package burger.garnish;

/**
 * {@code BaconGarnish} represents a garnish of bacon commonly used in burgers.
 */
public class BaconGarnish extends BurgerGarnish {
    @Override
    public String toString() {
        return "Bacon";
    }

    @Override
    public Double getPrice() {
        return 1.60;
    }
}
