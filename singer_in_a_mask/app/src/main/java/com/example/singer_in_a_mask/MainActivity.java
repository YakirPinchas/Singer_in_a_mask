package com.example.singer_in_a_mask;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int numOfChildren = 13;
    int sumOfAges = 374;

    //edit text name
    AppCompatEditText nameRooster;
    AppCompatEditText nameYael;
    AppCompatEditText nameDragon;
    AppCompatEditText namePickle;
    AppCompatEditText nameSafirit;
    AppCompatEditText namePalpel;
    AppCompatEditText namePopcorn;
    AppCompatEditText nameHasida;

    //edit text children
    AppCompatEditText childRooster;
    AppCompatEditText childYael;
    AppCompatEditText childDragon;
    AppCompatEditText childPickle;
    AppCompatEditText childSafirit;
    AppCompatEditText childPalpel;
    AppCompatEditText childPopcorn;
    AppCompatEditText childHasida;

    //edit text age
    AppCompatEditText ageRooster;
    AppCompatEditText ageYael;
    AppCompatEditText ageDragon;
    AppCompatEditText agePickle;
    AppCompatEditText ageSafirit;
    AppCompatEditText agePalpel;
    AppCompatEditText agePopcorn;
    AppCompatEditText ageHasida;
    AppCompatButton check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkIfInputNotNull()){
                    if(sumOfAges() != 0 && numOfChildren() != 0){
                        //function that check if sum of age and sum of children match to rules.
                        checkMatching(sumOfAges() ,numOfChildren());
                    }
                } else {
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                    dlgAlert.setMessage("כל השדות חייבות להיות עם ערך");
                    dlgAlert.setTitle("שגיאה");
                    dlgAlert.setNegativeButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                }
            }
        });
    }

    public void initComponent(){

        nameRooster = findViewById(R.id.rooster_name);
        nameYael = findViewById(R.id.yael_name);
        nameDragon = findViewById(R.id.dragon_name);
        namePickle = findViewById(R.id.pickle_name);
        nameSafirit = findViewById(R.id.safirit_name);
        namePalpel = findViewById(R.id.plapel_name);
        namePopcorn = findViewById(R.id.popcorn_name);
        nameHasida = findViewById(R.id.hasida_name);

        ageRooster = findViewById(R.id.rooster_age);
        ageYael = findViewById(R.id.yael_age);
        ageDragon = findViewById(R.id.dragon_age);
        agePickle = findViewById(R.id.pickle_age);
        ageSafirit = findViewById(R.id.safirit_age);
        agePalpel = findViewById(R.id.plapel_age);
        agePopcorn = findViewById(R.id.popcorn_age);
        ageHasida = findViewById(R.id.hasida_age);

        childRooster = findViewById(R.id.rooster_children);
        childYael = findViewById(R.id.yael_children);
        childDragon = findViewById(R.id.dragon_children);
        childPickle = findViewById(R.id.pickle_children);
        childSafirit = findViewById(R.id.safirit_children);
        childPalpel = findViewById(R.id.plapel_children);
        childPopcorn = findViewById(R.id.popcorn_children);
        childHasida = findViewById(R.id.hasida_children);


        check = findViewById(R.id.check);
    }

    public int sumOfAges(){
        int ageRo = Integer.valueOf(ageRooster.getText().toString());
        int ageYa = Integer.valueOf(ageYael.getText().toString());
        int ageDr = Integer.valueOf(ageDragon.getText().toString());
        int agePi = Integer.valueOf(agePickle.getText().toString());
        int ageSa = Integer.valueOf(ageSafirit.getText().toString());
        int agePa = Integer.valueOf(agePalpel.getText().toString());
        int agePo = Integer.valueOf(agePopcorn.getText().toString());
        int ageHa = Integer.valueOf(ageHasida.getText().toString());

        if(checkAge(ageRo) && checkAge(ageYa) && checkAge(ageDr) && checkAge(agePi)
                && checkAge(ageSa) && checkAge(agePa) && checkAge(agePo) && checkAge(ageHa)){
            return ageRo + ageYa + ageDr + agePi + ageSa + agePa + agePo + ageHa;
        } else {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
            dlgAlert.setMessage("גיל חייב להיות בין 16 ל-90 ");
            dlgAlert.setTitle("שגיאה");
            dlgAlert.setNegativeButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            return 0;
        }

    }

    public boolean checkAge(int age){
        if((age < 90) && (age > 16)){
            return true;
        }
        else return false;
    }

    public int numOfChildren(){

        int childRo = Integer.valueOf(childRooster.getText().toString());
        int childYa = Integer.valueOf(childYael.getText().toString());
        int childDr = Integer.valueOf(childDragon.getText().toString());
        int childPi = Integer.valueOf(childPickle.getText().toString());
        int childSa = Integer.valueOf(childSafirit.getText().toString());
        int childPa = Integer.valueOf(childPalpel.getText().toString());
        int childPo = Integer.valueOf(childPopcorn.getText().toString());
        int childHa = Integer.valueOf(childHasida.getText().toString());

        if(checkNumOfChildren(childRo) && checkNumOfChildren(childYa) && checkNumOfChildren(childDr)
                && checkNumOfChildren(childPi) && checkNumOfChildren(childSa) &&
                checkNumOfChildren(childPa) && checkNumOfChildren(childPo) &&
                checkNumOfChildren(childHa))
        {
            return childRo + childYa + childDr + childPi + childSa + childPa + childPo + childHa;
        } else {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
            dlgAlert.setMessage("מספר ילדים חייב להיות בין 0 ל-10");
            dlgAlert.setTitle("שגיאה");
            dlgAlert.setNegativeButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            return 0;
        }

    }

    public boolean checkNumOfChildren(int numOfChildren){
        if(numOfChildren >= 0 && numOfChildren < 11){
            return true;
        }
        return false;
    }
    public void checkMatching(int sum, int numOfChild){

        if(sum == sumOfAges) {
            if(numOfChild == numOfChildren){
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("הצלחת לדעת מי הם הזמרים מאחורי המסכה!!");
                dlgAlert.setTitle("הצלחה!");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            } else if(numOfChildren > numOfChild) {
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("סכום הגילאים מדויק אבל מספר הילדים קטן ב- " + (numOfChildren - numOfChild) + " ממה שצריך ");
                dlgAlert.setTitle("כישלון!");
                dlgAlert.setNegativeButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            } else {
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("סכום הגילאים מדויק אבל מספר הילדים גדול ב- " + (numOfChild - numOfChildren) + " ממה שצריך ");
                dlgAlert.setTitle("כישלון!");
                dlgAlert.setNegativeButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }

        } else if(sum > sumOfAges) {
            if(numOfChild == numOfChildren) {
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("מספר הילדים מדויק אבל סכום הגילאים גדול ב- " + (sum - sumOfAges) + " ממה שצריך ב ");
                dlgAlert.setTitle("כישלון!");
                dlgAlert.setNegativeButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            } else if(numOfChildren > numOfChild) {
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("סכום הגילאים גדול ב- " + (sum - sumOfAges) + " ממה שצריך ומספר הילדים קטן ב- " + ( numOfChildren - numOfChild) + " ");
                dlgAlert.setTitle("כישלון!");
                dlgAlert.setNegativeButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            } else {
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("סכום הגילאים גדול ב- " + (sum - sumOfAges) + " ממה שצריך ומספר הילדים גדול ב- " + (numOfChild - numOfChildren) + " ");
                dlgAlert.setTitle("כישלון!");
                dlgAlert.setNegativeButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }

        } else {
            if (numOfChild == numOfChildren){
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("מספר הילדים מדויק אבל סכום הגילאים קטן ב- " + (sumOfAges - sum) + " ממה שצריך ");
                dlgAlert.setTitle("כישלון!");
                dlgAlert.setNegativeButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            } else if(numOfChild > numOfChildren) {
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("סכום הגילאים קטן ב- " + (sumOfAges - sum) +  " ממה שצריך ומספר הילדים גדול ב- " + (numOfChild - numOfChildren) + " ");
                dlgAlert.setTitle("כישלון!");
                dlgAlert.setNegativeButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            } else {
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("סכום הגילאים קטן ב- " + (sumOfAges - sum) +  " ממה שצריך ומספר הילדים גדול ב- " + (numOfChildren - numOfChild) + " ");
                dlgAlert.setTitle("כישלון!");
                dlgAlert.setNegativeButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }

        }
    }

    public boolean checkIfInputNotNull(){
        if(nameRooster.getText().toString().matches("")||
                ageRooster.getText().toString().matches("") ||
                childRooster.getText().toString().matches("") ||
                nameYael.getText().toString().matches("")||
                ageYael.getText().toString().matches("") ||
                childYael.getText().toString().matches("")||
                nameDragon.getText().toString().matches("")||
                ageDragon.getText().toString().matches("") ||
                childDragon.getText().toString().matches("")||
                namePickle.getText().toString().matches("")||
                agePickle.getText().toString().matches("") ||
                childPickle.getText().toString().matches("")||
                nameSafirit.getText().toString().matches("")||
                ageSafirit.getText().toString().matches("") ||
                childSafirit.getText().toString().matches("")||
                namePalpel.getText().toString().matches("")||
                agePalpel.getText().toString().matches("") ||
                childPalpel.getText().toString().matches("")||
                namePopcorn.getText().toString().matches("")||
                agePopcorn.getText().toString().matches("") ||
                childPopcorn.getText().toString().matches("")||
                nameHasida.getText().toString().matches("")||
                ageHasida.getText().toString().matches("") ||
                childHasida.getText().toString().matches("")
        ){
            return false;
        }
        return true;
    }
}
