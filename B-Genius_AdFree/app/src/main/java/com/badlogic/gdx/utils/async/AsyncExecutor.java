package com.badlogic.gdx.utils.async;

import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncExecutor
  implements Disposable
{
  private final ExecutorService executor;

  public AsyncExecutor(int paramInt)
  {
    this.executor = Executors.newFixedThreadPool(paramInt, new AsyncExecutor.1(this));
  }

  public void dispose()
  {
    this.executor.shutdown();
    try
    {
      this.executor.awaitTermination(9223372036854775807L, TimeUnit.SECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    throw new GdxRuntimeException("Couldn't shutdown loading thread", localInterruptedException);
  }

  public AsyncResult submit(AsyncTask paramAsyncTask)
  {
    if (this.executor.isShutdown())
      throw new GdxRuntimeException("Cannot run tasks on an executor that has been shutdown (disposed)");
    return new AsyncResult(this.executor.submit(new AsyncExecutor.2(this, paramAsyncTask)));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.async.AsyncExecutor
 * JD-Core Version:    0.6.0
 */