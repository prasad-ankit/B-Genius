package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LargeParcelTeleporter
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new B();
  final int a;
  ParcelFileDescriptor b;
  private Parcelable c;
  private boolean d;

  LargeParcelTeleporter(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.a = paramInt;
    this.b = paramParcelFileDescriptor;
    this.c = null;
    this.d = true;
  }

  public LargeParcelTeleporter(SafeParcelable paramSafeParcelable)
  {
    this.a = 1;
    this.b = null;
    this.c = paramSafeParcelable;
    this.d = false;
  }

  // ERROR //
  private ParcelFileDescriptor a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 45	android/os/ParcelFileDescriptor:createPipe	()[Landroid/os/ParcelFileDescriptor;
    //   3: astore 4
    //   5: new 47	android/os/ParcelFileDescriptor$AutoCloseOutputStream
    //   8: dup
    //   9: aload 4
    //   11: iconst_1
    //   12: aaload
    //   13: invokespecial 50	android/os/ParcelFileDescriptor$AutoCloseOutputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   16: astore_3
    //   17: new 52	java/lang/Thread
    //   20: dup
    //   21: new 54	com/google/android/gms/ads/internal/request/b
    //   24: dup
    //   25: aload_0
    //   26: aload_3
    //   27: aload_1
    //   28: invokespecial 57	com/google/android/gms/ads/internal/request/b:<init>	(Lcom/google/android/gms/ads/internal/request/LargeParcelTeleporter;Ljava/io/OutputStream;[B)V
    //   31: invokespecial 60	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   34: invokevirtual 63	java/lang/Thread:start	()V
    //   37: aload 4
    //   39: iconst_0
    //   40: aaload
    //   41: astore 5
    //   43: aload 5
    //   45: areturn
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_3
    //   49: ldc 65
    //   51: aload_2
    //   52: invokestatic 70	com/google/android/gms/b/hc:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   55: invokestatic 76	com/google/android/gms/ads/internal/P:h	()Lcom/google/android/gms/b/hn;
    //   58: aload_2
    //   59: iconst_1
    //   60: invokevirtual 81	com/google/android/gms/b/hn:a	(Ljava/lang/Throwable;Z)V
    //   63: aload_3
    //   64: invokestatic 86	android/support/v4/app/j:a	(Ljava/io/Closeable;)V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_2
    //   70: goto -21 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   0	17	46	java/io/IOException
    //   17	43	69	java/io/IOException
  }

  // ERROR //
  public final SafeParcelable a(Parcelable.Creator paramCreator)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:d	Z
    //   4: ifeq +105 -> 109
    //   7: aload_0
    //   8: getfield 31	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:b	Landroid/os/ParcelFileDescriptor;
    //   11: ifnonnull +10 -> 21
    //   14: ldc 89
    //   16: invokestatic 92	com/google/android/gms/b/hc:b	(Ljava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 94	java/io/DataInputStream
    //   24: dup
    //   25: new 96	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 31	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:b	Landroid/os/ParcelFileDescriptor;
    //   33: invokespecial 97	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   36: invokespecial 100	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 104	java/io/DataInputStream:readInt	()I
    //   44: newarray byte
    //   46: astore 5
    //   48: aload_2
    //   49: aload 5
    //   51: iconst_0
    //   52: aload 5
    //   54: arraylength
    //   55: invokevirtual 108	java/io/DataInputStream:readFully	([BII)V
    //   58: aload_2
    //   59: invokestatic 86	android/support/v4/app/j:a	(Ljava/io/Closeable;)V
    //   62: invokestatic 114	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   65: astore 6
    //   67: aload 6
    //   69: aload 5
    //   71: iconst_0
    //   72: aload 5
    //   74: arraylength
    //   75: invokevirtual 117	android/os/Parcel:unmarshall	([BII)V
    //   78: aload 6
    //   80: iconst_0
    //   81: invokevirtual 121	android/os/Parcel:setDataPosition	(I)V
    //   84: aload_0
    //   85: aload_1
    //   86: aload 6
    //   88: invokeinterface 127 2 0
    //   93: checkcast 6	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   96: putfield 33	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:c	Landroid/os/Parcelable;
    //   99: aload 6
    //   101: invokevirtual 130	android/os/Parcel:recycle	()V
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 35	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:d	Z
    //   109: aload_0
    //   110: getfield 33	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:c	Landroid/os/Parcelable;
    //   113: checkcast 6	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   116: areturn
    //   117: astore 4
    //   119: new 132	java/lang/IllegalStateException
    //   122: dup
    //   123: ldc 134
    //   125: aload 4
    //   127: invokespecial 136	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: athrow
    //   131: astore_3
    //   132: aload_2
    //   133: invokestatic 86	android/support/v4/app/j:a	(Ljava/io/Closeable;)V
    //   136: aload_3
    //   137: athrow
    //   138: astore 7
    //   140: aload 6
    //   142: invokevirtual 130	android/os/Parcel:recycle	()V
    //   145: aload 7
    //   147: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   40	58	117	java/io/IOException
    //   40	58	131	finally
    //   119	131	131	finally
    //   67	99	138	finally
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Parcel localParcel;
    if (this.b == null)
      localParcel = Parcel.obtain();
    try
    {
      this.c.writeToParcel(localParcel, 0);
      byte[] arrayOfByte = localParcel.marshall();
      localParcel.recycle();
      this.b = a(arrayOfByte);
      B.a(this, paramParcel, paramInt);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.LargeParcelTeleporter
 * JD-Core Version:    0.6.0
 */