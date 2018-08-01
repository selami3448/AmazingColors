package src;

public class ColorTest {

	public static void main(String[] args) {
		Colors colors = new Colors();
		colors.addColor("white");
		colors.addColor("green");
		colors.addColor("blue");
		colors.addColor("red");
		int result = colors.getColorCount("blue");
		System.out.println(result);
	}

}
