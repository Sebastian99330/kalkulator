package kalkulator;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class Plik implements Obsluguj {
	
	private Scanner open;
	private Formatter write;
	
	public void openFile(){
		try{
			open=new Scanner(new File("dzialania.txt"));
			System.out.println("Poprawnie otwarto plik");
		}
		catch(Exception e){
			System.out.println("Nie uda�o si� otworzy� pliku.");
		}
	}
	
	
	@Override
	public void obsluguj(){
		System.out.println("Jestem w Plik.java i zaraz pi�knie wczytam z pliku");
		while(open.hasNext()){
			String a = open.next();
			String b = open.next();
			String c = open.next();
			
			System.out.printf("%s %s %s \n", a,b,c);
		}  
	
		
	}
	
	

	public void closeFile(){
		open.close();
	}
}
