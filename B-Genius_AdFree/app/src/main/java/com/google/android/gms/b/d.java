package com.google.android.gms.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.ads.b;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class d
{
  int A;
  int B;
  int C;
  int D;
  int E;
  int F;
  int G;
  int H;
  int I;
  int J;
  int K;
  int L;
  int M;
  int N;
  int O;
  int P;
  int Q;
  int R;
  int S;
  int T;
  int U;
  int V;
  int W;
  int X;
  int Y;
  int Z;
  int a;
  int aA;
  int aB;
  int aC;
  int aD;
  int aE;
  int aF;
  int aG;
  int aH;
  int aI;
  int aJ;
  int aK;
  int aL;
  int aM;
  int aN;
  int aO;
  int aP;
  int aQ;
  int aR;
  int aS;
  int aT;
  int aU;
  int aV;
  int aW;
  int aX;
  int aY;
  int aZ;
  int aa;
  int ab;
  int ac;
  int ad;
  int ae;
  int af;
  int ag;
  int ah;
  int ai;
  int aj;
  int ak;
  int al;
  int am;
  int an;
  int ao;
  int ap;
  int aq;
  int ar;
  int as;
  int at;
  int au;
  int av;
  int aw;
  int ax;
  int ay;
  int az;
  int b;
  int bA;
  int bB;
  int bC;
  int bD;
  int bE;
  int bF;
  int bG;
  int bH;
  int bI;
  int bJ;
  int bK;
  int bL;
  int bM;
  int bN;
  int bO;
  int bP;
  int bQ;
  int bR;
  int bS;
  int bT;
  int bU;
  int bV;
  int bW;
  int bX;
  int bY;
  int bZ;
  int ba;
  int bb;
  int bc;
  int bd;
  int be;
  int bf;
  int bg;
  int bh;
  int bi;
  int bj;
  int bk;
  int bl;
  int bm;
  int bn;
  int bo;
  int bp;
  int bq;
  int br;
  int bs;
  int bt;
  int bu;
  int bv;
  int bw;
  int bx;
  int by;
  int bz;
  int c;
  int cA;
  int cB;
  int cC;
  int cD;
  int cE;
  int cF;
  int cG;
  int cH;
  int cI;
  int cJ;
  int cK;
  int cL;
  int cM;
  private e[] cN;
  int ca;
  int cb;
  int cc;
  int cd;
  int ce;
  int cf;
  int cg;
  int ch;
  int ci;
  int cj;
  int ck;
  int cl;
  int cm;
  int cn;
  int co;
  int cp;
  int cq;
  int cr;
  int cs;
  int ct;
  int cu;
  int cv;
  int cw;
  int cx;
  int cy;
  int cz;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  int r;
  int s;
  int t;
  int u;
  int v;
  int w;
  int x;
  int y;
  int z;

  public d()
  {
    e[] arrayOfe = new e[12];
    arrayOfe[0] = new f(this, 0);
    arrayOfe[1] = new g(this, 0);
    arrayOfe[2] = new j(this, 0);
    arrayOfe[3] = new k(this, 0);
    arrayOfe[4] = new l(this, 0);
    arrayOfe[5] = new m(this, 0);
    arrayOfe[6] = new n(this, 0);
    arrayOfe[7] = new o(this, 0);
    arrayOfe[8] = new p(this, 0);
    arrayOfe[9] = new q(this, 0);
    arrayOfe[10] = new h(this, 0);
    arrayOfe[11] = new i(this, 0);
    this.cN = arrayOfe;
  }

  public static int a(b paramb)
  {
    switch (eM.a[paramb.ordinal()])
    {
    default:
      return 0;
    case 2:
      return 1;
    case 3:
      return 2;
    case 4:
    }
    return 3;
  }

  public static int a(String paramString)
  {
    byte[] arrayOfByte1;
    int i1;
    int i2;
    int i4;
    int i6;
    int i8;
    try
    {
      byte[] arrayOfByte2 = paramString.getBytes("UTF-8");
      arrayOfByte1 = arrayOfByte2;
      i1 = arrayOfByte1.length;
      i2 = 0 + (i1 & 0xFFFFFFFC);
      int i3 = 0;
      int i14;
      for (i4 = 0; i3 < i2; i4 = i14)
      {
        int i12 = -862048943 * (0xFF & arrayOfByte1[i3] | (0xFF & arrayOfByte1[(i3 + 1)]) << 8 | (0xFF & arrayOfByte1[(i3 + 2)]) << 16 | arrayOfByte1[(i3 + 3)] << 24);
        int i13 = i4 ^ 461845907 * (i12 << 15 | i12 >>> 17);
        i14 = -430675100 + 5 * (i13 << 13 | i13 >>> 19);
        i3 += 4;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        arrayOfByte1 = paramString.getBytes();
      int i5 = i1 & 0x3;
      i6 = 0;
      switch (i5)
      {
      default:
        i8 = i4;
      case 3:
      case 2:
      case 1:
      }
    }
    while (true)
    {
      int i9 = i8 ^ i1;
      int i10 = -2048144789 * (i9 ^ i9 >>> 16);
      int i11 = -1028477387 * (i10 ^ i10 >>> 13);
      return i11 ^ i11 >>> 16;
      i6 = (0xFF & arrayOfByte1[(i2 + 2)]) << 16;
      i6 |= (0xFF & arrayOfByte1[(i2 + 1)]) << 8;
      int i7 = -862048943 * (i6 | 0xFF & arrayOfByte1[i2]);
      i8 = i4 ^ 461845907 * (i7 << 15 | i7 >>> 17);
    }
  }

  static long a(long paramLong, int paramInt)
  {
    if (paramInt == 0)
      paramLong = 1L;
    do
      return paramLong;
    while (paramInt == 1);
    if (paramInt % 2 == 0)
      return a(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L;
    return paramLong * (a(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L) % 1073807359L;
  }

  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("admob", 0);
  }

  public static com.google.ads.d a(AdSizeParcel paramAdSizeParcel)
  {
    int i1 = 0;
    com.google.ads.d[] arrayOfd = new com.google.ads.d[6];
    arrayOfd[0] = com.google.ads.d.a;
    arrayOfd[1] = com.google.ads.d.b;
    arrayOfd[2] = com.google.ads.d.c;
    arrayOfd[3] = com.google.ads.d.d;
    arrayOfd[4] = com.google.ads.d.e;
    arrayOfd[5] = com.google.ads.d.f;
    while (i1 < 6)
    {
      if ((arrayOfd[i1].a() == paramAdSizeParcel.f) && (arrayOfd[i1].b() == paramAdSizeParcel.c))
        return arrayOfd[i1];
      i1++;
    }
    return new com.google.ads.d(c.a(paramAdSizeParcel.f, paramAdSizeParcel.c, paramAdSizeParcel.b));
  }

  public static com.google.ads.mediation.h a(AdRequestParcel paramAdRequestParcel)
  {
    HashSet localHashSet;
    Date localDate;
    int i1;
    if (paramAdRequestParcel.e != null)
    {
      localHashSet = new HashSet(paramAdRequestParcel.e);
      localDate = new Date(paramAdRequestParcel.b);
      switch (paramAdRequestParcel.d)
      {
      default:
        i1 = 1;
      case 2:
      case 1:
      }
    }
    while (true)
    {
      return new com.google.ads.mediation.h(localDate, i1, localHashSet, paramAdRequestParcel.f, paramAdRequestParcel.k);
      localHashSet = null;
      break;
      i1 = 3;
      continue;
      i1 = 2;
    }
  }

  public static ih a(List paramList)
  {
    ic localic = new ic();
    int i1 = paramList.size();
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      ((ih)localIterator.next()).a(new if(localAtomicInteger, i1, localic, paramList));
    return localic;
  }

  static String a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (paramArrayOfString.length < paramInt1 + paramInt2)
    {
      hc.b("Unable to construct shingle");
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i1 = paramInt1; i1 < -1 + (paramInt1 + paramInt2); i1++)
    {
      localStringBuffer.append(paramArrayOfString[i1]);
      localStringBuffer.append(' ');
    }
    localStringBuffer.append(paramArrayOfString[(-1 + (paramInt1 + paramInt2))]);
    return localStringBuffer.toString();
  }

  static void a(int paramInt1, long paramLong, String paramString, int paramInt2, PriorityQueue paramPriorityQueue)
  {
    aq localaq = new aq(paramLong, paramString, paramInt2);
    if ((paramPriorityQueue.size() == paramInt1) && (((aq)paramPriorityQueue.peek()).a > localaq.a));
    do
    {
      do
        return;
      while (paramPriorityQueue.contains(localaq));
      paramPriorityQueue.add(localaq);
    }
    while (paramPriorityQueue.size() <= paramInt1);
    paramPriorityQueue.poll();
  }

  public static void a(View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    new io(paramView, paramOnGlobalLayoutListener).a();
  }

  public static void a(View paramView, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    new ip(paramView, paramOnScrollChangedListener).a();
  }

  public static void a(String[] paramArrayOfString, int paramInt1, int paramInt2, PriorityQueue paramPriorityQueue)
  {
    if (paramArrayOfString.length < paramInt2)
      a(paramInt1, b(paramArrayOfString, 0, paramArrayOfString.length), a(paramArrayOfString, 0, paramArrayOfString.length), paramArrayOfString.length, paramPriorityQueue);
    while (true)
    {
      return;
      long l1 = b(paramArrayOfString, 0, paramInt2);
      a(paramInt1, l1, a(paramArrayOfString, 0, paramInt2), paramInt2, paramPriorityQueue);
      long l2 = a(16785407L, paramInt2 - 1);
      for (int i1 = 1; i1 < 1 + (paramArrayOfString.length - paramInt2); i1++)
      {
        int i2 = a(paramArrayOfString[(i1 - 1)]);
        int i3 = a(paramArrayOfString[(-1 + (i1 + paramInt2))]);
        long l3 = l2 * ((2147483647L + i2) % 1073807359L) % 1073807359L;
        l1 = (16785407L * ((l1 + 1073807359L - l3) % 1073807359L) % 1073807359L + (2147483647L + i3) % 1073807359L) % 1073807359L;
        a(paramInt1, l1, a(paramArrayOfString, i1, paramInt2), paramArrayOfString.length, paramPriorityQueue);
      }
    }
  }

  private static long b(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    long l1 = (2147483647L + a(paramArrayOfString[0])) % 1073807359L;
    for (int i1 = 1; i1 < paramInt2 + 0; i1++)
      l1 = (l1 * 16785407L % 1073807359L + (2147483647L + a(paramArrayOfString[i1])) % 1073807359L) % 1073807359L;
    return l1;
  }

  public static String[] b(String paramString)
  {
    if (paramString == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    char[] arrayOfChar = paramString.toCharArray();
    int i1 = paramString.length();
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5;
    int i6;
    int i12;
    label184: int i13;
    label224: int i7;
    label232: int i8;
    int i9;
    if (i4 < i1)
    {
      i5 = Character.codePointAt(arrayOfChar, i4);
      i6 = Character.charCount(i5);
      if (Character.isLetter(i5))
      {
        Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(i5);
        if ((localUnicodeBlock == Character.UnicodeBlock.BOPOMOFO) || (localUnicodeBlock == Character.UnicodeBlock.BOPOMOFO_EXTENDED) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || (localUnicodeBlock == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS) || (localUnicodeBlock == Character.UnicodeBlock.HANGUL_JAMO) || (localUnicodeBlock == Character.UnicodeBlock.HANGUL_SYLLABLES) || (localUnicodeBlock == Character.UnicodeBlock.HIRAGANA) || (localUnicodeBlock == Character.UnicodeBlock.KATAKANA) || (localUnicodeBlock == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS))
        {
          i12 = 1;
          if (i12 == 0)
          {
            if (((i5 < 65382) || (i5 > 65437)) && ((i5 < 65441) || (i5 > 65500)))
              break label314;
            i13 = 1;
            if (i13 == 0)
              break label320;
          }
          i7 = 1;
          if (i7 == 0)
            break label326;
          if (i2 != 0)
            localArrayList.add(new String(arrayOfChar, i3, i4 - i3));
          localArrayList.add(new String(arrayOfChar, i4, i6));
          i8 = i3;
          i9 = 0;
        }
      }
    }
    while (true)
    {
      i4 += i6;
      int i10 = i9;
      i3 = i8;
      i2 = i10;
      break;
      i12 = 0;
      break label184;
      label314: i13 = 0;
      break label224;
      label320: i7 = 0;
      break label232;
      label326: if ((Character.isLetterOrDigit(i5)) || (Character.getType(i5) == 6) || (Character.getType(i5) == 8))
      {
        if (i2 == 0)
          i3 = i4;
        i8 = i3;
        i9 = 1;
        continue;
      }
      if (i2 != 0)
      {
        localArrayList.add(new String(arrayOfChar, i3, i4 - i3));
        i8 = i3;
        i9 = 0;
        continue;
        if (i2 != 0)
          localArrayList.add(new String(arrayOfChar, i3, i4 - i3));
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      int i11 = i2;
      i8 = i3;
      i9 = i11;
    }
  }

  final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    e[] arrayOfe = this.cN;
    int i1 = arrayOfe.length;
    for (int i2 = 0; i2 < i1; i2++)
      arrayOfe[i2].a(paramArrayOfByte1, paramArrayOfByte2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.d
 * JD-Core Version:    0.6.0
 */