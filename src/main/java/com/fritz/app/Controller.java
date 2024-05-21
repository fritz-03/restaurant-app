package com.fritz.app;

import burger.Burger;
import burger.bun.BurgerBun;
import burger.bun.SesameSeedBun;
import burger.bun.SourdoughBun;
import burger.bun.WholeWheatBun;
import burger.cheese.*;
import burger.garnish.*;
import burger.patty.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import pizza.AbstractMenuItem;
import pizza.MenuItem;
import pizza.Pizza;
import pizza.crust.PizzaCrust;
import pizza.crust.ThickCrust;
import pizza.crust.ThinCrust;
import pizza.sauce.AlfredoSauce;
import pizza.sauce.PizzaSauce;
import pizza.sauce.TomatoSauce;
import pizza.topping.*;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the Main Application.
 *
 * This controller manages the interaction between the user interface and the
 * underlying model classes such as Pizza and Burger. It handles user actions
 * such as selecting a crust, adding toppings, and placing an order.
 */
public class Controller {

    @FXML
    private Label pizzaOrder;

    @FXML
    private Label burgerOrder;

    @FXML
    private Label addedToppingLabel;

    @FXML
    private RadioButton alfredoRadioButton;

    @FXML
    private RadioButton americanRadioButton;

    @FXML
    private RadioButton asiagoRadioButton;

    @FXML
    private RadioButton baconRadioButton;

    @FXML
    private RadioButton beefRadioButton;

    @FXML
    private RadioButton brisketRadioButton;

    @FXML
    private RadioButton cauliflowerRadioButton;

    @FXML
    private RadioButton cheddarRadioButton;

    @FXML
    private RadioButton chickenRadioButton;

    @FXML
    private RadioButton flourRadioButton;

    @FXML
    private CheckBox isDeepDishCheck;

    @FXML
    private RadioButton lettuceRadioButton;

    @FXML
    private RadioButton mozzarellaRadioButton;

    @FXML
    private RadioButton mushroomRadioButton;

    @FXML
    private RadioButton pepperJackRadioButton;

    @FXML
    private RadioButton pepperRadioButton;

    @FXML
    private RadioButton pepperoniRadioButton;

    @FXML
    private Slider pepperoniSpicinessSlider;

    @FXML
    private RadioButton pickleRadioButton;

    @FXML
    private RadioButton sausageRadioButton;

    @FXML
    private Slider sausageSpicinessSlider;

    @FXML
    private RadioButton sesameSeedRadioButton;

    @FXML
    private RadioButton sourdoughRadioButton;

    @FXML
    private RadioButton swissRadioButton;

    @FXML
    private RadioButton thickCrustRadioButton;

    @FXML
    private RadioButton thinCrustRadioButton;

    @FXML
    private RadioButton tomatoPizzaRadioButton;

    @FXML
    private RadioButton tomatoBurgerRadioButton;

    @FXML
    private Label addedGarnishLabel;

    @FXML
    private Label addedCheeseLabel;

    @FXML
    private RadioButton turkeyRadioButton;

    @FXML
    private RadioButton wholeWheatRadioButton;

    private Pizza pizza;

    private Burger burger;

    private Integer addedToppingNum = 0;

    private Integer addedCheeseNum = 0;

    private Integer addedBurgerNum = 0;

    private Integer addedGarnishNum = 0;

    private Integer addedPizzaNum = 0;

    private List<Double> foodPrices = new ArrayList<>();

    private List<String> foodDescriptions = new ArrayList<>();


    /**
     * Initializes the controller class.
     */
    @FXML
    void initialize() {
        pizza = new Pizza();
        burger = new Burger();
    }

    /**
     * Sets the crust choice for the pizza.
     *
     * @param event the action event
     */
    @FXML
    void setCrustChoice(ActionEvent event) {
        try {
            PizzaCrust selectedCrust = null;
            String doughType = null;

            if (thinCrustRadioButton.isSelected()) {
                selectedCrust = new ThinCrust();
                System.out.println("Thin crust selected!");
            } else if (thickCrustRadioButton.isSelected()) {
                isDeepDishCheck.setVisible(true);
                Boolean isChecked = isDeepDishCheck.isSelected();

                ThickCrust thickCrust = new ThickCrust();
                thickCrust.setIsDeepDish(isChecked);
                selectedCrust = thickCrust;
                System.out.println("Thick crust selected!");
            }

            if (flourRadioButton.isSelected()) {
                doughType = "Flour";
                System.out.println("Flour selected!");
            } else if (cauliflowerRadioButton.isSelected()) {
                doughType = "Cauliflower";
                System.out.println("Cauliflower selected!");
            }

            if (doughType != null && selectedCrust != null) {
                selectedCrust.setIngredient(doughType);
            }

            if (selectedCrust != null && doughType != null) {
                pizza.addComponent(selectedCrust);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sets the sauce choice for the pizza.
     *
     * @param event the action event
     */
    @FXML
    void setSauceChoice(ActionEvent event) {
        try {
            PizzaSauce selectedSauce = null;

            if (tomatoPizzaRadioButton.isSelected()) {
                selectedSauce = new TomatoSauce();
                System.out.println("Tomato sauce selected!");
            } else if (alfredoRadioButton.isSelected()) {
                System.out.println("Alfredo sauce selected!");
                selectedSauce = new AlfredoSauce();
            }

            if (selectedSauce != null) {
                pizza.addComponent(selectedSauce);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a topping to the pizza.
     *
     * @param topping the topping to add
     * @param radioButton the radio button associated with the topping
     */
    void addTopping(PizzaTopping topping, RadioButton radioButton) {
        pizza.addComponent(topping);
        addedToppingNum++;
        addedToppingLabel.setText("Total toppings added: " + addedToppingNum);
        System.out.println("Total toppings added: " + addedToppingNum);
        System.out.println(topping.getClass().getSimpleName() + " topping selected!");

        PauseTransition pause = new PauseTransition(Duration.seconds(0.3));
        pause.setOnFinished(event -> radioButton.setSelected(false));
        pause.play();
    }

    /**
     * Sets the topping choice for the pizza.
     *
     * @param event the action event
     */
    @FXML
    void setToppingChoice(ActionEvent event) {
        try {
            if (pepperoniRadioButton.isSelected()) {
                MeatTopping pepperoniTopping = new PepperoniTopping();
                pepperoniTopping.setSpiciness(Math.round(
                        Float.parseFloat(String.valueOf(pepperoniSpicinessSlider.getValue()))));
                addTopping(pepperoniTopping, pepperoniRadioButton);
            }

            if (sausageRadioButton.isSelected()) {
                MeatTopping sausageTopping = new SausageTopping();
                sausageTopping.setSpiciness(Math.round(
                        Float.parseFloat(String.valueOf(sausageSpicinessSlider.getValue()))));
                addTopping(sausageTopping, sausageRadioButton);
            }

            if (mushroomRadioButton.isSelected()) {
                addTopping(new MushroomTopping(), mushroomRadioButton);
            }

            if (mozzarellaRadioButton.isSelected()) {
                addTopping(new MozzarellaTopping(), mozzarellaRadioButton);
            }

            if (pepperRadioButton.isSelected()) {
                addTopping(new PepperTopping(), pepperRadioButton);
            }

            if (asiagoRadioButton.isSelected()) {
                addTopping(new AsiagoTopping(), asiagoRadioButton);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a pizza to the order.
     *
     * @param event the action event
     */
    @FXML
    void setAddPizzaButton(ActionEvent event) {
        if (!pizza.getComponents().isEmpty()) {

            addedPizzaNum++;
            pizzaOrder.setText("Pizza x" + addedPizzaNum);

            addedToppingNum = 0;
            addedToppingLabel.setText("Total toppings added: " + addedToppingNum);

            foodComponents(pizza.getPrice(), pizza.getComponents());
        }
    }

    private void foodComponents(Double price, ArrayList<AbstractMenuItem> components) {
        StringBuilder sb = new StringBuilder();
        for (MenuItem m : components) {
            sb.append(String.format("%s $%.2f\n", m.toNiceString(), m.getPrice()));
        }

        if (pizza.getComponents().equals(components)) {
            sb.append(String.format("Price: $%.2f\n", pizza.getPrice()));
        } else {
            sb.append(String.format("Price: $%.2f\n", burger.getPrice()));
        }

        foodDescriptions.add(sb.toString());
        foodPrices.add(price);

        System.out.println(sb);
    }

    /**
     * Resets the order.
     *
     * @param event the action event
     */
    @FXML
    void setResetButton(ActionEvent event) {
        thinCrustRadioButton.setSelected(false);
        thickCrustRadioButton.setSelected(false);

        isDeepDishCheck.setSelected(false);

        pepperoniSpicinessSlider.setValue(0);
        sausageSpicinessSlider.setValue(0);

        radioButtons(flourRadioButton, cauliflowerRadioButton, alfredoRadioButton, tomatoPizzaRadioButton, mozzarellaRadioButton, mushroomRadioButton, pepperRadioButton, pepperoniRadioButton, sausageRadioButton, asiagoRadioButton, sesameSeedRadioButton, sourdoughRadioButton);
        radioButtons(wholeWheatRadioButton, beefRadioButton, turkeyRadioButton, chickenRadioButton, brisketRadioButton, americanRadioButton, cheddarRadioButton, swissRadioButton, pepperJackRadioButton, baconRadioButton, pickleRadioButton, lettuceRadioButton);
        tomatoBurgerRadioButton.setSelected(false);

        addedCheeseNum = 0;
        addedCheeseLabel.setText("Total slices added: " + addedCheeseNum);

        addedGarnishNum = 0;
        addedGarnishLabel.setText("Total garnishes added: " + addedGarnishNum);

        addedToppingNum = 0;
        addedToppingLabel.setText("Total toppings added: " + addedToppingNum);

        pizza.clearPizzaComponents();
        burger.clearBurgerComponents();
    }

    private void radioButtons(RadioButton flourRadioButton, RadioButton cauliflowerRadioButton, RadioButton alfredoRadioButton, RadioButton tomatoPizzaRadioButton, RadioButton mozzarellaRadioButton, RadioButton mushroomRadioButton, RadioButton pepperRadioButton, RadioButton pepperoniRadioButton, RadioButton sausageRadioButton, RadioButton asiagoRadioButton, RadioButton sesameSeedRadioButton, RadioButton sourdoughRadioButton) {
        flourRadioButton.setSelected(false);
        cauliflowerRadioButton.setSelected(false);

        alfredoRadioButton.setSelected(false);
        tomatoPizzaRadioButton.setSelected(false);

        mozzarellaRadioButton.setSelected(false);
        mushroomRadioButton.setSelected(false);
        pepperRadioButton.setSelected(false);
        pepperoniRadioButton.setSelected(false);
        sausageRadioButton.setSelected(false);
        asiagoRadioButton.setSelected(false);

        sesameSeedRadioButton.setSelected(false);
        sourdoughRadioButton.setSelected(false);
    }

    /**
     * Shows the receipt for the order.
     *
     * @param event the action event
     */
    @FXML
    void showReceipt(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("receipt.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 600);

            ReceiptController receipt = fxmlLoader.getController();

            String food = String.join("\n", foodDescriptions);
            receipt.displayFoodDesc(food);

            double total = 0;
            for (Double price : foodPrices) {
                total += price;
            }
            receipt.displayTotalPrice(String.valueOf(total));

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the bun choice for the burger.
     *
     * @param event the action event
     */
    @FXML
    void setBunChoice(ActionEvent event) {
        try {
            BurgerBun selectedBun = null;

            if (sesameSeedRadioButton.isSelected()) {
                selectedBun = new SesameSeedBun();
                System.out.println("Sesame Seed Bun Selected!");
            } else if (sourdoughRadioButton.isSelected()) {
                selectedBun = new SourdoughBun();
                System.out.println("Sourdough Bun Selected!");
            } else if (wholeWheatRadioButton.isSelected()) {
                System.out.println("Whole Wheat Bun Selected!");
                selectedBun = new WholeWheatBun();
            }

            if (selectedBun != null) {
                burger.addComponents(selectedBun);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sets the patty choice for the burger.
     *
     * @param event the action event
     */
    @FXML
    void setPattyChoice(ActionEvent event) {
        try {
            BurgerPatty selectedPatty = null;

            if (beefRadioButton.isSelected()) {
                selectedPatty = new BeefPatty();
                System.out.println("Beef Patty Selected!");
            } else if (turkeyRadioButton.isSelected()) {
                selectedPatty = new TurkeyPatty();
                System.out.println("Turkey Patty Selected!");
            } else if (chickenRadioButton.isSelected()) {
                selectedPatty = new ChickenPatty();
                System.out.println("Chicken Patty Selected!");
            } else if (brisketRadioButton.isSelected()) {
                selectedPatty = new BrisketPatty();
                System.out.println("Brisket Patty Selected!");
            }

            if (selectedPatty != null) {
                burger.addComponents(selectedPatty);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a cheese to the burger.
     *
     * @param cheese the cheese to add
     * @param radioButton the radio button associated with the cheese
     */
    void addCheese(BurgerCheese cheese, RadioButton radioButton) {
        burger.addComponents(cheese);
        addedCheeseNum++;
        addedCheeseLabel.setText("Total slices added: " + addedCheeseNum);
        System.out.println("Total slices added: " + addedCheeseNum);
        System.out.println(cheese.getClass().getSimpleName() + " cheese selected");

        PauseTransition pause = new PauseTransition(Duration.seconds(0.3));
        pause.setOnFinished(event -> radioButton.setSelected(false));
        pause.play();
    }

    /**
     * Sets the cheese choice for the burger.
     *
     * @param event the action event
     */
    @FXML
    void setCheeseChoice(ActionEvent event) {
        try {
            if (americanRadioButton.isSelected()) {
                addCheese(new AmericanCheese(), americanRadioButton);
            }

            if (cheddarRadioButton.isSelected()) {
                addCheese(new CheddarCheese(), cheddarRadioButton);
            }

            if (swissRadioButton.isSelected()) {
                addCheese(new SwissCheese(), swissRadioButton);
            }

            if (pepperJackRadioButton.isSelected()) {
                addCheese(new PepperJackCheese(), pepperJackRadioButton);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a garnish to the burger.
     *
     * @param garnish the garnish to add
     * @param radioButton the radio button associated with the garnish
     */
    void addGarnish(BurgerGarnish garnish, RadioButton radioButton) {
        burger.addComponents(garnish);
        addedGarnishNum++;
        addedGarnishLabel.setText("Total garnishes added " + addedGarnishNum);
        System.out.println("Total garnished added " + addedGarnishNum);
        System.out.println(garnish.getClass().getSimpleName() + " garnish selected");

        PauseTransition pause = new PauseTransition(Duration.seconds(0.3));
        pause.setOnFinished(event -> radioButton.setSelected(false));
        pause.play();
    }

    /**
     * Sets the garnish choice for the burger.
     *
     * @param event the action event
     */
    @FXML
    void setGarnishChoice(ActionEvent event) {
        try {
            if (baconRadioButton.isSelected()) {
                addGarnish(new BaconGarnish(), baconRadioButton);
            }

            if (pickleRadioButton.isSelected()) {
                addGarnish(new PickleGarnish(), pickleRadioButton);
            }

            if (lettuceRadioButton.isSelected()) {
                addGarnish(new LettuceGarnish(), lettuceRadioButton);
            }

            if (tomatoBurgerRadioButton.isSelected()) {
                addGarnish(new TomatoGarnish(), tomatoBurgerRadioButton);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a burger to the order.
     *
     * @param event the action event
     */
    @FXML
    void setAddBurgerButton(ActionEvent event) {
        if (!burger.getComponents().isEmpty()) {

            addedBurgerNum++;
            burgerOrder.setText("Burger x" + addedBurgerNum);

            addedCheeseNum = 0;
            addedCheeseLabel.setText("Total slices added: " + addedCheeseNum);

            addedGarnishNum = 0;
            addedGarnishLabel.setText("Total garnishes added: " + addedGarnishNum);

            foodComponents(burger.getPrice(), burger.getComponents());
        }
    }
}