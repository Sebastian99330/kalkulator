package kalkulator;

/* obs³uguj przyjmowanie linijki-dzia³ania.
 * 
 * interfejs po którym odziedzicz¹ klasy Klawiatura i Plik.
 * klasy które ten interfejs implementuj¹, maj¹ w okreœlony przez siebie sposób (z klawiatury / z pliku) 
 * przyj¹æ stringa - jedn¹ linijkê opisuj¹c¹ dzia³anie np 22-4, i przekazaæ j¹ do klasy Analiza
 * do metody Operuj ¿eby ta metoda rozebra³a podanego stringa na czêœci pierwsze (dwie liczby i operator),
 * wykona³a dzia³anie w poda³a wynik.

 * zmienna typu obs³uguj bêdzie wykorzystana w mainie ¿eby zrobiæ polimorfizm - wcisn¹æ do niej albo new Klawiature,
 * albo new Plik, zale¿y co u¿ytkownik bêdzie chcia³ robiæ.
*/
public interface WczytywanieDzialania {	
	
	public void wczytajDzialanie();	
}
