package com.gildedrose;

class GildedRose {
	
	public static final String Aged_Brie = Constants.getAgedBrie();
    public static final String Backstage_passes = Constants.getBackstage();
    public static final String Sulfuras = Constants.getSulfuras();
    public static final String Conjured = Constants.getConjured();
    
    private Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
    	//doUpdateQuality() will iterate for individual Item
        for (Item item : items) {
            doUpdateQuality(item);
        }
    }
    
    private void UpdateAgedBrie(Item item) {
        incquality(item);
        updatesellIn(item);
    }
    
    private void UpdateBackstagePasses(Item item) {
    	if (item.quality <= 50) {
    		if (item.sellIn < 11 && item.sellIn > 5){
    			item.quality = item.quality + 2;
    			if (item.quality > 50) {
    				item.quality = 50;
    			}
    			updatesellIn(item);
    		}
    		else if (item.sellIn < 6 && item.sellIn > 0){
    			item.quality = item.quality + 3;
    			if (item.quality > 50) {
    				item.quality = 50;
    			}
    			updatesellIn(item);
    		}
    		else if (item.sellIn <= 0){
    			item.quality = 0;
    			updatesellIn(item);
    		}
            else{
                incquality(item);
                updatesellIn(item);
            }
    	}
        else{
            incquality(item);
            updatesellIn(item);
        }
    }
    
    private void UpdateSulfuras(Item item) {
        item.sellIn = item.sellIn;
        item.quality = item.quality;
    }
    
    private void UpdateConjured(Item item) {
    	//For Conjured Quality decrease twice. Hence, multiplier will be '2'
        decquality(item, 2);
        updatesellIn(item);
    }

    private void doUpdateQuality(Item item){
        if (item.name.equals(Aged_Brie)){
        	UpdateAgedBrie(item);
        }
        else if (item.name.equals(Backstage_passes)){
        	UpdateBackstagePasses(item);
        }
        else if (item.name.equals(Sulfuras)){
        	UpdateSulfuras(item);
        }
        else if (item.name.equals(Conjured)){
        	UpdateConjured(item);
        }
        else{
            decquality(item, 1);
            updatesellIn(item);
        }
    }
    
    //It will take multiplier as a input parameter
    private void decquality(Item item, Integer mul){
        if (item.quality > 0 && item.quality < 50){
            if (item.sellIn >0){
                item.quality = item.quality - 1*mul;
                if (item.quality < 0) {
    				item.quality = 0;
    			}
            }
            else{
                item.quality = item.quality - 2*mul;
                if (item.quality < 0) {
    				item.quality = 0;
    			}
            }
        }
        else{
            item.quality = item.quality;
        }
      
    }
    
    
    private void incquality(Item item){
        if (item.quality < 50 && item.quality >= 0){
            if (item.sellIn > 0){
                item.quality = item.quality + 1;
            }
            else{
                item.quality = item.quality + 2;
            }
        }
        else{
            item.quality = item.quality;
        }
    }

    private void updatesellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }


    public Item[] getItems() {
        return items;
      }
}
