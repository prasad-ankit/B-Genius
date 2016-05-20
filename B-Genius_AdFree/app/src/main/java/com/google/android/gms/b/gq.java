package com.google.android.gms.b;

import android.content.Context;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.w;
import com.google.android.gms.ads.internal.request.y;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class gq extends w
{
  private static final Object a = new Object();
  private static gq b;
  private final Context c;
  private final gp d;
  private final as e;
  private final du f;

  private gq(Context paramContext, as paramas, gp paramgp)
  {
    this.c = paramContext;
    this.d = paramgp;
    this.e = paramas;
    if (paramContext.getApplicationContext() != null);
    for (Context localContext = paramContext.getApplicationContext(); ; localContext = paramContext)
    {
      this.f = new du(localContext, new VersionInfoParcel(8487000, 8487000, true), paramas.a(), new gy(this), new dH());
      return;
    }
  }

  // ERROR //
  private static AdResponseParcel a(Context paramContext, du paramdu, as paramas, gp paramgp, AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    // Byte code:
    //   0: ldc 78
    //   2: invokestatic 83	com/google/android/gms/b/hc:a	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: invokestatic 88	com/google/android/gms/b/aD:a	(Landroid/content/Context;)V
    //   9: getstatic 92	com/google/android/gms/b/aD:u	Lcom/google/android/gms/b/au;
    //   12: astore 5
    //   14: new 94	com/google/android/gms/b/aR
    //   17: dup
    //   18: invokestatic 100	com/google/android/gms/ads/internal/P:n	()Lcom/google/android/gms/b/aB;
    //   21: aload 5
    //   23: invokevirtual 105	com/google/android/gms/b/aB:a	(Lcom/google/android/gms/b/au;)Ljava/lang/Object;
    //   26: checkcast 107	java/lang/Boolean
    //   29: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   32: ldc 113
    //   34: aload 4
    //   36: getfield 118	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:d	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   39: getfield 123	com/google/android/gms/ads/internal/client/AdSizeParcel:b	Ljava/lang/String;
    //   42: invokespecial 126	com/google/android/gms/b/aR:<init>	(ZLjava/lang/String;Ljava/lang/String;)V
    //   45: astore 6
    //   47: aload 4
    //   49: getfield 129	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:a	I
    //   52: bipush 10
    //   54: if_icmple +40 -> 94
    //   57: aload 4
    //   59: getfield 133	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:B	J
    //   62: ldc2_w 134
    //   65: lcmp
    //   66: ifeq +28 -> 94
    //   69: aload 6
    //   71: aload 6
    //   73: aload 4
    //   75: getfield 133	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:B	J
    //   78: invokevirtual 138	com/google/android/gms/b/aR:a	(J)Lcom/google/android/gms/b/aN;
    //   81: iconst_1
    //   82: anewarray 140	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: ldc 142
    //   89: aastore
    //   90: invokevirtual 145	com/google/android/gms/b/aR:a	(Lcom/google/android/gms/b/aN;[Ljava/lang/String;)Z
    //   93: pop
    //   94: aload 6
    //   96: invokevirtual 148	com/google/android/gms/b/aR:a	()Lcom/google/android/gms/b/aN;
    //   99: astore 7
    //   101: aload 4
    //   103: getfield 129	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:a	I
    //   106: iconst_4
    //   107: if_icmplt +853 -> 960
    //   110: aload 4
    //   112: getfield 152	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:o	Landroid/os/Bundle;
    //   115: ifnull +845 -> 960
    //   118: aload 4
    //   120: getfield 152	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:o	Landroid/os/Bundle;
    //   123: astore 8
    //   125: getstatic 155	com/google/android/gms/b/aD:D	Lcom/google/android/gms/b/au;
    //   128: astore 9
    //   130: invokestatic 100	com/google/android/gms/ads/internal/P:n	()Lcom/google/android/gms/b/aB;
    //   133: aload 9
    //   135: invokevirtual 105	com/google/android/gms/b/aB:a	(Lcom/google/android/gms/b/au;)Ljava/lang/Object;
    //   138: checkcast 107	java/lang/Boolean
    //   141: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   144: ifeq +806 -> 950
    //   147: aload_3
    //   148: getfield 161	com/google/android/gms/b/gp:i	Landroid/support/v4/app/z;
    //   151: ifnull +799 -> 950
    //   154: aload 8
    //   156: ifnonnull +39 -> 195
    //   159: getstatic 164	com/google/android/gms/b/aD:E	Lcom/google/android/gms/b/au;
    //   162: astore 52
    //   164: invokestatic 100	com/google/android/gms/ads/internal/P:n	()Lcom/google/android/gms/b/aB;
    //   167: aload 52
    //   169: invokevirtual 105	com/google/android/gms/b/aB:a	(Lcom/google/android/gms/b/au;)Ljava/lang/Object;
    //   172: checkcast 107	java/lang/Boolean
    //   175: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   178: ifeq +17 -> 195
    //   181: ldc 166
    //   183: invokestatic 168	com/google/android/gms/b/hc:e	(Ljava/lang/String;)V
    //   186: new 170	android/os/Bundle
    //   189: dup
    //   190: invokespecial 171	android/os/Bundle:<init>	()V
    //   193: astore 8
    //   195: aload 8
    //   197: ifnull +743 -> 940
    //   200: new 173	com/google/android/gms/b/gr
    //   203: dup
    //   204: aload_3
    //   205: aload_0
    //   206: aload 4
    //   208: aload 8
    //   210: invokespecial 176	com/google/android/gms/b/gr:<init>	(Lcom/google/android/gms/b/gp;Landroid/content/Context;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Landroid/os/Bundle;)V
    //   213: invokestatic 181	com/google/android/gms/b/ho:a	(Ljava/util/concurrent/Callable;)Lcom/google/android/gms/b/ih;
    //   216: astore 11
    //   218: aload 8
    //   220: astore 10
    //   222: invokestatic 185	com/google/android/gms/ads/internal/P:k	()Lcom/google/android/gms/b/gI;
    //   225: aload_0
    //   226: invokevirtual 190	com/google/android/gms/b/gI:a	(Landroid/content/Context;)Lcom/google/android/gms/b/gG;
    //   229: astore 12
    //   231: aload 12
    //   233: getfield 195	com/google/android/gms/b/gG:m	I
    //   236: iconst_m1
    //   237: if_icmpne +17 -> 254
    //   240: ldc 197
    //   242: invokestatic 83	com/google/android/gms/b/hc:a	(Ljava/lang/String;)V
    //   245: new 199	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   248: dup
    //   249: iconst_2
    //   250: invokespecial 202	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   253: areturn
    //   254: aload 4
    //   256: getfield 129	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:a	I
    //   259: bipush 7
    //   261: if_icmplt +69 -> 330
    //   264: aload 4
    //   266: getfield 205	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:w	Ljava/lang/String;
    //   269: astore 13
    //   271: new 207	com/google/android/gms/b/gB
    //   274: dup
    //   275: aload 13
    //   277: aload 4
    //   279: getfield 210	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:f	Landroid/content/pm/ApplicationInfo;
    //   282: getfield 215	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   285: invokespecial 218	com/google/android/gms/b/gB:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: astore 14
    //   290: aload 4
    //   292: getfield 221	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:c	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   295: getfield 225	com/google/android/gms/ads/internal/client/AdRequestParcel:c	Landroid/os/Bundle;
    //   298: ifnull +43 -> 341
    //   301: aload 4
    //   303: getfield 221	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:c	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   306: getfield 225	com/google/android/gms/ads/internal/client/AdRequestParcel:c	Landroid/os/Bundle;
    //   309: ldc 227
    //   311: invokevirtual 231	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   314: astore 51
    //   316: aload 51
    //   318: ifnull +23 -> 341
    //   321: aload_0
    //   322: aload 4
    //   324: aload 51
    //   326: invokestatic 236	com/google/android/gms/b/gA:a	(Landroid/content/Context;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Ljava/lang/String;)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   329: areturn
    //   330: invokestatic 242	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   333: invokevirtual 245	java/util/UUID:toString	()Ljava/lang/String;
    //   336: astore 13
    //   338: goto -67 -> 271
    //   341: aload 4
    //   343: getfield 247	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:e	Ljava/lang/String;
    //   346: pop
    //   347: aload 4
    //   349: getfield 251	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:g	Landroid/content/pm/PackageInfo;
    //   352: getfield 254	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   355: pop
    //   356: aload_3
    //   357: getfield 257	com/google/android/gms/b/gp:b	Lcom/google/android/gms/b/at;
    //   360: aload 4
    //   362: invokevirtual 262	com/google/android/gms/b/at:a	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)Ljava/util/List;
    //   365: astore 17
    //   367: aload_3
    //   368: getfield 265	com/google/android/gms/b/gp:f	Lcom/google/android/gms/b/gR;
    //   371: aload 4
    //   373: invokevirtual 270	com/google/android/gms/b/gR:a	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)Ljava/lang/String;
    //   376: astore 18
    //   378: aload 11
    //   380: ifnull +45 -> 425
    //   383: ldc_w 272
    //   386: invokestatic 168	com/google/android/gms/b/hc:e	(Ljava/lang/String;)V
    //   389: getstatic 275	com/google/android/gms/b/aD:F	Lcom/google/android/gms/b/au;
    //   392: astore 49
    //   394: aload 11
    //   396: invokestatic 100	com/google/android/gms/ads/internal/P:n	()Lcom/google/android/gms/b/aB;
    //   399: aload 49
    //   401: invokevirtual 105	com/google/android/gms/b/aB:a	(Lcom/google/android/gms/b/au;)Ljava/lang/Object;
    //   404: checkcast 277	java/lang/Long
    //   407: invokevirtual 281	java/lang/Long:longValue	()J
    //   410: getstatic 287	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   413: invokeinterface 293 4 0
    //   418: pop
    //   419: ldc_w 295
    //   422: invokestatic 168	com/google/android/gms/b/hc:e	(Ljava/lang/String;)V
    //   425: aload 4
    //   427: aload 12
    //   429: aconst_null
    //   430: aconst_null
    //   431: aload 18
    //   433: aload 17
    //   435: aload 10
    //   437: invokestatic 298	com/google/android/gms/b/gA:a	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Lcom/google/android/gms/b/gG;Lcom/google/android/gms/drive/e;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;)Lorg/json/JSONObject;
    //   440: astore 19
    //   442: aload 4
    //   444: getfield 129	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:a	I
    //   447: bipush 7
    //   449: if_icmpge +14 -> 463
    //   452: aload 19
    //   454: ldc_w 300
    //   457: aload 13
    //   459: invokevirtual 306	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   462: pop
    //   463: aload 19
    //   465: ifnonnull +36 -> 501
    //   468: new 199	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   471: dup
    //   472: iconst_0
    //   473: invokespecial 202	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   476: areturn
    //   477: astore 47
    //   479: ldc_w 308
    //   482: aload 47
    //   484: invokestatic 311	com/google/android/gms/b/hc:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   487: goto -62 -> 425
    //   490: astore 48
    //   492: ldc_w 313
    //   495: invokestatic 83	com/google/android/gms/b/hc:a	(Ljava/lang/String;)V
    //   498: goto -73 -> 425
    //   501: aload 19
    //   503: invokevirtual 314	org/json/JSONObject:toString	()Ljava/lang/String;
    //   506: astore 20
    //   508: aload 6
    //   510: aload 7
    //   512: iconst_1
    //   513: anewarray 140	java/lang/String
    //   516: dup
    //   517: iconst_0
    //   518: ldc_w 316
    //   521: aastore
    //   522: invokevirtual 145	com/google/android/gms/b/aR:a	(Lcom/google/android/gms/b/aN;[Ljava/lang/String;)Z
    //   525: pop
    //   526: aload 6
    //   528: invokevirtual 148	com/google/android/gms/b/aR:a	()Lcom/google/android/gms/b/aN;
    //   531: astore 22
    //   533: getstatic 318	com/google/android/gms/b/aD:b	Lcom/google/android/gms/b/au;
    //   536: astore 23
    //   538: invokestatic 100	com/google/android/gms/ads/internal/P:n	()Lcom/google/android/gms/b/aB;
    //   541: aload 23
    //   543: invokevirtual 105	com/google/android/gms/b/aB:a	(Lcom/google/android/gms/b/au;)Ljava/lang/Object;
    //   546: checkcast 107	java/lang/Boolean
    //   549: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   552: ifeq +85 -> 637
    //   555: getstatic 323	com/google/android/gms/b/hu:a	Landroid/os/Handler;
    //   558: new 325	com/google/android/gms/b/gs
    //   561: dup
    //   562: aload_1
    //   563: aload 14
    //   565: aload 6
    //   567: aload 22
    //   569: aload 20
    //   571: invokespecial 328	com/google/android/gms/b/gs:<init>	(Lcom/google/android/gms/b/du;Lcom/google/android/gms/b/gB;Lcom/google/android/gms/b/aR;Lcom/google/android/gms/b/aN;Ljava/lang/String;)V
    //   574: invokevirtual 334	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   577: pop
    //   578: aload 14
    //   580: invokevirtual 337	com/google/android/gms/b/gB:a	()Ljava/util/concurrent/Future;
    //   583: ldc2_w 338
    //   586: getstatic 342	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   589: invokeinterface 293 4 0
    //   594: checkcast 344	com/google/android/gms/b/gF
    //   597: astore 30
    //   599: aload 30
    //   601: ifnonnull +100 -> 701
    //   604: new 199	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   607: dup
    //   608: iconst_0
    //   609: invokespecial 202	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   612: astore 42
    //   614: getstatic 323	com/google/android/gms/b/hu:a	Landroid/os/Handler;
    //   617: new 346	com/google/android/gms/b/gw
    //   620: dup
    //   621: aload_3
    //   622: aload_0
    //   623: aload 14
    //   625: aload 4
    //   627: invokespecial 349	com/google/android/gms/b/gw:<init>	(Lcom/google/android/gms/b/gp;Landroid/content/Context;Lcom/google/android/gms/b/gB;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   630: invokevirtual 334	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   633: pop
    //   634: aload 42
    //   636: areturn
    //   637: getstatic 323	com/google/android/gms/b/hu:a	Landroid/os/Handler;
    //   640: new 351	com/google/android/gms/b/gv
    //   643: dup
    //   644: aload_0
    //   645: aload 4
    //   647: aload 14
    //   649: aload 6
    //   651: aload 22
    //   653: aload 20
    //   655: aload_2
    //   656: invokespecial 354	com/google/android/gms/b/gv:<init>	(Landroid/content/Context;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Lcom/google/android/gms/b/gB;Lcom/google/android/gms/b/aR;Lcom/google/android/gms/b/aN;Ljava/lang/String;Lcom/google/android/gms/b/as;)V
    //   659: invokevirtual 334	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   662: pop
    //   663: goto -85 -> 578
    //   666: astore 27
    //   668: new 199	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   671: dup
    //   672: iconst_0
    //   673: invokespecial 202	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   676: astore 28
    //   678: getstatic 323	com/google/android/gms/b/hu:a	Landroid/os/Handler;
    //   681: new 346	com/google/android/gms/b/gw
    //   684: dup
    //   685: aload_3
    //   686: aload_0
    //   687: aload 14
    //   689: aload 4
    //   691: invokespecial 349	com/google/android/gms/b/gw:<init>	(Lcom/google/android/gms/b/gp;Landroid/content/Context;Lcom/google/android/gms/b/gB;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   694: invokevirtual 334	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   697: pop
    //   698: aload 28
    //   700: areturn
    //   701: aload 30
    //   703: invokevirtual 357	com/google/android/gms/b/gF:a	()I
    //   706: bipush 254
    //   708: if_icmpeq +40 -> 748
    //   711: new 199	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   714: dup
    //   715: aload 30
    //   717: invokevirtual 357	com/google/android/gms/b/gF:a	()I
    //   720: invokespecial 202	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   723: astore 31
    //   725: getstatic 323	com/google/android/gms/b/hu:a	Landroid/os/Handler;
    //   728: new 346	com/google/android/gms/b/gw
    //   731: dup
    //   732: aload_3
    //   733: aload_0
    //   734: aload 14
    //   736: aload 4
    //   738: invokespecial 349	com/google/android/gms/b/gw:<init>	(Lcom/google/android/gms/b/gp;Landroid/content/Context;Lcom/google/android/gms/b/gB;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   741: invokevirtual 334	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   744: pop
    //   745: aload 31
    //   747: areturn
    //   748: aload 6
    //   750: invokevirtual 359	com/google/android/gms/b/aR:e	()Lcom/google/android/gms/b/aN;
    //   753: ifnull +24 -> 777
    //   756: aload 6
    //   758: aload 6
    //   760: invokevirtual 359	com/google/android/gms/b/aR:e	()Lcom/google/android/gms/b/aN;
    //   763: iconst_1
    //   764: anewarray 140	java/lang/String
    //   767: dup
    //   768: iconst_0
    //   769: ldc_w 361
    //   772: aastore
    //   773: invokevirtual 145	com/google/android/gms/b/aR:a	(Lcom/google/android/gms/b/aN;[Ljava/lang/String;)Z
    //   776: pop
    //   777: aload 30
    //   779: invokevirtual 363	com/google/android/gms/b/gF:f	()Z
    //   782: ifeq +12 -> 794
    //   785: aload 4
    //   787: getfield 251	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:g	Landroid/content/pm/PackageInfo;
    //   790: getfield 254	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   793: pop
    //   794: aload 4
    //   796: getfield 366	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:k	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   799: getfield 367	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:b	Ljava/lang/String;
    //   802: astore 33
    //   804: aload 30
    //   806: invokevirtual 369	com/google/android/gms/b/gF:d	()Ljava/lang/String;
    //   809: astore 34
    //   811: aload 30
    //   813: invokevirtual 372	com/google/android/gms/b/gF:h	()Z
    //   816: pop
    //   817: aload 4
    //   819: aload_0
    //   820: aload 33
    //   822: aload 34
    //   824: aconst_null
    //   825: aconst_null
    //   826: aload 30
    //   828: aload 6
    //   830: aload_3
    //   831: invokestatic 375	com/google/android/gms/b/gq:a	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/b/gF;Lcom/google/android/gms/b/aR;Lcom/google/android/gms/b/gp;)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   834: astore 36
    //   836: aload 36
    //   838: getfield 378	com/google/android/gms/ads/internal/request/AdResponseParcel:x	I
    //   841: iconst_1
    //   842: if_icmpne +12 -> 854
    //   845: aload 4
    //   847: getfield 251	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:g	Landroid/content/pm/PackageInfo;
    //   850: getfield 254	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   853: pop
    //   854: aload 6
    //   856: aload 7
    //   858: iconst_1
    //   859: anewarray 140	java/lang/String
    //   862: dup
    //   863: iconst_0
    //   864: ldc_w 380
    //   867: aastore
    //   868: invokevirtual 145	com/google/android/gms/b/aR:a	(Lcom/google/android/gms/b/aN;[Ljava/lang/String;)Z
    //   871: pop
    //   872: aload 36
    //   874: aload 6
    //   876: invokevirtual 382	com/google/android/gms/b/aR:c	()Ljava/lang/String;
    //   879: putfield 385	com/google/android/gms/ads/internal/request/AdResponseParcel:z	Ljava/lang/String;
    //   882: getstatic 323	com/google/android/gms/b/hu:a	Landroid/os/Handler;
    //   885: new 346	com/google/android/gms/b/gw
    //   888: dup
    //   889: aload_3
    //   890: aload_0
    //   891: aload 14
    //   893: aload 4
    //   895: invokespecial 349	com/google/android/gms/b/gw:<init>	(Lcom/google/android/gms/b/gp;Landroid/content/Context;Lcom/google/android/gms/b/gB;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   898: invokevirtual 334	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   901: pop
    //   902: aload 36
    //   904: areturn
    //   905: astore 25
    //   907: getstatic 323	com/google/android/gms/b/hu:a	Landroid/os/Handler;
    //   910: new 346	com/google/android/gms/b/gw
    //   913: dup
    //   914: aload_3
    //   915: aload_0
    //   916: aload 14
    //   918: aload 4
    //   920: invokespecial 349	com/google/android/gms/b/gw:<init>	(Lcom/google/android/gms/b/gp;Landroid/content/Context;Lcom/google/android/gms/b/gB;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   923: invokevirtual 334	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   926: pop
    //   927: aload 25
    //   929: athrow
    //   930: astore 45
    //   932: goto -469 -> 463
    //   935: astore 47
    //   937: goto -458 -> 479
    //   940: aload 8
    //   942: astore 10
    //   944: aconst_null
    //   945: astore 11
    //   947: goto -725 -> 222
    //   950: aload 8
    //   952: astore 10
    //   954: aconst_null
    //   955: astore 11
    //   957: goto -735 -> 222
    //   960: aconst_null
    //   961: astore 8
    //   963: goto -838 -> 125
    //
    // Exception table:
    //   from	to	target	type
    //   383	425	477	java/lang/InterruptedException
    //   383	425	490	java/util/concurrent/TimeoutException
    //   578	599	666	java/lang/Exception
    //   578	599	905	finally
    //   604	614	905	finally
    //   668	678	905	finally
    //   701	725	905	finally
    //   748	777	905	finally
    //   777	794	905	finally
    //   794	854	905	finally
    //   854	882	905	finally
    //   452	463	930	org/json/JSONException
    //   383	425	935	java/util/concurrent/ExecutionException
  }

  // ERROR //
  public static AdResponseParcel a(AdRequestInfoParcel paramAdRequestInfoParcel, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, gF paramgF, aR paramaR, gp paramgp)
  {
    // Byte code:
    //   0: aload 7
    //   2: ifnull +335 -> 337
    //   5: aload 7
    //   7: invokevirtual 148	com/google/android/gms/b/aR:a	()Lcom/google/android/gms/b/aN;
    //   10: astore 9
    //   12: new 389	com/google/android/gms/b/gE
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 392	com/google/android/gms/b/gE:<init>	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   20: astore 10
    //   22: new 394	java/lang/StringBuilder
    //   25: dup
    //   26: ldc_w 396
    //   29: invokespecial 398	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: aload_3
    //   33: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 83	com/google/android/gms/b/hc:a	(Ljava/lang/String;)V
    //   42: new 405	java/net/URL
    //   45: dup
    //   46: aload_3
    //   47: invokespecial 406	java/net/URL:<init>	(Ljava/lang/String;)V
    //   50: astore 12
    //   52: invokestatic 409	com/google/android/gms/ads/internal/P:i	()Lcom/google/android/gms/b/ju;
    //   55: invokeinterface 413 1 0
    //   60: lstore 13
    //   62: iconst_0
    //   63: istore 15
    //   65: aload 12
    //   67: astore 16
    //   69: aload 16
    //   71: invokevirtual 417	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   74: checkcast 419	java/net/HttpURLConnection
    //   77: astore 17
    //   79: invokestatic 422	com/google/android/gms/ads/internal/P:e	()Lcom/google/android/gms/b/hu;
    //   82: aload_1
    //   83: aload_2
    //   84: iconst_0
    //   85: aload 17
    //   87: invokevirtual 425	com/google/android/gms/b/hu:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
    //   90: aload 4
    //   92: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne +13 -> 108
    //   98: aload 17
    //   100: ldc_w 433
    //   103: aload 4
    //   105: invokevirtual 436	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload 5
    //   110: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne +29 -> 142
    //   116: aload 17
    //   118: ldc_w 438
    //   121: new 394	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 440
    //   128: invokespecial 398	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload 5
    //   133: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokevirtual 436	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload 6
    //   144: ifnull +64 -> 208
    //   147: aload 6
    //   149: invokevirtual 441	com/google/android/gms/b/gF:c	()Ljava/lang/String;
    //   152: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +53 -> 208
    //   158: aload 17
    //   160: iconst_1
    //   161: invokevirtual 445	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   164: aload 6
    //   166: invokevirtual 441	com/google/android/gms/b/gF:c	()Ljava/lang/String;
    //   169: invokevirtual 449	java/lang/String:getBytes	()[B
    //   172: astore 34
    //   174: aload 17
    //   176: aload 34
    //   178: arraylength
    //   179: invokevirtual 452	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   182: new 454	java/io/BufferedOutputStream
    //   185: dup
    //   186: aload 17
    //   188: invokevirtual 458	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   191: invokespecial 461	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   194: astore 35
    //   196: aload 35
    //   198: aload 34
    //   200: invokevirtual 465	java/io/BufferedOutputStream:write	([B)V
    //   203: aload 35
    //   205: invokestatic 470	android/support/v4/app/j:a	(Ljava/io/Closeable;)V
    //   208: aload 17
    //   210: invokevirtual 473	java/net/HttpURLConnection:getResponseCode	()I
    //   213: istore 19
    //   215: aload 17
    //   217: invokevirtual 477	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   220: astore 20
    //   222: iload 19
    //   224: sipush 200
    //   227: if_icmplt +187 -> 414
    //   230: iload 19
    //   232: sipush 300
    //   235: if_icmpge +179 -> 414
    //   238: aload 16
    //   240: invokevirtual 478	java/net/URL:toString	()Ljava/lang/String;
    //   243: astore 27
    //   245: new 480	java/io/InputStreamReader
    //   248: dup
    //   249: aload 17
    //   251: invokevirtual 484	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   254: invokespecial 487	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   257: astore 28
    //   259: invokestatic 422	com/google/android/gms/ads/internal/P:e	()Lcom/google/android/gms/b/hu;
    //   262: pop
    //   263: aload 28
    //   265: invokestatic 490	com/google/android/gms/b/hu:a	(Ljava/io/InputStreamReader;)Ljava/lang/String;
    //   268: astore 31
    //   270: aload 28
    //   272: invokestatic 470	android/support/v4/app/j:a	(Ljava/io/Closeable;)V
    //   275: aload 27
    //   277: aload 20
    //   279: aload 31
    //   281: iload 19
    //   283: invokestatic 493	com/google/android/gms/b/gq:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   286: aload 10
    //   288: aload 27
    //   290: aload 20
    //   292: aload 31
    //   294: invokevirtual 496	com/google/android/gms/b/gE:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V
    //   297: aload 7
    //   299: ifnull +21 -> 320
    //   302: aload 7
    //   304: aload 9
    //   306: iconst_1
    //   307: anewarray 140	java/lang/String
    //   310: dup
    //   311: iconst_0
    //   312: ldc_w 498
    //   315: aastore
    //   316: invokevirtual 145	com/google/android/gms/b/aR:a	(Lcom/google/android/gms/b/aN;[Ljava/lang/String;)Z
    //   319: pop
    //   320: aload 10
    //   322: lload 13
    //   324: invokevirtual 501	com/google/android/gms/b/gE:a	(J)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   327: astore 33
    //   329: aload 17
    //   331: invokevirtual 504	java/net/HttpURLConnection:disconnect	()V
    //   334: aload 33
    //   336: areturn
    //   337: aconst_null
    //   338: astore 9
    //   340: goto -328 -> 12
    //   343: astore 36
    //   345: aconst_null
    //   346: astore 35
    //   348: aload 35
    //   350: invokestatic 470	android/support/v4/app/j:a	(Ljava/io/Closeable;)V
    //   353: aload 36
    //   355: athrow
    //   356: astore 18
    //   358: aload 17
    //   360: invokevirtual 504	java/net/HttpURLConnection:disconnect	()V
    //   363: aload 18
    //   365: athrow
    //   366: astore 11
    //   368: new 394	java/lang/StringBuilder
    //   371: dup
    //   372: ldc_w 506
    //   375: invokespecial 398	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: aload 11
    //   380: invokevirtual 509	java/io/IOException:getMessage	()Ljava/lang/String;
    //   383: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 511	com/google/android/gms/b/hc:d	(Ljava/lang/String;)V
    //   392: new 199	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   395: dup
    //   396: iconst_2
    //   397: invokespecial 202	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   400: areturn
    //   401: astore 29
    //   403: aconst_null
    //   404: astore 28
    //   406: aload 28
    //   408: invokestatic 470	android/support/v4/app/j:a	(Ljava/io/Closeable;)V
    //   411: aload 29
    //   413: athrow
    //   414: aload 16
    //   416: invokevirtual 478	java/net/URL:toString	()Ljava/lang/String;
    //   419: aload 20
    //   421: aconst_null
    //   422: iload 19
    //   424: invokestatic 493	com/google/android/gms/b/gq:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   427: iload 19
    //   429: sipush 300
    //   432: if_icmplt +100 -> 532
    //   435: iload 19
    //   437: sipush 400
    //   440: if_icmpge +92 -> 532
    //   443: aload 17
    //   445: ldc_w 513
    //   448: invokevirtual 516	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   451: astore 22
    //   453: aload 22
    //   455: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   458: ifeq +27 -> 485
    //   461: ldc_w 518
    //   464: invokestatic 511	com/google/android/gms/b/hc:d	(Ljava/lang/String;)V
    //   467: new 199	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   470: dup
    //   471: iconst_0
    //   472: invokespecial 202	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   475: astore 26
    //   477: aload 17
    //   479: invokevirtual 504	java/net/HttpURLConnection:disconnect	()V
    //   482: aload 26
    //   484: areturn
    //   485: new 405	java/net/URL
    //   488: dup
    //   489: aload 22
    //   491: invokespecial 406	java/net/URL:<init>	(Ljava/lang/String;)V
    //   494: astore 23
    //   496: iload 15
    //   498: iconst_1
    //   499: iadd
    //   500: istore 24
    //   502: iload 24
    //   504: iconst_5
    //   505: if_icmple +66 -> 571
    //   508: ldc_w 520
    //   511: invokestatic 511	com/google/android/gms/b/hc:d	(Ljava/lang/String;)V
    //   514: new 199	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   517: dup
    //   518: iconst_0
    //   519: invokespecial 202	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   522: astore 25
    //   524: aload 17
    //   526: invokevirtual 504	java/net/HttpURLConnection:disconnect	()V
    //   529: aload 25
    //   531: areturn
    //   532: new 394	java/lang/StringBuilder
    //   535: dup
    //   536: ldc_w 522
    //   539: invokespecial 398	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   542: iload 19
    //   544: invokevirtual 525	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 511	com/google/android/gms/b/hc:d	(Ljava/lang/String;)V
    //   553: new 199	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   556: dup
    //   557: iconst_0
    //   558: invokespecial 202	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   561: astore 21
    //   563: aload 17
    //   565: invokevirtual 504	java/net/HttpURLConnection:disconnect	()V
    //   568: aload 21
    //   570: areturn
    //   571: aload 10
    //   573: aload 20
    //   575: invokevirtual 528	com/google/android/gms/b/gE:a	(Ljava/util/Map;)V
    //   578: aload 17
    //   580: invokevirtual 504	java/net/HttpURLConnection:disconnect	()V
    //   583: aload 8
    //   585: ifnull +14 -> 599
    //   588: iload 24
    //   590: istore 15
    //   592: aload 23
    //   594: astore 16
    //   596: goto -527 -> 69
    //   599: iload 24
    //   601: istore 15
    //   603: aload 23
    //   605: astore 16
    //   607: goto -538 -> 69
    //   610: astore 29
    //   612: goto -206 -> 406
    //   615: astore 36
    //   617: goto -269 -> 348
    //
    // Exception table:
    //   from	to	target	type
    //   182	196	343	finally
    //   79	108	356	finally
    //   108	142	356	finally
    //   147	182	356	finally
    //   203	208	356	finally
    //   208	222	356	finally
    //   238	245	356	finally
    //   270	297	356	finally
    //   302	320	356	finally
    //   320	329	356	finally
    //   348	356	356	finally
    //   406	414	356	finally
    //   414	427	356	finally
    //   443	477	356	finally
    //   485	496	356	finally
    //   508	524	356	finally
    //   532	563	356	finally
    //   571	578	356	finally
    //   12	62	366	java/io/IOException
    //   69	79	366	java/io/IOException
    //   329	334	366	java/io/IOException
    //   358	366	366	java/io/IOException
    //   477	482	366	java/io/IOException
    //   524	529	366	java/io/IOException
    //   563	568	366	java/io/IOException
    //   578	583	366	java/io/IOException
    //   245	259	401	finally
    //   259	270	610	finally
    //   196	203	615	finally
  }

  public static gq a(Context paramContext, as paramas, gp paramgp)
  {
    synchronized (a)
    {
      if (b == null)
      {
        if (paramContext.getApplicationContext() != null)
          paramContext = paramContext.getApplicationContext();
        b = new gq(paramContext, paramas, paramgp);
      }
      gq localgq = b;
      return localgq;
    }
  }

  private static void a(String paramString1, Map paramMap, String paramString2, int paramInt)
  {
    if (hc.a(2))
    {
      hc.e("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        Iterator localIterator1 = paramMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str1 = (String)localIterator1.next();
          hc.e("    " + str1 + ":");
          Iterator localIterator2 = ((List)paramMap.get(str1)).iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            hc.e("      " + str2);
          }
        }
      }
      hc.e("  Body:");
      if (paramString2 != null)
        for (int i = 0; i < Math.min(paramString2.length(), 100000); i += 1000)
          hc.e(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
      hc.e("    null");
      hc.e("  Response Code:\n    " + paramInt + "\n}");
    }
  }

  public final AdResponseParcel a(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    return a(this.c, this.f, this.e, this.d, paramAdRequestInfoParcel);
  }

  public final void a(AdRequestInfoParcel paramAdRequestInfoParcel, y paramy)
  {
    P.h().a(this.c, paramAdRequestInfoParcel.k);
    ho.a(new gz(this, paramAdRequestInfoParcel, paramy));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.gq
 * JD-Core Version:    0.6.0
 */