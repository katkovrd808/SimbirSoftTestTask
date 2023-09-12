package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class FillFormTest {
    public static MainPage mainPage;
    public static ConfirmationPage confPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("baseUrl"));
        //создание экземпляра главной страницы
        mainPage = new MainPage(driver);
        //создание экземпляра страницы с таблицей
        confPage = new ConfirmationPage(driver);
        //создание метода JS, закрывающего нижний iframe
        WebElement iFrame = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//iframe[@id = 'google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0']")));
        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].remove();", iFrame);
        //метод, изменяющий атрибут Style у Footer на Null
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footer = driver.findElement(By.xpath("//*[@id=\"app\"]/footer"));
        js.executeScript("arguments[0].setAttribute('style', 'display: none')", footer);
        //метод, изменяющий атрибут Style у Div, который мешает нажатию на кнопку Submit на Null
        WebElement div = driver.findElement(By.xpath("//*[@id='fixedban']/div/div[1]"));
        js.executeScript("arguments[0].setAttribute('style', 'display: none')", div);
        //метод изменяющий атрибут Style у Div, который мешает нажатию на кнопку Submit на Null
        WebElement googleAd = driver.findElement(By.xpath("//*[@id = 'adplus-anchor']/div"));
        js.executeScript("arguments[0].setAttribute('style', 'display: none')", googleAd);
    }
    @Test
    public void fillFormTest() {
        //заполняем поле First Name
        mainPage.insertFirstName(ConfProperties.getProperty("name"));
        //заполняем поле Last Name
        mainPage.insertLastName(ConfProperties.getProperty("secName"));
        //заполняем поле Email
        mainPage.insertEmail(ConfProperties.getProperty("email"));
        //выбираем радиобаттон Male
        mainPage.selectMale();
        //заполняем поле Mobile
        mainPage.insertMobile(ConfProperties.getProperty("mobile"));
        //выбираем дату рождения 22.05.2002
        mainPage.selectBirthDate();
        //заполняем поле Subject
        mainPage.selectSubject(ConfProperties.getProperty("subjectName"));
        //загружаем изображение
        mainPage.importImage(ConfProperties.getProperty("image"));
        //заполняем поле Current Address
        mainPage.sendAddress(ConfProperties.getProperty("address"));
        //выбираем штат NCR
        mainPage.selectState();
        //выбираем город Delhi
        mainPage.selectCity();
        //нажимем на кнопку Submit
        mainPage.clickSubmitBtn();
        //получаем ФИО пользователя, сверяем с данными в конфиге и проверяем отобразилась ли таблица
        String userName = confPage.getUserFullName();
        Assert.assertEquals(ConfProperties.getProperty("fullName"), userName );
        //получаем Email пользователя, сверяем с данными в конфиге
        String userEmail = confPage.getUserEmail();
        Assert.assertEquals(ConfProperties.getProperty("email"), userEmail );
        //получаем Gender пользователя, сверяем с данными в конфиге
        String userGender = confPage.getUserGender();
        Assert.assertEquals(ConfProperties.getProperty("gender"), userGender );
        //получаем Mobile пользователя, сверяем с данными в конфиге
        String userMobile = confPage.getUserMobile();
        Assert.assertEquals(ConfProperties.getProperty("mobile"), userMobile );
        //получаем Date of Birth пользователя, сверяем с данными в конфиге
        String userBirthDate = confPage.getUserBirthDate();
        Assert.assertEquals(ConfProperties.getProperty("birthDate"), userBirthDate );
        //получаем Subjects пользователя, сверяем с данными в конфиге
        String userSubject = confPage.getUserSubjects();
        Assert.assertEquals(ConfProperties.getProperty("subjectName"), userSubject );
        //получаем Picture пользователя, сверяем с данными в конфиге
        String userImage = confPage.getUserImage();
        Assert.assertEquals(ConfProperties.getProperty("imageName"), userImage );
        //получаем Address пользователя, сверяем с данными в конфиге
        String userAddress = confPage.getUserAddress();
        Assert.assertEquals(ConfProperties.getProperty("address"), userAddress );
        //получаем State and City пользователя, сверяем с данными в конфиге
        String userStateAndCity = confPage.getUserStateAndCity();
        Assert.assertEquals(ConfProperties.getProperty("stateAndCity"), userStateAndCity );
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
