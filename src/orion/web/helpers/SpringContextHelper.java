package orion.web.helpers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringContextHelper {
	
	private static String pathToContext;
	
	static {
		pathToContext = System.getenv("CATALINA_HOME")+"/webapps/orion/WEB-INF/Orion-servlet.xml";
	}
	
	public static ApplicationContext getContext() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(pathToContext);
		return ctx;
	}
	
	public static Object getBean(String beanName) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(pathToContext);
		Object bean = ctx.getBean(beanName);
		return bean;
	}
}