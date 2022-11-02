import PageObject.MainPage;
import PageObject.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class OrderWithTopButton {
    private WebDriver driver;

    private String userName;
    private String nextName;
    private String adress;
    private String station;
    private String number;
    private String comment;

    public OrderWithTopButton(String userName, String nextName, String adress, String station, String number, String comment) {
        this.userName = userName;
        this.nextName = nextName;
        this.adress = adress;
        this.station=station;
        this.number=number;
        this.comment=comment;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        //Имя, Фамилия, Адрес, Метро, Номер телефона, Комментарий
        return new Object[][] {
                { "Глеб", "Дмитриев","Кутузовская 28","Лубянка","89057085320","Просто так"},
                { "Дима", "Антонов","Санкт-Петербург Ленина 8","Черкизовская","89957185320","Тестирую"},
        };

    }
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickFirstButtonOrder();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.orderPage(userName,nextName,adress,station,number,comment);
    }
    @After
    public void quitBrowser(){
        driver.quit();
    }
}




