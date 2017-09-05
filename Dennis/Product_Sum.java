/*
Given two integers a and b. Write a program to find the number of digits in the product of these two integers.

Input:
First line contains an integer T denoting number of test cases. The next T lines contains 2 space separated integers a and b each.


Output:
For each test case print the number of digits in the product of the two numbers.

Constraints:
1<=T<=10^5
-10^5<=a,b<=10^5

Example:
Input: 
1 
12 4 
-24 33 
Output: 
2 
3
*/

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Product_Sum {
		
	// Method that takes two int values, finds the sum and then returns the number of digits.
	public static int calcProductLength(int a, int b) {
		int s = a*b;
		if (s < 0) { // this if statment accounts for negative numbers so the '-' sign is not counted.
			s = s * (-1); 
		}
		int length = String.valueOf(s).length(); //Stores the length of the product of a and b as int length
		return length;
	}
	
	// Method that reads a file of test cases
	private static void readFile(File fin) throws IOException{
		int a, b, l;
		int numOfTestCase = 0;
		int numOfTestCaseComplete = 0;
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		while ((line = br.readLine()) != null) {
			Scanner scanner = new Scanner(line);
			// this if statement only runs for line 1 and reads the number of test cases in the file. 
			if (scanner.hasNext() && numOfTestCase == 0) {
				int temp = scanner.nextInt();
				if (temp >= 1 && temp <= 100000) {
					numOfTestCase = temp;
				} else {
					System.out.println("number given for T falls outside the expected constraints of 1 <= T <= 10^5");
					scanner.close();
					return;
				}
			// this if statement runs for all test cases and prints the length of the sum of the test case to the console. 
			} else if (numOfTestCase != numOfTestCaseComplete) {
				
				int tempA = scanner.nextInt();
				int tempB = scanner.nextInt();
				if (tempA >= -100000) {
					a = tempA;
					if (tempB <= 100000) {
						b = tempB;
					} else {
						System.out.println("number given for 'b' falls outside the constraints of b <= 10^5");
						scanner.close();
						return;
					}
				} else {
					System.out.println("number given for 'a' falls outside the constraints of a >= -10^5");
					scanner.close();
					return;
				}
				l = calcProductLength(a, b);
				System.out.println(l);
				numOfTestCaseComplete ++;
			}
			scanner.close();
		}
		br.close();
	}

	
	public static void main (String [] args) throws IOException {	
		File dir = new File(".");
		File fin = new File(dir.getCanonicalPath() + File.separator + "Dennis/Product_Sum_testcase.txt");		 
		readFile(fin);		
	}
}