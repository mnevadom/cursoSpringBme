package mario.empleados.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import mario.empleados.config.EmpConfig;

public class MvcWebAI extends AbstractAnnotationConfigDispatcherServletInitializer {

	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { EmpConfig.class };
	}

    protected Class<?>[] getServletConfigClasses() {
		return new Class[] {EmpWebConfigurator.class };
    }

	protected String[] getServletMappings() {
		return new String[] {"*.do", "/rest/*"};
	}

}
