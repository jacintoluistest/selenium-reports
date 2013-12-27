package seleniumObjects;
import com.thoughtworks.selenium.DefaultSelenium;
public interface Navigable {
	
	public boolean open(String url,DefaultSelenium mySelenium);
	public boolean type(String locatorInput,int value,DefaultSelenium mySelenium);
	public boolean type(String locatorInput,String value,DefaultSelenium mySelenium);
	public boolean type(String locatorInput,char[] value,DefaultSelenium mySelenium);
	public boolean click(String locatorElement,DefaultSelenium mySelenium);
	

}
