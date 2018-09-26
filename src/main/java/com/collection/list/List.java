package com.collection.list;

public class List {
    Node first;
    Node last;
    int size;

    List() {

    }

    public void add(String data) {
        final Node l = last;
        final Node newNode = new Node(l, null, data);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void printList() {
        if (size > 0) {
            Node node = first;
            while (node.data != null) {
                if (node != last) {
                    System.out.println("------------" + node.data);
                    node = node.next;
                } else {
                    System.out.println("------------" + node.data);
                    break;
                }
            }

        }
    }

    public Node reverse() {
        Node next = first;
        Node tail = null;
        Node header = null;
        while (next.data != null) {
            if (next != last) {
                if (next == first) {
                    header = new Node(null, null, next.data);
                } else {
                    header = new Node(null, tail, next.data);
                    tail.prev = header;
                }
                tail = header;
                next = next.next;
            } else {
                header = new Node(null, tail, next.data);
                tail.prev = header;
                break;
            }
        }
        return header;
    }

    public static void main(String[] args) {
        List list = new List();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.size);
        list.printList();
        list.reverse();
    }


    class Node {
        Node prev;
        Node next;
        String data;

        Node() {
        }

        public Node(Node prev, Node next, String data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
