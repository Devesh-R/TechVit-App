package com.dv19;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder>{

    Context context;

    public CoursesAdapter(Context context) {
        this.context = context;
    }

    public void setCourses(ArrayList<Courses> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }

    ArrayList<Courses> courses = new ArrayList<>() ;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.courses_layout,parent,false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.coursename.setText(courses.get(position).getCoursename());
        Glide.with(context).asBitmap().load(courses.get(position).getImglink()).into(holder.img);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,CourseEnrollment.class);
                intent.putExtra("Course",courses.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView card;
        ImageView img;
        TextView coursename;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            img = itemView.findViewById(R.id.img);
            coursename= itemView.findViewById(R.id.coursename);
        }
    }
}
