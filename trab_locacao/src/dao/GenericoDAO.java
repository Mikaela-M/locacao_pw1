package dao;

public interface GenericoDAO<T> {
		public int insert(T obj); 
	    public T selectElement(T elm);
	    public String listAll();
	    
}
