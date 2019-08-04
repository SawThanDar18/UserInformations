package com.padcmyanmar.padc9.userinformations;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String gender;

        final EditText name_et = findViewById(R.id.name_et);
        final EditText email_et = findViewById(R.id.email_et);
        final EditText phone_et = findViewById(R.id.phone_et);
        final EditText address_et = findViewById(R.id.address_et);

        final RadioButton male_rb = findViewById(R.id.male_rb);
        final RadioButton female_rb = findViewById(R.id.female_rb);

        final CheckBox reading_cb = findViewById(R.id.reading_cb);
        final CheckBox swimming_cb = findViewById(R.id.swimming_cb);
        final CheckBox walking_cb = findViewById(R.id.walking_cb);
        final CheckBox travelling_cb = findViewById(R.id.travelling_cb);

        Button ok_btn = findViewById(R.id.ok_btn);

//        male_rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    getString(R.string.male_rb);
//                }
//            }
//        });
//
//        female_rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    getString(R.string.female_rb);
//                }
//            }
//        });

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gender = "";
                if(male_rb.isChecked()){
                    gender = getString(R.string.male_rb);
                }

                else if(female_rb.isChecked()){
                    gender = getString(R.string.female_rb);
                }

                String intresting = reading_cb.isChecked() ? getString(R.string.reading_cb) : "";
                intresting += swimming_cb.isChecked() ? "," + "Swimming" : "";
                intresting += walking_cb.isChecked() ? "," + "Walking" : "";
                intresting += travelling_cb.isChecked() ? "," + "Travelling" : "";

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Profile");
                alertDialog.setMessage("Name : " + name_et.getText() + "\n" + "Email : " + email_et.getText() +
                                       "\n" + "Phone Number : " + phone_et.getText() + "\n" + "Address : " + address_et.getText() +
                                       "\n" + "Gender : " + gender + "\n" + "Interesting Category : " + intresting);

                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                name_et.setText("");
                                email_et.setText("");
                                phone_et.setText("");
                                address_et.setText("");
                            }
                        });
                alertDialog.show();
            }
        });

    }
}
