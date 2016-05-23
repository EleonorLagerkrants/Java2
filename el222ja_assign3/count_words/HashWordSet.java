package Java2.el222ja_assign3.count_words;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HashWordSet implements WordSet {
	private Node[] buckets;
	private int size;
	
	public HashWordSet() {
		buckets = new Node[10];
		size = 0;
	}
	
	private class Node {
		private Word word;
		private Node next;
		
		public Node(Word word) {
			this.word = word;
		}
		public String toString() {
			return word.toString();
		}
	}
	    
	@Override
	public Iterator iterator() {
		return new HashWordIterator();
	}

	@Override
	public void add(Word word) {
			int k = word.hashCode();
			if(k < 0)
				k = -k;
			int h = k % buckets.length;
			Node node = buckets[h];
			while(node!=null) {
				if(node.word.equals(word))
					return;
				else
					node = node.next;
			}
			
			node = new Node(word);
			node.next = buckets[h];
			buckets[h] = node;
			size++;
	
			if (size == buckets.length) {
				rehash();
			}
		}
	
		
	@Override
	public boolean contains(Word word) {
		int k = word.hashCode();
		if(k<0)
			k = -k;
		int h = k % buckets.length;
		Node node = buckets[h];
		while(node != null) {
			if(node.word.equals(word))
				return true;
			else
				node = node.next;
		}	
		return false;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for(int i = 0; i < buckets.length; i++)
			{
				if(buckets[i] != null)
				{
					Node n = buckets[i];
					while(n != null)
					{
						sb.append(n.word.toString());
						sb.append(", ");
						n = n.next;
					}
				}
			}
			sb.delete(sb.length()-2, sb.length());
			sb.append("]");
			
			return sb.toString();		
		}
	
	private void rehash() {
		Node[] temp = buckets;
		buckets = new Node[2*temp.length];
		size = 0;
		for(Node n : temp) {
			if(n == null)
				continue;
			while(n!=null) {
				add(n.word);
				n = n.next;
			}
		}
	}
	public class HashWordIterator implements Iterator {
			private int index;
			private Node current;
			private int bucketLength;
			
			public HashWordIterator() {
				index = 0;
				current = buckets[0];
				bucketLength = buckets.length;
			}
			
			public boolean hasNext() {
				if(current.next == null && index == bucketLength)
					return false;
				if(current.next != null)
					return true;
				else
				{
					for(int i = index; i < bucketLength; i++)
					{
						Node n = buckets[i];
						if(n != null)
							return true;
					}
				}
				return false;
			}
			public Word next() {
				if(current.next != null)
				{
					current = current.next;
					return current.word;
				}
				else
				{
					for(int i = index; i < bucketLength-1; i++)
					{
						index++;
						if(buckets[i] != null)
						{
							current = buckets[i];
							return current.word;
						}
					}
				}
				throw new NoSuchElementException();	
		
			}
		 
		public void remove() {
			throw new UnsupportedOperationException("The method remove () is not implemented");
		}
	}
	
	public static void main(String[] args) {
		try{
			File file = new File("C:\\Temp\\words.txt");
			Scanner scan = new Scanner((file));
			HashWordSet hashset = new HashWordSet();
			String[] arr;
			while(scan.hasNext()) {
				String str = scan.nextLine();
				arr = str.split(" ");
				for(int i=0; i<arr.length; i++) {
					Word word = new Word(arr[i]);
					hashset.add(word);
				}
			}
		System.out.println("Hashset size: "+hashset.size());
		System.out.println(hashset.toString());
		scan.close();
		Iterator<Word> it = hashset.iterator();
		while(it.hasNext())
			System.out.print(it.next()+", ");
		
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
}