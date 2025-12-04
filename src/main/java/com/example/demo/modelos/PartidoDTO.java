package com.example.demo.modelos;

public class PartidoDTO {

	private int jornada;
	private String fecha;
	private String lugar;
	private String equipo1; // Equipo Local
	private String equipo2; // Equipo Visitante
	private String estado;
	// -------------------------------
	private int golesL;
	private int golesV;

	public PartidoDTO(int id, int jornada, String fecha, String lugar, String equipo1, String equipo2, int golesL,
			int golesV, int amarillas, int rojas) {
		this.jornada = jornada;
		this.fecha = fecha;
		this.lugar = lugar;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.estado = "Pendiente de Jugar";
		this.golesL = 0;
		this.golesV = 0;
	}

	public PartidoDTO() {

		this.estado = "Pendiente de Jugar";
		this.golesL = 0;
		this.golesV = 0;

	}

	public int getGolesL() {
		return golesL;
	}

	public void setGolesL(int golesL) {
		this.golesL = golesL;
	}

	public int getGolesV() {
		return golesV;
	}

	public void setGolesV(int golesV) {
		this.golesV = golesV;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getEquipo1() {
		return equipo1;
	}

	public void EquipoDTO(String equipo1) {
		this.equipo1 = equipo1;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
