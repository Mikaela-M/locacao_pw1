package util;
import java.util.*;

public interface Validador {
	
	public default boolean validarData(Date data1, Date data2) {
		if (data2.before(data1)) {
			//se data2 (devolucao) for antes da data1 (retirada) retorna falso
			return false;
		}
		if (data1.after(data2)) {
			//se data1 (retirada) for depois da data2 (devolucao) retorna falso
			return false;
		}
		//Ver outras validacoes
		return true;
	}
	
}
