package negocio.cliente;

public class TransferCliente
{
	private int ID;
	private String nombre;
	private String apellidos;
	private boolean tipo;
	private String DNI;
	private String email;
	private String telefono;
	private boolean intencion;
	private final String tab="\t\t\t\t\t\t\t\t\t\t\t\t";
	
	public int getID() {
		return ID;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public String getTelefono() {
		// TODO Auto-generated method stub
		return telefono;
	}

	public String getDNI() {
		// TODO Auto-generated method stub
		return DNI;
	}

	public String getApellidos() {
		// TODO Auto-generated method stub
		return apellidos;
	}

	public boolean getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public boolean getIntencion() {
		// TODO Auto-generated method stub
		return intencion;
	}

	public void setID(int ID) {
		this.ID=ID;
		
	}

	public void setApellidos(String apellidos) {
		this.apellidos=apellidos;
		
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
		
	}

	public void setTipo(boolean tipo) {
		this.tipo=tipo;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public void setDNI(String DNI) {
		this.DNI=DNI;
	}

	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}

	public void setIntencion(boolean intencion) {
		this.intencion=intencion;
	}
	
	public String toString()
	{
		String salida = ID + tab + nombre + tab + apellidos + tab + email + tab + telefono + tab + intencion + tab + tipo;
		return salida; 
	}
}
