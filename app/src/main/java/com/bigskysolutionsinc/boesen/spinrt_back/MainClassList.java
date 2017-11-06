package com.bigskysolutionsinc.boesen.spinrt_back;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


import static com.bigskysolutionsinc.boesen.spinrt_back.R.id.txtFirstName;


public class MainClassList extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class_list);

        final Switch swDegreeCert = (Switch) findViewById(R.id.swDegreeCert);
        final Spinner spDegree = (Spinner) findViewById(R.id.spnDegree);
        final Spinner spCertificate = (Spinner) findViewById(R.id.spnCertificate);
        final TextView txtCertificate = (TextView) findViewById(R.id.lblCertificate);
        final TextView txtDegree = (TextView) findViewById(R.id.lblDegree);
        final Button btnNext = (Button) findViewById(R.id.btnNext);

        final EditText firstName = (EditText) findViewById(txtFirstName);
        final EditText lastName = (EditText) findViewById(R.id.txtLastName);
        final EditText phone = (EditText) findViewById(R.id.txtPhone);

        final Spinner spMonth = (Spinner) findViewById(R.id.spnMonth);
        final EditText txtDay = (EditText) findViewById(R.id.txtDay);
        final EditText txtYear = (EditText) findViewById(R.id.txtYear);

        firstName.requestFocus();
       swDegreeCert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked) {
                   spDegree.setVisibility(View.VISIBLE);
                   txtDegree.setVisibility(View.VISIBLE);
                   spCertificate.setVisibility(View.GONE);
                   txtCertificate.setVisibility(View.GONE);
               } else {
                   spDegree.setVisibility(View.GONE);
                   txtDegree.setVisibility(View.GONE);
                   spCertificate.setVisibility(View.VISIBLE);
                   txtCertificate.setVisibility(View.VISIBLE);
               }
           }
       });

       btnNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               if (checkData()) {
                   String doBirth = "";
                   doBirth = spMonth.getSelectedItem().toString() + "/" + txtDay.getText().toString() + "/" + txtYear.getText().toString();

                   // old way
                   // startActivity(new Intent(MainClassList.this, ChooseClass.class));


                   // It is our 'intent' to pass data
                   // So we build the intent
                   Intent nextScreen = new Intent(MainClassList.this, ChooseClass.class);
                   nextScreen.putExtra("FirstName", firstName.getText().toString());
                   nextScreen.putExtra("LastName", lastName.getText().toString());
                   nextScreen.putExtra("Phone", phone.getText().toString());
                   nextScreen.putExtra("BirthDate", doBirth);

                   if (spDegree.getVisibility() == View.VISIBLE) {
                       nextScreen.putExtra("isDegreeCert", "Degree");
                       nextScreen.putExtra("degreeCert", spDegree.getSelectedItem().toString());
                   } else {
                       nextScreen.putExtra("isDegreeCert", "Certificate");
                       nextScreen.putExtra("degreeCert", spCertificate.getSelectedItem().toString());
                   }
                   //Start the activity
                   startActivity(nextScreen);
               }
           }
       });

    }

    private boolean checkData(){


        final EditText firstName = (EditText) findViewById(txtFirstName);
        final EditText lastName = (EditText) findViewById(R.id.txtLastName);
        final EditText phone = (EditText) findViewById(R.id.txtPhone);
        final EditText txtDay = (EditText) findViewById(R.id.txtDay);
        final EditText txtYear = (EditText) findViewById(R.id.txtYear);

        if(firstName.getText().toString().isEmpty()) {
            //error
            firstName.setError(getString(R.string.errFirst));
            firstName.requestFocus();
            return false;
        }
        if(lastName.getText().toString().isEmpty()){
            //error
            lastName.setError(getString(R.string.errLast));
            lastName.requestFocus();
            return false;
        }

        if (phone.getText().toString().isEmpty()){
          // error
            phone.setError(getString(R.string.errPhone));
            phone.requestFocus();
            return false;

        }

        if (txtDay.getText().toString().isEmpty()){
            txtDay.setError(getString(R.string.errDate));
            txtDay.requestFocus();

            return false;
        }

        if (txtYear.getText().toString().isEmpty()){
            // error
            txtYear.setError(getString(R.string.errDate));
            txtYear.requestFocus();
            return false;
        }


        return true;
    }



}
