package com.badlogic.gdx.assets.loaders.resolvers;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

public class InternalFileHandleResolver
  implements FileHandleResolver
{
  public FileHandle resolve(String paramString)
  {
    return Gdx.files.internal(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
 * JD-Core Version:    0.6.0
 */