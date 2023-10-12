package generico;

import java.util.*;

public class ListaGenerica<E> implements ListaGenericaInterface<E> {
	private LinkedList<E> listaDados = new LinkedList<>();

	@Override
	public void adicionar(E obj) {
		try {
			listaDados.add(obj);
		} catch (UnsupportedOperationException e) {
			System.out.println("Operacao nao suportada para a lista - adicionar()");
		} catch (NullPointerException e) {
			System.out.println("Parametro nulo - adicionar()");
		} catch (ClassCastException e) {
			System.out.println("Erro ao fazer casting da classe - adicionar()");
		} catch (IllegalArgumentException e) {
			System.out.println("Argumento invalido - adicionar()");
		}
	}

	@Override
	public String listaTodosStr() {
		String aux = "";
		for (E dado : listaDados) {
			if (dado != null) {
				aux += dado.toString();
			}
		}
		return aux;
	}

	@Override
	public LinkedList<E> listaTodosObj() {
		return listaDados;
	}

}
