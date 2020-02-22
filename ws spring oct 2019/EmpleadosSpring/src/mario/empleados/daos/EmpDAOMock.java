package mario.empleados.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import mario.empleados.model.Empleado;

public class EmpDAOMock implements EmpDAO {

	@Autowired
	private Map<String, Empleado> mpEmpleados;
	
	@PostConstruct
	public void init() {
		mpEmpleados.put("1", new Empleado("1", "Mario", "Nevado", 36));
		mpEmpleados.put("2", new Empleado("2", "Alex", "Fité", 51));
		mpEmpleados.put("3", new Empleado("3", "Victor", "Gracia", 30));
		mpEmpleados.put("4", new Empleado("4", "David", "Sánchez", 38));
	}
	
	@Override
	public Empleado getEmpleado(String cif) {
		Empleado eReturn = null;
		try {
			 eReturn = (Empleado) mpEmpleados.get(cif).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eReturn;
	}

	@Override
	public List<Empleado> getAllEmpleados() {
		List<Empleado> lReturn = new ArrayList<Empleado>();
		for (Empleado emp : mpEmpleados.values()) {
			try {
				lReturn.add((Empleado) emp.clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lReturn;
	}

	public void setEmpleados(Map<String, Empleado> mpEmpleados) {
		this.mpEmpleados = mpEmpleados;
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		Empleado eAux = this.mpEmpleados.remove(cif);
		return (eAux != null);
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {
		if (this.existeEmpleado(emp.getCif())) {
			return false;
		} else {
			try {
				this.mpEmpleados.put(emp.getCif(), (Empleado) emp.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return true;
		}
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		if (!this.existeEmpleado(emp.getCif())) {
			return false;
		} else {
			try {
				this.mpEmpleados.put(emp.getCif(), (Empleado) emp.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return true;
		}
	}

	private boolean existeEmpleado(String cif) {
		return this.mpEmpleados.containsKey(cif);
	}
	
}
