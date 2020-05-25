package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.*;

class AnimalTest {

	@Test
	void test() {
		Animal testCow = new Cow();
		testCow.addAnimals(10);
		testCow.updateHappiness(10);
		testCow.updateHappinessGrowth(10);
		testCow.updateHealth(10);
		testCow.updateHappiness(-20);
		testCow.updateHappinessGrowth(-20);
		testCow.updateHealth(-20);
		assertEquals("10 Cow with happiness of -8 and health of -4", testCow.toString());
		assertEquals("Cow", testCow.getType());
		assertEquals(0, testCow.getIndex());
		assertEquals(3, testCow.getPurchasePrice());
		assertEquals(0, testCow.getTendingReward());
		assertEquals(-8, testCow.getHappiness());
		assertEquals(-4, testCow.getHealth());
		assertEquals(-12, testCow.getHappinessGrowthRate());
		assertEquals(10, testCow.getAmount());
	}

}
