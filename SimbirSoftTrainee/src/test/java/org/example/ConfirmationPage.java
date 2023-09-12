package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {

    //констурктор для класса MainPage, занимающийся инициализацией полей класса
    public WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //локатор для Имени студента в таблице
    @FindBy(xpath = "//*[@class = 'table-responsive']/table/tbody/tr[1]/td[2]")
    private WebElement userFullName;
    //локатор для Email студента в таблице
    @FindBy(xpath = "//*[@class = 'table-responsive']/table/tbody/tr[2]/td[2]")
    private WebElement userEmail;
    //локатор для Пола студента в таблице
    @FindBy(xpath = "//*[@class = 'table-responsive']/table/tbody/tr[3]/td[2]")
    private WebElement userGender;
    //локатор для Мобильного номера студента в таблице
    @FindBy(xpath = "//*[@class = 'table-responsive']/table/tbody/tr[4]/td[2]")
    private WebElement userMobileNumber;
    //локатор для Даты рождения студента в таблице
    @FindBy(xpath = "//*[@class = 'table-responsive']/table/tbody/tr[5]/td[2]")
    private WebElement userBirthDate;
    //локатор для поля Subjects студента в таблице
    @FindBy(xpath = "//*[@class = 'table-responsive']/table/tbody/tr[6]/td[2]")
    private WebElement userSubjects;
    //локатор для поля Image студента в таблице
    @FindBy(xpath = "//*[@class = 'table-responsive']/table/tbody/tr[8]/td[2]")
    private WebElement userUploadImage;
    //локатор для Адреса студента в таблице
    @FindBy(xpath = "//*[@class = 'table-responsive']/table/tbody/tr[9]/td[2]")
    private WebElement userAddress;
    //локатор для поля State and City студента в таблице
    @FindBy(xpath = "//*[@class = 'table-responsive']/table/tbody/tr[10]/td[2]")
    private WebElement userStateAndCity;

    //метод для получения данных ФИО из таблицы + проверка наличия текста Thanks for submitting the form
    public String getUserFullName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Thanks for submitting the form']")));
        String userNameText = userFullName.getText();
        return userNameText;
    }
    //метод для получения данных Email из таблицы
    public String getUserEmail() {
        String userEmailText = userEmail.getText();
        return userEmailText;
    }
    //метод для получения данных Gender из таблицы
    public String getUserGender() {
        String userGenderText = userGender.getText();
        return userGenderText;
    }
    //метод для получения данных Mobile из таблицы
    public String getUserMobile() {
        String userMobileText = userMobileNumber.getText();
        return userMobileText;
    }
    //метод для получения данных BirthDate из таблицы
    public String getUserBirthDate() {
        String userBirthDateText = userBirthDate.getText();
        return userBirthDateText;
    }
    //метод для получения данных Mobile из таблицы
    public String getUserSubjects() {
        String userSubjectsText = userSubjects.getText();
        return userSubjectsText;
    }
    //метод для получения данных Image из таблицы
    public String getUserImage() {
        String userFileText = userUploadImage.getText();
        return userFileText;
    }
    //метод для получения данных Mobile из таблицы
    public String getUserAddress() {
        String userAddressText = userAddress.getText();
        return userAddressText;
    }
    //метод для получения данных Mobile из таблицы
    public String getUserStateAndCity() {
        String userStateAndCityText = userStateAndCity.getText();
        return userStateAndCityText;
    }
}
