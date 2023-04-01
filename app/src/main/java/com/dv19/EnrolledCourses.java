package com.dv19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EnrolledCourses extends AppCompatActivity {

    public static final String TAG="Enrolled Courses Activity";

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase mDatabase;
    DatabaseReference mDatabaseReference;

    RecyclerView erecview;
    Enrolled_Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrolled_courses);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String uid = user.getUid();
        mDatabaseReference = mDatabase.getReference().child("users").child(uid);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "OnStateChanged : signed in " + user.getUid());
                } else {
                    Log.d(TAG, "OnStateChanged : signed out");
                }

            }
        };
        erecview= findViewById(R.id.cRecview);
        ArrayList<Courses> array = new ArrayList<>();

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

               for(DataSnapshot ds : snapshot.getChildren()){
                   Courses course = ds.getValue(Courses.class);
                   array.add(course);
                   Log.d("child",course.getCoursename());
               }
                adapter= new Enrolled_Adapter(getApplicationContext());
                adapter.setArray(array);
                erecview.setAdapter(adapter);
                erecview.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Log.d("error",error.getMessage());

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