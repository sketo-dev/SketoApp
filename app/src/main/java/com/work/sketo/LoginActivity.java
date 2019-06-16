package com.work.sketo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mName,mPassword;
    private Button btnLogin;
    private CheckBox mCheckbox;
    private TextView textSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mName = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnSignIn);
        mCheckbox = (CheckBox) findViewById(R.id.checkRem);
        textSignUp = (TextView) findViewById(R.id.textSignUp);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mPreferences = getSharedPreferences("com.work.sketo", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkSharedPreference();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save the checkbox preference
                if (mCheckbox.isChecked()) {
                    //set a checkbox when the application starts
                    mEditor.putString(getString(R.string.checkbox),"True");
                    mEditor.commit();

                    //save the name
                    String name = mName.getText().toString();
                    mEditor.putString(getString(R.string.name),name);
                    mEditor.commit();

                    //save the password
                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password),password);
                    mEditor.commit();

                    Intent loginIntent = new Intent(LoginActivity.this, DrawerActivity.class);
                    startActivity(loginIntent);
                    finish();

                }else{
                    //set a checkbox when the application starts
                    mEditor.putString(getString(R.string.checkbox),"False");
                    mEditor.commit();

                    //save the name
                    mEditor.putString(getString(R.string.name),"");
                    mEditor.commit();

                    //save the password
                    mEditor.putString(getString(R.string.password),"");
                    mEditor.commit();

                    Intent loginIntent = new Intent(LoginActivity.this, DrawerActivity.class);
                    startActivity(loginIntent);
                    finish();
                }
            }
        });

        textSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(signupIntent);
            }
        });




/*        mEditor.putString("key","shantanu");
        mEditor.commit();

        String name = mPreferences.getString("some_other_key", "default");
        Log.d(TAG, "onCreate: name: " + name);*/
    }
    private void checkSharedPreference(){
        String checkbox = mPreferences.getString(getString(R.string.checkbox), "False");
        String name = mPreferences.getString(getString(R.string.name), "");
        String password = mPreferences.getString(getString(R.string.password), "");

        mName.setText(name);
        mPassword.setText(password);

        if (checkbox.equals("True")){
            mCheckbox.setChecked(true);
        }else{
            mCheckbox.setChecked(false);
        }
    }
}
