package by.gsu.lab4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Runner {
	private static final String FILE_NAME = "file.out";

	public static void main(final String[] args) throws IOException, ClassNotFoundException {
		try {
			final Scanner scan = new Scanner(System.in);
			System.out.println("Enter information about explorer.");
			System.out.print("Name: ");
			final String name = scan.nextLine();
			System.out.print("Position: ");
			final String position = scan.nextLine();
			System.out.println("Category: ");
			final int category = scan.nextInt();
			scan.close();
			final Explorer explorerWritten = new Explorer(name, category, position);
			final FileOutputStream fos = new FileOutputStream(Runner.FILE_NAME);
			final ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(explorerWritten);
			oos.flush();
			oos.close();
			final FileInputStream fis = new FileInputStream(Runner.FILE_NAME);
			final ObjectInputStream ois = new ObjectInputStream(fis);
			final Explorer explorerRead = (Explorer) ois.readObject();
			ois.close();
			System.out.println(explorerRead.toString());
		} catch (final ExplorerException ex1) {
			System.out.println(ex1.getMessage());
			System.out.println(ex1.getNumber());
			System.out.println(ex1.getLine());
		} catch (final IOException ex2) {
			System.out.println(ex2.getMessage());
		} catch (final ClassNotFoundException ex3) {
			System.out.println(ex3.getMessage());
		}

	}

}
