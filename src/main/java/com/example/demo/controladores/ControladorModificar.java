package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.EquipoDTO;
import com.example.demo.modelos.JugadorDTO;
import com.example.demo.servicios.ServicioEquipo;
import com.example.demo.servicios.ServicioJugador;

@RequestMapping("/Modificar")
@Controller
public class ControladorModificar {

	@Autowired
	ServicioEquipo servicioequipo;
	@Autowired
	ServicioJugador serviciojugador;

	// --------->Pagina para el menu de modificar
	@GetMapping("/MenuModificar")
	public String menumodificar() {
		return "Modificar/MenuModificar";
	}

	// ------------------------------------------------------------INTEGRAR JUGADOR
	// --------->Pagina para indicar el jugador que desea añadir (Y el equipo)
	@GetMapping("/IndicarIngreso")
	public String indicaringreso() {
		return "Modificar/IndicarIngreso";
	}

	// --------->Metodo para integrar el jugador
	@GetMapping("/Integrarjugador")
	public String integrarjugador(@RequestParam String nombrejugador, @RequestParam String nombreequipo) {
		boolean existe = servicioequipo.comprobarequipo(ControladorEquipo.ListaEquipos, nombreequipo);

		if (existe == false) {
			System.out.println("Equipo inexistente");
			return "redirect:/";

		} else if (existe == true) {
			JugadorDTO jugadorencontrado = serviciojugador.obtenerjugador(ControladorJugador.listajugadores,
					nombrejugador);
			EquipoDTO equipo = servicioequipo.obtenerequipo(ControladorEquipo.ListaEquipos, nombreequipo);
			equipo.getJugadores().add(jugadorencontrado);
			jugadorencontrado.setEquipo(nombreequipo);

		}

		return "redirect:/";
	}

	// ------------------------------------------------------------ELIMINAR JUGADOR
	// --------->Pagina para indicar que jugador eliminar (Y el equipo)
	@GetMapping("/IndicarEliminar")
	public String indicareliminar() {
		return "Modificar/IndicarEliminar";
	}

	// --------->Metodo para eliminar al jugador
	@GetMapping("/EliminarJugador")
	public String eliminarjugador(@RequestParam String nombrejugador, @RequestParam String nombreequipo) {
		boolean existe = servicioequipo.comprobarequipo(ControladorEquipo.ListaEquipos, nombreequipo);

		if (existe == false) {
			System.out.println("Equipo inexistente");
			return "redirect:/";

		} else if (existe == true) {
			JugadorDTO jugadorencontrado = serviciojugador.obtenerjugador(ControladorJugador.listajugadores,
					nombrejugador);
			EquipoDTO equipo = servicioequipo.obtenerequipo(ControladorEquipo.ListaEquipos, nombreequipo);
			serviciojugador.eliminarjugador(jugadorencontrado, equipo);

		}

		return "redirect:/";
	}

	// ------------------------------------------------------------CAMBIAR
	// ENTRENADOR
	// --------->Pagina para indicar el nombre del entrenador (Y el equipo)
	@GetMapping("/IndicarEtrenador")
	public String indicarentrenador() {
		return "Modificar/IndicarEntrenador";
	}

	// --------->Metodo para obtener el equipo del entrenador
	@GetMapping("/ObtenerEntrenador")
	public String cambiarentrenador(@RequestParam String nombreequipo, Model modelo) {
		boolean existe = servicioequipo.comprobarequipo(ControladorEquipo.ListaEquipos, nombreequipo);
		EquipoDTO equipo;
		if (existe == false) {
			System.out.println("Equipo Inexistente");
			return "redirect:/";
		} else {
			equipo = servicioequipo.obtenerequipo(ControladorEquipo.ListaEquipos, nombreequipo);
			modelo.addAttribute("EquipoSacado", equipo);
		}
		return "Modificar/ModificarEntrenador";
	}

	// --------->Metodo para modificar el entrenador
	@PostMapping("/ModificarEntrenador")
	public String cambiarentrenador(@RequestParam String nombreentrenador, @RequestParam String nombreequipo) {
		servicioequipo.modificarentrenador(ControladorEquipo.ListaEquipos, nombreequipo, nombreentrenador);
		return "redirect:/";
	}

}
