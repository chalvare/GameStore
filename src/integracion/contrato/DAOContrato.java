package integracion.contrato;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.contrato.TransferContrato;

public interface DAOContrato {
	public boolean altaContrato(TransferContrato t) throws SQLException;
	public boolean actualizarContrato(TransferContrato t) throws SQLException;
	public TransferContrato consultaContrato(int IDContrato) throws SQLException;
	public ArrayList<TransferContrato> consultaContratos() throws SQLException;
}
