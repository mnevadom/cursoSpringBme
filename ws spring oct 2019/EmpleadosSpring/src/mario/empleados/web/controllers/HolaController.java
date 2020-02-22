package mario.empleados.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hola")
public class HolaController {
	
	@GetMapping
	public String saludo(Model model) {
		model.addAttribute("mensaje", "Mensaje que me paso el controlador");
		return "hello";
	}
}
