package com.javapractise.junitPractise.test;

import com.javapractise.junitPractise.src.BankAccount;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {


    @org.junit.Test
    public void deposit() {
        //Method 1 (All are local)
        BankAccount bankAccount = new BankAccount("firstName1", "lastName1", 1000, BankAccount.CHECKING);
        bankAccount.deposit(100,true);

        //Below one is deprecated as new one with delta is introduced. Delta is helpful for double data types.
        //Assert.assertEquals(1100, bankAccount.getBalance());
        Assert.assertEquals(1100, bankAccount.getBalance(), 0);
    }

    @org.junit.Test
    public void wihtdraw() {
        BankAccount bankAccount = new BankAccount("firstName1", "lastName1", 1000, BankAccount.CHECKING);
        bankAccount.withdraw(100,true);

        //Below one is deprecated as new one with delta is introduced. Delta is helpful for double data types.
        //Assert.assertEquals(1100, bankAccount.getBalance());
        Assert.assertEquals(900, bankAccount.getBalance(), 0.0);
    }

    @Test
    public void testToFailaTestCaseByForce() {
        //Below style can be used by addingthis line where the test should never reach to this line.
        fail("Why is the test reaching this line? it should never reach this line");
    }

    @Test
    public void testToChecking(){
        BankAccount bankAccount = new BankAccount("firstName1", "lastName1", 1000, BankAccount.CHECKING);
        assertEquals(true, bankAccount.isChecking());
        //OR
        assertTrue(bankAccount.isChecking());
        assertTrue("This account is not of type CHECKING", bankAccount.isChecking());
    }
}