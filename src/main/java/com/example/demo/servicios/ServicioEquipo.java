package com.example.demo.servicios;

import java.util.List;

import com.example.demo.modelos.EquipoDTO;


public interface ServicioEquipo {

	void guardarequipo(EquipoDTO equipo,List<EquipoDTO>listaequipos);
	void eliminarequipo(List<EquipoDTO>listaequipos,String nombreequipo);
	boolean comprobarequipo(List<EquipoDTO>listaequipos,String nombreequipo);
	EquipoDTO obtenerequipo (List<EquipoDTO>listaequipos,String nombreequipo);
	void modificarentrenador(List<EquipoDTO> listaequipos, String nombreequipo, String nombreentrenador);
	
}
