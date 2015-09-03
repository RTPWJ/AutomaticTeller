/*
Name: Alexander Georgiadis (RezTech)
Date Started: 9/2/2015
Date Last Edited: 9/3/2015
Description: This is a partialy complex automatic teller (ATM) program, to be used with RTPWJ (Ready To Program With Java).
*/

import java.awt.*;
import hsa.Console;

public class AutomaticTeller_Educational
{
    static Console c;
    static double startAmmount = 1337; //Starting Amount

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
                    //withdraw ();
                    break;
                }
            case (3):
                {
                    //printBalance ();
                    break;
                }
            default: //case (4): or default: is valid here, as we forced the entry of either 1, 2, 3, or 4 using the while statement
                {
                    //quit ();
                    break;
                }
        }
    }


    //Deposit Method
    public static void deposit ()
    {
        //Variables
        double value = 0;

        //Prompt
        c.clear ();
        c.println ("Okay, how much money would you like to deposit? (Use the following format: 2.45)");
        value = c.readDouble (); //There is no way to make sure they entered a number without crashing the program, so, we hope they entered it correctly. Or else, the program will crash
        startAmmount = startAmmount + value;
        c.clear ();
        c.print ("Your current balance is $");
        c.print (startAmmount, 0, 2);
        c.println (". Please wait well we return you to the main menu...");
        menu (); //Re-call the menu method
    }
}

