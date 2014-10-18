package com.pycore.imageconversion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by amit on 9/27/2014.
 */
public class Main {

    public static void main(String[] args) {
          BufferedImage img = getImage("IndiaStates_410px.png");
          for (int i=0; i< img.getHeight(); i++) {
              for( int j=0; j < img.getWidth(); j++)
              {
                  int imgRGB = img.getRGB(j, i);
                  System.out.print(getRelativeAsciiShade(convertoGrayScale(imgRGB)));
                  if (j == img.getWidth() - 1)
                  {
                      System.out.println();
                  }
              }
          }

    }

    public static int  convertoGrayScale(int pixel) {
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        return  ( red + green + blue)/3;
    }

    public static BufferedImage getImage(String filePath) {
       BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            System.out.println("Could not load Image from " + filePath);
            e.printStackTrace();
        }
        return img;
    }

    private static String getRelativeAsciiShade(int rgbValue)
    {
        String asciival = " ";

        if (rgbValue >= 230)
        {
            asciival = " ";
        }
        else if (rgbValue >= 200)
        {
            asciival = ".";
        }
        else if (rgbValue >= 180)
        {
            asciival = "*";
        }
        else if (rgbValue >= 160)
        {
            asciival = ":";
        }
        else if (rgbValue >= 130)
        {
            asciival = "o";
        }
        else if (rgbValue >= 100)
        {
            asciival = "&";
        }
        else if (rgbValue >= 70)
        {
            asciival = "8";
        }
        else if (rgbValue >= 50)
        {
            asciival = "#";
        }
        else
        {
            asciival = "@";
        }

        return asciival;
    }
}
