package com.ahmedgemi.informatique_task.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ahmedgemi.informatique_task.R;

/**
 * Created by Ahmed Gemi on 21/09/2016.
 */
public class CheckHolder extends RecyclerView.ViewHolder {

    TextView check_name;
    CheckBox check_box;

    public CheckHolder(View itemView) {
        super(itemView);

        check_name = (TextView) itemView.findViewById(R.id.check_name);
        check_box = (CheckBox) itemView.findViewById(R.id.chech_list);

    }
}
