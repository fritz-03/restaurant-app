package burger.patty;

/**
 * {@code ChickenPatty} represents a chicken patty for a burger.
 */
public class ChickenPatty extends BurgerPatty {
    @Override
    public String toString() {
        return "Chicken Patty";
    }

    @Override
    public Double getPrice() {
        return 2.00;
    }
}
