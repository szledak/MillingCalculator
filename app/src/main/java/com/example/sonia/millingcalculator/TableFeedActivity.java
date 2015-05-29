package com.example.sonia.millingcalculator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class TableFeedActivity extends Activity implements TextWatcher{

    private TableFeed tableFeed;
    private TextView txtResult;
    private EditText edtInsertNumber, edtFeedPerTooth, edtMainAxisSpindleSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_feed);

        initElements();

        tableFeed = new TableFeed();

        addEditListeners();
    }

    public void initElements(){
        edtMainAxisSpindleSpeed = (EditText)findViewById(R.id.editParameter_2);
        edtInsertNumber = (EditText)findViewById(R.id.editParameter_3);
        edtFeedPerTooth = (EditText)findViewById(R.id.editParameter_1);

        txtResult = (TextView)findViewById(R.id.txtResult_2);
    }

    public void addEditListeners(){
        edtFeedPerTooth.addTextChangedListener(this);
        edtInsertNumber.addTextChangedListener(this);
        edtMainAxisSpindleSpeed.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(s.length() != 0){
            tableFeed.setInsertNumber(edtInsertNumber.getText().toString());
            tableFeed.setFeedPerTooth(edtFeedPerTooth.getText().toString());
            tableFeed.setMainAxisSpiendleSpeed(edtMainAxisSpindleSpeed.getText().toString());

            txtResult.setText(tableFeed.returnTableFeed());
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
