package profe.empleados.empleadosweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import profe.empleados.model.Empleado;

@Service
public class EmpleadosServiceStatic implements EmpleadosService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${app.empleadosServiceUrl}")
	private String serviceUrl;
	
	@Override
	public Empleado[] getAllEmpleados() {
		return restTemplate.getForObject(this.serviceUrl, Empleado[].class);
	}

	@Override
	public Empleado getEmpleado(String cif) {
		return restTemplate.getForObject(this.serviceUrl + cif, Empleado.class);
	}

	@Override
	public void eliminaEmpleado(String cif) {
		restTemplate.delete(this.serviceUrl + cif);
	}

	@Override
	public void insertaEmpleado(Empleado emp) {
		restTemplate.postForLocation(this.serviceUrl, emp);
	}

	@Override
	public void modificaEmpleado(Empleado emp) {
		restTemplate.put(this.serviceUrl + emp.getCif(), emp);
	}

}
