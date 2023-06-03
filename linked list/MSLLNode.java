class MSLLNode<T> {
private String key;
private SLL<T> list;
private double latitude;
    private double longitude;
private MSLLNode<T> next;
public MSLLNode(String key, SLL<T> list, MSLLNode<T> next) {
    this.key = key;
    this.list = list;
    this.next = next;
}

  
    
   

    public MSLLNode(String key, SLL<T> list, double latitude, double longitude) {
        this.key = key;
        this.list = list;
        this.latitude = latitude;
        this.longitude = longitude;
    }

public String getKey() {
    return key;
}

public SLL<T> getList() {
    return list;
}

public MSLLNode<T> getNext() {
    return next;
}

public void setNext(MSLLNode<T> next) {
    this.next = next;
}

}
