package com.example.fernandezharold_activity_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text_username,text_password,text_retype;
    Button button_register,button_return;
    DB helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_username = (EditText)findViewById(R.id.txt_username);
        text_password = (EditText)findViewById(R.id.txt_password);
        text_retype = (EditText)findViewById(R.id.txt_retype);
        button_register = (Button)findViewById(R.id.btn_register);
        button_return = (Button)findViewById(R.id.btn_return);
        helper = new DB(this);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = text_username.getText().toString();
                String pass = text_password.getText().toString();
                String retry = text_retype.getText().toString();

                if(user.equals("")||pass.equals("")||retry.equals(""))
                    Toast.makeText(MainActivity.this, "Please fill all fields to complete your registration", Toast.LENGTH_SHORT).show();
                else{

                    if(pass.equals(retry)) {
                        Boolean checkuser = helper.checkusername(user);

                        if (checkuser == false) {
                            Boolean insert = helper.insertData(user, pass);

                            if (insert == true) {
                                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "There is a problem with your registration", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Username already in use", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login_page.class);
                startActivity(intent);
            }
        });
    }
}