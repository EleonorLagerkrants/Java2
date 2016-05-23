package Java2.el222ja_assign2.LinkedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Creates a Linked Queue that implements the interface Queue. 
 * 
 * @author Eleonor Lagerkrants
 * @since 2014-02-11
 */
public class Linked_Queue implements Queue {
	private Node head;
	private Node tail;
	private int size;
	
	/**
	 * Creates a Linked Queue
	 */
	public Linked_Queue() {
		size = 0;
		head = null;
		tail = null;
	}
	/**
	 * Get the current size of the Linked Queue
	 * @return the size of the Linked Queue
	 */
	@Override
	public int size() {
		return size;
	}
	/**
	 * Check if the Linked Queue is Empty
	 * @return true if Linked Queue is Empty
	 */
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	/**
	 * Add element at end of queue
	 * @param element to be added
	 */
	@Override
	public void enqueue(Object element) {
		if(head==null) {
			head = new Node(element);
			tail=head;
		}
		else {
			tail.next = new Node(element);
			tail = tail.next;
		}
		size++;
		
	}
	/**
	 * Remove element from front of Queue
	 * @return removed element
	 * @throws NoSuchElementException
	 */
	@Override
	public Object dequeue()	throws NoSuchElementException {
		if(head==null) {
			throw new NoSuchElementException ();
		}
		else {
			Object o = head;
			head=head.next;
			size--;
			if(size==0) {
				tail=null;
			}	
		return o;
		}
	}
	/**
	 * Return the first element of the Queue
	 * @return element that is first in Queue
	 * @throws NoSuchElementException 
	 */
	@Override
	public Object first() throws NoSuchElementException {
		if(head==null) {
			throw new NoSuchElementException();
		}
		else {
			return head;
		}
	}
	/**
	 * Return the last element of the Queue
	 * @return the last element of the Queue
	 * @throws NoSuchElementException
	 */
	@Override
	public Object last() throws NoSuchElementException {
		if(tail==null) {
			throw new NoSuchElementException();
		}
		else {
		return tail;
		}
	}
	/**
	 *A method that enables the Linked Queue to be returned as a string
	 *@return the string that containes the Linked Queue
	 */
	public String toString() {
		Iterator it = iterator();
		StringBuilder str = new StringBuilder();
		while(it.hasNext()) {
			str.append(" "+it.next());
		}
		String string = str.toString();
		return string;
	}
	/**
	 * Iterator that returns the Iterator from the class QueueIterator
	 * @return QueueIterator
	 */
	@Override
	public Iterator iterator() {
		return new QueueIterator();
	}
	/**
	 * An iterator over the Linked Queue. Generates the elements of the Queue.
	 * @author Eleonor Lagerkrants
	 * @since 2014-02-11
	 */
	private class QueueIterator implements Iterator {
		Node node = head;
		/**
		 * Returns true if the iterator has more elements.
		 * @return true if the iterator has more elements
		 */
		@Override
		public boolean hasNext() {
			return node!=null;
		}
		/**
		 * Returns the next element in the iteration
		 * @return the next element in the iteration
		 */
		@Override
		public Object next() {
				Node n = node;
				node = node.next;
				return n;
		}
		/**
		 * Removes from the underlying collection the last element returned by this iterator.
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	/**
	 * Creates an object Node
	 * @author Eleonor Lagerkrants
	 * @since 2014-02-11
	 */
	private class Node {
		private Object value;
		private Node next;
		
		/**
		 * Creates an Node with the value of the element
		 * @param element
		 */
		Node(Object element) {
			value = element;
		}
		/**
		 * Return the Node as a string
		 * @return the Node as a string
		 */
		public String toString() {
			return value.toString();
		}
	}
}