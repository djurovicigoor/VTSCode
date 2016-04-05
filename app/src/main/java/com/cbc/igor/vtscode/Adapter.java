package com.cbc.igor.vtscode;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Igor on 11/6/2015.
 */
public class Adapter extends BaseAdapter {
    private Context context;
    String[] tagovi;
    String[] tagoviopis;

    public Adapter(Context context, int niz, int niz1){
        this.context=context;
        tagovi = context.getResources().getStringArray(niz1);
        tagoviopis = context.getResources().getStringArray(niz);
    }
    @Override
    public int getCount() {

        return tagovi.length;
    }

    @Override
    public Object getItem(int position) {
        return tagovi[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_row, parent, false);

        TextView TitleTextView1 = (TextView) row.findViewById(R.id.textView1);
        TextView DescriptionTextView = (TextView) row.findViewById(R.id.textView2);

        TitleTextView1.setText(tagovi[position]);
        DescriptionTextView.setText(tagoviopis[position]);

        return row;
    }
}
