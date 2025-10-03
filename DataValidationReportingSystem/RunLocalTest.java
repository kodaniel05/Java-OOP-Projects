import org.junit.Test;
import org.junit.After;
import java.lang.reflect.Field;
import org.junit.Assert;
import org.junit.Before;
import org.junit.rules.Timeout;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * A framework to run public test cases.
 *
 * <p>Purdue University -- CS18000 -- Spring 2021</p>
 *
 * @author Purdue CS 
 * @version January 19, 2021
 */
public class RunLocalTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
        	for (Failure failure : result.getFailures()) {
            	System.out.println(failure.toString());
        	}
        }
    }
    
    /**
     * A set of public test cases.
     *
     * <p>Purdue University -- CS18000 -- Spring 2021</p>
     *
     * @author Purdue CS 
     * @version January 19, 2021
     */
    public static class TestCase {
        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;
        
        @SuppressWarnings("FieldCanBeLocal")
	    private ByteArrayInputStream testIn;

	    @SuppressWarnings("FieldCanBeLocal")
	    private ByteArrayOutputStream testOut;
        
	    @Before
	    public void outputStart() {
		    testOut = new ByteArrayOutputStream();
		    System.setOut(new PrintStream(testOut));
	    }
        
        @After
	    public void restoreInputAndOutput() {
		    System.setIn(originalSysin);
		    System.setOut(originalOutput);
	    }
        
        private String getOutput() {
		    return testOut.toString();
	    }
        
        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        } 
       
        
        @Test(timeout = 1000)
        public void classDeclarationTestOne() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = Company.class;
            
            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Company` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `Company` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `Company` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `Company` implements no interfaces!", 0, superinterfaces.length);
        }
        
        @Test(timeout = 1000)
        public void classDeclarationTestTwo() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = DataSystem.class;
            
            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `DataSystem` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `DataSystem` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `DataSystem` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `DataSystem` implements no interfaces!", 0, superinterfaces.length);
        }
        
        @Test(timeout = 1000)
        public void classDeclarationTestThree() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = Report.class;
            
            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Report` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `Report` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `Report` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `Report` implements no interfaces!", 0, superinterfaces.length);
        }
        
        @Test(timeout = 1000)
        public void classDeclarationTestFour() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = Validator.class;
            
            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Validator` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `Validator` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `Validator` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `Validator` implements no interfaces!", 0, superinterfaces.length);
        }
        
        @Test(timeout = 1000)
        public void classDeclarationTestFive() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = WrongFormatException.class;
            
            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `WrongFormatException` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `WrongFormatException` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `WrongFormatException` extends `Exception`!", Exception.class, superclass);

            Assert.assertEquals("Ensure that `WrongFormatException` implements no interfaces!", 0, superinterfaces.length);
        }
        
        @Test(timeout = 1000)
        public void classDeclarationTestSix() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = InvalidPriceException.class;
            
            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `InvalidPriceException` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `InvalidPriceException` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `InvalidPriceException` extends `Exception`!", Exception.class, superclass);

            Assert.assertEquals("Ensure that `InvalidPriceException` implements no interfaces!", 0, superinterfaces.length);
        }
		

    }    
}
