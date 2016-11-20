package com.javaclassloadingexample;

import java.lang.reflect.Field;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Object previousInstance = null;
    	Class<?> previousClass = null;
    	for (;;) {
    		    Class<?> myStaticClass = new Reloader().loadClass("com.javaclassloadingexample.MyStaticClass");
    		    Field field = null;
    		    try {
    		    	
    		    	// static field and static method
					field = myStaticClass.getDeclaredField("myNumber");
					System.out.println(field.get(null));
					myStaticClass.getDeclaredMethod("printANumber",null).invoke(null, null);
	    		    MyStaticClass.printANumber();

	    		    // instance field and instance method
	    		    Object obj = myStaticClass.newInstance();
	    		    myStaticClass.getMethod("printAnInstanceNumber").invoke(obj);	
	    		    if (previousInstance != null) {
	    		    	previousClass.getMethod("printAnInstanceNumber").invoke(previousInstance);	
	    		    }
	    		    
	    		    previousInstance = obj;
	    		    previousClass = myStaticClass;

	    		    Thread.sleep(2000);

				} catch (Exception e1) {
					e1.printStackTrace();
				} 
    		    
		  }    
	  }
}
