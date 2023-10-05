package dao;

public enum SQLsDependente {
	INSERTDEPENDENTE("insert into dependente(nomedependente, datanascimentodependente) values (?, ?)"),
	INSERTFKSOCIO("insert into dependente(idsocio) values (?)");

	private final String sql;
	SQLsDependente(String sql){
        this.sql = sql; 
    }

    public String getSql() {
        return sql;
    }    
}
