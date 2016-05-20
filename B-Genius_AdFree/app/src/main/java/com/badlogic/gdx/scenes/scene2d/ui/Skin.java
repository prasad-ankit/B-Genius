package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Values;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Method;
import java.util.Iterator;

public class Skin
  implements Disposable
{
  TextureAtlas atlas;
  ObjectMap resources = new ObjectMap();

  public Skin()
  {
  }

  public Skin(FileHandle paramFileHandle)
  {
    FileHandle localFileHandle = paramFileHandle.sibling(paramFileHandle.nameWithoutExtension() + ".atlas");
    if (localFileHandle.exists())
    {
      this.atlas = new TextureAtlas(localFileHandle);
      addRegions(this.atlas);
    }
    load(paramFileHandle);
  }

  public Skin(FileHandle paramFileHandle, TextureAtlas paramTextureAtlas)
  {
    this.atlas = paramTextureAtlas;
    addRegions(paramTextureAtlas);
    load(paramFileHandle);
  }

  public Skin(TextureAtlas paramTextureAtlas)
  {
    this.atlas = paramTextureAtlas;
    addRegions(paramTextureAtlas);
  }

  private static Method findMethod(Class paramClass, String paramString)
  {
    for (Method localMethod : ClassReflection.getMethods(paramClass))
      if (localMethod.getName().equals(paramString))
        return localMethod;
    return null;
  }

  public void add(String paramString, Object paramObject)
  {
    add(paramString, paramObject, paramObject.getClass());
  }

  public void add(String paramString, Object paramObject, Class paramClass)
  {
    if (paramString == null)
      throw new IllegalArgumentException("name cannot be null.");
    if (paramObject == null)
      throw new IllegalArgumentException("resource cannot be null.");
    ObjectMap localObjectMap = (ObjectMap)this.resources.get(paramClass);
    if (localObjectMap == null)
    {
      localObjectMap = new ObjectMap();
      this.resources.put(paramClass, localObjectMap);
    }
    localObjectMap.put(paramString, paramObject);
  }

  public void addRegions(TextureAtlas paramTextureAtlas)
  {
    Array localArray = paramTextureAtlas.getRegions();
    int i = localArray.size;
    for (int j = 0; j < i; j++)
    {
      TextureAtlas.AtlasRegion localAtlasRegion = (TextureAtlas.AtlasRegion)localArray.get(j);
      add(localAtlasRegion.name, localAtlasRegion, TextureRegion.class);
    }
  }

  public void dispose()
  {
    if (this.atlas != null)
      this.atlas.dispose();
    ObjectMap.Values localValues1 = this.resources.values().iterator();
    while (localValues1.hasNext())
    {
      ObjectMap.Values localValues2 = ((ObjectMap)localValues1.next()).values().iterator();
      while (localValues2.hasNext())
      {
        Object localObject = localValues2.next();
        if (!(localObject instanceof Disposable))
          continue;
        ((Disposable)localObject).dispose();
      }
    }
  }

  public String find(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("style cannot be null.");
    ObjectMap localObjectMap = (ObjectMap)this.resources.get(paramObject.getClass());
    if (localObjectMap == null)
      return null;
    return (String)localObjectMap.findKey(paramObject, true);
  }

  public Object get(Class paramClass)
  {
    return get("default", paramClass);
  }

  public Object get(String paramString, Class paramClass)
  {
    if (paramString == null)
      throw new IllegalArgumentException("name cannot be null.");
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    Object localObject;
    if (paramClass == Drawable.class)
      localObject = getDrawable(paramString);
    do
    {
      return localObject;
      if (paramClass == TextureRegion.class)
        return getRegion(paramString);
      if (paramClass == NinePatch.class)
        return getPatch(paramString);
      if (paramClass == Sprite.class)
        return getSprite(paramString);
      ObjectMap localObjectMap = (ObjectMap)this.resources.get(paramClass);
      if (localObjectMap == null)
        throw new GdxRuntimeException("No " + paramClass.getName() + " registered with name: " + paramString);
      localObject = localObjectMap.get(paramString);
    }
    while (localObject != null);
    throw new GdxRuntimeException("No " + paramClass.getName() + " registered with name: " + paramString);
  }

  public ObjectMap getAll(Class paramClass)
  {
    return (ObjectMap)this.resources.get(paramClass);
  }

  public TextureAtlas getAtlas()
  {
    return this.atlas;
  }

  public Color getColor(String paramString)
  {
    return (Color)get(paramString, Color.class);
  }

  // ERROR //
  public Drawable getDrawable(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 166
    //   4: invokevirtual 208	com/badlogic/gdx/scenes/scene2d/ui/Skin:optional	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   7: checkcast 166	com/badlogic/gdx/scenes/scene2d/utils/Drawable
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +5 -> 17
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: aload_1
    //   19: ldc 210
    //   21: invokevirtual 208	com/badlogic/gdx/scenes/scene2d/ui/Skin:optional	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   24: checkcast 166	com/badlogic/gdx/scenes/scene2d/utils/Drawable
    //   27: astore_2
    //   28: aload_2
    //   29: ifnonnull -14 -> 15
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 174	com/badlogic/gdx/scenes/scene2d/ui/Skin:getRegion	(Ljava/lang/String;)Lcom/badlogic/gdx/graphics/g2d/TextureRegion;
    //   37: astore 7
    //   39: aload 7
    //   41: instanceof 120
    //   44: ifeq +242 -> 286
    //   47: aload 7
    //   49: checkcast 120	com/badlogic/gdx/graphics/g2d/TextureAtlas$AtlasRegion
    //   52: astore 11
    //   54: aload 11
    //   56: getfield 214	com/badlogic/gdx/graphics/g2d/TextureAtlas$AtlasRegion:splits	[I
    //   59: ifnull +99 -> 158
    //   62: new 216	com/badlogic/gdx/scenes/scene2d/utils/NinePatchDrawable
    //   65: dup
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 180	com/badlogic/gdx/scenes/scene2d/ui/Skin:getPatch	(Ljava/lang/String;)Lcom/badlogic/gdx/graphics/g2d/NinePatch;
    //   71: invokespecial 219	com/badlogic/gdx/scenes/scene2d/utils/NinePatchDrawable:<init>	(Lcom/badlogic/gdx/graphics/g2d/NinePatch;)V
    //   74: astore 8
    //   76: aload 8
    //   78: ifnonnull +201 -> 279
    //   81: new 221	com/badlogic/gdx/scenes/scene2d/utils/TextureRegionDrawable
    //   84: dup
    //   85: aload 7
    //   87: invokespecial 224	com/badlogic/gdx/scenes/scene2d/utils/TextureRegionDrawable:<init>	(Lcom/badlogic/gdx/graphics/g2d/TextureRegion;)V
    //   90: astore 9
    //   92: aload 9
    //   94: astore 4
    //   96: aload 4
    //   98: ifnonnull +31 -> 129
    //   101: aload_0
    //   102: aload_1
    //   103: ldc 176
    //   105: invokevirtual 208	com/badlogic/gdx/scenes/scene2d/ui/Skin:optional	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   108: checkcast 176	com/badlogic/gdx/graphics/g2d/NinePatch
    //   111: astore 5
    //   113: aload 5
    //   115: ifnull +101 -> 216
    //   118: new 216	com/badlogic/gdx/scenes/scene2d/utils/NinePatchDrawable
    //   121: dup
    //   122: aload 5
    //   124: invokespecial 219	com/badlogic/gdx/scenes/scene2d/utils/NinePatchDrawable:<init>	(Lcom/badlogic/gdx/graphics/g2d/NinePatch;)V
    //   127: astore 4
    //   129: aload 4
    //   131: instanceof 226
    //   134: ifeq +12 -> 146
    //   137: aload 4
    //   139: checkcast 226	com/badlogic/gdx/scenes/scene2d/utils/BaseDrawable
    //   142: aload_1
    //   143: invokevirtual 229	com/badlogic/gdx/scenes/scene2d/utils/BaseDrawable:setName	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: aload_1
    //   148: aload 4
    //   150: ldc 166
    //   152: invokevirtual 88	com/badlogic/gdx/scenes/scene2d/ui/Skin:add	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)V
    //   155: aload 4
    //   157: areturn
    //   158: aload 11
    //   160: getfield 233	com/badlogic/gdx/graphics/g2d/TextureAtlas$AtlasRegion:rotate	Z
    //   163: ifne +29 -> 192
    //   166: aload 11
    //   168: getfield 236	com/badlogic/gdx/graphics/g2d/TextureAtlas$AtlasRegion:packedWidth	I
    //   171: aload 11
    //   173: getfield 239	com/badlogic/gdx/graphics/g2d/TextureAtlas$AtlasRegion:originalWidth	I
    //   176: if_icmpne +16 -> 192
    //   179: aload 11
    //   181: getfield 242	com/badlogic/gdx/graphics/g2d/TextureAtlas$AtlasRegion:packedHeight	I
    //   184: aload 11
    //   186: getfield 245	com/badlogic/gdx/graphics/g2d/TextureAtlas$AtlasRegion:originalHeight	I
    //   189: if_icmpeq +97 -> 286
    //   192: new 247	com/badlogic/gdx/scenes/scene2d/utils/SpriteDrawable
    //   195: dup
    //   196: aload_0
    //   197: aload_1
    //   198: invokevirtual 186	com/badlogic/gdx/scenes/scene2d/ui/Skin:getSprite	(Ljava/lang/String;)Lcom/badlogic/gdx/graphics/g2d/Sprite;
    //   201: invokespecial 250	com/badlogic/gdx/scenes/scene2d/utils/SpriteDrawable:<init>	(Lcom/badlogic/gdx/graphics/g2d/Sprite;)V
    //   204: astore 8
    //   206: goto -130 -> 76
    //   209: astore_3
    //   210: aload_2
    //   211: astore 4
    //   213: goto -117 -> 96
    //   216: aload_0
    //   217: aload_1
    //   218: ldc 182
    //   220: invokevirtual 208	com/badlogic/gdx/scenes/scene2d/ui/Skin:optional	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   223: checkcast 182	com/badlogic/gdx/graphics/g2d/Sprite
    //   226: astore 6
    //   228: aload 6
    //   230: ifnull +17 -> 247
    //   233: new 247	com/badlogic/gdx/scenes/scene2d/utils/SpriteDrawable
    //   236: dup
    //   237: aload 6
    //   239: invokespecial 250	com/badlogic/gdx/scenes/scene2d/utils/SpriteDrawable:<init>	(Lcom/badlogic/gdx/graphics/g2d/Sprite;)V
    //   242: astore 4
    //   244: goto -115 -> 129
    //   247: new 188	com/badlogic/gdx/utils/GdxRuntimeException
    //   250: dup
    //   251: new 22	java/lang/StringBuilder
    //   254: dup
    //   255: ldc 252
    //   257: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload_1
    //   261: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokespecial 197	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   270: athrow
    //   271: astore 10
    //   273: aload 8
    //   275: astore_2
    //   276: goto -66 -> 210
    //   279: aload 8
    //   281: astore 9
    //   283: goto -191 -> 92
    //   286: aload_2
    //   287: astore 8
    //   289: goto -213 -> 76
    //
    // Exception table:
    //   from	to	target	type
    //   32	76	209	com/badlogic/gdx/utils/GdxRuntimeException
    //   158	192	209	com/badlogic/gdx/utils/GdxRuntimeException
    //   192	206	209	com/badlogic/gdx/utils/GdxRuntimeException
    //   81	92	271	com/badlogic/gdx/utils/GdxRuntimeException
  }

  public BitmapFont getFont(String paramString)
  {
    return (BitmapFont)get(paramString, BitmapFont.class);
  }

  protected Json getJsonLoader(FileHandle paramFileHandle)
  {
    Skin.1 local1 = new Skin.1(this);
    local1.setTypeName(null);
    local1.setUsePrototypes(false);
    local1.setSerializer(Skin.class, new Skin.2(this, this));
    local1.setSerializer(BitmapFont.class, new Skin.3(this, paramFileHandle, this));
    local1.setSerializer(Color.class, new Skin.4(this));
    local1.setSerializer(Skin.TintedDrawable.class, new Skin.5(this));
    return local1;
  }

  public NinePatch getPatch(String paramString)
  {
    NinePatch localNinePatch = (NinePatch)optional(paramString, NinePatch.class);
    if (localNinePatch != null)
      return localNinePatch;
    try
    {
      TextureRegion localTextureRegion = getRegion(paramString);
      if ((localTextureRegion instanceof TextureAtlas.AtlasRegion))
      {
        int[] arrayOfInt1 = ((TextureAtlas.AtlasRegion)localTextureRegion).splits;
        if (arrayOfInt1 != null)
        {
          localNinePatch = new NinePatch(localTextureRegion, arrayOfInt1[0], arrayOfInt1[1], arrayOfInt1[2], arrayOfInt1[3]);
          int[] arrayOfInt2 = ((TextureAtlas.AtlasRegion)localTextureRegion).pads;
          if (arrayOfInt2 != null)
            localNinePatch.setPadding(arrayOfInt2[0], arrayOfInt2[1], arrayOfInt2[2], arrayOfInt2[3]);
        }
      }
      if (localNinePatch == null)
        localNinePatch = new NinePatch(localTextureRegion);
      add(paramString, localNinePatch, NinePatch.class);
      return localNinePatch;
    }
    catch (GdxRuntimeException localGdxRuntimeException)
    {
    }
    throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + paramString);
  }

  public TextureRegion getRegion(String paramString)
  {
    TextureRegion localTextureRegion1 = (TextureRegion)optional(paramString, TextureRegion.class);
    if (localTextureRegion1 != null)
      return localTextureRegion1;
    Texture localTexture = (Texture)optional(paramString, Texture.class);
    if (localTexture == null)
      throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + paramString);
    TextureRegion localTextureRegion2 = new TextureRegion(localTexture);
    add(paramString, localTextureRegion2, TextureRegion.class);
    return localTextureRegion2;
  }

  public Sprite getSprite(String paramString)
  {
    Object localObject = (Sprite)optional(paramString, Sprite.class);
    if (localObject != null)
      return localObject;
    try
    {
      TextureRegion localTextureRegion = getRegion(paramString);
      if ((localTextureRegion instanceof TextureAtlas.AtlasRegion))
      {
        TextureAtlas.AtlasRegion localAtlasRegion = (TextureAtlas.AtlasRegion)localTextureRegion;
        if ((localAtlasRegion.rotate) || (localAtlasRegion.packedWidth != localAtlasRegion.originalWidth) || (localAtlasRegion.packedHeight != localAtlasRegion.originalHeight))
          localObject = new TextureAtlas.AtlasSprite(localAtlasRegion);
      }
      if (localObject == null)
        localObject = new Sprite(localTextureRegion);
      add(paramString, localObject, Sprite.class);
      return localObject;
    }
    catch (GdxRuntimeException localGdxRuntimeException)
    {
    }
    throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + paramString);
  }

  public TiledDrawable getTiledDrawable(String paramString)
  {
    TiledDrawable localTiledDrawable1 = (TiledDrawable)optional(paramString, TiledDrawable.class);
    if (localTiledDrawable1 != null)
      return localTiledDrawable1;
    TiledDrawable localTiledDrawable2 = new TiledDrawable(getRegion(paramString));
    localTiledDrawable2.setName(paramString);
    add(paramString, localTiledDrawable2, TiledDrawable.class);
    return localTiledDrawable2;
  }

  public boolean has(String paramString, Class paramClass)
  {
    ObjectMap localObjectMap = (ObjectMap)this.resources.get(paramClass);
    if (localObjectMap == null)
      return false;
    return localObjectMap.containsKey(paramString);
  }

  public void load(FileHandle paramFileHandle)
  {
    try
    {
      getJsonLoader(paramFileHandle).fromJson(Skin.class, paramFileHandle);
      return;
    }
    catch (SerializationException localSerializationException)
    {
    }
    throw new SerializationException("Error reading file: " + paramFileHandle, localSerializationException);
  }

  public Drawable newDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof TextureRegionDrawable))
      return new TextureRegionDrawable((TextureRegionDrawable)paramDrawable);
    if ((paramDrawable instanceof NinePatchDrawable))
      return new NinePatchDrawable((NinePatchDrawable)paramDrawable);
    if ((paramDrawable instanceof SpriteDrawable))
      return new SpriteDrawable((SpriteDrawable)paramDrawable);
    throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + paramDrawable.getClass());
  }

  public Drawable newDrawable(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return newDrawable(paramDrawable, new Color(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }

  public Drawable newDrawable(Drawable paramDrawable, Color paramColor)
  {
    Object localObject;
    if ((paramDrawable instanceof TextureRegionDrawable))
      localObject = ((TextureRegionDrawable)paramDrawable).tint(paramColor);
    BaseDrawable localBaseDrawable;
    while (true)
      if ((localObject instanceof BaseDrawable))
      {
        localBaseDrawable = (BaseDrawable)localObject;
        if (!(paramDrawable instanceof BaseDrawable))
          break;
        localBaseDrawable.setName(((BaseDrawable)paramDrawable).getName() + " (" + paramColor + ")");
      }
      else
      {
        return localObject;
        if ((paramDrawable instanceof NinePatchDrawable))
        {
          localObject = ((NinePatchDrawable)paramDrawable).tint(paramColor);
          continue;
        }
        if ((paramDrawable instanceof SpriteDrawable))
        {
          localObject = ((SpriteDrawable)paramDrawable).tint(paramColor);
          continue;
        }
        throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + paramDrawable.getClass());
      }
    localBaseDrawable.setName(" (" + paramColor + ")");
    return (Drawable)localObject;
  }

  public Drawable newDrawable(String paramString)
  {
    return newDrawable(getDrawable(paramString));
  }

  public Drawable newDrawable(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return newDrawable(getDrawable(paramString), new Color(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }

  public Drawable newDrawable(String paramString, Color paramColor)
  {
    return newDrawable(getDrawable(paramString), paramColor);
  }

  public Object optional(String paramString, Class paramClass)
  {
    if (paramString == null)
      throw new IllegalArgumentException("name cannot be null.");
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    ObjectMap localObjectMap = (ObjectMap)this.resources.get(paramClass);
    if (localObjectMap == null)
      return null;
    return localObjectMap.get(paramString);
  }

  public void remove(String paramString, Class paramClass)
  {
    if (paramString == null)
      throw new IllegalArgumentException("name cannot be null.");
    ((ObjectMap)this.resources.get(paramClass)).remove(paramString);
  }

  public void setEnabled(Actor paramActor, boolean paramBoolean)
  {
    Method localMethod1 = findMethod(paramActor.getClass(), "getStyle");
    if (localMethod1 == null);
    while (true)
    {
      return;
      try
      {
        Object localObject1 = localMethod1.invoke(paramActor, new Object[0]);
        String str1 = find(localObject1);
        if (str1 == null)
          continue;
        StringBuilder localStringBuilder = new StringBuilder().append(str1.replace("-disabled", ""));
        if (paramBoolean);
        for (String str2 = ""; ; str2 = "-disabled")
        {
          Object localObject2 = get(str2, localObject1.getClass());
          Method localMethod2 = findMethod(paramActor.getClass(), "setStyle");
          if (localMethod2 == null)
            break;
          try
          {
            localMethod2.invoke(paramActor, new Object[] { localObject2 });
            return;
          }
          catch (Exception localException2)
          {
            return;
          }
        }
      }
      catch (Exception localException1)
      {
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Skin
 * JD-Core Version:    0.6.0
 */