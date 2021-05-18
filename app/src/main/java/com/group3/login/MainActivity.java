package com.group3.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText username,password;
    private Button loginBtn;
    private TextView invalid;

    private String username1 = "Phineas";
    private String pass1 = "152204";
    private String username2 = "Jackhole";
    private String pass2 = "1234";
    private String username3 = "plumede";
    private String pass3 = "1234";



    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        loginBtn=(Button) findViewById(R.id.loginBtn);
        invalid = (TextView) findViewById(R.id.invalid);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = username.getText().toString();
                String inputPass = password.getText().toString();


                //validate input
                if(inputName.isEmpty() || inputPass.isEmpty()){
                    invalid.setText("Kindly Enter Credentials");
                }else{

                    isValid = validate(inputName,inputPass);
                    isValid = validate1(inputName,inputPass);
                    isValid = validate2(inputName,inputPass);

                    if(inputName.equals(username1) && inputPass.equals(pass1)){

                        //dashboard activity 1
                        Intent intent = new Intent(MainActivity.this, Dashboard1.class);
                        startActivity(intent);
                        finish();
                    }else if(inputName.equals(username2) && inputPass.equals(pass2)){

                        //dashboard activity 2
                        Intent intent = new Intent(MainActivity.this, Dashboard2.class);
                        startActivity(intent);
                        finish();
                    }else if(inputName.equals(username3) && inputPass.equals(pass3)){

                        //dashboard activity 3
                        Intent intent = new Intent(MainActivity.this, Dashboard3.class);
                        startActivity(intent);
                        finish();
                    }else if(!isValid){
                        invalid.setText("Wrong Credentials");
                    }
                }
            }
        });
    }

    //function to validate the input
    private boolean validate(String name, String password){
        if(name.equals(username1) && password.equals(pass1)){
            return true;
        }
        return false;
    }

    private boolean validate1(String name, String password){
        if(name.equals(username2) && password.equals(pass2)){
            return true;
        }
        return false;
    }

    private boolean validate2(String name, String password){
        if(name.equals(username3) && password.equals(pass3)){
            return true;
        }
        return false;
    }
}