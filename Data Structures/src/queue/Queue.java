package queue;

//Bu, generik bir sinifdir. T hər hansı bir tip ola bilər və bu, queue-də saxlanacaq elementlərin tipini təyin edir.
public class Queue<T> {
    private int front; // Queue-nin başlanğıcını izləmək üçün
    private int rear; // Queue-nin sonunu izləmək üçün
    private final int capacity = 100; // Queue-nin maksimum ölçüsü
    private Object[] queue; // Queue elementlərini saxlamaq üçün massiv

    /**
     * front - Queue-dəki ilk elementin indeksini izləyir. Başlanğıcda -1 olaraq təyin edilir ki, bu da queue-nin boş olduğunu göstərir.
     * rear - Queue-dəki son elementin indeksini izləyir. Başlanğıcda -1 olaraq təyin edilir.
     * capacity - Queue-nin maksimum tutumudur (burada 100 olaraq təyin edilib).
     * queue - Elementləri saxlamaq üçün massivdir.
     */

    //Bu konstruktor queue-nin başlanğıc vəziyyətini təyin edir.
    public Queue() {
        front = -1;
        rear = -1;
        queue = new Object[capacity];
    }

    // Queue-nin boş olub-olmadığını yoxlayır.
    public boolean isEmpty() {
        return front == -1;
    }

    // Queue-yə yeni element əlavə edir.Əgər queue doludursa, xəbərdarlıq mesajı çap edir. Əks halda, yeni elementi əlavə edir və rear dəyişənini artırır.
    public void enqueue(T data) {
        if ((rear + 1) % capacity == front) {
            System.out.println("Queue is full.Can't enqueue the data");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        queue[rear] = data;
    }

    // Queue-nin başındakı elementi çıxarır və qaytarır.Əgər queue boşdursa, xəbərdarlıq mesajı çap edir və null qaytarır. Əks halda, baş elementi çıxarır və front dəyişənini artırır.
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.Can't dequeue.");
            return null;
        }
        T data = (T) queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return data;
    }

    // Queue-nin başındakı elementi çıxarmadan qaytarır.Əgər queue boşdursa, xəbərdarlıq mesajı çap edir və null qaytarır. Əks halda, baş elementi qaytarır.
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty/Nothing to peek.");
            return null;
        }
        return (T) queue[front];
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(23);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Front element after dequeue: " + queue.peek());

        /**
         * Bu hissədə Queue<Integer> obyektini yaradır və ona integer dəyərlər əlavə edir.
         * Sonra isə peek() və dequeue() metodlarını istifadə edərək, queue-dən elementləri oxuyur və çıxarır.
         */
    }
}
