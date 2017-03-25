package kalkulator;

import java.util.Scanner;
//import org.apache.commons.lang3.math.NumberUtils;	//czemu nie dzia�a?

/*
 * Klasa klawiatura - wczytuje od u�ytkownika lini�-dzia�anie (np 3*4) i przekazuje j� do
 * "analizy" czyli do klasy kt�ra odpowiednio zbada ten napis i obliczy ��dane dzia�anie i zwr�ci wynik
*/
public class Klawiatura extends AnalizujDzialanie implements WczytywanieDzialania {
	
	
	
	@Override	//przys�oni�te bo klasa Plik wygeneruje t� lini�-dzia�anie inaczej ni� ta Klawiatura
	public void wczytajDzialanie() {
		// TODO Auto-generated method stub
		boolean czyCzytamy=true;	//jak u�ytkownik wpisze "koniec" to damy na false
		Scanner keyboard = new Scanner(System.in);
		while(czyCzytamy){
			
			System.out.println("Podaj ci�g znak�w do obliczenia (slowo \"koniec\" konczy wczytywanie): ");
			String linijka = keyboard.nextLine();
			System.out.println("Wczytany tekst: " + linijka);
			if(linijka.equals("koniec")){
				czyCzytamy=false;
				continue;
			}
			double wynik=0;
			wynik=Operuj(linijka);	//przekazujemy linijk� do obliczenia  do metody operuj z klasy bazowej Analiza
		}
		keyboard.close();
		
	}
	
}