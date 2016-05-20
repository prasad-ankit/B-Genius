package com.application.kidsnurseryrhymes;

import android.graphics.Bitmap;

public class GridItemActivity
{
  Bitmap image;
  String title;

  public GridItemActivity(Bitmap paramBitmap, String paramString)
  {
    this.image = paramBitmap;
    this.title = paramString;
  }

  public Bitmap getImage()
  {
    return this.image;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setImage(Bitmap paramBitmap)
  {
    this.image = paramBitmap;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}
