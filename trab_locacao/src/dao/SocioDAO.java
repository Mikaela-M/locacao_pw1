package dao;
import java.sql.*;
import java.util.*;
import java.util.Date;

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
				System.out.println("Excecao no codigo - insert SocioDAO");
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				System.out.println("Classe nao encontrada - insert SocioDAO");
			}
			return chavePrimaria;
		}

		@Override
		public Socio selectNome(String elm) {
			try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(SQLsSocio.SELECTNOME.getSql())){
				stmt.setString(1, elm);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					String nome = rs.getString("nomesocio");
					Date dataNascimento = rs.getDate("datanascimentosocio");
					String endereco = rs.getString("enderecosocio");
					String email = rs.getString("emailsocio");
					System.out.println(dataNascimento);
					return new Socio(nome, dataNascimento, endereco, email, null);
				}
			}
			catch(SQLException e){ 
				System.out.println("Excecao selectNome - SocioDAO");
				e.printStackTrace();
			}catch(Exception e){  
				System.out.println("Excecao no codigo - selectNome SocioDAO");
			}
			return null;
		}

		public static List<Socio> selectAll() {
			List<Socio> listaSocio = new LinkedList<Socio>();
			try(Connection connection = new ConnectionFactory().getConnection();
					PreparedStatement stmt = 
							connection.prepareStatement(SQLsSocio.SELECTALLSOCIO.getSql())){
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					String nome = rs.getString("nomesocio");
					Date dataNascimento = rs.getDate("datanascimentosocio");
					String endereco = rs.getString("enderecosocio");
					String email = rs.getString("emailsocio");
					listaSocio.add(new Socio(nome, dataNascimento, endereco, email, null));
				}
				return listaSocio;
			}catch(SQLException e){ 
				System.out.println("Excecao SQL - selectAll SocioDAO");
			}catch(Exception e){  
				System.out.println("Excecao no codigo - selectAll SocioDAO");
			}
			return null;
		}
}
