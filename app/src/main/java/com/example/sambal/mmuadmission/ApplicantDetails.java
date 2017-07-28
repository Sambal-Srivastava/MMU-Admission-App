package com.example.sambal.mmuadmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class ApplicantDetails extends AppCompatActivity {
    EditText applicant_mobile;
    EditText applicant_email;
    EditText applicant_name;


    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_details);

        databaseHelper = new DatabaseHelper(this);
        applicant_name = (EditText) findViewById(R.id.editText_name);
        applicant_email = (EditText) findViewById(R.id.editText_email);

        applicant_mobile = (EditText) findViewById(R.id.editText_mobile);
        //USE OF SPINNERS
        Spinner spinner_gender=(Spinner)findViewById(R.id.spinner_gender);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_select, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_gender.setAdapter(adapter);



        //USE OF SPINNERS
        Spinner spinner_martialstatus=(Spinner)findViewById(R.id.spinner_martialstatus);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.martialstatus_select, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_martialstatus.setAdapter(adapter1);



        //USE OF SPINNERS
        Spinner spinner_category=(Spinner)findViewById(R.id.spinner_category);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.category_select, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_category.setAdapter(adapter2);


        Button btn_goto_parents_details= (Button) findViewById(R.id.btn_goto_parents_details);
        btn_goto_parents_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ApplicantDetails.this, ParentsDetails.class);
                startActivity(intent);

                try {

                    boolean result = databaseHelper.insertData2(Integer.parseInt(applicant_mobile.getText().toString()),
                            applicant_name.getText().toString(),applicant_email.getText().toString());
                    if (result)
                        Toast.makeText(ApplicantDetails.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                 catch (Exception e) {
                    Toast.makeText(ApplicantDetails.this, e.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(ApplicantDetails.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
}

