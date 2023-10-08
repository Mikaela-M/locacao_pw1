package generico;

import java.util.LinkedList;

import locacoes.Locacao;

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
	public E buscaElemento(E elm) {
		//fazer aqui para pegar valor
		Object obj = new Object();
		for (E elemento : listaDados) {
			if (condition) {
				
			}
		}
		return listaDados.;
	}
	
}
