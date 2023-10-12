package generico;

import java.util.*;

public interface ListaGenericaInterface<E> {
	public void adicionar(E obj);
	public String listaTodosStr();
	public LinkedList<E> listaTodosObj();
}
