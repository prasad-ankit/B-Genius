package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.aB;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.au;
import com.google.android.gms.b.dW;
import com.google.android.gms.b.gT;
import com.google.android.gms.b.hG;
import com.google.android.gms.b.ha;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.ho;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.ij;
import com.google.android.gms.b.im;
import com.google.android.gms.b.ju;
import com.google.android.gms.b.r;
import com.google.android.gms.b.y;

public final class e extends ha
  implements j
{
  hG a;
  private final d b;
  private final a c;
  private final Object d = new Object();
  private final Context e;
  private final y f;
  private AdRequestInfoParcel g;
  private Runnable h;
  private AdResponseParcel i;
  private dW j;

  public e(Context paramContext, a parama, y paramy, d paramd)
  {
    this.b = paramd;
    this.e = paramContext;
    this.c = parama;
    this.f = paramy;
  }

  private AdSizeParcel a(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    if (this.i.m == null)
      throw new h("The ad response must specify one of the supported ad sizes.", 0);
    String[] arrayOfString = this.i.m.split("x");
    if (arrayOfString.length != 2)
      throw new h("Invalid ad size format from the ad response: " + this.i.m, 0);
    while (true)
    {
      int i1;
      AdSizeParcel localAdSizeParcel;
      try
      {
        int k = Integer.parseInt(arrayOfString[0]);
        int m = Integer.parseInt(arrayOfString[1]);
        AdSizeParcel[] arrayOfAdSizeParcel = paramAdRequestInfoParcel.d.h;
        int n = arrayOfAdSizeParcel.length;
        i1 = 0;
        if (i1 >= n)
          break;
        localAdSizeParcel = arrayOfAdSizeParcel[i1];
        float f1 = this.e.getResources().getDisplayMetrics().density;
        if (localAdSizeParcel.f == -1)
        {
          i2 = (int)(localAdSizeParcel.g / f1);
          if (localAdSizeParcel.c != -2)
            break label249;
          i3 = (int)(localAdSizeParcel.d / f1);
          if ((k != i2) || (m != i3))
            break label259;
          return new AdSizeParcel(localAdSizeParcel, paramAdRequestInfoParcel.d.h);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new h("Invalid ad size number from the ad response: " + this.i.m, 0);
      }
      int i2 = localAdSizeParcel.f;
      continue;
      label249: int i3 = localAdSizeParcel.c;
      continue;
      label259: i1++;
    }
    throw new h("The ad size from the ad response was not one of the requested sizes: " + this.i.m, 0);
  }

  private void a(int paramInt, String paramString)
  {
    if ((paramInt == 3) || (paramInt == -1))
    {
      hc.c(paramString);
      if (this.i != null)
        break label95;
      this.i = new AdResponseParcel(paramInt);
      label33: if (this.g == null)
        break label117;
    }
    label95: label117: for (AdRequestInfoParcel localAdRequestInfoParcel = this.g; ; localAdRequestInfoParcel = new AdRequestInfoParcel(this.c, null, -1L))
    {
      gT localgT = new gT(localAdRequestInfoParcel, this.i, this.j, null, paramInt, -1L, this.i.n, null);
      this.b.a(localgT);
      return;
      hc.d(paramString);
      break;
      this.i = new AdResponseParcel(paramInt, this.i.k);
      break label33;
    }
  }

  final hG a(VersionInfoParcel paramVersionInfoParcel, ij paramij)
  {
    return a.a(this.e, paramVersionInfoParcel, paramij, this);
  }

  public final void a()
  {
    hc.a("AdLoaderBackgroundTask started.");
    this.h = new f(this);
    Handler localHandler = hu.a;
    Runnable localRunnable = this.h;
    au localau = aD.Z;
    localHandler.postDelayed(localRunnable, ((Long)P.n().a(localau)).longValue());
    im localim = new im();
    long l = P.i().b();
    ho.a(new g(this, localim));
    String str = this.f.a().a(this.e);
    this.g = new AdRequestInfoParcel(this.c, str, l);
    localim.a(this.g);
  }

  // ERROR //
  public final void a(AdResponseParcel paramAdResponseParcel)
  {
    // Byte code:
    //   0: ldc_w 272
    //   3: invokestatic 192	com/google/android/gms/b/hc:a	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: aload_1
    //   8: putfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   11: invokestatic 236	com/google/android/gms/ads/internal/P:i	()Lcom/google/android/gms/b/ju;
    //   14: invokeinterface 240 1 0
    //   19: lstore_2
    //   20: aload_0
    //   21: getfield 36	com/google/android/gms/ads/internal/request/e:d	Ljava/lang/Object;
    //   24: astore 4
    //   26: aload 4
    //   28: monitorenter
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 274	com/google/android/gms/ads/internal/request/e:a	Lcom/google/android/gms/b/hG;
    //   34: aload 4
    //   36: monitorexit
    //   37: aload_0
    //   38: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   41: getfield 276	com/google/android/gms/ads/internal/request/AdResponseParcel:e	I
    //   44: bipush 254
    //   46: if_icmpeq +88 -> 134
    //   49: aload_0
    //   50: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   53: getfield 276	com/google/android/gms/ads/internal/request/AdResponseParcel:e	I
    //   56: bipush 253
    //   58: if_icmpeq +76 -> 134
    //   61: new 57	com/google/android/gms/ads/internal/request/h
    //   64: dup
    //   65: new 72	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 278
    //   72: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   79: getfield 276	com/google/android/gms/ads/internal/request/AdResponseParcel:e	I
    //   82: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: aload_0
    //   89: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   92: getfield 276	com/google/android/gms/ads/internal/request/AdResponseParcel:e	I
    //   95: invokespecial 62	com/google/android/gms/ads/internal/request/h:<init>	(Ljava/lang/String;I)V
    //   98: athrow
    //   99: astore 6
    //   101: aload_0
    //   102: aload 6
    //   104: invokevirtual 284	com/google/android/gms/ads/internal/request/h:a	()I
    //   107: aload 6
    //   109: invokevirtual 287	com/google/android/gms/ads/internal/request/h:getMessage	()Ljava/lang/String;
    //   112: invokespecial 178	com/google/android/gms/ads/internal/request/e:a	(ILjava/lang/String;)V
    //   115: getstatic 202	com/google/android/gms/b/hu:a	Landroid/os/Handler;
    //   118: aload_0
    //   119: getfield 182	com/google/android/gms/ads/internal/request/e:h	Ljava/lang/Runnable;
    //   122: invokevirtual 291	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   125: return
    //   126: astore 5
    //   128: aload 4
    //   130: monitorexit
    //   131: aload 5
    //   133: athrow
    //   134: aload_0
    //   135: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   138: getfield 276	com/google/android/gms/ads/internal/request/AdResponseParcel:e	I
    //   141: bipush 253
    //   143: if_icmpeq +78 -> 221
    //   146: aload_0
    //   147: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   150: getfield 293	com/google/android/gms/ads/internal/request/AdResponseParcel:c	Ljava/lang/String;
    //   153: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +15 -> 171
    //   159: new 57	com/google/android/gms/ads/internal/request/h
    //   162: dup
    //   163: ldc_w 301
    //   166: iconst_3
    //   167: invokespecial 62	com/google/android/gms/ads/internal/request/h:<init>	(Ljava/lang/String;I)V
    //   170: athrow
    //   171: invokestatic 304	com/google/android/gms/ads/internal/P:h	()Lcom/google/android/gms/b/hn;
    //   174: aload_0
    //   175: getfield 40	com/google/android/gms/ads/internal/request/e:e	Landroid/content/Context;
    //   178: aload_0
    //   179: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   182: getfield 307	com/google/android/gms/ads/internal/request/AdResponseParcel:u	Z
    //   185: invokevirtual 312	com/google/android/gms/b/hn:a	(Landroid/content/Context;Z)Ljava/util/concurrent/Future;
    //   188: pop
    //   189: aload_0
    //   190: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   193: getfield 314	com/google/android/gms/ads/internal/request/AdResponseParcel:h	Z
    //   196: istore 13
    //   198: iload 13
    //   200: ifeq +21 -> 221
    //   203: aload_0
    //   204: new 316	com/google/android/gms/b/dW
    //   207: dup
    //   208: aload_0
    //   209: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   212: getfield 293	com/google/android/gms/ads/internal/request/AdResponseParcel:c	Ljava/lang/String;
    //   215: invokespecial 317	com/google/android/gms/b/dW:<init>	(Ljava/lang/String;)V
    //   218: putfield 150	com/google/android/gms/ads/internal/request/e:j	Lcom/google/android/gms/b/dW;
    //   221: aload_0
    //   222: getfield 146	com/google/android/gms/ads/internal/request/e:g	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   225: getfield 96	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:d	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   228: getfield 101	com/google/android/gms/ads/internal/client/AdSizeParcel:h	[Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   231: ifnull +166 -> 397
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 146	com/google/android/gms/ads/internal/request/e:g	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   239: invokespecial 319	com/google/android/gms/ads/internal/request/e:a	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   242: astore 11
    //   244: aload 11
    //   246: astore 7
    //   248: invokestatic 304	com/google/android/gms/ads/internal/P:h	()Lcom/google/android/gms/b/hn;
    //   251: aload_0
    //   252: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   255: getfield 322	com/google/android/gms/ads/internal/request/AdResponseParcel:v	Z
    //   258: invokevirtual 325	com/google/android/gms/b/hn:a	(Z)V
    //   261: aload_0
    //   262: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   265: getfield 328	com/google/android/gms/ads/internal/request/AdResponseParcel:r	Ljava/lang/String;
    //   268: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   271: ifne +120 -> 391
    //   274: new 330	org/json/JSONObject
    //   277: dup
    //   278: aload_0
    //   279: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   282: getfield 328	com/google/android/gms/ads/internal/request/AdResponseParcel:r	Ljava/lang/String;
    //   285: invokespecial 331	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   288: astore 8
    //   290: new 148	com/google/android/gms/b/gT
    //   293: dup
    //   294: aload_0
    //   295: getfield 146	com/google/android/gms/ads/internal/request/e:g	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   298: aload_0
    //   299: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   302: aload_0
    //   303: getfield 150	com/google/android/gms/ads/internal/request/e:j	Lcom/google/android/gms/b/dW;
    //   306: aload 7
    //   308: bipush 254
    //   310: lload_2
    //   311: aload_0
    //   312: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   315: getfield 156	com/google/android/gms/ads/internal/request/AdResponseParcel:n	J
    //   318: aload 8
    //   320: invokespecial 159	com/google/android/gms/b/gT:<init>	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Lcom/google/android/gms/ads/internal/request/AdResponseParcel;Lcom/google/android/gms/b/dW;Lcom/google/android/gms/ads/internal/client/AdSizeParcel;IJJLorg/json/JSONObject;)V
    //   323: astore 9
    //   325: aload_0
    //   326: getfield 38	com/google/android/gms/ads/internal/request/e:b	Lcom/google/android/gms/ads/internal/request/d;
    //   329: aload 9
    //   331: invokeinterface 164 2 0
    //   336: getstatic 202	com/google/android/gms/b/hu:a	Landroid/os/Handler;
    //   339: aload_0
    //   340: getfield 182	com/google/android/gms/ads/internal/request/e:h	Ljava/lang/Runnable;
    //   343: invokevirtual 291	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   346: return
    //   347: astore 14
    //   349: new 57	com/google/android/gms/ads/internal/request/h
    //   352: dup
    //   353: new 72	java/lang/StringBuilder
    //   356: dup
    //   357: ldc_w 333
    //   360: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: aload_0
    //   364: getfield 49	com/google/android/gms/ads/internal/request/e:i	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   367: getfield 293	com/google/android/gms/ads/internal/request/AdResponseParcel:c	Ljava/lang/String;
    //   370: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: iconst_0
    //   377: invokespecial 62	com/google/android/gms/ads/internal/request/h:<init>	(Ljava/lang/String;I)V
    //   380: athrow
    //   381: astore 10
    //   383: ldc_w 335
    //   386: aload 10
    //   388: invokestatic 338	com/google/android/gms/b/hc:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   391: aconst_null
    //   392: astore 8
    //   394: goto -104 -> 290
    //   397: aconst_null
    //   398: astore 7
    //   400: goto -152 -> 248
    //
    // Exception table:
    //   from	to	target	type
    //   37	99	99	com/google/android/gms/ads/internal/request/h
    //   134	171	99	com/google/android/gms/ads/internal/request/h
    //   171	198	99	com/google/android/gms/ads/internal/request/h
    //   203	221	99	com/google/android/gms/ads/internal/request/h
    //   221	244	99	com/google/android/gms/ads/internal/request/h
    //   349	381	99	com/google/android/gms/ads/internal/request/h
    //   29	37	126	finally
    //   128	131	126	finally
    //   203	221	347	org/json/JSONException
    //   274	290	381	java/lang/Exception
  }

  public final void b()
  {
    synchronized (this.d)
    {
      if (this.a != null)
        this.a.d();
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.e
 * JD-Core Version:    0.6.0
 */