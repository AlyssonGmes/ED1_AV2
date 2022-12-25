package estruturas;

public class No<T> {
    private T dado;
    private No<T> prox;

    public void setDado(T dado) {
        this.dado = dado;
    }

    public void setProximo(No<T> prox) {
        this.prox = prox;
    }

    public No<T> getProximo() {
        return prox;
    }

    public T getDado() {
        return dado;
    }
}