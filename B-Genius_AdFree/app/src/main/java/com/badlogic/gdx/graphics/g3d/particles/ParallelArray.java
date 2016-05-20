package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;

public class ParallelArray
{
  Array arrays = new Array(false, 2, ParallelArray.Channel.class);
  public int capacity;
  public int size;

  public ParallelArray(int paramInt)
  {
    this.capacity = paramInt;
    this.size = 0;
  }

  private ParallelArray.Channel allocateChannel(ParallelArray.ChannelDescriptor paramChannelDescriptor)
  {
    if (paramChannelDescriptor.type == Float.TYPE)
      return new ParallelArray.FloatChannel(this, paramChannelDescriptor.id, paramChannelDescriptor.count, this.capacity);
    if (paramChannelDescriptor.type == Integer.TYPE)
      return new ParallelArray.IntChannel(this, paramChannelDescriptor.id, paramChannelDescriptor.count, this.capacity);
    return new ParallelArray.ObjectChannel(this, paramChannelDescriptor.id, paramChannelDescriptor.count, this.capacity, paramChannelDescriptor.type);
  }

  private int findIndex(int paramInt)
  {
    for (int i = 0; i < this.arrays.size; i++)
      if (((ParallelArray.Channel[])this.arrays.items)[i].id == paramInt)
        return i;
    return -1;
  }

  public ParallelArray.Channel addChannel(ParallelArray.ChannelDescriptor paramChannelDescriptor)
  {
    return addChannel(paramChannelDescriptor, null);
  }

  public ParallelArray.Channel addChannel(ParallelArray.ChannelDescriptor paramChannelDescriptor, ParallelArray.ChannelInitializer paramChannelInitializer)
  {
    ParallelArray.Channel localChannel = getChannel(paramChannelDescriptor);
    if (localChannel == null)
    {
      localChannel = allocateChannel(paramChannelDescriptor);
      if (paramChannelInitializer != null)
        paramChannelInitializer.init(localChannel);
      this.arrays.add(localChannel);
    }
    return localChannel;
  }

  public void addElement(Object[] paramArrayOfObject)
  {
    if (this.size == this.capacity)
      throw new GdxRuntimeException("Capacity reached, cannot add other elements");
    Iterator localIterator = this.arrays.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ParallelArray.Channel localChannel = (ParallelArray.Channel)localIterator.next();
      localChannel.add(i, paramArrayOfObject);
      i += localChannel.strideSize;
    }
    this.size = (1 + this.size);
  }

  public void clear()
  {
    this.arrays.clear();
    this.size = 0;
  }

  public ParallelArray.Channel getChannel(ParallelArray.ChannelDescriptor paramChannelDescriptor)
  {
    Iterator localIterator = this.arrays.iterator();
    while (localIterator.hasNext())
    {
      ParallelArray.Channel localChannel = (ParallelArray.Channel)localIterator.next();
      if (localChannel.id == paramChannelDescriptor.id)
        return localChannel;
    }
    return null;
  }

  public void removeArray(int paramInt)
  {
    this.arrays.removeIndex(findIndex(paramInt));
  }

  public void removeElement(int paramInt)
  {
    int i = -1 + this.size;
    Iterator localIterator = this.arrays.iterator();
    while (localIterator.hasNext())
      ((ParallelArray.Channel)localIterator.next()).swap(paramInt, i);
    this.size = i;
  }

  public void setCapacity(int paramInt)
  {
    if (this.capacity != paramInt)
    {
      Iterator localIterator = this.arrays.iterator();
      while (localIterator.hasNext())
        ((ParallelArray.Channel)localIterator.next()).setCapacity(paramInt);
      this.capacity = paramInt;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParallelArray
 * JD-Core Version:    0.6.0
 */