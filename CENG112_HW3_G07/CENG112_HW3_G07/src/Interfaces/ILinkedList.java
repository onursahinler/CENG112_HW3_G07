package Interfaces;

public interface ILinkedList<T> {
	public void add(T newEntry);
	public void add(int newPosition, T newEntry);
	public T remove(int givenPosition);
	public T[] toArray();
	public T replace(int givenPosition, T newEntry);
	public T getEntry(int givenPosition);
	public boolean contains(T anEntry);
	public boolean isEmpty();
	public T peek();
	public int getLength();
	public void clear();
	public void initializeDataFields();
}
