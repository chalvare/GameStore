package negocio.venta;

import java.sql.Date;

public class TransferVenta {

	private int ID;
	private int IDCliente;
	private float costeTotal;
	private Date fecha;
	private final String tab="\t\t\t\t\t\t\t\t\t\t\t\t";
	
	public Float getCosteTotal() {
		return costeTotal;
	}

	public Integer getIDCliente() {
		return IDCliente;
	}

	public Date getFecha(){
		return fecha;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID=ID;
	}

	public void setIDCliente(int IDCliente) {
		this.IDCliente=IDCliente;
	}

	public void setCosteTotal(float costeTotal) {
		this.costeTotal=costeTotal;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String toString()
	{
		String salida = ID + tab + IDCliente + tab + costeTotal + tab + fecha;
		return salida; 
	}
}
