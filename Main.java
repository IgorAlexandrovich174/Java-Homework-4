import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startProgram();
    }
    /**
     * Первая задача
     * */
    static void task1(){
//        Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
//        Постараться не обращаться к листу по индексам.
        LinkedList<Integer> linkedList1 = createLinkedlist(5,1,11);
        LinkedList<Integer> linkedList2 = reverseLinkedList(linkedList1);
        System.out.println("Список до разворота: " + linkedList1);
        System.out.println("Список после разворота: " + linkedList2);

    }


    /**
     * Создание связанного списка
     * */
    static LinkedList<Integer> createLinkedlist(int size, int minValue, int maxValue) {
        LinkedList<Integer> result = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(minValue,maxValue));
        }
        return result;
    }
    /**
     * Разворот связанного списка
     * */
    static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> inputList){
        LinkedList<Integer> result = new LinkedList<>();
        ListIterator<Integer> listIterator = inputList.listIterator(inputList.size());
        while (listIterator.hasPrevious()) {
            result.add(listIterator.previous());
        }
        return result;
    }
/**
 * Вторая задача
 * */
    void task2(){
//        Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди,
//        dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из
//        очереди, не удаляя.
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println("Очередь после добавления элементов: " + myQueue.queue);
        int FirstItemRemoved = myQueue.dequeue();
        System.out.println("Очередь после применения метода dequeue(): " + myQueue.queue);
        int firstElement = myQueue.first();
        System.out.println("Очередь после применения метода first(): " + myQueue.queue);

    }
    /**
     * Мой класс очереди с методами
     * */
    public class MyQueue {
        private LinkedList<Integer> queue = new LinkedList<>();

        public void enqueue(int inputValue) {
            queue.addLast(inputValue);
        }
        public int dequeue(){
            return queue.removeFirst();
        }

        public int first(){
            return queue.getFirst();
        }
    }

    static void task3(){
//        Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
        LinkedList<Integer> linkedList = createLinkedlist(5,1,11);
        ListIterator<Integer> listIterator = linkedList.listIterator();
        int result = 0;
        while (listIterator.hasNext()){
            result += listIterator.next();
        }
        System.out.println("Сумма элементов равна: " + result);
    }

    static void startProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задачи, которую хотите проверить: ");
        int result = scanner.nextInt();
        switch (result) {
            case 1 -> task1();
            case 2 -> {
                Main main = new Main();
                main.task2();
            }
            case 3 -> task3();
        }
    }
}
