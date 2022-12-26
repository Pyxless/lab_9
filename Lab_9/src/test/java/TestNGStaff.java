import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.log.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGStaff {
    @Test
    public void AddElementForManInFavorites() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://staff-clothes.by/");
        int expected = 1;
        WebElement ForManBtnElement = driver.findElement(By.xpath("//a/span[text()='Для парней']"));
        ForManBtnElement.click();
        WebElement addInFavoritesBtn = driver.findElement(By.xpath("//*[@id=\"pt-pageContent\"]/div/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/a"));
        addInFavoritesBtn.click();
        driver.get("https://staff-clothes.by/wishlist/");
        WebElement count_element = driver.findElement(By.xpath("//a[@class='pt-dropdown-toggle']/span[@class='pt-badge']"));
        int count = Integer.parseInt(count_element.getText());
        Assert.assertTrue(expected == count,String.valueOf(count));
    }
}
