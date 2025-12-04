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
import com.example.demo.modelos.PartidoDTO;
import com.example.demo.servicios.ServicioPartido;

@Controller
@RequestMapping("/Partido")
public class ControladorPartido {

	@Autowired
	ServicioPartido serviciopartido;
	public static List<PartidoDTO> listapartidos = new ArrayList<>();

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



}
