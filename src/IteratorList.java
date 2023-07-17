public class IteratorList {
    private Node current;
    private LinkList ourList;

    public IteratorList(LinkList list) {
        ourList = list;
        reset();
    }

    public void reset() {
        current = ourList.getFirst();
    }

    public boolean atEnd() {
        return (current == ourList.getLast());
    }

    public void nextNode() {
        current = current.next;
    }

    public Node getCurrent() {
        return current;
    }

    public void insertAfter(int key) {
        Node node = new Node(key);
        if(ourList.isEmpty()) {
            ourList.setFirst(node);
            ourList.setLast(node);
            current = node;
        } else if (atEnd()) {
            ourList.setLast(node);
            current.next = node;
            node.previous = current;
            current = node;
        } else {
            node.next = current.next;
            node.previous = current;
            current.next = node;
            node.next.previous = node;
        }
    }

    public void insertBefore(int key) {
        Node node = new Node(key);
        if(ourList.isEmpty()) {
            ourList.setFirst(node);
            ourList.setLast(node);
            current = node;
        } else if(current.previous == null) {
            ourList.setFirst(node);
            node.next = current;
            current.previous = node;
            reset();
        } else {
            current.previous.next = node;
            node.previous = current.previous;
            node.next =current;
            current.previous = node;
        }
    }

    public void deleteCurrent() {
        if (current == ourList.getFirst()) {
            ourList.setFirst(current.next);
            reset();
        } else if (atEnd()) {
            ourList.setLast(current.previous);
            reset();
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current = current.next;

        }
    }
}
