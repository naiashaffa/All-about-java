package Struktur_data.LATIHAN;

class Node {
    public int data;
    public Node next;

    public Node (int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
public class ShortedLinkedList {
    private Node first;
    
    public ShortedLinkedList() {
        first = null;
    }

    public void add(int i) {
        if (first == null || first.getData() >= i) {
            Node temp = first;
            Node newNode = new Node(i);
            first = newNode;
            newNode.next = temp;
        } else {
            Node index = first;
            while (index.next != null && index.next.getData() < i) {
                index = index.next;
            }
            Node newNode = new Node(i);
            Node temp = index.next;
            index.next = newNode;
            newNode.next = temp;
        }
    }

    public void lihatData() {
        Node index = first;
        while (index != null) {
            System.out.println(index.getData() + " ");
            index = index.next;
        }
    }
}

class tryIt {
    public static void main(String[] args) {
        ShortedLinkedList list = new ShortedLinkedList();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(0);
        list.lihatData();
    }
}