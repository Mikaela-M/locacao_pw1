package pessoa;

import java.util.Date;

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

}