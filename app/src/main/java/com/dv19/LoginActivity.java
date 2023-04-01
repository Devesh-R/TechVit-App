package com.dv19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG="LoginActivity";

    EditText lemail,lpassword;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    MaterialButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lemail = findViewById(R.id.lemailid);
        lpassword=findViewById(R.id.lpassword);
        submit=findViewById(R.id.submit);
        mAuth=FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){

                    Log.d(TAG,"OnStateChanged : Signed in "+ user.getUid() );
                }else{
                    Log.d(TAG,"OnStateChanged : Signed_out" );
                }

            }
        };

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail= lemail.getText().toString().trim();
                String password= lpassword.getText().toString().trim();

                if(mail.equals(""))lemail.setError("Enter your mail id");
                if(password.equals(""))lpassword.setError("Enter your password");
                if(!mail.equals("") && !password.equals("")) {
                    mAuth.signInWithEmailAndPassword(mail, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(LoginActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                    lemail.setText("");
                                    lpassword.setText("");
                                    startActivity(new Intent(LoginActivity.this,CourseActivity.class));

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(LoginActivity.this, "Login Failure", Toast.LENGTH_SHORT).show();

                                }
                            });
                }
                else
                    Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mAuthListener!=null){
            mAuth.removeAuthStateListener(mAuthListener);
        }

    }
}