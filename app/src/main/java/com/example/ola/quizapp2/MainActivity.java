package com.example.ola.quizapp2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Using intent for launching second activity
        Button switchButton = (Button) findViewById(R.id.help_button);

        switchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }

        });
    }

    /**
     * This method is called when the submit button is clicked
     * It verifies whether all correct answers are selected and gives 1 point for every correct answer
     * and gives 0 for incorrect answers
     *  At the end, it displays final score and reinitialises the variable score
     */
    public void submitAnswers(View view) {

        //------------------------------------------------------------------------------------------
        // Question 1 - Correct answer is #2: Casablanca
        //------------------------------------------------------------------------------------------
        RadioButton question1_answer2 = (RadioButton) this.findViewById(R.id.question1_answer2);
        boolean answer1 = question1_answer2.isChecked();
        if (answer1) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 2 - Correct answer is #3: Marlon Brando
        //------------------------------------------------------------------------------------------
        RadioButton question2_answer3 = (RadioButton) this.findViewById(R.id.question2_answer3);
        boolean answer2 = question2_answer3.isChecked();
        if (answer2) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 3 - Correct answer is: "Zorro"
        //------------------------------------------------------------------------------------------
        EditText question3_answer = (EditText) this.findViewById(R.id.question3_answer);
        String answer3 = question3_answer.getText().toString().toLowerCase();
        if (answer3.equals("zorro") || answer3.equals("Zorro")){
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 4  - Correct answers are: #1, #2 and #3
        //------------------------------------------------------------------------------------------
        CheckBox question4_answer1 = (CheckBox) this.findViewById(R.id.question4_answer1);
        CheckBox question4_answer2 = (CheckBox) this.findViewById(R.id.question4_answer2);
        CheckBox question4_answer3 = (CheckBox) this.findViewById(R.id.question4_answer3);
        CheckBox question4_answer4 = (CheckBox) this.findViewById(R.id.question4_answer4);
        boolean answer4_answer1 = question4_answer1.isChecked();
        boolean answer4_answer2 = question4_answer2.isChecked();
        boolean answer4_answer3 = question4_answer3.isChecked();
        boolean answer4_answer4 = question4_answer4.isChecked();
        if (answer4_answer1 && answer4_answer2 && answer4_answer3 && !answer4_answer4) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 6  - Correct answers are: #1, #2, #3 and #4
        //------------------------------------------------------------------------------------------
        CheckBox question6_answer1 = (CheckBox) this.findViewById(R.id.question6_answer1);
        CheckBox question6_answer2 = (CheckBox) this.findViewById(R.id.question6_answer2);
        CheckBox question6_answer3 = (CheckBox) this.findViewById(R.id.question6_answer3);
        CheckBox question6_answer4 = (CheckBox) this.findViewById(R.id.question6_answer4);
        boolean answer6_answer1 = question6_answer1.isChecked();
        boolean answer6_answer2 = question6_answer2.isChecked();
        boolean answer6_answer3 = question6_answer3.isChecked();
        boolean answer6_answer4 = question6_answer4.isChecked();
        if (answer6_answer1 && answer6_answer2 && answer6_answer3 && answer6_answer4) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 7 - Correct answer is #2: Fight Club
        //------------------------------------------------------------------------------------------
        RadioButton question7_answer2 = (RadioButton) this.findViewById(R.id.question7_answer2);
        boolean answer7 = question7_answer2.isChecked();
        if (answer7) {
            score += 1;
        }

        //------------------------------------------------------------------------------------------
        // Question 5  - Correct answer is: 3
        //------------------------------------------------------------------------------------------

        if (quantity==3){
            score+=1;
        }

        displayScore(view,score);

        // This code reinitializes the score in case user wants to resubmit answers without clicking the reset button
        score = 0;
    }

    //--------------------------------------------------------------------------------------------
    // Final Score
    // This method displays a toast message with the final score when the submit button is clicked
    //--------------------------------------------------------------------------------------------

    public void displayScore(View view, int score) {
        if (score == 7) {
            Toast.makeText(this, R.string.result_message, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.score_message, score), Toast.LENGTH_LONG).show();
        }
    }


    // This method resets the score and deletes all entered answers
    public int resetScore(View view) {

        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.bogart);
        radioGroup1.clearCheck();

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.coppola);
        radioGroup2.clearCheck();

        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.club);
        radioGroup3.clearCheck();

        CheckBox question4_answer1 = (CheckBox) findViewById(R.id.question4_answer1);
        question4_answer1.setChecked(false);

        CheckBox question4_answer2 = (CheckBox) findViewById(R.id.question4_answer2);
        question4_answer2.setChecked(false);

        CheckBox question4_answer3 = (CheckBox) findViewById(R.id.question4_answer3);
        question4_answer3.setChecked(false);

        CheckBox question4_answer4 = (CheckBox) findViewById(R.id.question4_answer4);
        question4_answer4.setChecked(false);

        CheckBox question6_answer1 = (CheckBox) findViewById(R.id.question6_answer1);
        question6_answer1.setChecked(false);

        CheckBox question6_answer2 = (CheckBox) findViewById(R.id.question6_answer2);
        question6_answer2.setChecked(false);

        CheckBox question6_answer3 = (CheckBox) findViewById(R.id.question6_answer3);
        question6_answer3.setChecked(false);

        CheckBox question6_answer4 = (CheckBox) findViewById(R.id.question6_answer4);
        question6_answer4.setChecked(false);

        EditText question3_answer = (EditText) this.findViewById(R.id.question3_answer);
        question3_answer.getText().clear();

        score = 0;

        // Setting quantity of movies in question 5
        quantity = 1;
        display(quantity);
        return score ;

    }

    /**
     * This method increases the quantity of Matrix’s movies by 1 each time the button "+" is clicked
     */
    public void increment(View view) {
        if (quantity < 3) {
            quantity += 1;
            display(quantity);
        } else {
            //Show an error message
            Toast.makeText(getApplicationContext(), "3 movies are a maximum", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method decreases the quantity of Matrix’s movies by 1 each time the button "-" is clicked
     */
    public void decrement(View view) {
        if (quantity == 1) {
            //Show an error message
            Toast.makeText(this, "1 movie is a minimum", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity -= 1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value in question 5
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}
