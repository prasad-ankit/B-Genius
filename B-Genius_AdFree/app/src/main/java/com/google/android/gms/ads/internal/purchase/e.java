package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.fr;
import com.google.android.gms.b.gW;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hn;
import com.google.android.gms.b.hu;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e extends fr
{
  private String a;
  private Context b;
  private String c;
  private ArrayList d;

  public e(String paramString1, ArrayList paramArrayList, Context paramContext, String paramString2)
  {
    this.c = paramString1;
    this.d = paramArrayList;
    this.a = paramString2;
    this.b = paramContext;
  }

  private String a(String paramString, HashMap paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/google/android/gms/ads/internal/purchase/e:b	Landroid/content/Context;
    //   4: invokevirtual 33	android/content/Context:getPackageName	()Ljava/lang/String;
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 24	com/google/android/gms/ads/internal/purchase/e:b	Landroid/content/Context;
    //   12: invokevirtual 37	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   15: aload_3
    //   16: iconst_0
    //   17: invokevirtual 43	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   20: getfield 48	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   23: astore 25
    //   25: aload 25
    //   27: astore 5
    //   29: invokestatic 54	com/google/android/gms/ads/internal/P:h	()Lcom/google/android/gms/b/hn;
    //   32: invokevirtual 59	com/google/android/gms/b/hn:d	()Lcom/google/android/gms/b/gW;
    //   35: invokevirtual 64	com/google/android/gms/b/gW:a	()J
    //   38: lstore 6
    //   40: invokestatic 69	android/os/SystemClock:elapsedRealtime	()J
    //   43: lload 6
    //   45: lsub
    //   46: lstore 8
    //   48: aload_2
    //   49: invokevirtual 75	java/util/HashMap:keySet	()Ljava/util/Set;
    //   52: invokeinterface 81 1 0
    //   57: astore 10
    //   59: aload 10
    //   61: invokeinterface 87 1 0
    //   66: ifeq +80 -> 146
    //   69: aload 10
    //   71: invokeinterface 91 1 0
    //   76: checkcast 93	java/lang/String
    //   79: astore 22
    //   81: ldc 95
    //   83: iconst_1
    //   84: anewarray 97	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload 22
    //   91: aastore
    //   92: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   95: astore 23
    //   97: iconst_1
    //   98: anewarray 97	java/lang/Object
    //   101: astore 24
    //   103: aload 24
    //   105: iconst_0
    //   106: aload_2
    //   107: aload 22
    //   109: invokevirtual 105	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: aastore
    //   113: aload_1
    //   114: aload 23
    //   116: ldc 107
    //   118: aload 24
    //   120: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   123: invokevirtual 111	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   126: astore_1
    //   127: goto -68 -> 59
    //   130: astore 4
    //   132: ldc 113
    //   134: aload 4
    //   136: invokestatic 118	com/google/android/gms/b/hc:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   139: ldc 120
    //   141: astore 5
    //   143: goto -114 -> 29
    //   146: ldc 95
    //   148: iconst_1
    //   149: anewarray 97	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: ldc 122
    //   156: aastore
    //   157: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: astore 11
    //   162: iconst_1
    //   163: anewarray 97	java/lang/Object
    //   166: astore 12
    //   168: aload 12
    //   170: iconst_0
    //   171: invokestatic 54	com/google/android/gms/ads/internal/P:h	()Lcom/google/android/gms/b/hn;
    //   174: invokevirtual 124	com/google/android/gms/b/hn:a	()Ljava/lang/String;
    //   177: aastore
    //   178: aload_1
    //   179: aload 11
    //   181: ldc 107
    //   183: aload 12
    //   185: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   188: invokevirtual 111	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   191: ldc 95
    //   193: iconst_1
    //   194: anewarray 97	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: ldc 126
    //   201: aastore
    //   202: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   205: ldc 107
    //   207: iconst_1
    //   208: anewarray 97	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload_3
    //   214: aastore
    //   215: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   218: invokevirtual 111	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   221: astore 13
    //   223: ldc 95
    //   225: iconst_1
    //   226: anewarray 97	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: ldc 128
    //   233: aastore
    //   234: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   237: astore 14
    //   239: iconst_1
    //   240: anewarray 97	java/lang/Object
    //   243: astore 15
    //   245: aload 15
    //   247: iconst_0
    //   248: getstatic 134	android/os/Build$VERSION:SDK_INT	I
    //   251: invokestatic 138	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   254: aastore
    //   255: aload 13
    //   257: aload 14
    //   259: ldc 107
    //   261: aload 15
    //   263: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   266: invokevirtual 111	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   269: astore 16
    //   271: ldc 95
    //   273: iconst_1
    //   274: anewarray 97	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: ldc 140
    //   281: aastore
    //   282: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   285: astore 17
    //   287: iconst_1
    //   288: anewarray 97	java/lang/Object
    //   291: astore 18
    //   293: aload 18
    //   295: iconst_0
    //   296: aload_0
    //   297: getfield 22	com/google/android/gms/ads/internal/purchase/e:a	Ljava/lang/String;
    //   300: aastore
    //   301: aload 16
    //   303: aload 17
    //   305: ldc 107
    //   307: aload 18
    //   309: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   312: invokevirtual 111	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   315: ldc 95
    //   317: iconst_1
    //   318: anewarray 97	java/lang/Object
    //   321: dup
    //   322: iconst_0
    //   323: ldc 142
    //   325: aastore
    //   326: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   329: ldc 107
    //   331: iconst_1
    //   332: anewarray 97	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: aload 5
    //   339: aastore
    //   340: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   343: invokevirtual 111	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   346: astore 19
    //   348: ldc 95
    //   350: iconst_1
    //   351: anewarray 97	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: ldc 144
    //   358: aastore
    //   359: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   362: astore 20
    //   364: iconst_1
    //   365: anewarray 97	java/lang/Object
    //   368: astore 21
    //   370: aload 21
    //   372: iconst_0
    //   373: lload 8
    //   375: invokestatic 147	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   378: aastore
    //   379: aload 19
    //   381: aload 20
    //   383: ldc 107
    //   385: aload 21
    //   387: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   390: invokevirtual 111	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   393: ldc 95
    //   395: iconst_1
    //   396: anewarray 97	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: ldc 149
    //   403: aastore
    //   404: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   407: ldc 107
    //   409: iconst_1
    //   410: anewarray 97	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: ldc 120
    //   417: aastore
    //   418: invokestatic 101	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   421: invokevirtual 111	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   424: ldc 151
    //   426: ldc 153
    //   428: invokevirtual 111	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   431: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   8	25	130	android/content/pm/PackageManager$NameNotFoundException
  }

  private void b()
  {
    try
    {
      Class localClass = this.b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter");
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = Context.class;
      arrayOfClass[1] = String.class;
      arrayOfClass[2] = String.class;
      arrayOfClass[3] = Boolean.TYPE;
      Method localMethod = localClass.getDeclaredMethod("reportWithProductId", arrayOfClass);
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = this.b;
      arrayOfObject[1] = this.c;
      arrayOfObject[2] = "";
      arrayOfObject[3] = Boolean.valueOf(true);
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      hc.d("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      hc.d("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      return;
    }
    catch (Exception localException)
    {
      hc.c("Fail to report a conversion.", localException);
    }
  }

  public final String a()
  {
    return this.c;
  }

  public final void a(int paramInt)
  {
    if (paramInt == 1)
      b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", String.valueOf(paramInt));
    localHashMap.put("sku", this.c);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      localLinkedList.add(a((String)localIterator.next(), localHashMap));
    P.e();
    hu.a(this.b, this.a, localLinkedList);
  }

  public final void b(int paramInt)
  {
    int i = 1;
    if (paramInt == 0)
      b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("google_play_status", String.valueOf(paramInt));
    localHashMap.put("sku", this.c);
    if (paramInt == 0);
    LinkedList localLinkedList;
    while (true)
    {
      localHashMap.put("status", String.valueOf(i));
      localLinkedList = new LinkedList();
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
        localLinkedList.add(a((String)localIterator.next(), localHashMap));
      if (paramInt == i)
      {
        i = 2;
        continue;
      }
      if (paramInt == 4)
      {
        i = 3;
        continue;
      }
      i = 0;
    }
    P.e();
    hu.a(this.b, this.a, localLinkedList);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.e
 * JD-Core Version:    0.6.0
 */