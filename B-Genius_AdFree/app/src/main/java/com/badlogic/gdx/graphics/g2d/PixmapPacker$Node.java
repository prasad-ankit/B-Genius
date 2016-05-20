package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.Rectangle;

final class PixmapPacker$Node
{
  public String leafName;
  public Node leftChild;
  public Rectangle rect;
  public Node rightChild;

  public PixmapPacker$Node()
  {
    this.rect = new Rectangle();
  }

  public PixmapPacker$Node(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Node paramNode1, Node paramNode2, String paramString)
  {
    this.rect = new Rectangle(paramInt1, paramInt2, paramInt3, paramInt4);
    this.leftChild = paramNode1;
    this.rightChild = paramNode2;
    this.leafName = paramString;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.PixmapPacker.Node
 * JD-Core Version:    0.6.0
 */