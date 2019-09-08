package util;

import core.IceCreamMenu;
import core.IceCreamMenuList;

import java.io.*;
import java.util.ArrayList;

public class StorageManager {
    public IceCreamMenuList readIceCreamMenuFile(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            ObjectInputStream ois = new ObjectInputStream(fis);
            IceCreamMenuList iceCreamMenuList = (IceCreamMenuList) ois.readObject();
            ois.close();
            fis.close();
            return iceCreamMenuList;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return new IceCreamMenuList();
    }

    public void writeIceCreamMenuFile(String fileName, IceCreamMenuList iceCreamMenuList) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(fileName));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(iceCreamMenuList);
            fos.close();
            oos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
