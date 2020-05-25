package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.*;

class FarmTest {

	@Test
	void test() {
		Farm testFarm = new Farm("Lifestyle Block");
		testFarm.setName("Number One Farm");
		Farmer testFarmer = new Farmer("Chris", 21);
		testFarm.setFarmer(testFarmer);
		
		assertEquals("Number One Farm", testFarm.getName());
		assertEquals("The farm has 20 dollars.", testFarm.toString());
		assertEquals("4 crops in the field, 6 more can be planted.", testFarm.cropFieldStatus());
		assertEquals("2 animals in the farm, 8 more can be raised.", testFarm.animalFarmStatus());
		assertEquals(0, testFarm.getCropIndex("Corn"));
		assertEquals(0, testFarm.getAnimalIndex("Cow"));
		assertEquals(0, testFarm.getItemIndex("1080"));
		assertEquals(2, testFarm.getCropPrice(5));
		assertEquals(1, testFarm.getAnimalPrice(2));
		assertEquals(4, testFarm.getItemPrice(5));
	}
	
	@Test
	void testBuyCrops() {
		Farm testFarm = new Farm("Lifestyle Block");
		testFarm.buyCrops(1, 0);
		assertEquals("Corn", testFarm.getAllCrops().get(0).getType());
		assertEquals(1, testFarm.getAllCrops().get(0).getAmount());
		assertEquals(16, testFarm.getMoneyOwned());
	}
	
	@Test
	void testHarvest() {
		Farm testFarm = new Farm("Lifestyle Block");
		testFarm.buyCrops(5, 0);
		testFarm.waterCrops(0);
		testFarm.waterCrops(0);
		testFarm.waterCrops(0);
		testFarm.waterCrops(0);
		assertEquals("5 Corn, ", testFarm.harvestableCrops());
		int earning = testFarm.harvestCrops();
		assertEquals(45, earning);
	}
	
	@Test
	void testBuyAnimals() {
		Farm testFarm = new Farm("Lifestyle Block");
		testFarm.buyAnimals(1, 0);
		assertEquals("Cow", testFarm.getAllAnimals().get(0).getType());
		assertEquals(1, testFarm.getAllAnimals().get(0).getAmount());
		assertEquals(17, testFarm.getMoneyOwned());
	}
	
	@Test
	void testPlayWithAnimals() {
		Farm testFarm = new Farm("Cow");
		testFarm.playWithAnimals(0);
		assertEquals(7, testFarm.getAllAnimals().get(0).getHappiness());
	}
	
	@Test
	void testBuyItems() {
		Farm testFarm = new Farm("Cow");
		testFarm.buyItem(5, 0);
		assertEquals(5, testFarm.getItemList().get(0).getAmount());
		assertEquals(10, testFarm.getMoneyOwned());
	}
	
	@Test
	void testTending() {
		Farm testFarm = new Farm("Cow");
		testFarm.tending();
		assertEquals(15, testFarm.getMaxAnimals());
		assertEquals(15, testFarm.getMaxCrops());
		assertEquals(-1, testFarm.getAllAnimals().get(0).getHappinessGrowthRate());
	}
	
	@Test
	void testMoveToNextDay() {
		Farm testFarm = new Farm("Lifestyle Block");
		int earning = testFarm.moveToNextDay();
		assertEquals(2, earning);
		assertEquals(1, testFarm.getAllCrops().get(0).getDaysUntilHarvest());
		assertEquals(4, testFarm.getAllAnimals().get(0).getHappiness());
	}
	
	@Test
	void testGetCropValue() {
		Farm testFarm = new Farm("Wheat");
		int money = testFarm.getCropValue();
		assertEquals(30, money);
	}
	
	@Test
	void testGetAnimalValue() {
		Farm testFarm = new Farm("Cow");
		int money = testFarm.getAnimalValue();
		assertEquals(4, money);
	}
	
	@Test
	void testGetItemValue() {
		Farm testFarm = new Farm("Wheat");
		int money = testFarm.getItemValue();
		assertEquals(4, money);
	}
}
