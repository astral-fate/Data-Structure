public class SLLNode<T> {
    private T data;
    private double latitude;
    private double longitude;
    private SLLNode<T> next;

    public SLLNode(T data, double latitude, double longitude) {
        this.data = data;
        this.latitude = latitude;
        this.longitude = longitude;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public SLLNode<T> getNext() {
        return next;
    }

    public void setNext(SLLNode<T> next) {
        this.next = next;
    }

    public String getCity() {
        return data.toString();
    }
    
    
  
    private T element;
 



    public T getLelemnt() {
        return element;
    }
   

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

   
   

    public SLLNode<T> findNode(T target) {
        SLLNode<T> currentNode = this;
        while (currentNode != null) {
            if (currentNode.getElement().equals(target)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
}


