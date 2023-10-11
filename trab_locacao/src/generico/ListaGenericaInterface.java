package generico;

import java.util.List;

public interface ListaGenericaInterface<E> {
	public void adicionar(E obj);
	public String listaTodos();
	public int buscaIndice(E obj);
	public E buscaElemento(int i);
	public List<E> listAll();
}
