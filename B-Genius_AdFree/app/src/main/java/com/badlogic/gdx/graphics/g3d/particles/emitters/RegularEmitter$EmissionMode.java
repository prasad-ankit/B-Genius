package com.badlogic.gdx.graphics.g3d.particles.emitters;

public enum RegularEmitter$EmissionMode
{
  static
  {
    Disabled = new EmissionMode("Disabled", 2);
    EmissionMode[] arrayOfEmissionMode = new EmissionMode[3];
    arrayOfEmissionMode[0] = Enabled;
    arrayOfEmissionMode[1] = EnabledUntilCycleEnd;
    arrayOfEmissionMode[2] = Disabled;
    $VALUES = arrayOfEmissionMode;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.emitters.RegularEmitter.EmissionMode
 * JD-Core Version:    0.6.0
 */