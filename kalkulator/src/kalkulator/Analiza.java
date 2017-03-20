package kalkulator;

import java.util.Scanner;
import java.util.StringTokenizer;


public class Analiza {	//Analiza podanej linijki
	
	
	public double Operuj(String linijka){	//operuj na przyj�tej linijce-dzia�aniu (np 3*3), tzn 
		//rozbierz go na cz�ci pierwsze (dwie liczby i operator) i oblicz
		
		
		StringTokenizer st = new StringTokenizer(linijka, "+-*/", true);	//za pomoc� st potniemy linijk� na kawa�ki
		
		//string pom pomocniczy, b�dzie przyjmowa� kolejne cz�ci stringa linijka. 
		//np �eby liczb� 2 da� do zmiennej na liczb�, + do operatora itd
		String pom=null;	
		double liczba1=0, liczba2=0;
		char operator=' ';
		
		///// w p�tli dop�ki s� jeszcze tokeny (metoda hasMoreTokens()) //to na wypadek przyjmowania d�u�szych �a�cuch�w znakowych
		//// ni� np. tylko 2+2 itp
		/////NumberUtils.toInt(nextToken);

		
		//while(st.hasMoreTokens()) {	//p�tla gdyby�my przyjmowali 2+2+2-7 itd
			pom=st.nextToken();	//dajemy do pom zawarto�� linijki do pierwszego znaku + albo - albo * albo /
			Scanner sc2 = new Scanner(pom);	//sc2 do zmiany typu ze stringa na double
			liczba1=sc2.nextDouble();
			
			pom=st.nextToken();	//teraz do pom leci ten operator + - * /
			operator=pom.charAt(0);
			
			pom=st.nextToken();		
			sc2 = new Scanner(pom);
			liczba2=sc2.nextDouble();
		
		System.out.print("Liczba1: " + liczba1);
		System.out.print(" , Liczba2: " + liczba2);
		double wynik = 0;
		if(operator=='+'){wynik=liczba1+liczba2; System.out.println(" Dodajemy.");}
		else if(operator=='-'){wynik=liczba1-liczba2; System.out.println(" Odejmujemy.");}
		else if(operator=='*'){wynik=liczba1*liczba2; System.out.println(" Mno�ymy.");}
		else if(operator=='/'){wynik=liczba1/liczba2; System.out.println(" Dzielimy.");}
		System.out.println("Wynik: "+liczba1+" "+operator+" "+liczba2+" = "+wynik+"\n");
		return wynik;
	}
}
