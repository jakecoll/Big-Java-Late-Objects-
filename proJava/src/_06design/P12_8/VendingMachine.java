package _06design.P12_8;

/**
 * Created by jakecoll on 11/5/16.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {

    private ArrayList<VendingMachineItem> arrayVendingMachine;
    private double dCollectedMoney;


    /**
     * Constructs a VendingMachine object with no parameters
     * Sets machine balance to 0 and items from addItems method
     */
    public VendingMachine()
    {
        arrayVendingMachine = addItem();
        dCollectedMoney = 0.0;
    }

    /**
     * getItemArray method returns an arraylist of VendingMachineItem objects
     * @return
     */
    public ArrayList<VendingMachineItem> getItemArray()
    {
        return arrayVendingMachine;
    }

    /**
     * method returns the balance of the VendingMachine
     * @return
     */
    public double getCollectedMoney()
    {
        return dCollectedMoney;
    }

    /**
     * Method increment the balance dCollectedMoney of the VendingMachine object by the price of a dispensed vendingmachineitem when implemented
     * @param processedItemValue
     */
    public void addCollectedMoney(double processedItemValue)
    {
        dCollectedMoney = dCollectedMoney + processedItemValue;
    }

    /**
     * method adds the balance of the VendingMachine object to the balance of an Operator object and sets the balance of the VendingMachine to 0.0
     * @param operator
     */
    public void removeCollectedMoney(Operator operator)
    {
        operator.addCollectedMoney(dCollectedMoney);
        dCollectedMoney = 0.0;
    }

    /**
     * method returns a boolean true if the button code implemented (buttonPressed) is a button of VendingMachineItem object or false otherwise
     * @param buttonPressed
     * @return
     */
    public boolean checkButton(String buttonPressed)
    {
        boolean IsButton = false;
        for (VendingMachineItem item: arrayVendingMachine)
        {
            if (item.getButton().equals(buttonPressed))
            {
                IsButton = true;
            }
        }
        if (IsButton) {
            return true;
        } else { return false; }
    }

    /**
     * method returns a VendingMachineItem object based on a referenced button parameter
     * @param itemList
     * @param button
     * @return
     */
    public VendingMachineItem getItem(ArrayList<VendingMachineItem> itemList, String button)
    {
        for (VendingMachineItem item: itemList)
        {
            if (item.getButton().equals(button))
            {
                return item;
            }
        }

        return null;
    }

    /**
     * method prints in console a List of VendingMachineItem objects by button, name and price
     */
    public void userInterface()
    {
        for (VendingMachineItem item: getItemArray())
        {
            System.out.println(item.getButton() + ": " + item.getName() + " " + item.getPrice());
        }
    }

    /**
     * method prints in console list of VendingMachineItem objects by button, name and inventory amount as well as list of commands operator can implement
     */
    public void operatorInterface()
    {
        for (VendingMachineItem item: getItemArray())
        {
            System.out.println(item.getButton() + ": " + item.getName() + " Inventory: " + item.getInventory());
        }
        System.out.println("\nRestock Item: Enter item button and amount (Ex: A1 10)");
        System.out.println("Collect Money: Enter COLLECT");
        System.out.println("Turn off vending machine: Enter OFF\n");

    }

    /**
     * method builds an array list of VendingMachineItem objects available in the VendingMachine object
     * @return
     */
    public static ArrayList<VendingMachineItem> addItem()
    {
        ArrayList<VendingMachineItem> stockedItemds = new ArrayList<VendingMachineItem>();
        VendingMachineItem coke = new VendingMachineItem("Coke", "A1", 10, 1.50);
        VendingMachineItem dietCoke = new VendingMachineItem("Diet Coke", "A2", 10, 1.50);
        VendingMachineItem sprite = new VendingMachineItem("Sprite", "B1", 10, 1.25);
        VendingMachineItem fresca = new VendingMachineItem("Fresca", "B2", 10, 0.75);
        VendingMachineItem drPepper = new VendingMachineItem("Dr. Pepper", "C1", 10, 1.50);
        VendingMachineItem rootBeer = new VendingMachineItem("Root Beer", "C2", 10, 1.25);
        VendingMachineItem water = new VendingMachineItem("Aquafina", "D1", 10, .75);
        stockedItemds.add(coke);
        stockedItemds.add(dietCoke);
        stockedItemds.add(sprite);
        stockedItemds.add(fresca);
        stockedItemds.add(drPepper);
        stockedItemds.add(rootBeer);
        stockedItemds.add(water);

        return stockedItemds;

    }
}
