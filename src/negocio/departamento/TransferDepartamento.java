package negocio.departamento;

public class TransferDepartamento
{
	private int ID;
	private String nombre;
	private final String tab="\t\t\t\t\t\t\t\t\t\t\t\t";
	
	public String getNombre() {
		return nombre;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID=ID;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public String toString()
	{
		String salida = ID + tab + nombre;
		return salida; 
	}
}
