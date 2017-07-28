package com.example.sambal.mmuadmission;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ParentsDetails extends AppCompatActivity {
    EditText applicant_father,applicant_mother;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_details);

        databaseHelper = new DatabaseHelper(this);
        applicant_father = (EditText) findViewById(R.id.editText_fathername);
        applicant_mother = (EditText) findViewById(R.id.editText_mothername);

        Button btn_goto_address_details= (Button) findViewById(R.id.btn_goto_address_details);
        btn_goto_address_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentsDetails.this, Address_Details.class);
                startActivity(intent);

                try {

                    boolean result = databaseHelper.insertData3(applicant_father.getText().toString(),applicant_mother.getText().toString());
                    if (result)
                        Toast.makeText(ParentsDetails.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(ParentsDetails.this, e.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(ParentsDetails.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
}
