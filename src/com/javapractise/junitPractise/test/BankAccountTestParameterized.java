package com.javapractise.junitPractise.test;

import com.javapractise.junitPractise.src.BankAccount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

//When we add below line: This automatically become test class
// In IntelliJ you can see two arrows on gutter once you add this line above the class
@RunWith(Parameterized.class)
public class BankAccountTestParameterized {
    private BankAccount bankAccount;




    @Before
    public void setup(){
        System.out.println("Before each test");
        bankAccount = new BankAccount("firstName1", "lastName1", 1000, BankAccount.CHECKING);
    }

    //Step2
    @Parameterized.Parameters
    public static Collection<Object> testConditionsForDeposit() {
        return Arrays.asList(
                new Object[][]
                        {
                                {100.00, true, 1100.00},
                                {200.00, true, 1200.00},
                                {325.14, true, 1325.14},
                                {489.33, true, 1489.33},
                                {1000.00, true, 2000.00}

                        });
    }

        //Step-3
        private double amount;
        private boolean branch;
        private double balance;

    public BankAccountTestParameterized(double amount, boolean branch, double balance) {
            this.amount = amount;
            this.branch = branch;
            this.balance = balance;
        }

        //Step-4
    @Test
    public void testDeposits(){
        bankAccount.deposit(amount, branch);
        assertEquals(balance, bankAccount.getBalance(),0.1);
        //Kept threshold error difference value to 0.1 otherwise test will fail as below if we keep that as 0
        /*
        Before each test

            java.lang.AssertionError:
            Expected :1325.14
            Actual   :1325.1399999999999
            <Click to see difference>
         */
        assertEquals(balance, bankAccount.getBalance(),0.1);
    }
}

//Step 1: Declare annotation of @Runwith(Parameterized.class)
//Step 2: Delcare Array of input parameters for the function that you are planning to test.
//     2.1: Use  @Parameterized.Parameters annotation
//     2.2: Function has be to Static
//Step 3: Create a constructor and build a object such that this can be passed to the test function in Step4
//Step 4: Create the function and use the object and class variables
