package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.joints.PulleyJoint;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import java.util.Iterator;

public class Box2DDebugRenderer
  implements Disposable
{
  private static Vector2 axis;
  private static final Array bodies;
  private static final Array joints;
  private static final Vector2 lower;
  private static Vector2 t;
  private static final Vector2 upper;
  private static final Vector2[] vertices = new Vector2[1000];
  public final Color AABB_COLOR = new Color(1.0F, 0.0F, 1.0F, 1.0F);
  public final Color JOINT_COLOR = new Color(0.5F, 0.8F, 0.8F, 1.0F);
  public final Color SHAPE_AWAKE = new Color(0.9F, 0.7F, 0.7F, 1.0F);
  public final Color SHAPE_KINEMATIC = new Color(0.5F, 0.5F, 0.9F, 1.0F);
  public final Color SHAPE_NOT_ACTIVE = new Color(0.5F, 0.5F, 0.3F, 1.0F);
  public final Color SHAPE_NOT_AWAKE = new Color(0.6F, 0.6F, 0.6F, 1.0F);
  public final Color SHAPE_STATIC = new Color(0.5F, 0.9F, 0.5F, 1.0F);
  public final Color VELOCITY_COLOR = new Color(1.0F, 0.0F, 0.0F, 1.0F);
  private boolean drawAABBs;
  private boolean drawBodies;
  private boolean drawContacts;
  private boolean drawInactiveBodies;
  private boolean drawJoints;
  private boolean drawVelocities;
  private final Vector2 f = new Vector2();
  private final Vector2 lv = new Vector2();
  protected ShapeRenderer renderer = new ShapeRenderer();
  private final Vector2 v = new Vector2();

  static
  {
    lower = new Vector2();
    upper = new Vector2();
    bodies = new Array();
    joints = new Array();
    t = new Vector2();
    axis = new Vector2();
  }

  public Box2DDebugRenderer()
  {
    this(true, true, false, true, false, true);
  }

  public Box2DDebugRenderer(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    for (int i = 0; i < vertices.length; i++)
      vertices[i] = new Vector2();
    this.drawBodies = paramBoolean1;
    this.drawJoints = paramBoolean2;
    this.drawAABBs = paramBoolean3;
    this.drawInactiveBodies = paramBoolean4;
    this.drawVelocities = paramBoolean5;
    this.drawContacts = paramBoolean6;
  }

  private void drawAABB(Fixture paramFixture, Transform paramTransform)
  {
    if (paramFixture.getType() == Shape.Type.Circle)
    {
      CircleShape localCircleShape = (CircleShape)paramFixture.getShape();
      float f1 = localCircleShape.getRadius();
      vertices[0].set(localCircleShape.getPosition());
      paramTransform.mul(vertices[0]);
      lower.set(vertices[0].x - f1, vertices[0].y - f1);
      upper.set(f1 + vertices[0].x, f1 + vertices[0].y);
      vertices[0].set(lower.x, lower.y);
      vertices[1].set(upper.x, lower.y);
      vertices[2].set(upper.x, upper.y);
      vertices[3].set(lower.x, upper.y);
      drawSolidPolygon(vertices, 4, this.AABB_COLOR, true);
    }
    do
      return;
    while (paramFixture.getType() != Shape.Type.Polygon);
    PolygonShape localPolygonShape = (PolygonShape)paramFixture.getShape();
    int i = localPolygonShape.getVertexCount();
    localPolygonShape.getVertex(0, vertices[0]);
    lower.set(paramTransform.mul(vertices[0]));
    upper.set(lower);
    for (int j = 1; j < i; j++)
    {
      localPolygonShape.getVertex(j, vertices[j]);
      paramTransform.mul(vertices[j]);
      lower.x = Math.min(lower.x, vertices[j].x);
      lower.y = Math.min(lower.y, vertices[j].y);
      upper.x = Math.max(upper.x, vertices[j].x);
      upper.y = Math.max(upper.y, vertices[j].y);
    }
    vertices[0].set(lower.x, lower.y);
    vertices[1].set(upper.x, lower.y);
    vertices[2].set(upper.x, upper.y);
    vertices[3].set(lower.x, upper.y);
    drawSolidPolygon(vertices, 4, this.AABB_COLOR, true);
  }

  private void drawContact(Contact paramContact)
  {
    WorldManifold localWorldManifold = paramContact.getWorldManifold();
    if (localWorldManifold.getNumberOfContactPoints() == 0)
      return;
    Vector2 localVector2 = localWorldManifold.getPoints()[0];
    this.renderer.setColor(getColorByBody(paramContact.getFixtureA().getBody()));
    this.renderer.point(localVector2.x, localVector2.y, 0.0F);
  }

  private void drawJoint(Joint paramJoint)
  {
    Body localBody1 = paramJoint.getBodyA();
    Body localBody2 = paramJoint.getBodyB();
    Transform localTransform1 = localBody1.getTransform();
    Transform localTransform2 = localBody2.getTransform();
    Vector2 localVector21 = localTransform1.getPosition();
    Vector2 localVector22 = localTransform2.getPosition();
    Vector2 localVector23 = paramJoint.getAnchorA();
    Vector2 localVector24 = paramJoint.getAnchorB();
    if (paramJoint.getType() == JointDef.JointType.DistanceJoint)
    {
      drawSegment(localVector23, localVector24, this.JOINT_COLOR);
      return;
    }
    if (paramJoint.getType() == JointDef.JointType.PulleyJoint)
    {
      PulleyJoint localPulleyJoint = (PulleyJoint)paramJoint;
      Vector2 localVector25 = localPulleyJoint.getGroundAnchorA();
      Vector2 localVector26 = localPulleyJoint.getGroundAnchorB();
      drawSegment(localVector25, localVector23, this.JOINT_COLOR);
      drawSegment(localVector26, localVector24, this.JOINT_COLOR);
      drawSegment(localVector25, localVector26, this.JOINT_COLOR);
      return;
    }
    if (paramJoint.getType() == JointDef.JointType.MouseJoint)
    {
      drawSegment(paramJoint.getAnchorA(), paramJoint.getAnchorB(), this.JOINT_COLOR);
      return;
    }
    drawSegment(localVector21, localVector23, this.JOINT_COLOR);
    drawSegment(localVector23, localVector24, this.JOINT_COLOR);
    drawSegment(localVector22, localVector24, this.JOINT_COLOR);
  }

  private void drawSegment(Vector2 paramVector21, Vector2 paramVector22, Color paramColor)
  {
    this.renderer.setColor(paramColor);
    this.renderer.line(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y);
  }

  private void drawShape(Fixture paramFixture, Transform paramTransform, Color paramColor)
  {
    int i = 0;
    if (paramFixture.getType() == Shape.Type.Circle)
    {
      CircleShape localCircleShape = (CircleShape)paramFixture.getShape();
      t.set(localCircleShape.getPosition());
      paramTransform.mul(t);
      drawSolidCircle(t, localCircleShape.getRadius(), axis.set(paramTransform.vals[2], paramTransform.vals[3]), paramColor);
    }
    do
    {
      return;
      if (paramFixture.getType() == Shape.Type.Edge)
      {
        EdgeShape localEdgeShape = (EdgeShape)paramFixture.getShape();
        localEdgeShape.getVertex1(vertices[0]);
        localEdgeShape.getVertex2(vertices[1]);
        paramTransform.mul(vertices[0]);
        paramTransform.mul(vertices[1]);
        drawSolidPolygon(vertices, 2, paramColor, true);
        return;
      }
      if (paramFixture.getType() != Shape.Type.Polygon)
        continue;
      PolygonShape localPolygonShape = (PolygonShape)paramFixture.getShape();
      int m = localPolygonShape.getVertexCount();
      while (i < m)
      {
        localPolygonShape.getVertex(i, vertices[i]);
        paramTransform.mul(vertices[i]);
        i++;
      }
      drawSolidPolygon(vertices, m, paramColor, true);
      return;
    }
    while (paramFixture.getType() != Shape.Type.Chain);
    ChainShape localChainShape = (ChainShape)paramFixture.getShape();
    int j = localChainShape.getVertexCount();
    for (int k = 0; k < j; k++)
    {
      localChainShape.getVertex(k, vertices[k]);
      paramTransform.mul(vertices[k]);
    }
    drawSolidPolygon(vertices, j, paramColor, false);
  }

  private void drawSolidCircle(Vector2 paramVector21, float paramFloat, Vector2 paramVector22, Color paramColor)
  {
    this.renderer.setColor(paramColor.r, paramColor.g, paramColor.b, paramColor.a);
    int i = 0;
    float f1 = 0.0F;
    if (i < 20)
    {
      this.v.set(paramFloat * (float)Math.cos(f1) + paramVector21.x, paramFloat * (float)Math.sin(f1) + paramVector21.y);
      if (i == 0)
      {
        this.lv.set(this.v);
        this.f.set(this.v);
      }
      while (true)
      {
        i++;
        f1 += 0.3141593F;
        break;
        this.renderer.line(this.lv.x, this.lv.y, this.v.x, this.v.y);
        this.lv.set(this.v);
      }
    }
    this.renderer.line(this.f.x, this.f.y, this.lv.x, this.lv.y);
    this.renderer.line(paramVector21.x, paramVector21.y, 0.0F, paramVector21.x + paramFloat * paramVector22.x, paramVector21.y + paramFloat * paramVector22.y, 0.0F);
  }

  private void drawSolidPolygon(Vector2[] paramArrayOfVector2, int paramInt, Color paramColor, boolean paramBoolean)
  {
    this.renderer.setColor(paramColor.r, paramColor.g, paramColor.b, paramColor.a);
    this.lv.set(paramArrayOfVector2[0]);
    this.f.set(paramArrayOfVector2[0]);
    for (int i = 1; i < paramInt; i++)
    {
      Vector2 localVector2 = paramArrayOfVector2[i];
      this.renderer.line(this.lv.x, this.lv.y, localVector2.x, localVector2.y);
      this.lv.set(localVector2);
    }
    if (paramBoolean)
      this.renderer.line(this.f.x, this.f.y, this.lv.x, this.lv.y);
  }

  public static Vector2 getAxis()
  {
    return axis;
  }

  private Color getColorByBody(Body paramBody)
  {
    if (!paramBody.isActive())
      return this.SHAPE_NOT_ACTIVE;
    if (paramBody.getType() == BodyDef.BodyType.StaticBody)
      return this.SHAPE_STATIC;
    if (paramBody.getType() == BodyDef.BodyType.KinematicBody)
      return this.SHAPE_KINEMATIC;
    if (!paramBody.isAwake())
      return this.SHAPE_NOT_AWAKE;
    return this.SHAPE_AWAKE;
  }

  private void renderBodies(World paramWorld)
  {
    this.renderer.begin(ShapeRenderer.ShapeType.Line);
    if ((this.drawBodies) || (this.drawAABBs))
    {
      paramWorld.getBodies(bodies);
      Iterator localIterator1 = bodies.iterator();
      while (localIterator1.hasNext())
      {
        Body localBody = (Body)localIterator1.next();
        if ((!localBody.isActive()) && (!this.drawInactiveBodies))
          continue;
        renderBody(localBody);
      }
    }
    if (this.drawJoints)
    {
      paramWorld.getJoints(joints);
      Iterator localIterator3 = joints.iterator();
      while (localIterator3.hasNext())
        drawJoint((Joint)localIterator3.next());
    }
    this.renderer.end();
    if (this.drawContacts)
    {
      this.renderer.begin(ShapeRenderer.ShapeType.Point);
      Iterator localIterator2 = paramWorld.getContactList().iterator();
      while (localIterator2.hasNext())
        drawContact((Contact)localIterator2.next());
      this.renderer.end();
    }
  }

  public static void setAxis(Vector2 paramVector2)
  {
    axis = paramVector2;
  }

  public void dispose()
  {
    this.renderer.dispose();
  }

  public boolean isDrawAABBs()
  {
    return this.drawAABBs;
  }

  public boolean isDrawBodies()
  {
    return this.drawBodies;
  }

  public boolean isDrawContacts()
  {
    return this.drawContacts;
  }

  public boolean isDrawInactiveBodies()
  {
    return this.drawInactiveBodies;
  }

  public boolean isDrawJoints()
  {
    return this.drawJoints;
  }

  public boolean isDrawVelocities()
  {
    return this.drawVelocities;
  }

  public void render(World paramWorld, Matrix4 paramMatrix4)
  {
    this.renderer.setProjectionMatrix(paramMatrix4);
    renderBodies(paramWorld);
  }

  protected void renderBody(Body paramBody)
  {
    Transform localTransform = paramBody.getTransform();
    Iterator localIterator = paramBody.getFixtureList().iterator();
    while (localIterator.hasNext())
    {
      Fixture localFixture = (Fixture)localIterator.next();
      if (this.drawBodies)
      {
        drawShape(localFixture, localTransform, getColorByBody(paramBody));
        if (this.drawVelocities)
        {
          Vector2 localVector2 = paramBody.getPosition();
          drawSegment(localVector2, paramBody.getLinearVelocity().add(localVector2), this.VELOCITY_COLOR);
        }
      }
      if (!this.drawAABBs)
        continue;
      drawAABB(localFixture, localTransform);
    }
  }

  public void setDrawAABBs(boolean paramBoolean)
  {
    this.drawAABBs = paramBoolean;
  }

  public void setDrawBodies(boolean paramBoolean)
  {
    this.drawBodies = paramBoolean;
  }

  public void setDrawContacts(boolean paramBoolean)
  {
    this.drawContacts = paramBoolean;
  }

  public void setDrawInactiveBodies(boolean paramBoolean)
  {
    this.drawInactiveBodies = paramBoolean;
  }

  public void setDrawJoints(boolean paramBoolean)
  {
    this.drawJoints = paramBoolean;
  }

  public void setDrawVelocities(boolean paramBoolean)
  {
    this.drawVelocities = paramBoolean;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
 * JD-Core Version:    0.6.0
 */