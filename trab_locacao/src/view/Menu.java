package view;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

import generico.ListaGenerica;
import pessoa.*;
import locacoes.*;
import util.*;

public class Menu implements Validador {

	public static void main(String[] args) {
		try {
			TreeSet<Dependente> listaDependente = new TreeSet<Dependente>();
			//LinkedList<Locacao> listaLocacao = new LinkedList<Locacao>();
			ListaGenerica<Locacao> listaGenLocacao = new ListaGenerica<Locacao>();
			ListaGenerica<Dependente> listaGenDependente = new ListaGenerica<Dependente>();
			ListaGenerica<Socio> listaSocioAux = new ListaGenerica<Socio>();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Menu menu = new Menu();
			Socio socio = null;
			Locacao locacao = null;
			while (true) {
				switch (montaMenu()) {
				case 1:// Cadastrar Locacao
					Date dataRetirada = sdf
							.parse(JOptionPane.showInputDialog("Informe a data de retirada (dd/MM/yyyy): "));
					Date dataDevolucao = sdf
							.parse(JOptionPane.showInputDialog("Informe a data de devolucao (dd/MM/yyyy): "));
					try {
						if (!menu.validarData(dataRetirada, dataDevolucao)) {
							JOptionPane.showInternalMessageDialog(null, "Data invalida. Tente novamente");
							break;
						}
					} catch (NullPointerException e) {
						JOptionPane.showInternalMessageDialog(null, "Parâmetro nulo - validarData()");
					}

					double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da locacao: "));
					String titulo = JOptionPane.showInputDialog("Informe o titulo da locacao: ");
					String nomeSocioLoc = JOptionPane.showInputDialog("Informe o nome do Socio que fara a locacao: ");
					socio = new Socio();
					boolean socioEncontrado = false;
					for (Socio socioAux : listaSocioAux.listAll()) {
						if (socioAux != null && socioAux.getNome().equalsIgnoreCase(nomeSocioLoc)) {
							JOptionPane.showMessageDialog(null, socioAux.toString());
							socio = socioAux;
							socioEncontrado = true;
						}
					} 
					if(!socioEncontrado) {
						JOptionPane.showMessageDialog(null,
								"Socio nao cadastrado! Cadastre um socio no Menu para registrar uma locacao");
						break;
					}
					int situacaoSelec = exibeSituacao();
					Situacao situacaoRetornada = null;
					for (Situacao situacao : Situacao.values()) {
						if (situacao.getId() == situacaoSelec) {
							situacaoRetornada = situacao;
						}
					}
					listaGenLocacao.adicionar(new Locacao(dataRetirada, dataDevolucao, valor, titulo,
							socio, situacaoRetornada));
					break;
				case 2:// Pesquisar Locacao por valor
					double valorPesq = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor (0.00) da locacao que deseja pesquisar: "));
					locacao = new Locacao();
					locacao.setValor(valorPesq);
					/*if (listaGenLocacao.buscaElemento(locacao)) {
						System.out.println("locacao encontrada");
						//recuperar o objeto
						System.out.println(locacao.toString());
						
					}
					else {
						System.out.println("locacao nao encontrada");
					}*/
					break;
				case 3:// Cadastrar Socio
					String nomeSocio = JOptionPane.showInputDialog("Informe o nome do Socio: ");
					Date dataNascSocio = sdf
							.parse(JOptionPane.showInputDialog("Informe a data de nascimento do Socio (dd/MM/yyyy): "));
					String enderecoSocio = JOptionPane.showInputDialog("Informe o endereco do Socio: ");
					String emailSocio = JOptionPane.showInputDialog("Informe o email do Socio: ");

					if (JOptionPane.showConfirmDialog(null, "Socio tem dependente(s)?", "",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						boolean temDepend = true;
						while (temDepend) {
							String nomeDepend = JOptionPane.showInputDialog("Informe o nome do Dependente: ");
							Date dataNascDepend = sdf.parse(JOptionPane
									.showInputDialog("Informe a data de nascimento do Dependente (dd/MM/yyyy): "));
							listaDependente.add(new Dependente(nomeDepend, dataNascDepend));
							if (JOptionPane.showConfirmDialog(null, "Gostaria de inserir outro dependente?", "",
									JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
								temDepend = false;
							}
						}
					}

					socio = new Socio(nomeSocio, dataNascSocio, enderecoSocio, emailSocio, listaDependente);
					if (socio.insert() == -1)
						JOptionPane.showMessageDialog(null, "Erro ao inserir Socio!");
					else
						JOptionPane.showMessageDialog(null, "Socio inserido com sucesso!");
						listaSocioAux.adicionar(socio);
					break;
				case 4:// Pesquisar Socio Nome
					socio = new Socio();
					String nomeSocioPesq = JOptionPane
							.showInputDialog("Informe o nome do Socio que deseja pesquisar: ");
					socio.setNome(nomeSocioPesq);
					if (socio.selectNome() != null) {					
						JOptionPane.showMessageDialog(null, socio.selectNome());
					} else {
						JOptionPane.showMessageDialog(null, "Socio nao encontrado");
					}
					break;
				case 5:// Listar Locacoes
					if (!listaGenLocacao.listaTodos().isEmpty()) {
						JOptionPane.showMessageDialog(null, listaGenLocacao.listaTodos());
					} else {
						JOptionPane.showMessageDialog(null, "Nao ha locacoes cadastradas. Insira na opcao 1 do Menu");
					}
					break;
				case 6:// Listar Socios
					//socio = new Socio();
					for (Socio socioSelect : Socio.selectAll())
						if (socioSelect != null) {
							JOptionPane.showMessageDialog(null, socioSelect.toString());
						}
					break;
				case 7:// Sair
					System.exit(0);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static int montaMenu() {
		String menu = "";
		menu += ("Escolha uma das seguintes opcoes:\n");
		for (OpcoesMenu value : OpcoesMenu.values()) {
			menu += value.getItem() + "\n";
		}
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	public static int exibeSituacao() {
		String situacoes = "";
		situacoes += ("Escolha a situacao:\n");
		for (Situacao value : Situacao.values()) {
			situacoes += value.getItem() + "\n";
		}
		return Integer.parseInt(JOptionPane.showInputDialog(situacoes));
	}
}
