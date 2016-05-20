package com.badlogic.gdx.math;

import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;
import java.util.List;

public final class Intersector
{
  static Vector3 best;
  private static final Vector3 dir;
  private static final Vector3 i;
  static Vector3 intersection;
  private static final Plane p;
  private static final Vector3 start;
  static Vector3 tmp;
  static Vector3 tmp1;
  static Vector3 tmp2;
  static Vector3 tmp3;
  private static final Vector3 v0 = new Vector3();
  private static final Vector3 v1 = new Vector3();
  private static final Vector3 v2 = new Vector3();
  static Vector2 v2tmp;

  static
  {
    p = new Plane(new Vector3(), 0.0F);
    i = new Vector3();
    dir = new Vector3();
    start = new Vector3();
    best = new Vector3();
    tmp = new Vector3();
    tmp1 = new Vector3();
    tmp2 = new Vector3();
    tmp3 = new Vector3();
    v2tmp = new Vector2();
    intersection = new Vector3();
  }

  static float det(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
  }

  static double detd(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return paramDouble1 * paramDouble4 - paramDouble2 * paramDouble3;
  }

  public static float distanceLinePoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f = (float)Math.sqrt((paramFloat3 - paramFloat1) * (paramFloat3 - paramFloat1) + (paramFloat4 - paramFloat2) * (paramFloat4 - paramFloat2));
    return Math.abs((paramFloat5 - paramFloat1) * (paramFloat4 - paramFloat2) - (paramFloat6 - paramFloat2) * (paramFloat3 - paramFloat1)) / f;
  }

  public static float distanceSegmentPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return nearestSegmentPoint(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, v2tmp).dst(paramFloat5, paramFloat6);
  }

  public static float distanceSegmentPoint(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23)
  {
    return nearestSegmentPoint(paramVector21, paramVector22, paramVector23, v2tmp).dst(paramVector23);
  }

  public static float intersectLinePlane(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Plane paramPlane, Vector3 paramVector3)
  {
    Vector3 localVector31 = tmp.set(paramFloat4, paramFloat5, paramFloat6).sub(paramFloat1, paramFloat2, paramFloat3);
    Vector3 localVector32 = tmp2.set(paramFloat1, paramFloat2, paramFloat3);
    float f1 = localVector31.dot(paramPlane.getNormal());
    float f2;
    if (f1 != 0.0F)
    {
      f2 = -(localVector32.dot(paramPlane.getNormal()) + paramPlane.getD()) / f1;
      if (paramVector3 != null)
        paramVector3.set(localVector32).add(localVector31.scl(f2));
    }
    while (true)
    {
      return f2;
      if (paramPlane.testPoint(localVector32) != Plane.PlaneSide.OnPlane)
        break;
      f2 = 0.0F;
      if (paramVector3 == null)
        continue;
      paramVector3.set(localVector32);
      return 0.0F;
    }
    return -1.0F;
  }

  public static boolean intersectLinePolygon(Vector2 paramVector21, Vector2 paramVector22, Polygon paramPolygon)
  {
    float[] arrayOfFloat = paramPolygon.getTransformedVertices();
    float f1 = paramVector21.x;
    float f2 = paramVector21.y;
    float f3 = paramVector22.x;
    float f4 = paramVector22.y;
    int j = arrayOfFloat.length;
    float f5 = arrayOfFloat[(j - 2)];
    float f6 = arrayOfFloat[(j - 1)];
    int k = 0;
    float f7 = f5;
    while (k < j)
    {
      float f8 = arrayOfFloat[k];
      float f9 = arrayOfFloat[(k + 1)];
      float f10 = (f9 - f6) * (f3 - f1) - (f8 - f7) * (f4 - f2);
      if (f10 != 0.0F)
      {
        float f11 = f2 - f6;
        float f12 = f1 - f7;
        float f13 = (f11 * (f8 - f7) - f12 * (f9 - f6)) / f10;
        if ((f13 >= 0.0F) && (f13 <= 1.0F))
          return true;
      }
      k += 2;
      f6 = f9;
      f7 = f8;
    }
    return false;
  }

  public static boolean intersectLines(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, Vector2 paramVector2)
  {
    float f1 = (paramFloat8 - paramFloat6) * (paramFloat3 - paramFloat1) - (paramFloat7 - paramFloat5) * (paramFloat4 - paramFloat2);
    if (f1 == 0.0F)
      return false;
    if (paramVector2 != null)
    {
      float f2 = ((paramFloat7 - paramFloat5) * (paramFloat2 - paramFloat6) - (paramFloat8 - paramFloat6) * (paramFloat1 - paramFloat5)) / f1;
      paramVector2.set(paramFloat1 + f2 * (paramFloat3 - paramFloat1), paramFloat2 + f2 * (paramFloat4 - paramFloat2));
    }
    return true;
  }

  public static boolean intersectLines(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24, Vector2 paramVector25)
  {
    float f1 = paramVector21.x;
    float f2 = paramVector21.y;
    float f3 = paramVector22.x;
    float f4 = paramVector22.y;
    float f5 = paramVector23.x;
    float f6 = paramVector23.y;
    float f7 = paramVector24.x;
    float f8 = paramVector24.y;
    float f9 = (f8 - f6) * (f3 - f1) - (f7 - f5) * (f4 - f2);
    if (f9 == 0.0F)
      return false;
    if (paramVector25 != null)
    {
      float f10 = ((f7 - f5) * (f2 - f6) - (f8 - f6) * (f1 - f5)) / f9;
      paramVector25.set(f1 + f10 * (f3 - f1), f2 + f10 * (f4 - f2));
    }
    return true;
  }

  public static boolean intersectRayBounds(Ray paramRay, BoundingBox paramBoundingBox, Vector3 paramVector3)
  {
    int j = 1;
    if (paramBoundingBox.contains(paramRay.origin))
    {
      if (paramVector3 != null)
        paramVector3.set(paramRay.origin);
      return j;
    }
    float f1;
    int k;
    if ((paramRay.origin.x <= paramBoundingBox.min.x) && (paramRay.direction.x > 0.0F))
    {
      f1 = (paramBoundingBox.min.x - paramRay.origin.x) / paramRay.direction.x;
      if (f1 >= 0.0F)
      {
        v2.set(paramRay.direction).scl(f1).add(paramRay.origin);
        if ((v2.y >= paramBoundingBox.min.y) && (v2.y <= paramBoundingBox.max.y) && (v2.z >= paramBoundingBox.min.z) && (v2.z <= paramBoundingBox.max.z))
          k = j;
      }
    }
    while (true)
    {
      if ((paramRay.origin.x >= paramBoundingBox.max.x) && (paramRay.direction.x < 0.0F))
      {
        float f6 = (paramBoundingBox.max.x - paramRay.origin.x) / paramRay.direction.x;
        if (f6 >= 0.0F)
        {
          v2.set(paramRay.direction).scl(f6).add(paramRay.origin);
          if ((v2.y >= paramBoundingBox.min.y) && (v2.y <= paramBoundingBox.max.y) && (v2.z >= paramBoundingBox.min.z) && (v2.z <= paramBoundingBox.max.z) && ((k == 0) || (f6 < f1)))
          {
            k = j;
            f1 = f6;
          }
        }
      }
      if ((paramRay.origin.y <= paramBoundingBox.min.y) && (paramRay.direction.y > 0.0F))
      {
        float f5 = (paramBoundingBox.min.y - paramRay.origin.y) / paramRay.direction.y;
        if (f5 >= 0.0F)
        {
          v2.set(paramRay.direction).scl(f5).add(paramRay.origin);
          if ((v2.x >= paramBoundingBox.min.x) && (v2.x <= paramBoundingBox.max.x) && (v2.z >= paramBoundingBox.min.z) && (v2.z <= paramBoundingBox.max.z) && ((k == 0) || (f5 < f1)))
          {
            k = j;
            f1 = f5;
          }
        }
      }
      if ((paramRay.origin.y >= paramBoundingBox.max.y) && (paramRay.direction.y < 0.0F))
      {
        float f4 = (paramBoundingBox.max.y - paramRay.origin.y) / paramRay.direction.y;
        if (f4 >= 0.0F)
        {
          v2.set(paramRay.direction).scl(f4).add(paramRay.origin);
          if ((v2.x >= paramBoundingBox.min.x) && (v2.x <= paramBoundingBox.max.x) && (v2.z >= paramBoundingBox.min.z) && (v2.z <= paramBoundingBox.max.z) && ((k == 0) || (f4 < f1)))
          {
            k = j;
            f1 = f4;
          }
        }
      }
      if ((paramRay.origin.z <= paramBoundingBox.min.z) && (paramRay.direction.z > 0.0F))
      {
        float f3 = (paramBoundingBox.min.z - paramRay.origin.z) / paramRay.direction.z;
        if (f3 >= 0.0F)
        {
          v2.set(paramRay.direction).scl(f3).add(paramRay.origin);
          if ((v2.x >= paramBoundingBox.min.x) && (v2.x <= paramBoundingBox.max.x) && (v2.y >= paramBoundingBox.min.y) && (v2.y <= paramBoundingBox.max.y) && ((k == 0) || (f3 < f1)))
          {
            k = j;
            f1 = f3;
          }
        }
      }
      if ((paramRay.origin.z >= paramBoundingBox.max.z) && (paramRay.direction.z < 0.0F))
      {
        float f2 = (paramBoundingBox.max.z - paramRay.origin.z) / paramRay.direction.z;
        if (f2 >= 0.0F)
        {
          v2.set(paramRay.direction).scl(f2).add(paramRay.origin);
          if ((v2.x >= paramBoundingBox.min.x) && (v2.x <= paramBoundingBox.max.x) && (v2.y >= paramBoundingBox.min.y) && (v2.y <= paramBoundingBox.max.y) && ((k == 0) || (f2 < f1)))
            f1 = f2;
        }
      }
      while (true)
      {
        if ((j == 0) || (paramVector3 == null))
          break label1245;
        paramVector3.set(paramRay.direction).scl(f1).add(paramRay.origin);
        if (paramVector3.x < paramBoundingBox.min.x)
        {
          paramVector3.x = paramBoundingBox.min.x;
          if (paramVector3.y >= paramBoundingBox.min.y)
            break label1184;
          paramVector3.y = paramBoundingBox.min.y;
        }
        while (true)
        {
          if (paramVector3.z >= paramBoundingBox.min.z)
            break label1213;
          paramVector3.z = paramBoundingBox.min.z;
          return j;
          if (paramVector3.x <= paramBoundingBox.max.x)
            break;
          paramVector3.x = paramBoundingBox.max.x;
          break;
          label1184: if (paramVector3.y <= paramBoundingBox.max.y)
            continue;
          paramVector3.y = paramBoundingBox.max.y;
        }
        label1213: if (paramVector3.z <= paramBoundingBox.max.z)
          break;
        paramVector3.z = paramBoundingBox.max.z;
        return j;
        j = k;
      }
      label1245: break;
      k = 0;
      f1 = 0.0F;
    }
  }

  public static boolean intersectRayBoundsFast(Ray paramRay, Vector3 paramVector31, Vector3 paramVector32)
  {
    float f1 = 1.0F / paramRay.direction.x;
    float f2 = 1.0F / paramRay.direction.y;
    float f3 = 1.0F / paramRay.direction.z;
    float f4 = f1 * (paramVector31.x - 0.5F * paramVector32.x - paramRay.origin.x);
    float f5 = f1 * (paramVector31.x + 0.5F * paramVector32.x - paramRay.origin.x);
    if (f4 > f5);
    while (true)
    {
      float f7 = f2 * (paramVector31.y - 0.5F * paramVector32.y - paramRay.origin.y);
      float f8 = f2 * (paramVector31.y + 0.5F * paramVector32.y - paramRay.origin.y);
      if (f7 > f8);
      while (true)
      {
        float f10 = f3 * (paramVector31.z - 0.5F * paramVector32.z - paramRay.origin.z);
        float f11 = f3 * (paramVector31.z + 0.5F * paramVector32.z - paramRay.origin.z);
        if (f10 > f11);
        while (true)
        {
          float f13 = Math.max(Math.max(f5, f8), f11);
          float f14 = Math.min(Math.min(f4, f7), f10);
          return (f14 >= 0.0F) && (f14 >= f13);
          float f12 = f10;
          f10 = f11;
          f11 = f12;
        }
        float f9 = f7;
        f7 = f8;
        f8 = f9;
      }
      float f6 = f4;
      f4 = f5;
      f5 = f6;
    }
  }

  public static boolean intersectRayBoundsFast(Ray paramRay, BoundingBox paramBoundingBox)
  {
    return intersectRayBoundsFast(paramRay, paramBoundingBox.getCenter(tmp1), paramBoundingBox.getDimensions(tmp2));
  }

  public static boolean intersectRayPlane(Ray paramRay, Plane paramPlane, Vector3 paramVector3)
  {
    float f1 = paramRay.direction.dot(paramPlane.getNormal());
    float f2;
    if (f1 != 0.0F)
    {
      f2 = -(paramRay.origin.dot(paramPlane.getNormal()) + paramPlane.getD()) / f1;
      if (f2 >= 0.0F);
    }
    do
    {
      return false;
      if (paramVector3 != null)
        paramVector3.set(paramRay.origin).add(v0.set(paramRay.direction).scl(f2));
      return true;
    }
    while (paramPlane.testPoint(paramRay.origin) != Plane.PlaneSide.OnPlane);
    if (paramVector3 != null)
      paramVector3.set(paramRay.origin);
    return true;
  }

  public static float intersectRayRay(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24)
  {
    float f1 = paramVector23.x - paramVector21.x;
    float f2 = paramVector23.y - paramVector21.y;
    float f3 = paramVector22.x * paramVector24.y - paramVector22.y * paramVector24.x;
    if (f3 == 0.0F)
      return (1.0F / 1.0F);
    float f4 = paramVector24.x / f3;
    return f1 * (paramVector24.y / f3) - f2 * f4;
  }

  public static boolean intersectRaySphere(Ray paramRay, Vector3 paramVector31, float paramFloat, Vector3 paramVector32)
  {
    float f1 = paramRay.direction.dot(paramVector31.x - paramRay.origin.x, paramVector31.y - paramRay.origin.y, paramVector31.z - paramRay.origin.z);
    if (f1 < 0.0F);
    float f2;
    float f3;
    do
    {
      return false;
      f2 = paramVector31.dst2(paramRay.origin.x + f1 * paramRay.direction.x, paramRay.origin.y + f1 * paramRay.direction.y, paramRay.origin.z + f1 * paramRay.direction.z);
      f3 = paramFloat * paramFloat;
    }
    while (f2 > f3);
    if (paramVector32 != null)
      paramVector32.set(paramRay.direction).scl(f1 - (float)Math.sqrt(f3 - f2)).add(paramRay.origin);
    return true;
  }

  public static boolean intersectRayTriangle(Ray paramRay, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34)
  {
    Vector3 localVector31 = v0.set(paramVector32).sub(paramVector31);
    Vector3 localVector32 = v1.set(paramVector33).sub(paramVector31);
    Vector3 localVector33 = v2.set(paramRay.direction).crs(localVector32);
    float f1 = localVector31.dot(localVector33);
    if (MathUtils.isZero(f1))
    {
      p.set(paramVector31, paramVector32, paramVector33);
      if ((p.testPoint(paramRay.origin) == Plane.PlaneSide.OnPlane) && (isPointInTriangle(paramRay.origin, paramVector31, paramVector32, paramVector33)))
        if (paramVector34 != null)
          paramVector34.set(paramRay.origin);
    }
    float f5;
    do
    {
      return true;
      return false;
      float f2 = 1.0F / f1;
      Vector3 localVector34 = i.set(paramRay.origin).sub(paramVector31);
      float f3 = f2 * localVector34.dot(localVector33);
      if ((f3 < 0.0F) || (f3 > 1.0F))
        return false;
      Vector3 localVector35 = localVector34.crs(localVector31);
      float f4 = f2 * paramRay.direction.dot(localVector35);
      if ((f4 < 0.0F) || (f3 + f4 > 1.0F))
        return false;
      f5 = f2 * localVector32.dot(localVector35);
      if (f5 < 0.0F)
        return false;
    }
    while (paramVector34 == null);
    if (f5 <= 1.0E-006F)
    {
      paramVector34.set(paramRay.origin);
      return true;
    }
    paramRay.getEndPoint(paramVector34, f5);
    return true;
  }

  public static boolean intersectRayTriangles(Ray paramRay, List paramList, Vector3 paramVector3)
  {
    if (paramList.size() % 3 != 0)
      throw new RuntimeException("triangle list size is not a multiple of 3");
    int j = 0;
    int k = 0;
    float f1 = 3.4028235E+38F;
    float f2;
    int m;
    if (j < -2 + paramList.size())
    {
      if (intersectRayTriangle(paramRay, (Vector3)paramList.get(j), (Vector3)paramList.get(j + 1), (Vector3)paramList.get(j + 2), tmp) != true)
        break label157;
      f2 = paramRay.origin.dst2(tmp);
      if (f2 >= f1)
        break label157;
      best.set(tmp);
      m = 1;
    }
    while (true)
    {
      j += 3;
      k = m;
      f1 = f2;
      break;
      if (k == 0)
        return false;
      if (paramVector3 != null)
        paramVector3.set(best);
      return true;
      label157: m = k;
      f2 = f1;
    }
  }

  public static boolean intersectRayTriangles(Ray paramRay, float[] paramArrayOfFloat, Vector3 paramVector3)
  {
    if (paramArrayOfFloat.length / 3 % 3 != 0)
      throw new RuntimeException("triangle list size is not a multiple of 3");
    int j = 0;
    float f1 = 3.4028235E+38F;
    for (int k = 0; k < -6 + paramArrayOfFloat.length; k += 9)
    {
      if (intersectRayTriangle(paramRay, tmp1.set(paramArrayOfFloat[k], paramArrayOfFloat[(k + 1)], paramArrayOfFloat[(k + 2)]), tmp2.set(paramArrayOfFloat[(k + 3)], paramArrayOfFloat[(k + 4)], paramArrayOfFloat[(k + 5)]), tmp3.set(paramArrayOfFloat[(k + 6)], paramArrayOfFloat[(k + 7)], paramArrayOfFloat[(k + 8)]), tmp) != true)
        continue;
      float f2 = paramRay.origin.dst2(tmp);
      if (f2 >= f1)
        continue;
      best.set(tmp);
      j = 1;
      f1 = f2;
    }
    if (j == 0)
      return false;
    if (paramVector3 != null)
      paramVector3.set(best);
    return true;
  }

  public static boolean intersectRayTriangles(Ray paramRay, float[] paramArrayOfFloat, short[] paramArrayOfShort, int paramInt, Vector3 paramVector3)
  {
    if (paramArrayOfShort.length % 3 != 0)
      throw new RuntimeException("triangle list size is not a multiple of 3");
    int j = 0;
    float f1 = 3.4028235E+38F;
    for (int k = 0; k < paramArrayOfShort.length; k += 3)
    {
      int m = paramInt * paramArrayOfShort[k];
      int n = paramInt * paramArrayOfShort[(k + 1)];
      int i1 = paramInt * paramArrayOfShort[(k + 2)];
      if (intersectRayTriangle(paramRay, tmp1.set(paramArrayOfFloat[m], paramArrayOfFloat[(m + 1)], paramArrayOfFloat[(m + 2)]), tmp2.set(paramArrayOfFloat[n], paramArrayOfFloat[(n + 1)], paramArrayOfFloat[(n + 2)]), tmp3.set(paramArrayOfFloat[i1], paramArrayOfFloat[(i1 + 1)], paramArrayOfFloat[(i1 + 2)]), tmp) != true)
        continue;
      float f2 = paramRay.origin.dst2(tmp);
      if (f2 >= f1)
        continue;
      best.set(tmp);
      j = 1;
      f1 = f2;
    }
    if (j == 0)
      return false;
    if (paramVector3 != null)
      paramVector3.set(best);
    return true;
  }

  public static boolean intersectRectangles(Rectangle paramRectangle1, Rectangle paramRectangle2, Rectangle paramRectangle3)
  {
    if (paramRectangle1.overlaps(paramRectangle2))
    {
      paramRectangle3.x = Math.max(paramRectangle1.x, paramRectangle2.x);
      paramRectangle3.width = (Math.min(paramRectangle1.x + paramRectangle1.width, paramRectangle2.x + paramRectangle2.width) - paramRectangle3.x);
      paramRectangle3.y = Math.max(paramRectangle1.y, paramRectangle2.y);
      paramRectangle3.height = (Math.min(paramRectangle1.y + paramRectangle1.height, paramRectangle2.y + paramRectangle2.height) - paramRectangle3.y);
      return true;
    }
    return false;
  }

  public static boolean intersectSegmentCircle(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, float paramFloat)
  {
    tmp.set(paramVector22.x - paramVector21.x, paramVector22.y - paramVector21.y, 0.0F);
    tmp1.set(paramVector23.x - paramVector21.x, paramVector23.y - paramVector21.y, 0.0F);
    float f1 = tmp.len();
    float f2 = tmp1.dot(tmp.nor());
    if (f2 <= 0.0F)
      tmp2.set(paramVector21.x, paramVector21.y, 0.0F);
    while (true)
    {
      float f3 = paramVector23.x - tmp2.x;
      float f4 = paramVector23.y - tmp2.y;
      if (f3 * f3 + f4 * f4 > paramFloat)
        break;
      return true;
      if (f2 >= f1)
      {
        tmp2.set(paramVector22.x, paramVector22.y, 0.0F);
        continue;
      }
      tmp3.set(tmp.scl(f2));
      tmp2.set(tmp3.x + paramVector21.x, tmp3.y + paramVector21.y, 0.0F);
    }
    return false;
  }

  public static float intersectSegmentCircleDisplace(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, float paramFloat, Vector2 paramVector24)
  {
    float f1 = (paramVector23.x - paramVector21.x) * (paramVector22.x - paramVector21.x) + (paramVector23.y - paramVector21.y) * (paramVector22.y - paramVector21.y);
    float f2 = paramVector21.dst(paramVector22);
    float f3 = f1 / (f2 * f2);
    if ((f3 < 0.0F) || (f3 > 1.0F))
      return (1.0F / 1.0F);
    tmp.set(paramVector22.x, paramVector22.y, 0.0F).sub(paramVector21.x, paramVector21.y, 0.0F);
    tmp2.set(paramVector21.x, paramVector21.y, 0.0F).add(tmp.scl(f3));
    float f4 = tmp2.dst(paramVector23.x, paramVector23.y, 0.0F);
    if (f4 < paramFloat)
    {
      paramVector24.set(paramVector23).sub(tmp2.x, tmp2.y).nor();
      return f4;
    }
    return (1.0F / 1.0F);
  }

  public static boolean intersectSegmentPlane(Vector3 paramVector31, Vector3 paramVector32, Plane paramPlane, Vector3 paramVector33)
  {
    Vector3 localVector3 = v0.set(paramVector32).sub(paramVector31);
    float f1 = localVector3.dot(paramPlane.getNormal());
    float f2 = -(paramVector31.dot(paramPlane.getNormal()) + paramPlane.getD()) / f1;
    if ((f2 < 0.0F) || (f2 > 1.0F))
      return false;
    paramVector33.set(paramVector31).add(localVector3.scl(f2));
    return true;
  }

  public static boolean intersectSegmentPolygon(Vector2 paramVector21, Vector2 paramVector22, Polygon paramPolygon)
  {
    float[] arrayOfFloat = paramPolygon.getTransformedVertices();
    float f1 = paramVector21.x;
    float f2 = paramVector21.y;
    float f3 = paramVector22.x;
    float f4 = paramVector22.y;
    int j = arrayOfFloat.length;
    float f5 = arrayOfFloat[(j - 2)];
    float f6 = arrayOfFloat[(j - 1)];
    int k = 0;
    float f7 = f5;
    while (k < j)
    {
      float f8 = arrayOfFloat[k];
      float f9 = arrayOfFloat[(k + 1)];
      float f10 = (f9 - f6) * (f3 - f1) - (f8 - f7) * (f4 - f2);
      if (f10 != 0.0F)
      {
        float f11 = f2 - f6;
        float f12 = f1 - f7;
        float f13 = (f11 * (f8 - f7) - f12 * (f9 - f6)) / f10;
        if ((f13 >= 0.0F) && (f13 <= 1.0F))
        {
          float f14 = (f11 * (f3 - f1) - f12 * (f4 - f2)) / f10;
          if ((f14 >= 0.0F) && (f14 <= 1.0F))
            return true;
        }
      }
      k += 2;
      f6 = f9;
      f7 = f8;
    }
    return false;
  }

  public static boolean intersectSegments(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, Vector2 paramVector2)
  {
    float f1 = (paramFloat8 - paramFloat6) * (paramFloat3 - paramFloat1) - (paramFloat7 - paramFloat5) * (paramFloat4 - paramFloat2);
    if (f1 == 0.0F)
      return false;
    float f2 = paramFloat2 - paramFloat6;
    float f3 = paramFloat1 - paramFloat5;
    float f4 = (f2 * (paramFloat7 - paramFloat5) - f3 * (paramFloat8 - paramFloat6)) / f1;
    if ((f4 < 0.0F) || (f4 > 1.0F))
      return false;
    float f5 = (f2 * (paramFloat3 - paramFloat1) - f3 * (paramFloat4 - paramFloat2)) / f1;
    if ((f5 < 0.0F) || (f5 > 1.0F))
      return false;
    if (paramVector2 != null)
      paramVector2.set(paramFloat1 + f4 * (paramFloat3 - paramFloat1), paramFloat2 + f4 * (paramFloat4 - paramFloat2));
    return true;
  }

  public static boolean intersectSegments(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24, Vector2 paramVector25)
  {
    float f1 = paramVector21.x;
    float f2 = paramVector21.y;
    float f3 = paramVector22.x;
    float f4 = paramVector22.y;
    float f5 = paramVector23.x;
    float f6 = paramVector23.y;
    float f7 = paramVector24.x;
    float f8 = paramVector24.y;
    float f9 = (f8 - f6) * (f3 - f1) - (f7 - f5) * (f4 - f2);
    if (f9 == 0.0F)
      return false;
    float f10 = f2 - f6;
    float f11 = f1 - f5;
    float f12 = (f10 * (f7 - f5) - f11 * (f8 - f6)) / f9;
    if ((f12 < 0.0F) || (f12 > 1.0F))
      return false;
    float f13 = (f10 * (f3 - f1) - f11 * (f4 - f2)) / f9;
    if ((f13 < 0.0F) || (f13 > 1.0F))
      return false;
    if (paramVector25 != null)
      paramVector25.set(f1 + f12 * (f3 - f1), f2 + f12 * (f4 - f2));
    return true;
  }

  public static boolean isPointInPolygon(Array paramArray, Vector2 paramVector2)
  {
    Vector2 localVector21 = (Vector2)paramArray.peek();
    int j = 0;
    int k = 0;
    Object localObject = localVector21;
    if (j < paramArray.size)
    {
      Vector2 localVector22 = (Vector2)paramArray.get(j);
      if (((localVector22.y < paramVector2.y) && (((Vector2)localObject).y >= paramVector2.y)) || ((((Vector2)localObject).y < paramVector2.y) && (localVector22.y >= paramVector2.y) && (localVector22.x + (paramVector2.y - localVector22.y) / (((Vector2)localObject).y - localVector22.y) * (((Vector2)localObject).x - localVector22.x) < paramVector2.x)))
        if (k != 0)
          break label152;
      label152: for (k = 1; ; k = 0)
      {
        j++;
        localObject = localVector22;
        break;
      }
    }
    return k;
  }

  public static boolean isPointInPolygon(float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    int j = -2 + (paramInt1 + paramInt2);
    int k = 0;
    int m = j;
    int n = paramInt1;
    if (n <= j)
    {
      float f1 = paramArrayOfFloat[(n + 1)];
      float f2 = paramArrayOfFloat[(m + 1)];
      if (((f1 < paramFloat2) && (f2 >= paramFloat2)) || ((f2 < paramFloat2) && (f1 >= paramFloat2)))
      {
        float f3 = paramArrayOfFloat[n];
        if (f3 + (paramFloat2 - f1) / (f2 - f1) * (paramArrayOfFloat[m] - f3) < paramFloat1)
          if (k != 0)
            break label131;
      }
      label131: for (k = 1; ; k = 0)
      {
        int i1 = n + 2;
        m = n;
        n = i1;
        break;
      }
    }
    return k;
  }

  public static boolean isPointInTriangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    float f1 = paramFloat1 - paramFloat3;
    float f2 = paramFloat2 - paramFloat4;
    int j;
    int k;
    if (f2 * (paramFloat5 - paramFloat3) - f1 * (paramFloat6 - paramFloat4) > 0.0F)
    {
      j = 1;
      if (f2 * (paramFloat7 - paramFloat3) - f1 * (paramFloat8 - paramFloat4) <= 0.0F)
        break label71;
      k = 1;
      label56: if (k != j)
        break label77;
    }
    while (true)
    {
      return false;
      j = 0;
      break;
      label71: k = 0;
      break label56;
      label77: if ((paramFloat7 - paramFloat5) * (paramFloat2 - paramFloat6) - (paramFloat8 - paramFloat6) * (paramFloat1 - paramFloat5) > 0.0F);
      for (int m = 1; m == j; m = 0)
        return true;
    }
  }

  public static boolean isPointInTriangle(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24)
  {
    float f1 = paramVector21.x - paramVector22.x;
    float f2 = paramVector21.y - paramVector22.y;
    int j;
    int k;
    if (f2 * (paramVector23.x - paramVector22.x) - f1 * (paramVector23.y - paramVector22.y) > 0.0F)
    {
      j = 1;
      if (f2 * (paramVector24.x - paramVector22.x) - f1 * (paramVector24.y - paramVector22.y) <= 0.0F)
        break label103;
      k = 1;
      label88: if (k != j)
        break label109;
    }
    while (true)
    {
      return false;
      j = 0;
      break;
      label103: k = 0;
      break label88;
      label109: if ((paramVector24.x - paramVector23.x) * (paramVector21.y - paramVector23.y) - (paramVector24.y - paramVector23.y) * (paramVector21.x - paramVector23.x) > 0.0F);
      for (int m = 1; m == j; m = 0)
        return true;
    }
  }

  public static boolean isPointInTriangle(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34)
  {
    v0.set(paramVector32).sub(paramVector31);
    v1.set(paramVector33).sub(paramVector31);
    v2.set(paramVector34).sub(paramVector31);
    float f1 = v0.dot(v1);
    float f2 = v0.dot(v2);
    float f3 = v1.dot(v2);
    float f4 = v2.dot(v2);
    if (f3 * f2 - f4 * f1 < 0.0F);
    float f5;
    do
    {
      return false;
      f5 = v1.dot(v1);
    }
    while (f1 * f3 - f2 * f5 < 0.0F);
    return true;
  }

  public static Vector2 nearestSegmentPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Vector2 paramVector2)
  {
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    float f3 = f1 * f1 + f2 * f2;
    if (f3 == 0.0F)
      return paramVector2.set(paramFloat1, paramFloat2);
    float f4 = (f1 * (paramFloat5 - paramFloat1) + f2 * (paramFloat6 - paramFloat2)) / f3;
    if (f4 < 0.0F)
      return paramVector2.set(paramFloat1, paramFloat2);
    if (f4 > 1.0F)
      return paramVector2.set(paramFloat3, paramFloat4);
    return paramVector2.set(paramFloat1 + f1 * f4, paramFloat2 + f2 * f4);
  }

  public static Vector2 nearestSegmentPoint(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24)
  {
    float f1 = paramVector21.dst2(paramVector22);
    if (f1 == 0.0F)
      return paramVector24.set(paramVector21);
    float f2 = ((paramVector23.x - paramVector21.x) * (paramVector22.x - paramVector21.x) + (paramVector23.y - paramVector21.y) * (paramVector22.y - paramVector21.y)) / f1;
    if (f2 < 0.0F)
      return paramVector24.set(paramVector21);
    if (f2 > 1.0F)
      return paramVector24.set(paramVector22);
    return paramVector24.set(paramVector21.x + f2 * (paramVector22.x - paramVector21.x), paramVector21.y + f2 * (paramVector22.y - paramVector21.y));
  }

  public static boolean overlapConvexPolygons(Polygon paramPolygon1, Polygon paramPolygon2)
  {
    return overlapConvexPolygons(paramPolygon1, paramPolygon2, null);
  }

  public static boolean overlapConvexPolygons(Polygon paramPolygon1, Polygon paramPolygon2, Intersector.MinimumTranslationVector paramMinimumTranslationVector)
  {
    return overlapConvexPolygons(paramPolygon1.getTransformedVertices(), paramPolygon2.getTransformedVertices(), paramMinimumTranslationVector);
  }

  public static boolean overlapConvexPolygons(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, int paramInt3, int paramInt4, Intersector.MinimumTranslationVector paramMinimumTranslationVector)
  {
    float f1 = 3.4028235E+38F;
    float f2 = 0.0F;
    float f3 = 0.0F;
    int j = paramInt1 + paramInt2;
    int k = paramInt3 + paramInt4;
    int m = paramInt1;
    float f29;
    float f30;
    float f31;
    float f32;
    float f36;
    float f37;
    float f38;
    int i4;
    float f39;
    label136: float f49;
    float f50;
    if (m < j)
    {
      f29 = paramArrayOfFloat1[m];
      f30 = paramArrayOfFloat1[(m + 1)];
      f31 = paramArrayOfFloat1[((m + 2) % paramInt2)];
      f32 = paramArrayOfFloat1[((m + 3) % paramInt2)];
      float f33 = f30 - f32;
      float f34 = -(f29 - f31);
      float f35 = (float)Math.sqrt(f33 * f33 + f34 * f34);
      f36 = f33 / f35;
      f37 = f34 / f35;
      f38 = f36 * paramArrayOfFloat1[0] + f37 * paramArrayOfFloat1[1];
      i4 = paramInt1;
      f39 = f38;
      if (i4 < j)
      {
        f49 = f36 * paramArrayOfFloat1[i4] + f37 * paramArrayOfFloat1[(i4 + 1)];
        if (f49 < f39)
        {
          f50 = f49;
          f49 = f38;
        }
      }
    }
    while (true)
    {
      i4 += 2;
      f39 = f50;
      f38 = f49;
      break label136;
      if (f49 > f38)
      {
        f50 = f39;
        continue;
        float f40 = f36 * paramArrayOfFloat2[0] + f37 * paramArrayOfFloat2[1];
        int i5 = paramInt3;
        float f41 = f40;
        int i6 = 0;
        label233: float f47;
        float f48;
        if (i5 < k)
        {
          i6 -= pointLineSide(f29, f30, f31, f32, paramArrayOfFloat2[i5], paramArrayOfFloat2[(i5 + 1)]);
          f47 = f36 * paramArrayOfFloat2[i5] + f37 * paramArrayOfFloat2[(i5 + 1)];
          if (f47 < f41)
          {
            f48 = f47;
            f47 = f40;
          }
        }
        while (true)
        {
          i5 += 2;
          f41 = f48;
          f40 = f47;
          break label233;
          if (f47 > f40)
          {
            f48 = f41;
            continue;
            if (((f39 > f41) || (f38 < f41)) && ((f41 > f39) || (f40 < f39)))
              return false;
            float f42 = Math.min(f38, f40) - Math.max(f39, f41);
            float f46;
            label448: float f44;
            label465: float f43;
            if (((f39 < f41) && (f38 > f40)) || ((f41 < f39) && (f40 > f38)))
            {
              float f45 = Math.abs(f39 - f41);
              f46 = Math.abs(f38 - f40);
              if (f45 < f46)
                f42 += f45;
            }
            else
            {
              if (f42 >= f1)
                break label1087;
              if (i6 < 0)
                break label502;
              f44 = f36;
              if (i6 < 0)
                break label510;
              f43 = f37;
            }
            while (true)
            {
              m += 2;
              f3 = f43;
              f2 = f44;
              f1 = f42;
              break;
              f42 += f46;
              break label448;
              label502: f44 = -f36;
              break label465;
              label510: f43 = -f37;
              continue;
              int n = paramInt3;
              float f4 = f3;
              float f5 = f2;
              float f6 = f1;
              float f14;
              float f15;
              float f16;
              int i1;
              float f17;
              int i2;
              label649: float f27;
              float f28;
              if (n < k)
              {
                float f7 = paramArrayOfFloat2[n];
                float f8 = paramArrayOfFloat2[(n + 1)];
                float f9 = paramArrayOfFloat2[((n + 2) % paramInt4)];
                float f10 = paramArrayOfFloat2[((n + 3) % paramInt4)];
                float f11 = f8 - f10;
                float f12 = -(f7 - f9);
                float f13 = (float)Math.sqrt(f11 * f11 + f12 * f12);
                f14 = f11 / f13;
                f15 = f12 / f13;
                f16 = f14 * paramArrayOfFloat1[0] + f15 * paramArrayOfFloat1[1];
                i1 = paramInt1;
                f17 = f16;
                i2 = 0;
                if (i1 < j)
                {
                  f27 = f14 * paramArrayOfFloat1[i1] + f15 * paramArrayOfFloat1[(i1 + 1)];
                  i2 -= pointLineSide(f7, f8, f9, f10, paramArrayOfFloat1[i1], paramArrayOfFloat1[(i1 + 1)]);
                  if (f27 < f17)
                    f28 = f16;
                }
              }
              while (true)
              {
                i1 += 2;
                f16 = f28;
                f17 = f27;
                break label649;
                if (f27 > f16)
                {
                  f28 = f27;
                  f27 = f17;
                  continue;
                  float f18 = f14 * paramArrayOfFloat2[0] + f15 * paramArrayOfFloat2[1];
                  int i3 = paramInt3;
                  float f19 = f18;
                  label769: float f26;
                  if (i3 < k)
                  {
                    f26 = f14 * paramArrayOfFloat2[i3] + f15 * paramArrayOfFloat2[(i3 + 1)];
                    if (f26 >= f19);
                  }
                  while (true)
                  {
                    i3 += 2;
                    f19 = f26;
                    break label769;
                    if (f26 > f18)
                    {
                      f18 = f26;
                      f26 = f19;
                      continue;
                      if (((f17 > f19) || (f16 < f19)) && ((f19 > f17) || (f18 < f17)))
                        return false;
                      float f20 = Math.min(f16, f18) - Math.max(f17, f19);
                      float f25;
                      float f21;
                      if (((f17 < f19) && (f16 > f18)) || ((f19 < f17) && (f18 > f16)))
                      {
                        float f24 = Math.abs(f17 - f19);
                        f25 = Math.abs(f16 - f18);
                        if (f24 < f25)
                          f21 = f24 + f20;
                      }
                      while (true)
                      {
                        label950: float f23;
                        label967: float f22;
                        if (f21 < f6)
                          if (i2 < 0)
                          {
                            f23 = f14;
                            if (i2 >= 0)
                              break label1012;
                            f22 = f15;
                          }
                        while (true)
                        {
                          n += 2;
                          f4 = f22;
                          f5 = f23;
                          f6 = f21;
                          break;
                          f21 = f20 + f25;
                          break label950;
                          f23 = -f14;
                          break label967;
                          label1012: f22 = -f15;
                          continue;
                          if (paramMinimumTranslationVector != null)
                          {
                            paramMinimumTranslationVector.normal.set(f5, f4);
                            paramMinimumTranslationVector.depth = f6;
                          }
                          return true;
                          f22 = f4;
                          f23 = f5;
                          f21 = f6;
                        }
                        f21 = f20;
                      }
                    }
                    f26 = f19;
                  }
                }
                f28 = f16;
                f27 = f17;
              }
              label1087: f43 = f3;
              f44 = f2;
              f42 = f1;
            }
          }
          f47 = f40;
          f48 = f41;
        }
      }
      f49 = f38;
      f50 = f39;
    }
  }

  public static boolean overlapConvexPolygons(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, Intersector.MinimumTranslationVector paramMinimumTranslationVector)
  {
    return overlapConvexPolygons(paramArrayOfFloat1, 0, paramArrayOfFloat1.length, paramArrayOfFloat2, 0, paramArrayOfFloat2.length, paramMinimumTranslationVector);
  }

  public static boolean overlaps(Circle paramCircle1, Circle paramCircle2)
  {
    return paramCircle1.overlaps(paramCircle2);
  }

  public static boolean overlaps(Circle paramCircle, Rectangle paramRectangle)
  {
    float f1 = paramCircle.x;
    float f2 = paramCircle.y;
    if (paramCircle.x < paramRectangle.x)
    {
      f1 = paramRectangle.x;
      if (paramCircle.y >= paramRectangle.y)
        break label120;
      f2 = paramRectangle.y;
    }
    while (true)
    {
      float f3 = f1 - paramCircle.x;
      float f4 = f3 * f3;
      float f5 = f2 - paramCircle.y;
      if (f4 + f5 * f5 >= paramCircle.radius * paramCircle.radius)
        break label150;
      return true;
      if (paramCircle.x <= paramRectangle.x + paramRectangle.width)
        break;
      f1 = paramRectangle.x + paramRectangle.width;
      break;
      label120: if (paramCircle.y <= paramRectangle.y + paramRectangle.height)
        continue;
      f2 = paramRectangle.y + paramRectangle.height;
    }
    label150: return false;
  }

  public static boolean overlaps(Rectangle paramRectangle1, Rectangle paramRectangle2)
  {
    return paramRectangle1.overlaps(paramRectangle2);
  }

  public static int pointLineSide(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return (int)Math.signum((paramFloat3 - paramFloat1) * (paramFloat6 - paramFloat2) - (paramFloat4 - paramFloat2) * (paramFloat5 - paramFloat1));
  }

  public static int pointLineSide(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23)
  {
    return (int)Math.signum((paramVector22.x - paramVector21.x) * (paramVector23.y - paramVector21.y) - (paramVector22.y - paramVector21.y) * (paramVector23.x - paramVector21.x));
  }

  private static void splitEdge(float[] paramArrayOfFloat1, int paramInt1, int paramInt2, int paramInt3, Plane paramPlane, float[] paramArrayOfFloat2, int paramInt4)
  {
    float f1 = intersectLinePlane(paramArrayOfFloat1[paramInt1], paramArrayOfFloat1[(paramInt1 + 1)], paramArrayOfFloat1[(paramInt1 + 2)], paramArrayOfFloat1[paramInt2], paramArrayOfFloat1[(paramInt2 + 1)], paramArrayOfFloat1[(paramInt2 + 2)], paramPlane, intersection);
    paramArrayOfFloat2[paramInt4] = intersection.x;
    paramArrayOfFloat2[(paramInt4 + 1)] = intersection.y;
    paramArrayOfFloat2[(paramInt4 + 2)] = intersection.z;
    for (int j = 3; j < paramInt3; j++)
    {
      float f2 = paramArrayOfFloat1[(paramInt1 + j)];
      float f3 = paramArrayOfFloat1[(paramInt2 + j)];
      paramArrayOfFloat2[(paramInt4 + j)] = (f2 + f1 * (f3 - f2));
    }
  }

  public static void splitTriangle(float[] paramArrayOfFloat, Plane paramPlane, Intersector.SplitTriangle paramSplitTriangle)
  {
    int j = paramArrayOfFloat.length / 3;
    int k;
    int m;
    if (paramPlane.testPoint(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]) == Plane.PlaneSide.Back)
    {
      k = 1;
      if (paramPlane.testPoint(paramArrayOfFloat[(j + 0)], paramArrayOfFloat[(j + 1)], paramArrayOfFloat[(j + 2)]) != Plane.PlaneSide.Back)
        break label141;
      m = 1;
      label55: if (paramPlane.testPoint(paramArrayOfFloat[(0 + (j << 1))], paramArrayOfFloat[(1 + (j << 1))], paramArrayOfFloat[(2 + (j << 1))]) != Plane.PlaneSide.Back)
        break label147;
    }
    label141: label147: for (int n = 1; ; n = 0)
    {
      paramSplitTriangle.reset();
      if ((k != m) || (m != n))
        break label171;
      paramSplitTriangle.total = 1;
      if (k == 0)
        break label153;
      paramSplitTriangle.numBack = 1;
      System.arraycopy(paramArrayOfFloat, 0, paramSplitTriangle.back, 0, paramArrayOfFloat.length);
      return;
      k = 0;
      break;
      m = 0;
      break label55;
    }
    label153: paramSplitTriangle.numFront = 1;
    System.arraycopy(paramArrayOfFloat, 0, paramSplitTriangle.front, 0, paramArrayOfFloat.length);
    return;
    label171: paramSplitTriangle.total = 3;
    int i1;
    int i2;
    label192: int i4;
    label207: boolean bool1;
    label237: boolean bool4;
    label290: label306: int i5;
    boolean bool3;
    label359: label375: boolean bool2;
    if (k != 0)
    {
      i1 = 0;
      if (m == 0)
        break label491;
      i2 = 0;
      int i3 = i1 + i2;
      if (n == 0)
        break label497;
      i4 = 0;
      paramSplitTriangle.numFront = (i4 + i3);
      paramSplitTriangle.numBack = (paramSplitTriangle.total - paramSplitTriangle.numFront);
      if (k != 0)
        break label503;
      bool1 = true;
      paramSplitTriangle.setSide(bool1);
      if (k == m)
        break label515;
      splitEdge(paramArrayOfFloat, 0, j, j, paramPlane, paramSplitTriangle.edgeSplit, 0);
      paramSplitTriangle.add(paramArrayOfFloat, 0, j);
      paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, j);
      if (paramSplitTriangle.getSide())
        break label509;
      bool4 = true;
      paramSplitTriangle.setSide(bool4);
      paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, j);
      i5 = j + j;
      if (m == n)
        break label531;
      splitEdge(paramArrayOfFloat, j, i5, j, paramPlane, paramSplitTriangle.edgeSplit, 0);
      paramSplitTriangle.add(paramArrayOfFloat, j, j);
      paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, j);
      if (paramSplitTriangle.getSide())
        break label525;
      bool3 = true;
      paramSplitTriangle.setSide(bool3);
      paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, j);
      if (n == k)
        break label547;
      splitEdge(paramArrayOfFloat, i5, 0, j, paramPlane, paramSplitTriangle.edgeSplit, 0);
      paramSplitTriangle.add(paramArrayOfFloat, i5, j);
      paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, j);
      if (paramSplitTriangle.getSide())
        break label541;
      bool2 = true;
      label424: paramSplitTriangle.setSide(bool2);
      paramSplitTriangle.add(paramSplitTriangle.edgeSplit, 0, j);
    }
    while (true)
    {
      if (paramSplitTriangle.numFront != 2)
        break label558;
      System.arraycopy(paramSplitTriangle.front, j << 1, paramSplitTriangle.front, j * 3, j << 1);
      System.arraycopy(paramSplitTriangle.front, 0, paramSplitTriangle.front, j * 5, j);
      return;
      i1 = 1;
      break;
      label491: i2 = 1;
      break label192;
      label497: i4 = 1;
      break label207;
      label503: bool1 = false;
      break label237;
      label509: bool4 = false;
      break label290;
      label515: paramSplitTriangle.add(paramArrayOfFloat, 0, j);
      break label306;
      label525: bool3 = false;
      break label359;
      label531: paramSplitTriangle.add(paramArrayOfFloat, j, j);
      break label375;
      label541: bool2 = false;
      break label424;
      label547: paramSplitTriangle.add(paramArrayOfFloat, i5, j);
    }
    label558: System.arraycopy(paramSplitTriangle.back, j << 1, paramSplitTriangle.back, j * 3, j << 1);
    System.arraycopy(paramSplitTriangle.back, 0, paramSplitTriangle.back, j * 5, j);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Intersector
 * JD-Core Version:    0.6.0
 */