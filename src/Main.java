public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insertFirst(50);
        list.insertFirst(60);
        list.insertFirst(70);
        list.insertFirst(80);
        list.insertFirst(90);
        list.insertFirst(100);
        list.insertLast(110);
        list.removeFirst();
        list.removeLast();
        list.removeIndex(3);
        list.removeIndex(7);
        list.insertIndex(0,11);
        list.displayList();
    }
}