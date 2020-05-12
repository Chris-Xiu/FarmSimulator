package game;
import java.util.*;
import java.util.Scanner;

public class TestClass {	
	public static void main(String[] args) {
		Scanner stringInput = new Scanner(System.in);
		Scanner intInput = new Scanner(System.in);
		
		System.out.println("Enter a string:");
		String string1 = stringInput.nextLine();
		
		System.out.println("Enter a number:");
		int numebr1 = intInput.nextInt();
		
		System.out.println("Enter a string:");
		String string2 = stringInput.nextLine();
		
		System.out.println("Enter a number:");
		int numebr2 = intInput.nextInt();
		
		System.out.println(string1);
		System.out.println(string2);
		System.out.println(numebr1);
		System.out.println(numebr2);
	}
}