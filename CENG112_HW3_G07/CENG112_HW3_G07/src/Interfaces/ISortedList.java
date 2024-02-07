package Interfaces;

public interface ISortedList<T> {
	 public void add(T newEntry);
	 public boolean remove(T anEntry);
	 public int getPosition(T anEntry);
	 public boolean isEmpty();
	 public void clear();
	 public boolean contains(T anEntry);
	 public T getEntry(int position);
	 public int getSize();
	 public T peek();
	 public T[] toArray();
}
