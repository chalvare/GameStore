/**
 * 
 */
package presentacion.comando.comandoFactory;

import presentacion.comando.Comando;
import presentacion.comando.IDEventos;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Administrador
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class CommandFactory {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static CommandFactory commandFactoryInstancia;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static CommandFactory getInstancia() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		crearCommandFactory();
		return commandFactoryInstancia;
		// end-user-code
	}
	
	private synchronized static void crearCommandFactory(){
		if(commandFactoryInstancia==null)
			commandFactoryInstancia = new CommandFactoryImp();
			
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract Comando nuevoComando(IDEventos id_comando);
}