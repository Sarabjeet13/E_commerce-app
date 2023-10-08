package com.example.e_commerce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{

    ArrayList<datamodel>dataholder;

    public myadapter(ArrayList<datamodel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_raw_design,parent,false);
        return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.img.setImageResource(dataholder.get(position).getImage());
        holder.rate.setText(dataholder.get(position).getImagerate());
        holder.name.setText(dataholder.get(position).getImagename());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class  myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView rate,name;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.itemimage);
            rate=itemView.findViewById(R.id.itemrate);
            name=itemView.findViewById(R.id.itemname);
        }
    }

}
