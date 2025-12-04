package com.example.demo.servicios;


import java.util.List;

import com.example.demo.modelos.EquipoDTO;
import com.example.demo.modelos.JugadorDTO;
import com.example.demo.modelos.PartidoDTO;

public interface ServicioPartido {

	void guardarpartido(List<PartidoDTO> listapartidos,PartidoDTO partido);
	PartidoDTO obtenerpartido(List<PartidoDTO>listapartidos,int jornada,String fecha);
	void metergol(PartidoDTO partido,JugadorDTO jugador,List<EquipoDTO>listaequipos);
	
	
	
}
