package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.b.a;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.PrintWriter;
import java.util.ArrayList;

final class f extends I
  implements Runnable
{
  private static boolean n;
  i a;
  int b;
  int c;
  int d;
  boolean e;
  String f;
  int g = -1;
  int h;
  CharSequence i;
  int j;
  CharSequence k;
  ArrayList l;
  ArrayList m;
  private A o;
  private i p;
  private boolean q;

  static
  {
    if (Build.VERSION.SDK_INT >= 21);
    for (boolean bool = true; ; bool = false)
    {
      n = bool;
      return;
    }
  }

  public f(A paramA)
  {
    this.o = paramA;
  }

  private int a(boolean paramBoolean)
  {
    if (this.q)
      throw new IllegalStateException("commit already called");
    this.q = true;
    if (this.e);
    for (this.g = this.o.a(this); ; this.g = -1)
    {
      this.o.a(this, paramBoolean);
      return this.g;
    }
  }

  private j a(SparseArray paramSparseArray1, SparseArray paramSparseArray2, boolean paramBoolean)
  {
    j localj = new j(this);
    localj.d = new View(this.o.h.a);
    int i1 = 0;
    int i2 = 0;
    int i3 = paramSparseArray1.size();
    int i4 = 0;
    if (i1 < i3)
      if (!a(paramSparseArray1.keyAt(i1), localj, paramBoolean, paramSparseArray1, paramSparseArray2))
        break label145;
    label145: for (int i6 = 1; ; i6 = i2)
    {
      i1++;
      i2 = i6;
      break;
      while (i4 < paramSparseArray2.size())
      {
        int i5 = paramSparseArray2.keyAt(i4);
        if ((paramSparseArray1.get(i5) == null) && (a(i5, localj, paramBoolean, paramSparseArray1, paramSparseArray2)))
          i2 = 1;
        i4++;
      }
      if (i2 == 0)
        localj = null;
      return localj;
    }
  }

  private a a(j paramj, Fragment paramFragment, boolean paramBoolean)
  {
    a locala = new a();
    if (this.l != null)
    {
      d.a(locala, paramFragment.getView());
      if (!paramBoolean)
        break label66;
      locala.a(this.m);
    }
    while (paramBoolean)
    {
      if (paramFragment.mEnterTransitionCallback != null);
      a(paramj, locala, false);
      return locala;
      label66: locala = a(this.l, this.m, locala);
    }
    if (paramFragment.mExitTransitionCallback != null);
    b(paramj, locala, false);
    return locala;
  }

  private static a a(ArrayList paramArrayList1, ArrayList paramArrayList2, a parama)
  {
    if (parama.isEmpty())
      return parama;
    a locala = new a();
    int i1 = paramArrayList1.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = (View)parama.get(paramArrayList1.get(i2));
      if (localView == null)
        continue;
      locala.put(paramArrayList2.get(i2), localView);
    }
    return locala;
  }

  private void a(j paramj, int paramInt, Object paramObject)
  {
    if (this.o.c != null)
    {
      int i1 = 0;
      if (i1 < this.o.c.size())
      {
        Fragment localFragment = (Fragment)this.o.c.get(i1);
        if ((localFragment.mView != null) && (localFragment.mContainer != null) && (localFragment.mContainerId == paramInt))
        {
          if (!localFragment.mHidden)
            break label122;
          if (!paramj.b.contains(localFragment.mView))
          {
            d.a(paramObject, localFragment.mView, true);
            paramj.b.add(localFragment.mView);
          }
        }
        while (true)
        {
          i1++;
          break;
          label122: d.a(paramObject, localFragment.mView, false);
          paramj.b.remove(localFragment.mView);
        }
      }
    }
  }

  private void a(j paramj, a parama, boolean paramBoolean)
  {
    int i1;
    int i2;
    label13: String str1;
    String str2;
    if (this.m == null)
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1)
        return;
      str1 = (String)this.l.get(i2);
      View localView = (View)parama.get((String)this.m.get(i2));
      if (localView != null)
      {
        str2 = localView.getTransitionName();
        if (!paramBoolean)
          break label100;
        a(paramj.a, str1, str2);
      }
    }
    while (true)
    {
      i2++;
      break label13;
      i1 = this.m.size();
      break;
      label100: a(paramj.a, str2, str1);
    }
  }

  private static void a(a parama, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null));
    for (int i1 = 0; i1 < parama.size(); i1++)
    {
      if (!paramString1.equals(parama.c(i1)))
        continue;
      parama.a(i1, paramString2);
      return;
    }
    parama.put(paramString1, paramString2);
  }

  private static void a(SparseArray paramSparseArray, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i1 = paramFragment.mContainerId;
      if ((i1 != 0) && (!paramFragment.isHidden()) && (paramFragment.isAdded()) && (paramFragment.getView() != null) && (paramSparseArray.get(i1) == null))
        paramSparseArray.put(i1, paramFragment);
    }
  }

  private boolean a(int paramInt, j paramj, boolean paramBoolean, SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    ViewGroup localViewGroup = (ViewGroup)this.o.i.a(paramInt);
    if (localViewGroup == null)
      return false;
    Fragment localFragment1 = (Fragment)paramSparseArray2.get(paramInt);
    Fragment localFragment2 = (Fragment)paramSparseArray1.get(paramInt);
    Object localObject2;
    TransitionSet localTransitionSet1;
    if (localFragment1 == null)
    {
      localObject2 = null;
      if ((localFragment1 != null) && (localFragment2 != null))
        break label163;
      localTransitionSet1 = null;
    }
    Object localObject4;
    ArrayList localArrayList1;
    a locala1;
    TransitionSet localTransitionSet2;
    while (true)
    {
      if (localFragment2 != null)
        break label233;
      localObject4 = null;
      localArrayList1 = new ArrayList();
      locala1 = null;
      if (localTransitionSet1 == null)
        break label334;
      locala1 = a(paramj, localFragment2, paramBoolean);
      if (!locala1.isEmpty())
        break label264;
      locala1 = null;
      localTransitionSet2 = null;
      if ((localObject2 != null) || (localTransitionSet2 != null) || (localObject4 != null))
        break label351;
      return false;
      if (paramBoolean);
      for (Object localObject1 = localFragment1.getReenterTransition(); ; localObject1 = localFragment1.getEnterTransition())
      {
        localObject2 = d.a(localObject1);
        break;
      }
      label163: if (paramBoolean);
      for (Object localObject9 = localFragment2.getSharedElementReturnTransition(); ; localObject9 = localFragment1.getSharedElementEnterTransition())
      {
        if (localObject9 != null)
          break label195;
        localTransitionSet1 = null;
        break;
      }
      label195: Transition localTransition7 = (Transition)localObject9;
      if (localTransition7 == null)
      {
        localTransitionSet1 = null;
        continue;
      }
      localTransitionSet1 = new TransitionSet();
      localTransitionSet1.addTransition(localTransition7);
    }
    label233: if (paramBoolean);
    for (Object localObject3 = localFragment2.getReturnTransition(); ; localObject3 = localFragment2.getExitTransition())
    {
      localObject4 = d.a(localObject3);
      break;
    }
    label264: if (paramBoolean);
    for (T localT = localFragment2.mEnterTransitionCallback; ; localT = localFragment1.mEnterTransitionCallback)
    {
      if (localT != null)
      {
        new ArrayList(locala1.keySet());
        new ArrayList(locala1.values());
      }
      localViewGroup.getViewTreeObserver().addOnPreDrawListener(new g(this, localViewGroup, localTransitionSet1, localArrayList1, paramj, paramBoolean, localFragment1, localFragment2));
      label334: localTransitionSet2 = localTransitionSet1;
      break;
    }
    label351: ArrayList localArrayList2 = new ArrayList();
    View localView1 = paramj.d;
    if (localObject4 != null);
    for (Object localObject5 = d.a(localObject4, localFragment2.getView(), localArrayList2, locala1, localView1); ; localObject5 = localObject4)
    {
      if ((this.m != null) && (locala1 != null))
      {
        Object localObject8 = this.m.get(0);
        View localView5 = (View)locala1.get(localObject8);
        if (localView5 != null)
        {
          if (localObject5 != null)
            d.a(localObject5, localView5);
          if (localTransitionSet2 != null)
            d.a(localTransitionSet2, localView5);
        }
      }
      d locald = new d(this, localFragment1);
      ArrayList localArrayList3 = new ArrayList();
      a locala2 = new a();
      boolean bool2;
      if (localFragment1 != null)
        if (paramBoolean)
          bool2 = localFragment1.getAllowReturnTransitionOverlap();
      for (boolean bool1 = bool2; ; bool1 = true)
      {
        Object localObject6 = (Transition)localObject2;
        Transition localTransition1 = (Transition)localObject5;
        Transition localTransition2 = (Transition)localTransitionSet2;
        if ((localObject6 != null) && (localTransition1 != null));
        while (true)
        {
          Object localObject7;
          if (bool1)
          {
            localObject7 = new TransitionSet();
            if (localObject6 != null)
              ((TransitionSet)localObject7).addTransition((Transition)localObject6);
            if (localTransition1 != null)
              ((TransitionSet)localObject7).addTransition(localTransition1);
            if (localTransition2 != null)
              ((TransitionSet)localObject7).addTransition(localTransition2);
          }
          while (true)
          {
            if (localObject7 != null)
            {
              View localView2 = paramj.d;
              N localN = paramj.c;
              a locala3 = paramj.a;
              d.a(localObject2, localTransitionSet2, localViewGroup, locald, localView2, localN, locala3, localArrayList3, locala1, locala2, localArrayList1);
              localViewGroup.getViewTreeObserver().addOnPreDrawListener(new h(this, localViewGroup, paramj, paramInt, localObject7));
              View localView3 = paramj.d;
              d.a(localObject7, localView3, true);
              a(paramj, paramInt, localObject7);
              TransitionManager.beginDelayedTransition(localViewGroup, (Transition)localObject7);
              View localView4 = paramj.d;
              ArrayList localArrayList4 = paramj.b;
              Transition localTransition3 = (Transition)localObject2;
              Transition localTransition4 = (Transition)localObject5;
              Transition localTransition5 = (Transition)localTransitionSet2;
              Transition localTransition6 = (Transition)localObject7;
              if (localTransition6 != null)
                localViewGroup.getViewTreeObserver().addOnPreDrawListener(new M(localViewGroup, localTransition3, localArrayList3, localTransition4, localArrayList2, localTransition5, localArrayList1, locala2, localArrayList4, localTransition6, localView4));
            }
            if (localObject7 == null)
              break label888;
            return true;
            bool2 = localFragment1.getAllowEnterTransitionOverlap();
            break;
            if ((localTransition1 != null) && (localObject6 != null))
              localObject6 = new TransitionSet().addTransition(localTransition1).addTransition((Transition)localObject6).setOrdering(1);
            while (true)
            {
              if (localTransition2 == null)
                break label881;
              localObject7 = new TransitionSet();
              if (localObject6 != null)
                ((TransitionSet)localObject7).addTransition((Transition)localObject6);
              ((TransitionSet)localObject7).addTransition(localTransition2);
              break;
              if (localTransition1 != null)
              {
                localObject6 = localTransition1;
                continue;
              }
              if (localObject6 != null)
                continue;
              localObject6 = null;
            }
            label881: localObject7 = localObject6;
          }
          label888: return false;
          bool1 = true;
        }
      }
    }
  }

  private static void b(j paramj, a parama, boolean paramBoolean)
  {
    int i1 = parama.size();
    int i2 = 0;
    if (i2 < i1)
    {
      String str1 = (String)parama.b(i2);
      String str2 = ((View)parama.c(i2)).getTransitionName();
      if (paramBoolean)
        a(paramj.a, str1, str2);
      while (true)
      {
        i2++;
        break;
        a(paramj.a, str2, str1);
      }
    }
  }

  private static void b(SparseArray paramSparseArray, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i1 = paramFragment.mContainerId;
      if (i1 != 0)
        paramSparseArray.put(i1, paramFragment);
    }
  }

  private void b(SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    if (!this.o.i.a());
    i locali;
    do
    {
      return;
      locali = this.a;
    }
    while (locali == null);
    switch (locali.c)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      locali = locali.a;
      break;
      b(paramSparseArray2, locali.d);
      continue;
      Fragment localFragment1 = locali.d;
      Fragment localFragment2;
      if (this.o.c != null)
      {
        localFragment2 = localFragment1;
        int i1 = 0;
        if (i1 < this.o.c.size())
        {
          Fragment localFragment3 = (Fragment)this.o.c.get(i1);
          if ((localFragment2 == null) || (localFragment3.mContainerId == localFragment2.mContainerId))
          {
            if (localFragment3 != localFragment2)
              break label176;
            localFragment2 = null;
          }
          while (true)
          {
            i1++;
            break;
            label176: a(paramSparseArray1, localFragment3);
          }
        }
      }
      else
      {
        localFragment2 = localFragment1;
      }
      b(paramSparseArray2, localFragment2);
      continue;
      a(paramSparseArray1, locali.d);
      continue;
      a(paramSparseArray1, locali.d);
      continue;
      b(paramSparseArray2, locali.d);
      continue;
      a(paramSparseArray1, locali.d);
      continue;
      b(paramSparseArray2, locali.d);
    }
  }

  public final int a()
  {
    return a(false);
  }

  public final I a(Fragment paramFragment)
  {
    i locali = new i();
    locali.c = 3;
    locali.d = paramFragment;
    a(locali);
    return this;
  }

  public final I a(Fragment paramFragment, String paramString)
  {
    paramFragment.mFragmentManager = this.o;
    if (paramString != null)
    {
      if ((paramFragment.mTag != null) && (!paramString.equals(paramFragment.mTag)))
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString);
      paramFragment.mTag = paramString;
    }
    i locali = new i();
    locali.c = 1;
    locali.d = paramFragment;
    a(locali);
    return this;
  }

  public final j a(boolean paramBoolean, j paramj, SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    if (n)
    {
      if (paramj != null)
        break label153;
      if ((paramSparseArray1.size() != 0) || (paramSparseArray2.size() != 0))
        paramj = a(paramSparseArray1, paramSparseArray2, true);
    }
    label34: a(-1);
    int i1;
    label46: int i2;
    label53: i locali;
    int i4;
    if (paramj != null)
    {
      i1 = 0;
      if (paramj == null)
        break label237;
      i2 = 0;
      locali = this.p;
      if (locali == null)
        break label562;
      if (paramj == null)
        break label246;
      i4 = 0;
      label71: if (paramj == null)
        break label256;
    }
    label256: for (int i5 = 0; ; i5 = locali.h)
      switch (locali.c)
      {
      default:
        throw new IllegalArgumentException("Unknown cmd: " + locali.c);
        label153: if (paramBoolean)
          break label34;
        ArrayList localArrayList1 = this.m;
        ArrayList localArrayList2 = this.l;
        if (localArrayList1 == null)
          break label34;
        for (int i7 = 0; i7 < localArrayList1.size(); i7++)
        {
          String str1 = (String)localArrayList1.get(i7);
          String str2 = (String)localArrayList2.get(i7);
          a(paramj.a, str1, str2);
        }
        i1 = this.d;
        break label46;
        label237: i2 = this.c;
        break label53;
        label246: i4 = locali.g;
        break label71;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    Fragment localFragment8 = locali.d;
    localFragment8.mNextAnim = i5;
    this.o.a(localFragment8, A.a(i2), i1);
    while (true)
    {
      locali = locali.b;
      break;
      Fragment localFragment6 = locali.d;
      if (localFragment6 != null)
      {
        localFragment6.mNextAnim = i5;
        this.o.a(localFragment6, A.a(i2), i1);
      }
      if (locali.i == null)
        continue;
      for (int i6 = 0; i6 < locali.i.size(); i6++)
      {
        Fragment localFragment7 = (Fragment)locali.i.get(i6);
        localFragment7.mNextAnim = i4;
        this.o.a(localFragment7, false);
      }
      Fragment localFragment5 = locali.d;
      localFragment5.mNextAnim = i4;
      this.o.a(localFragment5, false);
      continue;
      Fragment localFragment4 = locali.d;
      localFragment4.mNextAnim = i4;
      this.o.c(localFragment4, A.a(i2), i1);
      continue;
      Fragment localFragment3 = locali.d;
      localFragment3.mNextAnim = i5;
      this.o.b(localFragment3, A.a(i2), i1);
      continue;
      Fragment localFragment2 = locali.d;
      localFragment2.mNextAnim = i4;
      this.o.e(localFragment2, A.a(i2), i1);
      continue;
      Fragment localFragment1 = locali.d;
      localFragment1.mNextAnim = i4;
      this.o.d(localFragment1, A.a(i2), i1);
    }
    label562: if (paramBoolean)
    {
      this.o.a(this.o.g, A.a(i2), i1, true);
      paramj = null;
    }
    A localA;
    int i3;
    if (this.g >= 0)
    {
      localA = this.o;
      i3 = this.g;
      monitorenter;
    }
    try
    {
      localA.e.set(i3, null);
      if (localA.f == null)
        localA.f = new ArrayList();
      localA.f.add(Integer.valueOf(i3));
      monitorexit;
      this.g = -1;
      return paramj;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  final void a(int paramInt)
  {
    if (!this.e);
    while (true)
    {
      return;
      for (i locali = this.a; locali != null; locali = locali.a)
      {
        if (locali.d != null)
        {
          Fragment localFragment2 = locali.d;
          localFragment2.mBackStackNesting = (paramInt + localFragment2.mBackStackNesting);
        }
        if (locali.i == null)
          continue;
        for (int i1 = -1 + locali.i.size(); i1 >= 0; i1--)
        {
          Fragment localFragment1 = (Fragment)locali.i.get(i1);
          localFragment1.mBackStackNesting = (paramInt + localFragment1.mBackStackNesting);
        }
      }
    }
  }

  final void a(i parami)
  {
    if (this.a == null)
    {
      this.p = parami;
      this.a = parami;
    }
    while (true)
    {
      parami.e = 0;
      parami.f = 0;
      parami.g = 0;
      parami.h = 0;
      this.b = (1 + this.b);
      return;
      parami.b = this.p;
      this.p.a = parami;
      this.p = parami;
    }
  }

  public final void a(SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    if (!this.o.i.a());
    i locali;
    do
    {
      return;
      locali = this.a;
    }
    while (locali == null);
    switch (locali.c)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      locali = locali.a;
      break;
      a(paramSparseArray1, locali.d);
      continue;
      if (locali.i != null)
        for (int i1 = -1 + locali.i.size(); i1 >= 0; i1--)
          b(paramSparseArray2, (Fragment)locali.i.get(i1));
      a(paramSparseArray1, locali.d);
      continue;
      b(paramSparseArray2, locali.d);
      continue;
      b(paramSparseArray2, locali.d);
      continue;
      a(paramSparseArray1, locali.d);
      continue;
      b(paramSparseArray2, locali.d);
      continue;
      a(paramSparseArray1, locali.d);
    }
  }

  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mName=");
    paramPrintWriter.print(this.f);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.g);
    paramPrintWriter.print(" mCommitted=");
    paramPrintWriter.println(this.q);
    if (this.c != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTransition=#");
      paramPrintWriter.print(Integer.toHexString(this.c));
      paramPrintWriter.print(" mTransitionStyle=#");
      paramPrintWriter.println(Integer.toHexString(this.d));
    }
    if ((this.h != 0) || (this.i != null))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mBreadCrumbTitleRes=#");
      paramPrintWriter.print(Integer.toHexString(this.h));
      paramPrintWriter.print(" mBreadCrumbTitleText=");
      paramPrintWriter.println(this.i);
    }
    if ((this.j != 0) || (this.k != null))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
      paramPrintWriter.print(Integer.toHexString(this.j));
      paramPrintWriter.print(" mBreadCrumbShortTitleText=");
      paramPrintWriter.println(this.k);
    }
    if (this.a != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str1 = paramString + "    ";
      i locali1 = this.a;
      int i1 = 0;
      i locali2 = locali1;
      while (locali2 != null)
      {
        String str2;
        int i2;
        switch (locali2.c)
        {
        default:
          str2 = "cmd=" + locali2.c;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str2);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(locali2.d);
          if ((locali2.e != 0) || (locali2.f != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("enterAnim=#");
            paramPrintWriter.print(Integer.toHexString(locali2.e));
            paramPrintWriter.print(" exitAnim=#");
            paramPrintWriter.println(Integer.toHexString(locali2.f));
          }
          if ((locali2.g != 0) || (locali2.h != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("popEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(locali2.g));
            paramPrintWriter.print(" popExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(locali2.h));
          }
          if ((locali2.i == null) || (locali2.i.size() <= 0))
            break label683;
          i2 = 0;
          label522: if (i2 >= locali2.i.size())
            break label683;
          paramPrintWriter.print(str1);
          if (locali2.i.size() != 1)
            break;
          paramPrintWriter.print("Removed: ");
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        }
        while (true)
        {
          paramPrintWriter.println(locali2.i.get(i2));
          i2++;
          break label522;
          str2 = "NULL";
          break;
          str2 = "ADD";
          break;
          str2 = "REPLACE";
          break;
          str2 = "REMOVE";
          break;
          str2 = "HIDE";
          break;
          str2 = "SHOW";
          break;
          str2 = "DETACH";
          break;
          str2 = "ATTACH";
          break;
          if (i2 == 0)
            paramPrintWriter.println("Removed:");
          paramPrintWriter.print(str1);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i2);
          paramPrintWriter.print(": ");
        }
        label683: locali2 = locali2.a;
        i1++;
      }
    }
  }

  public final int b()
  {
    return a(true);
  }

  public final void run()
  {
    if ((this.e) && (this.g < 0))
      throw new IllegalStateException("addToBackStack() called after commit()");
    a(1);
    SparseArray localSparseArray1;
    SparseArray localSparseArray2;
    if (n)
    {
      localSparseArray1 = new SparseArray();
      localSparseArray2 = new SparseArray();
      b(localSparseArray1, localSparseArray2);
    }
    for (j localj = a(localSparseArray1, localSparseArray2, false); ; localj = null)
    {
      int i1;
      label73: int i2;
      label80: i locali;
      int i3;
      if (localj != null)
      {
        i1 = 0;
        if (localj == null)
          break label190;
        i2 = 0;
        locali = this.a;
        if (locali == null)
          break label600;
        if (localj == null)
          break label199;
        i3 = 0;
        label98: if (localj == null)
          break label209;
      }
      label190: label199: label209: for (int i4 = 0; ; i4 = locali.f)
        switch (locali.c)
        {
        default:
          throw new IllegalArgumentException("Unknown cmd: " + locali.c);
          i1 = this.d;
          break label73;
          i2 = this.c;
          break label80;
          i3 = locali.e;
          break label98;
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        }
      Fragment localFragment9 = locali.d;
      localFragment9.mNextAnim = i3;
      this.o.a(localFragment9, false);
      while (true)
      {
        locali = locali.a;
        break;
        Fragment localFragment6 = locali.d;
        int i5 = localFragment6.mContainerId;
        Fragment localFragment7;
        if (this.o.c != null)
        {
          int i6 = 0;
          localFragment7 = localFragment6;
          if (i6 < this.o.c.size())
          {
            Fragment localFragment8 = (Fragment)this.o.c.get(i6);
            if (localFragment8.mContainerId == i5)
            {
              if (localFragment8 != localFragment7)
                break label348;
              locali.d = null;
              localFragment7 = null;
            }
            while (true)
            {
              i6++;
              break;
              label348: if (locali.i == null)
                locali.i = new ArrayList();
              locali.i.add(localFragment8);
              localFragment8.mNextAnim = i4;
              if (this.e)
                localFragment8.mBackStackNesting = (1 + localFragment8.mBackStackNesting);
              this.o.a(localFragment8, i2, i1);
            }
          }
        }
        else
        {
          localFragment7 = localFragment6;
        }
        if (localFragment7 == null)
          continue;
        localFragment7.mNextAnim = i3;
        this.o.a(localFragment7, false);
        continue;
        Fragment localFragment5 = locali.d;
        localFragment5.mNextAnim = i4;
        this.o.a(localFragment5, i2, i1);
        continue;
        Fragment localFragment4 = locali.d;
        localFragment4.mNextAnim = i4;
        this.o.b(localFragment4, i2, i1);
        continue;
        Fragment localFragment3 = locali.d;
        localFragment3.mNextAnim = i3;
        this.o.c(localFragment3, i2, i1);
        continue;
        Fragment localFragment2 = locali.d;
        localFragment2.mNextAnim = i4;
        this.o.d(localFragment2, i2, i1);
        continue;
        Fragment localFragment1 = locali.d;
        localFragment1.mNextAnim = i3;
        this.o.e(localFragment1, i2, i1);
      }
      label600: this.o.a(this.o.g, i2, i1, true);
      if (this.e)
      {
        A localA = this.o;
        if (localA.d == null)
          localA.d = new ArrayList();
        localA.d.add(this);
      }
      return;
    }
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.g >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.g);
    }
    if (this.f != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.f);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.f
 * JD-Core Version:    0.6.0
 */