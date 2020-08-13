package MaquinaVendaJulianoNunes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MaquinaVendaJulianoNunes {

	
	// DADOS DO PRODUTO
	
	public static ArrayList<String> nomeprodutos = new ArrayList<String>();
	public static ArrayList<String> categorias = new ArrayList<String>();
	public static ArrayList<String> descricaoproduto = new ArrayList<String>();
	public static ArrayList<Double> valorproduto = new ArrayList<Double>();
	public static ArrayList<Double> custoproduto = new ArrayList<Double>();
	public static ArrayList<Double> vendadoproduto = new ArrayList<Double>();
	
	// DADOS DA VENDA
	
	public static ArrayList<Integer> vendaprodutos = new ArrayList<Integer>();
							
	// FUNCAO QUE CONVERTE INTEIROS EM STRING
	
	  public static Integer jopint(String num) {
		 int n1 = 0;
		 n1 = Integer.parseInt(JOptionPane.showInputDialog(num));
		 return n1;
	  }
	
	  // FUNCAO DE MOSTRAR MENSAGEM
	  
	  public static void jopmes(String msg) {
		  JOptionPane.showMessageDialog(null, msg);
	  }
	  
	  // FUNCAO QUE PERGUNTA E RETORNA STRING
	  
	  public static String jopstr(String msg) {
		  String meg = "";
		  meg = JOptionPane.showInputDialog(msg);
		  return meg;
	  }
	  
	  // FUNCAO QUE CONVERTE DOUBLE EM STRING
	  
	  public static Double jopdou(String msg) {
		  double num = 0D;
		  num = Double.parseDouble(JOptionPane.showInputDialog(msg));
		  return num;
	  }
	
	  // Função que é responsavel pelo saldo de vendas de um produto
	  
	  public static void saldoproduto(Integer produto,Double venda) {
		  Double novovalor = 0D;
		  novovalor = vendadoproduto.get(produto);
		  novovalor = novovalor + venda;
		  vendadoproduto.set(produto, novovalor);
	  }
	  
	  // Função que efetua uma venda
	  
	  public static void efetuarvendaproduto(Integer produto) {
		  vendaprodutos.add(produto);
		  saldoproduto(produto, valorproduto.get(produto));		 		  
	  }
	  	 	  	 	  	 	  	  	  	  
	public static void main(String[] args) {
		
		// TODO inicio
		
		// DADOS PRIMITIVOS A SER ENVIADOS AS ARRAYLIST
		
		String nomeProduto = "";
		int escolha = 0;
		String categoria = "";
		String descricao = "";
		double venda = 0D;
		double custo = 0D;
		double vendafeita = 0D;
		
		// STRINGBUFFER USADO PARA LISTAR
		
		StringBuffer listar = new StringBuffer();
		
		// MENU PRINCIPAL
		
		int console = -1;
		StringBuffer menuSB = new StringBuffer();
		menuSB.append("1- Cadastrar Produto\n");
		menuSB.append("2- Listar Produtos\n");
		menuSB.append("3- Alterar valor Produto\n");
		menuSB.append("4- Remover Produto\n");
		menuSB.append("5- Efetuar Vendas do Produto\n");
		menuSB.append("6- Total de Vendas\n");
		menuSB.append("7- Total de Lucros\n");
		menuSB.append("0- Sair");
		
		while (console != 0) {
			
			console = jopint(menuSB.toString());
			
			// DADOS TEMPORARIOS
			
			
			
			switch (console) {
			case 1: // CADASTRAR PRODUTO
				
				// TODO cadastrar
				
				nomeProduto = new String();
				escolha = 0;
				categoria = new String();
				descricao = new String();
				venda = 0D;
				custo = 0D;
				vendafeita = 0D;
				
				nomeProduto = jopstr("Produto a ser estocado:");
				escolha = jopint("Escolha qual a categoria do produto:\n0- Salgadinho\n"
						+ "1- Docê\n"
						+ "2- Bebida\n"
						+ "3- Outro");
				if (escolha == 0) {
					categoria = "Salgadinho";
				}
				if (escolha == 1) {
					categoria = "Docê";
				}
				if (escolha == 2) {
					categoria = "Bebida";
				}
				if (escolha == 3) {
					categoria = "Outro";
				}
				
				descricao = jopstr("Descrição do produto:");
				 venda = jopdou("Venda do Produto a ser vendido");
				 custo = jopdou("Custo do Produto a ser estocado:");
				 vendafeita = 0D;
				 
				 nomeprodutos.add(nomeProduto);
				 categorias.add(categoria);
				 descricaoproduto.add(descricao);
				 valorproduto.add(venda);
				 custoproduto.add(custo);
				 vendadoproduto.add(vendafeita);
				
				break;
			case 2: // LISTAR PRODUTO
				
				// TODO listar
				
				if (nomeprodutos.isEmpty()) {
					jopmes("Nenhum produto a ser listado!");
				} else {
				
				listar = new StringBuffer();
				
				listar.append("Lista de Produtos:\n");
				for (int i = 0; i < nomeprodutos.size(); i++) {
					listar.append("Produto: "+nomeprodutos.get(i)+"\n");
					listar.append("Categoria: "+categorias.get(i)+"\n");
					listar.append("Descrição: "+descricaoproduto.get(i)+"\n");
					listar.append("Valor: "+valorproduto.get(i)+"\n");
					listar.append("Custo: "+custoproduto.get(i)+"\n");
					listar.append("Venda: "+vendadoproduto.get(i)+"\n");
					listar.append("=================================\n");
				}
				 jopmes(listar.toString());
				}
				break;
			case 3: // ALTERAR VALOR DO PRODUTO
				
				// TODO ALTERAR VALOR
				
				if (nomeprodutos.isEmpty()) {
					jopmes("Não ha nenhum produto!");
				} else {
				int indiceValor = 0;
				listar = new StringBuffer();
				
				listar.append("Produtos e valor:\n");
				for (int i = 0; i < nomeprodutos.size(); i++) {
					listar.append("==========================\n");
					listar.append("Indice: "+i+"\n");
					listar.append("Produto: "+nomeprodutos.get(i)+"\n");
					listar.append("Valor: R$ "+valorproduto.get(i)+"\n");
					listar.append("Custo: R$ "+custoproduto.get(i)+"\n");
					listar.append("====================================\n");
				}
				indiceValor = jopint(listar.toString());
				
				venda = jopdou("Digite o valor novo do Produto:");
				valorproduto.set(indiceValor, venda);
				}
				break;
			case 4: // REMOVER PRODUTO
				
				// TODO REMOVER
				
				int removerProduto = 0;
				
				listar = new StringBuffer();
				if (nomeprodutos.isEmpty()) {
					jopmes("Nenhum produto a ser removido!");
				} else {
				listar.append("Lista de Produto a ser Removido:\n");
				for (int i = 0; i < nomeprodutos.size(); i++) {
					listar.append("==========================\n");
					listar.append("Indice: "+i+"\n");
					listar.append("Produto: "+nomeprodutos.get(i)+"\n");
					listar.append("Categoria: "+categorias.get(i)+"\n");
					listar.append("Descrição: "+descricaoproduto.get(i)+"\n");
					listar.append("Valor: "+valorproduto.get(i)+"\n");
					listar.append("Custo: "+custoproduto.get(i)+"\n");
					listar.append("=================================\n");
				}
				 removerProduto = jopint(listar.toString());
				 nomeprodutos.remove(removerProduto);
				 categorias.remove(removerProduto);
				 descricaoproduto.remove(removerProduto);
				 valorproduto.remove(removerProduto);
				 custoproduto.remove(removerProduto);
				 jopmes("Produto removido com sucesso!");}
				break;
			case 5: // EFETUAR VENDA DO PRODUTOS
				
				// TODO EFETUAR VENDA
				
				listar = new StringBuffer();
				int indicevenda = 0;
				
				listar.append("Listar os Produtos para vender:\n");
				for (int i = 0; i < nomeprodutos.size(); i++) {
					listar.append("==========================\n");
					listar.append("Indice: "+i+"\n");
					listar.append("Produto: "+nomeprodutos.get(i)+"\n");					
					listar.append("Valor: "+valorproduto.get(i)+"\n");
					listar.append("Custo: "+custoproduto.get(i)+"\n");
					listar.append("=================================\n");
				}
				indicevenda = jopint(listar.toString());
				
				efetuarvendaproduto(indicevenda);
				
				listar = new StringBuffer();
				
				listar.append("Vendas efetuadas\n");
				listar.append("Produto: "+nomeprodutos.get(indicevenda)+"\n");
				jopmes(listar.toString());
				    
				break;
			case 6: // TOTAL DE VENDAS
				
				// TODO TOTAL VENDAS
				
				Double valor = 0D; // ELE PEGA O TOTAL DE VENDAS DA ARRAY VENDADOPRODUTO
				
				listar = new StringBuffer();
				
				for (int i = 0; i < vendadoproduto.size(); i++) {
					valor += vendadoproduto.get(i);
					
				}
												
				listar.append("Total de vendas:\n");
				listar.append("Vendas totais: R$"+valor+"\n");
				jopmes(listar.toString());
				
				break;
			case 7: // TOTAL DE LUCROS
				
				// TODO TOTAL LUCRO
				
				Double lucro = 0D;
				Double valortotal = 0D;
				Double custototal = 0D;
				
				listar = new StringBuffer();
				
				for (int i = 0; i < valorproduto.size(); i++) {
					valortotal += valorproduto.get(i);
				}
				
				for (int i = 0; i < custoproduto.size(); i++) {
					custototal += custoproduto.get(i);
				}
			     
				lucro = valortotal - custototal;
				
				listar.append("Total de Lucros:\n");
			    listar.append("Lucro: R$"+lucro+"\n");
				jopmes(listar.toString());
			
				break;
			case 0: // SAIR
				JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?");
				break;
			default: // OPCAO INVALIDA
				jopmes("Erro\n Opção Invalida");
				break;
			}
		}
		
	}
	
	
}
