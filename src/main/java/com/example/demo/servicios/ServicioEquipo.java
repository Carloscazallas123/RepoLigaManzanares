package com.example.demo.servicios;

import java.util.ArrayList;

import com.example.demo.modelos.EquipoDTO;


public interface ServicioEquipo {

	void guardarequipo(EquipoDTO equipo,ArrayList<EquipoDTO>listaequipos);
	void eliminarequipo(ArrayList<EquipoDTO>listaequipos,String nombreequipo);
	boolean comprobarequipo(ArrayList<EquipoDTO>listaequipos,String nombreequipo);
	EquipoDTO obtenerequipo (ArrayList<EquipoDTO>listaequipos,String nombreequipo);
	void modificarentrenador(ArrayList<EquipoDTO> listaequipos, String nombreequipo, String nombreentrenador);
	
}
