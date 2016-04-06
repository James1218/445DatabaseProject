package tsp;

/**
 *************************************************************
 *Comments by prof.
 *************************************************************
 * File name:   DataValidation.java
 * @author:     Jason Nam
 * Created on:  6 / 4 / 2014
 * @version:    1.0
 * Platform:    Windows 8, NetBeans 8.0,
 *************************************************************
 */

public class DataValidation 
{
    /**
     * Method name : checkInteger
     * 
     * @param testingString
     * @return isInteger
     */
    public boolean checkInteger(String testingString)
    {
        boolean isInteger = true;
        
        try 
        {
            Integer.parseInt(testingString);
            isInteger = true;
        }
        catch (NumberFormatException nfe) 
        {
            isInteger = false;
        }
        
        return isInteger;
    }
     
    /**
     * Method name : chechValueType()
     * @param testingTarget
     * @return qualifiedPass
     */
    public boolean chechValueType(String[] testingTarget)
    {
        boolean qualifiedPass = true;
        
        for(int i = 0; i < testingTarget.length; i++)
        {
            try
            {
                Integer.valueOf(testingTarget[i]);
            }
            catch(NumberFormatException e)
            {
                qualifiedPass = false;
                break;
            }
        }
        
        return qualifiedPass;
    }  
}
