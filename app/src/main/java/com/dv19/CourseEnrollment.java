package com.dv19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CourseEnrollment extends AppCompatActivity {

    public static final String TAG="Course Enrollement activity";

    TextView shortdes,longdes,cname;
    ImageView cimg;
    MaterialButton enroll;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase mDatabase;
    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_enrollment);

        Courses course = getIntent().getParcelableExtra("Course");
        shortdes=findViewById(R.id.shortdesc);
        longdes=findViewById(R.id.longdesc);
        cname=findViewById(R.id.cname);
        cimg=findViewById(R.id.courseimg);
        enroll =findViewById(R.id.enroll);

        mAuth= FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference();

        cname.setText(course.getCoursename());
        longdes.setText(course.getLongdesc());
        shortdes.setText(course.getShortdesc());
        Glide.with(this).asBitmap().load(course.getImglink()).into(cimg);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    Log.d(TAG,"OnStateChanged : signed in "+ user.getUid() );
                }else{
                    Log.d(TAG,"OnStateChanged : =signed out" );
                }

            }
        };

        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = mAuth.getCurrentUser();
                mDatabaseReference.child("users").child(user.getUid()).child(course.getCoursename()).setValue(course);
                Intent intent = new Intent(getApplicationContext(),EnrolledCourses.class);
                startActivity(intent);
                Toast.makeText(CourseEnrollment.this, "Enrolled "+course.getCoursename()+" Successfully", Toast.LENGTH_SHORT).show();
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