package com.example.demo.servicios.implementaciones;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelos.EquipoDTO;
import com.example.demo.modelos.PartidoDTO;
import com.example.demo.modelos.JugadorDTO;
import com.example.demo.servicios.ServicioPartido;

@Service
public class ImplementacionPartido implements ServicioPartido {

	@Override
	public void guardarpartido(List<PartidoDTO> listapartidos, PartidoDTO partido) {
		boolean comprobarequipos = comprobarequipos(partido, listapartidos);
		if (comprobarequipos == false) {
			listapartidos.add(partido);
		} else {
			System.out.println("Error, vuelve a intentarlo");
		}
	}

	// -----------------Metodo para comprobar que los dos equipos no sean los mismos
	public static boolean comprobarequipos(PartidoDTO partido, List<PartidoDTO> listapartidos) {
		String equipo1 = partido.getEquipo1();
		String equipo2 = partido.getEquipo2();
		boolean repetidos = false;

		if (equipo1.equals(equipo2)) {
			System.out.println("Equipos repetidos");
			repetidos = true;
		} else {
			repetidos = false;
		}
		return repetidos;
	}

	@Override
	public PartidoDTO obtenerpartido(List<PartidoDTO> listapartidos, int jornada, String fecha) {
		PartidoDTO partido = null;
		boolean existe = false;
		for (int i = 0; i < listapartidos.size(); i++) {
			if (listapartidos.get(i).getJornada() == jornada && listapartidos.get(i).getFecha().equals(fecha)) {
				existe = true;
				partido = listapartidos.get(i);
			}

		}

		if (existe == false) {
			System.out.println("Partido Inexistente");
			partido = null;
		}

		return partido;
	}

	@Override
	public void metergol(PartidoDTO partido, JugadorDTO jugador, List<EquipoDTO> listaequipos) {
		EquipoDTO equipo1 = null;
		EquipoDTO equipo2 = null;

		// For para obtener los equipos
		for (int i = 0; i < listaequipos.size(); i++) {
			if (listaequipos.get(i).getNombre().equals(partido.getEquipo1())) {
				equipo1 = listaequipos.get(i);
			} else if (listaequipos.get(i).getNombre().equals(partido.getEquipo2())) {
				equipo2 = listaequipos.get(i);
			}
		}
		if (jugador.getEquipo().equals(equipo1.getNombre())) {
			// Añadiendo el Gol a la estadistica del jugador
			jugador.setGoles(jugador.getGoles() + 1);
			// Añadiendo el Gol al equipo visitante (equipo2) del partido
			partido.setGolesL(partido.getGolesV() + 1);
			// Añadiendo el Gol a las estadisticas de los equipo
			equipo1.setGolesfavor(equipo2.getGolesfavor() + 1);
			equipo2.setGolescontra(equipo1.getGolescontra() + 1);

		} else if (jugador.getEquipo().equals(equipo2.getNombre())) {
			// Añadiendo el Gol a la estadistica del jugador
			jugador.setGoles(jugador.getGoles() + 1);
			// Añadiendo el Gol al equipo visitante (equipo2) del partido
			partido.setGolesV(partido.getGolesV() + 1);
			// Añadiendo el Gol a las estadisticas de los equipo
			equipo2.setGolesfavor(equipo2.getGolesfavor() + 1);
			equipo1.setGolescontra(equipo1.getGolescontra() + 1);
		} else {
			System.out.println("Error");
		}

	}

	@Override
	public void sacartarjeta(PartidoDTO partido, JugadorDTO jugador, String tarjeta) {

		if (tarjeta.equals("Amarilla")) {
			jugador.setAmarillas(jugador.getAmarillas() + 1);
			partido.setAmarillas(partido.getAmarillas() + 1);
		} else {
			jugador.setRojas(jugador.getRojas() + 1);
			partido.setRojas(partido.getRojas() + 1);
		}

	}

	@Override
	public void terminarpartido(PartidoDTO partido, List<EquipoDTO> listaequipos) {
		EquipoDTO equipo1 = null;
		EquipoDTO equipo2 = null;

		// For para obtener los equipos
		for (int i = 0; i < listaequipos.size(); i++) {
			if (listaequipos.get(i).getNombre().equals(partido.getEquipo1())) {
				equipo1 = listaequipos.get(i);
			} else if (listaequipos.get(i).getNombre().equals(partido.getEquipo2())) {
				equipo2 = listaequipos.get(i);
			}
		}

		if (partido.getGolesL() > partido.getGolesV()) {
			equipo1.setPuntos(equipo1.getPuntos() + 3);
			equipo1.setVictorias(equipo1.getVictorias() + 1);
			equipo2.setDerrotas(equipo2.getDerrotas() + 1);
		} else if (partido.getGolesL() < partido.getGolesV()) {
			equipo2.setPuntos(equipo2.getPuntos() + 3);
			equipo2.setVictorias(equipo2.getVictorias() + 1);
			equipo1.setDerrotas(equipo1.getDerrotas() + 1);
		} else {
			equipo1.setPuntos(equipo1.getPuntos() + 1);
			equipo2.setPuntos(equipo2.getPuntos() + 1);
		}

		partido.setEstado("Terminado");
	}

}
