package com.example.demo.controladores;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.EquipoDTO;
import com.example.demo.servicios.ServicioEquipo;

@Controller
@RequestMapping("/Equipos")
public class ControladorEquipo {

	public static ArrayList<EquipoDTO> ListaEquipos = new ArrayList<>();
	EquipoDTO equipomodificar;
	
	@Autowired
	ServicioEquipo servicioequipo;

	// ---------->Pagina para mostrar los Equipos
	@GetMapping("/MostrarEquipos")
	public String mostrarequipos(Model modelo) {
		Collections.sort(ListaEquipos);
		modelo.addAttribute("ListadeEquipos", ListaEquipos);

		return "Equipos/MostrarEquipos";
	}

	// ------------>Pagina para crear el Equipo
	@GetMapping("/CrearEquipo")
	public String crearequipo(Model modelo) {
		modelo.addAttribute("EquipoDTO", new EquipoDTO());
		return "Equipos/CrearEquipo";
	}

	// --------->Metodo para Guardar el equipo
	@PostMapping("/GuardarEquipo")
	public String guardarequipo(@ModelAttribute EquipoDTO equipo) {
		servicioequipo.guardarequipo(equipo, ListaEquipos);
		return "redirect:/";

	}
	

	// ------------>Pagina para Eliminar el Equipo
	@GetMapping("/IndicarEquipo")
	public String indicareliminar(Model modelo) {
		return "Equipos/IndicarEquipo";
	}

	// --------->Metodo para Eliminar el equipo
	@GetMapping("/EliminarEquipo")
	public String eliminarequipo(@RequestParam String nombreequipo) {
		servicioequipo.eliminarequipo(ListaEquipos, nombreequipo);
		return "redirect:/";

	}
	
	
	
	

}
