/**
 * 
 */
package presentacion.controlador;

import presentacion.comando.comandoFactory.CommandResponse;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Administrador
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class Dispatcher {
	
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static Dispatcher dispatcherInstance;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param respuestacomando
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void redirect(CommandResponse respuestacomando);

	private synchronized static void createDispatcher() {
		if (dispatcherInstance == null)
			dispatcherInstance = new DispatcherImp();
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static Dispatcher getInstance() {
		createDispatcher();
		return dispatcherInstance;

	}
	
	
	
}