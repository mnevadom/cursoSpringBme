package mario.restaurantes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("ext")
@Lazy
public class CociExt implements Cocinero {

	@Override
	public String getDesayuno() {
		return "Torrijas";
	}

}
