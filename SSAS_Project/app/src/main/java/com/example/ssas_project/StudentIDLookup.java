package com.example.ssas_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.ssas_project.database.DAO;
import com.example.ssas_project.database.MyDAO;
import com.example.ssas_project.entity.Student;
import com.example.ssas_project.entity.Types;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;


import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;



public class StudentIDLookup extends AppCompatActivity {

    private DAO myDAO;
    private EditText edit_id;
    private Button edit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_idlookup);

        edit_id = findViewById(R.id.studentid_id);
        edit_button = findViewById(R.id.studentid_button);

        //Initialize DAO
        myDAO = new MyDAO(this);

        //Create a bunch of student with IDs
        //for(int i = 0; i < 100; i++) {
            //Student student = new Student(i, "44444", "44444@tufts.edu",
                    //Types.StudentStatus.junior, "44444");
            //myDAO.insertStudent(student);
       // }

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edit_id.getText().toString();
                Intent intent = new Intent(StudentIDLookup.this,StudentView.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });
    }
}