import java.io.*;
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    private String sliceString(String message, int whichSlice, int totalSlices) 
    {
	StringBuilder sb = new StringBuilder();       //REPLACE WITH YOUR CODE
	for (int i = whichSlice; i < message.length(); i += totalSlices)
	{
		sb.append(message.charAt(i));
	}
        return sb.toString();
    }

    private int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
	String encryptd = "";
	CaesarCracker crack = new CaesarCracker(mostCommon);
	for (int i = 0 ; i < klength; i++)
	{
		encryptd = sliceString(encrypted, i, klength);
		key[i] = crack.getKey(encryptd);
	}
        //WRITE YOUR CODE HERE
        return key;
    }

    private int countWords(String code, HashSet<String> dictionary)
    {
	int counter = 0; 
	String[] words = code.split("\\W+");
	    for (String word : words)
	    {
		    if  (dictionary.contains(word.toLowerCase()))
			    counter++;
	    }
	    return counter;
    }
    private HashSet<String> readDictionary(FileResource fr)
    {
	    HashSet<String> language = new HashSet<String>();
	    for (String word : fr.words())
	    {
		language.add(word.toLowerCase());
	    }
	    return language;
    }
    private String getMaxKeyString(HashMap<String, Integer> Klength)
    {
	    int max = 0;
	    String N = "";
	    for (String key : Klength.keySet())
	    {
		    if (Klength.get(key) > max)
		    {
			   max = Klength.get(key);
		 	   N = key;
		    }
	    }
	    return N; 
    }
    public char getMaxKeyChar(HashMap<Character, Integer> Klength)
    {
	    int max = 0;
	    char c = ' ';
	    for (char key : Klength.keySet())
	    {
		    if (Klength.get(key) > max)
		    {
			   max = Klength.get(key);
		 	   c = key;
		    }
	    }
	    return c;
    }
    private int getMaxKey(HashMap<Integer, Integer> Klength)
    {
	    int max = 0;
	    int N = 0;
	    for (int key : Klength.keySet())
	    {
		    if (Klength.get(key) > max)
		    {
			   max = Klength.get(key);
		 	   N = key;
		    }
	    }
	    return N;
    }
    public String breakForLanguage(String code, HashSet<String> dictionary, char MostChar)
    {
	    HashMap<Integer, Integer> Klength = new HashMap<Integer, Integer>();
	    for (int i = 1; i < 100; i++)
	    {
		int[] key = tryKeyLength(code, i, MostChar);
		VigenereCipher vc = new VigenereCipher(key);
		String decrypted = vc.decrypt(code);
		int count = countWords(decrypted, dictionary);
		Klength.put(key.length, count);
	    }
	    int key = getMaxKey(Klength);
	    //int[] i = {14, 24};
	    VigenereCipher vc = new VigenereCipher(tryKeyLength(code, 2, MostChar)); 
  
	    System.out.println(vc.toString());
	    return vc.decrypt(code);
    }
    public String breakForAllLangs(String code, HashMap<String, HashSet<String>> languages)
    {
	    HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		for (String language : languages.keySet())
		{
			HashSet<String> words = languages.get(language); 
			String decrypted = breakForLanguage(code, words, mostCommonCharIn(languages.get(language)));
			int count = countWords(decrypted, words);
			dictionary.put(language, count);
		}
		String language = getMaxKeyString(dictionary);
		System.out.println(language);
		return breakForLanguage(code, languages.get(language), mostCommonCharIn(languages.get(language)));
    }
    private char mostCommonCharIn(HashSet<String> dictionary)
    {
	HashMap<Character, Integer> maximum = new HashMap<Character, Integer>();
	for (String word : dictionary)
	{
		for (int i=0; i < word.length(); i++)
		{
			if (!maximum.containsKey(word.charAt(i)))
				maximum.put(word.charAt(i), 1);
			else
				maximum.put(word.charAt(i), maximum.get(word.charAt(i)) + 1);
		}
	}
	return getMaxKeyChar(maximum);
    }
    public void breakVigenere () {
        //WRITE YOUR CODE HERE
	String fr = new FileResource().asString();
	//String fr = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
	HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
	DirectoryResource dr = new DirectoryResource();
	for (File f : dr.selectedFiles())
	{
		HashSet<String> dictionary = readDictionary(new FileResource(f));	
		languages.put(f.getName(), dictionary);
	}
	String decrypted = breakForAllLangs(fr, languages);
	System.out.println(decrypted);

    }
    
}
