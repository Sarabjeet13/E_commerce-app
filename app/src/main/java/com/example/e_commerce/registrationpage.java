package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registrationpage extends AppCompatActivity {
    EditText name,gmail,password,cpassword;
    Button register;
    TextView ahac;

    com.example.e_commerce.DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationpage);


        name=(EditText) findViewById(R.id.name);
        gmail=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        cpassword=(EditText) findViewById(R.id.cpassword);

        register=(Button) findViewById(R.id.button);
        ahac=(TextView) findViewById(R.id.textView);
        DB=new DBhelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=name.getText().toString();
                String pass=password.getText().toString();

                String repass=cpassword.getText().toString();
                String gl=gmail.getText().toString();

                if (TextUtils.isEmpty(user) ||TextUtils.isEmpty(pass) ||TextUtils.isEmpty(repass) ||TextUtils.isEmpty(gl))
                {
                    Toast.makeText(registrationpage.this, "All fields Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (pass.equals(repass))
                    {
                        Boolean checkuser=DB.checkusernamegmailpassword(user,gl,pass);

                        if (checkuser ==false)
                        {
                            Boolean insert=DB.insertData(user,pass,gl);
                            if(insert==true)
                            {
                                Toast.makeText(registrationpage.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(getApplicationContext(), loginpage.class);
                                startActivity(intent);
                            }else
                            {
                                Toast.makeText(registrationpage.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(registrationpage.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(registrationpage.this, "Password are not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        ahac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), loginpage.class);
                startActivity(intent);
            }
        });
    }
}