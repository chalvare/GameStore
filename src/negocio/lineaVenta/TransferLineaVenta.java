package negocio.lineaVenta;

public class TransferLineaVenta
{
	private int IDVenta;
	private int IDArticulo;
	private float coste;
	private int cantidad;
	private final String tab="\t\t\t\t\t\t\t\t\t\t\t\t";
	
	public int getIDVenta() {
		return IDVenta;
	}
	public void setIDVenta(int IDVenta) {
		this.IDVenta = IDVenta;
	}
	public int getIDArticulo() {
		return IDArticulo;
	}
	public void setIDArticulo(int IDArticulo) {
		this.IDArticulo = IDArticulo;
	}
	public float getCoste() {
		return coste;
	}
	public void setCoste(float coste) {
		this.coste = coste;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String toString()
	{
		String salida = IDVenta + tab + IDArticulo + tab + coste + tab + cantidad + tab;
		return salida; 
	}
}
