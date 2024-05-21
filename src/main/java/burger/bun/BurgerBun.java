package burger.bun;
import pizza.AbstractMenuItem;

/**
 * {@code BurgerBun} represents all possible types of buns for a burger.
 */
public abstract class BurgerBun extends AbstractMenuItem {
    /**
     * Returns a string representation of the burger bun.
     * @return a string describing the type of burger bun
     */
    public abstract String toString();

    /**
     * Returns a nicely formatted string representation of the burger bun.
     * @return A string containing the type of burger bun.
     */
    public String toNiceString() {
        return "Bun is: " + toString();
    }

    public Double getPrice() {
        return 0.50; // default price for bun
    }
}