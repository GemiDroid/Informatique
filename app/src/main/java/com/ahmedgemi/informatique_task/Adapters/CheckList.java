package com.ahmedgemi.informatique_task.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmedgemi.informatique_task.Holder.CheckHolder;
import com.ahmedgemi.informatique_task.R;

import java.util.List;

/**
 * Created by Ahmed Gemi on 21/09/2016.
 */
public class CheckList  extends RecyclerView.Adapter<CheckHolder>{

    List<String> check_name_list;
    Context context;

    public CheckList(List<String> check_name_list, Context context) {
        this.check_name_list = check_name_list;
        this.context = context;
    }


    @Override
    public CheckHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.content_model,null);
        CheckHolder holder=new CheckHolder(v);
        return  holder;

    }

    @Override
    public void onBindViewHolder(CheckHolder holder, int position) {

        String checkName=check_name_list.get(position);

        // here will populate datafrom String checkName and set it to TextView called check_name

    }

    @Override
    public int getItemCount() {
        return check_name_list.size();
    }
}
