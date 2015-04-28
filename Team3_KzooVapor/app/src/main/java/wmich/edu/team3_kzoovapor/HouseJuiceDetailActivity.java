package wmich.edu.team3_kzoovapor;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
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

        TextView tvTitleLabel = (TextView)findViewById(R.id.tvTitleLabel);
        TextView tvDescLabel = (TextView)findViewById(R.id.tvDescLabel);
        ImageView ivPrImage = (ImageView)findViewById(R.id.ivPrvImage);
        Button btn = (Button)findViewById(R.id.button1);


        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            title = extras.getString("province");
            tvTitleLabel.setText(title);
            btn.setText("More about "+ title);


            image = extras.getInt("prvImg");
            ivPrImage.setImageResource(image);

            description = extras.getString("provincedesclabel");
            tvDescLabel.setText(description);

        }


    }

}