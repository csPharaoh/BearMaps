package bearmaps.proj2c.server.handler.impl;

import static bearmaps.proj2c.utils.Constants.*;

public class ImgToData
{

    public static double newllon(String fileName)
    {

        int [] data = FileNameToData(fileName);
        int depth = data [0];
        int x = data [1];
        int y = data [2];

        return (x* getTileWidth(depth)+ ROOT_ULLON);
    }


    public static double newrlon(String fileName)
    {

        int [] data = FileNameToData(fileName);
        int depth = data [0];
        int x = data [1];
        int y = data [2];

        return ((x+1)* getTileWidth(depth)+ ROOT_ULLON);
    }


    public static double newulat(String fileName)
    {
        int [] data = FileNameToData(fileName);
        int depth = data [0];
        int x = data [1];
        int y = data [2];

        return (ROOT_ULLAT-((y)* getTileHeight(depth)));
    }


    public static double newllat(String fileName)
    {
        int [] data = FileNameToData(fileName);
        int depth = data [0];
        int x = data [1];
        int y = data [2];

        return (ROOT_ULLAT -((y+1)* getTileHeight(depth)));
    }


    public static double newlPP(String fileName)
    {
        double totLon = newrlon(fileName) - newllon(fileName);
        double lPP = totLon / 256;

        return lPP;
    }


    private static int [] FileNameToData(String fileName)
    {
        int [] result = new int [3];
        String fName = fileName;

        if(fileName.split("\\.").length > 1)
        {
            fName = fileName.split("\\.")[0];
        }

        String [] tokens = fName.split("_");
        int x = Integer.parseInt(tokens[1].substring(1));
        int y = Integer.parseInt(tokens[2].substring(1));
        int depth = Integer.parseInt(tokens[0].substring(1));

        result [0] = depth;
        result [1] = x;
        result [2] = y;

        return result;
    }



    public  static double getTileWidth(int depth)
    {
        double deltaLat = ROOT_LRLON - ROOT_ULLON;
        deltaLat = deltaLat / Math.pow(2,depth);

        return deltaLat;
    }


    public  static double getTileHeight(int depth)
    {
        double deltaLat = ROOT_ULLAT - ROOT_LRLAT;
        deltaLat = deltaLat / Math.pow(2,depth);

        return deltaLat;
    }

}
