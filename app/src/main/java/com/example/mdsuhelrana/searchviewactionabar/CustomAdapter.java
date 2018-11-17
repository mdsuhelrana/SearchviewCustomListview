package com.example.mdsuhelrana.searchviewactionabar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Md Suhel Rana on 10/29/2018.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<String> list;
    ArrayList<String>arrayList;
    LayoutInflater inflater;

    public CustomAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<String>();
        this.arrayList.addAll(list);
    }
    public class ViewHolder{
        TextView tvname;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row_model, null);

            //locate the views in row.xml
            holder.tvname = view.findViewById(R.id.tv_id);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.tvname.setText(list.get(i));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //you can add your action handling
                Toast.makeText(context, "item is "+list.get(i), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        list.clear();
        if (charText.length()==0){
            list.addAll(arrayList);
        }
        else {
            for (String strlist : arrayList){
                if (strlist.toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    list.add(strlist);
                }
            }
        }
        notifyDataSetChanged();
    }
}
