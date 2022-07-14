package com.shopme.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        ImageReader imRead = new ImageReader();
        ImageWriter imWrite = new ImageWriter();
        MatrixOperations mat = new MatrixOperations();
        File file = new File("C:\\Users\\Leo\\Desktop\\ShopmeAdminlo2.png");
        imRead.readImage();
       // getColors(new File("C:/Users/Leo/Desktop/ShopmeAdminlo2.png"));
     //  System.out.println(imRead.getColors(new File("C:\\Users\\Leo\\Desktop\\ShopmeAdminlo2.png")));
        
        //System.out.println(imRead.getBlueArray(file));
      Color matrix [][] = imRead.getColors(new File("C:\\Users\\Leo\\Desktop\\ShopmeAdminlo2.png"));
       
       //imRead.printImageMatrix(matrix);
       
     //imRead.printImageMatrix(imRead.getPixels(file, matrix,"green"));
       BufferedImage image = ImageIO.read(file);
//       
//       int r=0;
//       int g=134;
//       int b=145;
//       int rgb = imWrite.combine(r, g, b);
//       
      //System.out.println(imWrite.combine(r, g, b));
       
    // image.setRGB(10, 10, rgb);
       
       Integer red[][] = imRead.getPixels(file, matrix,"red");
       Integer blue[][] = imRead.getPixels(file, matrix,"blue");
       Integer green[][] = imRead.getPixels(file, matrix,"green");
       
       Integer newMatRed [][]= mat.addCoeff(red, -40);
       Integer newMatBlue [][]= mat.addCoeff(blue, -40);
       Integer newMatGreen [][]= mat.addCoeff(green, -40);
       Integer mat1 [][] = new Integer[2][2];
       Integer mat2 [][] = new Integer[2][2];
       
       mat1[0][0]=2;
       mat1[0][1]=3;
       mat1[1][0]=-2;
       mat1[1][1]=9;
       
       mat2[0][0]=-2;
       mat2[0][1]=6;
       mat2[1][0]=-2;
       mat2[1][1]=2;
       
       mat = new MatrixOperations();
      imRead.printImageMatrix(mat.addMatrix(mat1, mat2));
       
      //imRead.printImageMatrix(newMat);
       
      // Integer green[][] = imRead.getPixels(file, matrix,"green");
      // imRead.printImageMatrix(red);
      //imWrite.recombineIntoRGB(newMatRed, newMatBlue, newMatGreen);
       
       
     File f = new File("C:\\Users\\Leo\\Desktop\\imagenew.jpg");
     
      File file1 =  new File("C:/Users/Leo/Desktop/23157318_15876791570802896_o.jpg");
      File file2 =  new File("C:/Users/Leo/Desktop/273291283_4789207161128124_5385243164023758993_n.jpg");
      
      BufferedImage imageToWrite = imWrite.addTwoImages(file1, file2, mat);
     ImageIO.write(imageToWrite, "jpg", f);
     System.out.println(imWrite.recombineIntoRGB(red, green, blue));
       
       
   
    }
}
