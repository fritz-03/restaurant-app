package com.fritz.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller for the receipt view.
 */
public class ReceiptController {

    @FXML
    public Label totalPriceLabel;

    @FXML
    public Label displayFoodDesc;

    /**
     * Displays the food description.
     *
     * @param foodDesc the food description
     */
    void displayFoodDesc(String foodDesc) {
        displayFoodDesc.setText("\n" + foodDesc);
    }

    /**
     * Displays the total price.
     *
     * @param total the total price
     */
     void displayTotalPrice(String total) {
        totalPriceLabel.setText(String.format
                ("Total Price: $%.2f\n", Double.parseDouble(total)));
    }

}
