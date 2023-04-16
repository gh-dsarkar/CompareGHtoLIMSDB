package org;

import java.util.*;

public class testsExecute {

    public static String sampleid;
    public static String runid;
    //    static Scanner userEntry = new Scanner(System.in);
    public static ArrayList<Integer> testList = new ArrayList<Integer>();

    public static int counterTest;

    public static void getUserInput() {

            Scanner userEntry = new Scanner(System.in);
            // Create a Scanner object
            System.out.println("Enter the SampleID");
        sampleid = userEntry.nextLine();  // Read user input
//            sampleid = "A063262509";
            System.out.println("SampleID is: " + sampleid);

            System.out.println("Enter the RunID");
        runid = userEntry.nextLine();  // Read user input
//            runid = "230105_A01902_0066_AREVEALSX3";
            System.out.println("RunID is: " + runid);

            variantTestHelper();
        }

        public static void variantTestHelper(){
            Scanner userEntry = new Scanner(System.in);

            System.out.println("Enter numbers corresponding to the Variant to be tested. For mulitple variants separate by comma");
            System.out.println("1.SNV");
            System.out.println("2.CNV");
            System.out.println("3.Fusion");
            System.out.println("4.DenovoFusion");
            System.out.println("5.AlleleType");
            System.out.println("6.VirusData");
            System.out.println("7.Indel data");
            System.out.println("8.MSIData");
            System.out.println("9.HRDData");
            System.out.println("10.SampleMethyl");
            System.out.println("11.SingleMethylData");
            System.out.println("12.Deletion Data");
            System.out.println("12.TMB Data");


            String strVariantLst = userEntry.next();
//            String   strVariantLst = "3,5,10";
            String[] tempTestList = strVariantLst.split(",");

            for (String tmp: tempTestList) {
                testList.add(Integer.parseInt(tmp));
            }
            int tmpFlag=0;
            for (Integer i : testList) {
                if (i >= 11 && i <= 1) {
                    System.out.println("The user input contains invalid selection "+i+ "Please re-enter");
                    tmpFlag = 1;
                    break;
                }
            }
            if (tmpFlag==0) {
                System.out.println("The user input is valid");
            }
        }


    public static void main(String[] args) {


        getUserInput();
        for (int i: testList){
            testsExecute.counterTest = (i);
            compareghDb.excuteTests();
        }
    }

}
