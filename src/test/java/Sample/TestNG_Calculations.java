package Sample;
import com.epam.tat.module4.*;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestNG_Calculations {

	Calculator calculator;
	
	@BeforeClass
    public void setUpClass() {
        System.out.println("Before Class: Initialize Calculator object");
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("After Class: Clean up resources");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method: Set up for the test");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method: Clean up after the test");
    }

    @Test(groups = "MathOperations")
    public void testAddition() {
        long result = calculator.sum(5, 3);
        System.out.println("After Method"+result);
        Assert.assertEquals(result, 8);
    }

    @Test(groups = "MathOperations")
    public void testSubtraction() {
        double result = calculator.sub(10, 4);
        Assert.assertEquals(result, 6);
    }

    @Test(groups = "MathOperations")
    public void testMultiplication() {
        long result = calculator.mult(4, 7);
        Assert.assertEquals(result, 28);
    }

    @Test(groups = "MathOperations")
    public void testDivision() {
        long result = calculator.div(10, 2);
        Assert.assertEquals(result, 5.0);
    }

    @Test(groups = "MathOperations")
    public void testDivisionByZero() {
        // This test is expected to throw an ArithmeticException
        Assert.expectThrows(ArithmeticException.class, () -> {
            calculator.div(10, 0);
        });
    }

    @Test(groups = "MathOperations")
    public void testSquareRoot() {
        double result = calculator.sqrt(25);
        Assert.assertEquals(result, 5.0);
    }

    @Test(groups = "MathOperations")
    public void testPower() {
        double result = calculator.pow(2, 3);
        Assert.assertEquals(result, 8.0);
    }

    @Test(groups = "MathOperations")
    public void testNegativeAddition() {
        long result = calculator.sum(-5, -3);
        Assert.assertEquals(result, -8);
    }

    @Test(groups = "MathOperations")
    public void testNegativeMultiplication() {
        long result = calculator.mult(-4, 7);
        Assert.assertEquals(result, -28);
    }

    @Test(groups = "MathOperations")
    public void testAdditionWithZero() {
        long result = calculator.sum(0, 7);
        Assert.assertEquals(result, 7);
    }
    
    @Test(groups = "MathOperations", dataProvider = "TestData")
    public void testPower(double base, double exponent, double expected) {
        double result = calculator.pow(base, exponent);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "TestData")
    public Object[][] powerData() {
        return new Object[][]{
            {2.0, 3.0, 8.0},
            {3.0, 2.0, 9.0},
            {4.0, 0.5, 2.0}
        };
    }
}
