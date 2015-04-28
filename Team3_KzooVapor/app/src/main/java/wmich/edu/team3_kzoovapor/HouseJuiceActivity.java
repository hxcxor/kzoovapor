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
            "Apple Jax Tobacco","Baja Joe","Beast","Belgian Waffle","Blackberry","Black Licorice",
            "Blackspice Tobacco","Blueberry","Blueberry Cinna Crumble","Blueberry Custard Tobacco",
            "Blueberry Lemonade","Bomb Pop","Brass Monkey Tobacco","Butter Cream Cupcake","Buttery Nipple",
            "Candy Cane","Candy Corn","Captain Jack","Caramel Apple Tobacco","Caramel Delight",
            "Caramel Tobacco","Checkmate","Cherry Cola","Cherry Tobacco","Cherry Vanilla Twist",
            "Chocolate Covered Cherries","Clove Tobacco","Cola Cola","Coo Coo Fruit","Cool Shots","Cybermint",
            "Dark Side","Dingleberry Tobacco","Firefly","Granny's Apple Pie","Grape Cool Aid","Grasshopper",
            "Green Apple","Gummi Bear","Hellfire","Java Scotch","Juicy Peach","KaPow","KaZooka Bubble Gum",
            "Key Lime Pie", "Killah Vanilla","KVS 454","KVS 555","KVS Coffee","KVS Menthol Tobacco",
            "KVS Ry4","KVS Smooth","KVS Tobacco","Laffy Laffy Banana","Lemonade","Mad Hatter",
            "Mellow Dew","Menthol Ice","Mitten Juice","Monster Blood","OMFG Tobacco","Orange Whip",
            "Paradise Punch","Pear","Pina Colada","Pineapple","Pistacio Almond Ice Cream",
            "Raspberry","Raspberry Lemonade","Raspberry Vanilla Twist","Root Beer Float","S'Mores",
            "Strawberry","Strawberry Colada","Strawberry Lemonade","Strawberry Kiwi","StrawNana","StrawPeach",
            "Swamp Water","Sweet Tartz","Tango Mango","Tiger Stripe Gum","Turkish Blend","Vanilla Mint",
            "Vanilla Tobacco","Very Cherry","Voodoo","Wacky Watermelon","Wild West Tobacco",
            "WTF Menthol Tobacco","Yellow Snow"





    };
    // Images belonging to the ListView items
    int[] myImageList = new int[]{
            R.drawable.applejax,R.drawable.bajajoe,R.drawable.beast,R.drawable.belginwaffle,R.drawable.blackberry,
            R.drawable.blacklicorice,R.drawable.blackspice,R.drawable.blueberry,R.drawable.blucinacrum,
            R.drawable.blucustard,R.drawable.blulemon,R.drawable.bombpop,R.drawable.brassmonkey,R.drawable.buttercream,
            R.drawable.butterynipple,R.drawable.candycane,R.drawable.candycorn,R.drawable.capjack,
            R.drawable.caramelapple,R.drawable.carameldelight,R.drawable.carameltobacco,R.drawable.checkmate,
            R.drawable.cherrycola,R.drawable.cherrytobacco,R.drawable.cherryvanilla,R.drawable.chocolatecc,
            R.drawable.clove,R.drawable.colacola,R.drawable.coocoo,R.drawable.coolshots,R.drawable.cybermint,
            R.drawable.darkside,R.drawable.dingleberry,R.drawable.firefly,R.drawable.grannysapple,R.drawable.grapecool,
            R.drawable.grasshopper,R.drawable.greenapple,R.drawable.gummibear,R.drawable.hellfire,
            R.drawable.javascotch,R.drawable.juicypeach,R.drawable.kapow,R.drawable.kazooka,
            R.drawable.keylime,R.drawable.killahvanilla,R.drawable.kvs454,R.drawable.kvs555,R.drawable.kvscoffee,
            R.drawable.kvsmentholtob,R.drawable.kvsry4,R.drawable.kvssmooth,R.drawable.kvstobacco,
            R.drawable.laffylaffy,R.drawable.lemonade,R.drawable.madhatter,R.drawable.mellowdew,
            R.drawable.mentholice,R.drawable.mittenjuice,R.drawable.monsterblood,R.drawable.omfgtobacco,
            R.drawable.orangewhip,R.drawable.paradisepunch,R.drawable.pear,R.drawable.pinacolada,
            R.drawable.pineapple,R.drawable.pistacioalmond,R.drawable.raspberry,R.drawable.raspberrylemon,
            R.drawable.raspberryvanilla,R.drawable.rootbeer,R.drawable.smores,R.drawable.strawberry,
            R.drawable.strawberrycolada,R.drawable.strawberrykiwi,R.drawable.strawberrylemon,R.drawable.strawnana,
            R.drawable.strawpeach,R.drawable.swampwater,R.drawable.sweettartz,R.drawable.tangomango,
            R.drawable.tigerstripe,R.drawable.turkishblend,R.drawable.vanillamint,R.drawable.vanillatobacco,
            R.drawable.verycherry,R.drawable.voodoo,R.drawable.wackywatermelon,R.drawable.wildwest,
            R.drawable.wtfmenthol,R.drawable.yellowsnow



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
                String juiceName = juices[position - 1];
                final int juiceImg = myImageList[position - 1];

                //we retrieve the description of the juices from an array defined in arrays.xml
                String[] juiceDiscription = getResources().getStringArray(R.array.houseJuiceArray);
                final String juiceDiscLabel = juiceDiscription[position - 1];



                Intent intent = new Intent(getApplicationContext(), HouseJuiceDetailActivity.class);
                intent.putExtra("juiceName", juiceName);
                intent.putExtra("juiceDiscLabel", juiceDiscLabel);
                intent.putExtra("juiceImg", juiceImg);


                startActivity(intent);


            }


        });

    }
}

