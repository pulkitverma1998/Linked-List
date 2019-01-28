public class Node {

    private int value;
    private Node next;

    // This method creates a new node
    public Node(int v) {
        value = v;
        next = null;
    }

    // This method returns the integer value of the node
    public int getValue() {
        return value;
    }

    // This method returns the reference of the next node
    public Node getNext() {
        return next;
    }

    // This method sets the next value to the node
    public void setNext(Node node) {
        next = node;
    }

}
