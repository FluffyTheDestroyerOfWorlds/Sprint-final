package com.bigskysolutionsinc.boesen.spinrt_back;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    private String firstName = "";
    private String lastName = "";
    private String phone ="";
    private String birthDate = "";
    private String isDegreeCert = "";
    private String degreeCert = "";
    private String class1 = "";
    private String selected1 = "";
    private String class2 = "";
    private String selected2 = "";
    private String class3 = "";
    private String selected3 = "";
    private String class4 = "";
    private String selected4 = "";

//                     nextScreen.putExtra("FirstName", firstName);
//                      nextScreen.putExtra("LastName", lastName);
//                      nextScreen.putExtra("Phone", phone);
//                      nextScreen.putExtra("BirthDate", birthDate);
//                      nextScreen.putExtra("isDegreeCert", isDegreeCert);
//                      nextScreen.putExtra("degreeCert", degreeCert);
//
//                      nextScreen.putExtra("Class1", ctv1Text);
//                      nextScreen.putExtra("Selected1", selectedTime1);
//
//                      nextScreen.putExtra("Class2",ctv2Text);
//                      nextScreen.putExtra("Selected2", selectedTime2);
//
//                      nextScreen.putExtra("Class3", ctv3Text);
//                      nextScreen.putExtra("Selected3",selectedTime3);
//
//                      nextScreen.putExtra("Class4", ctv4Text);
//                      nextScreen.putExtra("Selected4", selectedTime4);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            firstName = extras.getString("FirstName");
            lastName = extras.getString("LastName");
            phone = extras.getString("Phone");
            birthDate = extras.getString("BirthDate");
            isDegreeCert = extras.getString("isDegreeCert");
            degreeCert = extras.getString("degreeCert");
            class1 = extras.getString("Class1");
            selected1 = extras.getString("Selected1");
            class2 = extras.getString("Class2");
            selected2 = extras.getString("Selected2");
            class3 = extras.getString("Class3");
            selected3 = extras.getString("Selected3");
            class4 = extras.getString("Class4");
            selected4 = extras.getString("Selected4");
        }

        final TextView txtStudent = (TextView) findViewById(R.id.txtStudent);
        final TextView txtPhone = (TextView) findViewById(R.id.txtPhone);
        final TextView txtBirthdate = (TextView) findViewById(R.id.txtBirthDate);
        final TextView txtDegreePlan = (TextView) findViewById(R.id.txtDegree);
        final TextView txtMajor = (TextView) findViewById(R.id.txtMajor);
        final TextView txtClassSchedule = (TextView) findViewById(R.id.txtClassSchedule);
        StringBuilder ClassSchedule = new StringBuilder(250);



        txtStudent.setText(firstName + " " + lastName);
        txtPhone.setText(phone);
        txtBirthdate.setText(birthDate);
        txtDegreePlan.setText(isDegreeCert);
        txtMajor.setText(degreeCert);

        if(class1 != null) {
            ClassSchedule.append(class1 + "\n" + findTheTime(Integer.parseInt(selected1)) + "\n");
        }
        if(class2 != null) {
            ClassSchedule.append(class2 + "\n" + findTheTime(Integer.parseInt(selected2)) + "\n");
        }
        if(class3 != null) {
            ClassSchedule.append(class3 + "\n" + findTheTime(Integer.parseInt(selected3)) + "\n");
        }
        if(class4 != null) {
            ClassSchedule.append(class4 + "\n" + findTheTime(Integer.parseInt(selected4)) + "\n");
        }

        txtClassSchedule.setText(ClassSchedule);


    }

    public String findTheTime(int nRes){
        String foundString = "";

        switch (nRes) {
            case R.string.timeRb1:
                foundString = getResources().getString(R.string.timeRb1);
                break;
            case R.string.timeRb2:
                foundString = getResources().getString(R.string.timeRb2);
                break;
            case R.string.timeRb3:
                foundString = getResources().getString(R.string.timeRb3);
                break;
            case R.string.timeRb4:
                foundString = getResources().getString(R.string.timeRb4);
                break;
            case R.string.timeRb5:
                foundString = getResources().getString(R.string.timeRb5);
                break;
            case R.string.timeRb6:
                foundString = getResources().getString(R.string.timeRb6);
                break;
            default:
                foundString = "Unknown Timeslot";
                break;
        }


        return foundString;
    }

}
