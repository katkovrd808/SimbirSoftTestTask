package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {

    //констурктор для класса MainPage, занимающийся инициализацией полей класса
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //локтор для поля First Name
    @FindBy(css = "input.form-control[id^='f']")
    private WebElement firstName;
    //локатор для поля Last Name
    @FindBy(id = "lastName")
    private WebElement lastName;
    //локатор для поля Email
    @FindBy(xpath = "//*[@id = 'userEmail-wrapper']/div[2]/input")
    private WebElement userEmail;
    //локтор для селектора Gender - Male
    @FindBy(xpath = "//div[@id = 'genterWrapper']/div[2]/div[1]/label")
    private WebElement genderMale;
    //локатор для селектора Gender - Female
    @FindBy(xpath = "//div[@id = 'genterWrapper']/div[2]/div[2]/label")
    private WebElement genderFemale;
    //локатор для поля Mobile
    @FindBy(xpath = "//*[@id = 'userNumber']")
    private WebElement userNumber;
    //локатор для поля Date of Birth
    @FindBy(xpath = "//*[@id = 'dateOfBirthInput']")
    private WebElement birthDate;
    //локатор для числа рождения в таблице Дата рождения
    @FindBy(xpath = "//*[@class = 'react-datepicker__month']/div[4]/div[4]")
    private WebElement birthDateTable;
    //локатор для поля Subjects
    @FindBy(xpath = "//*[@id= 'subjectsWrapper']/div[2]")
    private WebElement subjects;
    //локатор для поля Maths в выпадающем списке Subjects
    @FindBy(xpath = "//*[contains(@class, 'subjects-auto-complete__menu-list')]")
    private WebElement mathsList;
    //локатор для кнопки Выберите файл(изображение)
    @FindBy(xpath = "//*[@id = 'uploadPicture']")
    private WebElement uploadImage;
    //локатор для поля Current Address
    @FindBy(css = "textarea.form-control")
    private WebElement currentAddress;
    //локатор для селектора State
    @FindBy(xpath = "//*[@id = 'state']/div/div[2]")
    private WebElement state;
    //локатор для значения NCR в выпадающем списке State
    @FindBy(xpath = "//div[@id = 'react-select-3-option-0']")
    private WebElement stateNCR;
    //локатор для селектора City
    @FindBy(xpath = "//*[@id = 'city']")
    private WebElement city;
    //локатор для значения Delhi в выпадающем списке City
    @FindBy(xpath = "//*[@id = 'react-select-4-option-0']")
    private WebElement cityDelhi;
    //локатор для кнопки Submit
    @FindBy(xpath = "//*[@class='text-right col-md-2 col-sm-12']")
    private WebElement submitBtn;

    //метод для ввода данных в поле First Name
    public void insertFirstName(String name) {
        firstName.sendKeys(name);
    };
    //метод для ввода данных в поле Last Name
    public void insertLastName(String secName) {
        lastName.sendKeys(secName);
    }
    //метод для ввода данных в поле Email
    public void insertEmail(String email) {
        userEmail.sendKeys(email);
    }
    //метод для ввода данных в поле Mobile
    public void insertMobile(String mobile) {
        userNumber.sendKeys(mobile);
    }
    //метод для выбора Мужского пола
    public void selectMale() {
        genderMale.click();
    }
    //метод для выбора даты рождения
    public void selectBirthDate() {
        birthDate.click();
        Select birthMonth = new Select(driver.findElement(By.xpath("//*[@class = 'react-datepicker__month-select']")));
        Select birthYear = new Select(driver.findElement(By.xpath("//*[@class = 'react-datepicker__year-select']")));
        birthMonth.selectByVisibleText("May");
        birthYear.selectByVisibleText("2002");
        birthDateTable.click();
    }
    //метод для ввода данных в поле Subjects и выбор значения из выпадающего списка
    public void selectSubject(String subjectName) {
        subjects.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id= 'subjectsInput']")));
        driver.findElement(By.xpath("//*[@id= 'subjectsInput']")).sendKeys(subjectName);
        mathsList.click();
    }
    //метод для загрузки изображения в форму
    public void importImage(String image) {
        uploadImage.sendKeys(image);
    }
    //метод для ввода данных в поле Current Address
    public void sendAddress(String address) {
        currentAddress.sendKeys(address);
    }
    //метод для выбора штата NCR из выпадающего списка State
    public void selectState() {
        state.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'react-select-3-option-0']")));
        stateNCR.click();
    }
    //метод для выбора города Delhi из выпадающего списка State
    public void selectCity() {
        city.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id = 'react-select-4-option-0']")));
        cityDelhi.click();
    }
    //метод для нажатия на кнопку Submit
    public void clickSubmitBtn() {
        submitBtn.click();
    }
}
