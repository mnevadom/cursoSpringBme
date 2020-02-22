package mario.empleados.daos;

import java.util.List;

import org.springframework.stereotype.Component;

import mario.empleados.model.Empleado;

public interface EmpDAO {
	
	public Empleado getEmpleado(String cif);
	
	public List<Empleado> getAllEmpleados();
	
	public boolean eliminaEmpleado(String cif);
	
	public boolean insertaEmpleado(Empleado emp);
	
	public boolean modificaEmpleado(Empleado emp);
	
}
