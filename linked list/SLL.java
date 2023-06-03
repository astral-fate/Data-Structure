public class SLL<T> {
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

    public void addToSLLHead(T city, double latitude, double longitude) {
        SLLNode<T> newNode = new SLLNode<>(city, latitude, longitude);
        newNode.setNext(head);
        head = newNode;
        incrementSize();
    }

    public void addToSLLPosition(T city, double latitude, double longitude, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position. Position should be between 1 and " + (size + 1));
            return;
        }

        SLLNode<T> newNode = new SLLNode<>(city, latitude, longitude);

        if (position == 1) {
            newNode.setNext(head);
            head = newNode;
        } else {
            SLLNode<T> prev = head;
            for (int i = 1; i < position - 1; i++) {
                prev = prev.getNext();
            }
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        }
        incrementSize();
    }

    public void deleteFromSLL(String city) {
        if (head == null) {
            return;
        }

        if (head.getCity().equals(city)) {
            head = head.getNext();
            decrementSize();
            return;
        }

        SLLNode<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getCity().equals(city)) {
                current.setNext(current.getNext().getNext());
                decrementSize();
                return;
            }
            current = current.getNext();
        }
    }

    public boolean isInSLL(String city) {
        SLLNode<T> current = head;
        while (current != null) {
            if (current.getCity().equals(city)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public SLLNode<T> findSLLNode(String city) {
        SLLNode<T> current = head;
        while (current != null) {
            if (current.getCity().equals(city)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public T getElement(SLLNode<T> node) {
        return node.getElement();
    }

    public void makeEmpty() {
        head = null;
        size = 0;
    }

    public void displayList() {
        SLLNode<T> current = head;
        while (current != null) {
            System.out.println(current.getCity() + " (" + current.getLatitude() + ", " + current.getLongitude() + ")");
            current = current.getNext();
        }
    }

    void incrementSize() {
        size++;
    }

    private void decrementSize() {
        size--;
    }

    public void addToSLLTail(T element, double latitude, double longitude) {
        SLLNode<T> newNode = new SLLNode<>(element, latitude, longitude);
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
}
