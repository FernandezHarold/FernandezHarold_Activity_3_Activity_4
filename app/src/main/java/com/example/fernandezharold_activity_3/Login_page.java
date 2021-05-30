package com.example.fernandezharold_activity_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_page extends AppCompatActivity {

    EditText text_username_2,text_password_2;
    Button button_signin,button_signup;
    DB Helper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        text_username_2 = (EditText)findViewById(R.id.txt_username_2);
        text_password_2 = (EditText)findViewById(R.id.txt_password_2);
        button_signin = (Button)findViewById(R.id.btn_signin);
        button_signup = (Button)findViewById(R.id.btn_signup);
        Helper = new DB (this);

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = text_username_2.getText().toString();
                String pass = text_password_2.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Login_page.this, "The Username or Password is empty please fill it to log in", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = Helper.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login_page.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Login_Successful.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login_page.this, "Login Failed please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}