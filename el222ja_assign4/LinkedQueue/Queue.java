package Java2.el222ja_assign4.LinkedQueue;

import java.util.Iterator;

public interface Queue<T> {
	public int size();                     // current queue size 
	
	public boolean isEmpty();              // true if queue is empty 
	
	public void enqueue(T value);   // add element at end of queue 
	
	public Object dequeue();               // return and remove first element. 
	
	public Object first();                 // return (without removing) first element 
	
	public Object last();                  // return (without removing) last element 
	
	public String toString();              // return a string representation of the queue content
	
	public Iterator iterator();            // element iterator
	}
