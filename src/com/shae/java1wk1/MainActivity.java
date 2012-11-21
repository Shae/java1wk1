package com.shae.java1wk1;

import java.io.Console;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	// global values
	LinearLayout LL;
	LinearLayout.LayoutParams LP;
	EditText et;
	TextView result;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // setting up 
        LL = new LinearLayout(this);
        LL.setOrientation(LinearLayout.VERTICAL);
        LP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LL.setLayoutParams(LP);
        
        TextView tv = new TextView(this);
        tv.setText("Conversion Table from Gigabytes!");
        
        LL.addView(tv);
        
        setContentView(LL);
        
        et = new EditText(this);
        et.setHint("Enter Gigabytes");
        
        Button b = new Button(this);
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Checking to see if the UIText field is empty or not
				if(et.getText().toString().compareTo("") == 1)   // Testing to see if "et" is == to Empty string.  1 means NOT the same (not blank)
				{
				Log.i("TextField", "HAS DATA");

				
				// telling values where to find the data in Resources 
				int bits = getResources().getInteger(R.integer.bits);
				int bytes = getResources().getInteger(R.integer.bytes);
				int kilobits = getResources().getInteger(R.integer.kilobits);
				int kilobytes = getResources().getInteger(R.integer.kilobytes);
				int megabits = getResources().getInteger(R.integer.megabits);
				int megabytes = getResources().getInteger(R.integer.megabytes);
				int gigabits = getResources().getInteger(R.integer.gigabits);
				int gigabytes = getResources().getInteger(R.integer.gigabytes);
				
				// Parsing the UIString entry into a number
				int entry = Integer.parseInt(et.getText().toString());
				 
				
				// Setting values for equations
				//long numBits = (bits * 1000000) * entry;
				long numBits = (long)((Math.pow(10,9) * bits) * entry);
				long numBytes = (long)((Math.pow(10,9) * bytes) * entry);
				int numKilobits = kilobits * entry;
				int numKilobytes = kilobytes * entry;
				int numMegabits = megabits * entry;
				int numMegabytes = megabytes * entry;
				int numGigabits = gigabits * entry;
				int numGigabytes = gigabytes * entry;
				double numTerabytes = (double)(0.001 * gigabytes) * entry;
				double numPetabytes = (double)(0.000001 * gigabytes) * entry;
				
				// Setting a results view
				result.setText("Bits: " + numBits + "\r\n" + 
						"Bytes: " + numBytes + "\r\n" +
						"Kilobits: " + numKilobits + "\r\n" +
						"Kilobytes: " + numKilobytes + "\r\n" +
						"Megabits: " + numMegabits + "\r\n" +
						"Megabytes: " + numMegabytes + "\r\n" +
						"Gigabits: " + numGigabits + "\r\n" +
						"Gigabytes: " + numGigabytes + "\r\n" +
						"Terabytes: " + numTerabytes + "\r\n" +
						"Terabytes: " + numPetabytes
						);
				}
				else
				System.out.println("No Value in Box");
			}
		});
        
        b.setText("Convert");
        
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.HORIZONTAL);
        LP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        form.setLayoutParams(LP);
        
        form.addView(et);
        form.addView(b);
        
        LL.addView(form);
        
        
        
        result = new TextView(this);
        LL.addView(result);
        setContentView(LL);
        
        

        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
