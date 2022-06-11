import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    protected WebDriver driver;

    private final By SearchField = By.cssSelector("input[name=\"q\"]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchText(String query) {
        driver.findElement(SearchField).sendKeys(query);
    }
    public void search(){
        driver.findElement(SearchField).sendKeys(Keys.RETURN);
    }
    public CalcPage searchCalc(){
        setSearchText("Калькулятор");
        search();
        return new CalcPage(driver);
    }
}
