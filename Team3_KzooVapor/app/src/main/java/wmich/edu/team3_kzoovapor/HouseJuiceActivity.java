package wmich.edu.team3_kzoovapor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Bryan on 4/27/2015.
 */
public class HouseJuiceActivity extends ActionBarActivity {
    // ListView items
    String[] juices = new String[]{
            "Apple Jax Tobacco",
            "Baja Joe",
            "Beast",

    };
    // Images belonging to the ListView items
    int[] myImageList = new int[]{

    };



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housejuice);


        ListView houseJuiceListView = (ListView)findViewById(R.id.listViewHouse);

        //add header to listview
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.listheader, houseJuiceListView, false);
        houseJuiceListView.addHeaderView(header, null, false);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, juices);
        houseJuiceListView.setAdapter(adapter);
        houseJuiceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

                //we use the items of the listview as title of the next activity
                String province = juices[position - 1];
                //final int prvImg = myImageList[position - 1];

                //we retrieve the description of the juices from an array defined in arrays.xml
                String[] provincedescription = getResources().getStringArray(R.array.houseJuiceArray);
                final String provincedesclabel = provincedescription[position - 1];



                Intent intent = new Intent(getApplicationContext(), HouseJuiceDetailActivity.class);
                intent.putExtra("province", province);
                intent.putExtra("provincedesclabel", provincedesclabel);
                //intent.putExtra("prvImg", prvImg);


                startActivity(intent);


            }


        });

    }
}

