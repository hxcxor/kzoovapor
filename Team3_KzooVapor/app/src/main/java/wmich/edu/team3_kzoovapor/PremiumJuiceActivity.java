package wmich.edu.team3_kzoovapor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Bryan on 4/27/2015.
 */
public class PremiumJuiceActivity extends ActionBarActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premiumjuice);

        ImageButton buttonSJ = (ImageButton) findViewById(R.id.imageButtonSJ);
        ImageButton buttonBrew = (ImageButton) findViewById(R.id.imageButtonBrew);
        ImageButton buttonIVC = (ImageButton) findViewById(R.id.imageButtonIVC);
        ImageButton buttonRDA = (ImageButton) findViewById(R.id.imageButtonRDA);
        ImageButton buttonHydros = (ImageButton) findViewById(R.id.imageButtonHydros);
        ImageButton buttonNoName = (ImageButton) findViewById(R.id.imageButtonNo);
        ImageButton buttonSeduce = (ImageButton) findViewById(R.id.imageButtonSeduce);
        ImageButton buttonMyst = (ImageButton) findViewById(R.id.imageButtonMys);

    }
        public void onClick(View v){

            if(v.getId() == R.id.imageButtonSJ){
                Intent intent = new Intent(PremiumJuiceActivity.this, SpaceJamActivity.class);
                startActivity(intent);

            }else if(v.getId() == R.id.imageButtonBrew){
                Intent intent = new Intent(PremiumJuiceActivity.this, BrewActivity.class);
                startActivity(intent);

            }else if(v.getId() == R.id.imageButtonIVC){
                Intent intent = new Intent(PremiumJuiceActivity.this, IVCActivity.class);
                startActivity(intent);

            }else if(v.getId() == R.id.imageButtonRDA){
                Intent intent = new Intent(PremiumJuiceActivity.this, RDAActivity.class);
                startActivity(intent);

            }else if(v.getId() == R.id.imageButtonHydros){
                Intent intent = new Intent(PremiumJuiceActivity.this, HydrosActivity.class);
                startActivity(intent);

            }else if(v.getId() == R.id.imageButtonNo){
                Intent intent = new Intent(PremiumJuiceActivity.this, NoNameActivity.class);
                startActivity(intent);
            }else if(v.getId() == R.id.imageButtonSeduce){
                Intent intent = new Intent(PremiumJuiceActivity.this, SeduceActivity.class);
                startActivity(intent);
            }else if(v.getId() == R.id.imageButtonMys){
                Intent intent = new Intent(PremiumJuiceActivity.this, MystiqueActivity.class);
                startActivity(intent);
            }

        }
    }

