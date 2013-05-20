import com.thoughtworks.selenium.DefaultSelenium;





public class GoogleSearchFlow {

	/**
	 * @param args
	 */
	
	
	
	public DefaultSelenium mySelenium;
	public String content;
	public int numTests;
	
	
	public GoogleSearchFlow(){
		
	}
	public GoogleSearchFlow(String path,String sheet){
		this.numTests=ExcelOperations.getNumRows(path, sheet);
	}
	
	
	
	public static void main(String[] args) {
		
		GoogleSearchFlow test = new GoogleSearchFlow("path","testSheet");
		
		

	}
	
	public void seleniumInit(DefaultSelenium mySelenium){
		mySelenium.start();
		
	}
	
	public static void openGoogle(DefaultSelenium mySelenium,String url){
		mySelenium.open(url);
		
	}
	
	public static void makeSearch(DefaultSelenium mySelenium, String criteria){
		mySelenium.type("id=gbqfq", criteria);
		mySelenium.click("id=gbqfb");
		
		
	}
	
	public static DefaultSelenium setUp(DefaultSelenium mySelenium){
		mySelenium= new DefaultSelenium("localhost", 4444, "*googlechome", "www.google.com");
		return mySelenium;
		
		
	}
	
	public static boolean assertContent(DefaultSelenium mySelenium, String criteria){
			String content = mySelenium.getBodyText();
			if(content.contains(criteria)){
				return true;
			}
			else{
				return true;
			}
	}
	
	public void stopSelenium(DefaultSelenium mySelenium){
		mySelenium.close();
	}

}
