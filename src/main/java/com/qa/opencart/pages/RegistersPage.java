package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.Constants;

public class RegistersPage 
{
	public  WebDriver driver;

	

	 public RegistersPage(WebDriver driver) {
		this.driver=driver;
	}

	

	 private By firstNameTxt=By.id("input-firstname");
	 private By lastNameTxt=By.id("input-lastname");
	 private By emailTxt=By.id("input-email");
	 private By telephoneTxt=By.id("input-telephone");
	 private By passwordTxt=By.id("input-password");
	 private By confirmPasswordTxt=By.id("input-confirm");
	 private By subscribeYes=By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value='1']");
	 private By subscribeNo=By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value='0']");
	 private By agreeCheckBox=By.name("agree");
	 private By continueBtn=By.xpath("//input[@value='Continue']");
	 private By successMsg=By.cssSelector("div#content h1");
	 private By logoutLnkd=By.linkText("Logout");
	 private By registerLnkd=By.linkText("Register");

	public boolean accountRegisteration(String firstName,String lastName,String email,String telephone,String password,String subscribe) 
	 {
		 driver.findElement(firstNameTxt).sendKeys(firstName);
		 driver.findElement(lastNameTxt).sendKeys(lastName);
		 driver.findElement(emailTxt).sendKeys(email);
		 driver.findElement(telephoneTxt).sendKeys(telephone);
		 driver.findElement(passwordTxt).sendKeys(password);
		 driver.findElement(confirmPasswordTxt).sendKeys(password);
		 
		 if(subscribe.equalsIgnoreCase("yes")) 
		 {
			 driver.findElement(subscribeYes).click();
		 }
		 else 
		 {
			 driver.findElement(subscribeNo).click();
		 }
		 
		 driver.findElement(agreeCheckBox).click();
		 driver.findElement(continueBtn).click();
		 
		 if(getAccountRegisterSuccessMsg().contains(Constants.REGISTER_SUCCESS_MESSAGE)) 
		 {
			 goToRegisterPage();
			 return true;
		 }
		 return false;
	 }
	 
	 public String getAccountRegisterSuccessMsg() 
	 {
		 return driver.findElement(successMsg).getText();
	 }
	 
	 public void goToRegisterPage() 
	 {
		 driver.findElement(logoutLnkd).click();
		 driver.findElement(registerLnkd).click();
	 }
	 
}
