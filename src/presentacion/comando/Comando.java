package presentacion.comando;

import presentacion.comando.comandoFactory.CommandResponse;

public interface Comando {
	
	public CommandResponse ejecutar(Object datos);
	
}
