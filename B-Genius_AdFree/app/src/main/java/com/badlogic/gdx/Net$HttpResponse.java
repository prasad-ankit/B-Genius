package com.badlogic.gdx;

import com.badlogic.gdx.net.HttpStatus;
import java.io.InputStream;
import java.util.Map;

public abstract interface Net$HttpResponse
{
  public abstract String getHeader(String paramString);

  public abstract Map getHeaders();

  public abstract byte[] getResult();

  public abstract InputStream getResultAsStream();

  public abstract String getResultAsString();

  public abstract HttpStatus getStatus();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.Net.HttpResponse
 * JD-Core Version:    0.6.0
 */