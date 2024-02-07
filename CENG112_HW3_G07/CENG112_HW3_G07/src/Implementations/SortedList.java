package Implementations;
import java.util.Comparator;
import Interfaces.ISortedList;

public class SortedList<T extends Comparable<? super T>> implements ISortedList<T> {
	public Comparator<T> comparator;
	private LinkedList<T> list;
	
	public SortedList(Comparator<T> comparator) {
        this.comparator = comparator;
        this.list = new LinkedList<>();
    }
	public SortedList() {
		list = new LinkedList<>();
	}
	
	public void add(T newEntry) {
		int newPosition = Math.abs(getPosition(newEntry));
		list.add(newPosition, newEntry);
	}

	public boolean remove(T anEntry) {
		boolean result = false;
		int position = getPosition(anEntry);
		if(position>0) {
			list.remove(position);
			result = true;
		}
		return result;
	}

	public int getPosition(T anEntry) {
		int position = 1;
		int length = list.getLength();
		
		while((position<=length) && (list.getEntry(position).compareTo(anEntry)>0)) {
			position++;
		}
		if((position>length) || (anEntry.compareTo(list.getEntry(position)) != 0)) {
			position=-position;
		}
		return position;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void clear() {
		list.clear();
		
	}

	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	}

	public T getEntry(int position) {
		return list.getEntry(position);
	}

	public int getSize() {
		return list.getLength();
	}

	public T peek() {
		return list.peek();
	}

	public T[] toArray() {
		return list.toArray();
	}

}
