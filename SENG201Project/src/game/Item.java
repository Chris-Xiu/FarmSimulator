package game;

import java.util.ArrayList;

public interface Item {
	public void useItem(Farm inputFarm, int typeIndex);
	public int getAmount();
	public void changeAmount(int change);
	public String getName();
	}
