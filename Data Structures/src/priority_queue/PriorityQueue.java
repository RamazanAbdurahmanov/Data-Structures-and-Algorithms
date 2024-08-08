package priority_queue;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Bu, generik bir sinifdir. T hər hansı bir tip ola bilər və bu,
 * priority queue-də saxlanacaq elementlərin tipini təyin edir.
 */
public class PriorityQueue<T> {
    //queue - Elementlərin saxlanacağı və önceliklərinə görə sıralanacağı bir ArrayListdir.
    private ArrayList<Element> queue;

    /**
     * Daxili Sinif Element:
     * data - Queue-də saxlanacaq məlumatı (elementi) təmsil edir.
     * priority - Həmin elementin önceliyini təyin edir. İnt olaraq verilmişdir,
     * yəni rəqəm nə qədər böyükdürsə, öncelik bir o qədər yüksəkdir.
     */
    private class Element {
        T data;
        int priority;

        Element(T data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    //Bu konstruktor, boş bir ArrayList yaradır.
    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    //Queue-nin boş olub-olmadığını yoxlayır.
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Queue-yə yeni element və onun önceliyini əlavə edir.
     * Bu metodda yeni bir Element obyekt yaradılır və queue-yə əlavə olunur.
     * Sonra, elementlərin önceliklərinə görə sıralanması üçün sort() metodu istifadə olunur.
     * Comparator.comparingInt(e -> -e.priority) vasitəsilə önceliklərin azalan sıraya görə sıralanması təmin edilir.
     */
    public void insert(T data, int priority) {
        Element newElement = new Element(data, priority);
        queue.add(newElement);
        queue.sort(Comparator.comparing(e -> -e.priority));
    }

    /**
     * Queue-nin ən yüksək öncelikli elementini çıxarır və qaytarır.
     * Əgər queue boşdursa, xəbərdarlıq mesajı çap edir və null qaytarır.
     * Əks halda, ilk elementi (queue.remove(0)) çıxarır və həmin elementin data hissəsini qaytarır.
     */
    public T delete() {
        if (isEmpty()) {
            System.out.println("PriorityQueue is empty.Can't delete");
            return null;
        }
        return queue.remove(0).data;
    }

    /**
     * Queue-nin ən yüksək öncelikli elementini çıxarmadan qaytarır.
     * Əgər queue boşdursa, xəbərdarlıq mesajı çap edir və null qaytarır.
     * Əks halda, ilk elementi (queue.get(0)) qaytarır.
     */
    public T peek() {
        if (isEmpty()) {
            System.out.println("PriorityQueue is empty.Nothing to peek");
            return null;
        }
        return queue.get(0).data;
    }

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.insert("Run", 1);
        priorityQueue.insert("stop", 2);
        priorityQueue.insert("dead", 3);
        System.out.println("Highest priority element: " + priorityQueue.peek());
        System.out.println("Deleted element: " + priorityQueue.delete());
        System.out.println("Highest priority element after delete: " + priorityQueue.peek());

        /**
         * Bu hissədə PriorityQueue<String> obyektini yaradır və ona string dəyərlər və onların önceliklərini əlavə edir.
         * Sonra isə peek() və delete() metodlarını istifadə edərək, queue-dən elementləri oxuyur və çıxarır.
         */
    }
}
