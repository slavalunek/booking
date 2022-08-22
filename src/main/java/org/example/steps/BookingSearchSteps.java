package org.example.steps;

import com.codeborne.selenide.ElementsCollection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.BookingSearchPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingSearchSteps {

    BookingSearchPage bookingSearchPage = new BookingSearchPage();

    @Given("User is on {string} page")
    public void userIsOnPage(String url) {
        open(url);
    }

    @And("The browser is maximized")
    public void theBrowserIsMaximized() {
        getWebDriver().manage().window().maximize();
    }

    @When("User searches for {string}")
    public void userSearchesFor(String searchText) {
        bookingSearchPage.searchInCatalog(searchText);
        bookingSearchPage.clickOnTheHotel();
    }

    @And("The Button clicked")
    public void theButtonClicked() {
        bookingSearchPage.clickOnTheSearchButton();
    }

    @Then("{string} is the first search result")
    public void isTheFirstSearchResult(String searchResultHotel) {
        ElementsCollection hotelNames = bookingSearchPage.getSearchResultHotelName();
        String actualName = hotelNames.first().getText();
        assertThat(actualName).as("The first search result in incorrect").contains(searchResultHotel);
        String actualRating = bookingSearchPage.getHotelRating();
        assertThat(actualRating).as("The hotel rating in incorrect").isEqualTo("8.0");
    }
}

