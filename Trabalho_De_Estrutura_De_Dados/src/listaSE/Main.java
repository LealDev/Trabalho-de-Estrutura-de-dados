package listaSE;

import listaEncadeada.Item;
import listaEncadeada.LseItem;
import listaEncadeada.NoItem;

public class Main {

	public static void main(String[] args) {
		LseItem lista1 = new LseItem();
		LseItem lista2 = new LseItem();

		lista1.insereUltimo(new Item(1));
		lista1.insereUltimo(new Item(2));
		lista1.insereUltimo(new Item(3));

		lista2.insereUltimo(new Item(1));
		lista2.insereUltimo(new Item(2));
		lista2.insereUltimo(new Item(3));

		System.out.println("Lista 1: " + lista1.toString());
		System.out.println("Lista 2: " + lista2.toString());

		if (iguais(lista1, lista2)) {
			System.out.println("As listas são iguais.");
		} else {
			System.out.println("As listas são diferentes.");
		}

		LseItem lista3 = concatena(lista1, lista2);
		System.out.println("Lista 3: " + lista3.toString());
	}

	public static boolean iguais(LseItem lista1, LseItem lista2) {
		NoItem aux1 = lista1.getPrim();
		NoItem aux2 = lista2.getPrim();

		while (aux1 != null && aux2 != null) {
			if (aux1.getItem().getChave() != aux2.getItem().getChave()) {
				return false;
			}
			aux1 = aux1.getProx();
			aux2 = aux2.getProx();
		}

		if (aux1 != null || aux2 != null) {
			return false;
		}

		return true;
	}

	public static LseItem concatena(LseItem lista1, LseItem lista2) {
		LseItem lista3 = new LseItem();
		NoItem aux1 = lista1.getPrim();
		NoItem aux2 = lista2.getPrim();

		while (aux1 != null) {
			lista3.insereUltimo(new Item(aux1.getItem().getChave()));
			aux1 = aux1.getProx();
		}

		while (aux2 != null) {
			lista3.insereUltimo(new Item(aux2.getItem().getChave()));
			aux2 = aux2.getProx();
		}

		return lista3;
	}

}