package negocio.trabajador;

import java.sql.Date;

public class TransferTrabajador
{
	private int ID;
	private int IDDepartamento;
	private String DNI;
	private String nombre;
	private String apellidos;
	private boolean tipo;
	private Date fecIni;
	private Date fecFin;
	private float sueldoBase;
	private float factProd;
	private float sueldoHoras;
	private int horas;
	private final String tab="\t\t\t\t\t\t\t\t\t\t\t\t";

	public Float getSueldoHoras() {
		return sueldoHoras;
	}

	public Date getFecFin() {
		return fecFin;
	}

	public Float getFactProd() {
		return factProd;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public Integer getHoras() {
		return horas;
	}

	public Boolean getTipo() {
		return tipo;
	}

	public Date getFecIni() {
		return fecIni;
	}

	public int getIDDepartamento() {
		return IDDepartamento;
	}

	public Float getSueldoBase() {
		return sueldoBase;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID=ID;
	}

	public void setIDDepartamento(int IDDepartamento) {
		this.IDDepartamento=IDDepartamento;
	}

	public void setDNI(String DNI) {
		this.DNI=DNI;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos=apellidos;
	}

	public void setTipo(boolean tipo) {
		this.tipo=tipo;
	}

	public void setFecIni(Date fecIni) {
		this.fecIni=fecIni;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin=fecFin;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase=sueldoBase;
	}

	public void setFactProd(float factProd) {
		this.factProd=factProd;
	}

	public void setSueldoHoras(float sueldoHoras) {
		this.sueldoHoras=sueldoHoras;
	}

	public void setHoras(int horas) {
		this.horas=horas;
	}
	
	public String toString()
	{
		String salida = ID + tab + IDDepartamento + tab + DNI + tab + nombre + tab +apellidos + tab + tipo + tab + fecIni.toString() + tab + fecFin.toString() + tab + sueldoBase + tab + factProd+ tab + sueldoHoras+ tab + horas;
		return salida; 
	}

}
