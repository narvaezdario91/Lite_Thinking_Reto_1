package com.litethinking.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PriceTest extends BaseTest{

    WebElement phonesCategoryButton = getCategoryElement("Phones");
    WebElement laptopsCategoryButton = getCategoryElement("Laptops");
    WebElement monitorsCategoryButton = getCategoryElement("Monitors");



    @Test
    public void priceHTC(){
        phonesCategoryButton.click();
        Assertions.assertEquals("$700", getPriceCard(getProductCard("HTC One M9")));
    }

    @Test
    public void priceMacBook(){
        laptopsCategoryButton.click();
        Assertions.assertEquals("$1100", getPriceCard(getProductCard("MacBook Pro")));
    }

    @Test
    public void priceDell_i78Gb(){
        laptopsCategoryButton.click();
        Assertions.assertEquals("$700", getPriceCard(getProductCard("Dell i7 8gb")));
    }

    @Test
    public void priceAsusFullHD(){
        monitorsCategoryButton.click();
        Assertions.assertEquals("$230", getPriceCard(getProductCard("ASUS Full HD")));
    }

    @Test
    public void priceMacBookAir(){
        laptopsCategoryButton.click();
        Assertions.assertEquals("$700", getPriceCard(getProductCard("MacBook air")));
    }

    public String getPriceCard(WebElement productCard){
        return productCard.findElement(By.xpath("h5")).getText();
    }

    public WebElement getCategoryElement(String categoryName){
        return webDriver.findElement(By.xpath("//a[@class='list-group-item' and contains(text(),'"+categoryName+"')]"));
    }

    public WebElement getProductCard(String productName){
        return webDriver.findElement(By.xpath("//h4[contains(.,'"+productName+"')]/parent::div[@class='card-block']"));
    }
}
