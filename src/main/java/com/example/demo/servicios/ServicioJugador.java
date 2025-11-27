package com.example.demo.servicios;

import java.util.ArrayList;

import com.example.demo.modelos.EquipoDTO;
import com.example.demo.modelos.JugadorDTO;

public interface ServicioJugador {

	void guardarjugador(JugadorDTO jugador, ArrayList<EquipoDTO> ListaEquipos, ArrayList<JugadorDTO> Listajugadores);
	JugadorDTO obtenerjugador(ArrayList<JugadorDTO>listajugadores,String nombrejugador);
	void eliminarjugador(JugadorDTO jugador,EquipoDTO equipo);
}
