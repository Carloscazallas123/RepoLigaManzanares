package com.example.demo.servicios.implementaciones;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelos.EquipoDTO;
import com.example.demo.servicios.ServicioEquipo;

@Service
public class ImplementacionEquipo implements ServicioEquipo {

	@Override
	public void guardarequipo(EquipoDTO equipo, List<EquipoDTO> listaequipos) {
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
	public boolean comprobarequipo(List<EquipoDTO> listaequipos, String nombreequipo) {
		boolean existe = false;
		for (int i = 0; i < listaequipos.size(); i++) {
			if (listaequipos.get(i).getNombre().equals(nombreequipo)) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public EquipoDTO obtenerequipo(List<EquipoDTO> listaequipos, String nombreequipo) {
		EquipoDTO equiposacado = null;

		for (int i = 0; i < listaequipos.size(); i++) {
			if (listaequipos.get(i).getNombre().equals(nombreequipo)) {
				equiposacado = listaequipos.get(i);
			}
		}

		return equiposacado;
	}

	@Override
	public void modificarentrenador(List<EquipoDTO> listaequipos, String nombreequipo, String nombreentrenador) {

		for (int i = 0; i < listaequipos.size(); i++) {

			if (listaequipos.get(i).getNombre().equals(nombreequipo)) {
				listaequipos.get(i).setEntrenador(nombreentrenador);
			}
		}

	}

	@Override
	public void eliminarequipo(List<EquipoDTO> listaequipos, String nombreequipo) {
		for (int i = 0; i < listaequipos.size(); i++) {
			if (listaequipos.get(i).getNombre().equals(nombreequipo)) {
				listaequipos.remove(i);
			}
		}

	}

}
