package Java2.el222ja_assign1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class PrintJavaMain {
	
	private static void visitSub(File directory) throws IOException {
		if(directory.isFile()) {
			if(directory.getName().endsWith(".java")) {
				countLines(directory);
				printAllJavaFiles(directory);
			}
		}	
		if(directory.isDirectory()){
			File[] subs = directory.listFiles();
			for(File f : subs)
				visitSub(f); }
				}
	
	private static int count=0;
	public static void printAllJavaFiles(File directory) throws IOException {
		StringBuffer buf = new StringBuffer();
		buf.append(" ");
		System.out.println((++count)+buf.toString()+directory.getName()+". Rader: "+countLines(directory));
		}
	
	public static int countLines(File startDir) throws IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader(startDir));
		lnr.skip(Long.MAX_VALUE);
		int line = lnr.getLineNumber();
		lnr.close();
		return line;
	}

	public static void main(String[] args) {
		File startDir = new File("C:\\Users\\Eleonor\\workspace\\1DV006\\src");
		if(startDir.exists()) {
			System.out.println("Start "+startDir);
			try {
				visitSub(startDir);
			} catch (Exception e) {
				e.printStackTrace();
			} }
		else {
			System.out.println("Can't find directory "+startDir);
		}

	}

}