package com.badlogic.gdx.graphics.g3d.particles.renderers;

import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.batches.ModelInstanceParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;

public class ModelInstanceRenderer extends ParticleControllerRenderer
{
  private boolean hasColor;
  private boolean hasRotation;
  private boolean hasScale;

  public ModelInstanceRenderer()
  {
    super(new ModelInstanceControllerRenderData());
  }

  public ModelInstanceRenderer(ModelInstanceParticleBatch paramModelInstanceParticleBatch)
  {
    this();
    setBatch(paramModelInstanceParticleBatch);
  }

  public void allocateChannels()
  {
    ((ModelInstanceControllerRenderData)this.renderData).positionChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position));
  }

  public ParticleControllerComponent copy()
  {
    return new ModelInstanceRenderer((ModelInstanceParticleBatch)this.batch);
  }

  public void init()
  {
    boolean bool1 = true;
    ((ModelInstanceControllerRenderData)this.renderData).modelInstanceChannel = ((ParallelArray.ObjectChannel)this.controller.particles.getChannel(ParticleChannels.ModelInstance));
    ((ModelInstanceControllerRenderData)this.renderData).colorChannel = ((ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Color));
    ((ModelInstanceControllerRenderData)this.renderData).scaleChannel = ((ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Scale));
    ((ModelInstanceControllerRenderData)this.renderData).rotationChannel = ((ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Rotation3D));
    boolean bool2;
    boolean bool3;
    if (((ModelInstanceControllerRenderData)this.renderData).colorChannel != null)
    {
      bool2 = bool1;
      this.hasColor = bool2;
      if (((ModelInstanceControllerRenderData)this.renderData).scaleChannel == null)
        break label170;
      bool3 = bool1;
      label141: this.hasScale = bool3;
      if (((ModelInstanceControllerRenderData)this.renderData).rotationChannel == null)
        break label175;
    }
    while (true)
    {
      this.hasRotation = bool1;
      return;
      bool2 = false;
      break;
      label170: bool3 = false;
      break label141;
      label175: bool1 = false;
    }
  }

  public boolean isCompatible(ParticleBatch paramParticleBatch)
  {
    return paramParticleBatch instanceof ModelInstanceParticleBatch;
  }

  public void update()
  {
    int i = this.controller.particles.size;
    int j = 0;
    int k = 0;
    if (k < i)
    {
      ModelInstance localModelInstance = ((ModelInstance[])((ModelInstanceControllerRenderData)this.renderData).modelInstanceChannel.data)[k];
      float f1;
      if (this.hasScale)
        f1 = ((ModelInstanceControllerRenderData)this.renderData).scaleChannel.data[k];
      while (true)
      {
        float f2 = 1.0F;
        boolean bool = this.hasRotation;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        if (bool)
        {
          int i1 = k * ((ModelInstanceControllerRenderData)this.renderData).rotationChannel.strideSize;
          f3 = ((ModelInstanceControllerRenderData)this.renderData).rotationChannel.data[i1];
          f4 = ((ModelInstanceControllerRenderData)this.renderData).rotationChannel.data[(i1 + 1)];
          f5 = ((ModelInstanceControllerRenderData)this.renderData).rotationChannel.data[(i1 + 2)];
          f2 = ((ModelInstanceControllerRenderData)this.renderData).rotationChannel.data[(i1 + 3)];
        }
        localModelInstance.transform.set(((ModelInstanceControllerRenderData)this.renderData).positionChannel.data[j], ((ModelInstanceControllerRenderData)this.renderData).positionChannel.data[(j + 1)], ((ModelInstanceControllerRenderData)this.renderData).positionChannel.data[(j + 2)], f3, f4, f5, f2, f1, f1, f1);
        if (this.hasColor)
        {
          int n = k * ((ModelInstanceControllerRenderData)this.renderData).colorChannel.strideSize;
          ColorAttribute localColorAttribute = (ColorAttribute)((Material)localModelInstance.materials.get(0)).get(ColorAttribute.Diffuse);
          BlendingAttribute localBlendingAttribute = (BlendingAttribute)((Material)localModelInstance.materials.get(0)).get(BlendingAttribute.Type);
          localColorAttribute.color.r = ((ModelInstanceControllerRenderData)this.renderData).colorChannel.data[n];
          localColorAttribute.color.g = ((ModelInstanceControllerRenderData)this.renderData).colorChannel.data[(n + 1)];
          localColorAttribute.color.b = ((ModelInstanceControllerRenderData)this.renderData).colorChannel.data[(n + 2)];
          if (localBlendingAttribute != null)
            localBlendingAttribute.opacity = ((ModelInstanceControllerRenderData)this.renderData).colorChannel.data[(n + 3)];
        }
        int m = k + 1;
        j += ((ModelInstanceControllerRenderData)this.renderData).positionChannel.strideSize;
        k = m;
        break;
        f1 = 1.0F;
      }
    }
    super.update();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.renderers.ModelInstanceRenderer
 * JD-Core Version:    0.6.0
 */