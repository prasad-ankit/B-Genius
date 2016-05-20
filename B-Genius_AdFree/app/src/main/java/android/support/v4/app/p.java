package android.support.v4.app;

import android.os.Parcel;

public class p extends RuntimeException
{
  public p(String paramString, Parcel paramParcel)
  {
    super(paramString + " Parcel: pos=" + paramParcel.dataPosition() + " size=" + paramParcel.dataSize());
  }

  public p(String paramString, Exception paramException)
  {
    super(paramString, paramException);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.p
 * JD-Core Version:    0.6.0
 */