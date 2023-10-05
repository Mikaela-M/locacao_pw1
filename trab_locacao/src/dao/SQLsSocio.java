package dao;

public enum SQLsSocio {
	INSERTSOCIO("insert into socio(nomesocio, datanascimentosocio, enderecosocio, emailsocio) values (?, ?, ?, ?)"), 
    LISTALLSOCIO("select * from socio"),
    FINDBYNOME("select * from socio where nome like '?'");
      
    private final String sql;
	SQLsSocio(String sql){
        this.sql = sql; 
    }

    public String getSql() {
        return sql;
    }    
}
