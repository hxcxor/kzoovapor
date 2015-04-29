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
        // minflater to inflate layout - passes mcontext
        mInflater = (LayoutInflater) mContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }



    // get count
    @Override
    public int getCount() {
        return 30;
    }

    // get item position
    @Override
    public Object getItem(int position) {
        return position;
    }

    // get item id
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // getview for custom adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        // viewholder vh
        final ViewHolder vh;
        vh= new ViewHolder();

        // if no convertview
        if(convertView==null )
        {
            // inflate
            convertView=mInflater.inflate(R.layout.rowlayout, parent,false);

            // tie variables to textviews
            vh.tv2= (TextView)convertView.findViewById(R.id.manufacturerTextView);
            vh.tv1= (TextView)convertView.findViewById(R.id.nameTextView);


        }
        else
        // else set text to defaults
        {
            convertView.setTag(vh);
        }
        vh.tv1.setText("my text");
        vh.tv2.setText("Postion = "+position);
        return convertView;
    }

    // viewholder variable textviews 1 and 2
    class ViewHolder
    {
        TextView tv1,tv2;
    }
}
