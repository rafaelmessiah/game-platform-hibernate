package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Jogo;
import model.Plataforma;




public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Configura��o Hibernate equivalente a hibernate.cfg.xml
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				//settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				//settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_exemplo?useTimezone=true&serverTimezone=UTC");
				settings.put(Environment.URL, "jdbc:mysql://localhost/jogo_plataforma?createDatabaseIfNotExist=true&useSSL=false&user=root&password=");
				//"jdbc:mysql://"+Server+"/"+dbName + "?useSSL=false&user="+userName+"&password="+pws);
				//1useSSL=false
				//settings.put(Environment.USER, "root");4
				//settings.put(Environment.PASS, "12345678");
				//settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Jogo.class);
				configuration.addAnnotatedClass(Plataforma.class);
				
			    

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}

 