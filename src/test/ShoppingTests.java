package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.Test;

import shopping.Catalog;


public class ShoppingTests {

	
	
	@Test
	public void loadItemsTest() {
		Catalog ctl = new Catalog();
		ctl.loadItems();
		assertEquals("[iPhone 6s, iPhone 6s Plus, iPhone X, MacbookPro, ThumbDrive, Beats HeadPhones, Mouse, Charger, iPad, Dyson Vacuum, TV, Apple Watch]"
				     ,ctl.items.toString());
	}
	
	@Test
	public void loadPricesTest() {
		Catalog ctl = new Catalog();
		ctl.loadPrices();
		assertEquals("[449.0, 549.0, 1149.0, 1499.99, 39.99, 349.99, 79.99, 39.99, 429.0, 399.0, 2199.0, 559.0]"
				    ,ctl.prices.toString());
	}
	
	@Test
	public void loadMonthPaymentsTest() {
		Catalog ctl = new Catalog();
		ctl.loadMonthlyPayments();
		assertEquals("[18.71, 22.88, 56.16, 79.49, 2.68, 15.12, 8.98, 4.56, 18.31, 16.25, 89.49, 21.18]"
				    ,ctl.monthlyPayments.toString());
	}
	
	@Test
	public void loadWholeCatalogTest() {
		Catalog ctl = new Catalog();
		ctl.loadWholeCatalog();
		assertEquals("[iPhone 6s, iPhone 6s Plus, iPhone X, MacbookPro, ThumbDrive, Beats HeadPhones, Mouse, Charger, iPad, Dyson Vacuum, TV, Apple Watch]"
			     ,ctl.items.toString());
		assertEquals("[449.0, 549.0, 1149.0, 1499.99, 39.99, 349.99, 79.99, 39.99, 429.0, 399.0, 2199.0, 559.0]"
			    ,ctl.prices.toString());
		assertEquals("[18.71, 22.88, 56.16, 79.49, 2.68, 15.12, 8.98, 4.56, 18.31, 16.25, 89.49, 21.18]"
			    ,ctl.monthlyPayments.toString());
	}

	@Test
	public void getWholeCatalogTest() throws IOException {
		Catalog ctl = new Catalog();
		String expected = fileData("catalog.txt");
		assertEquals(expected, ctl.getWholeCatalog().toString().trim());
	}

	@Test
	public void getItemDetailsTest1() throws IOException {
		Catalog ctl = new Catalog();
		assertEquals(null, ctl.getItemDetails("Table"));
	}

	@Test
	public void getItemDetailsTest2() throws IOException {
		Catalog ctl = new Catalog();
		assertEquals("MacbookPro-1499.99-79.49", ctl.getItemDetails("MacbookPro"));
	}

	@Test
	public void getItemDetailsTest3() throws IOException {
		Catalog ctl = new Catalog();
		assertEquals("Apple Watch-559.0-21.18", ctl.getItemDetails("Apple Watch"));
	}

	@Test
	public void getItemsLessThanAMonthlyPriceTest1() {
		Catalog ctl = new Catalog();
		ArrayList<String> stb = new ArrayList<>();
		stb.add("ThumbDrive-39.99-2.68");
		stb.add("Mouse-79.99-8.98");
		stb.add("Charger-39.99-4.56");
		assertEquals(stb.toString(), ctl.getItemsLessThanAMonthlyPrice(14.99).toString());
	}

	@Test
	public void getItemsLessThanAMonthlyPriceTest2() {
		Catalog ctl = new Catalog();
		List<String> stb = Arrays.asList(
		     "iPhone 6s-449.0-18.71","iPhone 6s Plus-549.0-22.88","ThumbDrive-39.99-2.68",
			"Beats HeadPhones-349.99-15.12","Mouse-79.99-8.98","Charger-39.99-4.56",
			"iPad-429.0-18.31","Dyson Vacuum-399.0-16.25","Apple Watch-559.0-21.18");
		assertEquals(stb.toString(), ctl.getItemsLessThanAMonthlyPrice(23.99).toString());
	}

	@Test
	public void getItemsLessThanAMonthlyPriceTest3() {
		Catalog ctl = new Catalog();
		assertEquals("[]", ctl.getItemsLessThanAMonthlyPrice(1.99).toString());
	}
	
	@Test
	public void updatePriceTest1() {
		Catalog ctl = new Catalog();
		ctl.updatePrice("iPhone 6s", 549.0);
		assertEquals("iPhone 6s-549.0-45.75",ctl.getItemDetails("iPhone 6s"));
	}
	
	@Test
	public void updatePriceTest2() {	
		Catalog ctl = new Catalog();
		ctl.updatePrice("iPad", 329.0);
		assertEquals("iPad-329.0-27.416666666666668",ctl.getItemDetails("iPad"));
	}
	
	@Test
	public void deleteItemFromCatalogTest1() {
		Catalog ctl = new Catalog();
		ctl.loadItems();
		assertTrue(ctl.items.contains("iPad"));
		ctl.items.clear();
		ctl.deleteItemFromCatalog("iPad");
		assertFalse(ctl.items.contains("iPad"));
		assertFalse(ctl.prices.contains(429.0));
		assertFalse(ctl.monthlyPayments.contains(18.31));
	}
	
	@Test
	public void deleteItemFromCatalogTest2() {
		Catalog ctl = new Catalog();
		ctl.loadItems();
		assertTrue(ctl.items.contains("MacbookPro"));
		ctl.items.clear();
		ctl.deleteItemFromCatalog("MacbookPro");
		assertFalse(ctl.items.contains("MacbookPro"));
		assertFalse(ctl.prices.contains(1499.99));
		assertFalse(ctl.monthlyPayments.contains(79.49));
	}

	@Test
	public void findIndexByNameTest() {
		
		Catalog ctl = new Catalog();
		ctl.loadItems();
		assertEquals(0 , ctl.findIndexOfItem("iPhone 6s"));
		assertEquals(8, ctl.findIndexOfItem("iPad"));
		assertEquals(9 ,ctl.findIndexOfItem("Dyson Vacuum"));
		assertEquals(-1 ,ctl.findIndexOfItem("SPACE SHIP"));
		

	}
	
	@Test
	public void findIndexByMonthlyTest() {
		
		Catalog ctl = new Catalog();
		ctl.loadMonthlyPayments();
		assertEquals(0 , ctl.findIndexOfItem(18.71));
		assertEquals(8, ctl.findIndexOfItem(18.31));
		assertEquals(9, ctl.findIndexOfItem(16.25));
		assertEquals(-1, ctl.findIndexOfItem(12321312));
		
	}
	
	
	private String fileData(String fileName) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		Scanner fileScanner = new Scanner(bufferedReader);

		while (fileScanner.hasNextLine()) {
			stringBuffer.append(fileScanner.nextLine() + "\n");
		}

		fileScanner.close();

		return stringBuffer.toString().trim();
	}

}