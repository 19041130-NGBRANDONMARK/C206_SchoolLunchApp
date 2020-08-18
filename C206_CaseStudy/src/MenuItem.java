
public class MenuItem {
	
	private String category;
	
	private String name;
	
	private boolean healthyChoice;
	
	private double price;
	
	public MenuItem(String category , String name , boolean healthyChoice , double price) {
		this.category = category;
		this.name = name;
		this.healthyChoice = healthyChoice;
		this.price = price;
	}
	
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setHealthyChoice(boolean healthyChoice) {
		this.healthyChoice = healthyChoice;
	}
	
	public boolean getHealthyChoice() {
		return healthyChoice;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
public String toString() {
		
		return String.format("%-20s %-20s %-10s %-10s" , getName(),getCategory() , getPrice(), getHealthyChoice());
		
	}
	
	
}
