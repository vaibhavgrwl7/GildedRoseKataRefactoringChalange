package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class ConjuredItemTest {

    @Test
    public void item_conjured_decreasesInQuality_twiceTheSpeed() {
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 3, 6));

        app.updateQuality();
        //When Quantity Decreases twice than normal Item and sellIn >0
        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", 2, 4));
    }

    @Test
    public void item_conjured_decreasesInQuality_twiceTheSpeed_alsoWhenSellInExpired() {
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 0, 6));

        app.updateQuality();
      //When Quantity Decreases twice than normal Item and sellIn <0
        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", -1, 2));
    }
}
