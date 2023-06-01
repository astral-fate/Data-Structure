
public class SLL<T> {
    private SLLNode<T> head;

    public void insertAtHead(T data) {
        SLLNode<T> newNode = new SLLNode<>(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insertAtTail(T data) {
        SLLNode<T> newNode = new SLLNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            SLLNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public boolean search(T data) {
        SLLNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean delete(T data) {
        if (head == null) {
            return false;
        }
        if (head.getData().equals(data)) {
            head = head.getNext();
            return true;
        }
        SLLNode<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void display() {
        SLLNode<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public T getCity(String cityName) {
        SLLNode<T> current = head;
        while (current != null) {
            if (current.getData() instanceof City) {
                City city = (City) current.getData();
                if (city.getCityName().equalsIgnoreCase(cityName)) {
                    return current.getData();
                }
            }
            current = current.getNext();
        }
        return null;
    }

    public void insertAtPosition(T data, int position) {
        if (position < 0) {
            System.out.println("Invalid position. Position should be non-negative.");
            return;
        }

        SLLNode<T> newNode = new SLLNode<>(data);

        if (position == 0) {
            newNode.setNext(head);
            head = newNode;
            return;
        }

        SLLNode<T> current = head;
        int currentPosition = 0;
        while (current != null && currentPosition < position - 1) {
            current = current.getNext();
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Invalid position. Position exceeds the size of the list.");
            return;
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    public void displayList() {
        SLLNode<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void addToTail(T data) {
        SLLNode<T> newNode = new SLLNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            SLLNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }
}
