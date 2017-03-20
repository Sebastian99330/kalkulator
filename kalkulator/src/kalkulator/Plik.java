package kalkulator;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Plik extends Analiza implements Obsluguj {
	//Klasa Plik - wczytuje z pliku liniê-dzia³anie (np 5+4) i przekazuje j¹ do
	//"analizy" czyli do klasy bazowej która odpowiednio zbada ten napis i obliczy ¿¹dane dzia³anie i zwróci wynik
	
	//jaka jest ró¿nica miêdzy interfejsem a klas¹ abstrakcyjn¹?
	
	private Scanner open;	//open to zmienna "wskanik do pliku"
	
	public void openFile(){
		try{
			open=new Scanner(new File("dzialania.txt"));
		}
		catch(Exception e){
			System.out.println("Nie uda³o siê otworzyæ pliku.");
		}
	}
	
	
	@Override
	public void obsluguj(){
		openFile();
		try{
			while(open.hasNext()){	//jeœli coœ jest w tym pliku (jakieœ dzia³ania zapisane)
				String linijka = open.next();	//to wczytujemy je
				double wynik=Operuj(linijka);	//i dajemy do obliczenia
			}
		}
		catch(Exception e){
			System.out.println("Wyjatek po metodzie \"obsluguj\" czyli po wczytaniu linii tekstu");
		}
		closeFile();	
	}	
	
	

	public void closeFile(){
		open.close();
	}
}
