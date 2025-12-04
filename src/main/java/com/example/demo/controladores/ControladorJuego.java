package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.EquipoDTO;
import com.example.demo.modelos.JugadorDTO;
import com.example.demo.modelos.PartidoDTO;
import com.example.demo.servicios.ServicioEquipo;
import com.example.demo.servicios.ServicioJugador;
import com.example.demo.servicios.ServicioPartido;

@Controller
@RequestMapping("/Juego")
public class ControladorJuego {

	@Autowired
	ServicioPartido serviciopartido;
	ServicioEquipo servicioequipo;
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
	public String Metergol(@RequestParam int jornada,@RequestParam String fecha, @RequestParam String nombrejugador) {
		PartidoDTO partido=serviciopartido.obtenerpartido(ControladorPartido.listapartidos, jornada, fecha);
		JugadorDTO jugador=serviciojugador.obtenerjugador(ControladorJugador.listajugadores, nombrejugador);
		serviciopartido.metergol(partido, jugador, ControladorEquipo.ListaEquipos);
		
		return "JugarPartidos/JugarPartido";
		}
	

	
}
