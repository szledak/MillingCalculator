package com.example.sonia.millingcalculator;

import android.text.TextUtils;

/**
 * Created by Sonia on 2015-04-23.
 */
public class TableFeed {
    private double feedPerTooth;
    private double insertNumber;
    private double mainAxisSpindleSpeed;

    public TableFeed() {
    }

    public void setFeedPerTooth(String feedPerTooth) {
        if(TextUtils.isEmpty(feedPerTooth))
            this.feedPerTooth = 0.0;
        else
            this.feedPerTooth = Double.parseDouble(feedPerTooth);
    }

    public void setInsertNumber(String insertNumber) {
        if(TextUtils.isEmpty(insertNumber))
            this.insertNumber = 0.0;
        else
            this.insertNumber = Double.parseDouble(insertNumber);
    }

    public void setMainAxisSpiendleSpeed(String mainAxisSpindleSpeed) {
        if(TextUtils.isEmpty(mainAxisSpindleSpeed))
            this.mainAxisSpindleSpeed = 0.0;
        else
            this.mainAxisSpindleSpeed = Double.parseDouble(mainAxisSpindleSpeed);
    }

    public double roundResult(double result){
        result *= 100;
        result = (double) Math.round(result);
        result /= 100;
        return  result;
    }

    public double calcTableFeed(){
        double result = feedPerTooth * insertNumber * mainAxisSpindleSpeed;
        return roundResult(result);
    }

    public String returnTableFeed(){
        return String.valueOf(calcTableFeed());
    }
}
