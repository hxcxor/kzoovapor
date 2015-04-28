package wmich.edu.team3_kzoovapor;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HouseJuiceDetailActivity extends ActionBarActivity {

    String title;
    String description;
    int image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housedetail);

        TextView tvTitleLabel = (TextView)findViewById(R.id.textViewHJTitle);
        TextView tvDescLabel = (TextView)findViewById(R.id.textViewHJDisc);
        ImageView ivPrImage = (ImageView)findViewById(R.id.imageViewJuice);



        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            title = extras.getString("juiceName");
            tvTitleLabel.setText(title);


            image = extras.getInt("juiceImg");
            ivPrImage.setImageResource(image);

            description = extras.getString("juiceDiscLabel");
            tvDescLabel.setText(description);

        }


    }

}