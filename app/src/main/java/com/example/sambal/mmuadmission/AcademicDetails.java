package com.example.sambal.mmuadmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class AcademicDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_details);
        Button btn_goto_mainActivity= (Button) findViewById(R.id.btn_goto_mainActivity);
        btn_goto_mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcademicDetails.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(AcademicDetails.this,"Your response has been recorded",Toast.LENGTH_LONG).show();


            }


        });

    }
}
