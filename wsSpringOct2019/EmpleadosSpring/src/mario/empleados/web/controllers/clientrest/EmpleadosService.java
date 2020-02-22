package mario.empleados.web.controllers.clientrest;

import org.springframework.stereotype.Service;

import mario.empleados.model.Empleado;

@Service
public interface EmpleadosService {

	
	public Empleado[] getAllEmpleados();

	public Empleado getEmpleado(String cif) ;

	public void eliminaEmpleado(String cif) ;

	public void insertaEmpleado(Empleado emp) ;

	public void modificaEmpleado(Empleado emp) ;

}
