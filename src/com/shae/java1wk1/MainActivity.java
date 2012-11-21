package com.shae.java1wk1;

import java.io.Console;
import java.util.concurrent.CountDownLatch;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
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
        
        // setting up screen layout 
        LL = new LinearLayout(this);
		LL.setBackgroundColor(0xFF00FF00 ); // set app BG to Lime Green
        LL.setOrientation(LinearLayout.VERTICAL); // set app main run layout as Vertical
        LP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        // setting the Parameters of the window for LL to the device window
        LL.setLayoutParams(LP);
        
        TextView tv = new TextView(this);
        //tv.getBackground().setColorFilter(Color.parseColor("#00ff00"), null);
        tv.setText("Conversion Table from Gigabytes!");
        
        // Set text Size
        tv.setTextSize(20);
        
        // set line centered Horizontally
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        
        LL.addView(tv);
        
        setContentView(LL);
        
        // Set ET to become NEW EditText field
        et = new EditText(this);
        
        // set ET attributes
        et.setHint("Enter Gigabytes");
        et.setBackgroundColor(Color.WHITE);
        
        ///////  NEW BUTTON  ///////////////
        Button b = new Button(this);
        b.setBackgroundColor(Color.LTGRAY);
     // create eventListener for 1st Button and BG color
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			
			public void onClick(View v) {

				// Checking to see IF the UIText field is empty or not
				// DOES NOT VALIDATE to check if an INT.  Will crash on letter, does nothing on decimal point add
				if(et.getText().toString().compareTo("") == 1)   // Testing to see if "et" is == to Empty string.  1 means NOT the same (not blank)
				{
				Log.i("TextField", "HAS DATA");

				
				// Settings Vars using Resources 
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
				else // If the user field is blank, else
				{
					// If the user input field is blank, LOG this
					Log.i("TextField", "HAS NO DATA!!!");
				}
				// Setting the text size and color and weight for the Result TextView
				result.setTextColor(Color.YELLOW);
				result.setTextSize(20);
				result.setTypeface(null, 1);
			}
		
		});
       // Setting the 1st buttons text
        b.setText("Convert");
        
        
        
        ///////  NEW BUTTON  ///////////////
        Button c = new Button(this);
        // setting the 2nd buttons text and BG color
        c.setText("Clear");
        c.setBackgroundColor(Color.LTGRAY);
        
        // create eventListener for 2nd Button
        c.setOnClickListener(new View.OnClickListener() {
        	
        	@Override
			public void onClick(View v) {
        		// resetting values and textViews
        		result.setText("");
        		et.setText("");
        	}
        	
        	
        });
        
        
        // adding a new layout
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.HORIZONTAL);
        LP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        form.setLayoutParams(LP);
        // adding the EditText Field, Convert Button and Clear Button to the "form" layout
        form.addView(et);
        form.addView(b);
        form.addView(c);
        
        form.setGravity(Gravity.CENTER_HORIZONTAL);
        
        // adding the "form" layout to the "main" layout
        LL.addView(form);
        
        
        
        result = new TextView(this);
        // adding the result to the main layout
        LL.addView(result);
        
        // setting the content of the device window to view the "main" layout and its sub-views
        setContentView(LL);
        
        ///////////////////////////////////////////////////////////
        ////  LOOOOOOOOP  (see my loop in the LogCat) /////////////  
        ///////////////////////////////////////////////////////////
        
        for(int i=0, j=10 ; i<j; i++){
        	Log.i("LOOP", "count" + (i + 1));
        	// log count 1 - 10
        	}

        
        
    }

    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
