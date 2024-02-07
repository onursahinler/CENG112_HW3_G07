package Implementations;
import java.util.NoSuchElementException;
import Interfaces.IPriorityQueue;

public class PriorityQueue<T extends Comparable<? super T>> implements IPriorityQueue<T> {
	
	private SortedList<T> sortedList;
	
	public PriorityQueue() {
		sortedList = new SortedList<>();
	}
	
	public void enqueue(T newEntry) {
		sortedList.add(newEntry);
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Priority queue is empty.");
		}
		
		T front = sortedList.getEntry(1);
        sortedList.remove(front);
        return front;
	}

	public T getFront() {
		if (isEmpty()) {
			throw new NoSuchElementException("Priority queue is empty.");
		}
		
		return sortedList.getEntry(1);
	}

	public boolean isEmpty() {
		return sortedList.isEmpty();
	}

	public void clear() {
		sortedList.clear();
	}

	public int getSize() {
		return sortedList.getSize();
	}
	
	public T[] toArray() {
		return sortedList.toArray();
	}
}

