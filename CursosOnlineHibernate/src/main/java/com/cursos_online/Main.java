package com.cursos_online;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.management.Query;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import com.cursos_online.entidades.Curso;
import com.cursos_online.entidades.Estudiantes;

public class Main {
	
	static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory= (SessionFactory) new MetadataSources(registry).buildMetadata();
	

	public static void main(String[] args) {
		Curso cur1 = new Curso("fundamentos d java");
		Curso cur2 = new Curso("hibernate para principiantes");
		
		ingresarCurso(cur1);
		ingresarCurso(cur2);
		
		Estudiantes estd1 = new Estudiantes(0,"cesar","alcivar");
		Estudiantes estd2 = new Estudiantes(0,"leonela","vera");
		
		ingresarEstudiante(estd1);
		ingresarEstudiante(estd2);
	}
	
	static List<Curso> getCursos(){
		Session session= sessionFactory.openSession();
		List<Curso> cursos= session.createQuery("from curso",Curso.class).list();
		return cursos;
		
	}
	static List<Estudiantes> getEstudiantes(){
		Session session= sessionFactory.openSession();
		List<Estudiantes> estudiantes= session.createQuery("from Estudiantes",Estudiantes.class).list();
		return estudiantes;
		
	}
	static void modificarCurso(Curso curso) {
		
		int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos actuales?");


		if(confirmar == JOptionPane.YES_OPTION){

		    Connection conexion = null;
		    
		    try {
		    
		        conexion = metodospool.dataSource.getConnection();
		        
		        String Ssql = "UPDATE contacto SET descripcion=? "
		                    + "WHERE id=?";
		        
		        PreparedStatement prest = conexion.prepareStatement(Ssql);
		        
		        prest.setString(1, id);
		        prest.setString(2, descripcion);
		       
		        
		        if(prest.executeUpdate() > 0){
		        
		            JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa", 
		                                          JOptionPane.INFORMATION_MESSAGE);
		        
		    }
		    }
		}
	}
		    
		
	}
	static void eliminarCurso(Curso curso) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM CURSO WHERE ID="+curso.getId();
		try {
			connect= Connection.conn();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: método eliminar");
			e.printStackTrace();
		}		
		return;
	}
		
	}
	
    static void modificarEstudiante(Estudiantes  estudiante) {
    	
    	int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos actuales?");


		if(confirmar == JOptionPane.YES_OPTION){

		    Connection conexion = null;
		    
		    try {
		    
		        conexion = metodospool.dataSource.getConnection();
		        
		        String Ssql = "UPDATE contacto SET nombre=?, apellido=?"
		                    + "WHERE id=?";
		        
		        PreparedStatement prest = conexion.prepareStatement(Ssql);
		        
		        prest.setString(1, id);
		        prest.setString(2, nombre);
		        prest.setString(3,apellido);
		       
		        
		        if(prest.executeUpdate() > 0){
		        
		            JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa", 
		                                          JOptionPane.INFORMATION_MESSAGE);
		        
		    }
		    }
		}
	}
		    
		
	}
	static void eliminarEstudiante(Estudiante estudiante) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM ESTUDIANTE WHERE ID="+estudiante.getId();
		try {
			connect= Connection.conn();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: método eliminar");
			e.printStackTrace();
		}		
		return;
	}
		
	}
	
	static List<Estudiantes> getEstudiantesPorNombre(String nombre){
		Session session= sessionFactory.openSession();
		Query query = session
				.createQuery("from Estudiante where nombre=:nombre");
		query.setParameter("nombre", nombre);
		List<Estudiantes> estudiantes=(List<Estudiantes>)query.getResultList();
		return estudiantes;
	}
	
	static void ingresarEstudiante(Estudiantes estudiante) {
		Session sessio= sessionFactory.openSession();
		sessio.beginTransaction();
		sessio.save(estudiante);
		
		sessio.getTransaction().commit();
		sessio.close();
	}
		
	static void ingresarCurso(Curso curso) {
		Session sessio= sessionFactory.openSession();
		sessio.beginTransaction();
		sessio.save(curso);
		
		sessio.getTransaction().commit();
		sessio.close();
		
		
		/*final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		
		SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Curso curso = new Curso("Nuevo Curso");
		session.save(curso);
		
		session.getTransaction().commit();
		*/
	}

}
