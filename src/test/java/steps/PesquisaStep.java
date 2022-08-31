package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PesquisaStep {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Dado("^que estou na tela inicial do site$")
    public void que_estou_na_tela_inicial_do_site() {
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");
    }

    @Quando("^eu digito a palavra de busca$")
    public void eu_digito_a_palavra_de_busca() {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium Webdriver");

    }

    @Quando("^clico em pesquisar$")
    public void clico_em_pesquisar() {
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Quando("^clico no item$")
    public void clico_no_item() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]" +
                "/div/span[3]/div[2]/div[4]/div/div/div/div/div[1]/span/a/div/img")).click();
    }

    @Quando("^adiciono ao carrinho$")
    public void adiciono_ao_carrinho() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    @Então("^vejo os resultados da pesquisa$")
    public void vejo_os_resultados_da_pesquisa() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id
                ("add-to-cart-confirmation-image")));
        Assert.assertTrue(driver.findElement(By.id("add-to-cart-confirmation-image")).isDisplayed());
    }
}
