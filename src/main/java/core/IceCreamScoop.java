package core;

import java.io.Serializable;

public class IceCreamScoop implements Serializable {
    public static final String[] FLAVOR_NAMES = new String[]{
            "(Any)",
            "Blueberry Cheesecake",
            "Chocolate",
            "Chocolate Chip",
            "Coconut",
            "Coffee",
            "Green Tea",
            "Lemon",
            "Mango",
            "Mint",
            "Rainbow Sherbet",
            "Strawberry",
            "Strawberry Cheesecake",
            "Vanilla",
    };
    private int flavor;

    public IceCreamScoop(int flavor) {
        this.setFlavor(flavor);
    }

    public int getFlavor() {
        return flavor;
    }

    public void setFlavor(int flavor) {
        if (flavor >= IceCreamScoop.FLAVOR_NAMES.length) {
            this.flavor = 0;
        } else {
            this.flavor = flavor;
        }
    }

    public String getFlavorName(int flavor) {
        return IceCreamScoop.FLAVOR_NAMES[flavor];
    }
}
