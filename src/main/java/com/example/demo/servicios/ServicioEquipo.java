package com.example.demo.servicios;

import java.util.ArrayList;

import com.example.demo.modelos.EquipoDTO;


public interface ServicioEquipo {

	void guardarequipo(EquipoDTO equipo,ArrayList<EquipoDTO>listaequipos);
	//Metodo tanto para comprobar el equipo introducido como para sacar el equipo
	// Itnroducido para realizar dichas modificaciones)
	boolean comprobarequipo(ArrayList<EquipoDTO>listaequipos,String nombreequipo);
	EquipoDTO obtenerequipo (ArrayList<EquipoDTO>listaequipos,String nombreequipo);
	void modificarentrenador(ArrayList<EquipoDTO> listaequipos, String nombreequipo, String nombreentrenador);
	
}
