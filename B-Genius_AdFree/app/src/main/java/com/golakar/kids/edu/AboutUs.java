/**Project Under : Golakar Kids Apps
 * You can not modify & redistribute without permission from the author
 * Project published on Golakar Technology platform April, 2014
 * Release Template for the buyer august 2015
 */
package com.golakar.kids.edu;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import ksz.test.b_genius.R;

public class AboutUs extends Activity {
	
	WebView myBrowser;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        myBrowser = (WebView)findViewById(R.id.mybrowser);
        
        myBrowser.loadUrl("file:///android_asset/about/index.html");

    }
}