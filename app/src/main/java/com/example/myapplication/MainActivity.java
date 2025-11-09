package com.example.myapplication;

// Import necessary Android libraries
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Main activity class - this is the first screen the user sees
public class MainActivity extends AppCompatActivity {

    // Declare UI element variables (these connect to elements in activity_main.xml)
    public ConstraintLayout main;           // The main container layout
    public Button addButton;                // The "Add" button
    public Button goToSecondPageButton;     // Button to navigate to second page
    public EditText foodItem;               // Input field for food name
    public TextView caloriesText;           // Label that says "Calories: "
    public TextView sugarText;              // Label that says "Sugar:"
    public EditText Meal1;                  // Input field for meal name
    public TextView totalCalories;         // Label that says "Total Calories: "
    public TextView totalSugar;             // Label that says "Total Sugar: "

    // Tracking variables for nutrition data
    int addSugar = 50;              // Amount of sugar to add per button click (in grams)
    int addCal = 50;                // Amount of calories to add per button click
    int totalCalorieIntake = 0;     // Running total of all calories consumed
    int totalSugarIntake = 0;       // Running total of all sugar consumed (in grams)



    /**
     * onCreate method - runs when the app starts up
     * This method initializes the UI and sets up the initial display values
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the parent class's onCreate method (required for Android)
        super.onCreate(savedInstanceState);
        // Enable edge-to-edge display (modern Android UI style)
        EdgeToEdge.enable(this);
        // Load the layout from activity_main.xml
        setContentView(R.layout.activity_main);




        // Initialize all UI elements by connecting them to their XML counterparts
        // findViewById links the Java variables to the UI elements defined in activity_main.xml
        main = findViewById(R.id.main);
        addButton = findViewById(R.id.addButton);
        goToSecondPageButton = findViewById(R.id.goToSecondPageButton);
        foodItem = findViewById(R.id.foodItem);
        caloriesText = findViewById(R.id.caloriesText);
        sugarText = findViewById(R.id.sugarText);
        totalCalories = findViewById(R.id.totalCalories);
        totalSugar = findViewById(R.id.totalSugar);
        Meal1 = findViewById(R.id.Meal1);

        // Set up initial display values when the app starts
        // This shows the default calorie and sugar amounts on startup

        // Display the per-click calorie amount (e.g., "Calories: 50")
        String newCal = caloriesText.getText().toString() + addCal;
        caloriesText.setText(newCal);

        // Display the per-click sugar amount (e.g., "Sugar: 50")
        String newSugar = sugarText.getText().toString() + " " + addSugar;
        sugarText.setText(newSugar);

        // Display the total calories consumed so far (starts at 0)
        String totalCalories_Display = totalCalories.getText().toString() + " " + totalCalorieIntake;
        totalCalories.setText(totalCalories_Display);

        // Display the total sugar consumed so far (starts at 0)
        String totalSugar_Display = totalSugar.getText().toString() + " " + totalSugarIntake + " g";
        totalSugar.setText(totalSugar_Display);

        //Method onClick goes through when the button "Add" is pressed.
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalSugarIntake = totalSugarIntake + addSugar;
                totalCalorieIntake = totalCalorieIntake + addCal;
                totalCalories.setText("Total Calories: " + totalCalorieIntake);
                totalSugar.setText("Total Sugar: " + totalSugarIntake + " g");

            }
        });

        // Navigate to second page when button is clicked
        goToSecondPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}