package main;

import java.util.Date;

import exceptions.FechaDeVencimientoInvalidaException;
import model.Marca;
import model.Tarjeta;

public class EjercicioTarjetas {

	public static void main(String[] args) {
		
		
		// Crear una clase ejecutable con 3 objetos
		
		Marca squa = new Marca("SQUA", Marca.calcularTasa("SQUA"));
        Marca sco = new Marca("SCO", Marca.calcularTasa("SCO"));
        Marca pere = new Marca("PERE", Marca.calcularTasa("PERE"));
		
        Tarjeta squaTarjeta = null;
        Tarjeta scoTarjeta = null;
        Tarjeta pereTarjeta = null;
        
        
		try {
			squaTarjeta = new Tarjeta(squa, "0001000100010001", "Juan Squa", new Date ("01/09/2020"));
		} catch (FechaDeVencimientoInvalidaException e) {
			e.printStackTrace();
		}

		try {
			scoTarjeta = new Tarjeta(sco, "0002000100010001", "Juan Sco", new Date ("01/10/2020"));
		} catch (FechaDeVencimientoInvalidaException e) {
			e.printStackTrace();
		}
		
		try {
			pereTarjeta = new Tarjeta(pere, "0003000100010001", "Juan Pere", new Date ("01/11/2020"));
		} catch (FechaDeVencimientoInvalidaException e) {
			e.printStackTrace();
		}
		
		// Invocar un método que devuelva toda la información de una tarjeta
		
		Tarjeta.infoTarjeta(squaTarjeta);
		Tarjeta.infoTarjeta(scoTarjeta);
		Tarjeta.infoTarjeta(pereTarjeta);
		
		
		// Informar si una operación es valida
		Tarjeta.operar (squaTarjeta,300L);
		Tarjeta.operar (pereTarjeta,1001L);
		
		//Informar si una tarjeta es válida para operar
		Tarjeta.esTarjetaValida(squaTarjeta);
		Tarjeta.esTarjetaValida(scoTarjeta);
		Tarjeta.esTarjetaValida(pereTarjeta);
		
		//Identificar si una tarjeta es distinta a otra
		Tarjeta.compararTarjetas(squaTarjeta, scoTarjeta);
		Tarjeta.compararTarjetas(scoTarjeta, scoTarjeta);
		Tarjeta.compararTarjetas(pereTarjeta, scoTarjeta);
		
		//Obtener por medio de un método la tasa de una operación informando marca e importe
		Marca.obtenerTasaDeOperacion(squa, 1000D);
		Marca.obtenerTasaDeOperacion(sco, 999D);
		Marca.obtenerTasaDeOperacion(pere, 2500D);
		
	}

}
