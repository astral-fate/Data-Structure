public class SLL<T> {
    private SLLNode<T> head;

    public SLL() {
        this.head = null;
    }

    public SLLNode<T> getHead() {
        return head;
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

    public boolean isInList(T data) {
        SLLNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void makeListEmpty() {
        head = null;
    }

    public void deleteFromList(T data) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty.");
        }

        if (head.getData().equals(data)) {
            head = head.getNext();
            return;
        }

        SLLNode<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }

        throw new IllegalArgumentException("Node with data does not exist.");
    }

    public void displayList() {
        SLLNode<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void makeEmpty() {
        head = null;
    }

    public boolean isInSLL(String cityName) {
        SLLNode<T> current = head;
        while (current != null) {
            if (current.getData() instanceof City) {
                City city = (City) current.getData();
                if (city.getCityName().equalsIgnoreCase(cityName)) {
                    return true;
                }
            }
            current = current.getNext();
        }
        return false;
    }

    public void deleteFromSLL(String cityName) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty.");
        }

        if (head.getData() instanceof City) {
            City city = (City) head.getData();
            if (city.getCityName().equalsIgnoreCase(cityName)) {
                head = head.getNext();
                return;
            }
        }

        SLLNode<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData() instanceof City) {
                City city = (City) current.getNext().getData();
                if (city.getCityName().equalsIgnoreCase(cityName)) {
                    current.setNext(current.getNext().getNext());
                    return;
                }
            }
            current = current.getNext();
        }

        throw new IllegalArgumentException("Node with data does not exist.");
    }

    public void addToSLLPosition(T data, int position) {
        SLLNode<T> newNode = new SLLNode<>(data);
        if (position < 0) {
            throw new IllegalArgumentException("Invalid position.");
        }

        if (position == 0) {
            addToSLLHead(data);
        } else {
            SLLNode<T> current = head;
            int currentPosition = 0;
            while (current != null && currentPosition < position - 1) {
                current = current.getNext();
                currentPosition++;
            }
            if (current == null) {
                throw new IllegalArgumentException("Position is out of bounds.");
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public T findInSLL(String cityName) {
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
    
    

    public void addToSLLHead(T data) {
        SLLNode<T> newNode = new SLLNode<>(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void addToSLLTail(T data) {
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

public int getSize() {
    int count = 0;
    SLLNode<T> current = head;
    while (current != null) {
        count++;
        current = current.getNext();
    }
    return count;
}
    Object getKey() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void incrementSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
