
public class MonthlyMenu extends MenuItem{
	private int month;

	public MonthlyMenu(String category, String name, boolean healthyChoice, double price, int month) {
		super(category, name, healthyChoice, price);
		this.month = month;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public String toString() {
		String output = "Name: "+getName();
		output += "\nCategory: "+getCategory();
		output += "\nPrice: "+getPrice();
		output += "\nIs Healthy Choice: "+getHealthyChoice();
		output += "\nMonth: "+getMonth();
		return output;
	}
}
