package com.example.sambal.mmuadmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ImageView iv;
    TextView welcometv;
    ImageButton courseib,feeib,admissionib,reviewadmission_ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        iv= (ImageView) findViewById(R.id.logoimageView);
        iv.setImageResource(R.drawable.logo);
        welcometv= (TextView) findViewById(R.id.welcometextView);
        courseib= (ImageButton) findViewById(R.id.courseib);
        courseib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Courses.class);
                startActivity(intent);
            }
        });
        feeib= (ImageButton) findViewById(R.id.feeib);
        feeib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,payment.class);
                startActivity(intent);
            }
        });
        admissionib= (ImageButton) findViewById(R.id.admissionib);
        admissionib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AdmissionActivity.class);
                startActivity(intent);
            }
        });

        reviewadmission_ib = (ImageButton) findViewById(R.id.reviewadmission_ib);
        reviewadmission_ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Review_Admission.class);
                startActivity(intent);
            }
        });

    }
}
