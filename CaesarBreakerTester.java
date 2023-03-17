import edu.duke.*;
class CaesarBreakerTester {
	public static void main (String args[])
	{
		CaesarCracker caesarbreaker = new CaesarCracker('a');
		FileResource fr = new FileResource();
		System.out.println(caesarbreaker.decrypt(fr.asString()));
	}
}

