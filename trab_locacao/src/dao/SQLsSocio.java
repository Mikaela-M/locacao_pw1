package dao;

public enum SQLsSocio {
	INSERTSOCIO("insert into socio(nomesocio, datanascimentosocio, enderecosocio, emailsocio) values (?, ?, ?, ?)"), 
    SELECTALLSOCIO("select * from socio"),
    SELECTNOME("select * from socio where nomesocio like ?");
      
    private final String sql;
	SQLsSocio(String sql){
        this.sql = sql; 
    }

    public String getSql() {
        return sql;
    }    
}
