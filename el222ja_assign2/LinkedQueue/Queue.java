package Java2.el222ja_assign2.LinkedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Queue {
	
	   public int size();                    
	   public boolean isEmpty();               
	   public void enqueue(Object element); 
	   public Object dequeue();            
	   public Object first();                  
	   public Object last();                  
	   public String toString();        
	   public Iterator iterator();        
	}
