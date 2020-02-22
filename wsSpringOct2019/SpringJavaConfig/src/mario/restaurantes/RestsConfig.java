package mario.restaurantes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Configuration
public class RestsConfig {
	
	@Bean
	public Restaurante restaurante() {
		return new Restaurante();
	}
	
	@Bean
	public Restaurante restaurante2() {
		return new Restaurante();
	}
	
	@Bean
	@Lazy
	@Primary
	public Cocinero miExt() {
		return new CociExt();
	}
	
	@Bean
	@Lazy
	public Cocinero miJapo() {
		return new CociJapo();
	}
}
