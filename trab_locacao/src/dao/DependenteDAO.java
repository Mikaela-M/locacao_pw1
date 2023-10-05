package dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import pessoa.*;

public class DependenteDAO implements GenericoDAO<Dependente>{

	@Override
	public int insert(Dependente dependente) {
		int chavePrimaria = -1;
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(SQLsDependente.INSERTDEPENDENTE.getSql(),
								Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, dependente.getNome());
			stmt.setDate(2, new java.sql.Date(dependente.getDataNascimento().getTime()));
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
	public Dependente selectElement(Dependente elm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
