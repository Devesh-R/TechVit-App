package com.dv19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="SignUp Activity";
    EditText email,password,name,number;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase mDatabase;
    DatabaseReference mDatabaseReference;
    MaterialButton submit,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.emailid);
        password=findViewById(R.id.password);
        submit=findViewById(R.id.Ssubmit);
        mAuth= FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference();
        name = findViewById(R.id.name);
        number= findViewById(R.id.number);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    Log.d(TAG,"OnStateChanged : Created "+ user.getUid() );
                }else{
                    Log.d(TAG,"OnStateChanged : creation failure" );

                }

            }
        };

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail= email.getText().toString().trim();
                String pass  = password.getText().toString().trim();
                String nam = name.getText().toString().trim();
                String num = number.getText().toString().trim();
                if(nam.equals(""))name.setError("Enter your name");
                if(num.equals(""))number.setError("Enter your number");
                if(mail.equals(""))email.setError("Enter your mail id");
                if(pass.equals(""))password.setError("Enter your password");
                if(!mail.contains("@") || !mail.contains("."))email.setError("Enter a valid Email Address");
                if(pass.length()<6)password.setError("Password should be atleast 6 characters");
                if(!mail.equals("") && !pass.equals("")) {
                    mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(MainActivity.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
                                email.setText("");
                                password.setText("");
                                name.setText("");
                                number.setText("");
                            }else{
                                Toast.makeText(MainActivity.this, "Signup Failure", Toast.LENGTH_SHORT).show();
                            }

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