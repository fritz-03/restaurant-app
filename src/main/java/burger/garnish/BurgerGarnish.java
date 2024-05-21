package burger.garnish;
import pizza.AbstractMenuItem;

/**
 * {@code BurgerGarnish} represents a generic garnish for burgers.
 */
public abstract class BurgerGarnish extends AbstractMenuItem {
    /**
     * Returns a string representation of the garnish.
     * @return A string describing the garnish.
     */
    public abstract String toString();

    /**
     * Returns a formatted string representation of the garnish.
     * @return A string describing the garnish in a nice format.
     */
    public String toNiceString() {
        return "Garnish is: " + toString();
    }

    public Double getPrice() {
        return 1.00; // default price for garnish
    }
}
