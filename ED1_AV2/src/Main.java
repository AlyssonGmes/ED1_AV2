import estruturas.Fila;
import estruturas.Pilha;
import exceptions.FilaCheiaException;
import exceptions.PilhaCheiaException;
import exceptions.PilhaVaziaException;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Fila<Integer> f1 = new Fila<>(10);
        f1.incluir(1);
        f1.incluir(2);
        f1.incluir(3);
        f1.incluir(4);
        f1.incluir(5);
        f1.incluir(6);
        f1.incluir(7);
        f1.incluir(8);
        f1.incluir(9);
        f1.incluir(10);


        Fila<Integer> f2 = new Fila<>(10);
        f2.incluir(1);
        f2.incluir(2);
        f2.incluir(3);
        f2.incluir(4);
        f2.incluir(5);
        f2.incluir(6);
        f2.incluir(7);
        f2.incluir(8);
        f2.incluir(9);
        f2.incluir(10);

        System.out.println(f1.saoIguais(f1, f2));

        f1.listar();
        f2.listar();

        Fila<Integer> fx = new Fila<>(1);
        Fila<Integer> fy = new Fila<>(1);

        System.out.println(fx.saoIguais(fx, fy));
        */

        //testarPilha();
        testarFila();
    }

    public static void testarFila() throws FilaCheiaException {
        System.out.println("Teste de fila");
        Fila<Integer> f1 = new Fila<>(10);
        f1.incluir(1);
        f1.incluir(2);
        f1.incluir(3);
        f1.incluir(4);
        f1.incluir(5);
        f1.incluir(6);
        f1.incluir(7);
        f1.incluir(8);
        f1.incluir(9);
        f1.incluir(10);

        Fila<Integer> f2 = new Fila<>(10);
        f2.incluir(1);
        f2.incluir(2);
        f2.incluir(3);
        f2.incluir(4);
        f2.incluir(5);
        f2.incluir(6);
        f2.incluir(7);
        f2.incluir(8);
        f2.incluir(9);
        f2.incluir(10);

        Fila<Integer> f3 = new Fila<>(10);
        f3.incluir(1);
        f3.incluir(2);
        f3.incluir(3);
        f3.incluir(4);
        f3.incluir(5);
        f3.incluir(6);
        f3.incluir(7);
        f3.incluir(8);
        f3.incluir(9);
        f3.incluir(10);

        Fila<Integer> f4 = new Fila<>(10);
        f4.incluir(1);
        f4.incluir(2);
        f4.incluir(3);
        f4.incluir(4);
        f4.incluir(5);
        f4.incluir(6);
        f4.incluir(7);
        f4.incluir(8);
        f4.incluir(9);
        f4.incluir(0);

        Fila<Integer> f5 = new Fila<>(40);
        f5.incluir(1);
        f5.incluir(2);
        f5.incluir(3);

        Fila<Integer> f6 = new Fila<>(3);

        System.out.println("Deve dar true: " + f1.saoIguais(f1, f2));

        System.out.println("Deve dar false: " + f3.saoIguais(f3, f4));

        System.out.println("Deve dar false: " + f5.saoIguais(f5, f6));

    }

    public static void testarPilha() throws PilhaCheiaException, PilhaVaziaException {
        System.out.println("Teste de pilha");
        String expressao1 = "A + B ∗ C + D ∗ E";
        String expressao2 = "A + B + C";
        String expressao3 = "12 + [35 - (10 + 2) +2]";
        String expressao4 = "[(18 + 3 · 2) ÷ 8 + 5 · 3] ÷ 6";
        String expressao5 = "37 + [-25 – (-11 + 19 – 4)]";
        String expressao6 = "60 ÷ {2 · [-7 + 18 ÷ (-3 + 12)}} – [7 · (-3) – 18 ÷ (-2) + 1]"; //incorreta
        String expressao7 = "-8 + {-5 + [(8 – 12) + (13 + 12)] – 10}";
        String expressao8 = "3 – {2 + (11 – 15) – [5 + (-3 + 1)] + 8}";
        String expressao9 = "[-1 + (22 – 5 · 6)] ÷ (-5 + 2) + 1 = 100";
        String expressao10 = "[– (24 – 8) · 2 – 24] ÷ [22 – (-3 + 2)]";
        String expressao11 = "{[(8 · 4 + 3) ÷ 7 + (3 + 15 ÷ 5) · 3] · 2 – (19 – 7) ÷ 6} · 2 + 12";

        Pilha<Character> p1 = new Pilha<>(expressao1.length());
        Pilha<Character> p2 = new Pilha<>(expressao2.length());
        Pilha<Character> p3 = new Pilha<>(expressao3.length());
        Pilha<Character> p4 = new Pilha<>(expressao4.length());
        Pilha<Character> p5 = new Pilha<>(expressao5.length());
        Pilha<Character> p6 = new Pilha<>(expressao6.length());
        Pilha<Character> p7 = new Pilha<>(expressao7.length());
        Pilha<Character> p8 = new Pilha<>(expressao8.length());
        Pilha<Character> p9 = new Pilha<>(expressao9.length());
        Pilha<Character> p10 = new Pilha<>(expressao10.length());
        Pilha<Character> p11 = new Pilha<>(expressao11.length());

        for (char d : expressao1.toCharArray()) {
            p1.empilhar(d);
        }

        for (char d : expressao2.toCharArray()) {
            p2.empilhar(d);
        }

        for (char d : expressao3.toCharArray()) {
            p3.empilhar(d);
        }

        for (char d : expressao4.toCharArray()) {
            p4.empilhar(d);
        }

        for (char d : expressao5.toCharArray()) {
            p5.empilhar(d);
        }

        for (char d : expressao6.toCharArray()) {
            p6.empilhar(d);
        }

        for (char d : expressao7.toCharArray()) {
            p7.empilhar(d);
        }

        for (char d : expressao8.toCharArray()) {
            p8.empilhar(d);
        }

        for (char d : expressao9.toCharArray()) {
            p9.empilhar(d);
        }

        for (char d : expressao10.toCharArray()) {
            p10.empilhar(d);
        }
        for (char d : expressao11.toCharArray()) {
            p11.empilhar(d);
        }

        p1.validarExpressao();
        p2.validarExpressao();
        p3.validarExpressao();
        p4.validarExpressao();
        p5.validarExpressao();
        p6.validarExpressao();
        p7.validarExpressao();
        p8.validarExpressao();
        p9.validarExpressao();
        p10.validarExpressao();
        p11.validarExpressao();
    }
}