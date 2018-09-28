package shopping;

import java.util.ArrayList;
import java.util.Arrays;

public class Catalog {
	
	 public ArrayList<String> items ;
	 public ArrayList<Double> prices ; 
	 public ArrayList<Double> monthlyPayments ;

	 public Catalog() {
		 this.items = new ArrayList<>();
		 this.prices = new ArrayList<>();
		 this.monthlyPayments = new ArrayList<>();
	 }
	
	/**
	 * This method adds all listed items to <items> arraylist
	 * that is already declared above
	 */
	public void loadItems() {
		//TODO
		
		items.add("iPhone 6s");		
		items.add("iPhone 6s Plus");
		items.add("iPhone X");
		items.add("MacbookPro");
		items.add("ThumbDrive");
		items.add("Beats HeadPhones");
		items.add("Mouse");
		items.add("Charger");
		items.add("iPad");
		items.add("Dyson Vacuum");
		items.add("TV");
		items.add("Apple Watch");

      /*	
        "iPhone 6s"
		"iPhone 6s Plus"
		"iPhone X"
		"MacbookPro"
		"ThumbDrive"
		"Beats HeadPhones"
		"Mouse"
		"Charger"
		"iPad"
		"Dyson Vacuum"
		"TV"
		"Apple Watch"
       */	
	}
	/**
	 * This method adds all listed prices to <prices> arraylist
	 * that is already declared above
	 */
	public void loadPrices() {
		//TODO
		prices.add(449.0) ; 
		prices.add(549.0);
		  prices.add(1149.0);
		  prices.add(1499.99);
		  prices.add(39.99);
		  prices.add(349.99);
		  prices.add(79.99);
		  prices.add(39.99);
			prices.add(429.0);
			 prices.add( 399.0);
			 prices.add( 2199.0);
			prices.add( 559.0);		
		
				
		/*449.0
		  549.0
		  1149.0
		  1499.99
		  39.99
		  349.99
		  79.99
		  39.99
		  429.0
		  399.0
		  2199.0
		  559.0
		 */
	}
	
	/**
	 * This method adds all listed monthly payments to <monthlyPayments> arraylist
	 * that is already declared above
	 */
	
	public void loadMonthlyPayments() {
		//TODO
		monthlyPayments.add(18.71);
		monthlyPayments.add(22.88);
		monthlyPayments.add(56.16);
		monthlyPayments.add(79.49);
		monthlyPayments.add(2.68);
		monthlyPayments.add(15.12);
		monthlyPayments.add(8.98);
		monthlyPayments.add(4.56);
		monthlyPayments.add(18.31);
		monthlyPayments.add(16.25);
		monthlyPayments.add(89.49);
		monthlyPayments.add(21.18);	
	
		
		/*
		  18.71
		  22.88
		  56.16
          79.49
          2.68
          15.12
		  8.98
		  4.56
		  18.31
		  16.25
		  89.49
		  21.18
		  */
	}
	
	/**
	 * This method will load whole catalog data - <items>,<prices>,<monthlyPayments>
	 * Call loadItems(),loadPrices(),loadMonthlyPayments() that you created above
	 */
	public void loadWholeCatalog() {
		//TODO
		
		loadItems();
		loadPrices();
		loadMonthlyPayments();
		}
	

	/**
	 * Write a method that reads values from above ArrayLists and 
	 * returns a stringbuilder with all item details:
	 * return format:
	 * 		iPhone 6s-449.0-18.71
			iPhone 6s Plus-549.0-22.88
			..
	 * 
	 */
	
	public StringBuilder getWholeCatalog() {
        //LOAD WHOLE CATALOG HERE FIRST
		
		loadWholeCatalog();
		//TODO
        
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<items.size();i++) {
            sb.append(items.get(i)+"-"+prices.get(i)+"-"+monthlyPayments.get(i)+"\n");
        }
		
		return sb;
	}

	/**
	 * write a method that an item name and returns all details for it. If item
	 * is not in the list then returns null
	 *  ex: 
	 * getItemDetails("ThumbDrive") -->ThumbDrive-39.99-2.68 
	 * getItemDetails("Charger") --> Charger-39.99-4.56
	 * getItemDetails("Potato") --> null
	 * 
	 * @param item
	 * @return
	 */

	public String getItemDetails(String item) {
		//LOAD WHOLE CATALOG HERE FIRST
		
		loadWholeCatalog();

		//TODO
		for(int i = 0; i < items.size(); i++) {
		if(items.get(i).equalsIgnoreCase(item))
			return items.get(i)+"-"+prices.get(i)+"-"+monthlyPayments.get(i);
					
		}
		return null;
	}

	/**
	 * write a method that accepts a price and returns a ArrayList<String> with
	 * items with all detail that have less than or equal monthly payments
	 * 
	 * getItemsLessThanAMonthlyPrice(5.99) --> ThumbDrive-39.99-2.68
	 * 										  Charger-39.99-4.56 
	 * getItemsLessThanAMonthlyPrice(1.99) --> ""
	 * 
	 * @param double price
	 * @return ArrayList<String>
	 */

	public ArrayList<String> getItemsLessThanAMonthlyPrice(double price) {
		//LOAD WHOLE CATALOG HERE FIRST
		loadWholeCatalog();
		//TODO
		ArrayList<String> arr =new ArrayList<String>();
		for(int i=0; i<monthlyPayments.size(); i++) {
			if( monthlyPayments.get(i) <= price) {
			
			arr.add(items.get(i)+"-"+prices.get(i)+"-"+monthlyPayments.get(i));
				}
			}	
		return arr;
	}



	
	/**
	 * Method accepts a item name and updates total Price and monthly payments
	 * for that item in <items>,<prices>,<monthlyPayments> arrayLists
	 * 
	 * @param item name
	 * @param newPrice
	 */
	
	public void updatePrice(String item, double newPrice) {
		//LOAD WHOLE CATALOG HERE FIRST
		
		loadWholeCatalog();
		//TODO
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).equalsIgnoreCase(item)) {
				prices.set(i, newPrice);
			    monthlyPayments.set(i, newPrice/12);
			}}
	
	}
	
	/**
	 * Method looks for an item in the catalog and removes
	 * all details for that item including item name, price, monthlypayments
	 * 
	 * 
	 * @param item
	 */
	
	public void deleteItemFromCatalog(String item) {
		//LOAD WHOLE CATALOG HERE FIRST
		loadWholeCatalog();
		//TODO
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).equalsIgnoreCase(item)) {
				items.remove(i);
				prices.remove(i);
				monthlyPayments.remove(i);
			}}
		
	}
	
	

	/**
	 * Method looks for an item in the catalog by name and return index
	 * 
	 * @param item
	 */
	
	public int findIndexOfItem(String item) {
		//LOAD WHOLE CATALOG HERE FIRST
		loadWholeCatalog();
		//TODO
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).equalsIgnoreCase(item))
				return i;
		}
		
	
		return -1 ; 
	}
	
	/**
	 * Method looks for an item in the catalog by monthlyPayment and return index
	 * 
	 * @param item
	 */
	public int findIndexOfItem(double monthlyPayment) {
		//LOAD WHOLE CATALOG HERE FIRST
		loadWholeCatalog();	
		//TODO
		for(int i = 0; i < monthlyPayments.size(); i++) {
			if(monthlyPayments.get(i) == monthlyPayment)
				return i;
		}
		
		return -1 ; 
	}
	
	
	
	
	
		
	
	

}
