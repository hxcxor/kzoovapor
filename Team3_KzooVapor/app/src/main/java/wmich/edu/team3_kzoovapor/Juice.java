package wmich.edu.team3_kzoovapor;
/*
*************************************
* Programmers: Bryan Minton, Jonathan Trapane,
*              Anson Richardson
* Final Project: Kalamazoo Vapor App
* CIS 4700: Mobile Commerce Development
* Spring 2015
* Due date: 4/28/15
* Date completed: 4/28/15
*************************************
*/
// Object Model - Juice (for sqlitedb)
public class Juice
{
    // fields for juice variables
    private long id;
    private String name;
    private String manufacturer;


    // methods to set and return values

    // get id method
    public long getId(){return id;}

    // set id method
    public void setId(long id) {
        this.id = id;}

    // getname method
    public String getName() {
        return name;
    }

    // setname method
    public void setName(String name) {
        this.name = name;
    }

    // get manufacturer method
    public String getManufacturer() {
        return manufacturer;
    }

    // set manufacturer method
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;}

    // string to string for listview
    @Override
    public String toString() {
        return name;
    }

}
