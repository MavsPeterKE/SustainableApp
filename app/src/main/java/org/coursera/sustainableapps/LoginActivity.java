package org.coursera.sustainableapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class LoginActivity extends AppCompatActivity {
    private Button btLogin;
    private EditText edEmail;
    private EditText edPass;
    private LoginUtil loginUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginUtil = new LoginUtil();
        btLogin = findViewById(R.id.btLogin);
        edEmail = findViewById(R.id.editTextTextEmailAddress);
        edPass = findViewById(R.id.editTextTextPassword);
        AppCenter.start(getApplication(), "4ee19856-3654-4307-8db3-ea445bf2f0f6",
                Analytics.class, Crashes.class);

        btLogin.setOnClickListener(view -> {
              String email = edEmail.getText().toString();
              String pass = edPass.getText().toString();

              if (loginUtil.isPasswordSpaces(pass)){
                  showMessage("The provided password is invalid");
              }else if(!loginUtil.isPasswordLengthValid(pass)){
                  showMessage("The provided password is too short");
              }else if (!loginUtil.isEmailValid(email)){
                  showMessage("Invalid email address");
              }else {
                  showMessage("Login success");
              }
        });
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}