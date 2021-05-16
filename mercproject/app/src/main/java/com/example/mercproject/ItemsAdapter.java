package com.example.mercproject;

import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
//連接的是content_amin.xml
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{

    String data1[];
    int images[];
    Context context;

    public ItemsAdapter(Context ct,String s1[],int img[]) {
       context= ct;
       data1=s1;
       images=img;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.myText1);
            myText2 = itemView.findViewById(R.id.myText2);
            myImage = itemView.findViewById(R.id.myImageView);

            // 點擊項目時
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent ( context , SecondActivity.class );
                    intent.putExtra ( "data1" , data1[getAdapterPosition()] );
                    intent.putExtra ( "data2" , data2[getAdapterPosition()] );
                    intent.putExtra ( "myImage" , images[getAdapterPosition()] );
                    context.startActivity ( intent );
                }
            });
        }
    }
}
