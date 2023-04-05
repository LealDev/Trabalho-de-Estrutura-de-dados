package lista;
import java.util.Scanner;


public class AppLC {
/*
 * a) Criar uma Linsta Contigua de inteiro com 20 posições
 * b) Fazer um menu para
 *     1 - Inserir 
 *     2 - Remover
 *     3 - Pesquisar
 *     4 - Imprimir
 *     5 - Sair
 */	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		LCInteiro lista = new LCInteiro(20);
		int op;
		
		do {
			op = menu();
			switch (op) {
			case 1: 
				inserir (lista);
				break;
			case 2:
				remover (lista);
				break;
			case 3:
				pesquisar (lista);
				break;
			case 4:
				imprimir (lista);
				break;
			case 5:
				System.out.println("SAINDO...");
				break;
			default:
				System.err.println("OPCAO INVALIDA");
			}
		}while (op!=5);
	}
	public static int menu() {
		System.out.print("ENTRE COM A OPCAO\n"+
                "1 - Inserir \n" + 
                "2 - Remover\n" + 
                "3 - Pesquisar\n" + 
                "4 - Imprimir\n" + 
                "5 - Sair\n");
		int op = sc.nextInt();
		return op;
	}
	public static void inserir (LCInteiro lista) {
		System.out.print("Entre com um inteiro: ");
		int num = sc.nextInt();

		System.out.print("Entre com a posicao da insercao ou \n-1 para inserir no final: ");
		int pos = sc.nextInt();
		int result;
		
		if (pos==-1) {
			// Chama o metodo insereFim da classe LCInteiro
			result = lista.insereFim(num);
			if (result==0) {
				System.out.println("INSERCAO FEITA COM SUCESSO");
			}else {
				System.err.println("LISTA CHEIA. NAO CONSEGUIU INSERIR");
			}
		}else {
			result = lista.insere(num, pos);
			if (result==0) {
				System.out.println("INSERCAO FEITA COM SUCESSO");
			}else if (result==-1){
				System.err.println("LISTA CHEIA. NAO CONSEGUIU INSERIR");
			}else {
				System.err.println("POSICAO INVALIDA. NAO CONSEGUIU INSERIR");
			}
		}
	}
	
	public static void remover (LCInteiro lista) {
		System.out.print("Digite o numero para remover: ");
		int num = sc.nextInt();
		boolean result = lista.remove(num);
		if (result) {
			System.out.println("REMOCAO FEITA COM SUCESSO");
		}else {
			System.err.println("ELEMENTO NAO EXISTE");
		}
	}
	
	public static void pesquisar (LCInteiro lista) {
		System.out.print("Entre com o valor para pesquisar: ");
		int num = sc.nextInt();
		int pos = lista.pesquisa(num);
		if (pos == -1) {
			System.err.println(num + " NAO ENCONTRADO");
		}else {
			System.out.println(num + " ESTA NA POSICAO "+ pos);
		}
	}
	
	public static void imprimir (LCInteiro lista) {
		System.out.println(lista.toString());
	}

}
