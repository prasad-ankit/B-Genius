package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.OrderedMap;
import java.util.Iterator;

public class PixmapPacker
  implements Disposable
{
  private static final String ANONYMOUS = "ANONYMOUS";
  private static final boolean debug;
  PixmapPacker.Page current;
  boolean disposed;
  final boolean duplicateBorder;
  boolean packToTexture;
  final int padding;
  final Pixmap.Format pageFormat;
  final int pageHeight;
  final int pageWidth;
  final Array pages = new Array();

  public PixmapPacker(int paramInt1, int paramInt2, Pixmap.Format paramFormat, int paramInt3, boolean paramBoolean)
  {
    this.pageWidth = paramInt1;
    this.pageHeight = paramInt2;
    this.pageFormat = paramFormat;
    this.padding = paramInt3;
    this.duplicateBorder = paramBoolean;
    newPage();
  }

  private PixmapPacker.Node insert(PixmapPacker.Node paramNode, Rectangle paramRectangle)
  {
    PixmapPacker.Node localNode;
    if ((paramNode.leafName == null) && (paramNode.leftChild != null) && (paramNode.rightChild != null))
    {
      localNode = insert(paramNode.leftChild, paramRectangle);
      if (localNode == null)
        localNode = insert(paramNode.rightChild, paramRectangle);
    }
    boolean bool2;
    do
    {
      boolean bool1;
      do
      {
        String str;
        do
        {
          return localNode;
          str = paramNode.leafName;
          localNode = null;
        }
        while (str != null);
        if ((paramNode.rect.width == paramRectangle.width) && (paramNode.rect.height == paramRectangle.height))
          return paramNode;
        bool1 = paramNode.rect.width < paramRectangle.width;
        localNode = null;
      }
      while (bool1);
      bool2 = paramNode.rect.height < paramRectangle.height;
      localNode = null;
    }
    while (bool2);
    paramNode.leftChild = new PixmapPacker.Node();
    paramNode.rightChild = new PixmapPacker.Node();
    if ((int)paramNode.rect.width - (int)paramRectangle.width > (int)paramNode.rect.height - (int)paramRectangle.height)
    {
      paramNode.leftChild.rect.x = paramNode.rect.x;
      paramNode.leftChild.rect.y = paramNode.rect.y;
      paramNode.leftChild.rect.width = paramRectangle.width;
      paramNode.leftChild.rect.height = paramNode.rect.height;
      paramNode.rightChild.rect.x = (paramNode.rect.x + paramRectangle.width);
      paramNode.rightChild.rect.y = paramNode.rect.y;
      paramNode.rightChild.rect.width = (paramNode.rect.width - paramRectangle.width);
    }
    for (paramNode.rightChild.rect.height = paramNode.rect.height; ; paramNode.rightChild.rect.height = (paramNode.rect.height - paramRectangle.height))
    {
      paramNode = paramNode.leftChild;
      break;
      paramNode.leftChild.rect.x = paramNode.rect.x;
      paramNode.leftChild.rect.y = paramNode.rect.y;
      paramNode.leftChild.rect.width = paramNode.rect.width;
      paramNode.leftChild.rect.height = paramRectangle.height;
      paramNode.rightChild.rect.x = paramNode.rect.x;
      paramNode.rightChild.rect.y = (paramNode.rect.y + paramRectangle.height);
      paramNode.rightChild.rect.width = paramNode.rect.width;
    }
  }

  private void newPage()
  {
    PixmapPacker.Page localPage = new PixmapPacker.Page();
    localPage.image = new Pixmap(this.pageWidth, this.pageHeight, this.pageFormat);
    localPage.root = new PixmapPacker.Node(0, 0, this.pageWidth, this.pageHeight, null, null, null);
    localPage.rects = new OrderedMap();
    this.pages.add(localPage);
    this.current = localPage;
  }

  public void dispose()
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.pages.iterator();
      while (localIterator.hasNext())
      {
        PixmapPacker.Page localPage = (PixmapPacker.Page)localIterator.next();
        if (localPage.texture != null)
          continue;
        localPage.image.dispose();
      }
    }
    finally
    {
      monitorexit;
    }
    this.disposed = true;
    monitorexit;
  }

  public TextureAtlas generateTextureAtlas(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      TextureAtlas localTextureAtlas = new TextureAtlas();
      updateTextureAtlas(localTextureAtlas, paramTextureFilter1, paramTextureFilter2, paramBoolean);
      monitorexit;
      return localTextureAtlas;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean getDuplicateBorder()
  {
    return this.duplicateBorder;
  }

  public boolean getPackToTexture()
  {
    return this.packToTexture;
  }

  public int getPadding()
  {
    return this.padding;
  }

  public PixmapPacker.Page getPage(String paramString)
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.pages.iterator();
      PixmapPacker.Page localPage;
      Rectangle localRectangle;
      do
      {
        if (!localIterator.hasNext())
          break;
        localPage = (PixmapPacker.Page)localIterator.next();
        localRectangle = (Rectangle)localPage.rects.get(paramString);
      }
      while (localRectangle == null);
      while (true)
      {
        return localPage;
        localPage = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public int getPageHeight()
  {
    return this.pageHeight;
  }

  public int getPageIndex(String paramString)
  {
    monitorenter;
    int i = 0;
    try
    {
      while (i < this.pages.size)
      {
        Rectangle localRectangle = (Rectangle)((PixmapPacker.Page)this.pages.get(i)).rects.get(paramString);
        if (localRectangle != null)
        {
          j = i;
          return j;
        }
        i++;
      }
      int j = -1;
    }
    finally
    {
      monitorexit;
    }
  }

  public int getPageWidth()
  {
    return this.pageWidth;
  }

  public Array getPages()
  {
    return this.pages;
  }

  public Rectangle getRect(String paramString)
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.pages.iterator();
      Rectangle localRectangle;
      do
      {
        if (!localIterator.hasNext())
          break;
        localRectangle = (Rectangle)((PixmapPacker.Page)localIterator.next()).rects.get(paramString);
      }
      while (localRectangle == null);
      while (true)
      {
        return localRectangle;
        localRectangle = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public Rectangle pack(Pixmap paramPixmap)
  {
    monitorenter;
    try
    {
      Rectangle localRectangle = pack(null, paramPixmap);
      monitorexit;
      return localRectangle;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public Rectangle pack(String paramString, Pixmap paramPixmap)
  {
    monitorenter;
    Object localObject2;
    int j;
    label78: int k;
    PixmapPacker.Node localNode;
    while (true)
    {
      try
      {
        boolean bool = this.disposed;
        if (!bool)
          continue;
        localObject2 = null;
        return localObject2;
        if ((paramString != null) && (getRect(paramString) != null))
          throw new GdxRuntimeException("Pixmap has already been packed with name: " + paramString);
      }
      finally
      {
        monitorexit;
      }
      int i = this.padding;
      if (!this.duplicateBorder)
        break;
      j = 1;
      k = j + i << 1;
      Rectangle localRectangle1 = new Rectangle(0.0F, 0.0F, k + paramPixmap.getWidth(), k + paramPixmap.getHeight());
      if ((localRectangle1.getWidth() > this.pageWidth) || (localRectangle1.getHeight() > this.pageHeight))
      {
        if (paramString == null)
          throw new GdxRuntimeException("Page size too small for anonymous pixmap.");
        throw new GdxRuntimeException("Page size too small for pixmap: " + paramString);
      }
      localNode = insert(this.current.root, localRectangle1);
      if (localNode != null)
        break label740;
      newPage();
      localObject2 = pack(paramString, paramPixmap);
    }
    while (true)
    {
      localNode.leafName = str;
      Rectangle localRectangle2 = new Rectangle(localNode.rect);
      localRectangle2.width -= k;
      localRectangle2.height -= k;
      int m = k >> 1;
      localRectangle2.x += m;
      localRectangle2.y += m;
      if (paramString != null)
      {
        this.current.rects.put(paramString, localRectangle2);
        this.current.addedRects.add(paramString);
      }
      int n = (int)localRectangle2.x;
      int i1 = (int)localRectangle2.y;
      int i2 = (int)localRectangle2.width;
      int i3 = (int)localRectangle2.height;
      if ((this.packToTexture) && (!this.duplicateBorder) && (this.current.texture != null) && (!this.current.dirty))
      {
        this.current.texture.bind();
        Gdx.gl.glTexSubImage2D(this.current.texture.glTarget, 0, n, i1, i2, i3, paramPixmap.getGLFormat(), paramPixmap.getGLType(), paramPixmap.getPixels());
      }
      while (true)
      {
        Pixmap.Blending localBlending = Pixmap.getBlending();
        Pixmap.setBlending(Pixmap.Blending.None);
        this.current.image.drawPixmap(paramPixmap, n, i1);
        if (this.duplicateBorder)
        {
          int i4 = paramPixmap.getWidth();
          int i5 = paramPixmap.getHeight();
          this.current.image.drawPixmap(paramPixmap, 0, 0, 1, 1, n - 1, i1 - 1, 1, 1);
          this.current.image.drawPixmap(paramPixmap, i4 - 1, 0, 1, 1, n + i2, i1 - 1, 1, 1);
          this.current.image.drawPixmap(paramPixmap, 0, i5 - 1, 1, 1, n - 1, i1 + i3, 1, 1);
          this.current.image.drawPixmap(paramPixmap, i4 - 1, i5 - 1, 1, 1, n + i2, i1 + i3, 1, 1);
          this.current.image.drawPixmap(paramPixmap, 0, 0, i4, 1, n, i1 - 1, i2, 1);
          this.current.image.drawPixmap(paramPixmap, 0, i5 - 1, i4, 1, n, i1 + i3, i2, 1);
          this.current.image.drawPixmap(paramPixmap, 0, 0, 1, i5, n - 1, i1, 1, i3);
          this.current.image.drawPixmap(paramPixmap, i4 - 1, 0, 1, i5, n + i2, i1, 1, i3);
        }
        Pixmap.setBlending(localBlending);
        localObject2 = localRectangle2;
        break;
        this.current.dirty = true;
      }
      j = 0;
      break label78;
      label740: if (paramString == null)
      {
        str = "ANONYMOUS";
        continue;
      }
      String str = paramString;
    }
  }

  public void setPackToTexture(boolean paramBoolean)
  {
    this.packToTexture = paramBoolean;
  }

  public void updatePageTextures(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.pages.iterator();
      while (localIterator.hasNext())
        ((PixmapPacker.Page)localIterator.next()).updateTexture(paramTextureFilter1, paramTextureFilter2, paramBoolean);
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public void updateTextureAtlas(TextureAtlas paramTextureAtlas, Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean)
  {
    monitorenter;
    while (true)
    {
      PixmapPacker.Page localPage;
      try
      {
        updatePageTextures(paramTextureFilter1, paramTextureFilter2, paramBoolean);
        Iterator localIterator1 = this.pages.iterator();
        if (!localIterator1.hasNext())
          break;
        localPage = (PixmapPacker.Page)localIterator1.next();
        if (localPage.addedRects.size <= 0)
          continue;
        Iterator localIterator2 = localPage.addedRects.iterator();
        if (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          Rectangle localRectangle = (Rectangle)localPage.rects.get(str);
          paramTextureAtlas.addRegion(str, new TextureRegion(localPage.texture, (int)localRectangle.x, (int)localRectangle.y, (int)localRectangle.width, (int)localRectangle.height));
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      localPage.addedRects.clear();
      paramTextureAtlas.getTextures().add(localPage.texture);
    }
    monitorexit;
  }

  public void updateTextureRegions(Array paramArray, Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      updatePageTextures(paramTextureFilter1, paramTextureFilter2, paramBoolean);
      while (paramArray.size < this.pages.size)
        paramArray.add(new TextureRegion(((PixmapPacker.Page)this.pages.get(paramArray.size)).texture));
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.PixmapPacker
 * JD-Core Version:    0.6.0
 */