package core;

import java.io.Serializable;
import java.util.ArrayList;

public class IceCreamMenuList implements Serializable {
    private ArrayList<IceCreamMenu> list;

    public IceCreamMenuList() {
        this.list = new ArrayList<IceCreamMenu>();
    }

    public IceCreamMenuList(ArrayList<IceCreamMenu> list) {
        this.list = list;
    }

    public ArrayList<IceCreamMenu> getList() {
        return list;
    }

    public IceCreamMenu getListItem(int index) {
        return list.get(index);
    }
}
