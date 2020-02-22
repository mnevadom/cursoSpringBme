package mario.restaurantes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RestsConfig.class);
		
	    Restaurante rest = (Restaurante) ctx.getBean("restaurante2");
		
		System.out.println("Contenedor inicializado");
		ctx.registerShutdownHook();
		rest.go();
		System.out.println("Fin app");
	}

}
