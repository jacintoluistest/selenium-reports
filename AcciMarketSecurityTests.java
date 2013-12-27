/**
 * @author luisja
 * Date 12/24/2013
 * Clase que ejecuta pruebas de seguridad para Accitrade
 * Basados en las revisadas en Quality Center.
 */

package source;
import com.thoughtworks.selenium.DefaultSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class AcciMarketSecurityTests {
	Properties propiedad;
	
	//Selenium instance variables locators
	String user;
	String pass;
	String userTextLocator;
	String passTextLocator;
	String aceptarButton;
	String limpiarButton;
	
	String propertiesPath="";
	String urlBase;
	String urlPath;
	String screenShootPath;
	
	
	/*Selenium WebDriver
	 * 
	 */
	WebDriver wb;
	WebElement element;
	
	
	
	/* Selenium instance variables
	 * 
	 */
	
	DefaultSelenium mySelenium;
	
	String serverHost;
	int	serverPort;
	String browserStartCommand;
	String browserURL;
	
	
	
	

	public void setUpSelenium(){
		wb=new HtmlUnitDriver();		
	}
	
	public void testEmptyPassword(){
		wb.get("/appserver/jsp/amlogin.jsp?lg=cgam");
		element.findElement(By.id("usuario"));
		
//		mySelenium.type(userTextLocator,user);
//		mySelenium.type(passTextLocator, "");
//		System.out.println(mySelenium.isElementPresent(aceptarButton));
//		mySelenium.focus(aceptarButton);
//		mySelenium.click(aceptarButton);
//		System.out.println(mySelenium.getAlert());
//		
		
		
		
		mySelenium.captureScreenshot(screenShootPath+"\\testEmptyPassword.jpg");
		
	}
	
	public void testBadPassword(){
		
	}
	
	public void testCancelPoliticsBanner(){
		
	}
	
	public void existsPoliticBanner(){
		
	}
	
	public void logout(){
		
	}
	
	public void acceptPoliticsBanner(){
		
	}
	
	public void blockAccount(){
		
	}
	
	public void setProperties(){
		System.out.println("Cargando propiedades");
		propiedad = new Properties();
		try{
			
			
			
			propiedad.load(new FileInputStream("AcciTradeSecurityTests.properties")); 
			
			//Selenium constructor instance variables
			serverHost=propiedad.getProperty("serverHost");
			serverPort = Integer.valueOf( propiedad.getProperty("serverPort"));
			browserStartCommand=propiedad.getProperty("browserStartCommand");
			browserURL=propiedad.getProperty("browserURL");
			
			//PathScreenShoot
			screenShootPath=propiedad.getProperty("screenShootPathLocal");
			
			//Locators
			
			user = propiedad.getProperty("user");
			pass= propiedad.getProperty("pass");
			userTextLocator=propiedad.getProperty("userTextBox");
			passTextLocator=propiedad.getProperty("passTextBox");
			aceptarButton=propiedad.getProperty("aceptarButton");
			limpiarButton=propiedad.getProperty("limpiarButton");
			
			
		}
		
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void closeSelenium(){
		mySelenium.stop();
	}
	
	
	//Getters and Setters
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUserTextLocator() {
		return userTextLocator;
	}

	public void setUserTextLocator(String userTextLocator) {
		this.userTextLocator = userTextLocator;
	}

	public String getPassTextLocator() {
		return passTextLocator;
	}

	public void setPassTextLocator(String passTextLocator) {
		this.passTextLocator = passTextLocator;
	}

	public String getPropertiesPath() {
		return propertiesPath;
	}

	public void setPropertiesPath(String propertiesPath) {
		this.propertiesPath = propertiesPath;
	}

	public String getUrlBase() {
		return urlBase;
	}

	public void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public Properties getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Properties propiedad) {
		this.propiedad = propiedad;
	}
	
	
	public void setSelenium(){
		
	}


}
