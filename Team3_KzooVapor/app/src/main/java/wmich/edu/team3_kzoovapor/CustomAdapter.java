package wmich.edu.team3_kzoovapor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        //imageId=arrayImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView textViewHolder;
        //ImageView img;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.program_list, null);
        holder.textViewHolder =(TextView) rowView.findViewById(R.id.textView1);
        //holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.textViewHolder.setText(result[position]);
        //holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switch(position){



                    case 0:
                        Intent intent = new Intent(context, JuiceListActivity.class);
                        context.startActivity(intent);
                        break;

                    case 1:
                        Intent intent1 = new Intent(context, PromotionsActivity.class);
                        context.startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(context, AdvancedUsersActivity.class);
                        context.startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(context, MoneySaverActivity.class);
                        context.startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(context, InformationActivity.class);
                        context.startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new Intent(context, LocationsActivity.class);
                        context.startActivity(intent5);
                        break;

                    case 6:
                        Intent intent6 = new Intent(context, WhatDidIGetActivity.class);
                        context.startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(context, JuiceTourActivity.class);
                        context.startActivity(intent7);
                        break;

                }
            }
        });
        return rowView;
    }

}
