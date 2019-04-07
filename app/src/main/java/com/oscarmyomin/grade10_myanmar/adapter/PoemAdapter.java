package com.oscarmyomin.grade10_myanmar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.oscarmyomin.grade10_myanmar.R;

import java.util.ArrayList;

public class PoemAdapter extends RecyclerView.Adapter<PoemAdapter.MyViewHolder> {

    ArrayList<String> title;
    ArrayList<String> content;
    Context context;

    public PoemAdapter(Context context, ArrayList<String> title, ArrayList<String> content) {
        this.context = context;
        this.title = title;
        this.content = content;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poem, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // set the data in items
        holder.mtitle.setText(title.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Log.e("Working", title.get(position));
            }
        });

    }


    @Override
    public int getItemCount() {
        return title.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mtitle, mcontent;
        Context context;
        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            mtitle = itemView.findViewById(R.id.title);

        }
    }
}
