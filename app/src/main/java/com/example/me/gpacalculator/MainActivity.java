package com.example.me.gpacalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText c1;
    private EditText c2;
    private EditText c3;
    private EditText c4;
    private EditText c5;
    private TextView GPA;
    private TextView prompt;
    private TextView calGpa;
    private Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = (EditText)findViewById(R.id.c1Txt);
        c2 = (EditText)findViewById(R.id.c2Txt);
        c3 = (EditText)findViewById(R.id.c3Txt);
        c4 = (EditText)findViewById(R.id.c4Txt);
        c5 = (EditText)findViewById(R.id.c5Txt);
        GPA = (TextView)findViewById(R.id.GPATxt);
        calGpa = (TextView)findViewById(R.id.CalculateGpaTxt);
        prompt = (TextView)findViewById(R.id.Prompt);
        calculate = (Button)findViewById(R.id.calculateBtn);


        GPA.setVisibility(View.INVISIBLE); //setting the GPA textview invisible till the user hit the calculate button
        calGpa.setVisibility(View.INVISIBLE); //setting the Calculate Gpa textview invisible till user hit the button
        prompt.setVisibility(View.INVISIBLE); //hiding the prompt till user enter invalid entry

    }


    public void onCalculate(View view){
      if(calculate.getText().toString().equals("COMPUTE GPA")) { //if the button says "Compute GPA" text

             boolean check = validateEntry(c1,c2,c3,c4,c5); //checking the status of entries

          if(check==true) {
              int value1, value2, value3, value4, value5;
              double TotalGrades;

              try {
                  //converting the entered numbers as a string into int
                  value1 = Integer.parseInt(c1.getText().toString());
                  value2 = Integer.parseInt(c2.getText().toString());
                  value3 = Integer.parseInt(c3.getText().toString());
                  value4 = Integer.parseInt(c4.getText().toString());
                  value5 = Integer.parseInt(c5.getText().toString());

                  TotalGrades = (double) (value1 + value2 + value3 + value4 + value5) / 5;
                  GPA.setText(Double.toString(TotalGrades)); //setting the calculated gpa to the GPA textview
                  GPA.setVisibility(View.VISIBLE);//making visible the GPA textview after user hits the button
                  calGpa.setVisibility(View.VISIBLE);//making visible the calculated GPA textview after user hits the button
                  changeBackground(TotalGrades); //calling the changeBackground function to change the activity's background color
                  calculate.setText("Clear"); //changing the text of button to 'clear' from 'calculate'
              } catch (NumberFormatException e) { //if the input enteries are not number then catch block gonna handle the execption by prompting error
                  prompt.setText("All fields has to be numbers!");
                  prompt.setVisibility(View.VISIBLE);
              }
          }
      }
      else
      {

          onClear(); //calls the function call in the case when user hits the clear button
      }
    }

    //the following function validate all the entries to check wheather it is empty or in the range or not.
    public boolean validateEntry(EditText a1, EditText a2, EditText a3, EditText a4, EditText a5){
        boolean result = true;

        if(a1.getText().toString().equals("")) {
            a1.setError("Course1 grade is required!");
            result = false;
        }
        else {
            if((Integer.parseInt(a1.getText().toString())>100) || (Integer.parseInt(a1.getText().toString())<0)) {
                a1.setError("Grade must be between 0 and 100 inclusive");
                result = false;
            }
        }

        if(a2.getText().toString().equals("")) {
            a2.setError("Course2 grade is required!");
            result = false;
        }
        else {
            if((Integer.parseInt(a2.getText().toString())>100) || (Integer.parseInt(a2.getText().toString())<0)) {
                a2.setError("Grade must be between 0 and 100 inclusive");
                result = false;
            }
        }

        if(a3.getText().toString().equals("")) {
            a3.setError("Course3 grade is required!");
            result = false;
        }
        else {
            if((Integer.parseInt(a3.getText().toString())>100) || (Integer.parseInt(a3.getText().toString())<0)) {
                a3.setError("Grade must be between 0 and 100 inclusive");
                result = false;
            }
        }

        if(a4.getText().toString().equals("")) {
            a4.setError("Course4 grade is required!");
            result = false;
        }
        else {
            if((Integer.parseInt(a4.getText().toString())>100) || (Integer.parseInt(a4.getText().toString())<0)) {
                a4.setError("Grade must be between 0 and 100 inclusive");
                result = false;
            }
        }

        if(a5.getText().toString().equals("")) {
            a5.setError("Course5 grade is required!");
            result = false;
        }
        else {
            if((Integer.parseInt(a5.getText().toString())>100) || (Integer.parseInt(a5.getText().toString())<0)) {
                a5.setError("Grade must be between 0 and 100 inclusive");
                result = false;
            }
        }
       return result;
     }

    public void onClear(){ //function which handles the case when user hits the button saying 'clear'
        //clearing all the previous entered entries
        c1.getText().clear();
        c2.getText().clear();
        c3.getText().clear();
        c4.getText().clear();
        c5.getText().clear();

        calculate.setText("COMPUTE GPA"); //changing the text of button back to 'Calculate'
        GPA.setVisibility(View.INVISIBLE);
        calGpa.setVisibility(View.INVISIBLE);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE); //changing the backgroung color back to white or default
    }

    //the following function change the background color depending on the calculated GPA
    public void  changeBackground(double number){
        if(number<=100 && number>=80)
            getWindow().getDecorView().setBackgroundColor(Color.GREEN); //changes the colour of the window before the root layout is applied
        else if(number<=79 && number>=61)
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        else
            getWindow().getDecorView().setBackgroundColor(Color.RED);
    }

}
