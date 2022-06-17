import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcPage {
    protected WebDriver driver;

    @FindBy(css = "div.jlkklc")
    private WebElement inputElement;
    @FindBy(css = "span.vUGUtc")
    private WebElement memoryLine;
    @FindBy(css = "span#cwos")
    private WebElement resultLine;
    @FindBy(css = "div[aria-label=\"равно\"]")
    private WebElement buttonCalc;

    public CalcPage(WebDriver driver) {
        this.driver = driver;
        init(this.driver);
    }


    public void setExpression(String expression){
        inputElement.sendKeys(expression.replace(" ", ""));
    }

    public void clickButtonCalc(){
        buttonCalc.click();
    }

    public void addEmptySin(){
        setExpression("s)");
    }

    public String getMemoryValue(){
        return memoryLine.getText();
    }

    public String getResultValue(){
        return resultLine.getText();
    }


    private void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
