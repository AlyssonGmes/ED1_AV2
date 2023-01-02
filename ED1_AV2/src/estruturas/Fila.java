package estruturas;

import exceptions.FilaCheiaException;
import exceptions.FilaVaziaException;

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

    public Object remover() throws FilaVaziaException {
        No<T> auxiliar = noInicioLista;

        if (estaVazia()) {
            throw new FilaVaziaException("A fila está vazia");
        } else {
            noInicioLista = noInicioLista.getProximo();
            contadorNos--;
        }

        return auxiliar;
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
        if (((Fila<?>) fila1).contadorNos != ((Fila<?>) fila2).contadorNos) {
            return false;
        } else {
            int qtd = ((Fila<?>) fila1).contadorNos;
            No<?> no1 = ((Fila<?>) fila1).noInicioLista;
            No<?> no2 = ((Fila<?>) fila2).noInicioLista;

            if (qtd == 0) {
                return true;
            }

            for (int i = 0; i < qtd; i++) {
                if (no1.getDado().equals(no2.getDado())) {
                    no1 = no1.getProximo();
                    no2 = no2.getProximo();
                } else {
                    return false;
                }
            }
        }

        return true;
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
