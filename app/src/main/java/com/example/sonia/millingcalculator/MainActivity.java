package com.example.sonia.millingcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    Button btnCuttingSpeed, btnTableFeed, btnFeedPerTooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCuttingSpeed = (Button)findViewById(R.id.btnCuttingSpeed);
        btnFeedPerTooth = (Button)findViewById(R.id.btnFeedPerTooth);
        btnTableFeed = (Button)findViewById(R.id.btnTableFeed);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.btnCuttingSpeed:
                        buttonOnClick(CuttingSpeedActivity.class);
                        break;
                    case R.id.btnFeedPerTooth:
                        buttonOnClick(FeedPerToothActivity.class);
                        break;
                    case R.id.btnTableFeed:
                        buttonOnClick(TableFeedActivity.class);
                        break;
                }
            }
        };

        btnCuttingSpeed.setOnClickListener(onClickListener);
        btnFeedPerTooth.setOnClickListener(onClickListener);
        btnTableFeed.setOnClickListener(onClickListener);


    }

    public void buttonOnClick(Class c){
        Intent intent = new Intent(getApplicationContext(), c);
        startActivity(intent);
    }
}
