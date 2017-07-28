package com.example.sambal.mmuadmission;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Review_Admission extends AppCompatActivity {
    EditText et_search_applicant_mobile;
    Button button_search_applicant_details;
    TextView tv_show_campus,tv_show_seat,tv_show_mobile_applicant,tv_show_name_applicant,tv_show_email_applicant,tv_show_fathername,tv_show_mothername;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review__admission);

        databaseHelper = new DatabaseHelper(this);

        et_search_applicant_mobile = (EditText) findViewById(R.id.et_search_applicant_mobile);

        button_search_applicant_details = (Button) findViewById(R.id.button_search_applicant_details);

        tv_show_campus = (TextView) findViewById(R.id.tv_show_campus);
        tv_show_seat = (TextView) findViewById(R.id.tv_show_seat);
        tv_show_name_applicant = (TextView) findViewById(R.id.tv_show_name_applicant);
        tv_show_email_applicant = (TextView) findViewById(R.id.tv_show_email_applicant);
        tv_show_mobile_applicant = (TextView) findViewById(R.id.tv_show_mobile_applicant);
        tv_show_fathername = (TextView) findViewById(R.id.tv_show_father_name);
        tv_show_mothername = (TextView) findViewById(R.id.tv_show_mothername);

        button_search_applicant_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = databaseHelper.getData(et_search_applicant_mobile.getText().toString());

                tv_show_campus.setText(" ");
                tv_show_seat.setText(" ");
                tv_show_mobile_applicant.setText(" ");
                tv_show_name_applicant.setText(" ");
                tv_show_email_applicant.setText(" ");

                while (cursor.moveToNext()) {
                    tv_show_campus.setText(cursor.getString(1));
                    tv_show_seat.setText(cursor.getString(2));
                    tv_show_name_applicant.setText(cursor.getString(4));
                    tv_show_email_applicant.setText(cursor.getString(5));
                    tv_show_mobile_applicant.setText(cursor.getString(3));
                    tv_show_fathername.setText(cursor.getString(6));
                    tv_show_mothername.setText(cursor.getString(7));
                }
            }
        });


    }
}
