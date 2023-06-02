public class MSLLNode<T> {
    private String key;
    private SLL<T> list;
    private MSLLNode<T> next;

    public MSLLNode(String key, SLL<T> list, MSLLNode<T> next) {
        this.key = key;
        this.list = list;
        this.next = next;
    }

    public String getKey() {
        return key;
    }

    public SLL<T> getList() {
        return list;
    }

    public void setList(SLL<T> list) {
        this.list = list;
    }

    public MSLLNode<T> getNext() {
        return next;
    }

    public void setNext(MSLLNode<T> next) {
        this.next = next;
    }
}
