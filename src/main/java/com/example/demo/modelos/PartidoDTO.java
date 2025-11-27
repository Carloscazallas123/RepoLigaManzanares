package com.example.demo.modelos;

public class PartidoDTO {

	private int jornada;
	private String fecha;
	private String lugar;
	private EquipoDTO equipo1;
	private EquipoDTO equipo2;
	private String estado;
	private String resultado;

	public PartidoDTO(int jornada, String fecha, String lugar, EquipoDTO equipo1, EquipoDTO equipo2) {
		this.jornada = jornada;
		this.fecha = fecha;
		this.lugar = lugar;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.estado = "Pendiente de Jugar";
		this.resultado = "No Disponible";
	}

	public PartidoDTO() {

		this.estado = "Pendiente de Jugar";
		this.resultado = "No Disponible";
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

	public EquipoDTO getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(EquipoDTO equipo1) {
		this.equipo1 = equipo1;
	}

	public EquipoDTO getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(EquipoDTO equipo2) {
		this.equipo2 = equipo2;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
