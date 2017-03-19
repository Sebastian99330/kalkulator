package kalkulator;

import java.io.File;
import java.util.Scanner;

public class Plik implements Obsluguj {
	
	
	private Scanner x;
	public void openFile(){
		try{
			x=new Scanner(new File("chinese.txt"));
		}
		catch(Exception e){
			System.out.println("You fckd up sthg!");
		}
	}
	
	@Override
	public void obsluguj(){
		System.out.println("Jestem w Plik.java i zaraz piêknie wczytam z pliku");
		
		while(x.hasNext()){
			String a = x.next();
			String b = x.next();
			String c = x.next();
			
			System.out.printf("%s %s %s \n", a,b,c);
		}
		
	}
	
	

	public void closeFile(){
		x.close();
	}
}
