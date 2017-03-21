package _02arrays;

/**
 * Created by jakecoll on 10/9/16.
 */
public class Address {

    private int nHouseNumber;
    private String street;
    private int nAptNumber;
    private String city;
    private int nPostalCode;


    public Address(int nHouseNumber, String street, int nAptNumber, String city, int nPostalCode)
    {
        this.nHouseNumber = nHouseNumber;
        this.street = street;
        this.nAptNumber = nAptNumber;
        this.city = city;
        this.nPostalCode = nPostalCode;
    }

    public void print()
    {
        if (nAptNumber == 0)
        {
            System.out.println(String.format("%d %s\n%s, %d", nHouseNumber, street, city, nPostalCode));

        }
        else if (nAptNumber != 0)
        {
            System.out.println(String.format("%d %s Apt. %d\n%s, %d", nHouseNumber, street, nAptNumber, city, nPostalCode));
        }
    }

    public boolean comesBefore(Address other)
    {
        return this.nPostalCode > other.nPostalCode;
    }
}
