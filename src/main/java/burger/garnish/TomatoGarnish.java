package burger.garnish;

/**
 * {@code TomatoGarnish} represents tomato garnish for burgers.
 */
public class TomatoGarnish extends BaconGarnish {
    @Override
    public String toString() {
        return "Tomato";
    }

    @Override
    public Double getPrice() {
        return 0.70;
    }
}
