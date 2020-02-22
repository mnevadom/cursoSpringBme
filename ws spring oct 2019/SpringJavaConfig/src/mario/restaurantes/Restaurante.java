package mario.restaurantes;

import org.springframework.beans.factory.annotation.Autowired;

public class Restaurante {

	@Autowired
	private Cocinero cocinero;
	
	public void go() {
		System.out.println("Hoy desayunamos "+cocinero.getDesayuno());
	}

}
