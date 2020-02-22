package mario.empleados.ui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mario.empleados.model.Empleado;
import mario.empleados.negocio.EmpNegocio;

public class Gestor {

	@Autowired
	private EmpNegocio miNegocio;
	
	@Autowired
	private EmpNegocio miNegocio2;
	
	public void go() {
		testElimina();
		
		try {
		// transacciones
			testInsertaEmpleados();
		} catch(Exception e) {
			e.printStackTrace();
		}
//		
		
		
		
		listaEmpleados(miNegocio.getAllEmpleados());
		testInserta();
		listaEmpleados(miNegocio.getAllEmpleados());
		testGetEmpleado();
		testModifica();
		listaEmpleados(miNegocio.getAllEmpleados());
		testElimina();
		listaEmpleados(miNegocio.getAllEmpleados());
		
	}
	
	public void testInserta() {
		miNegocio.insertaEmpleado(new Empleado("12", "Paca", "Contra", 92));
	}
	
	public void testModifica() {
		miNegocio.modificaEmpleado(new Empleado("12", "PacaMod", "ContraMod", 16));
	}
	
	public void testElimina() {
		for (Empleado emp : getListaEmpleados()) {
			try {
				miNegocio.eliminaEmpleado(emp.getCif());
			}catch (Exception e) {
				System.out.println("Empleado no existe " + emp.getCif());
			}
			
		}
		try {
			miNegocio.eliminaEmpleado("12");
		}catch (Exception e) {
			System.out.println("Empleado no existe 12");
		}
	}
	
	public void testGetEmpleado() {
		System.out.println("recojo empleado: " + miNegocio.getEmpleado("12"));
	}
	
	private List<Empleado> getListaEmpleados(){
		List<Empleado> emps = new ArrayList<Empleado>();
		emps.add(new Empleado("A", "A", "A", 1));
		emps.add(new Empleado("B", "B", "B", 2));
//		emps.add(new Empleado("A", "A", "A", 1));
		emps.add(new Empleado("C", "C", "C", 3));
		
		return emps;
	}
	
	public void testInsertaEmpleados() {
		getListaEmpleados().forEach(emp -> miNegocio.eliminaEmpleado(emp.getCif()));
		listaEmpleados(miNegocio.getAllEmpleados());
		miNegocio.insertaEmpleados(getListaEmpleados());
		listaEmpleados(miNegocio.getAllEmpleados());
	}
	
	public void listaEmpleados(List<Empleado> empleados) {
		System.out.println("\n Lista de empleados");
		System.out.println("===========");
		empleados.forEach(emp -> System.out.println(emp));
		System.out.println("===========\n");
	}
}
