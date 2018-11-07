package model;

import java.time.LocalDate;

public class Marca {
	
	private String nombre;
    private double tasa;
    
	public Marca(String nombre, double tasa) {
		super();
		this.nombre = nombre;
		this.tasa = tasa;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getTasa() {
		return tasa;
	}
	
	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
    
    public static double calcularTasa (String nombre) {
    	
    	double tasa = 0;
    	
    	if (("SQUA").equals(nombre)) {
    		double anio = LocalDate.now().getYear();
            double mes = LocalDate.now().getMonthValue();
            tasa = anio/mes;
    	} else if (("SCO").equals(nombre)) {
    		double diaDelMes = LocalDate.now().getDayOfMonth();
            tasa = diaDelMes * 0.5;
    	} else if (("PERE").equals(nombre)) {
    		double mes = LocalDate.now().getMonthValue();
            tasa = mes * 0.1;
    	}
    	
    	return tasa;
    }

    //informa el nombre de la marca y el valor total de la operacion (Monto de compra mas el interes)
    public static void obtenerTasaDeOperacion(Marca marca, Double importeCompra) {
    	
    	double montoTotal = 0;
        if (marca != null && importeCompra != null) {
        	montoTotal =  marca.getTasa() * importeCompra;
        	System.out.println ("Marca: " + marca.getNombre() +  " Monto Total: " + montoTotal);
        } 
    }
}
