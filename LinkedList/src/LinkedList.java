public class LinkedList {

    private Node head;

    public LinkedList() {
        head = null;
    }

    // This method returns true if the list is empty
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    // This method finds the position of a number from the list
    public int find(int number) {
        Node currentNode = head;
        int position = 1;

        while (currentNode != null && currentNode.getValue() != number) {
            currentNode = currentNode.getNext();
            position++;
            if (currentNode.getNext() == null)
                break;
        }

        if (currentNode.getValue() == number) {
            return position;
        } else {
            return 0;
        }
    }

    // This method returns the size of the Linked List
    public int size() {
        int count = 0;
        Node currentNode = head;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    // This method returns the average value of the Linked List
    public int average() {
        int sizeOfList = size();
        int sum = 0;
        int average;
        Node currentNode = head;

        while (currentNode != null) {
            sum += currentNode.getValue();
            currentNode = currentNode.getNext();
        }

        if (isEmpty() == false) {
            average = sum / sizeOfList;
            return average;
        }
        return 0;
    }

    // This method displays the Linked List
    public void displayList() {
        Node currentNode = head;
        int value;
        int count = 0;

        while (currentNode != null) {
            if (count % 10 == 0) {
                System.out.println();
            }
            value = currentNode.getValue();
            System.out.print(value + " ");
            currentNode = currentNode.getNext();
            count++;
        }
    }

    // This method removes a number from a position from the list
    public int remove(int position) {
        Node currentNode = head;
        Node previousNode = null;
        int count = 1;

        while (currentNode != null && count != position) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            count++;
        }

        if (position == 1) {
            head = currentNode.getNext();
        } else if (position == count) {
            previousNode.setNext(currentNode.getNext());
        }

        return currentNode.getValue();
    }

    // This method adds a number to the list
    public int addItem(int value) {
        Node currentNode = head;
        Node previousNode = null;
        Node temp = new Node(value);
        int position = 0;

        if (head == null) {
            head = temp;
            return 1;
        } else if (temp.getValue() <= head.getValue()) {
            temp.setNext(head);
            head = temp;
            return 1;
        } else if (temp.getValue() > head.getValue()) {
            while (currentNode != null) {
                position++;
                if (temp.getValue() <= currentNode.getValue()) {
                    previousNode.setNext(temp);
                    temp.setNext(currentNode);
                    break;
                }

                if (currentNode.getNext() != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                } else {
                    currentNode.setNext(temp);
                    return position + 1;
                }
            }
        }
        return position;
    }

    // Practice

//    public int maxValue() {
//        Node currentNode = head;
//        int maxValue = head.getValue();
//
//        while (currentNode != null) {
//            if (currentNode.getValue() >=  maxValue) {
//                maxValue = currentNode.getValue();
//            } else {
//                currentNode = currentNode.getNext();
//            }
//        }
//        return maxValue;
//    }

}
