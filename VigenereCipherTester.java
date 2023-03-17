import edu.duke.*;
class VigenereCipherTester {
	public static void main(String args[])
	{
		int[] i = {21, 8};
		VigenereCipher vst = new VigenereCipher(i);
		//FileResource fr = new FileResource();
		System.out.println(vst.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
		//System.out.println(vst.decrypt(fr.asString()));
		System.out.println(vst.toString());
	}
}
