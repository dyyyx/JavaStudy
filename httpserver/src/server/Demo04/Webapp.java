package server.Demo04;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Webapp {
	private static ServletContext context;
	static {
		try {
			//��ȡ��������
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//��ȡ������
			SAXParser sax = factory.newSAXParser();
			//ָ��xml+������
			WebHandler web = new WebHandler();
			sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("server\\Demo04\\web.xml"), web);
			//��list ת��map
			context = new ServletContext();
			
			Map<String, String> servlet = context.getServlet();
			for(Entity entity:web.getEntityList()) {
				servlet.put(entity.getName(), entity.getClz());
			}
			Map<String, String> mapping = context.getMapping();
			for(Mapping mapp:web.getMappingList()) {
				List<String> urls = mapp.getUrlPattern();
				for(String url:urls) {
					mapping.put(url, mapp.getName());
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if((null == url) || (url=url.trim()).equals("")) {
			return null;
		}
		//��������·����������

		//return context.getServlet().get(context.getMapping().get(url));
		String name = context.getServlet().get(context.getMapping().get(url));
		return (Servlet)Class.forName(name).newInstance();
	}
}
