package burger.patty;
import pizza.AbstractMenuItem;

/**
 * {@code BurgerPatty} represents a generic burger patty.
 */
public abstract class BurgerPatty extends AbstractMenuItem {
    /**
     * Returns a string representation of the burger patty.
     * @return A string describing the burger patty.
     */
    public abstract String toString();

    /**
     * Returns a nicely formatted string representing the burger patty.
     * @return A string with a nice description of the burger patty.
     */
    public String toNiceString() {
        return "Patty is: " + toString();
    }

    public Double getPrice() {
        return 1.50; // default price for patty
    }
}
