package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class AgedBrieTest {

    @Test
    public void itemAgedBrieincQuality() {
        GildedRose cls = new GildedRose(new Item("Aged Brie", 2, 2));

        cls.updateQuality();
        //When Quantity increases
        assertItemEquals(cls.getItems()[0], new Item("Aged Brie", 1, 3));
    }

    @Test
    public void itemAgedBrieincQuality_DoublesWhenOff() {
        GildedRose cls = new GildedRose(new Item("Aged Brie", 0, 2));

        cls.updateQuality();
        //When Quantity increases twice and sellIn <=0
        assertItemEquals(cls.getItems()[0], new Item("Aged Brie", -1, 4));
    }

    @Test
    public void itemAgedBrie50Quality() {
        GildedRose cls = new GildedRose(new Item("Aged Brie", 2, 50));

        cls.updateQuality();
        //When Quantity is set to maximum
        assertItemEquals(cls.getItems()[0], new Item("Aged Brie", 1, 50));
    }
}