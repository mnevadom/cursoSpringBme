package mario.restaurantes;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Restaurante {

	@Autowired
	private Cocinero cocinero;
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		
		Restaurante rest = (Restaurante) context.getBean("restaurante");
		
//		Restaurante rest2 = (Restaurante) context.getBean("restaurante");
		
		System.out.println("Contenedor inicializado");
		context.registerShutdownHook();
		rest.go();
//		rest2.go();
		System.out.println("Fin app");
	}

	private void go() {
		System.out.println("Hoy desayunamos "+cocinero.getDesayuno());
	}

}
