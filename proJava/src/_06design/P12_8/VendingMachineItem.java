package _06design.P12_8;

/**
 * Created by jakecoll on 11/5/16.
 */
public class VendingMachineItem {

    private String strItemName;
    private String strButtonName;
    private int nTotalInventory;
    private double dPrice;
    public boolean ItemInStock;

    /**
     * Constructs a VendingMachineItem objects from the following paramters
     * @param name
     * @param button
     * @param totalInventory
     * @param price
     */
    public VendingMachineItem(String name, String button, int totalInventory, double price)
    {
        strItemName = name;
        strButtonName = button;
        nTotalInventory = totalInventory;
        dPrice = price;

        if (nTotalInventory > 0)
        {
            ItemInStock = true;
        } else {ItemInStock = false; }
    }

    /**
     * method returns the name of a VendingMachineItem objects as a String
     * @return
     */
    public String getName()
    {
        return strItemName;
    }

    /**
     * method returns the button name/code of a VendingMachineItem object as a String
     * @return
     */
    public String getButton()
    {
        return strButtonName;
    }

    /**
     * method returns the inventory amount of a VendingMachineItem objects as an int
     * @return
     */
    public int getInventory()
    {
        return nTotalInventory;
    }

    /**
     * method returns the price of a VendingMachineItem object  as a double
     * @return
     */
    public double getPrice()
    {
        return dPrice;
    }

    /**
     * method increments the inventory amount of a VendingMachineItem object by an int parameter
     * @param addedInventory
     */
    public void restock(int addedInventory)
    {
        nTotalInventory = nTotalInventory + addedInventory;
    }

    /**
     * Method decreases the inventory of a VendingMachineItem object by one to represent that the object
     * was dispensed or prints a message that the item is out of stock if inventory is 0.
     */
    public void dispenseItem()
    {
        if (ItemInStock)
        {
            nTotalInventory = nTotalInventory - 1;
            if (nTotalInventory == 0) { ItemInStock = false; }
        } else { System.out.println("Item is out of stock"); }
    }
}
