package kalkulator;

import java.util.Scanner;

/**
 * Main menu which chooses mode
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Witaj");
		Obsluguj rozmawiaj;	//zmienna od rozmawiania z u�ytkownikiem
		//Obs�uguj to klasa bazowa od Klawiatury i Pliku. Wykorzystamy polimorfizm
		
		
		System.out.println("Podaj czy chcesz wczytywa� dane z pliku czy z klawiatury: ");
		System.out.println("1 - klawiatura, 2 - plik, 3 - koniec pracy programu");

		Scanner keyboard = new Scanner(System.in);
		int wybor;
		while((wybor=keyboard.nextInt())!=1 && wybor != 2 && wybor!=3){	//kontrola poprawno�ci danych, wyrzuci blad przy danych
			//innych ni� 1, 2 albo 3
			keyboard.nextLine();
			System.out.println("Bledne dane! Nie podales 1,2 ani 3. Jeszcze raz!");			
		}
		if(wybor==1){
			System.out.println("Poda�e� 1. Wczytujemy z klawiatury");
			rozmawiaj = new Klawiatura();
			rozmawiaj.obsluguj();	//wywo�a metod� obs�uguj dla Klawiatury, czyli zacznie wczytywanie klawiatury z konsoli

		}
		if(wybor==2){
			System.out.println("PODA�E� 2. Wczytujemy z pliku");
			rozmawiaj = new Plik();
			rozmawiaj.obsluguj(); //wywo�a metod� obs�uguj dla Pliku, czyli zacznie wczytywanie z pliku
			
		}
		if(wybor==3){
			System.out.println("Poda�e� 3.");
			
		}
		
		System.out.println("Koniec pracy programu! Pozdrawiam.");

		return;
	}
}