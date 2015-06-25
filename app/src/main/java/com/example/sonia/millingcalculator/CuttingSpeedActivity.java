package com.example.sonia.millingcalculator;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class CuttingSpeedActivity extends Activity implements TextWatcher {

    private EditText editParameter1, editParameter2;
    private EditText editParameterN1, editParameterN2;
    private TextView txtResult, txtResultN;
    private RelativeLayout submitLayoutVc, submitLayoutN;
    private RadioGroup radioGroup;
    private RadioButton rdbParameter1, rdbParameter2;

    private CuttingSpeed cuttingSpeedVc;
    private CuttingSpeed cuttingSpeedN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutting_speed);

        initElements();

        cuttingSpeedVc = new CuttingSpeed(this);
        cuttingSpeedN = new CuttingSpeed(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkRadioButton(checkedId);
            }
        });

        setEditListeners();
    }

    public void checkRadioButton(int id) {
        switch (id) {
            case R.id.radioParameter1: {
                submitLayoutVc.setVisibility(View.VISIBLE);
                submitLayoutN.setVisibility(View.GONE);
            }
            break;
            case R.id.radioParameter2: {
                submitLayoutVc.setVisibility(View.GONE);
                submitLayoutN.setVisibility(View.VISIBLE);
            }
            break;
        }
    }

    public void setEditListeners() {
        editParameter1.addTextChangedListener(this);
        editParameter2.addTextChangedListener(this);

        editParameterN1.addTextChangedListener(this);
        editParameterN2.addTextChangedListener(this);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (rdbParameter1.isChecked()) {
            if (s.length() != 0) {
                cuttingSpeedVc.setCuttingDiameter(editParameter1.getText().toString(), rdbParameter2.isChecked());
                cuttingSpeedVc.setMainAxisSpindleSpeed(editParameter2.getText().toString());

                txtResult.setText(cuttingSpeedVc.returnCuttingSpeedVc());
            }
        } else {
            if (s.length() != 0) {

                if(TextUtils.isEmpty(editParameterN2.getText().toString())){
                    editParameterN2.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                }else{
                    cuttingSpeedN.setCuttingDiameter(editParameterN2.getText().toString(), rdbParameter2.isChecked());
                    cuttingSpeedN.setCuttingSpeed(editParameterN1.getText().toString());
                    editParameterN2.getBackground().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_ATOP);

                }

                if(!TextUtils.isEmpty(editParameterN1.getText().toString()) && !TextUtils.isEmpty(editParameterN2.getText().toString()))
                    txtResultN.setText(cuttingSpeedN.returnCuttingSpeedN());
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    public void initElements() {
        submitLayoutVc = (RelativeLayout) findViewById(R.id.submit_layout_vc);
        submitLayoutN = (RelativeLayout) findViewById(R.id.submit_layout_n);
        submitLayoutN.setVisibility(View.GONE);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rdbParameter1 = (RadioButton) findViewById(R.id.radioParameter1);
        rdbParameter2 = (RadioButton) findViewById(R.id.radioParameter2);

        txtResult = (TextView) findViewById(R.id.txtResult_2);
        txtResultN = (TextView) findViewById(R.id.txtResultN_2);

        editParameter1 = (EditText) findViewById(R.id.editParameter_1);
        editParameter2 = (EditText) findViewById(R.id.editParameter_2);

        editParameterN1 = (EditText) findViewById(R.id.editParameterN_1);
        editParameterN2 = (EditText) findViewById(R.id.editParameterN_2);
    }
}
