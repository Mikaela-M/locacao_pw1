package view;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

import pessoa.Dependente;
import pessoa.*;

public class Menu {

	public static void main(String[] args) {
		try {
			Socio socio;
			TreeSet<Dependente> listaDependente = new TreeSet<Dependente>();
			
			while (true) {
				switch (montaMenu()) {
				case 1:// Cadastrar Locacao
					break;
				case 2:// Pesquisar Locacao por valor
					break;	
				case 3:// Cadastrar Socio
					String nomeSocio = JOptionPane.showInputDialog("Informe o nome do Socio: ");
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dataNascSocio = sdf.parse(JOptionPane.showInputDialog("Informe a data de nascimento do Socio (dd/MM/yyyy): "));
					String enderecoSocio = JOptionPane.showInputDialog("Informe o endereco do Socio: ");
					String emailSocio = JOptionPane.showInputDialog("Informe o email do Socio: ");
					
					if (JOptionPane.showConfirmDialog(null, "Socio tem dependente(s)?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						boolean temDepend = true;
						while (temDepend) {
							String nomeDepend = JOptionPane.showInputDialog("Informe o nome do Dependente: ");
							Date dataNascDepend = sdf.parse(JOptionPane.showInputDialog("Informe a data de nascimento do Dependente (dd/MM/yyyy): "));
							Dependente dependente = new Dependente(nomeDepend, dataNascDepend);
							if (dependente.insert() == -1)
								JOptionPane.showMessageDialog(null, "Erro ao inserir dependente!");
							else
								JOptionPane.showMessageDialog(null, "Dependente inserido com sucesso!");
							listaDependente.add(dependente);
							if(JOptionPane.showConfirmDialog(null, "Gostaria de inserir outro dependente?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
								temDepend = false;
							}
						}
					}
					
					socio = new Socio(nomeSocio, dataNascSocio, enderecoSocio, emailSocio, listaDependente);
					if(socio.insert() == - 1) 
						JOptionPane.showMessageDialog(null, "Erro ao inserir Socio!");
					else
						JOptionPane.showMessageDialog(null, "Socio inserido com sucesso!");
					//ver como fazer insercao da FK idsocio na tab dependente
					break;
				case 4:// Pesquisar Socio Nome
					break;
				case 5:// Listar Locacoes
					break;
				case 6:// Listar Socios
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
}
