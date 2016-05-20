package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import android.text.TextUtils;
import com.google.android.gms.b.jt;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Set;
import java.util.regex.Pattern;

public class DriveSpace
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new n();
  private static DriveSpace b = new DriveSpace("DRIVE");
  private static DriveSpace c = new DriveSpace("APP_DATA_FOLDER");
  private static DriveSpace d = new DriveSpace("PHOTOS");
  private static Set e;
  final int a;
  private final String f;

  static
  {
    DriveSpace localDriveSpace1 = b;
    DriveSpace localDriveSpace2 = c;
    DriveSpace localDriveSpace3 = d;
    jt localjt = new jt(3);
    localjt.add(localDriveSpace1);
    localjt.add(localDriveSpace2);
    localjt.add(localDriveSpace3);
    e = Collections.unmodifiableSet(localjt);
    TextUtils.join(",", e.toArray());
    Pattern.compile("[A-Z0-9_]*");
  }

  DriveSpace(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.f = ((String)w.a(paramString));
  }

  private DriveSpace(String paramString)
  {
    this(1, paramString);
  }

  public final String a()
  {
    return this.f;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != DriveSpace.class))
      return false;
    return this.f.equals(((DriveSpace)paramObject).f);
  }

  public int hashCode()
  {
    return 0x4A54C0DE ^ this.f.hashCode();
  }

  public String toString()
  {
    return this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DriveSpace
 * JD-Core Version:    0.6.0
 */