package mario.empleados.web.controllers;

import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mario.empleados.model.Empleado;
import mario.empleados.negocio.EmpNegocio;

@Controller
@RequestMapping("/gestEmpleados")
public class EmpleadosController {
	
	@Resource
	private EmpNegocio miNegocio;
	
	@GetMapping
	public String mostrarFormulario() {
		return "empleados";
	}
	
	@PostMapping(params = {"insertar"})
	public String insertaEmpleado(@ModelAttribute Empleado emp, Model model) {
		
		try {
			if (miNegocio.insertaEmpleado(emp))
				model.addAttribute("mensaje", "Empleado insertado");
			else
				model.addAttribute("mensaje", "Error insertando");
		}catch (Exception e) {
			model.addAttribute("mensaje", "Error insertando " +e.getMessage());
		}
		
		return "empleados";
	}
	
	@PostMapping(params = {"listar"})
	public String cargaempleados(Model model) {
		
		model.addAttribute("listaEmpleados", miNegocio.getAllEmpleados());
		return mostrarFormulario();
	}
	
	@PostMapping(params = {"modificar"})
	public String modificaEmpleado(@ModelAttribute Empleado emp, Model model) {
		
		try {
			if (miNegocio.modificaEmpleado(emp))
				model.addAttribute("mensaje", "Empleado modificado");
			else
				model.addAttribute("mensaje", "Error modificado");
		}catch (Exception e) {
			model.addAttribute("mensaje", "Error modificado "+e.getMessage());
		}
		
		return "empleados";
	}
	
	@PostMapping(params = {"eliminar"})
	public String eliminaEmpleado(@RequestParam String cif, Model model) {
		
		try {
			if (miNegocio.eliminaEmpleado(cif))
				model.addAttribute("mensaje", "Empleado eliminado");
			else
				model.addAttribute("mensaje", "Error eliminado");
		}catch (Exception e) {
			model.addAttribute("mensaje", "Error eliminado "+e.getMessage());
		}
		
		return "empleados";
	}

	@PostMapping(params = {"getOne"})
	public String cargaempleado (Model model, @RequestParam String cif) {
		model.addAttribute("listaEmpleados", Arrays.asList(miNegocio.getEmpleado(cif)));
		return "empleados";
	}
}
