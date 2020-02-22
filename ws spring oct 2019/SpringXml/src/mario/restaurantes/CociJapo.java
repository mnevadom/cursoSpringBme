package mario.restaurantes;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("japo")
@Lazy
@Primary
public class CociJapo implements Cocinero {

	@Override
	public String getDesayuno() {
		return "Atún teriyaki";
	}

}
