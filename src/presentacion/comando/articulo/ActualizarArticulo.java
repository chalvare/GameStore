/**
 * 
 */
package presentacion.comando.articulo;

import java.sql.SQLException;

import negocio.articulo.TransferArticulo;
import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Administrador
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ActualizarArticulo implements Comando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {
			
			cr.setDatos(FactorySA.getInstance().getSAArticulo().actualizarArticulo((TransferArticulo) datos));
			cr.setEvento(IDEventos.EVENTO_MODIFICAR_ARTICULO);

		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_EVENTO_MODIFICAR_ARTICULO);
		} 

		return cr;
	}
}