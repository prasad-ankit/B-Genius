package com.badlogic.gdx.backends.android;

import android.text.Editable;
import android.text.InputFilter;
import android.util.Log;

public class AndroidOnscreenKeyboard$PassThroughEditable
  implements Editable
{
  public Editable append(char paramChar)
  {
    Log.d("Editable", "append: " + paramChar);
    return this;
  }

  public Editable append(CharSequence paramCharSequence)
  {
    Log.d("Editable", "append: " + paramCharSequence);
    return this;
  }

  public Editable append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Log.d("Editable", "append: " + paramCharSequence);
    return this;
  }

  public char charAt(int paramInt)
  {
    Log.d("Editable", "charAt");
    return '\000';
  }

  public void clear()
  {
    Log.d("Editable", "clear");
  }

  public void clearSpans()
  {
    Log.d("Editable", "clearSpanes");
  }

  public Editable delete(int paramInt1, int paramInt2)
  {
    Log.d("Editable", "delete, " + paramInt1 + ", " + paramInt2);
    return this;
  }

  public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    Log.d("Editable", "getChars");
  }

  public InputFilter[] getFilters()
  {
    Log.d("Editable", "getFilters");
    return new InputFilter[0];
  }

  public int getSpanEnd(Object paramObject)
  {
    Log.d("Editable", "getSpanEnd");
    return 0;
  }

  public int getSpanFlags(Object paramObject)
  {
    Log.d("Editable", "getSpanFlags");
    return 0;
  }

  public int getSpanStart(Object paramObject)
  {
    Log.d("Editable", "getSpanStart");
    return 0;
  }

  public Object[] getSpans(int paramInt1, int paramInt2, Class paramClass)
  {
    Log.d("Editable", "getSpans");
    return null;
  }

  public Editable insert(int paramInt, CharSequence paramCharSequence)
  {
    Log.d("Editable", "insert: " + paramCharSequence);
    return this;
  }

  public Editable insert(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    Log.d("Editable", "insert: " + paramCharSequence);
    return this;
  }

  public int length()
  {
    Log.d("Editable", "length");
    return 0;
  }

  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    Log.d("Editable", "nextSpanTransition");
    return 0;
  }

  public void removeSpan(Object paramObject)
  {
    Log.d("Editable", "removeSpan");
  }

  public Editable replace(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    Log.d("Editable", "replace: " + paramCharSequence);
    return this;
  }

  public Editable replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    Log.d("Editable", "replace: " + paramCharSequence);
    return this;
  }

  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    Log.d("Editable", "setFilters");
  }

  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d("Editable", "setSpan");
  }

  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    Log.d("Editable", "subSequence");
    return null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidOnscreenKeyboard.PassThroughEditable
 * JD-Core Version:    0.6.0
 */