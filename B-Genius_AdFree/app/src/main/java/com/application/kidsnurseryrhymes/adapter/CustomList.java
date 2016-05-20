package com.application.kidsnurseryrhymes.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ksz.test.b_genius.R;

public class CustomList extends ArrayAdapter<String>{
private final Activity context;
private final String[] web;
	public CustomList(Activity context,String[] web) {
		super(context, R.layout.listitem, web);
this.context = context;
this.web = web;
}
@Override
public View getView(int position, View view, ViewGroup parent) {
LayoutInflater inflater = context.getLayoutInflater();
View rowView= inflater.inflate(R.layout.listitem, null, true);
Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"nosifercaps.ttf");
TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
Animation shake = AnimationUtils.loadAnimation(getContext(), R.anim.fadein);
	rowView.findViewById(R.id.textView1).startAnimation(shake);
txtTitle.setTypeface(tf);   
txtTitle.setText(web[position]);
return rowView;
}
}
