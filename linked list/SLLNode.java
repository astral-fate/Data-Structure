
public class SLLNode<T> {
    private T data;
    private SLLNode<T> next;

    public SLLNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SLLNode<T> getNext() {
        return next;
    }

    public void setNext(SLLNode<T> next) {
        this.next = next;
    }
}
