package Implementations;
import java.util.Arrays;
import java.util.EmptyStackException;

import Interfaces.IStack;
public class ArrayStack<T> implements IStack<T> {

    private T[] stackArray;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 50;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stackArray = tempStack;
        topIndex = -1;
    }

    public void push(T newEntry) {
        ensureCapacity();
        topIndex++;
        stackArray[topIndex] = newEntry;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T top = stackArray[topIndex];
        stackArray[topIndex] = null;
        topIndex--;
        return top;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stackArray[topIndex];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    private void ensureCapacity() {
        if (topIndex == stackArray.length - 1) {
            int newCapacity = 2 * stackArray.length;
            stackArray = Arrays.copyOf(stackArray, newCapacity);
        }
    }
}

