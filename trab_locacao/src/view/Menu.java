package view;

import java.text.ParseException;
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
			ListaGenerica<Locacao> listaGenLocacao = new ListaGenerica<Locacao>();
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
					socio.setNome(nomeSocioLoc);
					if (socio.selectNome() != null) {
						socio = socio.selectNome();
						for (Socio socioListaAux : listaSocioAux.listaTodosObj()) {
							if (socio.getNome().equalsIgnoreCase(socioListaAux.getNome())
									&& socioListaAux.getDependente() != null) {
								socio = socioListaAux;
							}
						}
						JOptionPane.showMessageDialog(null, socio.toString());
						socioEncontrado = true;
					}
					if (!socioEncontrado) {
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
					listaGenLocacao.adicionar(
							new Locacao(dataRetirada, dataDevolucao, valor, titulo, socio, situacaoRetornada));
					break;
				case 2:// Pesquisar Locacao por valor
					double valorPesq = Double.parseDouble(
							JOptionPane.showInputDialog("Informe o valor (0.00) da locacao que deseja pesquisar: "));

					boolean locacaoEncontrada = false;
					for (Locacao locacaoBusca : listaGenLocacao.listaTodosObj()) {
						if (locacaoBusca != null && locacaoBusca.getValor() == valorPesq) {
							JOptionPane.showMessageDialog(null, locacaoBusca.toString());
							locacaoEncontrada = true;
						}
					}
					if (!locacaoEncontrada) {
						JOptionPane.showMessageDialog(null, "Locacao nao encontrada");
					}

					break;
				case 3:// Cadastrar Socio
					String nomeSocio = JOptionPane.showInputDialog("Informe o nome do Socio: ");
					Date dataNascSocio = sdf
							.parse(JOptionPane.showInputDialog("Informe a data de nascimento do Socio (dd/MM/yyyy): "));
					String enderecoSocio = JOptionPane.showInputDialog("Informe o endereco do Socio: ");
					String emailSocio = JOptionPane.showInputDialog("Informe o email do Socio: ");

					TreeSet<Dependente> listaDependente = new TreeSet<Dependente>();
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
						socio = socio.selectNome();
						for (Socio socioListaAux : listaSocioAux.listaTodosObj()) {
							if (socio.getNome().equalsIgnoreCase(socioListaAux.getNome())
									&& socioListaAux.getDependente() != null) {
								socio = socioListaAux;
							}
						}
						JOptionPane.showMessageDialog(null, socio.toString());
					} else {
						JOptionPane.showMessageDialog(null, "Socio nao encontrado");
					}
					break;
				case 5:// Listar Locacoes
					if (!listaGenLocacao.listaTodosStr().isEmpty()) {
						Collections.sort(listaGenLocacao.listaTodosObj());
						for (Locacao locacaoBusca : listaGenLocacao.listaTodosObj()) {
							JOptionPane.showMessageDialog(null, locacaoBusca.toString());
						}
					} else {
						JOptionPane.showMessageDialog(null, "Nao ha locacoes cadastradas. Insira na opcao 1 do Menu");
					}
					break;
				case 6:// Listar Socios
					boolean temSocio = false;
					for (Socio socioSelect : Socio.selectAll())
						if (socioSelect != null) {
							for (Socio socioListaAux : listaSocioAux.listaTodosObj()) {
								if (socioSelect.getNome().equalsIgnoreCase(socioListaAux.getNome())
										&& socioListaAux.getDependente() != null) {
									socioSelect.setDependente(socioListaAux.getDependente());
								}
							}
							JOptionPane.showMessageDialog(null, socioSelect.toString());
							temSocio = true;
						}
					if (!temSocio) {
						JOptionPane.showMessageDialog(null, "Nao ha socios cadastrados. Insira na opcao 3 do Menu");
					}
					break;
				case 7:// Sair
					System.exit(0);
					break;
				default:
					System.exit(0);
					break;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Parametro nulo");
		} catch (ParseException e) {
			System.out.println("Nao foi possivel converter o valor para uma string");
		} catch (NumberFormatException e) {
			System.out.println("Formato informado invalido");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int montaMenu() {
		try {
			String menu = "";
			menu += ("Escolha uma das seguintes opcoes:\n");
			for (OpcoesMenu value : OpcoesMenu.values()) {
				menu += value.getItem() + "\n";
			}
			return Integer.parseInt(JOptionPane.showInputDialog(menu));
		} catch (NumberFormatException e) {
			System.out.println("Formato informado invalido - montaMenu()");
		}
		return 0;
	}

	public static int exibeSituacao() {
		try {
			String situacoes = "";
			situacoes += ("Escolha a situacao:\n");
			for (Situacao value : Situacao.values()) {
				situacoes += value.getItem() + "\n";
			}
			return Integer.parseInt(JOptionPane.showInputDialog(situacoes));
		} catch (NumberFormatException e) {
			System.out.println("Formato informado invalido - montaMenu()");
		}
		return 0;
	}
}
