package kalkulator;

import java.util.Scanner;	//po scanner

/**
 * Main menu which chooses mode
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Siema");
		Obsluguj gadaj;	//Obs³uguj to klasa bazowa od Klawiatury i Pliku
		
		
		System.out.println("Podaj czy chcesz wczytywaæ dane z pliku czy z klawiatury: ");
		System.out.println("1 - klawiatura, 2 - plik, 3 - koniec pracy programu");

		Scanner keyboard = new Scanner(System.in);
		int wybor;
		//keyboard.nextLine();
		while((wybor=keyboard.nextInt())!=1 && wybor != 2 && wybor!=3){
			keyboard.nextLine();
			System.out.println("Bledne dane! Nie podales 1,2 ani 3. Jeszcze raz!");			
		}
		if(wybor==1){
			System.out.println("Poda³eœ 1. Wczytujemy z klawiatury");
			gadaj = new Klawiatura();
			gadaj.obsluguj();	//wywo³a metodê obs³uguj dla Klawiatury, czyli zacznie wczytywanie klawiatury z konsoli

		}
		if(wybor==2){
			System.out.println("PODA£EŒ 2. Wczytujemy z pliku");
			gadaj = new Plik();
			gadaj.obsluguj(); //wywo³a metodê obs³uguj dla Pliku, czyli zacznie wczytywanie z pliku
			
		}
		if(wybor==3){
			System.out.println("Poda³eœ 3.");
			
		}
		
		System.out.println("Koniec pracy programu! Pozdrawiam.");

		return;
	}
}