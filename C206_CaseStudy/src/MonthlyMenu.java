import java.util.ArrayList;

public class MonthlyMenu {
	private String displayName;
	private int month;
	private int numberOfItems;
	private ArrayList<MenuItem> items;
	
	public MonthlyMenu(String displayName, int month, int numberOfItems, ArrayList<MenuItem> items) {
		this.displayName = displayName;
		this.month = month;
		this.numberOfItems = numberOfItems;
		this.items = items;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}

	public String toString() {
		String output = "Name: "+ getDisplayName();
		output += "\nMonth: "+ getMonth();
		output += "\nNumber of Items: "+ getNumberOfItems();
		output += "\nItems: "+ getItems();
		return output;
	}
}
