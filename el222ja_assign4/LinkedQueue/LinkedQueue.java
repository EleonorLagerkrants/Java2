package Java2.el222ja_assign4.LinkedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	// Creates a empty queue
	public LinkedQueue() {
		size = 0;
		head = null;
		tail = null;
	}
	
	//Returns the current size of the queue
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}
	
	//Adds element to the end of the queue
	@Override
	public void enqueue(T value) {
		if(head==null) {
			head = new Node<T>(value);
			tail=head;
		}
		else {
			tail.next = new Node<T>(value);
			tail = tail.next;
		}
		size++;
	}
	
	// Removes element from head of the queue
	@Override
	public T dequeue() throws NoSuchElementException {
		if(head==null) {
			throw new NoSuchElementException ();
		}
		else {
			T t = head.val;
			head=head.next;
			size--;
			if(size==0) {
				tail=null;
			}
		return t;
		}
	}
	
	// Returns the first element of the queue
	@Override
	public T first() throws NoSuchElementException {
		if(head==null) {
			throw new NoSuchElementException();
		}
		else {
			return head.val;
		}
	}
	
	// Returns the last element of the queue
	@Override
	public T last() throws NoSuchElementException {
		if(tail==null) {
			throw new NoSuchElementException();
		}
		else {
		return tail.val;
		}
	}
	
	public String toString() {
		Iterator it = iterator();
		StringBuilder str = new StringBuilder();
		while(it.hasNext()) {
			str.append(" "+it.next());
		}
		String string = str.toString();
		return string;
	}

	@Override
	public Iterator iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator {
		Node<T> node = head;

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public Node<T> next() {
			Node<T> n = node;
			node = node.next;
			return n;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	private static class Node<T> {
		private T val;
		private Node<T> next;
		
		Node(T value) {
			val = value;
		}
		
		public String toString() {
			return val.toString();
		}
	}

}
