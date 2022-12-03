package com.example.ssas_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import com.example.ssas_project.database.DAO;
import com.example.ssas_project.database.MyDAO;
import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;
import com.example.ssas_project.entity.Student;
import com.example.ssas_project.entity.Types;


public class StudentView extends AppCompatActivity {

    private DAO myDAO;
    private TextView edit_studentname,edit_studentid, edit_studentdob;
    private Button edit_backbutton, edit_viewdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);

        //Connect the variables to their ID
        edit_studentname = findViewById(R.id.student_view_info);
        edit_studentid = findViewById(R.id.student_view_id);
        edit_studentdob = findViewById(R.id.student_view_status);
        edit_backbutton = findViewById(R.id.student_view_backbutton);
        edit_viewdata = findViewById(R.id.student_view_databutton);

        //Retrieve ID from the last activity
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String intent_id = extras.getString("ID");
            Student student_info = myDAO.getStudent(Integer.parseInt(intent_id));
            edit_studentname.setText(student_info.getName());
            edit_studentid.setText(student_info.getId());
            edit_studentdob.setText(student_info.getEmail());
        }

        //Set on click listener for ViewDataButton
        //Click listener to the view data button
        edit_viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentView.this, StudentData.class);
                startActivity(intent);
            }
        });

        //Set on click listener for Back Button
        //Click listener to the back button
        edit_backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentView.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}