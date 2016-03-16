package negocio.contrato;

public class TransferContrato
{
	private int ID;
	private String descripcion;
	private final String tab="\t\t\t\t\t\t\t\t\t\t\t\t";

	public String getDescripcion() {
		return descripcion;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID=ID;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}

	public String toString()
	{
		String salida = ID + tab + descripcion;
		return salida; 
	}
}
