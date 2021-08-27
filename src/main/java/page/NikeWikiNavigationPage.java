package page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NikeWikiNavigationPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"Family_tree\"]")
    public WebElement headerFamilyTree;

    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/table[4]/tbody")
    public WebElement familyTreeTable;

    public NikeWikiNavigationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validate_family_tree_header() {
        Assert.assertTrue("Header family tree is not displayed", headerFamilyTree.isDisplayed());
        Assert.assertEquals("Header family tree name does not matches ", "Family tree", headerFamilyTree.getText());
        String familyTree[] = familyTreeTable.getText().split(" ");
        List familyTreeList = new ArrayList<String>(Arrays.asList(familyTree));
        System.out.println(familyTreeList);
    }


}
