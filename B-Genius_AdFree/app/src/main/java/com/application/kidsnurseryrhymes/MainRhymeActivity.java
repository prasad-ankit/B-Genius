package com.application.kidsnurseryrhymes;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import com.startapp.android.publish.StartAppSDK;

import ksz.test.b_genius.R;

public class MainRhymeActivity extends Activity
{
  GridAdapterActivity adapter;
  @SuppressWarnings({ "unchecked", "rawtypes" })
  ArrayList<GridItemActivity> gridArray = new ArrayList();
  GridView gridlsv;
  TextView maintext;
  private int mPhotoSize;
  private int mPhotoSpacing;
  @SuppressWarnings({ "unchecked", "rawtypes" })
protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    StartAppSDK.init(this, AppConstants.DEVELOPER_ID, AppConstants.APP_ID, true); //TODO: Replace with your IDs
    setContentView(R.layout.mainscreenactivity);
    

    Typeface tf = Typeface.createFromAsset(getAssets(),"bubblegumsans.otf");
    maintext = (TextView)findViewById(R.id.maintext);
	maintext.setTypeface(tf);
    maintext.setText("Kids Nursery Rhymes");
    Bitmap localBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.a_b_c_d);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.pussey_cat);
    Bitmap localBitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.today_monday);
    Bitmap localBitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.the_farmer);
    Bitmap localBitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.twinkle);
    Bitmap localBitmap6 = BitmapFactory.decodeResource(getResources(), R.drawable.wille_wille);
    Bitmap localBitmap7 = BitmapFactory.decodeResource(getResources(), R.drawable.oldkingcole);
    Bitmap localBitmap8 = BitmapFactory.decodeResource(getResources(), R.drawable.blue_bird);
    Bitmap localBitmap9 = BitmapFactory.decodeResource(getResources(), R.drawable.one_two_buck);
    Bitmap localBitmap10 = BitmapFactory.decodeResource(getResources(), R.drawable.clap_your_hands);
    
    ArrayList arrayList1 = gridArray;
    GridItemActivity gridItem_Activity1 = new GridItemActivity(localBitmap1, "A B C D");
    arrayList1.add(gridItem_Activity1);
   
    ArrayList arrayList2 = gridArray;
    GridItemActivity gridItem_Activity2 = new GridItemActivity(localBitmap2, "Pussy Cat");
    arrayList2.add(gridItem_Activity2);
    
    ArrayList arrayList3 = gridArray;
    GridItemActivity gridItem_Activity3 = new GridItemActivity(localBitmap3, "Today");
    arrayList3.add(gridItem_Activity3);
    
    ArrayList arrayList4 = gridArray;
    GridItemActivity gridItem_Activity4 = new GridItemActivity(localBitmap4, "The Farmer");
    arrayList4.add(gridItem_Activity4);
  
    ArrayList arrayList5 = gridArray;
    GridItemActivity gridItem_Activity5 = new GridItemActivity(localBitmap5, "Twinkle Twinkle");
    arrayList5.add(gridItem_Activity5);
  
    ArrayList arrayList6 = gridArray;
    GridItemActivity gridItem_Activity6 = new GridItemActivity(localBitmap6, "Willie Winkie");
    arrayList6.add(gridItem_Activity6);
    
    ArrayList arrayList7 = gridArray;
    GridItemActivity gridItem_Activity7 = new GridItemActivity(localBitmap7, "Old King Cole");
    arrayList7.add(gridItem_Activity7);
    
    ArrayList arrayList8 = gridArray;
    GridItemActivity gridItem_Activity8 = new GridItemActivity(localBitmap8, "Bluebird");
    arrayList8.add(gridItem_Activity8);
    
    ArrayList arrayList9 = gridArray;
    GridItemActivity gridItem_Activity9 = new GridItemActivity(localBitmap9, "One Two Three");
    arrayList9.add(gridItem_Activity9);
 
    ArrayList arrayList10 = gridArray;
    GridItemActivity gridItem_Activity10 = new GridItemActivity(localBitmap10, "Clap Your Hands");
    arrayList10.add(gridItem_Activity10);
    
    gridlsv = ((GridView)findViewById(R.id.gridview));
    GridAdapterActivity gridAdapter_Activity = new GridAdapterActivity(this, R.layout.gridphotoitem, gridArray);
    adapter = gridAdapter_Activity;
    gridlsv.setAdapter(adapter);
    mPhotoSize = getResources().getDimensionPixelSize(R.dimen.photo_size);
    mPhotoSpacing = getResources().getDimensionPixelSize(R.dimen.photo_spacing);
    ViewTreeObserver viewTreeObserver = gridlsv.getViewTreeObserver();
    ViewTreeObserver.OnGlobalLayoutListener local1 = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        if (adapter.getNumColumns() == 0)
        {
          int i = (int)Math.floor(gridlsv.getWidth() / (mPhotoSize + mPhotoSpacing));
          if (i > 0)
          {
            int j = gridlsv.getWidth() / i - mPhotoSpacing;
            adapter.setNumColumns(i);
            adapter.setItemHeight(j);
          }
        }
      }
    };
    viewTreeObserver.addOnGlobalLayoutListener(local1);
    GridView gridView = gridlsv;
    AdapterView.OnItemClickListener local2 = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> parent, View view, int inte, long longe)
      {
        Intent localIntent = new Intent(getApplicationContext(), SongRhymeActivity.class);
        localIntent.putExtra("position", inte);
        startActivity(localIntent);
        overridePendingTransition(R.anim.rightin, R.anim.rightout);
      }
    };
    gridView.setOnItemClickListener(local2);
  }
   @Override
   public void onResume() {
   	super.onResume();
   }

   @Override
   public void onPause() {
   	super.onPause();
   }

   @Override
   public void onBackPressed() {
	overridePendingTransition(R.anim.rightin, R.anim.rightout);
   	super.onBackPressed();
   }
}