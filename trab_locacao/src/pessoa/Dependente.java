package pessoa;

import java.util.Date;

import dao.*;

public class Dependente extends Pessoa {

	public Dependente() {}

	public Dependente(String nome, Date dataNascimento) {
		super(nome, dataNascimento);
	}

	@Override
	public String toString() {
		return 	"== Dependente ==" +
				super.toString();
	}

	public int insert() {
		return new DependenteDAO().insert(this);
	}
	
}
