class SLL<T> {
private SLLNode<T> head;
private int size;
public SLL() {
    this.head = null;
    this.size = 0;
}

public SLLNode<T> getHead() {
    return head;
}

public int getSize() {
    return size;
}

public void addToSLLHead(T city) {
    SLLNode<T> newNode = new SLLNode<>(city);
    newNode.setNext(head);
    head = newNode;
    size++;
}

public void addToSLLTail(T city) {
    SLLNode<T> newNode = new SLLNode<>(city);
    if (head == null) {
        head = newNode;
    } else {
        SLLNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }
    size++;
}

public void deleteFromSLL(String city) {
    if (head == null) {
        return;
    }

    if (head.getData().equals(city)) {
        head = head.getNext();
        size--;
        return;
    }

    SLLNode<T> current = head;
    while (current.getNext() != null) {
        if (current.getNext().getData().equals(city)) {
            current.setNext(current.getNext().getNext());
            size--;
            return;
        }
        current = current.getNext();
    }
}

public boolean isInSLL(String city) {
    SLLNode<T> current = head;
    while (current != null) {
        if (current.getData().equals(city)) {
            return true;
        }
        current = current.getNext();
    }
    return false;
}

public void makeEmpty() {
    head = null;
    size = 0;
}

public void displayList() {
    SLLNode<T> current = head;
    while (current != null) {
        System.out.println(current.getData());
        current = current.getNext();
    }
}

public void incrementSize() {
    size++;
}
}
