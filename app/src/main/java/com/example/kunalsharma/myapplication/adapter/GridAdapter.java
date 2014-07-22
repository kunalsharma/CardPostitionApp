package com.example.kunalsharma.myapplication.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.kunalsharma.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Kunal.Sharma on 7/22/2014.
 */

public class GridAdapter extends BaseAdapter {

    private Context mContext;
   ArrayList<String> arryCards = new ArrayList<String>();

    public GridAdapter(Context c,ArrayList<String> arryCards) {
        mContext = c;
        this.arryCards = arryCards;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arryCards.size();
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.card, null);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);

            String name = arryCards.get(position);
            int id = mContext.getResources().getIdentifier(name, "drawable",mContext.getPackageName());
            Drawable drawable = mContext.getResources().getDrawable(id);
            imageView.setImageDrawable(drawable);

//            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}