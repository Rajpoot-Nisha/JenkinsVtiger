package generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryAnalyzer implements IRetryAnalyzer {
	
int count = 0;
int reTryLimit = 0;

public boolean retry(ITestResult result)
{
if(count<reTryLimit)
{
	count++;
	return true;
}
	
return false;	

}

}