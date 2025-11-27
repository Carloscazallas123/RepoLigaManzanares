package com.example.demo.servicios.implementaciones;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.modelos.EquipoDTO;
import com.example.demo.servicios.ServicioEquipo;

@Service
public class ImplementacionEquipo implements ServicioEquipo {

	@Override
	public void guardarequipo(EquipoDTO equipo, ArrayList<EquipoDTO> listaequipos) {
		boolean existe = false;

		for (int i = 0; i < listaequipos.size(); i++) {
			if (listaequipos.get(i).getNombre().equals(equipo.getNombre())) {
				existe = true;
			} else if (listaequipos.get(i).getEntrenador().equals(equipo.getEntrenador())) {
				existe = true;
			}
		}

		if (existe == true) {
			System.out.println("Equipo o Entrenador ya exsitente");
		} else {
			listaequipos.add(equipo);

		}

	}

	@Override
	public boolean comprobarequipo(ArrayList<EquipoDTO> listaequipos, String nombreequipo) {
		boolean existe = false;
		for (int i = 0; i < listaequipos.size(); i++) {
			if (listaequipos.get(i).getNombre().equals(nombreequipo)) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public EquipoDTO obtenerequipo(ArrayList<EquipoDTO> listaequipos, String nombreequipo) {
		EquipoDTO equiposacado = null;

		for (int i = 0; i < listaequipos.size(); i++) {
			if (listaequipos.get(i).getNombre().equals(nombreequipo)) {
				equiposacado = listaequipos.get(i);
			}
		}

		return equiposacado;
	}

	@Override
	public void modificarentrenador(ArrayList<EquipoDTO> listaequipos, String nombreequipo, String nombreentrenador) {

		for (int i = 0; i < listaequipos.size(); i++) {

			if (listaequipos.get(i).getNombre().equals(nombreequipo)) {
				listaequipos.get(i).setEntrenador(nombreentrenador);
			}
		}

	}

}
