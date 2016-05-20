package com.badlogic.gdx.assets.loaders.resolvers;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

public class PrefixFileHandleResolver
  implements FileHandleResolver
{
  private FileHandleResolver baseResolver;
  private String prefix;

  public PrefixFileHandleResolver(FileHandleResolver paramFileHandleResolver, String paramString)
  {
    this.baseResolver = paramFileHandleResolver;
    this.prefix = paramString;
  }

  public FileHandleResolver getBaseResolver()
  {
    return this.baseResolver;
  }

  public String getPrefix()
  {
    return this.prefix;
  }

  public FileHandle resolve(String paramString)
  {
    return this.baseResolver.resolve(this.prefix + paramString);
  }

  public void setBaseResolver(FileHandleResolver paramFileHandleResolver)
  {
    this.baseResolver = paramFileHandleResolver;
  }

  public void setPrefix(String paramString)
  {
    this.prefix = paramString;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.resolvers.PrefixFileHandleResolver
 * JD-Core Version:    0.6.0
 */