package negocio.articulo;

public class TransferArticulo {
	
	private int ID;
	private String nombre;
	private int cantidad;
	private float valor;
	private final String tab="\t\t\t\t\t\t\t\t\t\t\t\t";

	public int getID() {
		return ID;
	}
	public String getNombre() {
		return nombre;
	}

	public Integer getCantidad() {
		// TODO Auto-generated method stub
		return cantidad;
	}

	public Float getValor() {
		// TODO Auto-generated method stub
		return valor;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public void setValor(float valor) {
		this.valor=valor;
	}

	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
	
	public void setID(int ID){
		this.ID=ID;
	}
	
	public String toString()
	{
		String salida = ID + tab + nombre + tab + cantidad + tab + valor;
		return salida; 
	}
}
