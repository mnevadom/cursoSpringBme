package mario.empleados.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import mario.empleados.model.Empleado;

public class EmpDAOHibernate implements EmpDAO {

	@Autowired
	private SessionFactory sf;
	
	private Session getSession() {
		return sf.getCurrentSession();
	}
	
	@Override
	public Empleado getEmpleado(String cif) {
		return (Empleado) getSession().get(Empleado.class, cif);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> getAllEmpleados() {
		return getSession().createQuery("from Empleado").list();
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		Empleado empDel = getEmpleado(cif);
		getSession().delete(empDel);
		return true;
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {
		getSession().persist(emp);
		return true;
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		getSession().update(emp);
		return true;
	}
	
	
	
}
