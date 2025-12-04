package com.example.demo.controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelos.JugadorDTO;
import com.example.demo.servicios.ServicioJugador;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Jugadores")
public class ControladorJugador {

	public static List<JugadorDTO> listajugadores = new ArrayList<JugadorDTO>();
	@Autowired
	ServicioJugador serviciojugador;

	// -----------> Pagina para Mostrar los jugadores por Posicion
	@GetMapping("/MostrarJugadores")
	public String mostrarjugadores(Model modelo) {
		Collections.sort(listajugadores,
				(Jugador1, Jugador2) -> Jugador1.getPosicion().compareTo(Jugador2.getPosicion()));
		modelo.addAttribute("ListadeJugadores", listajugadores);
		return "Jugadores/MostrarJugadores";

	}

	// -----------> Pagina para crear el Jugador
	@GetMapping("/CrearJugador")
	public String crearJugador(Model modelo) {
		modelo.addAttribute("JugadorDTO", new JugadorDTO());
		return "Jugadores/CrearJugador";
	}

	@PostMapping("/GuardarJugador")
	public String guardarjugador(@ModelAttribute JugadorDTO jugador, Model modelo) {

		serviciojugador.guardarjugador(jugador, ControladorEquipo.ListaEquipos, listajugadores);
		return "redirect:/";
	}
	
	//----------------->Pagina para Buscar al jugador
	@GetMapping("/MostrarGoleadores")
	public String mostrargoleadores(Model modelo) {
		return "Jugadores/MostrarJugadores";

	}

}
