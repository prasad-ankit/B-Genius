package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.b.hc;
import java.util.Locale;

public final class i
{
  private static final String a = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[] { "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time" });
  private static final Object c = new Object();
  private static i d;
  private final j b;

  private i(Context paramContext)
  {
    this.b = new j(this, paramContext, "google_inapp_purchase.db");
  }

  private static g a(Cursor paramCursor)
  {
    if (paramCursor == null)
      return null;
    return new g(paramCursor.getLong(0), paramCursor.getString(1), paramCursor.getString(2));
  }

  public static i a(Context paramContext)
  {
    synchronized (c)
    {
      if (d == null)
        d = new i(paramContext);
      i locali = d;
      return locali;
    }
  }

  private SQLiteDatabase b()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      hc.d("Error opening writable conversion tracking database");
    }
    return null;
  }

  private int c()
  {
    Cursor localCursor = null;
    SQLiteDatabase localSQLiteDatabase;
    synchronized (c)
    {
      localSQLiteDatabase = b();
      if (localSQLiteDatabase == null)
        return 0;
    }
    try
    {
      localCursor = localSQLiteDatabase.rawQuery("select count(*) from InAppPurchase", null);
      if (localCursor.moveToFirst())
      {
        int i = localCursor.getInt(0);
        if (localCursor != null)
          localCursor.close();
        monitorexit;
        return i;
        localObject2 = finally;
        monitorexit;
        throw localObject2;
      }
      if (localCursor != null)
        localCursor.close();
      monitorexit;
      return 0;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        hc.d("Error getting record count" + localSQLiteException.getMessage());
        if (localCursor == null)
          continue;
        localCursor.close();
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
    throw localObject3;
  }

  // ERROR //
  public final java.util.List a(long paramLong)
  {
    // Byte code:
    //   0: getstatic 45	com/google/android/gms/ads/internal/purchase/i:c	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: new 131	java/util/LinkedList
    //   9: dup
    //   10: invokespecial 132	java/util/LinkedList:<init>	()V
    //   13: astore 4
    //   15: ldc2_w 133
    //   18: lconst_0
    //   19: lcmp
    //   20: ifgt +8 -> 28
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: areturn
    //   28: aload_0
    //   29: invokespecial 93	com/google/android/gms/ads/internal/purchase/i:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore 6
    //   34: aload 6
    //   36: ifnonnull +8 -> 44
    //   39: aload_3
    //   40: monitorexit
    //   41: aload 4
    //   43: areturn
    //   44: aload 6
    //   46: ldc 24
    //   48: aconst_null
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: ldc 136
    //   55: ldc 138
    //   57: invokevirtual 142	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 10
    //   62: aload 10
    //   64: astore 8
    //   66: aload 8
    //   68: invokeinterface 105 1 0
    //   73: ifeq +30 -> 103
    //   76: aload 4
    //   78: aload 8
    //   80: invokestatic 144	com/google/android/gms/ads/internal/purchase/i:a	(Landroid/database/Cursor;)Lcom/google/android/gms/ads/internal/purchase/g;
    //   83: invokeinterface 150 2 0
    //   88: pop
    //   89: aload 8
    //   91: invokeinterface 153 1 0
    //   96: istore 12
    //   98: iload 12
    //   100: ifne -24 -> 76
    //   103: aload 8
    //   105: ifnull +10 -> 115
    //   108: aload 8
    //   110: invokeinterface 112 1 0
    //   115: aload_3
    //   116: monitorexit
    //   117: aload 4
    //   119: areturn
    //   120: astore 9
    //   122: aconst_null
    //   123: astore 8
    //   125: new 114	java/lang/StringBuilder
    //   128: dup
    //   129: ldc 155
    //   131: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: aload 9
    //   136: invokevirtual 121	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   139: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 90	com/google/android/gms/b/hc:d	(Ljava/lang/String;)V
    //   148: aload 8
    //   150: ifnull -35 -> 115
    //   153: aload 8
    //   155: invokeinterface 112 1 0
    //   160: goto -45 -> 115
    //   163: astore 5
    //   165: aload_3
    //   166: monitorexit
    //   167: aload 5
    //   169: athrow
    //   170: astore 7
    //   172: aconst_null
    //   173: astore 8
    //   175: aload 8
    //   177: ifnull +10 -> 187
    //   180: aload 8
    //   182: invokeinterface 112 1 0
    //   187: aload 7
    //   189: athrow
    //   190: astore 7
    //   192: goto -17 -> 175
    //   195: astore 9
    //   197: goto -72 -> 125
    //
    // Exception table:
    //   from	to	target	type
    //   44	62	120	android/database/sqlite/SQLiteException
    //   6	15	163	finally
    //   23	25	163	finally
    //   28	34	163	finally
    //   39	41	163	finally
    //   108	115	163	finally
    //   115	117	163	finally
    //   153	160	163	finally
    //   165	167	163	finally
    //   180	187	163	finally
    //   187	190	163	finally
    //   44	62	170	finally
    //   66	76	190	finally
    //   76	98	190	finally
    //   125	148	190	finally
    //   66	76	195	android/database/sqlite/SQLiteException
    //   76	98	195	android/database/sqlite/SQLiteException
  }

  public final void a(g paramg)
  {
    if (paramg == null)
      return;
    SQLiteDatabase localSQLiteDatabase;
    synchronized (c)
    {
      localSQLiteDatabase = b();
      if (localSQLiteDatabase == null)
        return;
    }
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "purchase_id";
    arrayOfObject[1] = Long.valueOf(paramg.a);
    localSQLiteDatabase.delete("InAppPurchase", String.format(localLocale, "%s = %d", arrayOfObject), null);
    monitorexit;
  }

  // ERROR //
  public final void b(g paramg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: getstatic 45	com/google/android/gms/ads/internal/purchase/i:c	Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: monitorenter
    //   11: aload_0
    //   12: invokespecial 93	com/google/android/gms/ads/internal/purchase/i:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +11 -> 30
    //   22: aload_2
    //   23: monitorexit
    //   24: return
    //   25: astore_3
    //   26: aload_2
    //   27: monitorexit
    //   28: aload_3
    //   29: athrow
    //   30: new 173	android/content/ContentValues
    //   33: dup
    //   34: invokespecial 174	android/content/ContentValues:<init>	()V
    //   37: astore 5
    //   39: aload 5
    //   41: ldc 28
    //   43: aload_1
    //   44: getfield 176	com/google/android/gms/ads/internal/purchase/g:c	Ljava/lang/String;
    //   47: invokevirtual 180	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload 5
    //   52: ldc 30
    //   54: aload_1
    //   55: getfield 182	com/google/android/gms/ads/internal/purchase/g:b	Ljava/lang/String;
    //   58: invokevirtual 180	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload 5
    //   63: ldc 32
    //   65: invokestatic 188	android/os/SystemClock:elapsedRealtime	()J
    //   68: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   71: invokevirtual 191	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   74: aload_1
    //   75: aload 4
    //   77: ldc 24
    //   79: aconst_null
    //   80: aload 5
    //   82: invokevirtual 195	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   85: putfield 159	com/google/android/gms/ads/internal/purchase/g:a	J
    //   88: aload_0
    //   89: invokespecial 197	com/google/android/gms/ads/internal/purchase/i:c	()I
    //   92: i2l
    //   93: ldc2_w 198
    //   96: lcmp
    //   97: ifle +25 -> 122
    //   100: getstatic 45	com/google/android/gms/ads/internal/purchase/i:c	Ljava/lang/Object;
    //   103: astore 6
    //   105: aload 6
    //   107: monitorenter
    //   108: aload_0
    //   109: invokespecial 93	com/google/android/gms/ads/internal/purchase/i:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   112: astore 8
    //   114: aload 8
    //   116: ifnonnull +9 -> 125
    //   119: aload 6
    //   121: monitorexit
    //   122: aload_2
    //   123: monitorexit
    //   124: return
    //   125: aload 8
    //   127: ldc 24
    //   129: aconst_null
    //   130: aconst_null
    //   131: aconst_null
    //   132: aconst_null
    //   133: aconst_null
    //   134: ldc 136
    //   136: ldc 201
    //   138: invokevirtual 142	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   141: astore 12
    //   143: aload 12
    //   145: astore 10
    //   147: aload 10
    //   149: ifnull +22 -> 171
    //   152: aload 10
    //   154: invokeinterface 105 1 0
    //   159: ifeq +12 -> 171
    //   162: aload_0
    //   163: aload 10
    //   165: invokestatic 144	com/google/android/gms/ads/internal/purchase/i:a	(Landroid/database/Cursor;)Lcom/google/android/gms/ads/internal/purchase/g;
    //   168: invokevirtual 203	com/google/android/gms/ads/internal/purchase/i:a	(Lcom/google/android/gms/ads/internal/purchase/g;)V
    //   171: aload 10
    //   173: ifnull +10 -> 183
    //   176: aload 10
    //   178: invokeinterface 112 1 0
    //   183: aload 6
    //   185: monitorexit
    //   186: goto -64 -> 122
    //   189: astore 7
    //   191: aload 6
    //   193: monitorexit
    //   194: aload 7
    //   196: athrow
    //   197: astore 11
    //   199: aconst_null
    //   200: astore 10
    //   202: new 114	java/lang/StringBuilder
    //   205: dup
    //   206: ldc 205
    //   208: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: aload 11
    //   213: invokevirtual 121	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   216: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 90	com/google/android/gms/b/hc:d	(Ljava/lang/String;)V
    //   225: aload 10
    //   227: ifnull -44 -> 183
    //   230: aload 10
    //   232: invokeinterface 112 1 0
    //   237: goto -54 -> 183
    //   240: aload 10
    //   242: ifnull +10 -> 252
    //   245: aload 10
    //   247: invokeinterface 112 1 0
    //   252: aload 9
    //   254: athrow
    //   255: astore 9
    //   257: goto -17 -> 240
    //   260: astore 11
    //   262: goto -60 -> 202
    //   265: astore 9
    //   267: aconst_null
    //   268: astore 10
    //   270: goto -30 -> 240
    //
    // Exception table:
    //   from	to	target	type
    //   11	17	25	finally
    //   22	24	25	finally
    //   26	28	25	finally
    //   30	108	25	finally
    //   122	124	25	finally
    //   194	197	25	finally
    //   108	114	189	finally
    //   119	122	189	finally
    //   176	183	189	finally
    //   183	186	189	finally
    //   191	194	189	finally
    //   230	237	189	finally
    //   245	252	189	finally
    //   252	255	189	finally
    //   125	143	197	android/database/sqlite/SQLiteException
    //   152	171	255	finally
    //   202	225	255	finally
    //   152	171	260	android/database/sqlite/SQLiteException
    //   125	143	265	finally
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.i
 * JD-Core Version:    0.6.0
 */