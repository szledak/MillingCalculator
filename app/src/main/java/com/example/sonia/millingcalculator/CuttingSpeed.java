package com.example.sonia.millingcalculator;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Sonia on 2015-04-21.
 */
public class CuttingSpeed {

    private double cuttingDiameter;
    private double mainAxisSpindleSpeed;
    private double cuttingSpeed;
    private Context context;

    public CuttingSpeed(Context context) {
        this.context = context;
    }

    public double calcCuttingSpeedVc(){
        double result = cuttingDiameter * Math.PI * mainAxisSpindleSpeed / 1000;
        return roundResult(result);
    }

    public double calcCuttingSpeedN(){
        double result;
        result = 0;
        if(cuttingDiameter != 0)
            result = (cuttingSpeed * 1000) / (Math.PI * cuttingDiameter);
        return roundResult(result);
    }

    public String returnCuttingSpeedN(){
        return String.valueOf(calcCuttingSpeedN());
    }

    public String returnCuttingSpeedVc(){
        return String.valueOf(calcCuttingSpeedVc());
    }

    public double roundResult(double result){
        result *= 100;
        result = (double) Math.round(result);
        result /= 100;
        return  result;
    }

    public void setCuttingDiameter(String cuttingDiameter, Boolean radio) {
        if(radio){
            if(TextUtils.isEmpty(cuttingDiameter) || cuttingDiameter.equals("0.0") || cuttingDiameter.equals("0")){
                Toast.makeText(context, context.getResources().getString(R.string.divide), Toast.LENGTH_LONG).show();
            }
            else
                this.cuttingDiameter = Double.parseDouble(cuttingDiameter);
        }
        else{
            if(TextUtils.isEmpty(cuttingDiameter))
                this.mainAxisSpindleSpeed = 0.0;
            else
                this.cuttingDiameter = Double.parseDouble(cuttingDiameter);
        }
    }

    public void setMainAxisSpindleSpeed(String mainAxisSpindleSpeed) {
        if(TextUtils.isEmpty(mainAxisSpindleSpeed))
            this.mainAxisSpindleSpeed = 0.0;
        else
            this.mainAxisSpindleSpeed = Double.parseDouble(mainAxisSpindleSpeed);
    }

    public void setCuttingSpeed(String cuttingSpeed) {
        if(TextUtils.isEmpty(cuttingSpeed))
            this.cuttingSpeed = 0.0;
        else
            this.cuttingSpeed = Double.parseDouble(cuttingSpeed);
    }
}
