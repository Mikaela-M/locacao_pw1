package generico;

import java.util.LinkedList;

public class ListaGenerica<E> implements ListaGenericaInterface<E>{
	LinkedList<E> listaDados = new LinkedList<>();

	@Override
	public void adicionar(E obj) {
		listaDados.add(obj);
	}

	@Override
	public String listaTodos() {
		String aux = "";
		for (E dado : listaDados) {
			if (dado != null) {
				aux += dado.toString();
			}
		}
		return aux;
	}

	@Override
	public boolean buscaElemento(E obj) {
		return listaDados.contains(obj);
	}
	
}
