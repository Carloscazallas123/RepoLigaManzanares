package com.example.demo.servicios;


import java.util.List;

import com.example.demo.modelos.PartidoDTO;

public interface ServicioPartido {

	void guardarpartido(List<PartidoDTO> listapartidos,PartidoDTO partido);
	PartidoDTO obtenerpartido(List<PartidoDTO>listapartidos,int jornada,String equipo1,String equipo2);
	void jugarpartido(int)
	
}
