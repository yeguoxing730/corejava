package com.collection.list;

public class SingleList {
    int size = 0;
    Node first;

    public SingleList() {
    }

    public void add(String data) {
        Node node = new Node(data, null);
        if (first == null)
            first = node;
        else
            node.next = first;
        first = node;
        size++;
    }

    public void printSingleList() {
        if (size > 0) {
            Node node = first;
            while (node.data != null) {
                System.out.println("-----------" + node.data);
                if (node.next != null) {
                    node = node.next;
                } else {
                    break;
                }
            }
        }
    }

    public Node reverse() {
        Node node = this.first;
        Node header = new Node();
        Node next = null;
        while (node != null) {
            header = new Node(node.data, next);
            next = header;
            node = node.next;
        }
        return header;
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.add("a");
        singleList.add("b");
        singleList.add("c");
        singleList.printSingleList();
        singleList.reverse();
    }

    class Node {
        String data;
        Node next;

        public Node() {
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
