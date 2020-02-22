package mario.empleados.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mario.empleados.daos.EmpDAO;
import mario.empleados.model.Empleado;

@Transactional
public class EmpNegocioImpl implements EmpNegocio{
	
	@Autowired
	private EmpDAO miDao;
	
	public EmpNegocioImpl(EmpDAO dao) {
		miDao = dao;
	}
	
	public Empleado getEmpleado(String cif) {
		return miDao.getEmpleado(cif);
	}

	public List<Empleado> getAllEmpleados() {
		return miDao.getAllEmpleados();
	}

	public boolean eliminaEmpleado(String cif) {
		return miDao.eliminaEmpleado(cif);
	}

	public boolean insertaEmpleado(Empleado emp) {
		return miDao.insertaEmpleado(emp);
	}

	public boolean modificaEmpleado(Empleado emp) {
		return miDao.modificaEmpleado(emp);
	}

	@Override
	public boolean insertaEmpleados(List<Empleado> emps) {
		emps.forEach(emp -> miDao.insertaEmpleado(emp));
		return true;
	}
	
	
}
