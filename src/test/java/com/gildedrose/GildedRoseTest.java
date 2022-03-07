package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class GildedRoseTest {

	@Test
	public void sellInDateDecreases_butQualityCannotBeNegative() {
		GildedRose app = new GildedRose(new Item("Item", 0, 0));

		app.updateQuality();

		assertItemEquals(app.getItems()[0], new Item("Item", -1, 0));
	}

	@Test
	public void qualityDecreases() {
		GildedRose app = new GildedRose(new Item("Item", 10, 10));

		app.updateQuality();

		assertItemEquals(app.getItems()[0], new Item("Item", 9, 9));
	}

	@Test
	public void qualityDecreasesFasterAfterSellInDateExpired() {
		GildedRose app = new GildedRose(new Item("Item", 0, 10));

		app.updateQuality();

		assertItemEquals(app.getItems()[0], new Item("Item", -1, 8));
	}

}
