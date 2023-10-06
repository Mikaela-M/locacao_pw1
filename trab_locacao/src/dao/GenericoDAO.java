package dao;

public interface GenericoDAO<T> {
		public int insert(T obj); 
	    public T selectElement(String elm);
	    public String listAll();
	    
}
