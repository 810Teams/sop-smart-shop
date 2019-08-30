/**
 * `SpringBootApp`
 *  Main class for running
 *
 *  127.0.0.1:8000/shop
 *      - to view shop page, containing ice cream menus.
 *  127.0.0.1:8000/shop/{menu}
 *      - to view a specific ice cream menu.
 *  127.0.0.1:8000/shop/{menu}/order`
 *      - to order a specific ice cream menu, this will add an ice cream menu to the cart
 *  127.0.0.1:8000/cart
 *      - to view the cart.
 *  127.0.0.1:8000/checkout
 *      - to checkout your items in the cart
 */

package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class SpringBootApp {
    public static ArrayList<IceCreamMenu> CART = new ArrayList<IceCreamMenu>();

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Welcome to SOP Smart Ice-Cream Shop!";
    }

    @RequestMapping("/shop")
    IceCreamMenu[] viewIceCreamMenuList() {
        return IceCreamMenuFactory.viewIceCreamMenuList();
    }

    @RequestMapping(value = "/shop/{menu}")
    IceCreamMenu viewIceCreamMenu(@PathVariable int menu) {
        return IceCreamMenuFactory.viewIceCreamMenu(menu);
    }

    @RequestMapping(value = "/shop/{menu}/order")
    String orderIceCreamMenu(@PathVariable int menu) {
        try {
            SpringBootApp.CART.add(IceCreamMenuFactory.getIceCreamMenu(menu));
            return "Menu '" + IceCreamMenuFactory.viewIceCreamMenu(menu).getName() + "' successfully added to the cart.";
        } catch (CloneNotSupportedException ex) {
            return "Sorry, something went wrong while we're adding your menu to the cart. Please try again.";
        }
    }

    @RequestMapping("/cart")
    ArrayList<IceCreamMenu> viewCart() {
        return SpringBootApp.CART;
    }

    @RequestMapping("/checkout")
    String checkout() {
        double totalPrice = 0;
        for (IceCreamMenu e : SpringBootApp.CART) {
            totalPrice += e.getPrice();
        }
        SpringBootApp.CART.clear();

        return "Thank you for purchase total of " + Double.toString(totalPrice) + " THB.\n" +
                "A delivery will now proceed right to your home.";
    }
}
