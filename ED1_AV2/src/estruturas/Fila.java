package estruturas;

import exceptions.FilaCheiaException;
import exceptions.FilaVaziaException;

import java.util.Scanner;

public class Fila<T> implements IFila, IFilaAvaliacao {
    No<T> noInicioLista;
    No<T> noFimLista;
    int contadorNos = 0;
    final int tamanhoMax;

    public Fila(int tamanhoMaximo) {
        noInicioLista = new No<>();
        noFimLista = new No<>();
        tamanhoMax = tamanhoMaximo;
    } //ok

    public Fila() {
        noInicioLista = new No<>();
        noFimLista = new No<>();
        tamanhoMax = Integer.MAX_VALUE;
    }

    public void incluir(Object valor) throws FilaCheiaException {
        if (tamanhoMax == contadorNos) {
            throw new FilaCheiaException("A fila está cheia");
        }

        if (noInicioLista.getDado() == null) {
            noInicioLista.setDado((T) valor);
            noInicioLista.setProximo(noFimLista);
            contadorNos++;
        } else {
            No<T> novoNo = new No<>();
            noFimLista.setDado((T) valor);
            noFimLista.setProximo(novoNo);
            noFimLista = novoNo;
            contadorNos++;
        }
    } //ok

    public T remover() throws FilaVaziaException {
        No<T> auxiliar = noInicioLista;

        if (estaVazia()) {
            throw new FilaVaziaException("A fila está vazia");
        } else if(contadorNos == 1){
            noInicioLista = new No<>();
            noFimLista = new No<>();
            contadorNos--;
        }else {
            noInicioLista = noInicioLista.getProximo();
            contadorNos--;
        }

        return auxiliar.getDado();
    } //ok

    public boolean estaVazia() {
        if (contadorNos == 0) {
            return true;
        }

        return false;
    } //ok

    public void limpar() {
        noInicioLista = new No<>();
        noFimLista = new No<>();
        contadorNos = 0;
    } //ok

    public Object visualizarProximo() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("A fila está vazia");
        }

        if (noInicioLista.getProximo().getDado() != null) {
            return noInicioLista.getProximo().getDado();
        }

        return null;
    } //ok

    @Override
    public boolean saoIguais(IFila fila1, IFila fila2) {
        //((Fila) fila1).listar(); - para verificar o estado inicial da fila
        //((Fila) fila2).listar();

        IFila temp1 = new FilaIlimitada<>();
        IFila temp2 = new FilaIlimitada<>();

        Object a = null;
        Object b = null;
        boolean verificacao = true;

        try {
            while (!(fila1.estaVazia() && fila2.estaVazia())) {
                if (!fila1.estaVazia()) {
                    a = fila1.remover();
                    temp1.incluir(a);
                }

                if (!fila2.estaVazia()) {
                    b = fila2.remover();
                    temp2.incluir(b);
                }

                if (!(a.equals(b))) {
                    verificacao = false;
                }
            }
        } catch (FilaVaziaException | FilaCheiaException e) {
            verificacao = false;
        }

        try {
            while (!temp1.estaVazia()) {
                fila1.incluir(temp1.remover());
            }

            while (!temp2.estaVazia()) {
                fila2.incluir(temp2.remover());
            }

        } catch (FilaVaziaException | FilaCheiaException e) {
            //
        }

        //((Fila) fila1).listar(); - para verificar o estado final da fila
       // ((Fila) fila2).listar();
        return verificacao;
    }

    public Object get(int posicao) throws Exception {
        if (posicao > contadorNos - 1 || posicao < 0) {
            throw new Exception("Posição solicitada não existe na lista");
        } else {
            No<T> auxiliar = noInicioLista;

            for (int i = 0; i < posicao; i++) {
                auxiliar = auxiliar.getProximo();
            }
            return auxiliar.getDado();
        }
    } //ok

    public void listar() {
        No<T> auxiliar = noInicioLista;
        while (auxiliar.getProximo() != null && auxiliar.getProximo().getDado() != null) {
            System.out.print(auxiliar.getDado() + " ");
            auxiliar = auxiliar.getProximo();
        }
        if (noInicioLista.getDado() == null) {
            System.out.println("A lista está vazia.");
        } else {
            System.out.println(auxiliar.getDado());
        }
    } //ok
}
