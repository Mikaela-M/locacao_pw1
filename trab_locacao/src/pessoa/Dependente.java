package pessoa;

import java.util.Date;
import java.util.Objects;

public class Dependente extends Pessoa implements Comparable<Pessoa>{

	public Dependente() {}

	public Dependente(String nome, Date dataNascimento) {
		super(nome, dataNascimento);
	}

	@Override
	public String toString() {
		return 	"== Dependente ==" +
				super.toString();
	}
	
	@Override
	public int compareTo(Pessoa o) {
		return this.getNome().compareTo(o.getNome());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.getNome());
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dependente other = (Dependente) obj;
		return Objects.equals(this.getNome(), other.getNome());
	}
}
