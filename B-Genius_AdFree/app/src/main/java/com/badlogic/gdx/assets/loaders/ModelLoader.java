package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider.AssetTextureProvider;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider.FileTextureProvider;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import java.util.Iterator;

public abstract class ModelLoader extends AsynchronousAssetLoader
{
  protected ModelLoader.ModelParameters defaultParameters = new ModelLoader.ModelParameters();
  protected Array items = new Array();

  public ModelLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, ModelLoader.ModelParameters paramModelParameters)
  {
    Array localArray1 = new Array();
    ModelData localModelData = loadModelData(paramFileHandle, paramModelParameters);
    if (localModelData == null)
      return localArray1;
    ObjectMap.Entry localEntry = new ObjectMap.Entry();
    localEntry.key = paramString;
    localEntry.value = localModelData;
    while (true)
    {
      synchronized (this.items)
      {
        this.items.add(localEntry);
        if (paramModelParameters != null)
        {
          localTextureParameter = paramModelParameters.textureParameter;
          Iterator localIterator1 = localModelData.materials.iterator();
          if (!localIterator1.hasNext())
            break;
          ModelMaterial localModelMaterial = (ModelMaterial)localIterator1.next();
          if (localModelMaterial.textures == null)
            continue;
          Iterator localIterator2 = localModelMaterial.textures.iterator();
          if (!localIterator2.hasNext())
            continue;
          localArray1.add(new AssetDescriptor(((ModelTexture)localIterator2.next()).fileName, Texture.class, localTextureParameter));
        }
      }
      TextureLoader.TextureParameter localTextureParameter = this.defaultParameters.textureParameter;
    }
    return localArray1;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, ModelLoader.ModelParameters paramModelParameters)
  {
  }

  public Model loadModel(FileHandle paramFileHandle)
  {
    return loadModel(paramFileHandle, new TextureProvider.FileTextureProvider(), null);
  }

  public Model loadModel(FileHandle paramFileHandle, ModelLoader.ModelParameters paramModelParameters)
  {
    return loadModel(paramFileHandle, new TextureProvider.FileTextureProvider(), paramModelParameters);
  }

  public Model loadModel(FileHandle paramFileHandle, TextureProvider paramTextureProvider)
  {
    return loadModel(paramFileHandle, paramTextureProvider, null);
  }

  public Model loadModel(FileHandle paramFileHandle, TextureProvider paramTextureProvider, ModelLoader.ModelParameters paramModelParameters)
  {
    ModelData localModelData = loadModelData(paramFileHandle, paramModelParameters);
    if (localModelData == null)
      return null;
    return new Model(localModelData, paramTextureProvider);
  }

  public ModelData loadModelData(FileHandle paramFileHandle)
  {
    return loadModelData(paramFileHandle, null);
  }

  public abstract ModelData loadModelData(FileHandle paramFileHandle, ModelLoader.ModelParameters paramModelParameters);

  public Model loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, ModelLoader.ModelParameters paramModelParameters)
  {
    Array localArray = this.items;
    monitorenter;
    int i = 0;
    Object localObject3;
    for (Object localObject1 = null; ; localObject1 = localObject3)
    {
      try
      {
        if (i < this.items.size)
        {
          if (!((String)((ObjectMap.Entry)this.items.get(i)).key).equals(paramString))
            break label173;
          localObject3 = (ModelData)((ObjectMap.Entry)this.items.get(i)).value;
          this.items.removeIndex(i);
          break label177;
        }
        monitorexit;
        if (localObject1 == null)
          return null;
      }
      finally
      {
        monitorexit;
      }
      Model localModel = new Model((ModelData)localObject1, new TextureProvider.AssetTextureProvider(paramAssetManager));
      Iterator localIterator = localModel.getManagedDisposables().iterator();
      while (localIterator.hasNext())
      {
        if (!((Disposable)localIterator.next() instanceof Texture))
          continue;
        localIterator.remove();
      }
      return localModel;
      label173: localObject3 = localObject1;
      label177: i++;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.ModelLoader
 * JD-Core Version:    0.6.0
 */