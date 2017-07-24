import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * 
 * @author Sebastian
 *
 */
public class Anagrams {
	
	/**
	 * words - map to keep all of the words from the input file.
	 * the Key - String - is just the word read from the file.	(for example: cat)
	 * Value - String - is the alphabetically sorted form of the Key word (for cat: act). Used for searching anagrams. 
	 */
	Map<String, String> words;
	
	/**
	 * sortedBiggestAnagram is String, that keeps the sorted form of word which has the most anagrams.
	 */
	String sortedBiggestAnagram;
	
	/**
	 * numberOfAnagrams - number of anagrams of the word that has most anagrams.
	 */
	int numberOfAnagrams;
	
	/**
	 * wordsHavingAnagrams - it is a map of words with numbers of anagrams they have.
	 *  Key - String - is the sorted form of word (sorted!! not regular word making sense. It's the counterpart of the Value in "words" map)
	 *  Integer - is the number of anagrams it has
	 */
	Map<String, Integer> wordsHavingAnagrams;
	
	
	public Anagrams() {
		numberOfAnagrams=0;
		words = new LinkedHashMap<>();
		wordsHavingAnagrams = new HashMap<>();
	}

	/**
	 * findWordWithMostAnagrams - this method finds word with most anagrams
	 */
	public void findWordWithMostAnagrams(){
		/**
		 * search through whole map with all the words
		 */
			for (Map.Entry<String, String> entry : words.entrySet()) {
		    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());	
				/**
				 * check if we have already find some anagram for this word (entry.getValue() is sorted form of the key (normal) word)\
				 * and words having anagrams as key also keep only sorted form of words
				 */
				if(wordsHavingAnagrams.containsKey(entry.getValue())){
					/**
					 * fact this word was already in map wordsHavingAnagrams, means we have an anagram. So we increment the amount of 
					 * anagrams (increment Integer - value of the map wordsHavingAnagrams)
					 */
					Integer newNumberOfAnagrams= wordsHavingAnagrams.get(entry.getValue());
					newNumberOfAnagrams++;
					wordsHavingAnagrams.put(entry.getValue(), newNumberOfAnagrams);
					
					/**
					 * if now, after incrementing number of anagrams of the word check, we have more than the previous 
					 * "most number of anagrams", then it means this word has the most anagrams. Then we update it
					 */
					if(newNumberOfAnagrams>numberOfAnagrams){
						numberOfAnagrams=newNumberOfAnagrams;
						sortedBiggestAnagram=entry.getValue();
					}
				}
				/**
				 * 	else: if the word wasn't in this map, it means that the examined word hasn't anagrams yet. We put the sorted
				 *	form of it into this map and check if in the future there will be anagrams for it. 
				 */
				else{
					wordsHavingAnagrams.put(entry.getValue(), 0);
				}
			}
	}
	
	/**
	 * read words from file and put all them into map "words".
	 * @return true if everything well, and
	 * 			false if there was some error (for example there was opening file error).
	 */
	public boolean readWords(){
		try ( BufferedReader br = new BufferedReader(new FileReader("slowa.txt")) ){
				String word=br.readLine();	//read first line in case file is empty		
		        while (word != null) { // read while not end of file
		            String sortedWord = sortWord(word);	//find the sorted form of the word to put it into map
		            words.put(word, sortedWord);            
		            word = br.readLine();
		        }
		} 
		
		catch(IOException ioe){
			System.out.println("There was some i/o error! Message: "+ioe.getMessage());
			return false; //false - something gone wrong
		}
		return true; //all is done well
	}
	
	/**
	 * We'll be checking if the words are anagrams, by comparing each letter of their sorted form.
	 * To do so, we need alphabetically sorted form of a word. This method find and returns it.
	 * @param wordToSort - word that we'll be sorting
	 * @return a sorted word
	 */
	public String sortWord(String wordToSort){
		char[] tmp = wordToSort.toCharArray();
		Arrays.sort(tmp);
		String sortedLine = String.valueOf(tmp);
		return sortedLine;
	}
	

	
	
	/**
	 * getKeysByValue return a set of a keys - real, unsorted words -
	 *  for given value (sorted form of a word) from map containing all the words.
	 */
	public Set<String> getKeysByValue(String wordToCheck) {
        Set<String> keys = new HashSet<String>();
        for (Entry<String, String> entry : words.entrySet()) {
                if (wordToCheck.equals(entry.getValue())) {
                        keys.add(entry.getKey());
                }
         }
        return keys;
	}
	


	
	
	public static void main(String[] args) {
		System.out.println("We're getting started.");
		Anagrams anagrams= new Anagrams();
		
		//point 1 from algorithm
		if(!anagrams.readWords()){	//readWords returns true if all went good, false if there was some error
			System.out.println("Something gone wrong, so it's end of the program.");
			System.exit(-1);
		}
		
		//point 2
		anagrams.findWordWithMostAnagrams();
		
		//System.out.println("We got our (sorted) /word/ with most anagrams!");
		
		/**
		 * setOfAnagrams is a set for the list of words-anagrams for the word with the most anagrams.
		 */
		Set<String> setOfAnagrams = new HashSet<>();
		//point 3
		setOfAnagrams = anagrams.getKeysByValue(anagrams.sortedBiggestAnagram);	
		
		//point 4
		System.out.println("Finally number of anagrams: "+anagrams.numberOfAnagrams);
		//System.out.println("Sorted form of a word that we have most anagrams for: "+anagrams.sortedBiggestAnagram);
		
		//printing out the result
		Iterator<String> it1 = setOfAnagrams.iterator();	
		String resultWord= it1.next();	//taking first element
		System.out.println("Our word having the most anagrams: "+resultWord);
		setOfAnagrams.remove(resultWord);	//we don't want same word said to be anagram (only different words are anagrams)
		
		System.out.println("And our anagrams: "+setOfAnagrams);
	}
	
}