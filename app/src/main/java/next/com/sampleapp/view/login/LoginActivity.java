package next.com.sampleapp.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import next.com.sampleapp.R;
import next.com.sampleapp.database.DatabaseClient;
import next.com.sampleapp.database.dao.UserDao;
import next.com.sampleapp.database.model.UserTable;
import next.com.sampleapp.view.holiday.HolidayActivity;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutUsername, textInputLayoutPassword, textInputLayout1, textInputLayout3;
    EditText eTxtVUsername, eTxtVPassword, eTxtV_username1, eTxtV_password1;
    Button btnSignin, btnRegistration;

    private FirebaseAuth mAuthLogin, mAuth1Registration;

    DatabaseClient databaseClient;

    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //databaseClient = DatabaseClient.getInstance(LoginActivity.this);

        getViewCasting();
    }

    public void getViewCasting(){

        eTxtVUsername = findViewById(R.id.eTxtV_username);
        eTxtVPassword = findViewById(R.id.eTxtV_password);
        textInputLayoutUsername = findViewById(R.id.textInputLayout);
        textInputLayoutPassword = findViewById(R.id.textInputLayout2);
        btnSignin = findViewById(R.id.btn_signin);
        eTxtV_username1 = findViewById(R.id.eTxtV_username1);
        eTxtV_password1 = findViewById(R.id.eTxtV_password1);
        textInputLayout1 = findViewById(R.id.textInputLayout1);
        textInputLayout3 = findViewById(R.id.textInputLayout3);
        btnRegistration = findViewById(R.id.btn_registration);

        // Initialize Firebase Auth
        mAuthLogin = FirebaseAuth.getInstance();
        mAuth1Registration = FirebaseAuth.getInstance();

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validation()){

                    firebaseLogin(eTxtVUsername.getText().toString(), eTxtVPassword.getText().toString());

                }

            }
        });

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation1()){

                    firebaseRegistration(eTxtV_username1.getText().toString(), eTxtV_password1.getText().toString());
                    userDao = databaseClient.getInstance(LoginActivity.this).getAppDatabase().userDao();
                    UserTable userTable = new UserTable();
                    userTable.setName(eTxtV_username1.getText().toString());
                    userTable.setEmail(eTxtV_password1.getText().toString());
                    userDao.insertAll(userTable);

                    for(int i=0; i<userDao.getAll().size(); i++) {
                        System.out.println("bnnnnnnnnnnnnnv ------- " + userDao.getAll().get(i).getName() + " ----------- " + userDao.getAll().get(i).getName());
                    }
                }
            }
        });
    }

    public void firebaseLogin(String email, String password) {

        mAuthLogin.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, HolidayActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void firebaseRegistration(String email, String password) {

        mAuth1Registration.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Registration failed! Please try again later", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public boolean validation(){

        boolean boolean_flag1, boolean_flag2;

        if(eTxtVUsername.getText().toString().length() == 0){
            textInputLayoutUsername.setError("Please enter the username");
            boolean_flag1 = false;
        }else {
            textInputLayoutUsername.setError("");
            boolean_flag1 = true;
        }

        if(eTxtVPassword.getText().toString().length() == 0){
            textInputLayoutPassword.setError("Please enter the password");
            boolean_flag2 = false;
        }else {
            textInputLayoutPassword.setError("");
            boolean_flag2 = true;
        }

        return boolean_flag1 && boolean_flag2;
    }

    public boolean validation1(){

        boolean boolean_flag1, boolean_flag2;

        if(eTxtV_username1.getText().toString().length() == 0){
            textInputLayout1.setError("Please enter the username");
            boolean_flag1 = false;
        }else {
            textInputLayout1.setError("");
            boolean_flag1 = true;
        }

        if(eTxtV_password1.getText().toString().length() == 0){
            textInputLayout3.setError("Please enter the password");
            boolean_flag2 = false;
        }else {
            textInputLayout3.setError("");
            boolean_flag2 = true;
        }

        return boolean_flag1 && boolean_flag2;
    }

}
