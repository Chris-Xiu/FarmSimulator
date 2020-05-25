package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import game.*;

class ItemTest {

	@Test
	void testTenEighty() {
		Farm testFarm = new Farm("Lifestyle Block");
		TenEighty testTenEighty = new TenEighty(1);
		testTenEighty.useItem(testFarm, 1);
		testTenEighty.changeAmount(10);
		assertEquals(0, testFarm.getAllCrops().get(0).getDaysUntilHarvest());
		assertEquals(3, testFarm.getAllAnimals().get(0).getHealth());
		assertEquals(10, testTenEighty.getAmount());
		assertEquals("1080", testTenEighty.getName());
		assertEquals(1, testTenEighty.getPrice());
	}
	
	@Test
	void testFertilizer() {
		Farm testFarm = new Farm("Lifestyle Block");
		Fertilizer testFertilizer = new Fertilizer(1);
		testFertilizer.useItem(testFarm, 1);
		testFertilizer.changeAmount(10);
		assertEquals(0, testFarm.getAllCrops().get(0).getDaysUntilHarvest());
		assertEquals(10, testFertilizer.getAmount());
		assertEquals("Fertilizer", testFertilizer.getName());
		assertEquals(2, testFertilizer.getPrice());
	}
	
	@Test
	void testIrrigation() {
		Farm testFarm = new Farm("Lifestyle Block");
		Irrigation testIrrigation = new Irrigation(1);
		testIrrigation.useItem(testFarm, 1);
		testIrrigation.changeAmount(10);
		assertEquals(0, testFarm.getAllCrops().get(0).getDaysUntilHarvest());
		assertEquals(10, testIrrigation.getAmount());
		assertEquals("Irrigation", testIrrigation.getName());
		assertEquals(4, testIrrigation.getPrice());
	}
	
	@Test
	void testFodder() {
		Farm testFarm = new Farm("Cow");
		Fodder testFodder = new Fodder(1);
		testFodder.useItem(testFarm, 0);
		testFodder.changeAmount(10);
		assertEquals(8, testFarm.getAllAnimals().get(0).getHealth());
		assertEquals(-1, testFarm.getAllAnimals().get(0).getHappinessGrowthRate());
		assertEquals(10, testFodder.getAmount());
		assertEquals("Fodder", testFodder.getName());
		assertEquals(1, testFodder.getPrice());
	}
	
	@Test
	void testFreshHay() {
		Farm testFarm = new Farm("Cow");
		FreshHay testFreshHay = new FreshHay(1);
		testFreshHay.useItem(testFarm, 0);
		testFreshHay.changeAmount(10);
		assertEquals(8, testFarm.getAllAnimals().get(0).getHealth());
		assertEquals(-1, testFarm.getAllAnimals().get(0).getHappinessGrowthRate());
		assertEquals(10, testFreshHay.getAmount());
		assertEquals("Fresh Hay", testFreshHay.getName());
		assertEquals(2, testFreshHay.getPrice());
	}
	
	@Test
	void testNewPaddock() {
		Farm testFarm = new Farm("Cow");
		NewPaddock testNewPaddock = new NewPaddock(1);
		testNewPaddock.useItem(testFarm, 0);
		testNewPaddock.changeAmount(10);
		assertEquals(8, testFarm.getAllAnimals().get(0).getHealth());
		assertEquals(-1, testFarm.getAllAnimals().get(0).getHappinessGrowthRate());
		assertEquals(10, testNewPaddock.getAmount());
		assertEquals("New Paddock", testNewPaddock.getName());
		assertEquals(4, testNewPaddock.getPrice());
	}
}
