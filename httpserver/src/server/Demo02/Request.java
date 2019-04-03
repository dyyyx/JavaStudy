package server.Demo02;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Request {
	//����ʽ
	private String method;
	//������Դ
	private String url;
	//�������
	private Map<String, List<String>> parmeterMapValues;
	
	//�ڲ�
	public static final String CRLF="\r\n";
	private InputStream is;
	private String requestInfo;
	
	public Request() {
		method = "";
		url = "";
		parmeterMapValues = new HashMap<String, List<String>>();
		requestInfo = "";
		
	}
	public Request(InputStream is) {
		this();
		this.is = is;
		try {
			byte[] data = new byte[20480];
			int len = is.read(data);
			requestInfo = new String(data, 0, len);
		} catch (Exception e) {
			return ;
		}
		//����ͷ��Ϣ
		parseRequestInfo();
	}
	/**
	 * ����������Ϣ
	 */
	private void parseRequestInfo() {
		if(null == requestInfo || (requestInfo=requestInfo.trim()).equals("")){
			return ;
		}
		/**
		 * =============================
		 * ����Ϣ�����зֽ��������ʽ  ����·��  �������(get���ܴ���)
		 * 
		 * ���Ϊpost��ʽ������������������������
		 * 
		 * =============================
		 */
		String paramString = ""; //�����������
		
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		//��ȡ����ʽ
		int idx = requestInfo.indexOf("/");
		this.method = firstLine.substring(0, idx).trim();
		String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
		if(this.method.equalsIgnoreCase("post")) {
			this.url = urlStr;
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();	
		}else if(this.method.equalsIgnoreCase("get")) {
			if(urlStr.contains("?")) { //�Ƿ���ڲ���
				String[] urlArray = url.split("\\?");
				this.url = urlArray[0];
				paramString = urlArray[1]; //�����������
			}else {
				this.url = urlStr;
			}
		}
		
		//�������������
		if(paramString.equals("")) {
			return;
		}
		//���������װ��Map��
		paramParams(paramString);
	}
	private void paramParams(String paramString) {
		//�ָ� ���ַ���ת������
		StringTokenizer token = new StringTokenizer(paramString, "&");
		while(token.hasMoreTokens()) {
			String keyValue = token.nextToken();
			String[] keyValues = keyValue.split("=");
			if(keyValues.length == 1) {
				keyValues = Arrays.copyOf(keyValues, 2);
				keyValues[1] = null;
			}
			String key = keyValues[0].trim();
			String value = null == keyValues[1]?null:decode(keyValues[1].trim(), "gbk");
			//ת����Map �ּ�
			if(!parmeterMapValues.containsKey(key)) {
				parmeterMapValues.put(key, new ArrayList<String>());
				
			}
			List<String> values = parmeterMapValues.get(key);
			values.add(value);
		}
	}
	/**
	 * ���Ľ�������
	 */
	private String decode(String value, String code) {
		try {
			return java.net.URLDecoder.decode(value, code);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * ����ҳ���name ��ȡ��Ӧ�Ķ��ֵ
	 * 
	 */
	public String[] getParameterValues(String name) {
		List<String> values = parmeterMapValues.get(name);
		if(null == values) {
			return null;
		}else {
			return values.toArray(new String[0]);
		}
	}
	/**
	 * ����ҳ���name ��ȡ��Ӧ�ĵ���ֵ
	 * 
	 */
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(null == values) {
			return null;
		}
		return values[0];
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
