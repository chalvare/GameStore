package presentacion.comando.comandoFactory;

import presentacion.comando.IDEventos;

public class CommandResponse {
	
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private IDEventos evento;
	private Object datos;

	/**
	 * @return el evento
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public IDEventos getEvento() {
		// begin-user-code
		return evento;
		// end-user-code
	}

	/**
	 * @param evento
	 *            el evento a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setEvento(IDEventos evento) {
		// begin-user-code
		this.evento = evento;
		// end-user-code
	}
	
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	/**
	 * @return el datos
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object getDatos() {
		// begin-user-code
		return datos;
		// end-user-code
	}

	/**
	 * @param datos
	 *            el datos a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDatos(Object datos) {
		// begin-user-code
		this.datos=datos;
		// end-user-code
	}
	

}
