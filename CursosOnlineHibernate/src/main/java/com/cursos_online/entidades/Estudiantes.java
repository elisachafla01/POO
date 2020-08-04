package com.cursos_online.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Estudiantes {
	
	@GeneratedValue
	@Id
	private int id;
	private String nombre;
	private String apellido;
	
	public Estudiantes(int id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Estudiantes() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

}
