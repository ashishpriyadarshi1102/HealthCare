package org.vtiger.genericutility;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class JavaUtility {
	
	/**
	 * This method will capture the local Date time 
	 * @return
	 */
	
	public String timeStamp()
	{
	 	String time = LocalDateTime.now().toString().replace(":", "_");
		
	 	return time;
	}
	
	/**
	 * This method will generate the random numbers
	 * @return
	 */
	
	public int randomNumber()
	{
		Random random = new Random();
		 int number = random.nextInt(1000000000);
		 return number;
	}
	
	public String randomData()
	{
		String data = UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "");
		return data;
	}

}
