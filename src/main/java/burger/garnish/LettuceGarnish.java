package burger.garnish;

/**
 * {@code LettuceGarnish} represents lettuce garnish for burgers.
 */
public class LettuceGarnish extends BaconGarnish {
    @Override
    public String toString() {
        return "Lettuce";
    }

    @Override
    public Double getPrice() {
        return 0.50;
    }
}
