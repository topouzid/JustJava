package com.example.android.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int price = 5;

    static String coffeesToOrder = "1";
    static String coffeeMessage = "$5 per coffee";
    final static String COFFEES_TO_ORDER = "SavedStateOfCoffeesToOrder";
    final static String COFFEE_MESSAGE = "SavedStateOfCoffeeMessage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /** call the super class onCreate to complete the creation of activity like
         * the view hierarchy */
        super.onCreate(savedInstanceState);

        /** recovering the instance state */
        if (savedInstanceState != null) {
            coffeesToOrder = savedInstanceState.getString(COFFEES_TO_ORDER);
            coffeeMessage = savedInstanceState.getString(COFFEE_MESSAGE);
            quantity = Integer.parseInt(coffeesToOrder);
        }
        /** set the user interface layout for this Activity
         * the layout file is defined in the project res/layout/main_activity.xml file */
        setContentView(R.layout.activity_main);

        display(quantity);
        displayMessage(coffeeMessage);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(COFFEES_TO_ORDER, coffeesToOrder);
        outState.putString(COFFEE_MESSAGE, coffeeMessage);

        super.onSaveInstanceState(outState);
    }

    /**
     * This callback is called only when there is a saved instance previously saved using
     * onSaveInstanceState(). We restore some state in onCreate() while we can optionally restore
     * other state here, possibly usable after onStart() has completed.
     * The savedInstanceState Bundle is same as the one used in onCreate().
     */

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        coffeesToOrder = (String) savedInstanceState.getString(COFFEES_TO_ORDER);
        coffeeMessage = savedInstanceState.getString(COFFEE_MESSAGE);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage;
        priceMessage = "Total price: $" + (quantity * price) + "\nThank you!";
        coffeeMessage = priceMessage;
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        coffeesToOrder = String.valueOf(number);
    }

    /**
     * This method displays the given price on the screen.
     *
     * private void displayPrice(int number) {
     * TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
     * priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
     * }
     */

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method is called when the + button is clicked
     *
     * @param view
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the - button is clicked
     *
     * @param view
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }
}