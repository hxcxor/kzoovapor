package wmich.edu.team3_kzoovapor;/*


*************************************
* Programmers: Bryan Minton, Jonathan Trapane,
*              Anson Richardson
* Final Project: Kalamazoo Vapor App
* CIS 4700: Mobile Commerce Development
* Spring 2015
* Due date: 4/28/15
* Date completed: 4/28/15
*************************************
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

// juiceadapter class
public class JuiceAdapter extends BaseAdapter
{
    LayoutInflater mInflater;

    public JuiceAdapter(Context mContext)
    {
        mInflater = (LayoutInflater) mContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final ViewHolder vh;
        vh= new ViewHolder();

        if(convertView==null )
        {
            convertView=mInflater.inflate(R.layout.rowlayout, parent,false);

            vh.tv2= (TextView)convertView.findViewById(R.id.manufacturerTextView);
            vh.tv1= (TextView)convertView.findViewById(R.id.nameTextView);


        }
        else
        {
            convertView.setTag(vh);
        }
        vh.tv1.setText("my text");
        vh.tv2.setText("Postion = "+position);
        return convertView;
    }

    class ViewHolder
    {
        TextView tv1,tv2;
    }
}
