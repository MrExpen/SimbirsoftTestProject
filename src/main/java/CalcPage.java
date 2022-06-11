import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalcPage {
    protected WebDriver driver;

    private By InputElement = By.cssSelector("div.jlkklc");
    private By MemoryLine = By.cssSelector("span.vUGUtc");
    private By ResultLine = By.cssSelector("span.qv3Wpe");
    private By ButtonCalc = By.cssSelector("div.UUhRt");
    private By ButtonSin = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[1]/tbody/tr[2]/td[2]/div/div[1]");

    public CalcPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setExpression(String expression){
        driver.findElement(InputElement).sendKeys(expression.replace(" ", ""));
    }
    public void clickButtonCalc(){
        driver.findElement(ButtonCalc).click();
    }
    public void clickButtonSin(){
        driver.findElement(ButtonSin).click();
    }
    public String getMemoryValue(){
        return driver.findElement(MemoryLine).getText();
    }
    public String getResultValue(){
        return driver.findElement(ResultLine).getText();
    }

}
