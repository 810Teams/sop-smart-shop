/**
 * `SpringBootApp`
 *  Main class for running
 *  @author Teerapat Kraisrisirikul
 *  @version 0.2.0
 *
 *  127.0.0.1:8080/shop
 *      - to view shop page, containing ice cream menus.
 *  127.0.0.1:8080/shop/{menu}
 *      - to view a specific ice cream menu.
 *  127.0.0.1:8080/shop/{menu}/order
 *      - to order a specific ice cream menu, this will add an ice cream menu to the cart
 *  127.0.0.1:8080/cart
 *      - to view the cart.
 *  127.0.0.1:8080/checkout
 *      - to checkout your items in the cart
 */

package main;

import core.IceCreamMenu;
import core.IceCreamMenuFactory;
import core.IceCreamMenuList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.StorageManager;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class SpringBootApp {
    private final IceCreamMenuFactory factory = new IceCreamMenuFactory();
    private final StorageManager storage_manager = new StorageManager();
    private IceCreamMenuList cart = storage_manager.readIceCreamMenuFile("cart.dat");

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Welcome to SOP Smart Ice-Cream Shop!";
    }

    @RequestMapping("/shop")
    IceCreamMenu[] viewIceCreamMenuList() {
        return factory.viewIceCreamMenuList();
    }

    @RequestMapping(value = "/shop/{menu}")
    IceCreamMenu viewIceCreamMenu(@PathVariable int menu) {
        return factory.viewIceCreamMenu(menu);
    }

    @RequestMapping(value = "/shop/{menu}/order")
    String orderIceCreamMenu(@PathVariable int menu) {
        try {
            cart.getList().add(factory.getIceCreamMenu(menu));
            storage_manager.writeIceCreamMenuFile("cart.dat", cart);
            return "Menu '" + factory.viewIceCreamMenu(menu).getName() + "' successfully added to the cart.";
        } catch (CloneNotSupportedException ex) {
            return "Sorry, something went wrong while we're adding your menu to the cart. Please try again.";
        }
    }

    @RequestMapping("/cart")
    ArrayList<IceCreamMenu> viewCart() {
        return cart.getList();
    }

    @RequestMapping("/checkout")
    String checkout() {
        double totalPrice = 0;
        for (IceCreamMenu e : cart.getList()) {
            totalPrice += e.getPrice();
        }
        cart.getList().clear();
        storage_manager.writeIceCreamMenuFile("cart.dat", cart);

        return "Thank you for purchase total of " + Double.toString(totalPrice) + " THB.\n" +
                "A delivery will now proceed right to your home.";
    }
}
