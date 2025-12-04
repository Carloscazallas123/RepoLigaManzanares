package com.example.demo.modelos;

import java.util.ArrayList;
import java.util.List;

public class EquipoDTO {

	// -----------Información del equipo
	private String nombre;
	private String entrenador;
	private List<JugadorDTO> jugadores;
	// -----------Estadisticas del equipo
	private int victorias;
	private int derrotas;
	private int empates;
	private int golesfavor;
	private int golescontra;
	private int puntos;

	// ----->Constructor Principal
	public EquipoDTO(String nombre, String entrenador) {
		super();
		this.nombre = nombre;
		this.entrenador = entrenador;
		this.jugadores = new ArrayList<JugadorDTO>();
		this.victorias = 0;
		this.derrotas = 0;
		this.empates = 0;
		this.golesfavor = 0;
		this.golescontra = 0;
		this.puntos = 0;

	}

	// ----->Constructor Secundario
	public EquipoDTO() {

		this.jugadores = new ArrayList<JugadorDTO>();
		this.victorias = 0;
		this.derrotas = 0;
		this.empates = 0;
		this.golesfavor = 0;
		this.golescontra = 0;
		this.puntos = 0;
	}

	public int getGolesfavor() {
		return golesfavor;
	}

	public void setGolesfavor(int golesfavor) {
		this.golesfavor = golesfavor;
	}

	public int getGolescontra() {
		return golescontra;
	}

	public void setGolescontra(int golescontra) {
		this.golescontra = golescontra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}

	public ArrayList<JugadorDTO> getJugadores() {
		return (ArrayList<JugadorDTO>) jugadores;
	}

	public void setJugadores(ArrayList<JugadorDTO> jugadores) {
		this.jugadores = jugadores;
	}

	public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
