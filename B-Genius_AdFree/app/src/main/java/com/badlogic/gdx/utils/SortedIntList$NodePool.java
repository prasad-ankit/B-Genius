package com.badlogic.gdx.utils;

class SortedIntList$NodePool extends Pool
{
  protected SortedIntList.Node newObject()
  {
    return new SortedIntList.Node();
  }

  public SortedIntList.Node obtain(SortedIntList.Node paramNode1, SortedIntList.Node paramNode2, Object paramObject, int paramInt)
  {
    SortedIntList.Node localNode = (SortedIntList.Node)super.obtain();
    localNode.p = paramNode1;
    localNode.n = paramNode2;
    localNode.value = paramObject;
    localNode.index = paramInt;
    return localNode;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.SortedIntList.NodePool
 * JD-Core Version:    0.6.0
 */