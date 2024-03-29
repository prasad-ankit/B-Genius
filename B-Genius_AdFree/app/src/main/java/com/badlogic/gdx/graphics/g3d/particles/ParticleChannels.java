package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class ParticleChannels
{
  public static final ParallelArray.ChannelDescriptor Acceleration;
  public static final int AlphaOffset = 3;
  public static final ParallelArray.ChannelDescriptor AngularVelocity2D;
  public static final ParallelArray.ChannelDescriptor AngularVelocity3D;
  public static final int BlueOffset = 2;
  public static final ParallelArray.ChannelDescriptor Color;
  public static final int CosineOffset = 0;
  public static final int CurrentLifeOffset = 0;
  public static final int GreenOffset = 1;
  public static final int HalfHeightOffset = 5;
  public static final int HalfWidthOffset = 4;
  public static final ParallelArray.ChannelDescriptor Interpolation;
  public static final ParallelArray.ChannelDescriptor Interpolation4;
  public static final ParallelArray.ChannelDescriptor Interpolation6;
  public static final int InterpolationDiffOffset = 1;
  public static final int InterpolationStartOffset = 0;
  public static final ParallelArray.ChannelDescriptor Life = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 3);
  public static final int LifePercentOffset = 2;
  public static final ParallelArray.ChannelDescriptor ModelInstance;
  public static final ParallelArray.ChannelDescriptor ParticleController;
  public static final ParallelArray.ChannelDescriptor Position = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 3);
  public static final ParallelArray.ChannelDescriptor PreviousPosition = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 3);
  public static final int RedOffset = 0;
  public static final ParallelArray.ChannelDescriptor Rotation2D;
  public static final ParallelArray.ChannelDescriptor Rotation3D;
  public static final ParallelArray.ChannelDescriptor Scale;
  public static final int SineOffset = 1;
  public static final ParallelArray.ChannelDescriptor TextureRegion;
  public static final int TotalLifeOffset = 1;
  public static final int U2Offset = 2;
  public static final int UOffset = 0;
  public static final int V2Offset = 3;
  public static final int VOffset = 1;
  public static final int VelocityPhiDiffOffset = 3;
  public static final int VelocityPhiStartOffset = 2;
  public static final int VelocityStrengthDiffOffset = 1;
  public static final int VelocityStrengthStartOffset = 0;
  public static final int VelocityThetaDiffOffset = 1;
  public static final int VelocityThetaStartOffset = 0;
  public static final int WOffset = 3;
  public static final int XOffset = 0;
  public static final int YOffset = 1;
  public static final int ZOffset = 2;
  private static int currentGlobalId;
  private int currentId;

  static
  {
    Color = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 4);
    TextureRegion = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 6);
    Rotation2D = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 2);
    Rotation3D = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 4);
    Scale = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 1);
    ModelInstance = new ParallelArray.ChannelDescriptor(newGlobalId(), ModelInstance.class, 1);
    ParticleController = new ParallelArray.ChannelDescriptor(newGlobalId(), ParticleController.class, 1);
    Acceleration = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 3);
    AngularVelocity2D = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 1);
    AngularVelocity3D = new ParallelArray.ChannelDescriptor(newGlobalId(), Float.TYPE, 3);
    Interpolation = new ParallelArray.ChannelDescriptor(-1, Float.TYPE, 2);
    Interpolation4 = new ParallelArray.ChannelDescriptor(-1, Float.TYPE, 4);
    Interpolation6 = new ParallelArray.ChannelDescriptor(-1, Float.TYPE, 6);
  }

  public ParticleChannels()
  {
    resetIds();
  }

  public static int newGlobalId()
  {
    int i = currentGlobalId;
    currentGlobalId = i + 1;
    return i;
  }

  public int newId()
  {
    int i = this.currentId;
    this.currentId = (i + 1);
    return i;
  }

  protected void resetIds()
  {
    this.currentId = currentGlobalId;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleChannels
 * JD-Core Version:    0.6.0
 */