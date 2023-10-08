package dao;

public interface GenericoDAO<T> {
		public int insert(T obj); 
	    public T selectNome(String elm);	    
}
