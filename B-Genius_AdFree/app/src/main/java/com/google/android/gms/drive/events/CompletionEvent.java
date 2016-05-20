package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator CREATOR = new d();
  final int a;
  final DriveId b;
  final String c;
  final ParcelFileDescriptor d;
  final ParcelFileDescriptor e;
  final MetadataBundle f;
  final List g;
  final int h;
  final IBinder i;

  CompletionEvent(int paramInt1, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, List paramList, int paramInt2, IBinder paramIBinder)
  {
    this.a = paramInt1;
    this.b = paramDriveId;
    this.c = paramString;
    this.d = paramParcelFileDescriptor1;
    this.e = paramParcelFileDescriptor2;
    this.f = paramMetadataBundle;
    this.g = paramList;
    this.h = paramInt2;
    this.i = paramIBinder;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String toString()
  {
    if (this.g == null);
    for (String str = "<null>"; ; str = "'" + TextUtils.join("','", this.g) + "'")
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = this.b;
      arrayOfObject[1] = Integer.valueOf(this.h);
      arrayOfObject[2] = str;
      return String.format(localLocale, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", arrayOfObject);
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt | 0x1);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.CompletionEvent
 * JD-Core Version:    0.6.0
 */