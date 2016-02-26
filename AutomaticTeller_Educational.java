/*
Name: Alexander Georgiadis (RezTech)
Date Started: 9/2/2015
Date Last Edited: 9/3/2015
Description: This is a partially complex automatic teller (ATM) program, to be used with RTPWJ (Ready To Program With Java).
*/

import java.awt.*;
import hsa.Console;

public class AutomaticTeller_Educational
{
    static Console c;
    static double startAmmount = 1337; //By making this a static double, it is acsessable to all methods, as well as can have deciaml points for cents values, although ATM's cant dispence coins

    public static void main (String[] args)
    {
        c = new Console ();
        menu (); //Initial Menu
    }


    public static void menu ()
    {
        //Variable
        String selection;

        //Prompt
        c.println ("Welcome! Please select one of the following promps by entering the corisponding number, then press the <Enter> key to continue.");
        c.println ("1. Deposit\n2. Withdraw\n3. Print Current Balance\n4. Quit"); //\n creates a new line, so we do not have to have four sepreate lines for each option
        selection = c.readLine (); //Prevent crashes if someone enters a space

        //Make Sure A Valid Option Is Selected
        while ((!(selection.equals ("1"))) && (!(selection.equals ("2"))) && (!(selection.equals ("3"))) && (!(selection.equals ("4"))))
        {
            c.clear ();
            c.println ("We are sorry, but please select one of the following promps by entering the corisponding number, then press the <Enter> key to continue.");
            c.println ("1. Deposit\n2. Withdraw\n3. Print Current Balance\n4. Quit"); //\n creates a new line, so we do not have to have four sepreate lines for each option
            selection = c.readLine (); //Prevent crashes if someone enters a space
        }

        int slectionint = Integer.parseInt (selection); //If the String is a valid int, convert it to be used in a switch

        //Call Methods Depending On Our Selected Input
        switch (slectionint)
        {
            case (1):
                {
                    deposit ();
                    break; //Do not forget this, if you do, it will trigger all of the switch statements, not just this one
                }
            case (2):
                {
                    withdraw ();
                    break;
                }
            case (3):
                {
                    printBalance ();
                    break;
                }
            default: //case (4): or default: is valid here, as we forced the entry of either 1, 2, 3, or 4 using the while statement
                {
                    quit ();
                    break;
                }
        }
    }


    //Deposit Method
    public static void deposit ()
    {
        //Variable
        double value = 0;

        //Prompt
        c.clear ();
        c.println ("Okay, how much money would you like to deposit? (Please use the following format: 2.45)");
        value = c.readDouble (); //There is no way to make sure they entered a number without crashing the program, so, we hope they entered it correctly. Or else, the program will crash
        startAmmount = startAmmount + value;
        c.clear ();
        c.print ("Your current balance is $");
        c.print (startAmmount, 0, 2);
        c.println (". Please wait well we return you to the main menu...");
        menu (); //Re-call the menu method
    }


    public static void withdraw ()
    {
        //Variable
        double value = 0;

        //Prompt
        c.clear ();
        c.println ("Okay, how much money would you like to withdraw? (Please use the following format: 2.45)");
        value = c.readDouble ();

        while (value > startAmmount) //This will prevent us from getting a negative balance, by making sure the user does not take out more then they have
        {
            c.clear ();
            c.print ("You cannot withdraw $");
            c.print (value, 0, 2);
            c.print (", because you only have $");
            c.print (startAmmount, 0, 2);
            c.println (" in your account! Please enter the ammount you would like to withdaw. (Please use the following format: 2.45)");
            value = c.readDouble ();
        }

        startAmmount = startAmmount - value; //Compleate the transaction

        c.clear ();
        c.print ("Your current balance is $");
        c.print (startAmmount, 0, 2);
        c.println (". Please wait well we return you to the main menu...");
        menu ();
    }


    public static void printBalance ()
    {
        c.clear ();
        c.print ("Your current balance is $");
        c.print (startAmmount, 0, 2);
        c.println (". Please wait well we return you to the main menu...");
        menu ();
    }


    public static void quit ()
    {
        c.clear ();
        c.println ("Thank you for using Alexander's ATM software. We hope to see you again!"); 
        //No need to call the main menu after this method, as we are now done all transactions
    }
}

