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
	//请求方式
	private String method;
	//请求资源
	private String url;
	//请求参数
	private Map<String, List<String>> parmeterMapValues;
	
	//内部
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
		//分析头信息
		parseRequestInfo();
	}
	/**
	 * 分析请求信息
	 */
	private void parseRequestInfo() {
		if(null == requestInfo || (requestInfo=requestInfo.trim()).equals("")){
			return ;
		}
		/**
		 * =============================
		 * 从信息的首行分解出：请求方式  请求路径  请求参数(get可能存在)
		 * 
		 * 如果为post方式，请求参数可能在最后正文中
		 * 
		 * =============================
		 */
		String paramString = ""; //接收请求参数
		
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		//获取请求方式
		int idx = requestInfo.indexOf("/");
		this.method = firstLine.substring(0, idx).trim();
		String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
		if(this.method.equalsIgnoreCase("post")) {
			this.url = urlStr;
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();	
		}else if(this.method.equalsIgnoreCase("get")) {
			if(urlStr.contains("?")) { //是否存在参数
				String[] urlArray = url.split("\\?");
				this.url = urlArray[0];
				paramString = urlArray[1]; //接收请求参数
			}else {
				this.url = urlStr;
			}
		}
		
		//不存在请求参数
		if(paramString.equals("")) {
			return;
		}
		//请求参数封装到Map中
		paramParams(paramString);
	}
	private void paramParams(String paramString) {
		//分割 将字符串转成数组
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
			//转换成Map 分拣
			if(!parmeterMapValues.containsKey(key)) {
				parmeterMapValues.put(key, new ArrayList<String>());
				
			}
			List<String> values = parmeterMapValues.get(key);
			values.add(value);
		}
	}
	/**
	 * 中文解码问题
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
	 * 根据页面的name 获取对应的多个值
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
	 * 根据页面的name 获取对应的单个值
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
