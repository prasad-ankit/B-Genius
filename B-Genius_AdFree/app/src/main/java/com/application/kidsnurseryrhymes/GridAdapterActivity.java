package com.application.kidsnurseryrhymes;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ksz.test.b_genius.R;

public class GridAdapterActivity extends ArrayAdapter<GridItemActivity>
{
  Context context;
  @SuppressWarnings({ "unchecked", "rawtypes" })
ArrayList<GridItemActivity> data = new ArrayList();
  int layoutResourceId;
  private LinearLayout.LayoutParams mImageViewLayoutParams;
  private LayoutInflater mInflater;
  private int mItemHeight = 0;
  private int mNumColumns = 0;

  public GridAdapterActivity(Context paramContext, int paramInt, ArrayList<GridItemActivity> paramArrayList)
  {
    super(paramContext, paramInt, paramArrayList);
    layoutResourceId = paramInt;
    context = paramContext;
    data = paramArrayList;
    mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    mImageViewLayoutParams = new LinearLayout.LayoutParams(-1, -1);
  }

  public int getNumColumns()
  {
    return mNumColumns;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    paramView = this.mInflater.inflate(R.layout.gridphotoitem, null);
    ImageView localImageView = (ImageView)paramView.findViewById(R.id.cover);
    TextView localTextView = (TextView)paramView.findViewById(R.id.title);
    localImageView.setLayoutParams(mImageViewLayoutParams);
    if (localImageView.getLayoutParams().height != mItemHeight)
    localImageView.setLayoutParams(mImageViewLayoutParams);
    GridItemActivity localGridItem_Activity = (GridItemActivity)data.get(paramInt);
    localTextView.setText(localGridItem_Activity.getTitle());
    localImageView.setImageBitmap(localGridItem_Activity.getImage());
    return paramView;
  }

  public void setItemHeight(int paramInt)
  {
    if (paramInt == mItemHeight);
    while (true)
    {
      
      mItemHeight = paramInt;
      mImageViewLayoutParams = new LinearLayout.LayoutParams(-1, mItemHeight);
      notifyDataSetChanged();
      return;
    }
  }

  public void setNumColumns(int paramInt)
  {
    mNumColumns = paramInt;
  }
}

