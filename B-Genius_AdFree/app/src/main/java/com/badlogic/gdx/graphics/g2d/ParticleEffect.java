package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import java.io.File;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;

public class ParticleEffect
  implements Disposable
{
  private BoundingBox bounds;
  private final Array emitters;
  private boolean ownsTexture;

  public ParticleEffect()
  {
    this.emitters = new Array(8);
  }

  public ParticleEffect(ParticleEffect paramParticleEffect)
  {
    this.emitters = new Array(true, paramParticleEffect.emitters.size);
    int i = paramParticleEffect.emitters.size;
    for (int j = 0; j < i; j++)
      this.emitters.add(new ParticleEmitter((ParticleEmitter)paramParticleEffect.emitters.get(j)));
  }

  public void allowCompletion()
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      ((ParticleEmitter)this.emitters.get(j)).allowCompletion();
  }

  public void dispose()
  {
    if (!this.ownsTexture);
    while (true)
    {
      return;
      int i = this.emitters.size;
      for (int j = 0; j < i; j++)
        ((ParticleEmitter)this.emitters.get(j)).getSprite().getTexture().dispose();
    }
  }

  public void draw(Batch paramBatch)
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      ((ParticleEmitter)this.emitters.get(j)).draw(paramBatch);
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      ((ParticleEmitter)this.emitters.get(j)).draw(paramBatch, paramFloat);
  }

  public ParticleEmitter findEmitter(String paramString)
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
    {
      ParticleEmitter localParticleEmitter = (ParticleEmitter)this.emitters.get(j);
      if (localParticleEmitter.getName().equals(paramString))
        return localParticleEmitter;
    }
    return null;
  }

  public void flipY()
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      ((ParticleEmitter)this.emitters.get(j)).flipY();
  }

  public BoundingBox getBoundingBox()
  {
    if (this.bounds == null)
      this.bounds = new BoundingBox();
    BoundingBox localBoundingBox = this.bounds;
    localBoundingBox.inf();
    Iterator localIterator = this.emitters.iterator();
    while (localIterator.hasNext())
      localBoundingBox.ext(((ParticleEmitter)localIterator.next()).getBoundingBox());
    return localBoundingBox;
  }

  public Array getEmitters()
  {
    return this.emitters;
  }

  public boolean isComplete()
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      if (!((ParticleEmitter)this.emitters.get(j)).isComplete())
        return false;
    return true;
  }

  public void load(FileHandle paramFileHandle1, FileHandle paramFileHandle2)
  {
    loadEmitters(paramFileHandle1);
    loadEmitterImages(paramFileHandle2);
  }

  public void load(FileHandle paramFileHandle, TextureAtlas paramTextureAtlas)
  {
    load(paramFileHandle, paramTextureAtlas, null);
  }

  public void load(FileHandle paramFileHandle, TextureAtlas paramTextureAtlas, String paramString)
  {
    loadEmitters(paramFileHandle);
    loadEmitterImages(paramTextureAtlas, paramString);
  }

  public void loadEmitterImages(FileHandle paramFileHandle)
  {
    this.ownsTexture = true;
    HashMap localHashMap = new HashMap(this.emitters.size);
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
    {
      ParticleEmitter localParticleEmitter = (ParticleEmitter)this.emitters.get(j);
      String str1 = localParticleEmitter.getImagePath();
      if (str1 == null)
        continue;
      String str2 = new File(str1.replace('\\', '/')).getName();
      Sprite localSprite = (Sprite)localHashMap.get(str2);
      if (localSprite == null)
      {
        localSprite = new Sprite(loadTexture(paramFileHandle.child(str2)));
        localHashMap.put(str2, localSprite);
      }
      localParticleEmitter.setSprite(localSprite);
    }
  }

  public void loadEmitterImages(TextureAtlas paramTextureAtlas)
  {
    loadEmitterImages(paramTextureAtlas, null);
  }

  public void loadEmitterImages(TextureAtlas paramTextureAtlas, String paramString)
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
    {
      ParticleEmitter localParticleEmitter = (ParticleEmitter)this.emitters.get(j);
      String str1 = localParticleEmitter.getImagePath();
      if (str1 == null)
        continue;
      String str2 = new File(str1.replace('\\', '/')).getName();
      int k = str2.lastIndexOf('.');
      if (k != -1)
        str2 = str2.substring(0, k);
      if (paramString != null)
        str2 = paramString + str2;
      Sprite localSprite = paramTextureAtlas.createSprite(str2);
      if (localSprite == null)
        throw new IllegalArgumentException("SpriteSheet missing image: " + str2);
      localParticleEmitter.setSprite(localSprite);
    }
  }

  // ERROR //
  public void loadEmitters(FileHandle paramFileHandle)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 214	com/badlogic/gdx/files/FileHandle:read	()Ljava/io/InputStream;
    //   4: astore_2
    //   5: aload_0
    //   6: getfield 23	com/badlogic/gdx/graphics/g2d/ParticleEffect:emitters	Lcom/badlogic/gdx/utils/Array;
    //   9: invokevirtual 217	com/badlogic/gdx/utils/Array:clear	()V
    //   12: new 219	java/io/BufferedReader
    //   15: dup
    //   16: new 221	java/io/InputStreamReader
    //   19: dup
    //   20: aload_2
    //   21: invokespecial 224	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: sipush 512
    //   27: invokespecial 227	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   30: astore_3
    //   31: new 33	com/badlogic/gdx/graphics/g2d/ParticleEmitter
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 230	com/badlogic/gdx/graphics/g2d/ParticleEmitter:<init>	(Ljava/io/BufferedReader;)V
    //   39: astore 4
    //   41: aload_0
    //   42: getfield 23	com/badlogic/gdx/graphics/g2d/ParticleEffect:emitters	Lcom/badlogic/gdx/utils/Array;
    //   45: aload 4
    //   47: invokevirtual 44	com/badlogic/gdx/utils/Array:add	(Ljava/lang/Object;)V
    //   50: aload_3
    //   51: invokevirtual 233	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: ifnull +14 -> 68
    //   57: aload_3
    //   58: invokevirtual 233	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore 7
    //   63: aload 7
    //   65: ifnonnull -34 -> 31
    //   68: aload_3
    //   69: invokestatic 239	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   72: return
    //   73: astore 5
    //   75: aconst_null
    //   76: astore_3
    //   77: new 241	com/badlogic/gdx/utils/GdxRuntimeException
    //   80: dup
    //   81: new 188	java/lang/StringBuilder
    //   84: dup
    //   85: ldc 243
    //   87: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_1
    //   91: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: aload 5
    //   99: invokespecial 249	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: athrow
    //   103: astore 6
    //   105: aload_3
    //   106: invokestatic 239	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   109: aload 6
    //   111: athrow
    //   112: astore 6
    //   114: aconst_null
    //   115: astore_3
    //   116: goto -11 -> 105
    //   119: astore 5
    //   121: goto -44 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   12	31	73	java/io/IOException
    //   31	63	103	finally
    //   77	103	103	finally
    //   12	31	112	finally
    //   31	63	119	java/io/IOException
  }

  protected Texture loadTexture(FileHandle paramFileHandle)
  {
    return new Texture(paramFileHandle, false);
  }

  public void reset()
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      ((ParticleEmitter)this.emitters.get(j)).reset();
  }

  public void save(Writer paramWriter)
  {
    int i = this.emitters.size;
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      ParticleEmitter localParticleEmitter = (ParticleEmitter)this.emitters.get(j);
      m = k + 1;
      if (k > 0)
        paramWriter.write("\n\n");
      localParticleEmitter.save(paramWriter);
      j++;
    }
  }

  public void scaleEffect(float paramFloat)
  {
    Iterator localIterator = this.emitters.iterator();
    while (localIterator.hasNext())
    {
      ParticleEmitter localParticleEmitter = (ParticleEmitter)localIterator.next();
      localParticleEmitter.getScale().setHigh(paramFloat * localParticleEmitter.getScale().getHighMin(), paramFloat * localParticleEmitter.getScale().getHighMax());
      localParticleEmitter.getScale().setLow(paramFloat * localParticleEmitter.getScale().getLowMin(), paramFloat * localParticleEmitter.getScale().getLowMax());
      localParticleEmitter.getVelocity().setHigh(paramFloat * localParticleEmitter.getVelocity().getHighMin(), paramFloat * localParticleEmitter.getVelocity().getHighMax());
      localParticleEmitter.getVelocity().setLow(paramFloat * localParticleEmitter.getVelocity().getLowMin(), paramFloat * localParticleEmitter.getVelocity().getLowMax());
      localParticleEmitter.getGravity().setHigh(paramFloat * localParticleEmitter.getGravity().getHighMin(), paramFloat * localParticleEmitter.getGravity().getHighMax());
      localParticleEmitter.getGravity().setLow(paramFloat * localParticleEmitter.getGravity().getLowMin(), paramFloat * localParticleEmitter.getGravity().getLowMax());
      localParticleEmitter.getWind().setHigh(paramFloat * localParticleEmitter.getWind().getHighMin(), paramFloat * localParticleEmitter.getWind().getHighMax());
      localParticleEmitter.getWind().setLow(paramFloat * localParticleEmitter.getWind().getLowMin(), paramFloat * localParticleEmitter.getWind().getLowMax());
      localParticleEmitter.getSpawnWidth().setHigh(paramFloat * localParticleEmitter.getSpawnWidth().getHighMin(), paramFloat * localParticleEmitter.getSpawnWidth().getHighMax());
      localParticleEmitter.getSpawnWidth().setLow(paramFloat * localParticleEmitter.getSpawnWidth().getLowMin(), paramFloat * localParticleEmitter.getSpawnWidth().getLowMax());
      localParticleEmitter.getSpawnHeight().setHigh(paramFloat * localParticleEmitter.getSpawnHeight().getHighMin(), paramFloat * localParticleEmitter.getSpawnHeight().getHighMax());
      localParticleEmitter.getSpawnHeight().setLow(paramFloat * localParticleEmitter.getSpawnHeight().getLowMin(), paramFloat * localParticleEmitter.getSpawnHeight().getLowMax());
      localParticleEmitter.getXOffsetValue().setLow(paramFloat * localParticleEmitter.getXOffsetValue().getLowMin(), paramFloat * localParticleEmitter.getXOffsetValue().getLowMax());
      localParticleEmitter.getYOffsetValue().setLow(paramFloat * localParticleEmitter.getYOffsetValue().getLowMin(), paramFloat * localParticleEmitter.getYOffsetValue().getLowMax());
    }
  }

  public void setDuration(int paramInt)
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
    {
      ParticleEmitter localParticleEmitter = (ParticleEmitter)this.emitters.get(j);
      localParticleEmitter.setContinuous(false);
      localParticleEmitter.duration = paramInt;
      localParticleEmitter.durationTimer = 0.0F;
    }
  }

  public void setEmittersCleanUpBlendFunction(boolean paramBoolean)
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      ((ParticleEmitter)this.emitters.get(j)).setCleansUpBlendFunction(paramBoolean);
  }

  public void setFlip(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      ((ParticleEmitter)this.emitters.get(j)).setFlip(paramBoolean1, paramBoolean2);
  }

  public void setPosition(float paramFloat1, float paramFloat2)
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      ((ParticleEmitter)this.emitters.get(j)).setPosition(paramFloat1, paramFloat2);
  }

  public void start()
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      ((ParticleEmitter)this.emitters.get(j)).start();
  }

  public void update(float paramFloat)
  {
    int i = this.emitters.size;
    for (int j = 0; j < i; j++)
      ((ParticleEmitter)this.emitters.get(j)).update(paramFloat);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.ParticleEffect
 * JD-Core Version:    0.6.0
 */