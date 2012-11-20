package com.shae.java1wk1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	LinearLayout LL;
	LinearLayout.LayoutParams LP;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LL = new LinearLayout(this);
        LL.setOrientation(LinearLayout.VERTICAL);
        LP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LL.setLayoutParams(LP);
        
        TextView tv = new TextView(this);
        tv.setText("This is a test, this is only a test!");
        
        LL.addView(tv);
        
        setContentView(LL);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
