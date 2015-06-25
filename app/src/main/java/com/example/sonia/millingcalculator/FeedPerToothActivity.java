package com.example.sonia.millingcalculator;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class FeedPerToothActivity extends Activity implements TextWatcher{

    EditText edtMainAxisSpindleSpeed, edtInsertNumber, edtTableFeed;
    TextView txtResult;
    FeedPerTooth feedPerTooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_per_tooth);

        initElements();

        feedPerTooth = new FeedPerTooth(this);

        setEditListeners();
    }

    public void initElements(){
        edtMainAxisSpindleSpeed = (EditText)findViewById(R.id.editParameter_2);
        edtInsertNumber = (EditText)findViewById(R.id.editParameter_3);
        edtTableFeed = (EditText)findViewById(R.id.editParameter_1);

        txtResult = (TextView)findViewById(R.id.txtResult_2);
    }

    public void setEditListeners(){
        edtInsertNumber.addTextChangedListener(this);
        edtTableFeed.addTextChangedListener(this);
        edtMainAxisSpindleSpeed.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(s.length() != 0){
            String strMAS = edtMainAxisSpindleSpeed.getText().toString();
            String strIN = edtInsertNumber.getText().toString();

            if(TextUtils.isEmpty(strMAS) || TextUtils.isEmpty(strIN)){
                edtMainAxisSpindleSpeed.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                edtInsertNumber.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            }
            else
            {
                feedPerTooth.setInsertNumber(edtInsertNumber.getText().toString());
                feedPerTooth.setMainAxisSpindleSpeed(edtMainAxisSpindleSpeed.getText().toString());
                feedPerTooth.setTableFeed(edtTableFeed.getText().toString());
                txtResult.setText(feedPerTooth.returnFeedPerTooth());
                edtMainAxisSpindleSpeed.getBackground().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_ATOP);
                edtInsertNumber.getBackground().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_ATOP);
            }


           // if(!TextUtils.isEmpty(edtInsertNumber.getText().toString()) && !TextUtils.isEmpty(edtMainAxisSpindleSpeed.getText().toString()))
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
