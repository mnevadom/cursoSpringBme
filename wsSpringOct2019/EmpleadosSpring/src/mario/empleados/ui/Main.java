package mario.empleados.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mario.empleados.config.EmpConfig;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EmpConfig.class);
		
		Gestor gestor = (Gestor) ctx.getBean("miGestor");
		
		System.out.println("Contenedor inicializado");
		ctx.registerShutdownHook();
		gestor.go();
		System.out.println("Fin app");

	}

}
