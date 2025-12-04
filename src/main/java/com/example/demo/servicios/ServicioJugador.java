package com.example.demo.servicios;

import java.util.List;

import com.example.demo.modelos.EquipoDTO;
import com.example.demo.modelos.JugadorDTO;

public interface ServicioJugador {
	JugadorDTO obtenerjugador(List<JugadorDTO> listajugadores,String nombrejugador);
	void eliminarjugador(JugadorDTO jugador,EquipoDTO equipo);
	void guardarjugador(JugadorDTO jugador, List<EquipoDTO> Listaequipos, List<JugadorDTO> Listajugadores);
}
