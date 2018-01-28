package com.example.rod.shoppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShoppyMain extends AppCompatActivity {

    private Budget budget = new Budget();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppy_main);
    }

    /*
        Get budget value from text box and store
     */
    public void saveBudget(View view) {
        EditText budgettext = (EditText) findViewById(R.id.budgetValue);
        Double budgetvalue = Double.valueOf(budgettext.getText().toString());

        budget.setStartingbudget(budgetvalue);

        budgettext.setText("");
        updateText();
    }

    public void subtractPrice(View view) {
        EditText pricetext = findViewById(R.id.itemPrice);
        Double price = Double.valueOf(pricetext.getText().toString());

        budget.updateBudget(price);

        pricetext.setText("");
        updateText();
    }

    private void updateText(){
        TextView startbudgettext = (TextView) findViewById(R.id.startBudget);
        TextView remainingbudgettext = (TextView) findViewById(R.id.remainingBudget);
        TextView usedbudgettext = (TextView) findViewById(R.id.usedBudget);

        startbudgettext.setText(Double.toString(budget.getStartingbudget()));
        remainingbudgettext.setText(Double.toString(budget.getRemainingbudget()));
        usedbudgettext.setText(Double.toString(budget.getUsedbudget()));
    }

}
