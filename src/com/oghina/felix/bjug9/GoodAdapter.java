package com.oghina.felix.bjug9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GoodAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    
    public GoodAdapter(final Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    @Override
    public int getCount() {
        return MainActivity.ITEMS;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View layout;
        if (convertView != null) {
            layout = convertView;
        } else {
            layout = inflater.inflate(R.layout.item, null);
        }
        final TextView tv1 = (TextView) layout.findViewById(R.id.tv1);
        final TextView tv2 = (TextView) layout.findViewById(R.id.tv2);
        
        tv1.setText("GOOD");
        tv2.setText(position + "");
        return layout;
    }

}
