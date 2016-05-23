package Java2.el222ja_assign2.LinkedQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class Linked_QueueTester {
	private static final Object Integer = null;
	private static int n = 10; //Change number for how many elements to add to Queue when testing enqueue()
		
	@Test
	public void testQueuing() {
		Linked_Queue a = new Linked_Queue();
		assertTrue("Constructor creates empty queue", a.size()==0);
		
		for(int i=0; i<n; i++ ) {
			a.enqueue(new Integer(i));
		}
		if(Integer instanceof Object) {
		assertTrue("Enqueue adds item to the queue", a.size()==n);
		
		Integer n = (Integer)(a.dequeue());
		assertTrue("Dequeue returns the first element",n.equals(new Integer(0)));
		assertTrue("Dequeue removes the first element",a.size()==n-1);
		
		n= (Integer)(a.first());
		assertTrue("First returns the first element",n.equals(new Integer(1)));
		assertTrue("First does not remove the first element",a.size()==n-1);
		
		n= (Integer)(a.last());
		assertTrue("Last returns the last element",n.equals(new Integer(n-1)));
		assertTrue("Last does not remove last element",a.size()==n-1);
		}
	}
	
	@Test
	public void testToString() {
		Linked_Queue b = new Linked_Queue();

		String desc = b.toString();
		assertTrue("Empty queue does not return a null toString() description", desc != null);
		System.out.println("toString(): " + desc);

		for(int i=1; i <= 10; i++) {
			b.enqueue(new Integer(i));
		}

		desc = b.toString();
		assertTrue("Non-empty queue does not return a null toString() description", desc != null);
		System.out.println("toString(): " + desc);
	}
	@Test
	public void testisEmpty() {
		Linked_Queue c = new Linked_Queue();
		assertTrue("Queue is empty",c.isEmpty());
		
		c.enqueue(9);
		assertTrue("isEmpty not true when Queue is not empty",!c.isEmpty());
		
		c.dequeue();
		assertTrue("isEmpty true when queue is empty, even after dequeue",c.isEmpty());
	}

}
