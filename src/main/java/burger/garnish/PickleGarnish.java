package burger.garnish;

/**
 * {@code PickleGarnish} represents pickle garnish for burgers.
 */
public class PickleGarnish extends BurgerGarnish {
    @Override
    public String toString() {
        return "Pickle";
    }

    @Override
    public Double getPrice() {
        return 1.30;
    }
}
