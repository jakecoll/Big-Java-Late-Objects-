package _06design.P12_8;

import java.util.Scanner;

/**
 * Created by jakecoll on 11/6/16.
 */
public class SampleUsage {
    public static void main(String[] args) {

        //Initializae the vending machine and operator
        VendingMachine machine = new VendingMachine();
        Operator masterOperator = new Operator();

        //set the vending machine to be on
        boolean MachineIsOn = true;

        /**
         * If vending machine is turned off by operator (see below) then exit application
         */
        if (!MachineIsOn)
        {
            System.exit(0);
        }

        /**
         * Unless operator turns off machine then while loop continues to take user input
         */
        while(MachineIsOn){

            //declase and initailize scanner
            Scanner in = new Scanner(System.in);

            //Print welcome message
            System.out.println("Welcome to QuikMart Vending Machine\n");

            //implements VendingMachine userInterface method to list items available
            machine.userInterface();

            //prompts user to enter button code of item wanted
            System.out.println("Enter button of item you want or operator password: ");
            String buttonPressed = in.nextLine();


            /**OPERATOR OPTIONS #### NOTE: OPERATOR PASSCODE IS 1234 #####
             * If passcode "1234" is entered instead of button code this if statement checks if it is corrects
             * inside if statements the operator methods of the VendingMachine are implemented
             */
            if (masterOperator.checkPassword(buttonPressed))
            {
                //initialize and declare new scanner for operator
                Scanner operatorButton = new Scanner(System.in);

                //implement VendingMachine operatorInterface method to display options for operator
                machine.operatorInterface();
                System.out.println("Enter which operation you want to perform: ");
                String button = in.nextLine();

                //If operator enters "COLLECT then Vending Machine dispense balance to operator
                if (button.equals("COLLECT"))
                {
                    System.out.println("Total amount was: " + machine.getCollectedMoney());
                    machine.removeCollectedMoney(masterOperator);
                    System.out.println("Vending Machine Balance now: " + machine.getCollectedMoney());
                    System.out.println("Operator Balance now: " + masterOperator.getCollectionAmount() + "\n");

                }

                //if OFF is entered then boolean MachineIsOn is set to false and program while loop will not execute again
                else if (button.equals("OFF"))
                {
                    System.out.println("TURNING VENDING MACHINE OFF");
                    MachineIsOn = false;
                }

                //Else statement checks if operator entered restock operation correctly or wrong statement entirely
                else {
                    String[] parts = button.split(" ");
                    if (machine.checkButton(parts[0]))
                    {
                        VendingMachineItem selectedItem = machine.getItem(machine.getItemArray(),parts[0]);
                        selectedItem.restock(Integer.parseInt(parts[1]));
                        System.out.println("\nItem restocked! Log back into to check inventory.\n");

                    } else {
                        System.out.println("Mr. Operator neither of those are options!");
                    }
                }

            }

            //Else if statement checks if user entered an actual button code, if it did it will prompt user to enter coinds
            else if (machine.checkButton(buttonPressed))
            {
                //initialize and declare new scanner for user interface
                Scanner coinScanner = new Scanner(System.in);

                //Get the selected item from the button code entered
                VendingMachineItem selectedItem = machine.getItem(machine.getItemArray(),buttonPressed);
                System.out.println(selectedItem.getName() + " selected. The price is $" + selectedItem.getPrice() + ".\nPlease list coins inserted and # to process: ");

                //Initialize and declare new insertedCoins object
                InsertedCoins insertedCoins = new InsertedCoins();

                while(coinScanner.hasNextDouble())
                {
                    double coin = coinScanner.nextDouble();
                    insertedCoins.addCoin(coin);
                }

                //checks if both the insertedCoins are of legal denominations (e.g. no such things as an .11 cent coin) and whether total amount is correct

                if(insertedCoins.checkLegalCoins() && insertedCoins.getTotal() == selectedItem.getPrice())
                {
                    //the following collects the money from the user, dispenses the item and adjust inventory and balance of VendingMachine
                    machine.addCollectedMoney(selectedItem.getPrice());
                    selectedItem.dispenseItem();
                    System.out.println(selectedItem.getInventory());
                    System.out.println(selectedItem.getName() + " Dispensed!");


                    //IF inserted coins are not legal or wrong amount then the following statement is printed
                } else {

                    System.out.println("Wrong Change. $" + insertedCoins.getTotal() + " returned.");
                }
            }

            //If user input is not a valid button or operator passcode the following statement is printed before while loop iterates again
            else
            {
                System.out.println("Oops! That is not a button! Please try again.\n");
            }


        }

    }
}
