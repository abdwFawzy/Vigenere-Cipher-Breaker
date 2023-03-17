import edu.duke.*;
class CaesarCipherTester{
	public static void  main(String args[])
	{
		CaesarCipher caesar = new CaesarCipher(15);
	//	FileResource fr = new FileResource();
		System.out.println(caesar.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
	}
}
