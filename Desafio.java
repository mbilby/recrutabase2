package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DesafioBase2 {

    @Test
    public void casoDeTeste(){

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://mantis-prova.base2.com.br");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));

        usernameField.sendKeys("treinamento14");
        passwordField.sendKeys("123456");
        loginButton.click();

        WebElement usuarioLogadoTxt = driver.findElement(By.xpath("//td[@class='login-info-left']/span[@class='italic']"));
        String usuarioLogado = usuarioLogadoTxt.getText();
        Assert.assertEquals("Treinamento14", usuarioLogado);

        WebElement relatarCaso = driver.findElement(By.xpath("//a[text()='Relatar Caso']"));
        relatarCaso.click();

        WebElement categoriaField = driver.findElement(By.xpath("//select[@name='category_id']"));
        categoriaField.click();
        WebElement categoriaOption = driver.findElement(By.xpath("//option[text()='[Todos os Projetos] 7EI2PODHPN']"));
        categoriaOption.click();

        WebElement frequenciaField = driver.findElement(By.xpath("//select[@name='reproducibility']"));
        frequenciaField.click();
        WebElement frequenciaOption = driver.findElement(By.xpath("//option[text()='sempre']"));
        frequenciaOption.click();

        WebElement gravidadeField = driver.findElement(By.xpath("//select[@name='severity']"));
        gravidadeField.click();
        WebElement gravidadeOption = driver.findElement(By.xpath("//option[text()='pequeno']"));
        gravidadeOption.click();

        WebElement resumoField = driver.findElement(By.xpath("//input[@name='summary']"));
        resumoField.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec augue magna, egestas a consectetur eu, faucibus a neque. Nulla facilisi.");

        WebElement descricaoField = driver.findElement(By.xpath("//textarea[@name='description']"));
        descricaoField.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec augue magna, egestas a consectetur eu, faucibus a neque. Nulla facilisi.");

        WebElement reproducaoField = driver.findElement(By.xpath("//textarea[@name='steps_to_reproduce']"));
        reproducaoField.sendKeys("1 - Lorem ipsum dolor sit amet \n2 - Lorem ipsum dolor sit amet \n3 - Lorem ipsum dolor sit amet");

        WebElement enviarButton = driver.findElement(By.xpath("//input[@value='Enviar Relatório']"));
        enviarButton.click();

        boolean value = driver.findElement(By.xpath("//*[contains(text(), 'Operação realizada com sucesso')]")).isEnabled();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Imprimir Relatórios']")));



        Assert.assertTrue(value);

        WebElement categoria = driver.findElement(By.xpath("//td[text()='7EI2PODHPN']"));
        String dado1 = categoria.getText();

        Assert.assertEquals("7EI2PODHPN", dado1);

        WebElement gravidade = driver.findElement(By.xpath("//td[text()='pequeno']"));
        String dado2 = gravidade.getText();

        Assert.assertEquals("pequeno", dado2);

        WebElement resumo = driver.findElement(By.xpath("//td[text()='Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec augue magna, egestas a consectetur eu, faucibus a neque. Nulla fa']"));
        String dado3 = resumo.getText();

        Assert.assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec augue magna, egestas a consectetur eu, faucibus a neque. Nulla fa", dado3);




        driver.quit();
    }

}
