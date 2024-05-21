package burger;
import java.util.ArrayList;
import java.util.Collections;

import burger.bun.BurgerBun;
import burger.garnish.BurgerGarnish;
import burger.patty.BurgerPatty;
import burger.cheese.BurgerCheese;
import pizza.AbstractMenuItem;
import pizza.MenuItem;

/**
 * {@code Burger} represents a complete burger composed of bun, patty, cheese, and garnishes.
 */
public class Burger extends AbstractMenuItem {
    private BurgerBun bun;
    private BurgerPatty patty;
    private ArrayList<BurgerCheese> cheeseList;
    private ArrayList<BurgerGarnish> garnishList;
    private ArrayList<AbstractMenuItem> burgerComponents;

    /**
     * Constructs a new Burger with default values.
     */
    public Burger() {
        this.bun = null;
        this.patty = null;
        this.cheeseList = new ArrayList<BurgerCheese>();
        this.garnishList = new ArrayList<BurgerGarnish>();
        this.burgerComponents = new ArrayList<AbstractMenuItem>();
    }

    /**
     * Gets the bun of the burger.
     * @return the bun of the burger
     */
    public BurgerBun getBun() {
        return this.bun;
    }

    /**
     * Sets the bun of the burger and adds it to the components list.
     * @param bun the bun to set
     */
    public void setBun(BurgerBun bun) {
        this.bun = bun;
        this.addComponents(bun);
    }

    /**
     * Gets the patty of the burger.
     * @return the patty of the burger
     */
    public BurgerPatty getPatty() {
        return this.patty;
    }

    /**
     * Sets the patty of the burger and adds it to the components list.
     * @param patty the patty to set
     */
    public void setPatty(BurgerPatty patty) {
        this.patty = patty;
        this.addComponents(patty);
    }

    /**
     * Gets the cheese slices of the burger.
     * @return the list of cheese slices
     */
    public ArrayList<BurgerCheese> getCheese() {
        return this.cheeseList;
    }

    /**
     * Sets the cheese slices of the burger.
     * @param slices the list of cheese slices to set
     */
    public void setCheese(ArrayList<BurgerCheese> slices) {
        this.cheeseList = slices;
    }

    /**
     * Adds a cheese slice to the burger and adds it to the components list.
     * @param cheese the cheese slice to add
     */
    public void addCheese(BurgerCheese cheese) {
        this.cheeseList.add(cheese);
        this.addComponents(cheese);
    }

    /**
     * Gets the components of the burger.
     * @return the list of burger components
     */
    public ArrayList<AbstractMenuItem> getComponents() {
        return this.burgerComponents;
    }


    /**
     * Adds a component to the burger.
     * @param item the component to add
     */
    public void addComponents(AbstractMenuItem item) {
        this.burgerComponents.add(item);
    }

    /**
     * Gets the garnishes of the burger.
     * @return the list of garnishes
     */
    public ArrayList<BurgerGarnish> getGarnish() {
        return this.garnishList;
    }

    /**
     * Sets the garnishes of the burger.
     * @param garnishes the list of garnishes to set
     */
    public void setGarnish(ArrayList<BurgerGarnish> garnishes) {
        this.garnishList = garnishes;
    }

    /**
     * Adds a garnish to the burger and adds it to the components list.
     * @param garnish the garnish to add
     */
    public void addGarnish(BurgerGarnish garnish) {
        this.garnishList.add(garnish);
        this.addComponents(garnish);
    }

    /**
     * Returns a nicely formatted string representation of the burger.
     * @return the string representation of the burger
     */
    public String toNiceString() {
        return "Burger is: " + toString();
    }

    /**
     * Returns a string representation of the burger.
     * @return the string representation of the burger
     */
    public String toString() {
        String burgerDesc = bun + ", " + patty;
        for (BurgerCheese t : cheeseList) {
            burgerDesc += ", " + t.toString();
        }
        for (BurgerGarnish t : garnishList) {
            burgerDesc += ", " + t.toString();
        }
        return burgerDesc;
    }

    /**
     * Displays the burger components.
     */
    public void display() {
        for (MenuItem m : this.burgerComponents) {
            System.out.printf("%s $%.2f\n", m.toNiceString(), m.getPrice());
        }
    }

    /**
     * Displays the burger components after sorting them.
     */
    public void displaySorted() {
        Collections.sort(this.burgerComponents);
        display();
    }

    /**
     * Computes the total price of the burger.
     * @return the total price of the burger
     */
    public Double getPrice() {
        Double total = 0.0;
        for (MenuItem m : burgerComponents) {
            total += m.getPrice();
        }
        return total;
    }

    /**
     * Clears all the components of the burger.
     *
     * This method is typically used when the user wants to start creating a new burger from scratch.
     */
    public void clearBurgerComponents() {
        burgerComponents.clear();
    }
}

