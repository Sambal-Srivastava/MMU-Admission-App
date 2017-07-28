package com.example.sambal.mmuadmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AdmissionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RadioGroup rg_nationality;
//    RadioButton rb_4storerbid;

    String campus_selection;
    String radiovalue;
    String mySelectedText;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);

        databaseHelper = new DatabaseHelper(this);



        //USE OF SPINNERS
        final Spinner spinner_campus = (Spinner) findViewById(R.id.spinner_campus);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.campus_select, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_campus.setAdapter(adapter);

        spinner_campus.setOnItemSelectedListener(this);

        //USE OF RADIO GROUPS AND BUTTONS
        rg_nationality = (RadioGroup) findViewById(R.id.rg_nationality);

        //Use ofSpinners
        Spinner spinner_courseselect = (Spinner) findViewById(R.id.spinner_courseselect);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.course_select, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_courseselect.setAdapter(adapter1);

        Button btn_goto_applicant_details = (Button) findViewById(R.id.btn_goto_applicant_details);
        btn_goto_applicant_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdmissionActivity.this, ApplicantDetails.class);
                startActivity(intent);

            }
        });

    }

    //Use Of Campus selection Listener
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // An item was selected. You can retrieve the selected item using
        campus_selection = (String) parent.getItemAtPosition(position);
        try {

            boolean result = databaseHelper.insertData(campus_selection);
//            if (result)
//                Toast.makeText(AdmissionActivity.this, "Data recorded", Toast.LENGTH_SHORT).show();
//                    else
//                        Toast.makeText(AddNewContact.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(AdmissionActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            Toast.makeText(AdmissionActivity.this, "Data not recorded", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        Toast.makeText(AdmissionActivity.this, "Please make a valid selection", Toast.LENGTH_LONG).show();
    }


    public void rbclick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radiobtn_generalseat:
                if (checked)
                // General seat selected
                {
//                    radiovalue = ((RadioButton) this.findViewById(rg_nationality.getCheckedRadioButtonId())).getText().toString();
                    int id = rg_nationality.getCheckedRadioButtonId();
                    RadioButton mySelectedRadioButton = (RadioButton) findViewById(id);
                    mySelectedText = mySelectedRadioButton.getText().toString();
                    //Save the value to database
                    try {

                        boolean result = databaseHelper.insertData1(mySelectedText.toString());
                        if (result)

                            Toast.makeText(AdmissionActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
//                    else
//                        Toast.makeText(AddNewContact.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(AdmissionActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(AdmissionActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.radiobtn_NRIseat:
                if (checked) {
                    // NRI seat selected
//                    radiovalue=  ((RadioButton)this.findViewById(rg_nationality.getCheckedRadioButtonId())).getText().toString();
                    int id = rg_nationality.getCheckedRadioButtonId();
                    RadioButton mySelectedRadioButton = (RadioButton) findViewById(id);
                    mySelectedText = mySelectedRadioButton.getText().toString();
                    //Save the value to database
                    try {

                        boolean result = databaseHelper.insertData1(mySelectedText.toString());
                        if (result)

                            Toast.makeText(AdmissionActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
//                    else
//                        Toast.makeText(AddNewContact.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(AdmissionActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(AdmissionActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                    }
                }
                break;


        }
    }

}