package Java2.el222ja_assign3.count_words;

import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TreeWordSet implements WordSet {
	String[] bst;
	int pos = 0;
	private BST root;
	private BST parent;
	private StringBuilder sb = new StringBuilder();
	
	public TreeWordSet() {
	}

	@Override
	public Iterator iterator() {
		return new TreeWordIterator();
	}
	
	public String toString() {
		return root.print();
	}

	@Override
	public void add(Word word) {
		if(root == null) {
			root = new BST(word);
			parent = root;
		}
		else
			root.add(word);
	}

	@Override
	public boolean contains(Word word) {
		  if(root == null)
		return false;
		  else
			  return root.contains(word);
	}

	@Override
	public int size() {
		if (root == null)
		return 0;
		else
			return size(root.left) + 1 + size(root.right);
	}
	
	public int size(BST root) {
		if (root == null)
		return 0;
		else
			return size(root.left) + 1 + size(root.right);
	}
	
	public String[] inOrder(BST root) {
		bst = new String[size()];
		if(root != null) {
			for(int i=0; i<bst.length; i++) {
			inOrder(root.left);
			bst[i] = root.w + " ";
			pos++;
			inOrder(root.right);
			}
		}
		return bst;
	}
	
	public class BST {
		Word w;
		BST root;
		BST next;
		BST left = null;
		BST right = null;
		BST parent = null;
		
		BST(Word wo) {w = wo;}
		
		BST(Word wo, BST parent) {w = wo;}
		
		void add(Word word, BST parent) {
			if(word.compareTo(w)<0) {
				if(left==null) {
					left = new BST(word, parent);
				}
				else
					left.add(word, parent);
					
			}
			else if(word.compareTo(w)>0) {
				if(right==null)
					right = new BST(word, parent);
				else
					right.add(word, parent);
			}
		}
		
		void add(Word word) {
			if(word.compareTo(w)<0) {
				if(left==null) {
					left = new BST(word, root);
				}
				else
					left.add(word, root);
					
			}
			else if(word.compareTo(w)>0) {
				if(right==null)
					right = new BST(word, root);
				else
					right.add(word, root);
			}
		}
	
	boolean contains(Word word) {
		if(word.compareTo(w)<0) {
			if(left == null)
				return false;
			else
				return left.contains(word);
		}
		else if(word.compareTo(w)>0) {
			if(right == null)
				return false;
			else 
				return right.contains(word);
		}
		return true;
	}
	
	String print() {
		if(left!= null)
			left.print();
		sb.append(w.toString()+" ");
		if(right!=null)
			right.print();
		return sb.toString();
	}

}
	public class TreeWordIterator implements Iterator {
		private BST next;
		
		public TreeWordIterator() {
			next = root;
			if(next != null) {
				while(next.left != null) {
					next = next.left;
				}
			}
		}
		@Override
		public boolean hasNext() {
			return next!=null;
		}
		
		@Override
		public String next() {
			String[] a = inOrder(root);
			if(hasNext()) 
				return a[pos++];
			else
				throw new NoSuchElementException();
			}
		@Override
		public void remove() {
			throw new UnsupportedOperationException("The method remove() is not implemented");
			
		}
	}		
		
	public static void main(String[] args) {
		try{
			File file = new File("C:\\Temp\\words.txt");
			Scanner scan = new Scanner((file));
			TreeWordSet treeset = new TreeWordSet();
			String[] arr;
			while(scan.hasNext()) {
				String str = scan.nextLine();
				arr = str.split(" ");
				for(int i=0; i<arr.length; i++) {
					Word word = new Word(arr[i]);
					treeset.add(word);
				}
			}
		System.out.println("Treewordset size: "+treeset.size());
		System.out.println(treeset.toString());
		scan.close();
		Iterator<Word> it = treeset.iterator();
		while(it.hasNext())
			System.out.print(it.next()+", ");
		
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
