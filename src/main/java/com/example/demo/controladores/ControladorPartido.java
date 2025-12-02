package com.example.demo.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.PartidoDTO;
import com.example.demo.servicios.ServicioPartido;

@Controller
@RequestMapping("/Partido")
public class ControladorPartido {

	@Autowired
	ServicioPartido serviciopartido;
	private List<PartidoDTO> listapartidos = new ArrayList<>();

	// ---------->Pagina para crear el Partido
	@GetMapping("/CrearPartido")
	public String crearpartido(Model modelo) {
		modelo.addAttribute("PartidoDTO", new PartidoDTO());
		return "Partidos/CrearPartido";
	}

	// ---------->Pagina para guardar el Partido
	@PostMapping("/GuardarPartido")
	public String guardarpartido(@ModelAttribute PartidoDTO partido) {
		serviciopartido.guardarpartido(listapartidos, partido);
		return "redirect:/";

	}

	// ---------->Pagina para mostrar la tabla de Partidos
	@GetMapping("/MostrarPartidos")
	public String mostrarpartidos(Model modelo) {
		modelo.addAttribute("ListaPartidos", listapartidos);
		return "Partidos/MostrarPartidos";

	}

	// ---------->Pagina para indicar el partido (El usuario introduce la jornada y
	// los equipos que se enfrentan)
	@GetMapping("/IndicarPartido")
	public String indicarpartido(Model modelo) {
		return "Partidos/IndicarPartido";
	}

	// ---------->Metodo para obtener el equipo
	@GetMapping("/ObtenerPartido")
	public String obtenerpartido(Model modelo, @RequestParam int jornada, @RequestParam String equipo1,
			@RequestParam String equipo2) {
		PartidoDTO partido = serviciopartido.obtenerpartido(listapartidos, jornada, equipo1, equipo2);

		modelo.addAttribute("Partido", partido);

		return "Partidos/JugarPartido";
	}
	
	// ---------->Metodo para obtener el equipo
		@GetMapping("/JugarPartido")
		public String jugarpartido(Model modelo, @RequestParam int jornada, @RequestParam String equipo1,
				@RequestParam String equipo2) {

			modelo.addAttribute("Partido", partido);

			return "Partidos/JugarPartido";
		}
	
	
	
	

}
