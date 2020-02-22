package mario.empleados.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mario.empleados.model.Empleado;

public class EmpDAOJdbc implements EmpDAO {
	
	
	private JdbcTemplate jdbcTemplate;
	
	private interface ConstantesSql{
		String GET_ALL_EMP = "select * from empleados";
		String GET_EMP = "select * from empleados where cif=?";
		String DELETE_EMP = "delete from empleados where cif=?";
		String UPDATE_EMP = "update empleados set nombre=?, apellidos=?, edad=? where cif=?";
		String INSERT_EMP = "insert into empleados VALUES (?,?,?,?)";
	}

	private RowMapper<Empleado> empMapper = (rs, numRow) -> {
		Empleado emp = new Empleado();
		emp.setCif(rs.getString("cif"));
		emp.setNombre(rs.getString("nombre"));
		emp.setApellidos(rs.getString("apellidos"));
		emp.setEdad(rs.getInt("edad"));
		
		return emp;
	};
	
	@Autowired
	public void setDataSource(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public Empleado getEmpleado(String cif) {
		try {
			return jdbcTemplate.queryForObject(ConstantesSql.GET_EMP, empMapper, cif);
		} catch(Exception e) {
			System.out.println("Empleado cif " + cif + "no encontrado");
			return null;
		}
		
	}

	@Override
	public List<Empleado> getAllEmpleados() {
		return jdbcTemplate.query(ConstantesSql.GET_ALL_EMP, empMapper);
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		return 1 == jdbcTemplate.update(ConstantesSql.DELETE_EMP, cif);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	// cuando se invoque, inicia siempre una nueva transación, haya una iniciada o no
	public boolean insertaEmpleado(Empleado emp) {
//		try {
			return 1 == jdbcTemplate.update(ConstantesSql.INSERT_EMP, emp.getCif(), emp.getNombre(), emp.getApellidos(), emp.getEdad());
//		} catch(Exception e) {
//			System.out.println("Error insertando empleado: " + e.getMessage());
//			return false;
//		}
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		return 1 == jdbcTemplate.update(ConstantesSql.UPDATE_EMP, emp.getNombre(), emp.getApellidos(), emp.getEdad(), emp.getCif());
	}

}
