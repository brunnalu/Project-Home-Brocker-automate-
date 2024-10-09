package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CompraTeste {
	WebDriver driver;
	ChromeOptions options=new ChromeOptions();
	
	
	@Test
	public void comprarAtivo() {
		options . addArguments("--start-maximized");
		driver=new ChromeDriver(options);
		driver.get("file:///C:/Users/user/AppData/Local/Temp/bba26c4e-701b-4a62-ac0c-1c1efbed41a2_hb.zip.1a2/hb/hb.html");
		driver.findElement(By.id("asset")).sendKeys("AAPL");
		driver.findElement(By.id("price")).sendKeys("25.00");
		driver.findElement(By.id("quantity")).sendKeys("10");
		driver.findElement(By.id("buy-button")).click();
		
		String saldoAtualizado= driver.findElement(By.id("balance")).getText();
		String carteiraAtualizada= driver.findElement(By.id("portfolio")).getText();
		assertEquals(saldoAtualizado,"R$9750.00");
		assertEquals(carteiraAtualizada,"AAPL: 10");
		driver.quit();
	}
	@Test
	public void compraPrecoErrado() {
		options . addArguments("--start-maximized");
		driver=new ChromeDriver(options);
		driver.get("file:///C:/Users/user/AppData/Local/Temp/bba26c4e-701b-4a62-ac0c-1c1efbed41a2_hb.zip.1a2/hb/hb.html");
		driver.findElement(By.id("asset")).sendKeys("AAPL");
		driver.findElement(By.id("price")).sendKeys("2.00");
		driver.findElement(By.id("quantity")).sendKeys("10");
		driver.findElement(By.id("buy-button")).click();
		
	}
}
