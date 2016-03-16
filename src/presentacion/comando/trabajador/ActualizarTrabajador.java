/**
 * 
 */
package presentacion.comando.trabajador;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import negocio.trabajador.TransferTrabajador;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Administrador
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ActualizarTrabajador implements Comando{
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSATrabajador().actualizarTrabajador((TransferTrabajador) datos));
			cr.setEvento(IDEventos.EVENTO_MODIFICAR_TRABAJADOR);

		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_EVENTO_MODIFICAR_TRABAJADOR);
		} 

		return cr;
	}
}