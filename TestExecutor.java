package source;


public class TestExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AcciMarketSecurityTests test = new AcciMarketSecurityTests();
		test.setProperties();
		test.setUpSelenium();
		test.testEmptyPassword();
		test.closeSelenium();
		

	}

}
