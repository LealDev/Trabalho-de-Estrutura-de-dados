package listaC;

import lista.LCInteiro;
import java.util.Random;

public class Aplicativo {
   

public static void main(String[] args) {
    LCInteiro l1 = new LCInteiro(5);
    LCInteiro l2 = new LCInteiro(5);

    // Gerando números aleatórios e preenchendo a primeira lista
    Random random = new Random();
    for (int i = 0; i < 5; i++) {
        int num = random.nextInt(10); // Gera um número aleatório entre 0 e 9
        l1.insereFim(num);
    }

    // Gerando números aleatórios e preenchendo a segunda lista
    for (int i = 0; i < 5; i++) {
        int num = random.nextInt(10); // Gera um número aleatório entre 0 e 9
        l2.insereFim(num);
    }

    // Imprimindo as listas
    System.out.println("Lista 1: " + l1);
    System.out.println("Lista 2: " + l2);

    // Verificando se as listas são iguais
    if (iguais(l1, l2)) {
        System.out.println("As listas são iguais.");
    } else {
        System.out.println("As listas são diferentes.");
    }

    // Criando a terceira lista
    LCInteiro l3 = concatena(l1, l2);

    // Imprimindo a terceira lista
    System.out.println("Lista 3 (concatenação de L1 com L2): " + l3);
}

    // MÃ©todo que verifica se duas listas sÃ£o iguais
    public static boolean iguais(LCInteiro l1, LCInteiro l2) {
        if (l1.getQuant() != l2.getQuant()) {
            return false;
        }

        for (int i = 0; i < l1.getQuant(); i++) {
            if (l1.getNum(i) != l2.getNum(i)) {
                return false;
            }
        }

        return true;
    }

    // MÃ©todo que concatena duas listas
    public static LCInteiro concatena(LCInteiro l1, LCInteiro l2) {
        LCInteiro l3 = new LCInteiro(l1.tamanho() + l2.tamanho());

        for (int i = 0; i < l1.getQuant(); i++) {
            l3.insereFim(l1.getNum(i));
        }

        for (int i = 0; i < l2.getQuant(); i++) {
            l3.insereFim(l2.getNum(i));
        }

        return l3;
    }
}