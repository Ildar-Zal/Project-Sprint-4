package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private WebDriver driver;
    private By firstButtonOrder = By.xpath("html/body/div/div/div/div/div/button[text()='Заказать']");
    private By nextButtonOrder = By.xpath((".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));



    public MainPage(WebDriver driver){
        this.driver=driver;
    }
     public void clickFirstButtonOrder(){
        driver.findElement(firstButtonOrder).click();
     }

     public void clickNextButtonOrder(){
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath((".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"))));
         driver.findElement(nextButtonOrder).click();
     }
     public String getTextAnswers(int index){
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath((".//div[text()='Катаетесь']"))));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath((".//div[@class ='accordion']"))));
         new WebDriverWait(driver, 20)
                 .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']")));
        driver.findElements(By.xpath("(.//div[@class='accordion__button'])")).get(index).click();
        return driver.findElements(By.xpath(".//div[@class='accordion__panel']/p")).get(index).getText();
    }
    }

