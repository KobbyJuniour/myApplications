package com.example.expertiseautomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

//import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.gsm.SmsManager;

public class MainActivity extends AppCompatActivity {

    Button buttonSend;
    EditText textPhoneNo;
    EditText textSMS;
    EditText textName;
    EditText textLocation;
    EditText personalPhone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = (EditText) findViewById(R.id.name);
        textLocation = (EditText) findViewById(R.id.location);
        textPhoneNo = (EditText) findViewById(R.id.number);
        textSMS = (EditText) findViewById(R.id.message);
        buttonSend = (Button) findViewById(R.id.alert);
        personalPhone = (EditText) findViewById(R.id.numbers);




        buttonSend.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = textName.getText().toString();
                String location = textLocation.getText().toString();
                String phoneNo = textPhoneNo.getText().toString();
                String perNum = personalPhone.getText().toString();
                String mess = textSMS.getText().toString();
           //  String sms = textSMS.getText().toString();
             String sms = "PetroAuto Customer Report"+ "\n" + "Name: " + textName.getText().toString() + "\n" + "Number: "  + personalPhone.getText().toString() + "\n" + "Location: " + textLocation.getText().toString() +"\n" + "Problem: " +  textSMS.getText().toString();

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent!",
                            Toast.LENGTH_LONG).show();

                    
                        name = " ";
                        location = "";
                        phoneNo = "";
                        perNum = "";
                        mess = "";
                        displayName(name, location, phoneNo, perNum, mess);
                     //   displayForTeamB(scoreTeamB);
                    

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }

            private void displayName(String name, String location, String phoneNo, String perNum, String mess) {
                EditText nameView = (EditText) findViewById(R.id.name);
                nameView.setText(String.valueOf(name));

                EditText locationView = (EditText) findViewById(R.id.location);
                locationView.setText(String.valueOf(location));

                EditText phoneView = (EditText) findViewById(R.id.number);
                phoneView.setText(String.valueOf(phoneNo));

                EditText perNoView = (EditText) findViewById(R.id.numbers);
                perNoView.setText(String.valueOf(perNum));

                EditText messView = (EditText) findViewById(R.id.message);
                messView.setText(String.valueOf(mess));

            }
        });

            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handling options menu item click
        switch (item.getItemId()) {
            case R.id.menuItem1:

                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                // Toast.makeText(this, "About Menu Item Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuItem2:
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
