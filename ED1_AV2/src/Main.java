import estruturas.Fila;
import estruturas.Pilha;

public class Main {
    public static void main(String[] args) throws Exception {
        String expressao = "A + B ∗ C + D ∗ E";
        Pilha<Character> p1 = new Pilha<>(expressao.length());

        for (char d : expressao.toCharArray()) {
            p1.empilhar(d);
        }

        p1.validarExpressao();

    }
}