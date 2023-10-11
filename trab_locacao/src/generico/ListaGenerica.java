package generico;

import java.util.LinkedList;
import java.util.List;

public class ListaGenerica<E> implements ListaGenericaInterface<E> {
	private List<E> listaDados = new LinkedList<>();

	@Override
	public void adicionar(E obj) {
		try {
			listaDados.add(obj);
		} catch (NullPointerException e) {
			System.out.println("Parametro nulo - adicionar()");
		} catch (ClassCastException e) {
			System.out.println("Erro ao fazer casting da classe - adicionar()");
		} catch (IllegalArgumentException e) {
			System.out.println("Argumento invalido - adicionar()");
		}
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
	public E buscaElemento(int index) {
		try {
			return listaDados.get(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Indice invalido - buscaElemento()");
		}
		return null;
	}

	@Override
	public int buscaIndice(E obj) {
		try {
			return listaDados.indexOf(obj);
		} catch (NullPointerException e) {
			System.out.println("Parametro nulo - buscaIndice()");
		} catch (ClassCastException e) {
			System.out.println("Erro ao fazer casting da classe - buscaIndice()");
		}
		return 0;
	}

	@Override
	public List<E> listAll() {
		return listaDados;
	}

}
