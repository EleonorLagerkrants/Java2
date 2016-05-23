package Java2.el222ja_assign2.LinkedQueue;

import java.util.Iterator;

public class QueueMain {

	public static void main(String[] args) {
		Linked_Queue q = new Linked_Queue();
		q.enqueue(9);
		q.enqueue(10);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(7);
		System.out.println("Dequeue: "+q.dequeue());
		
		System.out.println("Size: "+q.size());
		System.out.println("isEmpty: "+q.isEmpty());
		System.out.println("First: "+q.first());
		System.out.println("Last: "+q.last());
		System.out.println("Queue: "+q.toString());
		Iterator it = q.iterator();
		while (it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}

}
