/**
 * 
 */
package presentacion.comando.contrato;

import java.sql.SQLException;

import negocio.contrato.TransferContrato;
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
public class AltaContrato implements Comando{
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSAContrato().altaContrato((TransferContrato) datos));
			cr.setEvento(IDEventos.EVENTO_ALTA_CONTRATO);

		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_EVENTO_ALTA_CONTRATO);
		} 

		return cr;
	}
}