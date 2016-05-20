package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.ImageResolver;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public abstract class BaseTmxMapLoader extends AsynchronousAssetLoader
{
  protected static final int FLAG_FLIP_DIAGONALLY = 536870912;
  protected static final int FLAG_FLIP_HORIZONTALLY = -2147483648;
  protected static final int FLAG_FLIP_VERTICALLY = 1073741824;
  protected static final int MASK_CLEAR = -536870912;
  protected boolean convertObjectToTileSpace;
  protected boolean flipY = true;
  protected TiledMap map;
  protected int mapHeightInPixels;
  protected int mapTileHeight;
  protected int mapTileWidth;
  protected int mapWidthInPixels;
  protected XmlReader.Element root;
  protected XmlReader xml = new XmlReader();

  public BaseTmxMapLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  protected static FileHandle getRelativeFileHandle(FileHandle paramFileHandle, String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "\\/");
    FileHandle localFileHandle = paramFileHandle.parent();
    while (localStringTokenizer.hasMoreElements())
    {
      String str = localStringTokenizer.nextToken();
      if (str.equals(".."))
      {
        localFileHandle = localFileHandle.parent();
        continue;
      }
      localFileHandle = localFileHandle.child(str);
    }
    return localFileHandle;
  }

  public static int[] getTileIds(XmlReader.Element paramElement, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    int i = 0;
    XmlReader.Element localElement = paramElement.getChildByName("data");
    String str1 = localElement.getAttribute("encoding", null);
    if (str1 == null)
      throw new GdxRuntimeException("Unsupported encoding (XML) for TMX Layer Data");
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    if (str1.equals("csv"))
    {
      String[] arrayOfString = localElement.getText().split(",");
      while (i < arrayOfString.length)
      {
        arrayOfInt[i] = (int)Long.parseLong(arrayOfString[i].trim());
        i++;
      }
    }
    if (str1.equals("base64"));
    while (true)
    {
      byte[] arrayOfByte2;
      int j;
      int m;
      try
      {
        String str2 = localElement.getAttribute("compression", null);
        byte[] arrayOfByte1 = Base64Coder.decode(localElement.getText());
        localObject1 = null;
        if (str2 != null)
          continue;
        localObject1 = new ByteArrayInputStream(arrayOfByte1);
        arrayOfByte2 = new byte[4];
        j = 0;
        break label479;
        if (k >= paramInt1)
          break label436;
        m = ((InputStream)localObject1).read(arrayOfByte2);
        if (m < 4)
        {
          int n = ((InputStream)localObject1).read(arrayOfByte2, m, 4 - m);
          if (n != -1)
          {
            m += n;
            continue;
            boolean bool1 = str2.equals("gzip");
            localObject1 = null;
            if (!bool1)
              continue;
            localObject1 = new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(arrayOfByte1), arrayOfByte1.length));
            continue;
            boolean bool2 = str2.equals("zlib");
            localObject1 = null;
            if (!bool2)
              continue;
            localObject1 = new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(arrayOfByte1)));
            continue;
            throw new GdxRuntimeException("Unrecognised compression (" + str2 + ") for TMX Layer Data");
          }
        }
      }
      catch (IOException localIOException)
      {
        throw new GdxRuntimeException("Error Reading TMX Layer Data - IOException: " + localIOException.getMessage());
      }
      finally
      {
        StreamUtils.closeQuietly((Closeable)localObject1);
      }
      if (m != 4)
        throw new GdxRuntimeException("Error Reading TMX Layer Data: Premature end of tile data");
      arrayOfInt[(k + j * paramInt1)] = (unsignedByteToInt(arrayOfByte2[0]) | unsignedByteToInt(arrayOfByte2[1]) << 8 | unsignedByteToInt(arrayOfByte2[2]) << 16 | unsignedByteToInt(arrayOfByte2[3]) << 24);
      k++;
      continue;
      label436: j++;
      label479: 
      while (j >= paramInt2)
      {
        StreamUtils.closeQuietly((Closeable)localObject1);
        return arrayOfInt;
        throw new GdxRuntimeException("Unrecognised encoding (" + str1 + ") for TMX Layer Data");
      }
      int k = 0;
    }
  }

  protected static int unsignedByteToInt(byte paramByte)
  {
    return paramByte & 0xFF;
  }

  protected TiledMapTileLayer.Cell createTileLayerCell(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    TiledMapTileLayer.Cell localCell = new TiledMapTileLayer.Cell();
    if (paramBoolean3)
    {
      if ((paramBoolean1) && (paramBoolean2))
      {
        localCell.setFlipHorizontally(true);
        localCell.setRotation(3);
        return localCell;
      }
      if (paramBoolean1)
      {
        localCell.setRotation(3);
        return localCell;
      }
      if (paramBoolean2)
      {
        localCell.setRotation(1);
        return localCell;
      }
      localCell.setFlipVertically(true);
      localCell.setRotation(3);
      return localCell;
    }
    localCell.setFlipHorizontally(paramBoolean1);
    localCell.setFlipVertically(paramBoolean2);
    return localCell;
  }

  protected void loadBasicLayerInfo(MapLayer paramMapLayer, XmlReader.Element paramElement)
  {
    int i = 1;
    String str = paramElement.getAttribute("name", null);
    float f = Float.parseFloat(paramElement.getAttribute("opacity", "1.0"));
    if (paramElement.getIntAttribute("visible", i) == i);
    while (true)
    {
      paramMapLayer.setName(str);
      paramMapLayer.setOpacity(f);
      paramMapLayer.setVisible(i);
      return;
      int j = 0;
    }
  }

  protected void loadImageLayer(TiledMap paramTiledMap, XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver)
  {
    int i;
    int j;
    TextureRegion localTextureRegion2;
    int k;
    if (paramElement.getName().equals("imagelayer"))
    {
      i = Integer.parseInt(paramElement.getAttribute("x", "0"));
      j = Integer.parseInt(paramElement.getAttribute("y", "0"));
      if (this.flipY)
        j = this.mapHeightInPixels - j;
      XmlReader.Element localElement1 = paramElement.getChildByName("image");
      if (localElement1 == null)
        break label166;
      localTextureRegion2 = paramImageResolver.getImage(getRelativeFileHandle(paramFileHandle, localElement1.getAttribute("source")).path());
      k = j - localTextureRegion2.getRegionHeight();
    }
    for (TextureRegion localTextureRegion1 = localTextureRegion2; ; localTextureRegion1 = null)
    {
      TiledMapImageLayer localTiledMapImageLayer = new TiledMapImageLayer(localTextureRegion1, i, k);
      loadBasicLayerInfo(localTiledMapImageLayer, paramElement);
      XmlReader.Element localElement2 = paramElement.getChildByName("properties");
      if (localElement2 != null)
        loadProperties(localTiledMapImageLayer.getProperties(), localElement2);
      paramTiledMap.getLayers().add(localTiledMapImageLayer);
      return;
      label166: k = j;
    }
  }

  protected void loadObject(TiledMap paramTiledMap, MapLayer paramMapLayer, XmlReader.Element paramElement)
  {
    float f1;
    float f2;
    label45: float f3;
    label80: float f5;
    float f6;
    float f7;
    label162: label252: Object localObject;
    if (paramElement.getName().equals("object"))
    {
      float f4;
      float[] arrayOfFloat2;
      int i1;
      int i2;
      float f14;
      if (this.convertObjectToTileSpace)
      {
        f1 = 1.0F / this.mapTileWidth;
        if (!this.convertObjectToTileSpace)
          break label252;
        f2 = 1.0F / this.mapTileHeight;
        f3 = f1 * paramElement.getFloatAttribute("x", 0.0F);
        if (!this.flipY)
          break label258;
        f4 = this.mapHeightInPixels - paramElement.getFloatAttribute("y", 0.0F);
        f5 = f4 * f2;
        f6 = f1 * paramElement.getFloatAttribute("width", 0.0F);
        f7 = f2 * paramElement.getFloatAttribute("height", 0.0F);
        if (paramElement.getChildCount() <= 0)
          break label1047;
        XmlReader.Element localElement2 = paramElement.getChildByName("polygon");
        if (localElement2 == null)
          break label761;
        String[] arrayOfString3 = localElement2.getAttribute("points").split(" ");
        arrayOfFloat2 = new float[arrayOfString3.length << 1];
        i1 = 0;
        if (i1 >= arrayOfString3.length)
          break label277;
        String[] arrayOfString4 = arrayOfString3[i1].split(",");
        arrayOfFloat2[(i1 << 1)] = (f1 * Float.parseFloat(arrayOfString4[0]));
        i2 = 1 + (i1 << 1);
        f14 = f2 * Float.parseFloat(arrayOfString4[1]);
        if (!this.flipY)
          break label271;
      }
      label258: label271: for (int i3 = -1; ; i3 = 1)
      {
        arrayOfFloat2[i2] = (f14 * i3);
        i1++;
        break label162;
        f1 = 1.0F;
        break;
        f2 = 1.0F;
        break label45;
        f4 = paramElement.getFloatAttribute("y", 0.0F);
        break label80;
      }
      label277: Polygon localPolygon = new Polygon(arrayOfFloat2);
      localPolygon.setPosition(f3, f5);
      localObject = new PolygonMapObject(localPolygon);
    }
    while (true)
    {
      boolean bool2;
      label347: boolean bool3;
      label358: float f9;
      if (localObject == null)
      {
        String str3 = paramElement.getAttribute("gid", null);
        if (str3 == null)
          break label1000;
        int j = (int)Long.parseLong(str3);
        if ((0x80000000 & j) != 0)
        {
          bool2 = true;
          if ((0x40000000 & j) == 0)
            break label984;
          bool3 = true;
          TiledMapTileMapObject localTiledMapTileMapObject = new TiledMapTileMapObject(paramTiledMap.getTileSets().getTile(0x1FFFFFFF & j), bool2, bool3);
          TextureRegion localTextureRegion = localTiledMapTileMapObject.getTextureRegion();
          localTiledMapTileMapObject.getProperties().put("gid", Integer.valueOf(j));
          localTiledMapTileMapObject.setX(f3);
          if (!this.flipY)
            break label990;
          f9 = f5;
          label425: localTiledMapTileMapObject.setY(f9);
          float f10 = paramElement.getFloatAttribute("width", localTextureRegion.getRegionWidth());
          float f11 = paramElement.getFloatAttribute("height", localTextureRegion.getRegionHeight());
          localTiledMapTileMapObject.setScaleX(f1 * (f10 / localTextureRegion.getRegionWidth()));
          localTiledMapTileMapObject.setScaleY(f2 * (f11 / localTextureRegion.getRegionHeight()));
          localTiledMapTileMapObject.setRotation(paramElement.getFloatAttribute("rotation", 0.0F));
          localObject = localTiledMapTileMapObject;
        }
      }
      else
      {
        ((MapObject)localObject).setName(paramElement.getAttribute("name", null));
        String str1 = paramElement.getAttribute("rotation", null);
        if (str1 != null)
          ((MapObject)localObject).getProperties().put("rotation", Float.valueOf(Float.parseFloat(str1)));
        String str2 = paramElement.getAttribute("type", null);
        if (str2 != null)
          ((MapObject)localObject).getProperties().put("type", str2);
        int i = paramElement.getIntAttribute("id", 0);
        if (i != 0)
          ((MapObject)localObject).getProperties().put("id", Integer.valueOf(i));
        ((MapObject)localObject).getProperties().put("x", Float.valueOf(f1 * f3));
        MapProperties localMapProperties = ((MapObject)localObject).getProperties();
        if (this.flipY)
          f5 -= f7;
        localMapProperties.put("y", Float.valueOf(f2 * f5));
        ((MapObject)localObject).getProperties().put("width", Float.valueOf(f6));
        ((MapObject)localObject).getProperties().put("height", Float.valueOf(f7));
        if (paramElement.getIntAttribute("visible", 1) != 1)
          break label1041;
      }
      label1041: for (boolean bool1 = true; ; bool1 = false)
      {
        ((MapObject)localObject).setVisible(bool1);
        XmlReader.Element localElement1 = paramElement.getChildByName("properties");
        if (localElement1 != null)
          loadProperties(((MapObject)localObject).getProperties(), localElement1);
        paramMapLayer.getObjects().add((MapObject)localObject);
        return;
        label761: XmlReader.Element localElement3 = paramElement.getChildByName("polyline");
        if (localElement3 != null)
        {
          String[] arrayOfString1 = localElement3.getAttribute("points").split(" ");
          float[] arrayOfFloat1 = new float[arrayOfString1.length << 1];
          int k = 0;
          if (k < arrayOfString1.length)
          {
            String[] arrayOfString2 = arrayOfString1[k].split(",");
            arrayOfFloat1[(k << 1)] = (f1 * Float.parseFloat(arrayOfString2[0]));
            int m = 1 + (k << 1);
            float f13 = f2 * Float.parseFloat(arrayOfString2[1]);
            if (this.flipY);
            for (int n = -1; ; n = 1)
            {
              arrayOfFloat1[m] = (f13 * n);
              k++;
              break;
            }
          }
          Polyline localPolyline = new Polyline(arrayOfFloat1);
          localPolyline.setPosition(f3, f5);
          localObject = new PolylineMapObject(localPolyline);
          break;
        }
        if (paramElement.getChildByName("ellipse") == null)
          break label1047;
        float f12;
        if (this.flipY)
          f12 = f5 - f7;
        while (true)
        {
          localObject = new EllipseMapObject(f3, f12, f6, f7);
          break;
          f12 = f5;
        }
        bool2 = false;
        break label347;
        label984: bool3 = false;
        break label358;
        label990: f9 = f5 - f7;
        break label425;
        label1000: float f8;
        if (this.flipY)
          f8 = f5 - f7;
        while (true)
        {
          localObject = new RectangleMapObject(f3, f8, f6, f7);
          break;
          f8 = f5;
        }
      }
      label1047: localObject = null;
    }
  }

  protected void loadObjectGroup(TiledMap paramTiledMap, XmlReader.Element paramElement)
  {
    if (paramElement.getName().equals("objectgroup"))
    {
      String str = paramElement.getAttribute("name", null);
      MapLayer localMapLayer = new MapLayer();
      localMapLayer.setName(str);
      XmlReader.Element localElement = paramElement.getChildByName("properties");
      if (localElement != null)
        loadProperties(localMapLayer.getProperties(), localElement);
      Iterator localIterator = paramElement.getChildrenByName("object").iterator();
      while (localIterator.hasNext())
        loadObject(paramTiledMap, localMapLayer, (XmlReader.Element)localIterator.next());
      paramTiledMap.getLayers().add(localMapLayer);
    }
  }

  protected void loadProperties(MapProperties paramMapProperties, XmlReader.Element paramElement)
  {
    if (paramElement == null);
    do
      return;
    while (!paramElement.getName().equals("properties"));
    Iterator localIterator = paramElement.getChildrenByName("property").iterator();
    label29: XmlReader.Element localElement;
    String str1;
    String str2;
    if (localIterator.hasNext())
    {
      localElement = (XmlReader.Element)localIterator.next();
      str1 = localElement.getAttribute("name", null);
      str2 = localElement.getAttribute("value", null);
      if (str2 != null)
        break label93;
    }
    label93: for (String str3 = localElement.getText(); ; str3 = str2)
    {
      paramMapProperties.put(str1, str3);
      break label29;
      break;
    }
  }

  protected void loadTileLayer(TiledMap paramTiledMap, XmlReader.Element paramElement)
  {
    if (paramElement.getName().equals("layer"))
    {
      int i = paramElement.getIntAttribute("width", 0);
      int j = paramElement.getIntAttribute("height", 0);
      TiledMapTileLayer localTiledMapTileLayer = new TiledMapTileLayer(i, j, paramElement.getParent().getIntAttribute("tilewidth", 0), paramElement.getParent().getIntAttribute("tileheight", 0));
      loadBasicLayerInfo(localTiledMapTileLayer, paramElement);
      int[] arrayOfInt = getTileIds(paramElement, i, j);
      TiledMapTileSets localTiledMapTileSets = paramTiledMap.getTileSets();
      for (int k = 0; k < j; k++)
      {
        int m = 0;
        if (m >= i)
          continue;
        int n = arrayOfInt[(m + k * i)];
        boolean bool1;
        label130: boolean bool2;
        label141: boolean bool3;
        label152: TiledMapTileLayer.Cell localCell;
        if ((0x80000000 & n) != 0)
        {
          bool1 = true;
          if ((0x40000000 & n) == 0)
            break label228;
          bool2 = true;
          if ((0x20000000 & n) == 0)
            break label234;
          bool3 = true;
          TiledMapTile localTiledMapTile = localTiledMapTileSets.getTile(n & 0x1FFFFFFF);
          if (localTiledMapTile != null)
          {
            localCell = createTileLayerCell(bool1, bool2, bool3);
            localCell.setTile(localTiledMapTile);
            if (!this.flipY)
              break label240;
          }
        }
        label228: label234: label240: for (int i1 = j - 1 - k; ; i1 = k)
        {
          localTiledMapTileLayer.setCell(m, i1, localCell);
          m++;
          break;
          bool1 = false;
          break label130;
          bool2 = false;
          break label141;
          bool3 = false;
          break label152;
        }
      }
      XmlReader.Element localElement = paramElement.getChildByName("properties");
      if (localElement != null)
        loadProperties(localTiledMapTileLayer.getProperties(), localElement);
      paramTiledMap.getLayers().add(localTiledMapTileLayer);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.BaseTmxMapLoader
 * JD-Core Version:    0.6.0
 */