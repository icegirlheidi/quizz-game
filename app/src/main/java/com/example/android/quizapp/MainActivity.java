package com.example.android.quizapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.GridLayout.LayoutParams;

import org.w3c.dom.Text;

import static android.R.attr.button;
import static android.R.attr.checked;
import static android.R.attr.value;
import static android.view.View.generateViewId;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswer(View view) {

        // get the value of the first question, which is an edit text input
        EditText editText = (EditText) findViewById(R.id.edit_text_one);
        String editTextAnswer = editText.getText().toString();

        /**
         * get the value of the second question, which is a radio group
         */
        // find the radio group based on its view Id
        RadioGroup radioGroupOne = (RadioGroup) findViewById(R.id.radio_group_one);

        // get the Id of selected radio button within the radio group
        int selectedRadioButtonIdOne = radioGroupOne.getCheckedRadioButtonId();

        // find the selected radio button based on its Id
        RadioButton selectedRadioButtonOne = (RadioButton) findViewById(selectedRadioButtonIdOne);

        // get the text of the selected radio button
        String selectedRadioButtonOneText = "";
        if (selectedRadioButtonOne != null) {
            selectedRadioButtonOneText = selectedRadioButtonOne.getText().toString();
        }


        // get the value of the third question, which is a radio group
        RadioGroup radioGroupTwo = (RadioGroup) findViewById(R.id.radio_group_two);
        int selectedRadioButtonIdTwo = radioGroupTwo.getCheckedRadioButtonId();
        RadioButton selectedRadioButtonTwo = (RadioButton) findViewById(selectedRadioButtonIdTwo);
        String selectedRadioButtonTwoText = "";
        if (selectedRadioButtonTwo != null) {
            selectedRadioButtonTwoText = selectedRadioButtonTwo.getText().toString();
        }

        // calculate the total score that user gets
        checkAnswers(editTextAnswer, selectedRadioButtonOneText, selectedRadioButtonTwoText);

        // Pop up a toast to show the total score based on user's answers
        Context context = getApplicationContext();
        String resultSummary = getString(R.string.toast_results, score);
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, resultSummary, duration);
        toast.show();
    }

    /**
     * It calculates the total score that user gets. Each question is 20 points.
     *
     * @param answerOne   is the the text input user types when answering the first question
     * @param answerTwo   is the value of selected option that user chose for question two
     * @param answerThree is the value of selected option that user chose for question three
     */
    private int checkAnswers(String answerOne, String answerTwo, String answerThree) {

        // Reset the score to zero
        score = 0;

        // The right answers of question 1 - 3
        String rightAnswerOfQuestionOne = getString(R.string.right_answer_question_one);
        String rightAnswerOfQuestionTwo = getString(R.string.right_answer_question_two);
        String rightAnswerOfQuestionThree = getString(R.string.right_answer_question_three);

        // Figure out each option of checkbox is chosen or not
        CheckBox checkBoxOne = (CheckBox) findViewById(R.id.checkbox_one);
        boolean isChekedForOptionOne = checkBoxOne.isChecked();

        CheckBox checkBoxTwo = (CheckBox) findViewById(R.id.checkbox_two);
        boolean isChekedForOptionTwo = checkBoxTwo.isChecked();

        CheckBox checkBoxThree = (CheckBox) findViewById(R.id.checkbox_three);
        boolean isCheckedForOptionThree = checkBoxThree.isChecked();

        CheckBox checkBoxFour = (CheckBox) findViewById(R.id.checkbox_four);
        boolean isCheckedForOptionFour = checkBoxFour.isChecked();

        CheckBox checkBoxFive = (CheckBox) findViewById(R.id.checkbox_five);
        boolean isCheckedForOptionFive = checkBoxFive.isChecked();

        CheckBox checkBoxSix = (CheckBox) findViewById(R.id.checkbox_six);
        boolean isCheckedForOptionSix = checkBoxSix.isChecked();

        CheckBox checkBoxSeven = (CheckBox) findViewById(R.id.checkbox_seven);
        boolean isCheckedForOptionSeven = checkBoxSeven.isChecked();

        CheckBox checkBoxEight = (CheckBox) findViewById(R.id.checkbox_eight);
        boolean isCheckedForOptionEight = checkBoxEight.isChecked();

        // Check whether user's answer of question ONE is right
        // If it's right, 20 points will be added to score. The text "RIGHT" will be shown up under question 1
        // If it's wrong, no point will be addedd to score. The text "WRONG" will be shown up under question 1
        TextView tx1 = (TextView) findViewById(R.id.answer_status_question_one);
        tx1.setText("");
        tx1.setVisibility(View.VISIBLE);
        if (answerOne.equals(rightAnswerOfQuestionOne)) {
            score += 20;
            tx1.setText(getString(R.string.correct_status));
            tx1.setTextColor(Color.parseColor("#8BC34A"));
        } else {
            tx1.setText(getString(R.string.incorrect_status));
            tx1.setTextColor(Color.parseColor("#F44336"));
        }

        // Check whether user's answer of question TWO is right
        TextView tx2 = (TextView) findViewById(R.id.answer_status_question_two);
        tx2.setText("");
        tx2.setVisibility(View.VISIBLE);
        if (answerTwo.equals(rightAnswerOfQuestionTwo)) {
            score += 20;
            tx2.setText(getString(R.string.correct_status));
            tx2.setTextColor(Color.parseColor("#8BC34A"));

        } else {
            tx2.setText(getString(R.string.incorrect_status));
            tx2.setTextColor(Color.parseColor("#F44336"));
        }

        // Check whether user's answer of question THREE is right
        TextView tx3 = (TextView) findViewById(R.id.answer_status_question_three);
        tx3.setText("");
        tx3.setVisibility(View.VISIBLE);
        if (answerThree.equals(rightAnswerOfQuestionThree)) {
            score += 20;
            tx3.setText(getString(R.string.correct_status));
            tx3.setTextColor(Color.parseColor("#8BC34A"));
        } else {
            tx3.setText(getString(R.string.incorrect_status));
            tx3.setTextColor(Color.parseColor("#F44336"));
        }

        // Check whether user's answer of question FOUR is right
        TextView tx4 = (TextView) findViewById(R.id.answer_status_question_four);
        tx4.setText("");
        tx4.setVisibility(View.VISIBLE);
        if (!isChekedForOptionOne && isChekedForOptionTwo && !isCheckedForOptionThree && isCheckedForOptionFour) {
            score += 20;
            tx4.setText(getString(R.string.correct_status));
            tx4.setTextColor(Color.parseColor("#8BC34A"));
        } else {
            tx4.setText(getString(R.string.incorrect_status));
            tx4.setTextColor(Color.parseColor("#F44336"));
        }

        // Check whether user's answer of question FIVE is right
        TextView tx5 = (TextView) findViewById(R.id.answer_status_question_five);
        tx5.setText("");
        tx5.setVisibility(View.VISIBLE);
        if (isCheckedForOptionFive && !isCheckedForOptionSix && !isCheckedForOptionSeven && isCheckedForOptionEight) {
            score += 20;
            tx5.setText(getString(R.string.correct_status));
            tx5.setTextColor(Color.parseColor("#8BC34A"));
        } else {
            tx5.setText(getString(R.string.incorrect_status));
            tx5.setTextColor(Color.parseColor("#F44336"));
        }

        // This method returns the total points that user gets based on his/her answers
        return score;
    }


    /**
     * Reset the answer when the reset button is clicked
     */
    public void resetAnswer(View view) {

        // Clear the answer for question 1
        EditText editText = (EditText) findViewById(R.id.edit_text_one);
        editText.setText(null);
        // Clear the RIGHT/WRONG status of question 1
        TextView tx1 = (TextView) findViewById(R.id.answer_status_question_one);
        tx1.setVisibility(View.GONE);

        // Clear the answer for question 2
        RadioGroup radioGroupOne = (RadioGroup) findViewById(R.id.radio_group_one);
        radioGroupOne.clearCheck();
        // Clear the RIGHT/WRONG status of question 2
        TextView tx2 = (TextView) findViewById(R.id.answer_status_question_two);
        tx2.setVisibility(View.GONE);

        // Clear the answer for question 3
        RadioGroup radioGroupTwo = (RadioGroup) findViewById(R.id.radio_group_two);
        radioGroupTwo.clearCheck();
        // Clear the RIGHT/WRONG status of question 3
        TextView tx3 = (TextView) findViewById(R.id.answer_status_question_three);
        tx3.setVisibility(View.GONE);

        // Clear the RIGHT/WRONG status of question 4
        TextView tx4 = (TextView) findViewById(R.id.answer_status_question_four);
        tx4.setVisibility(View.GONE);

        // Clear the answer for question 4
        CheckBox checkBoxOne = (CheckBox) findViewById(R.id.checkbox_one);
        if (checkBoxOne.isChecked()) {
            checkBoxOne.setChecked(false);
        }
        CheckBox checkBoxTwo = (CheckBox) findViewById(R.id.checkbox_two);
        if (checkBoxTwo.isChecked()) {
            checkBoxTwo.setChecked(false);
        }
        CheckBox checkBoxThree = (CheckBox) findViewById(R.id.checkbox_three);
        if (checkBoxThree.isChecked()) {
            checkBoxThree.setChecked(false);
        }
        CheckBox checkBoxFour = (CheckBox) findViewById(R.id.checkbox_four);
        if (checkBoxFour.isChecked()) {
            checkBoxFour.setChecked(false);
        }

        // Clear the RIGHT/WRONG status of question 5
        TextView tx5 = (TextView) findViewById(R.id.answer_status_question_five);
        tx5.setVisibility(View.GONE);

        // Clear the answer for question 5
        CheckBox checkBoxFive = (CheckBox) findViewById(R.id.checkbox_five);
        if (checkBoxFive.isChecked()) {
            checkBoxFive.setChecked(false);
        }
        CheckBox checkBoxSix = (CheckBox) findViewById(R.id.checkbox_six);
        if (checkBoxSix.isChecked()) {
            checkBoxSix.setChecked(false);
        }
        CheckBox checkBoxSeven = (CheckBox) findViewById(R.id.checkbox_seven);
        if (checkBoxSeven.isChecked()) {
            checkBoxSeven.setChecked(false);
        }
        CheckBox checkBoxEight = (CheckBox) findViewById(R.id.checkbox_eight);
        if (checkBoxEight.isChecked()) {
            checkBoxEight.setChecked(false);
        }
    }

}
