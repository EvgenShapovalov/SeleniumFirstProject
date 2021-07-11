import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TransferP2P {

    //1. Определение UI элементов для взаимодействия.
    By debitCard = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By firstName=By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By lastName=By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By debitCard2 = By.xpath("//input[@data-qa-node='numberreceiver']");
    By firstName1=By.xpath("//input[@data-qa-node='firstNamereceiver']");
    By lastName2=By.xpath("//input[@data-qa-node='lastNamereceiver']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By currency = By.xpath("//button[@data-qa-node='currency']");
    By currencyUsd = By.xpath("//button[@title='USD']");
    By comment = By.xpath("//span[@data-qa-node='toggle-comment']");
    By myFirstComent = By.xpath("//textarea[@data-qa-node='comment']");
    By submitButton = By.xpath("//button[@type='submit']");
    
    //2. Определение UI элементов корзины.
    By payerCard = By.xpath("//span[@data-qa-node='payer-card']");
    By receiverCard = By.xpath("//span[@data-qa-node='receiver-card']");
    By payerName = By.xpath("//div[@data-qa-node='payer-name']");
    By receiverName = By.xpath("//div[@data-qa-node='receiver-name']");
    By paymentSum = By.xpath("//div[@data-qa-node='payer-amount']");
    By commission = By.xpath("//div[@data-qa-node='payer-currency']");
    By receivingPayment = By.xpath("//div[@data-qa-node='receiver-amount']");
    By receiverCurrency = By.xpath("//div[@data-qa-node='receiver-currency']");
    By commentTransfer = By.xpath("//div[@data-qa-value='My First Automation Test']");

    //3. Написание тестов.
    @Test
    public void checkMinPaymentSum() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\10mut\\IdeaProjects\\AutomationProject\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //4. Действия с UI элементами.
        driver.get("https://next.privat24.ua/money-transfer/card");
        driver.findElement(debitCard).sendKeys("5309 2330 3476 5085");
        driver.findElement(expiredDate).sendKeys("0124");
        driver.findElement(cvv).sendKeys("891");
        driver.findElement(firstName).sendKeys("EVGEN");
        driver.findElement(lastName).sendKeys("SHAPOVALOV");
        driver.findElement(debitCard2).sendKeys("4506 9093 2427 4797");
        driver.findElement(firstName1).sendKeys("ANDREY");
        driver.findElement(lastName2).sendKeys("KLUCH");
        driver.findElement(amount).sendKeys("10");
        driver.findElement(currency).click();
        driver.findElement(currencyUsd).click();
        driver.findElement(comment).click();
        driver.findElement(myFirstComent).sendKeys("My First Automation Test");
        driver.findElement(submitButton).submit();


        // 5. Проверка ОР с ФР

        Assert.assertEquals("5309 2330 3476 5085", driver.findElement(payerCard).getText());
        Assert.assertEquals("4506 9093 2427 4797", driver.findElement(receiverCard).getText());
        Assert.assertEquals("Картка відправника", driver.findElement(payerName).getText());
        Assert.assertEquals("A***** K****", driver.findElement(receiverName).getText());
        Assert.assertEquals("10 USD", driver.findElement(paymentSum).getText());
        Assert.assertEquals("3.15 USD", driver.findElement(commission).getText());
        Assert.assertEquals("10 USD", driver.findElement(receivingPayment).getText());
        Assert.assertEquals("0 USD", driver.findElement(receiverCurrency).getText());
        Assert.assertEquals("My First Automation Test", driver.findElement(commentTransfer).getText());

    }
}
