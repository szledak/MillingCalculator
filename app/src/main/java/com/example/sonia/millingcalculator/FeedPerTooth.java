package com.example.sonia.millingcalculator;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Sonia on 2015-04-23.
 */
public class FeedPerTooth {
    private double insertNumber;
    private double tableFeed;
    private double mainAxisSpindleSpeed;
    private Context context;

    public FeedPerTooth(Context context) {
        this.context = context;
    }

    public void setMainAxisSpindleSpeed(String mainAxisSpindleSpeed) {
        if(mainAxisSpindleSpeed.equals("0"))
            Toast.makeText(context, context.getResources().getString(R.string.divide), Toast.LENGTH_LONG).show();
        else
            this.mainAxisSpindleSpeed = Double.parseDouble(mainAxisSpindleSpeed);
    }

    public void setTableFeed(String tableFeed) {
        if(TextUtils.isEmpty(tableFeed))
            this.tableFeed = 0.0;
        else
            this.tableFeed = Double.parseDouble(tableFeed);
    }

    public void setInsertNumber(String insertNumber) {
        if(insertNumber.equals("0"))
            Toast.makeText(context, context.getResources().getString(R.string.divide), Toast.LENGTH_LONG).show();
        else
            this.insertNumber = Double.parseDouble(insertNumber);
    }

    public double calcFeedPerTooth(){
        double result = 0;
        if(insertNumber !=0 || mainAxisSpindleSpeed != 0)
            result = tableFeed / (insertNumber * mainAxisSpindleSpeed);
        return roundResult(result);
    }

    public String returnFeedPerTooth(){
        return String.valueOf(calcFeedPerTooth());
    }

    public double roundResult(double result){
        result *= 100;
        result = (double) Math.round(result);
        result /= 100;
        return  result;
    }
}
