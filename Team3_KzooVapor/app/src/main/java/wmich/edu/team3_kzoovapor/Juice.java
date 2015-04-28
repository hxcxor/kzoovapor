package wmich.edu.team3_kzoovapor;

// Object Model - Juice (for sqlitedb)
public class Juice
{
    // fields for juice
    private int id;
    private String name;
    private String manufacturer;
    private String flavor;

    public Juice(){}

    public Juice(String name, String manufacturer, String flavor) {
        super();
        this.name = name;
        this.manufacturer = manufacturer;
        this.flavor = flavor;
    }

    // getters & setters

    @Override
    public String toString() {
        return "Juice [id=" + id + ", name=" + name + ", " +
                "manufacturer=" + manufacturer + ",  flavor=" + flavor + ", + ";
    }


    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getFlavor() {
        return flavor;
    }
}
