public interface List {

    void insertFirst(int element);   //добавление элемента в начало списка
    void insertLast(int element);  //добавление в конец списка
    void removeFirst();   //удаление первого элемента
    void removeLast();  //удаление последнего элемента
    boolean isEmpty();   //проверка на пустоту списка
    void displayList();   //вывод в консоль
    void find(int element);   //поиск элемента по значению

}
