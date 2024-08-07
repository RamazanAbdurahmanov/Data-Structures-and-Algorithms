package stack;

//Bu, generik bir sinifdir. T hər hansı bir tip ola bilər və bu, stack-də saxlanacaq elementlərin tipini təyin edir.
public class Stack<T> {
    private int top;// Üst elementin indeksini izləmək üçün
    private final int capacity = 100; // Stack-in maksimum ölçüsü
    private Object[] stack; // Stack elementlərini saxlamaq üçün massiv

    /**
     * top - Stack-dəki ən üst elementin indeksini izləyir. Başlanğıcda -1 olaraq təyin edilir ki, bu da stack-in boş olduğunu göstərir.
     * capacity - Stack-in maksimum tutumudur (burada 100 olaraq təyin edilib).
     * stack - Elementləri saxlamaq üçün massivdir.
     */

    // Bu konstruktor stack-in başlanğıc vəziyyətini təyin edir.
    public Stack() {
        top = -1;
        stack = new Object[capacity];
    }

    //  Stack-in boş olub-olmadığını yoxlayır.
    public boolean isEmpty() {
        return top == -1;
    }

    //Stack-ə yeni element əlavə edir.Əgər stack doludursa, xəbərdarlıq mesajı çap edir. Əks halda, yeni elementi əlavə edir və top dəyişənini artırır.
    public void push(T data) {
        if (top == capacity - 1) {
            System.out.println("Stack doludur,Əlavə etməyə yer yoxdur");
            return;
        }
        stack[++top] = data;
    }

    // Stack-in üstündəki elementi çıxarır və qaytarır.Əgər stack boşdursa, xəbərdarlıq mesajı çap edir və null qaytarır. Əks halda, üst elementi çıxarır və top dəyişənini azaldır.
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack boşdur,əlavə edə bilərsiz");
            return null;
        }
        return (T) stack[top--];
    }

    // Stack-in üstündəki elementi çıxarmadan qaytarır.Əgər stack boşdursa, xəbərdarlıq mesajı çap edir və null qaytarır. Əks halda, üst elementi qaytarır.
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack boşdur");
        }
        return (T) stack[top];
    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(23);
        myStack.push(16);
        myStack.push(25);
        myStack.push(45);
        System.out.println("En son elave edilen element :" + myStack.peek());
        System.out.println("Atilan element :" + myStack.pop());
        System.out.println("Atilandan sonraki element :" + myStack.peek());

        /**
         * Bu hissədə Stack<Integer> obyektini yaradır və ona integer dəyərlər əlavə edir. Sonra isə peek() və pop() metodlarını istifadə edərək, stack-dən elementləri oxuyur və çıxarır.
         */
    }


}
