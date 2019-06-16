package com.work.sketo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editName,editEmail,editPhone,editPass,editPassCheck;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        myDB = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editName);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editPhone = (EditText)findViewById(R.id.editPhone);
        editPass = (EditText)findViewById(R.id.editPass);
        editPassCheck = (EditText)findViewById(R.id.editPassCheck);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        AddData();
    }

    public void AddData(){
        buttonSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertData(editName.getText().toString(),
                                editEmail.getText().toString(),
                                editPhone.getText().toString(),
                                editPass.getText().toString());

                        String n = editName.getText().toString();
                        String e = editEmail.getText().toString();
                        String ph = editPhone.getText().toString();
                        String p1 = editPass.getText().toString();
                        String p2 = editPassCheck.getText().toString();

                        if (p2.equals(p1)){
                            if (isInserted == true){
                                Toast.makeText(RegistrationActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();
                            }
                            else
                                Toast.makeText(RegistrationActivity.this,"Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(RegistrationActivity.this,"Passwords dont match !",Toast.LENGTH_LONG).show();
                            editPass.setText("");
                            editPassCheck.setText("");
                        }
                    }
                }
        );
    }
}
