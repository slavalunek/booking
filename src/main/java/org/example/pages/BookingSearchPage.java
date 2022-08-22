package org.example.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BookingSearchPage {

    public void searchInCatalog(String searchText){
        $x("//input[@name='ss']").sendKeys(searchText);
        $x("//div[text()='Orbi City Hotel Batumi']").shouldBe(enabled);
    }

    public void clickOnTheHotel(){
        $x("//div[text()='Orbi City Hotel Batumi']").click();
    }

    public void clickOnTheSearchButton(){
        $x("//span[text()='Search']").click();
        $x("//span[text()='Search results']").shouldBe(enabled);
    }

    public ElementsCollection getSearchResultHotelName() {
        return $$x("//div[@data-testid='title']");
    }

    public String getHotelRating() {
        return $x("//div[text()='Orbi City Hotel Batumi']//ancestor::div[@data-testid='property-card']" +
                "//div[@aria-label='Scored 8.0 ']").getText();
    }
}