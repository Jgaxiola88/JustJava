package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method displays the price of the order
     */
    public void displayMessage(String message)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        String priceMessage = "Total: $";
        String closingMessage = "Thank You!";
        displayMessage(priceMessage + (quantity * price + "\n" + closingMessage));
    }

    /**
     * This method is called when the increment button is clicked
     */

    public void incrementOrder(View view)
    {
        quantity++;
        display(quantity);
    }

    /**
     * This method is called when the decrement button is clicked
     */

    public void decrementOrder(View view)
    {
        try
        {
            if (quantity != 0)
            {
                quantity--;
            }
            else
            {
                quantity = 0;
            }
        }
        catch (Exception e)
        {
            display(-1);
        }
        display(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number)
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }

}