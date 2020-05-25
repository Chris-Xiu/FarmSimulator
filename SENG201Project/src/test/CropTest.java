package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.*;

class CropTest {

	@Test
	void test() {
		Crop testCorn = new Corn();
		testCorn.addCrops(10);
		testCorn.updateDays(10);
		assertEquals("10 Corn which can be harvested in 0 days", testCorn.toString());
		assertEquals("Corn", testCorn.getType());
		assertEquals(0, testCorn.getIndex());
		assertEquals(4, testCorn.getPurchasePrice());
		assertEquals(9, testCorn.getSellPrice());
		assertEquals(0, testCorn.getDaysUntilHarvest());
		assertEquals(10, testCorn.getAmount());
	}

}
