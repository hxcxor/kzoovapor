package wmich.edu.team3_kzoovapor;

// Object Model - Juice (for sqlitedb)
public class Juice
{
    // fields for juice
    private long id;
    private String name;
    private String manufacturer;


    // methods to set and return values

    public long getId(){return id;}

    public void setId(long id) {
        this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;}

    @Override
    public String toString() {
        return name;
    }

}
