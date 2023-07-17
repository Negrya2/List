public class ArrayList implements List {
    private Integer[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity){
        if (capacity <= 0){
            throw new IllegalArgumentException("Capacity <= 0");
        }else{
            list = new Integer[capacity];
        }
    }

    public ArrayList(){
        list = new Integer[DEFAULT_CAPACITY];
    }

    private void increaseList(ArrayList arrayList){
        Integer[] newList = new Integer[arrayList.list.length * 2];
        for (int i = 0; i < arrayList.list.length; i++){
            newList[i] = arrayList.list[i];

        }
        arrayList.list = newList;
    }

    @Override
    public void insertFirst(int element) {
        if (list[list.length - 1] == null){
            for (int i = size; i > 0; i--){
               list[i] = list[i-1];
            }
            list[0] = element;
            size++;
        }else{
            increaseList(this);
            for (int i = size; i > 0; i--){
                list[i] = list[i-1];
            }
            list[0] = element;
            size++;
        }
    }

    @Override
    public void insertLast(int element) {
        if (list[list.length - 1] == null){
          list[size] = element;
          size++;
        }else{
            increaseList(this);
            list[size] = element;
            size++;
        }
    }

    public void insertIndex(int index, int element){
        if (list[list.length - 1] == null){
            for (int i = 0; i <= size; i++){
                if (i == index){
                    for (i = size; i > index; i--){
                        list[i] = list[i-1];
                    }
                    list[index] = element;
                    size++;
                    break;
                }
            }
        }else{
            increaseList(this);
            for (int i = 0; i < size; i++){
                if (i == index){
                    for (i = size; i > index; i--){
                        list[i] = list[i-1];
                    }
                    list[index] = element;
                    size++;
                    break;
                }
            }
        }
    }

    @Override
    public void removeFirst() {
        if (isEmpty()){
            System.out.println("Список пуст");
        }else{
            for (int i = 0; i < size - 1; i++){
                list[i] = list[i+1];
            }
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (isEmpty()){
            System.out.println("Список пуст");
        }else{
            list[size - 1] = null;
            size--;
            }

    }

    public void removeIndex(int index) {
        if (isEmpty()){
            System.out.println("Список пуст");
        }else{
            for (int i = 0; i < size; i++){
                if (i == index){
                    for (i = index; i < size - 1; i++){
                        list[i] = list[i+1];
                    }
                    size--;
                    break;
                }
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return (list[0] == null);
    }

    @Override
    public void displayList() {
        for (int i = 0; i < size; i++)
            System.out.print(list[i] + " ");
    }

    @Override
    public void find(int element) {
        for (int i = 0; i < size; i++){
            if (list[i] == element){
                System.out.println("Данный элемент находится под индексом: " + i);
            }
        }
    }
}
