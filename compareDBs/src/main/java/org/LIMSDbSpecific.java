package org;

import org.json.*;

import java.math.*;
import java.sql.*;
import java.util.*;

public class LIMSDbSpecific {
    private static Connection con;
    private static ResultSetMetaData rsmd;
    private static ResultSet results;

    private static ResultSet GHDBresult;
    public static HashMap<String,String> LIMSDataMap = new HashMap<>();

    public static  JSONArray jsonArr;
    public static String mapKey;
    public int rs_size=0;

    String rundid= "221007_A01744_0043_OTRVARSCEN";
    String sampleid= "A060542201";

    String LIMSQuery = null;

//    public String LIMSQuerytoExecute(int option) {
//
//
//        switch (option) {
//            case 1: //CNV
//                LIMSQuery = "SELECT * FROM U_GHCNVGENE WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 2: //SNV
//                LIMSQuery = "SELECT * FROM U_GHSNV WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 3: //DeletionQuery
//                LIMSQuery = "SELECT * FROM U_GHDELETION WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 4: //DenovoQuery
//                LIMSQuery = "SELECT * FROM U_GHDENOVOFUSION WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 5: //FusionQuery
//                LIMSQuery = "SELECT * FROM U_GHFUSION WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 6: //IndelQuery
//                LIMSQuery = "SELECT * FROM U_GHINDEL WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 7: //AlleleTypeQuery
//                LIMSQuery = "SELECT * FROM U_GHALLELETYPE WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 8: //SingleMethylQuery
//                LIMSQuery = "SELECT * FROM U_GHSINGLEMETHYL WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 9: //VirusQuery
//                LIMSQuery = "SELECT * FROM U_GHVIRUS WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 10: //TMB
//                LIMSQuery = "SELECT * FROM U_GHTMB WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 11: //SampleCoverage
//                LIMSQuery = "SELECT * FROM U_GHSAMPLECOVERAGE WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 12: //MSI
//                LIMSQuery = "SELECT * FROM U_GHMSI WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 13: //HRD
//                LIMSQuery = "SELECT * FROM U_GHHRD WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//            case 14: //SampleMethyl
//                LIMSQuery = "SELECT * FROM U_GHSAMPLEMETHYL WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
//                break;
//
//        }
//        return LIMSQuery;
//
//    }


    public JSONArray getLIMSdata(){
        String username = "dsarkar";;
        String password = "Ventana@27gh";
        String hostname = "gh-val-db-lims.ghdna.io";
        String port = "1521";
        String SID = "limsval";

        String DB_LIMS_Schema= "labvantage" ;
        String DB_ServiceName = "ocrl";
        String connectionString="" ;
        HashMap<String,JSONArray> geneMap = new HashMap<String,JSONArray>();



        if (!SID.equals("")) {
            connectionString = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + SID;
        } else if (!DB_ServiceName.equals("")) {
            connectionString = "jdbc:oracle:thin:@//" + hostname + ":" + port + "/" + DB_ServiceName;
        }
        System.out.println(connectionString);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(
                    connectionString, username,
                    password);

            con.setSchema(DB_LIMS_Schema);
            System.out.println("Connected to LIMS Database succesfully");


            //Read records from db

            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            st.executeQuery("ALTER SESSION SET CURRENT_SCHEMA = labvantage");

            String CNVQuery_call3 ="SELECT * FROM U_GHCNVGENE WHERE runid ='"+rundid+ "' and SAMPLEID ='"+sampleid+"'";

            String CNVQuery_call2 ="SELECT * FROM U_GHCNVGENE WHERE runid ='"+rundid+ "' and SAMPLEID ='"+sampleid+"' AND CNVCALL =2";

            String CNVQuery_call1 ="SELECT * FROM U_GHCNVGENE cnv WHERE cnv.SAMPLEID = '"+sampleid+"' AND CNVCALL =1";

            String SNVQuery ="SELECT * FROM U_GHSNV WHERE runid ='"+rundid+ "' and SAMPLEID ='"+sampleid+"'";

            String DeletionQuery_loh = "SELECT * FROM U_GHDELETION  WHERE SAMPLEID = '"+sampleid+"'";

            String DeletionQuery_homdel = "SELECT * FROM U_GHDELETION  WHERE SAMPLEID = '"+sampleid+"'";

            String DenovoQuery = "SELECT *  FROM U_GHDENOVOFUSION  WHERE SAMPLEID = '"+sampleid+"'";

            String fusionQuery = "SELECT *  FROM U_GHFUSION  WHERE SAMPLEID = '"+sampleid+"'";

            String IndelQuery = "SELECT * FROM U_GHINDEL  WHERE SAMPLEID = '"+sampleid+"'";

            String AlleleTypeQuery = "SELECT * FROM U_GHALLELETYPE ug  WHERE SAMPLEID = '"+sampleid+"'";

            String SingleMethylQuery = "SELECT * FROM U_GHSINGLEMETHYL  WHERE SAMPLEID = '"+sampleid+"'";


            String VirusQuery  = "SELECT * FROM U_GHVIRUS ug  WHERE SAMPLEID = '"+sampleid+"'";

            String MSIQuery = "SELECT * FROM U_GHMSI  WHERE SAMPLEID = '"+sampleid+"'";

            String TMBQuery_High ="SELECT * FROM U_GHTMB   WHERE SAMPLEID = '"+sampleid+"'";

            String TMBQuery_Low = "SELECT * FROM u_ghtmb WHERE SAMPLEID ='"+sampleid+"' AND TMB_CATEGORY ='Low'";



            String HRDQuery = "SELECT * FROM U_GHHRD ug WHERE SAMPLEID = '"+sampleid+"'";

            String SampleMethyl = "SELECT * FROM U_GHSAMPLEMETHYL ug  WHERE SAMPLEID = '"+sampleid+"'";


            System.out.println("---------------------GETTING LIMS DATA--------------------");
            System.out.println("LIMS Query :" +DeletionQuery_loh);
            results = st.executeQuery(DeletionQuery_loh);



            rsmd = results.getMetaData();
            jsonArr = new JSONArray();

            while (results.next()) {
                int dbColumns = rsmd.getColumnCount();
                JSONObject obj = new JSONObject();
                for (int i = 1; i <= dbColumns; i++) {
                    try {
                        String column_name = rsmd.getColumnName(i);
                        obj.put(column_name, results.getObject(column_name));
                        if (results.getObject(column_name)==null){
                            obj.put(column_name, JSONObject.NULL);
                        }
//                        else if (results.getObject(column_name) instanceof BigDecimal) {
//                            obj.put(column_name, ((BigDecimal)results.getObject(column_name)).doubleValue());
//                        }
                        else if (results.getObject(column_name) instanceof BigDecimal) {
                            if (((BigDecimal) results.getObject(column_name)).remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0){
                                obj.put(column_name, ((BigDecimal)results.getObject(column_name)).intValue());
                            }
                            else{
                                obj.put(column_name, ((BigDecimal)results.getObject(column_name)).doubleValue());
                            }


                        }

                        else {
                            obj.put(column_name, results.getObject(column_name));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    jsonArr.put(obj);
                }

//                geneMap.put(mapKey,jsonArr);
            rs_size++;

            }
//            System.out.println("No of records : "+ jsonArr.length());

            System.out.println("No of records collected :"+rs_size);

            System.out.println("LIMS DATA COLLECTION COMPLETED");
            System.out.println("---------------------------------------------------------------------------------");
            con.close();

        }
        catch (Exception e) {
            e.getMessage();
        }

        return jsonArr;

    }

}
