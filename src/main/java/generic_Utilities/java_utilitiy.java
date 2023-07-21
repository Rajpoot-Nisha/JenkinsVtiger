package generic_Utilities;

import java.util.Random;

public class java_utilitiy {

	/**
	 * This method is used to avoid duplicates
	 * @return
	 * @author HP
	 * 
	 */
	
	public int getRandomNum()
	{
		 Random r = new Random();
	        int rabNum = r.nextInt(1000);
	        return rabNum;
		
	}

}
