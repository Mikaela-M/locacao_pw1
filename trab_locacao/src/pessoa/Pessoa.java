package pessoa;

import java.util.*;

public abstract class Pessoa {
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
		return "\nNome: " + nome +
				"\nData de Nascimento: " + dataNascimento + 
				"\nTotal: " + total;
	}

}
