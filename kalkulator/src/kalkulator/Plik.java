package kalkulator;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Plik extends Analiza implements Obsluguj {
	//Klasa Plik - wczytuje z pliku lini�-dzia�anie (np 5+4) i przekazuje j� do
	//"analizy" czyli do klasy bazowej kt�ra odpowiednio zbada ten napis i obliczy ��dane dzia�anie i zwr�ci wynik
	
	//jaka jest r�nica mi�dzy interfejsem a klas� abstrakcyjn�?
	
	private Scanner open;	//open to zmienna "wskanik do pliku"
	
	public void openFile(){
		try{
			open=new Scanner(new File("dzialania.txt"));
		}
		catch(Exception e){
			System.out.println("Nie uda�o si� otworzy� pliku.");
		}
	}
	
	
	@Override
	public void obsluguj(){
		openFile();
		try{
			while(open.hasNext()){	//je�li co� jest w tym pliku (jakie� dzia�ania zapisane)
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
