package estruturas;

public class FilaIlimitada<T> extends Fila {

    private FilaIlimitada(int tamanhoMaximo) {
        super(tamanhoMaximo);
    }

    public FilaIlimitada() {
    }

    @Override
    public void incluir(Object valor) {
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
    }
}