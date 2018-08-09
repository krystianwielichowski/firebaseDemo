package com.example.firebasedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {
    private ArrayList<Movie> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtTitle;
    }



    public MovieAdapter(ArrayList<Movie> data, Context context) {
        super(context, R.layout.row, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row, parent, false);
            viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.row);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtTitle.setText(dataModel.getTitle());
        // Return the completed view to render on screen
        return convertView;
    }
}

