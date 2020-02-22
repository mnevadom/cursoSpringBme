package mario.empleados.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mario.empleados.model.Empleado;
import mario.empleados.negocio.EmpNegocio;

@RestController
@RequestMapping("/empleados")
public class EmpleadosRestController {
	
	@Resource
	private EmpNegocio miNegocio;
	
	@GetMapping
	public List<Empleado> getAll(){
		return miNegocio.getAllEmpleados();
	}
	
	@GetMapping(params="/{cif}")
	public Empleado getOne(@PathVariable String cif) {
		return miNegocio.getEmpleado(cif);
	}
}
