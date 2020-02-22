package mario.empleados.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import mario.empleados.daos.EmpDAO;
import mario.empleados.daos.EmpDAOHibernate;
import mario.empleados.daos.EmpDAOJdbc;
import mario.empleados.model.Empleado;
import mario.empleados.negocio.EmpNegocio;
import mario.empleados.negocio.EmpNegocioImpl;
import mario.empleados.ui.Gestor;

@Configuration
@EnableTransactionManagement
public class EmpConfig {
	
	@Bean
	public Gestor miGestor() {
		return new Gestor();
	}
	
	@Bean
	public EmpNegocio miNegocio() {
		return new EmpNegocioImpl(dao());
	}
	
	@Bean
	public EmpNegocio miNegocio2() {
		return new EmpNegocioImpl(dao());
	}
	
//	@Bean
////	@Scope("prototype")
//	public EmpDAO miDao() {
//		return new EmpDAOJdbc();
//	}
	
	@Bean
	public EmpDAO dao() {
		return new EmpDAOHibernate();
	}
	
	@Bean
	public Map<String, Empleado> mpEmpleados() {
		Map<String, Empleado> mpEmpleados = new HashMap<String, Empleado>();

		return mpEmpleados;
	}
	
	@Bean
	public DataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/empleados_simple?serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("Bolsa2010");
		
		return ds;
	}
	
//	@Bean
//	@Profile("Jdbc")
//	public DataSourceTransactionManager txManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}
	
	@Bean
//	@Profile("Hb")
	public HibernateTransactionManager txHibManager(SessionFactory sessionFactory) {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory);
		return htm;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"mario.empleados.model"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
	}
	
	private Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
				setProperty("hibernate.show_sql", "true");
			}
		};
	}
}
