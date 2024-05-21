package burger;
import java.util.Scanner;

import burger.bun.SesameSeedBun;
import burger.bun.SourdoughBun;
import burger.bun.WholeWheatBun;
import burger.cheese.AmericanCheese;
import burger.cheese.CheddarCheese;
import burger.cheese.PepperJackCheese;
import burger.cheese.SwissCheese;
import burger.garnish.BaconGarnish;
import burger.garnish.LettuceGarnish;
import burger.garnish.PickleGarnish;
import burger.garnish.TomatoGarnish;
import burger.patty.ChickenPatty;
import burger.patty.BeefPatty;
import burger.patty.BrisketPatty;
import burger.patty.TurkeyPatty;

/**
 * This is the driver class for assembling a burger from bun, patty, cheese, and garnishes
 */
public class BurgerMain {
    private Burger burger;
    private Scanner input;

    public BurgerMain() {
        burger = new Burger();
        input = new Scanner(System.in);
    }

    private void inputBunChoice() {
        Boolean validChoice = false;
        System.out.println("What kind of bun would you like:");
        System.out.println("1 - Sesame Seed Bun");
        System.out.println("2 - Sourdough Bun");
        System.out.println("3 - Whole Wheat Bun");
        System.out.print("Your choice: ");
        while (!validChoice) {
            Integer choice = input.nextInt();
            switch(choice) {
                case 1:
                    burger.setBun(new SesameSeedBun());
                    validChoice = true;
                    break;
                case 2:
                    burger.setBun(new SourdoughBun());
                    validChoice = true;
                    break;
                case 3:
                    burger.setBun(new WholeWheatBun());
                    validChoice = true;
                    break;
                default:
                    System.out.println("Pick between 1-3");
            }
        }
    }

    private void inputPattyChoice() {
        Boolean validChoice = false;
        System.out.println("Select patty type:");
        System.out.println("1 - Beef Patty");
        System.out.println("2 - Chicken Patty");
        System.out.println("3 - Turkey Patty");
        System.out.println("4 - Brisket Patty");
        System.out.print("Your choice: ");
        while (!validChoice) {
            Integer choice = input.nextInt();
            switch(choice) {
                case 1:
                    burger.setPatty(new BeefPatty());
                    validChoice = true;
                    break;
                case 2:
                    burger.setPatty(new ChickenPatty());
                    validChoice = true;
                    break;
                case 3:
                    burger.setPatty(new TurkeyPatty());
                    validChoice = true;
                    break;
                case 4:
                    burger.setPatty(new BrisketPatty());
                    validChoice = true;
                    break;
                default:
                    System.out.println("Pick between 1-4");
            }
        }
    }

    private void inputCheeseChoices() {
        System.out.print("How many cheese slices? ");
        Integer numCheeseSlices = input.nextInt();
        for (Integer i = 0; i < numCheeseSlices; i++) {
            Boolean validChoice = false;
            System.out.println("1 - American Cheese");
            System.out.println("2 - Swiss Cheese");
            System.out.println("3 - Cheddar Cheese");
            System.out.println("4 - Pepper Jack Cheese");
            System.out.print("Your choice: ");
            while (!validChoice) {
                Integer choice = input.nextInt();
                switch(choice) {
                    case 1:
                        burger.addCheese(new AmericanCheese());
                        validChoice = true;
                        break;
                    case 2:
                        burger.addCheese(new SwissCheese());
                        validChoice = true;
                        break;
                    case 3:
                        burger.addCheese(new CheddarCheese());
                        validChoice = true;
                        break;
                    case 4:
                        burger.addCheese(new PepperJackCheese());
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Pick between 1-4");
                }
            }
        }
    }

    private void inputGarnishChoices() {
        System.out.print("How many garnishes? ");
        Integer numGarnishes = input.nextInt();
        for (Integer i = 0; i < numGarnishes; i++) {
            Boolean validChoice = false;
            System.out.println("1 - Bacon");
            System.out.println("2 - Letture");
            System.out.println("3 - Pickle");
            System.out.println("4 - Tomato");
            System.out.print("Your choice: ");
            while (!validChoice) {
                Integer choice = input.nextInt();
                switch(choice) {
                    case 1:
                        burger.addGarnish(new BaconGarnish());
                        validChoice = true;
                        break;
                    case 2:
                        burger.addGarnish(new LettuceGarnish());
                        validChoice = true;
                        break;
                    case 3:
                        burger.addGarnish(new PickleGarnish());
                        validChoice = true;
                        break;
                    case 4:
                        burger.addGarnish(new TomatoGarnish());
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Pick between 1-4");
                }
            }
        }
    }

    private void showBurger() {
        burger.displaySorted();
        System.out.println("----");
        System.out.printf("%s $%.2f\n", burger.toNiceString(), burger.getPrice());
    }

    /**
     * Solicit user inputs regarding burger preferences
     */
    public void runMenu() {
        inputBunChoice();
        inputPattyChoice();
        inputCheeseChoices();
        inputGarnishChoices();
        showBurger();
    }

    public static void main(String[] args) {
        BurgerMain bm = new BurgerMain();
        bm.runMenu();
    }
}