package sample.algorithm;
//This script read 2 BVH file, make the average between line and create a 2nd movement (bvhfile).

import java.io.*;
import java.util.Random;

public class Script {

    int ligneFile1 = 0;
    int ligneFile2 = 0;
    int decalage = 0;

    public void createBVH(String file1, String  file2, Algo algorithm) throws IOException {

        FileWriter out = new FileWriter("../bvh/frankenstein.bvh", true);
        BufferedWriter writer = new BufferedWriter(out);

        FileInputStream fstream =  new FileInputStream(file1);
        FileInputStream fstream2 = new FileInputStream(file2);

        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));

        System.out.println(br + "   " + br2 );


        String strLine;

        //Read File Line By Line


        String line = null;
        String line2 = null;
        String[] numbers = null;
        String[] numbers2 = null;
        float xfile = 0;
        float xfile2 = 0;
        br.readLine();
        br2.readLine();


        while ((line = br.readLine()) != null  && (line2 = br2.readLine()) != null)   {
            // split each line based on regular expression having
            // "any digit followed by one or more spaces".
            numbers = line.split("\\d\\s+");
            //numbers = line.split("[-+]?\\d*\\.?\\d+(?:[eE]([-+]?\\d+))?$/\\s+");
            numbers2 = line2.split("\\d\\s+");


            //Pour chaque float
            for(int it =  0; it < numbers.length; it++){
                if(numbers[it].length() == 0 || numbers[it].length()== 1){
                 //  System.out.println("dans le if");
                    xfile = 0;
                } else {

                    if(Float.valueOf(numbers[it].trim()) == 18.0){
                        xfile = 180.0f;
                    } else {
                        xfile = Float.valueOf(numbers[it].trim());

                    }

                }

                if(numbers2[it].length() == 0 || numbers2[it].length()== 1){
                    //  System.out.println("dans le if");
                    xfile2 = 0;
                } else {
                    if(Float.valueOf(numbers2[it].trim()) == 18.0){
                        xfile2 = 180.0f;
                    } else {
                        xfile2 = Float.valueOf(numbers2[it].trim());

                    }
                }
               // runAlgo(writer,algorithm,xfile, xfile2);
                Random rand = new Random();
                int randomNum = rand.nextInt((1 - 1) + 1) -1;
                try {
                    writer.write( xfile+ randomNum+" "  );
                    System.out.println(xfile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            writer.write("\n");


        }
         writer.close();
        //Close the input stream
         br.close();
         br2.close();

    }





    public void runAlgo(BufferedWriter writer, Algo algo, float xfile, float xfile2){



        switch (algo){
            case MULT:
                break;
            case RANDOM:
                Random rand = new Random();
                int randomNum = rand.nextInt((1 - 1) + 1) -1;
                try {
                    writer.write( xfile+ randomNum+" "  );
                    System.out.println(xfile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case AVERAGE:
                break;
        }




        //  System.out.println("xfile : "+ xfile);
        // System.out.println("xfile2 : " + xfile2);
        // Print the content on the console
        //  System.out.println (strLine);
        //  System.out.println(""+ it);

               /* if(it<43){
                    writer.write( xfile+ " "  );

                }
                else{
                    writer.write( xfile2+ " "  );

                }*/

              /*  if(it == 1 ){
                    writer.write((((xfile+xfile2)/2))+" ");

                } else {
                    writer.write(xfile+" ");

                }*/
    }




}
