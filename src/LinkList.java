public class LinkList implements List {
    private Node first;
    private Node last;

    public LinkList() {
        first = null;
        last = null;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node newFirst) {
        first = newFirst;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node newLast) {
        last = newLast;
    }

    public IteratorList getIterator() {
        return new IteratorList(this);
    }

    @Override
    public void insertFirst(int element) {
        Node list = new Node(element);

        if (isEmpty()) {
            last = list;
        } else {
            first.previous = list;
            list.next = first;
        }
        first = list;
    }

    @Override
    public void insertLast(int element) {
        Node list = new Node(element);

       if (isEmpty()) {
           first = list;
       } else {
           last.next = list;
           list.previous = last;
       }
       last = list;
    }

    public void insertAfter(int element, int newElement) {   //добавление после заданого элемента
        Node cur = first;
        Node list = new Node(newElement);

        while (cur.key != element) {
            if (cur.next == null) {
                System.out.print("Такого элемента нет!");
                break;
            } else {
                cur = cur.next;
            }
        }
        if (cur.next == null) {
            cur.next = list;
            list.previous = cur;
            last = list;
        }
        else {
            list.next = cur.next;
            list.previous = cur;
            cur.next = list;
            list.next.previous = list;


        }

    }


    @Override
    public void removeFirst() {
        first.next.previous = null;
        first = first.next;

    }

    @Override
    public void removeLast() {
        last = last.previous;
        last.next = null;
    }

    public void removeKey(int element) {
        Node cur = first;

        while(cur.key != element) {
            if(cur.next == null) {
                System.out.print("Такого элемента нет!");
                break;
            }
            else {
                cur = cur.next;
            }
        }
        if (cur == first) {
            removeFirst();
        } else if (cur == last)  {
            removeLast();
        } else {
            cur.previous.next = cur.next;
            cur.next.previous = cur.previous;
        }
    }

    @Override
    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public void displayList() {
        Node list = first;
        while (list != null) {
            System.out.println(list.key + " ");
            list = list.next;
        }

   }


    @Override
    public void find(int element) {
        Node cur = first;
        int index = 0;

        while(cur.key != element) {
            if(cur.next == null) {
                System.out.print("Такого элемента нет!");
                index = -1;
                break;
            }
            else {
                cur = cur.next;
                index++;
            }
        }
        if (index != -1) {
            System.out.println("Данный элемент лежит под номером: " + index);
        }
    }
}
