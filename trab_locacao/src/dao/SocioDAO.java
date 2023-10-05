package dao;
import java.sql.*;
import pessoa.*;

public class SocioDAO implements GenericoDAO<Socio>{
		@Override
		public int insert(Socio socio) {
			int chavePrimaria = -1;
			try(Connection connection = new ConnectionFactory().getConnection();
					PreparedStatement stmt = 
							connection.prepareStatement(SQLsSocio.INSERTSOCIO.getSql(),
									Statement.RETURN_GENERATED_KEYS)){
				stmt.setString(1, socio.getNome());
				stmt.setDate(2, new java.sql.Date(socio.getDataNascimento().getTime()));
				stmt.setString(3, socio.getEndereco());
				stmt.setString(4, socio.getEmail());
				stmt.execute();
				ResultSet chaves = stmt.getGeneratedKeys();
				if (chaves.next())  chavePrimaria= chaves.getInt(1);
			}catch(SQLException e){
				System.out.println("Excecao no codigo - Socio insert");
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				System.out.println("Classe nao encontrada - Socio insert!");
			}
			return chavePrimaria;
		}

		@Override
		public Socio selectElement(Socio elm) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String listAll() {
			// TODO Auto-generated method stub
			return null;
		}
}
