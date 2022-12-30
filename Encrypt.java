package User;

public class Encrypt {
	public static void main (String[] args) {
		int key =6;
		String text = "Nk2&nu}-y&oz&ngtmotmE";
		System.out.println(text);
		char[] chars = text.toCharArray();
		for (char c : chars ) {
			c -= key;
			System.out.print(c);
		}
		
	}
}
