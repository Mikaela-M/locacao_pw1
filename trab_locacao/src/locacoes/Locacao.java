package locacoes;
import java.util.*;
import pessoa.*;
import util.*;

public class Locacao implements Comparable<Locacao> {
	private Date dataRetirada;
	private Date dataDevolucao;
	private double valor;
	private String titulo;
	private Socio socio;
	private Situacao situacao;
	
	public Locacao() {}
	
	public Locacao(Date dataRetirada, Date dataDevolucao, double valor, String titulo, Socio socio, Situacao situacao) {
		super();
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
		this.valor = valor;
		this.titulo = titulo;
		this.socio = socio;
		this.situacao = situacao;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		String auxSocio = "";
		
		if (socio != null) {
			auxSocio = socio.toString();
		}
		else {
			auxSocio = "Socio nao informado";
		}
		return "== Locacao ==" + 
				"\nData Retirada: " + dataRetirada +
				"\nData Devolucao: " + dataDevolucao + 
				"\nValor: R$" + valor + 
				"\nTitulo: " + titulo +
				"\n" + auxSocio + 
				"\nSitucao: " + situacao.getDescricao();
	}

	@Override
	public int compareTo(Locacao o) {
		if(this.getValor() > o.getValor()) return 1;
		if(this.getValor() < o.getValor()) return -1;
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locacao other = (Locacao) obj;
		return Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
}
