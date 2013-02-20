package com.oghina.felix.bjug9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TwoToneAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    
    public TwoToneAdapter(final Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    private static class ViewTag {
        final TextView tv1;
        final TextView tv2;
        
        public ViewTag(View layout) {
            tv1 = (TextView) layout.findViewById(R.id.tv1);
            tv2 = (TextView) layout.findViewById(R.id.tv2);
        }
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
    public int getViewTypeCount() {
        return 2;
    }
    
    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewTag tag;
        
        if (convertView != null) {
            tag = (ViewTag) convertView.getTag();
        } else {
            final int layout = position % 2 == 0 ? R.layout.item : R.layout.item_right;
            convertView = inflater.inflate(layout, null);
            tag = new ViewTag(convertView);
            convertView.setTag(tag);
        }
        
        tag.tv1.setText("AWESOME");
        tag.tv2.setText(position + "");
        return convertView;
    }

}
