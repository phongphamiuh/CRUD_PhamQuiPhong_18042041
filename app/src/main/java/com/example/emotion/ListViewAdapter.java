package com.example.emotion;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    List<Product> list;
    Context context;
    int layout;


    public ListViewAdapter(List<Product> list, Context context, int layout) {
        this.list = list;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TextView idP,name,brand;
        Button edit,save;
        view  = LayoutInflater.from(context).inflate(layout,parent, false);

        idP = view.findViewById(R.id.idP);
        name=view.findViewById(R.id.name);
        brand=view.findViewById(R.id.brand);

        edit = view.findViewById(R.id.button3);

        idP.setText(list.get(position).getId());
        name.setText(list.get(position).getName());
        brand.setText(list.get(position).getBrand());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product =list.get(position);
                Intent intent  = new Intent(context,edit.class);
                intent.putExtra("product",product);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
