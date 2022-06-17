import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    protected WebDriver driver;

    @FindBy(css = "input[name=\"q\"]")
    private WebElement searchField;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        init(this.driver);
    }


    public void setSearchText(String query) {
        searchField.sendKeys(query);
    }

    public void search(){
        searchField.sendKeys(Keys.RETURN);
    }

    public CalcPage searchCalc(){
        setSearchText("Калькулятор");
        search();
        return new CalcPage(driver);
    }


    private void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
