package com.example.android.testq;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.testq.R.id.answer1;
import static com.example.android.testq.R.id.answer2;
import static com.example.android.testq.R.id.answer3;
import static com.example.android.testq.R.id.answer4;
import static com.example.android.testq.R.id.playerName;
import static com.example.android.testq.R.id.q1r1;
import static com.example.android.testq.R.id.q1r2;
import static com.example.android.testq.R.id.q2c1;
import static com.example.android.testq.R.id.q2c2;
import static com.example.android.testq.R.id.q2c3;
import static com.example.android.testq.R.id.q2c4;
import static com.example.android.testq.R.id.q3r1;
import static com.example.android.testq.R.id.q3r2;
import static com.example.android.testq.R.id.q4e1;
import static com.example.android.testq.R.id.result;
import static com.example.android.testq.R.id.submit;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void onSubmit(View view) {
        TextView res = (TextView) findViewById(result);
        Button sub = (Button) findViewById(submit);
        EditText pName = (EditText) findViewById(playerName);
        if (pName.getText().toString().isEmpty()){
            Context context = getApplicationContext();
            CharSequence text = "Please enter your name";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (validateQ1() && validateQ2() && validateQ3() && validateQ4()) {
            checkQ1();
            checkQ2();
            checkQ3();
            checkQ4();

            if (checkQ1() && checkQ2() && checkQ3() && checkQ4()) {
                res.setText("Congrats");
                sub.setEnabled(false);
            } else {
                res.setText("Sorry. Try again");
            }
        }
            else{

                Context context = getApplicationContext();
                CharSequence text = "Please answer all questions";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        }


    public boolean validateQ1(){
        RadioButton q1rb1 = (RadioButton) findViewById(q1r1);
        RadioButton q1rb2= (RadioButton) findViewById(q1r2);
        boolean isAnsweredQ1 = false;

        if (q1rb1.isChecked()|| q1rb2.isChecked()){
            isAnsweredQ1 =true;
        }


     return isAnsweredQ1;
    }
    public boolean validateQ2(){
        CheckBox q2cb1 = (CheckBox) findViewById(q2c1);
        CheckBox q2cb2 = (CheckBox) findViewById(q2c2);
        CheckBox q2cb3 = (CheckBox) findViewById(q2c3);
        CheckBox q2cb4 = (CheckBox) findViewById(q2c4);
        boolean isAnsweredQ2 = false;
        if (q2cb1.isChecked() || q2cb1.isChecked()|| q2cb3.isChecked()|| q2cb4.isChecked()){
            isAnsweredQ2 =true;
        }
        return isAnsweredQ2;
    }
    public boolean validateQ3(){
        RadioButton q3rb1 = (RadioButton) findViewById(q3r1);
        RadioButton q3rb2= (RadioButton) findViewById(q3r2);
        boolean isAnsweredQ3 = false;
        if (q3rb1.isChecked()|| q3rb2.isChecked()){
            isAnsweredQ3 =true;
        }


        return isAnsweredQ3;
    }
    public boolean validateQ4() {
        EditText q4et = (EditText) findViewById(q4e1);
        boolean isAnsweredQ4 = false;
        if (q4et.getText().toString().trim().length() > 0) {
 isAnsweredQ4=true;
        }
        return isAnsweredQ4;
    }
    public boolean checkQ1(){
        RadioButton q1rb1 = (RadioButton) findViewById(q1r1);
        RadioButton q1rb2= (RadioButton) findViewById(q1r2);
        Button ans1 = (Button) findViewById(answer1);
        boolean isCorrectQ1 = false;

       // RadioButton q1R2 = (RadioButton) findViewById(q1r2);

        if (q1rb1.isChecked()){
            isCorrectQ1=true;
            ans1.setPressed(true);
            ans1.setText("");
        }
        else
        {
            ans1.setText("X");
        }
        return isCorrectQ1;

            }
    public boolean checkQ2(){
        CheckBox q2cb1 = (CheckBox) findViewById(q2c1);
        CheckBox q2cb2 = (CheckBox) findViewById(q2c2);
        CheckBox q2cb3 = (CheckBox) findViewById(q2c3);
        CheckBox q2cb4 = (CheckBox) findViewById(q2c4);
        Button ans2 = (Button) findViewById(answer2);
        boolean isCorrectQ2 = false;


       if(q2cb1.isChecked() && q2cb3.isChecked()){
            isCorrectQ2=true;
           ans2.setPressed(true);
           ans2.setText("");
        }
       else
       {

           ans2.setPressed(false);
           ans2.setText("X");
       }
        return isCorrectQ2;
    }

    public boolean checkQ3(){
        RadioButton q3rb1 = (RadioButton) findViewById(q3r1);
        RadioButton q3rb2= (RadioButton) findViewById(q3r2);
        Button ans3 = (Button) findViewById(answer3);
        boolean isCorrectQ3 = false;


        if (q3rb1.isChecked()){
            isCorrectQ3=true;
            ans3.setPressed(true);
            ans3.setText("");
        }
        else
        {
            ans3.setPressed(false);
            ans3.setText("X");

        }
        return isCorrectQ3;
    }
    public boolean checkQ4(){
        EditText q4et = (EditText) findViewById(q4e1);
        Button ans4 = (Button) findViewById(answer4);
        boolean isCorrectQ4 = false;

        String q4Answer = q4et.getText().toString().trim();
        Log.v("Main",q4Answer);
        if ( q4Answer.equalsIgnoreCase("yes")){
            isCorrectQ4=true;
            ans4.setPressed(true);
            ans4.setText("");
        }
        else
        {
            ans4.setText("X");
        }
        return isCorrectQ4 ;

    }


}
