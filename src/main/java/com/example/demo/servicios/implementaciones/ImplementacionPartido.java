package com.example.demo.servicios.implementaciones;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelos.PartidoDTO;
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
	public PartidoDTO obtenerpartido(List<PartidoDTO> listapartidos, int jornada, String equipo1, String equipo2) {
		PartidoDTO partido = null;
		boolean existe = false;
		for (int i = 0; i < listapartidos.size(); i++) {
			if (listapartidos.get(i).getJornada() == jornada && listapartidos.get(i).getEquipo1().equals(equipo1)
					&& listapartidos.get(i).getEquipo2().equals(equipo2)) {
				partido = listapartidos.get(i);
				existe = true;
			}

		}

		if (existe == false) {
			System.out.println("Partido Inexistente");
		}

		return partido;
	}
}
