package generico;

public interface ListaGenericaInterface<E> {
	public void adicionar(E obj);
	public String listaTodos();
	public boolean buscaElemento(E obj);
}
