package view;

public enum OpcoesMenu {
	
	CADASTRO(1, "Cadastrar Locação"),
	PESQLOCVALOR(2, "Pesquisar Locação usando o valor"),
	CADSOCIO(3, "Cadastrar Sócio (no banco de dados)"),
	PESQSOCNOME(4, "Pesquisar Sócio usando o nome"),
	LISTALOC(5, "Listar todas as Locações"),
	LISTASOC(6, "Listar todos os Sócios"),
	SAIR(7, "Sair");
	
	private final int opcao;
	private final String descricaoMenu;
	
	private OpcoesMenu(int opcao, String descricaoMenu) {
		this.opcao = opcao;
		this.descricaoMenu = descricaoMenu;
	}
	
	public int getOpcao() {
		return opcao;
	}
	public String getDescricaoMenu() {
		return descricaoMenu;
	}
	
	public String getItem() {
		return this.getOpcao() + " - " + this.getDescricaoMenu();
	}
	
}
