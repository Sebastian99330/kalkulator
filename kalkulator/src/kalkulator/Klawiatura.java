package kalkulator;

import java.util.*;	//po scanner i po string tokenizer
//import org.apache.commons.lang3.math.NumberUtils;

public class Klawiatura implements Obsluguj {

	@Override
	public void obsluguj() {
		// TODO Auto-generated method stub
		
		System.out.println("Podaj ci¹g znaków do obliczenia: ");
		Scanner keyboard = new Scanner(System.in);
		String linijka = keyboard.nextLine();
		System.out.println("Wczytany tekst: " + linijka);
		
		StringTokenizer st = new StringTokenizer(linijka, "+-*/", true);
		//char operator=' ';
		String pom=null;
		double liczba1=0, liczba2=0;
		char operator=' ';
		// w pêtli dopóki s¹ jeszcze tokeny (metoda hasMoreTokens()
		//NumberUtils.toInt(nextToken);

		Scanner sc = new Scanner(linijka);	//sc do rozdzielania linijki na liczby i operatory
		
		//double price1 = sc.nextDouble(), 
		//while(st.hasMoreTokens()) {
			pom=st.nextToken();		
			Scanner sc2 = new Scanner(pom);	//sc2 do zmiany typu ze stringa na double
			liczba1=sc2.nextDouble();
			
			pom=st.nextToken();
			operator=pom.charAt(0);
			
			pom=st.nextToken();		
			sc2 = new Scanner(pom);	//sc2 do zmiany typu ze stringa na double
			liczba2=sc2.nextDouble();
		//}
		System.out.println("Liczba1: " + liczba1);
		System.out.println("Liczba1: " + liczba2);
		double wynik = 0;
		if(operator=='+'){wynik=liczba1+liczba2;}
		if(operator=='-'){wynik=liczba1-liczba2;}
		if(operator=='*'){wynik=liczba1*liczba2;}
		if(operator=='/'){wynik=liczba1/liczba2;}
		System.out.println("Wynik to: "+wynik);
	}
	
}