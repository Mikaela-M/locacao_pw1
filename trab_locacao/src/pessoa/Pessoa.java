package pessoa;

import java.util.*;

public abstract class Pessoa implements Comparable<Pessoa>{
	private String nome;
	private Date dataNascimento;
	private static int total = 0;
	
	public Pessoa() {
		this(null, null);
	}
	
	public Pessoa(String nome, Date dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		total++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static int getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Nome: " + nome +
				"\nData de Nascimento: " + dataNascimento + 
				"\nTotal: " + total;
	}

	@Override
	public int compareTo(Pessoa o) {
		return this.getNome().compareTo(o.getNome());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(nome, other.nome);
	}
}
