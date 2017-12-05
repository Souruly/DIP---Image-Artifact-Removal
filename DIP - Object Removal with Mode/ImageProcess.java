import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageProcess
{
  BufferedImage image;
  BufferedImage images[] = new BufferedImage[5];
  int width;
  int height;
  public ImageProcess(String i1, String i2, String i3, String i4, String i5 , String output)
  {
    try
    {
      String[] fileNames = {i1,i2,i3,i4,i5};
      System.out.println("Input Files : ");
      for(String s : fileNames)
      {
      System.out.println(s);
      }
      File input = new File(i4);
      File[] inputs = new File[5];
      for(int k=0 ; k<5 ; k++)
      {
        inputs[k] = new File(fileNames[k]);
      }
      System.out.println("Working... ");

      for(int k=0 ; k<5 ; k++)
      {
        images[k] = ImageIO.read(inputs[k]);
      }
      width = images[0].getWidth();
      height = images[0].getHeight();
      image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
      for(int i=0; i<height; i++)
      {
        for(int j=0; j<width; j++)
        {
          int[] col = {0,0,0,0,0};
          int r=0,g=0,b=0;
          for(int k=0 ; k<5 ; k++)
          {
            Color c = new Color(images[k].getRGB(j, i));
            int red = (int)(c.getRed());
            r += red;
            int green = (int)(c.getGreen());
            g += green;
            int blue = (int)(c.getBlue());
            b += blue;
            col[k] = (red+green+blue)/3;
            col[k] /= 5;
            col[k] *= 5;
          }

          int newCol = mode(col);
          if(newCol!=-1)
          {
            int k = indexOf(newCol,col);
            Color newColor = new Color(images[k].getRGB(j, i));
            image.setRGB(j,i,newColor.getRGB());
          }
          else
          {
            r = r/5;
            g = g/5;
            b = b/5;
            Color newColor = new Color(r,g,b);
            image.setRGB(j,i,newColor.getRGB());
          }
        }
      }

      File ouptut = new File(output);
      ImageIO.write(image, "jpg", ouptut);
      System.out.println("Completed. File Saved as 'output.jpg'.");
    }
    catch (Exception e)
    {}
  }

  public static int mode(int a[])
  {
    int maxValue = a[0], maxCount = 1;

    for (int i = 0; i < a.length; ++i)
    {
      int count = 0;
      for (int j = 0; j < a.length; ++j)
      {
        if (a[j] == a[i]) ++count;
      }
      if (count > maxCount)
      {
        maxCount = count;
        maxValue = a[i];
      }
    }

    if(maxCount==1)
    {
      return -1;
    }
    return maxValue;
  }

  public static int indexOf(int v,int a[])
  {
    for (int i = 0; i < a.length; ++i)
    {
      if (a[i] == v)
      {
        return i;
      }
    }
    return -1;
  }


  public static void main(String args[]) throws Exception
  {
    String[] images = new String[5];
    int l = args.length;
    if(l==0)
    {
      System.out.println("No images specified");
      return;
    }
    else
    {
      if(l<=5)
      {
        for (int i=0 ; i<l ; i++) {
        images[i] = args[i];
        }
        for(int i=0 ; i<5-l ; i++)
        {
          images[l+i] = args[0];
        }
      }
      else
      {
        for (int i=0 ; i<5 ; i++)
        {
          images[i] = args[i];
        }
      }
    }
    ImageProcess obj = new ImageProcess(images[0],images[1],images[2],images[3],images[4],"output.jpg");
  }
}
