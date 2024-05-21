package burger.cheese;
import pizza.AbstractMenuItem;

/**
 * {@code BurgerCheese} represents a generic type of cheese used in burgers.
 * It extends the {@link AbstractMenuItem} class.
 */
public abstract class BurgerCheese extends AbstractMenuItem {
    /**
     * Returns a string representation of the cheese.
     * @return A string describing the type of cheese.
     */
    public abstract String toString();

    /**
     * Returns a nicely formatted string representation of the cheese.
     * @return A string describing the type of cheese with a label.
     */
    public String toNiceString() {
        return "Cheese is: " + toString();
    }

    public Double getPrice() {
        return 0.50; // default price for cheese
    }
}
