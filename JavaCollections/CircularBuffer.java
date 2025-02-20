import java.util.Arrays;

public class CircularBuffer {
    private int[] buffer;
    private int head = 0, tail = 0, size = 0, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    public void enqueue(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; // Overwrite oldest element
        }
    }

    public int dequeue() {
        if (size == 0) throw new RuntimeException("Buffer is empty");
        int value = buffer[head];
        head = (head + 1) % capacity;
        size--;
        return value;
    }

    public int[] getBufferContents() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(head + i) % capacity];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.enqueue(4); // Overwrites 1

        System.out.println("Buffer: " + Arrays.toString(buffer.getBufferContents())); // Output: [2, 3, 4]
    }
}

