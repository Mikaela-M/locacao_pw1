package pessoa;
import java.util.*;

import dao.*;

public class Socio extends Pessoa {
	private String endereco;
	private String email;
	private TreeSet<Dependente> dependentes;
	
	public Socio() {}
	
	public Socio(String nome, Date dataNascimento, String endereco, String email, TreeSet<Dependente> dependentes) {
		super(nome, dataNascimento);
		this.endereco = endereco;
		this.email = email;
		this.dependentes = dependentes;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public TreeSet<Dependente>getDependente() {
		return dependentes;
	}

	public void setDependente(TreeSet<Dependente> dependente) {
		this.dependentes = dependente;
	}

	@Override
	public String toString() {
		String aux = "";
		if (dependentes != null) {
			for (Dependente dependente : dependentes) {
				aux += dependente.toString() + "\n";
			}
		}
		else {
			aux = "Dependente nao informado";
		}
		return 	"== Socio ==" +
				super.toString() + 
				"\nEndereco: " + endereco + 
				"\nEmail: " + email +
				"\n" + aux;
	}
	
	public int insert() {
		return new SocioDAO().insert(this);
	}
	
	public Socio selectNome() {
		return new SocioDAO().selectNome(this.getNome());
	}
	
	public static List<Socio> selectAll(){
		return SocioDAO.selectAll();
	}
	
}
