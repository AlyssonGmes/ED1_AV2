package estruturas;

import exceptions.PilhaCheiaException;
import exceptions.PilhaVaziaException;

public class Pilha<T> {
    private T[] pilha;
    private int posAtual = -1;
    final int tamanhoMaximo;

    public Pilha(int tamanho) {
        tamanhoMaximo = tamanho;
        pilha = (T[]) new Object[tamanho];
    } //ok

    public void empilhar(T valor) throws PilhaCheiaException {
        if (estahCheia()) {
            throw new PilhaCheiaException("A pilha está cheia.");
        } else {
            pilha[++posAtual] = valor;
        }
    } //ok

    public T desempilhar() throws PilhaVaziaException {
        if (estahVazia()) {
            throw new PilhaVaziaException("A pilha está vazia");
        }

        T obj = pilha[posAtual];
        pilha[posAtual] = null;
        posAtual--;
        return obj;
    } //ok

    public T getTopo() throws PilhaVaziaException {
        if (estahVazia()) {
            throw new PilhaVaziaException("A pilha está vazia");
        }

        return pilha[posAtual];
    } //ok

    public int getQtd() {
        return posAtual + 1;
    } //ok

    public boolean estahVazia() {
        if (posAtual == -1) {
            return true;
        }

        return false;
    } //ok

    public boolean estahCheia() {
        if (posAtual == tamanhoMaximo - 1) {
            return true;
        }

        return false;
    } //ok

    public void limpar() {
        posAtual = -1;
        pilha = (T[]) new Object[tamanhoMaximo];
    } //ok

    public void listar() throws PilhaVaziaException {
        if (estahVazia()) {
            throw new PilhaVaziaException("A pilha esta vazia");
        } else {
            for (int i = 0; i < getQtd(); i++) {
                System.out.print(pilha[i] + " ");
            }
            System.out.println();
        }
    } //ok

    public void validarExpressao() throws PilhaCheiaException, PilhaVaziaException {
        Pilha<Character> temp = new Pilha<>(tamanhoMaximo);
        boolean valido = true;

        String expressao = "";
        Character letra;

        for (int i = 0; i < tamanhoMaximo && valido; i++) {
            letra = (char) pilha[i];
            expressao += letra;

            switch (letra) {
                case '(':
                    temp.empilhar('(');
                    break;
                case '[':
                    temp.empilhar('[');
                    break;
                case '{':
                    temp.empilhar('{');
                    break;

                default:

                    if (letra.equals(')')) {
                        if (temp.estahVazia()) {
                            valido = false;
                        } else if (temp.getTopo().equals('(')) {
                            temp.desempilhar();
                        } else {
                            valido = false;
                        }
                    } else if (letra.equals(']')) {
                        if (temp.estahVazia()) {
                            valido = false;
                        } else if (temp.getTopo().equals('[')) {
                            temp.desempilhar();
                        } else {
                            valido = false;
                        }
                    } else if (letra.equals('}')) {
                        if (temp.estahVazia()) {
                            valido = false;
                        } else if (temp.getTopo().equals('{')) {
                            temp.desempilhar();
                        } else {
                            valido = false;
                        }
                    }
            }
        }

        if (temp.getQtd() == 0 && valido) {
            System.out.println("Expressão correta: " + expressao);
        } else {
            System.out.println("Expressão incorreta: " + expressao);
        }
    } // 2º versao, acrescentado 'válido' na condicional for
}
