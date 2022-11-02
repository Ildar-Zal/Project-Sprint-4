package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class OrderPage {
    private WebDriver driver;
    private final By firstNameField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private final By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By adressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath(".//div/input[@class='select-search__input']");
    private final By numberPhoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By calendarField = By.xpath("(.//input[@placeholder='* Когда привезти самокат'])");
    private final By calendarDateSeven = By.xpath(".//div[text()='7']");
    private final By rentalPeriodField = By.xpath("(.//div[@class='Dropdown-placeholder'])");
    private final By daySelectionFour = By.xpath("(.//div[text()='четверо суток'])");
    private final By checkBoxBlack = By.xpath("(.//input[@id='black'])");
    private final By commentField = By.xpath("(.//input[@placeholder='Комментарий для курьера'])");
    private final By buttonChoiseYes = By.xpath("(.//button[text()='Да'])");
    public OrderPage(WebDriver driver){
        this.driver=driver;
    }
    public void setFirstNameField(String username) {
        driver.findElement(firstNameField).click();
        driver.findElement(firstNameField).sendKeys(username);
    }
    public void setNextNameField(String nextName) {
        driver.findElement(secondNameField).click();
        driver.findElement(secondNameField).sendKeys(nextName);
    }
    public void setAdressField(String adress) {
        driver.findElement(adressField).click();
        driver.findElement(adressField).sendKeys(adress);
    }
    public void setMetroField(String station){
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys(station, Keys.ARROW_DOWN, Keys.ENTER);

    }


    public void setNumberField(String number){
        driver.findElement(numberPhoneField).sendKeys(number);
    }
    public void clickButtonNext(){
        driver.findElement(buttonNext).click();
    }
    public void clickDate(){
        driver.findElement(calendarField).click();
        driver.findElement(calendarDateSeven).click();
    }
    public void clickRental(){
        driver.findElement(rentalPeriodField).click();
        driver.findElement(daySelectionFour).click();
    }
    public void clickCheckBox(){
        driver.findElement(checkBoxBlack).click();
    }
    public void setComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickButtonChoise(){
        driver.findElement(buttonChoiseYes).click();
    }
    public void orderPage(String username,String nextName, String adress,String station,String number,String comment) {
     setFirstNameField(username);
     setNextNameField(nextName);
     setAdressField(adress);
     setMetroField(station);
     setNumberField(number);
     clickButtonNext();
     clickDate();
     clickRental();
     clickCheckBox();
     setComment(comment);
     clickButtonNext();
     clickButtonChoise();
    }



    }
