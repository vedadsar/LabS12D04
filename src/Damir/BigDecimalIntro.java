package Damir;
import java.math.BigDecimal;
import java.util.Scanner;


public class BigDecimalIntro {
	
	public static void main(String[] args) {
		BigDecimal dec;
		Scanner sc = new Scanner(System.in);
		
		String decimalString = sc.nextLine();
		
		dec = new BigDecimal(decimalString);
		dec = dec.multiply(new BigDecimal(2));
		System.out.println(dec.toString());
	}
}
