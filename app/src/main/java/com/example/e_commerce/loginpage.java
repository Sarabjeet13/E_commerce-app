package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerce.MainActivity;
import com.example.e_commerce.R;
import com.example.e_commerce.registrationpage;

public class loginpage extends AppCompatActivity {
    EditText name, gmail, password;
    Button login;
    TextView newuser;
   DBhelper DB;
   SharedPreferences sharedPreferences;
   private static  final String SHARED_PREF_NAME="mypref";
   private static  final String KEY_NAME="name";
   private static  final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        name = findViewById(R.id.user);
        gmail = findViewById(R.id.gmaile);
        password = findViewById(R.id.passworde);
        login = findViewById(R.id.button2);
        newuser = findViewById(R.id.textView2);
        DB = new com.example.e_commerce.DBhelper(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString();
                String userGmail = gmail.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(userGmail) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(loginpage.this, "All fields required", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkUsernameGmailPass = DB.checkusernamegmailpassword(user, userGmail, pass);
                    if (checkUsernameGmailPass) {



                        Intent intent = new Intent(loginpage.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(loginpage.this, "Login successful", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(loginpage.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpage.this, registrationpage.class);
                startActivity(intent);
            }
        });
    }
}
