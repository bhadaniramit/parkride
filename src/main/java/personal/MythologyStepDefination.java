package personal;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.NikeWikiNavigationPage;
import pages.WikiNavigationPage;

public class MythologyStepDefination {

    String driverpath = "C:\\myAssignment\\chromedriver\\chromedriver.exe";
    private WebDriver driver;
    private String baseURL = "https://en.wikipedia.org/wiki/Metis_(mythology)";
    WikiNavigationPage wikiNavigationPage;
    ArrayList hyperlinkUnderContentList;
    ArrayList headersOnPageList;
    JavascriptExecutor javascriptExecutor;
    NikeWikiNavigationPage nikeWikiNavigationPage;
    String currentPageTitle;

    @BeforeClass
    @Given("User navigates to wiki Page")
    public void urlInvoke() {
        System.setProperty("webdriver.chrome.driver", driverpath);
        driver = new ChromeDriver();
        wikiNavigationPage = new WikiNavigationPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
        currentPageTitle = driver.getTitle();
        Assert.assertEquals("User is not on right page", currentPageTitle, "Metis (mythology) - Wikipedia");
    }

    @Given("User navigates to contents table and check of hyperlinks mentioned under table")
    public void user_navigates_to_contents_table_on_wiki_page() {
        // Write code here that turns the phrase above into concrete actions
        hyperlinkUnderContentList = new ArrayList<String>();
        WebElement readContentTable = wikiNavigationPage.contentBox;
        List<WebElement> contentTableLink = readContentTable.findElements(By.tagName("li"));
        for (WebElement newList : contentTableLink) {
            hyperlinkUnderContentList.add(newList.getText().substring(1).trim());
        }
        System.out.println(hyperlinkUnderContentList);
    }

    @Then("check all headings on the page")
    public void check_all_headings_on_the_page() {
        // Write code here that turns the phrase above into concrete actions
        headersOnPageList = new ArrayList<String>();
        List<WebElement> myHeaderList = wikiNavigationPage.headerspresentOnPage;
        for (int i = 0; i < myHeaderList.size(); i++) {
            headersOnPageList.add(myHeaderList.get(i).getText());
        }
    }

    @Then("Validate that headings on the page with the list mentioned under the content matches")
    public void validate_that_headings_on_the_page_with_the_list_mentioned_under_the_content_matches() {
        // Write code here that turns the phrase above into concrete actions
        for (Object links : hyperlinkUnderContentList) {
            System.out.println("Available Links under Content Table is " + links);
        }
        for (Object headers : headersOnPageList) {
            System.out.println("Available Headers on Wiki Page is " + headers);
        }
        boolean headingAndHeadersMatches = wikiNavigationPage
                .isHeaderAndHeadingMatches(hyperlinkUnderContentList, headersOnPageList);
        Assert.assertTrue("Headings on the page Matches with the list mentioned under the content",
                headingAndHeadersMatches = true);
    }

    @Then("validate all the links are navigating user respective headings")
    public void validate_all_the_links_are_navigating_user_respective_headings() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        for (Object linkClickValidation : hyperlinkUnderContentList) {
            wikiNavigationPage.clickFunction(linkClickValidation.toString());
        }
    }

    @Given("User validate NIKE hyperlink availibility")
    public void user_validate_hyperlink_availibility() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Nike link is not displayed",
                wikiNavigationPage.linkNike.isDisplayed() && wikiNavigationPage.linkNike.isEnabled(),
                !wikiNavigationPage.linkNike.isDisplayed() && !wikiNavigationPage.linkNike.isEnabled());
    }

    @When("User navigates to NIKE link")
    public void user_navigates_to_link() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        wikiNavigationPage.mouseHoveronNikeLink();
    }

    @Then("Validate the text displayed in the Nike popup")
    public void validate_the_text_displayed_in_the_nike_popup() {
        // Write code here that turns the phrase above into concrete actions
        String actualTextFromPopup = wikiNavigationPage.reading_Tool_Tip();
        String expectedMessageFromPopup = "In ancient Greek civilization, Nike was a goddess who personified victory. Her Roman equivalent was Victoria.";
        Assert.assertEquals("Text in popup doesnot matched", actualTextFromPopup, expectedMessageFromPopup);
    }

    @Then("click on the Nike hyperlink")
    public void click_on_the_nike_hyperlink() {
        // Write code here that turns the phrase above into concrete actions
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,950)");
        Assert.assertTrue("Nike link is not displayed",
                wikiNavigationPage.linkNike.isDisplayed() && wikiNavigationPage.linkNike.isEnabled());
        wikiNavigationPage.click_on_nike_link();
    }

    @Then("validate user navigated to Nike Page")
    public void validate_user_navigated_to_nike_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("User is not on Nike Mythology page ", driver.getTitle(), "Nike (mythology) - Wikipedia");
        nikeWikiNavigationPage = new NikeWikiNavigationPage(driver);
    }

    @Then("check for the family tree heading on the Nike page")
    public void check_for_the_family_tree_heading_on_the_nike_page() {
        // Write code here that turns the phrase above into concrete actions
        nikeWikiNavigationPage.validate_family_tree_header();
    }

    @AfterClass
    public void driver_close() {
        driver.close();
    }
}
