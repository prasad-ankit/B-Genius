package com.badlogic.gdx.utils.async;

import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncResult
{
  private final Future future;

  AsyncResult(Future paramFuture)
  {
    this.future = paramFuture;
  }

  public Object get()
  {
    try
    {
      Object localObject = this.future.get();
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
    }
    throw new GdxRuntimeException(localExecutionException.getCause());
  }

  public boolean isDone()
  {
    return this.future.isDone();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.async.AsyncResult
 * JD-Core Version:    0.6.0
 */