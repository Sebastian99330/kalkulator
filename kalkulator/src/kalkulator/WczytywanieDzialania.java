package kalkulator;

/* obs�uguj przyjmowanie linijki-dzia�ania.
 * 
 * interfejs po kt�rym odziedzicz� klasy Klawiatura i Plik.
 * klasy kt�re ten interfejs implementuj�, maj� w okre�lony przez siebie spos�b (z klawiatury / z pliku) 
 * przyj�� stringa - jedn� linijk� opisuj�c� dzia�anie np 22-4, i przekaza� j� do klasy Analiza
 * do metody Operuj �eby ta metoda rozebra�a podanego stringa na cz�ci pierwsze (dwie liczby i operator),
 * wykona�a dzia�anie w poda�a wynik.

 * zmienna typu obs�uguj b�dzie wykorzystana w mainie �eby zrobi� polimorfizm - wcisn�� do niej albo new Klawiature,
 * albo new Plik, zale�y co u�ytkownik b�dzie chcia� robi�.
*/
public interface WczytywanieDzialania {	
	
	public void wczytajDzialanie();	
}
