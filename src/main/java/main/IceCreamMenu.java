package main;

public class IceCreamMenu implements Cloneable {
    public static final double DEFAULT_PRICE = 175;
    private String name;
    private String details;
    private IceCreamScoop[] scoops;
    private double price;

    public IceCreamMenu(String name, String details, IceCreamScoop[] scoops, double price) {
        this.name = name;
        this.details = details;
        this.scoops = scoops;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() == 0) {
            this.name = "Unnamed Ice Cream Menu";
        } else {
            this.name = name;
        }
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        if (details.length() == 0) {
            this.details = "No details";
        } else {
            this.details = details;
        }
    }

    public IceCreamScoop[] getScoops() {
        return scoops;
    }

    public void setScoops(IceCreamScoop[] scoops) {
        if (scoops.length == 0) {
            this.scoops = new IceCreamScoop[]{new IceCreamScoop(0)};
        } else {
            this.scoops = scoops;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            this.price = IceCreamMenu.DEFAULT_PRICE;
        } else {
            this.price = price;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
