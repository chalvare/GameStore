package negocio.contrato;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SAContrato{
	public boolean altaContrato(TransferContrato t) throws SQLException;
	public boolean actualizarContrato(TransferContrato t) throws SQLException;
	public TransferContrato consultaContrato(int IDContrato) throws SQLException;
	public ArrayList<TransferContrato> consultaContratos() throws SQLException;
}
