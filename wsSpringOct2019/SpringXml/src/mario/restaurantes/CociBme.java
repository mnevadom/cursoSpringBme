package mario.restaurantes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("bme")
@Lazy
public class CociBme implements Cocinero {

	@Override
	public String getDesayuno() {
		return "Bocata de tortilla con bacon y queso";
	}

}
