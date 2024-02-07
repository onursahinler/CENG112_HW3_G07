package Interfaces;

public interface IPriorityQueue<T> {
	public void enqueue(T newEntry);
	public T dequeue();
	public T getFront();
	public boolean isEmpty();
	public void clear();
	public int getSize();
	public T[] toArray();
}
