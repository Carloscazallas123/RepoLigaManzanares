package com.example.demo.servicios.implementaciones;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelos.EquipoDTO;
import com.example.demo.modelos.JugadorDTO;
import com.example.demo.servicios.ServicioJugador;

@Service
public class ImplementacionJugador implements ServicioJugador {

	@Override
	public void guardarjugador(JugadorDTO jugador, List<EquipoDTO> Listaequipos, List<JugadorDTO> Listajugadores) {
		boolean equipoencontrado = false;
		String equipo = jugador.getEquipo();
		if (jugador.getEdad() < 16) {
			System.out.println("Menor de edad");
		} else {

			/*
			 * For que sirve para recorrer el ArrayList de equipos Si el equipo del jugador
			 * coincide
			 */
			for (int i = 0; i < Listaequipos.size(); i++) {

				if (Listaequipos.get(i).getNombre().equals(equipo)) {
					Listaequipos.get(i).getJugadores().add(jugador);
					equipoencontrado = true;
				}
			}
			/*
			 * If para que en caso de que no encuentre equipo, se le asigne de
			 * "Agente Libre"
			 */
			if (equipoencontrado == false) {
				jugador.setEquipo("AgenteLibre");
				Listajugadores.add(jugador);
			} else {
				Listajugadores.add(jugador);
			}
		}
	}

	@Override
	public JugadorDTO obtenerjugador(List<JugadorDTO> listajugadores, String nombrejugador) {
		JugadorDTO jugadorencontrado = null;

		for (int i = 0; i < listajugadores.size(); i++) {
			if (listajugadores.get(i).getNombre().equals(nombrejugador)) {
				jugadorencontrado = listajugadores.get(i);
			}
		}
		return jugadorencontrado;
	}

	@Override
	public void eliminarjugador(JugadorDTO jugador, EquipoDTO equipo) {
		for (int i = 0; i < equipo.getJugadores().size(); i++) {
			if (equipo.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
				equipo.getJugadores().remove(i);
				jugador.setEquipo("Agente Libre");
			}
		}

	}

	@Override
	public void obtenermejores(List<JugadorDTO> listagoleadores, List<JugadorDTO> listajugadores) {
		int goles = 0;

		for (int i = 0; i < listajugadores.size(); i++) {
			if (listagoleadores.size() < 3) {
				if (listajugadores.get(i).getGoles() > goles) {
					goles = listajugadores.get(i).getGoles();
					listagoleadores.add(listajugadores.get(i));
				}
			}
		}

	}

}
