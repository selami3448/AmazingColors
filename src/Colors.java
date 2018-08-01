package src;

import java.util.ArrayList;

public class Colors {
	private ArrayList<String> colorsList = new ArrayList<>();

	public Colors() {

	}

	public Colors(ArrayList<String> a) {
		if (a != null) {
			this.colorsList.addAll(a);
		}
	}

	public ArrayList<String> getColorsList() {
		return colorsList;
	}

	public void setColorsList(ArrayList<String> colorsList) {
		this.colorsList = colorsList;
	}

	public void addColor(String color) {
		this.colorsList.add(color);
	}

	public void addColors(ArrayList<String> colors) {
		this.colorsList.addAll(colors);
	}

	public ArrayList<String> changeSecondToOrange() {
		ArrayList<String> result = new ArrayList<>();
		result.addAll(this.colorsList);
		for (int i = 1; i < result.size(); i += 2)
			result.set(i, "Orange");
		return result;
	}

	public int findColor(String color) {
		return this.colorsList.indexOf(color);
	}

	public int getColorCount(String color) {
		int count = 0;
		for (int i = 0; i < this.colorsList.size(); i++) {
			if (colorsList.get(i).equalsIgnoreCase(color))
				count++;
		}
		return count;
	}

	public void removeDuplicates() {
		Object[] st = this.colorsList.toArray();
		for (Object s : st) {
			if (this.colorsList.indexOf(s) != this.colorsList.lastIndexOf(s)) {
				this.colorsList.remove(this.colorsList.indexOf(s));
			}
		}
	}

	public boolean replaceColor(String color, String replacementColor) {
		int count = 0;
		for (int i = 0; i < this.colorsList.size(); i++) {
			int indexOfGivenColor = this.colorsList.indexOf(color);
			if (indexOfGivenColor != -1) {
				this.colorsList.set(indexOfGivenColor, replacementColor);
				count++;
			}
		}
		System.out.println(this.colorsList);
		if (count == 0)
			return false;
		else
			return true;
	}

}
