package model;

import java.util.Date;

import exceptions.FechaDeVencimientoInvalidaException;

public class Tarjeta {
	
	private Marca marca;
	private String numeroTarjeta;
    private String cardHolder;
    private Date fechaVencimiento;
    
	public Tarjeta(Marca marca, String numeroTarjeta, String cardHolder, Date fechaVencimiento) throws FechaDeVencimientoInvalidaException{
		this.marca = marca;
		this.numeroTarjeta = numeroTarjeta;
		this.cardHolder = cardHolder;
		
		if  (validarFechaDeExpirancion(fechaVencimiento)) {
			this.fechaVencimiento = fechaVencimiento;
		} else {
			System.out.println("No se pudo crear la tarjeta debido a que la fecha de Vencimiento es Invalida");
			throw new FechaDeVencimientoInvalidaException();
		}
		
		
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
    
	public static boolean validarFechaDeExpirancion(Date fechaExpiracion) {
        return fechaExpiracion.after(new Date());
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardHolder == null) ? 0 : cardHolder.hashCode());
		result = prime * result + ((fechaVencimiento == null) ? 0 : fechaVencimiento.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((numeroTarjeta == null) ? 0 : numeroTarjeta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		if (cardHolder == null) {
			if (other.cardHolder != null)
				return false;
		} else if (!cardHolder.equals(other.cardHolder))
			return false;
		if (fechaVencimiento == null) {
			if (other.fechaVencimiento != null)
				return false;
		} else if (!fechaVencimiento.equals(other.fechaVencimiento))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (numeroTarjeta == null) {
			if (other.numeroTarjeta != null)
				return false;
		} else if (!numeroTarjeta.equals(other.numeroTarjeta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tarjeta [marca=" + marca + ", numeroTarjeta=" + numeroTarjeta + ", cardHolder=" + cardHolder
				+ ", fechaVencimiento=" + fechaVencimiento + "]";
	}

	public static String infoTarjeta(Tarjeta tarjeta) {
		
		String info = "";
		if (tarjeta !=null) {
			info = tarjeta.toString();
		}
		return info;
	}
	
	public static void operar(Tarjeta tarjeta, double importe) {
		if (tarjeta != null ) {
			if (Tarjeta.validarFechaDeExpirancion(tarjeta.getFechaVencimiento())) {
				if (importe <= 1000) {
					System.out.println("Operacion Correcta");
				} else {
					System.out.println("Operacion Inorrecta. Excede el monto maximo permitido");
				}
			} else {
				System.out.println("Operacion Inorrecta. Fecha de ExpiracionInvalida");
			}
		} else {
			System.out.println("Operacion Inorrecta. Tarjeta nula");
		}
	}

	public static void esTarjetaValida (Tarjeta tarjeta) {
		if (tarjeta != null) {
			if (Tarjeta.validarFechaDeExpirancion(tarjeta.getFechaVencimiento())) {
				System.out.println("Tarjeta valida");
			} else {
				System.out.println("Tarjeta invalida");
			}
			
		} else {
			System.out.println("Tarjeta nula");
		}
	}
	
	
    public static void compararTarjetas(Tarjeta unaTarjeta, Tarjeta otraTarjeta) {
    	
        if (unaTarjeta == null) {
        	System.out.println("No se puede comparar. La primera tarjeta es nula");
        }
        
        if (otraTarjeta == null) {
        	System.out.println("No se puede comparar. La segunda tarjeta es nula");
        }
        
        if (unaTarjeta.equals(otraTarjeta)) {
        	System.out.println("Las tarjetas son iguales");
        } else {
        	System.out.println("La tarjetas indicadas son distintas");
        }

    }
	
}	
	