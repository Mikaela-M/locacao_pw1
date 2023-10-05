package util;

public enum Situacao {
	EMDIA(1, "Em dia"),
	CANCELADA(2, "Cancelada"),
	ATRASADA(3, "Atrasada");
	
	private final int id;
	private final String descricao;
	
	private Situacao(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}
	
	public String getDescricao() { 
		return descricao;
	}

	public String getItem() {
		return this.getId() + " - " + this.getDescricao();
	}
	
}
