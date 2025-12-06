package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.JugadorDTO;
import com.example.demo.modelos.PartidoDTO;
import com.example.demo.servicios.ServicioEquipo;
import com.example.demo.servicios.ServicioJugador;
import com.example.demo.servicios.ServicioPartido;

@Controller
@RequestMapping("/JugarPartidos")
public class ControladorJuego {

	@Autowired
	ServicioPartido serviciopartido;
	@Autowired
	ServicioEquipo servicioequipo;
	@Autowired
	ServicioJugador serviciojugador;

	// ----->Menu para Jugar el Partido
	@GetMapping("/JugarPartido")
	public String jugarpartido() {
		return "JugarPartidos/JugarPartido";
	}

	// ----->Pagina para indicar el Gol
	@GetMapping("/IndicarGol")
	public String indicargol() {
		return "JugarPartidos/IndicarGol";
	}

	// ----->Metodo para marcar el Gol
	@GetMapping("/MeterGol")
	public String metergol(@RequestParam int jornada, @RequestParam String fecha, @RequestParam String nombrejugador, @RequestParam String nombrejugador2) {
		PartidoDTO partido = serviciopartido.obtenerpartido(ControladorPartido.listapartidos, jornada, fecha);
		//El Jugador1 es el marca el Gol y el Jugador 2 el que hace la asistencia
		JugadorDTO jugador = serviciojugador.obtenerjugador(ControladorJugador.listajugadores, nombrejugador);
		JugadorDTO jugador2 = serviciojugador.obtenerjugador(ControladorJugador.listajugadores, nombrejugador2);
		serviciopartido.metergol(partido, jugador, jugador2, ControladorEquipo.ListaEquipos);

		return "JugarPartidos/JugarPartido";
	}

	// ----->Pagina para indicar la tarjeta amarilla
	@GetMapping("/IndicarTarjeta")
	public String indicartarjeta() {
		return "JugarPartidos/IndicarTarjeta";
	}

	// ----->Metodo para sacar la Amarila/Roja
	@GetMapping("/SacarTarjeta")
	public String sacartarjeta(@RequestParam int jornada, @RequestParam String fecha,
			@RequestParam String nombrejugador, @RequestParam String tarjeta) {
		PartidoDTO partido = serviciopartido.obtenerpartido(ControladorPartido.listapartidos, jornada, fecha);
		JugadorDTO jugador = serviciojugador.obtenerjugador(ControladorJugador.listajugadores, nombrejugador);
		serviciopartido.sacartarjeta(partido, jugador, tarjeta);
		return "JugarPartidos/JugarPartido";
	}

	// ----->Pagina para indicar la tarjeta amarilla
	@GetMapping("/IndicarTerminar")
	public String indicarterminar() {
		return "JugarPartidos/IndicarTerminar";
	}

	// ----->Metodo para terminar el partido
	@GetMapping("/TerminarPartido")
	public String terminarpartido(@RequestParam int jornada, @RequestParam String fecha) {
		PartidoDTO partido = serviciopartido.obtenerpartido(ControladorPartido.listapartidos, jornada, fecha);
		serviciopartido.terminarpartido(partido, ControladorEquipo.ListaEquipos);

		return "redirect:/";
	}

}
