package com.example.demo.modelos;

public class JugadorDTO {

	// -------Información del Jugador
	private String dni;
	private String nombre;
	private int edad;
	private String posicion;
	private String equipo;
	private int valor;
	// -------Estadisticas
	private int goles;
	private int asistencias;
	private int amarillas;
	private int rojas;

	// ----->Constructor Principal
	public JugadorDTO(String dni, String nombre, int edad, String posicion, String equipo, int valor) {

		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.posicion = posicion;
		this.equipo = equipo;
		this.valor = valor;
		this.goles = 0;
		this.asistencias = 0;
		this.amarillas = 0;
		this.rojas = 0;

	}

	// ----->Constructor Secundario
	public JugadorDTO() {

		this.goles = 0;
		this.asistencias = 0;
		this.amarillas = 0;
		this.rojas = 0;

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getAmarillas() {
		return amarillas;
	}

	public void setAmarillas(int amarillas) {
		this.amarillas = amarillas;
	}

	public int getRojas() {
		return rojas;
	}

	public void setRojas(int rojas) {
		this.rojas = rojas;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

}
