package core;

public class IceCreamMenuFactory {
    public static final IceCreamMenu[] ICE_CREAM_MENUS = new IceCreamMenu[]{
            new IceCreamMenu("Menu A", "Details of ice cream menu A", new IceCreamScoop[]{
                    new IceCreamScoop(0)
            }, 105),
            new IceCreamMenu("Menu B", "Details of ice cream menu B", new IceCreamScoop[]{
                    new IceCreamScoop(1),
                    new IceCreamScoop(2),
            }, 140),
            new IceCreamMenu("Menu C", "Details of ice cream menu C", new IceCreamScoop[]{
                    new IceCreamScoop(3),
                    new IceCreamScoop(4),
                    new IceCreamScoop(5),
            }, 175),
            new IceCreamMenu("Menu D", "Details of ice cream menu D", new IceCreamScoop[]{
                    new IceCreamScoop(6),
                    new IceCreamScoop(7),
                    new IceCreamScoop(8),
            }, 175),
            new IceCreamMenu("Menu E", "Details of ice cream menu E", new IceCreamScoop[]{
                    new IceCreamScoop(9),
                    new IceCreamScoop(10),
                    new IceCreamScoop(11),
                    new IceCreamScoop(12),
            }, 210),
            new IceCreamMenu("Menu F", "Details of ice cream menu F", new IceCreamScoop[]{
                    new IceCreamScoop(13),
                    new IceCreamScoop(14),
                    new IceCreamScoop(15),
                    new IceCreamScoop(16),
            }, 210),
    };

    public static IceCreamMenu viewIceCreamMenu(int menu) {
        return (IceCreamMenu) ICE_CREAM_MENUS[menu];
    }

    public static IceCreamMenu[] viewIceCreamMenuList() {
        return ICE_CREAM_MENUS;
    }

    public static IceCreamMenu getIceCreamMenu(int menu) throws CloneNotSupportedException {
        return (IceCreamMenu) ICE_CREAM_MENUS[menu].clone();
    }

    public static IceCreamMenu getIceCreamMenu(int menu, IceCreamScoop[] customScoops) throws CloneNotSupportedException {
        IceCreamMenu newIceCreamMenu = (IceCreamMenu) ICE_CREAM_MENUS[menu].clone();
        newIceCreamMenu.setScoops(customScoops);
        return newIceCreamMenu;
    }
}
