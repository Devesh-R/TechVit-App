package com.dv19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class Enrolled_Adapter extends RecyclerView.Adapter<Enrolled_Adapter.ViewHolderE> {


   Context context;
   ArrayList<Courses> array =new ArrayList<>();

    public void setArray(ArrayList<Courses> array) {
        this.array = array;
        notifyDataSetChanged();
    }

    public Enrolled_Adapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderE onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.enrolled_model,parent,false);
        return new ViewHolderE(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderE holder, int position) {

        holder.ename.setText(array.get(position).getCoursename());
        Glide.with(context).asBitmap().load(array.get(position).getImglink()).into(holder.eimg);

    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class ViewHolderE extends RecyclerView.ViewHolder{

        ImageView eimg;
        TextView ename ;
        MaterialCardView ecard;

        public ViewHolderE(@NonNull View itemView) {

            super(itemView);

            eimg=itemView.findViewById(R.id.enrolled_img);
            ename = itemView.findViewById(R.id.enrolled_coursename);
            ecard = itemView.findViewById(R.id.enrolled_model_card);

        }
    }
}
