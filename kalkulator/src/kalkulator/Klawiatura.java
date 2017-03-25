package kalkulator;

import java.util.Scanner;
//import org.apache.commons.lang3.math.NumberUtils;	//czemu nie dzia³a?

/*
 * Klasa klawiatura - wczytuje od u¿ytkownika liniê-dzia³anie (np 3*4) i przekazuje j¹ do
 * "analizy" czyli do klasy która odpowiednio zbada ten napis i obliczy ¿¹dane dzia³anie i zwróci wynik
*/
public class Klawiatura extends AnalizujDzialanie implements WczytywanieDzialania {
	
	
	
	@Override	//przys³oniête bo klasa Plik wygeneruje t¹ liniê-dzia³anie inaczej ni¿ ta Klawiatura
	public void wczytajDzialanie() {
		// TODO Auto-generated method stub
		boolean czyCzytamy=true;	//jak u¿ytkownik wpisze "koniec" to damy na false
		Scanner keyboard = new Scanner(System.in);
		while(czyCzytamy){
			
			System.out.println("Podaj ci¹g znaków do obliczenia (slowo \"koniec\" konczy wczytywanie): ");
			String linijka = keyboard.nextLine();
			System.out.println("Wczytany tekst: " + linijka);
			if(linijka.equals("koniec")){
				czyCzytamy=false;
				continue;
			}
			double wynik=0;
			wynik=Operuj(linijka);	//przekazujemy linijkê do obliczenia  do metody operuj z klasy bazowej Analiza
		}
		keyboard.close();
		
	}
	
}