package mario.empleados.negocio;

import java.util.List;

import mario.empleados.model.Empleado;

public interface EmpNegocio {

	public Empleado getEmpleado(String cif);
	
	public List<Empleado> getAllEmpleados();
	
	public boolean eliminaEmpleado(String cif);
	
	public boolean insertaEmpleado(Empleado emp);
	
	public boolean modificaEmpleado(Empleado emp);
	
	public boolean insertaEmpleados(List<Empleado> emps);
}
