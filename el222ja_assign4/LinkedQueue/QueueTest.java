package Java2.el222ja_assign4.LinkedQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {
	private static final Object Integer = null;
	int n = 100;
	
	@Test
	public void testQueing() {
		LinkedQueue<Integer> g = new LinkedQueue<Integer>();
		LinkedQueue<String> s = new LinkedQueue<String>();
		LinkedQueue<Object> o = new LinkedQueue<Object>();
		assertTrue("Constructor creates empty queue", g.size() == 0);
		assertTrue(g.isEmpty());
		assertTrue("Constructor creates empty queue", s.size() == 0);
		assertTrue(s.isEmpty());
		assertTrue("Constructor creates empty queue", o.size() == 0);
		assertTrue(o.isEmpty());
		
		String str = "Hej";
		String str1 = "Alla";
		String str2 = "Bara";
		s.enqueue(str);
		assertTrue("Enqueu adds item to the queue", s.size()==1);
		s.enqueue(str1);
		s.enqueue(str2);
		
		assertTrue("First returns the first element", s.first()==str);
		assertTrue("First does no remove the first element", s.size()==3);
		
		assertTrue("Last returns the last element", s.last()==str2);
		assertTrue("Last does not remove the last element", s.size()==3);
		s.dequeue();
		assertTrue("Dequeue removes the first element", s.size()==2);
		
		for(int i=0; i<n; i++) {
			o.enqueue(new Integer(i));
		}
		if(Integer instanceof Object) {
			assertTrue("Enqueue adds item to the queue", o.size()==n);
			
			Integer p = (Integer)(o.dequeue());
			assertTrue("Dequeue returns the first element",p.equals(new Integer(0)));
			assertTrue("Dequeue removes the first element",o.size()==n-1);
			
			Integer f = (Integer)(o.first());
			assertTrue("First returns the first element",f.equals(new Integer(1)));
			assertTrue("First does not remove the first element",o.size()==n-1);
			
			Integer h = (Integer) (o.last());
			assertTrue("Last returns the last element",h.equals(new Integer(n-1)));
			assertTrue("Last does not remove last element",o.size()==n-1);
			}

		for(int i=0; i<n; i++ ) {
			g.enqueue(i); 
		}
		assertTrue("Enqueue adds item to the queue", g.size()==n);
		
		Integer m = g.dequeue();
		assertTrue("Dequeue returns the first element",m.equals(0));
		assertTrue("Dequeue removes the first element",g.size()==n-1);
		
		Integer c = g.first();
		assertTrue("First returns the first element",c.equals(1));
		assertTrue("First does not remove the first element",g.size()==n-1);
		
		Integer h = g.last();
		assertTrue("Last returns the last element",h.equals(n-1));
		assertTrue("Last does not remove last element",g.size()==n-1);
	}
	@Test
	public void testToString() {
		LinkedQueue<Integer> b = new LinkedQueue<Integer>();

		String desc = b.toString();
		assertTrue("Empty queue does not return a null toString() description", desc != null);
		System.out.println("toString(): " + desc);

		for(int i=1; i <= 10; i++) {
			b.enqueue(i);
		}

		desc = b.toString();
		assertTrue("Non-empty queue does not return a null toString() description", desc != null);
		System.out.println("toString(): " + desc);
	}
	@Test
	public void testisEmpty() {
		LinkedQueue<Integer> c = new LinkedQueue<Integer>();
		assertTrue("Queue is empty",c.isEmpty());
		
		c.enqueue(9);
		assertTrue("isEmpty not true when Queue is not empty",!c.isEmpty());
		
		c.dequeue();
		assertTrue("isEmpty true when queue is empty, even after dequeue",c.isEmpty());
	}
}