package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.ImageResolver;
import com.badlogic.gdx.maps.ImageResolver.AssetManagerImageResolver;
import com.badlogic.gdx.maps.ImageResolver.DirectImageResolver;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Values;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

public class TideMapLoader extends SynchronousAssetLoader
{
  private XmlReader.Element root;
  private XmlReader xml = new XmlReader();

  public TideMapLoader()
  {
    super(new InternalFileHandleResolver());
  }

  public TideMapLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  private static FileHandle getRelativeFileHandle(FileHandle paramFileHandle, String paramString)
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

  private void loadLayer(TiledMap paramTiledMap, XmlReader.Element paramElement)
  {
    TiledMapTileLayer localTiledMapTileLayer;
    TiledMapTileSets localTiledMapTileSets;
    Object localObject1;
    int k;
    int n;
    int i1;
    int i2;
    int i4;
    label210: XmlReader.Element localElement4;
    String str5;
    int i5;
    if (paramElement.getName().equals("Layer"))
    {
      String str1 = paramElement.getAttribute("Id");
      String str2 = paramElement.getAttribute("Visible");
      XmlReader.Element localElement1 = paramElement.getChildByName("Dimensions");
      String str3 = localElement1.getAttribute("LayerSize");
      String str4 = localElement1.getAttribute("TileSize");
      String[] arrayOfString1 = str3.split(" x ");
      int i = Integer.parseInt(arrayOfString1[0]);
      int j = Integer.parseInt(arrayOfString1[1]);
      String[] arrayOfString2 = str4.split(" x ");
      localTiledMapTileLayer = new TiledMapTileLayer(i, j, Integer.parseInt(arrayOfString2[0]), Integer.parseInt(arrayOfString2[1]));
      localTiledMapTileLayer.setName(str1);
      localTiledMapTileLayer.setVisible(str2.equalsIgnoreCase("True"));
      Array localArray1 = paramElement.getChildByName("TileArray").getChildrenByName("Row");
      localTiledMapTileSets = paramTiledMap.getTileSets();
      localObject1 = null;
      k = 0;
      int m = localArray1.size;
      n = 0;
      if (n < m)
      {
        XmlReader.Element localElement3 = (XmlReader.Element)localArray1.get(n);
        i1 = m - 1 - n;
        i2 = 0;
        int i3 = localElement3.getChildCount();
        i4 = 0;
        if (i4 < i3)
        {
          localElement4 = localElement3.getChild(i4);
          str5 = localElement4.getName();
          if (str5.equals("TileSheet"))
          {
            localObject1 = localTiledMapTileSets.getTileSet(localElement4.getAttribute("Ref"));
            k = ((Integer)((TiledMapTileSet)localObject1).getProperties().get("firstgid", Integer.class)).intValue();
            i5 = i2;
          }
        }
      }
    }
    while (true)
    {
      i4++;
      i2 = i5;
      break label210;
      if (str5.equals("Null"))
      {
        i5 = i2 + localElement4.getIntAttribute("Count");
        continue;
      }
      if (str5.equals("Static"))
      {
        TiledMapTileLayer.Cell localCell1 = new TiledMapTileLayer.Cell();
        localCell1.setTile(((TiledMapTileSet)localObject1).getTile(k + localElement4.getIntAttribute("Index")));
        i5 = i2 + 1;
        localTiledMapTileLayer.setCell(i2, i1, localCell1);
        continue;
      }
      if (str5.equals("Animated"))
      {
        int i6 = localElement4.getInt("Interval");
        XmlReader.Element localElement5 = localElement4.getChildByName("Frames");
        Array localArray2 = new Array();
        int i7 = localElement5.getChildCount();
        int i8 = 0;
        if (i8 < i7)
        {
          XmlReader.Element localElement6 = localElement5.getChild(i8);
          String str6 = localElement6.getName();
          Object localObject2;
          int i9;
          if (str6.equals("TileSheet"))
          {
            localObject2 = localTiledMapTileSets.getTileSet(localElement6.getAttribute("Ref"));
            i9 = ((Integer)((TiledMapTileSet)localObject2).getProperties().get("firstgid", Integer.class)).intValue();
          }
          while (true)
          {
            i8++;
            localObject1 = localObject2;
            k = i9;
            break;
            if (str6.equals("Static"))
              localArray2.add((StaticTiledMapTile)((TiledMapTileSet)localObject1).getTile(k + localElement6.getIntAttribute("Index")));
            i9 = k;
            localObject2 = localObject1;
          }
        }
        TiledMapTileLayer.Cell localCell2 = new TiledMapTileLayer.Cell();
        localCell2.setTile(new AnimatedTiledMapTile(i6 / 1000.0F, localArray2));
        i5 = i2 + 1;
        localTiledMapTileLayer.setCell(i2, i1, localCell2);
        continue;
        n++;
        break;
        XmlReader.Element localElement2 = paramElement.getChildByName("Properties");
        if (localElement2 != null)
          loadProperties(localTiledMapTileLayer.getProperties(), localElement2);
        paramTiledMap.getLayers().add(localTiledMapTileLayer);
        return;
      }
      i5 = i2;
    }
  }

  private TiledMap loadMap(XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver)
  {
    TiledMap localTiledMap = new TiledMap();
    XmlReader.Element localElement = paramElement.getChildByName("Properties");
    if (localElement != null)
      loadProperties(localTiledMap.getProperties(), localElement);
    Iterator localIterator1 = paramElement.getChildByName("TileSheets").getChildrenByName("TileSheet").iterator();
    while (localIterator1.hasNext())
      loadTileSheet(localTiledMap, (XmlReader.Element)localIterator1.next(), paramFileHandle, paramImageResolver);
    Iterator localIterator2 = paramElement.getChildByName("Layers").getChildrenByName("Layer").iterator();
    while (localIterator2.hasNext())
      loadLayer(localTiledMap, (XmlReader.Element)localIterator2.next());
    return localTiledMap;
  }

  private void loadProperties(MapProperties paramMapProperties, XmlReader.Element paramElement)
  {
    if (paramElement.getName().equals("Properties"))
    {
      Iterator localIterator = paramElement.getChildrenByName("Property").iterator();
      while (localIterator.hasNext())
      {
        XmlReader.Element localElement = (XmlReader.Element)localIterator.next();
        String str1 = localElement.getAttribute("Key", null);
        String str2 = localElement.getAttribute("Type", null);
        String str3 = localElement.getText();
        if (str2.equals("Int32"))
        {
          paramMapProperties.put(str1, Integer.valueOf(Integer.parseInt(str3)));
          continue;
        }
        if ((!str2.equals("String")) && (str2.equals("Boolean")))
        {
          paramMapProperties.put(str1, Boolean.valueOf(str3.equalsIgnoreCase("true")));
          continue;
        }
        paramMapProperties.put(str1, str3);
      }
    }
  }

  private void loadTileSheet(TiledMap paramTiledMap, XmlReader.Element paramElement, FileHandle paramFileHandle, ImageResolver paramImageResolver)
  {
    if (paramElement.getName().equals("TileSheet"))
    {
      String str1 = paramElement.getAttribute("Id");
      paramElement.getChildByName("Description").getText();
      String str2 = paramElement.getChildByName("ImageSource").getText();
      XmlReader.Element localElement1 = paramElement.getChildByName("Alignment");
      String str3 = localElement1.getAttribute("SheetSize");
      String str4 = localElement1.getAttribute("TileSize");
      String str5 = localElement1.getAttribute("Margin");
      localElement1.getAttribute("Spacing");
      String[] arrayOfString1 = str3.split(" x ");
      Integer.parseInt(arrayOfString1[0]);
      Integer.parseInt(arrayOfString1[1]);
      String[] arrayOfString2 = str4.split(" x ");
      int i = Integer.parseInt(arrayOfString2[0]);
      int j = Integer.parseInt(arrayOfString2[1]);
      String[] arrayOfString3 = str5.split(" x ");
      int k = Integer.parseInt(arrayOfString3[0]);
      int m = Integer.parseInt(arrayOfString3[1]);
      String[] arrayOfString4 = str5.split(" x ");
      int n = Integer.parseInt(arrayOfString4[0]);
      int i1 = Integer.parseInt(arrayOfString4[1]);
      TextureRegion localTextureRegion = paramImageResolver.getImage(getRelativeFileHandle(paramFileHandle, str2).path());
      TiledMapTileSets localTiledMapTileSets = paramTiledMap.getTileSets();
      Iterator localIterator = localTiledMapTileSets.iterator();
      int i2 = 1;
      while (localIterator.hasNext())
        i2 += ((TiledMapTileSet)localIterator.next()).size();
      TiledMapTileSet localTiledMapTileSet = new TiledMapTileSet();
      localTiledMapTileSet.setName(str1);
      localTiledMapTileSet.getProperties().put("firstgid", Integer.valueOf(i2));
      int i3 = localTextureRegion.getRegionWidth() - i;
      int i4 = localTextureRegion.getRegionHeight() - j;
      int i7;
      for (int i5 = i2; m <= i4; i5 = i7)
      {
        int i6 = k;
        int i8;
        for (i7 = i5; i6 <= i3; i7 = i8)
        {
          StaticTiledMapTile localStaticTiledMapTile = new StaticTiledMapTile(new TextureRegion(localTextureRegion, i6, m, i, j));
          localStaticTiledMapTile.setId(i7);
          i8 = i7 + 1;
          localTiledMapTileSet.putTile(i7, localStaticTiledMapTile);
          i6 += i + n;
        }
        m += j + i1;
      }
      XmlReader.Element localElement2 = paramElement.getChildByName("Properties");
      if (localElement2 != null)
        loadProperties(localTiledMapTileSet.getProperties(), localElement2);
      localTiledMapTileSets.addTileSet(localTiledMapTileSet);
    }
  }

  private Array loadTileSheets(XmlReader.Element paramElement, FileHandle paramFileHandle)
  {
    Array localArray = new Array();
    Iterator localIterator = paramElement.getChildByName("TileSheets").getChildrenByName("TileSheet").iterator();
    while (localIterator.hasNext())
      localArray.add(getRelativeFileHandle(paramFileHandle, ((XmlReader.Element)localIterator.next()).getChildByName("ImageSource").getText()));
    return localArray;
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, TideMapLoader.Parameters paramParameters)
  {
    Array localArray = new Array();
    try
    {
      this.root = this.xml.parse(paramFileHandle);
      Iterator localIterator = loadTileSheets(this.root, paramFileHandle).iterator();
      while (localIterator.hasNext())
        localArray.add(new AssetDescriptor(((FileHandle)localIterator.next()).path(), Texture.class));
    }
    catch (IOException localIOException)
    {
      throw new GdxRuntimeException("Couldn't load tilemap '" + paramString + "'", localIOException);
    }
    return localArray;
  }

  public TiledMap load(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TideMapLoader.Parameters paramParameters)
  {
    try
    {
      TiledMap localTiledMap = loadMap(this.root, paramFileHandle, new ImageResolver.AssetManagerImageResolver(paramAssetManager));
      return localTiledMap;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Couldn't load tilemap '" + paramString + "'", localException);
  }

  public TiledMap load(String paramString)
  {
    FileHandle localFileHandle1;
    ObjectMap localObjectMap;
    try
    {
      localFileHandle1 = resolve(paramString);
      this.root = this.xml.parse(localFileHandle1);
      localObjectMap = new ObjectMap();
      Iterator localIterator = loadTileSheets(this.root, localFileHandle1).iterator();
      while (localIterator.hasNext())
      {
        FileHandle localFileHandle2 = (FileHandle)localIterator.next();
        localObjectMap.put(localFileHandle2.path(), new Texture(localFileHandle2));
      }
    }
    catch (IOException localIOException)
    {
      throw new GdxRuntimeException("Couldn't load tilemap '" + paramString + "'", localIOException);
    }
    ImageResolver.DirectImageResolver localDirectImageResolver = new ImageResolver.DirectImageResolver(localObjectMap);
    TiledMap localTiledMap = loadMap(this.root, localFileHandle1, localDirectImageResolver);
    localTiledMap.setOwnedResources(localObjectMap.values().toArray());
    return localTiledMap;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.TideMapLoader
 * JD-Core Version:    0.6.0
 */