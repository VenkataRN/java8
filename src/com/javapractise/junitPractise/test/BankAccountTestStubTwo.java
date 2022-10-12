package com.javapractise.junitPractise.test;

import com.javapractise.junitPractise.src.BankAccount;
import org.junit.*;

import static org.junit.Assert.*;

public class BankAccountTestStubTwo {

    private BankAccount bankAccount;

    @BeforeClass
   //public void beforeClass(){
    //Having beforeClass and afterClass ones non-static will give runtime error to declare as Statis
    public static void beforeClass(){
        System.out.println("Before the test suite");
    }

    //Runs  Before each test
    @Before
    public void setup(){
        System.out.println("Before each test");
         bankAccount = new BankAccount("firstName1", "lastName1", 1000, BankAccount.CHECKING);
    }

    @Test
    public void deposit() {
        System.out.println(" each test");
    }

    @Test
    public void wihtdrawBranch() {
        System.out.println(" each test");
        double balance = bankAccount.withdraw(600, true);
        assertEquals(400, balance, 0);
    }

    @Test
    public void testWillFailAsExceptionIsNotHandled() {
        System.out.println(" each test");
        double balance = bankAccount.withdraw(600, false);
        assertEquals(400, balance, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wihtdrawATMHandlingExceptionSoTestWillPassAndCanTestNegativeScenario() {
        System.out.println(" each test");
        double balance = bankAccount.withdraw(600, false);
        assertEquals(400, balance, 0);
    }
    @Test
    public void isChecking() {
        System.out.println(" each test");
    }

    //Runs  after each test
    @After
    public void after(){
        System.out.println("after each test");
    }

    //Runs after whole test suite.
    @AfterClass
    public static void afterClass(){
        System.out.println("After the test suite");
    }
}