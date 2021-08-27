package page;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class WikiNavigationPage {

    private static final String Function = "Function";
    private static final String Family = "Family";
    private static final String Mythology = "Mythology";
    private static final String Insociology = "In sociology";
    private static final String Honours = "Honours";
    private static final String Notes = "Notes";
    private static final String References = "References";
    private static final String FurtherReading = "Further reading";
    @FindBy(xpath = "//*[@id=\"toc\"]")
    public WebElement contentBox;
    @FindBy(className = "mw-headline")
    public List<WebElement> headerspresentOnPage;
    @FindBy(className = "toctitle")
    public WebElement contentHeaderName;
    @FindBy(xpath = "//*[@id=\"toc\"]/ul/li[1]")
    public WebElement hyperLinkFunction;
    @FindBy(xpath = "//*[@id=\"toc\"]/ul/li[2]")
    public WebElement hyperLinkFamily;
    @FindBy(xpath = "//*[@id=\"toc\"]/ul/li[3]")
    public WebElement hyperLinkMythology;
    @FindBy(xpath = "//*[@id=\"toc\"]/ul/li[4]")
    public WebElement hyperLinkInsociology;
    @FindBy(xpath = "//*[@id=\"toc\"]/ul/li[5]")
    public WebElement hyperLinkHonours;
    @FindBy(xpath = "//*[@id=\"toc\"]/ul/li[6]")
    public WebElement hyperLinkNotes;
    @FindBy(xpath = "//*[@id=\"toc\"]/ul/li[7]")
    public WebElement hyperLinkReferences;
    @FindBy(xpath = "//*[@id=\"toc\"]/ul/li[8]")
    public WebElement hyperLinkFurtherReading;
    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/table[3]/tbody/tr[6]/td/div/ul/li[13]/a")
    public WebElement linkNike;
    @FindBy(xpath = "//a[@class='mwe-popups-extract']")
    public WebElement hiddenNikePopup;
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait wait;

    public WikiNavigationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Linkmousehover(WebElement elementToMouseHover) throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.clickAndHold(elementToMouseHover).perform();
    }

    public boolean isHeaderAndHeadingMatches(ArrayList arr1, ArrayList arr2) {
        boolean isHeaderMatchwithHeading = false;
        if (arr1.size() != arr2.size()) {
            return isHeaderMatchwithHeading;
        } else {
            if (arr1.containsAll(arr2)) {
                isHeaderMatchwithHeading = true;
                for (int i = 0; i < arr1.size(); i++) {
                    for (int j = 0; j < arr2.size(); j++) {
                        if (arr1.get(i).equals(arr2.get(j))) {
                            System.out.println(
                                    "the " + arr1.get(i) + " listed in the `Contents` box are used as headings as "
                                            + arr2.get(i) + " on the Wiki page");
                        }
                    }
                }
            }
        }
        return isHeaderMatchwithHeading;
    }

    public void clickFunction(String linkName) throws InterruptedException {
        System.out.println("Clicking the hyperlink  " + linkName);
        wait = new WebDriverWait(driver, 10);
        boolean isLinkedClicked = false;
        switch (linkName) {
            case Function:
                Assert.assertTrue(linkName + " - Link is not working", hyperLinkFunction.isDisplayed()
                        && hyperLinkFunction.isEnabled());
                hyperLinkFunction.click();
                break;
            case Family:
                Assert.assertTrue(linkName + "- Link is not working ", hyperLinkFamily.isDisplayed()
                        && hyperLinkFamily.isEnabled());
                hyperLinkFamily.click();
                break;
            case Mythology:
                Assert.assertTrue(linkName + "- Link is not working ", hyperLinkMythology.isDisplayed()
                        && hyperLinkMythology.isEnabled());
                hyperLinkMythology.click();
                break;
            case Insociology:
                Assert.assertTrue(linkName + "- Link is not working ", hyperLinkInsociology.isDisplayed()
                        && hyperLinkInsociology.isEnabled());
                hyperLinkInsociology.click();
                break;
            case Honours:
                Assert.assertTrue(linkName + "- Link is not working ", hyperLinkHonours.isDisplayed()
                        && hyperLinkHonours.isEnabled());
                hyperLinkHonours.click();
                break;
            case Notes:
                Assert.assertTrue(linkName + "- Link is not working ", hyperLinkNotes.isDisplayed()
                        && hyperLinkNotes.isEnabled());
                hyperLinkNotes.click();
                break;
            case References:
                Assert.assertTrue(linkName + "- Link is not working ", hyperLinkReferences.isDisplayed()
                        && hyperLinkReferences.isEnabled());
                hyperLinkReferences.click();
                break;
            case FurtherReading:
                Assert.assertTrue(linkName + "- Link is not working ", hyperLinkFurtherReading.isDisplayed()
                        && hyperLinkFurtherReading.isEnabled());
                hyperLinkFurtherReading.click();
                break;
            default:
                throw new IllegalArgumentException("LinkName does not exit - " + linkName);
        }
    }

    public void mouseHoveronNikeLink() throws InterruptedException {
        Linkmousehover(linkNike);
    }

    public String reading_Tool_Tip() {
        WebElement nikeHoverText = new WebDriverWait(driver, 20).until(ExpectedConditions
                .visibilityOf(hiddenNikePopup));
        System.out.println("Message from popup -->" + nikeHoverText.getText());
        return nikeHoverText.getText();
    }

    public void click_on_nike_link() {
        linkNike.click();
    }
}
