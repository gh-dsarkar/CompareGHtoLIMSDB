package org;

import org.json.*;

import java.sql.*;
import java.util.*;

public class ghDBSpecific {

    private static ResultSetMetaData rsmd;

    public static String sampleid = testsExecute.sampleid;
    public static String runid = testsExecute.runid;
//    static Scanner userEntry = new Scanner(System.in);
    public static ArrayList<Integer> testList = new ArrayList<Integer>();

//    String runid= "230105_A01902_0066_AREVEALSX3";
//    String sampleid= "A061886909";

    public int rs_size=0;

    static int i = testsExecute.counterTest;

    private ResultSet rs = null;



    String ghDBQuery;


//    public static void getUserInput(){
//        Scanner userEntry = new Scanner(System.in);
//        // Create a Scanner object
//        System.out.println("Enter the SampleID");
////        sampleid = userEntry.nextLine();  // Read user input
//        sampleid = "A063262509";
//        System.out.println("SampleID is: " + sampleid);
//
//        System.out.println("Enter the RunID");
////        runid = userEntry.nextLine();  // Read user input
//        runid = "230105_A01902_0066_AREVEALSX3";
//        System.out.println("RunID is: " + runid);
//
//        variantTestHelper();
//
//
//
//    }
//
//
//
//    public static void variantTestHelper(){
//        Scanner userEntry = new Scanner(System.in);
//
//            System.out.println("Enter numbers corresponding to the Variant to be tested. For mulitple variants separate by comma");
//            System.out.println("1.SNV");
//            System.out.println("2.CNV");
//            System.out.println("3.Fusion");
//            System.out.println("4.DenovoFusion");
//            System.out.println("5.AlleleType");
//            System.out.println("6.VirusData");
//            System.out.println("7.Indel data");
//            System.out.println("8.MSIData");
//            System.out.println("9.HRDData");
//            System.out.println("10.SampleMethyl");
//            System.out.println("11.SingleMethylData");
//            System.out.println("12.Deletion Data");
//            System.out.println("12.TMB Data");
//
//
////            String strVariantLst = userEntry.next();
//            String   strVariantLst = "3,5,10";
//            String[] tempTestList = strVariantLst.split(",");
//
//            for (String tmp: tempTestList) {
//                testList.add(Integer.parseInt(tmp));
//            }
//            int tmpFlag=0;
//            for (Integer i : testList) {
//                if (i >= 11 && i <= 1) {
//                    System.out.println("The user input contains invalid selection "+i+ "Please re-enter");
//                    tmpFlag = 1;
//                    break;
//                }
//               }
//            if (tmpFlag==0) {
//                System.out.println("The user input is valid");
//            }
//
//
//
//
//
//    }




    public JSONArray getGhDBdata() {
        String username = "admin";
        String password = "N7Tks0xPS";
        String JDBCUrl = "jdbc:postgresql://10.4.170.107/ghdb";
        Connection con = null;
        Statement st;
        JSONObject obj;
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
//            //
            e.printStackTrace();
        }
//        JSONArray result = null;
        JSONArray jsonArr = null;

        String SNVQuery = "select (snv.* ), gb.snv_call from snv_call snv join gh_board gb on gb.run_sample_id =snv.run_sample_id  where \n" +
                "snv.runid = '"+runid+"' and snv.run_sample_id ='"+sampleid+"'";
        //       "' and \n gb.snv_call = 'PASS'  and snv.\"call\" =1 and snv.ruo_reportable =1";

        String CNVQuery_call3 =  "select cnv.*,gb.cnv_call from cnv_call cnv join gh_board gb on gb.run_sample_id =cnv.run_sample_id  where gb.cnv_call = 'PASS' and cnv.\"call\" = 3 \n" +
                "and cnv.runid = '"+runid+"' and cnv.run_sample_id ='"+sampleid+"' and cnv.ruo_reportable =1";

        String CNVQuery_call2 =  "select cnv.*,gb.cnv_call from cnv_call cnv join gh_board gb on gb.run_sample_id =cnv.run_sample_id  where gb.cnv_call = 'PASS' and cnv.\"call\" = 2 \n" +
                "and cnv.runid = '"+runid+"' and cnv.run_sample_id ='"+sampleid+"' and cnv.ruo_reportable =1";

        String CNVQuery_call1 =  "select cnv.* from cnv_call cnv join gh_board gb on gb.run_sample_id =cnv.run_sample_id  where  cnv.run_sample_id ='B00150584' and cnv.runid = '221007_A01744_0043_SAMPLE0VAR'" +
                " and cnv.ruo_reportable =1 and   cnv.\"call\" =1  and gb.cnv_call = 'PASS'";

        String fusionQuery = "SELECT fc.run_sample_id run_sample_id,fc.runid, fc.downstream_gene, fc.gene_a, fc.gene_b, fc.chrom_a, fc.chrom_b, fc.pos_a," +
                " fc.pos_b,fc.percentage,fc.nof1_comment,fc.tb_code,fc.call,fc.variant_comment,fc.analysis_version,fc.Fusion_Molecule_Count_A," +
                "fc.Molecule_Coverage_A,fc.Fusion_Molecule_Count_B, fc.Molecule_Coverage_B,fc.Fusion_Molecule_Count_AB, gf.direction_a, gf.direction_b, " +
                "gf.orientation_gene_a, gf.orientation_gene_b, fc.fusion_read_count_a, fc.fusion_read_count_b, fc.fusion_read_count_ab, " +
                "fc.ldt_reportable , fc.ruo_reportable FROM fusion_call fc left join gh_fusion gf on fc.runid=gf.runid and " +
                "fc.run_sample_id=gf.run_sample_id and fc.chrom_a = gf.chromosome_a and fc.chrom_b = gf.chromosome_b and " +
                "fc.pos_a = gf.position_a and fc.pos_b =gf.position_b and fc.downstream_gene = gf.downstream_gene " +
                "and fc.gene_a = gf.gene_a and fc.gene_b = gf.gene_b WHERE fc.run_sample_id = " +
                "'"+sampleid+"' AND fc.runid = '"+runid+"' AND fc.ruo_reportable = 1 AND fc.call = 1";

        String denovoFusionQuery ="select fc.*,gb.denovofusion_call from denovofusion_call fc join gh_board gb on gb.run_sample_id =fc.run_sample_id  where \n" +
                "fc.runid = '"+runid+"' and fc.run_sample_id ='"+sampleid+"'  \n" +
                "and gb.fusion_call ='PASS' and fc.\"call\" =1 and fc.ruo_reportable =1";

        String indelQuery = "select (ic.* ),gb.indel_call from indel_call ic join gh_board gb on gb.run_sample_id =ic.run_sample_id  where \n" +
                "ic.runid = '"+runid+"' and ic.run_sample_id ='"+sampleid+"'";
         //       "gb.indel_call = 'PASS' and ic.\"call\" =1 \n and ic.ruo_reportable =1 and ic.tumor_call is null";

        String deletionQuery_loh = " select (dc.* ), gb.deletion_call from deletion_call dc join gh_board gb on gb.run_sample_id =dc.run_sample_id  where \n" +
                "dc.runid = '"+runid+"' and dc.run_sample_id ='"+sampleid+"' and \n" +
                "gb.indel_call = 'PASS' and dc.is_deletion =true\n" +
                "and dc.ruo_reportable =1 and dc.cnv_type ='loh'";

        String deletionQuery_homdel = "select (dc.* ), gb.deletion_call from deletion_call dc join gh_board gb on gb.run_sample_id =dc.run_sample_id  where \n" +
                "dc.runid = '"+runid+"' and dc.run_sample_id ='"+sampleid+"' and \n" +
                "gb.indel_call = 'PASS' and dc.is_deletion =true\n" +
                "and dc.ruo_reportable =1 and dc.cnv_type ='homdel'";

        String AlleleTypeQuery = "select * from alleletype_call ac where " +
                "ac.runid = '"+runid+"' and ac.run_sample_id ='"+sampleid+"'";

        String SingleMethylRegionQuery =
                "select (srmc.* ) from single_region_methyl_call srmc join gh_board gb on gb.run_sample_id =srmc.run_sample_id  where \n" +
                        "srmc.runid = '"+runid+"' and srmc.run_sample_id ='"+sampleid+"' and \n" +
                        "gb.single_region_methyl_call = 'PASS' and srmc.\"call\" =1\n" +
                        "and srmc.ruo_reportable =1";

        String VirusQuery = "select (vc.* ),gb.virus_call from virus_call vc join gh_board gb on gb.run_sample_id =vc.run_sample_id  where \n" +
                "vc.runid = '"+runid+"' and vc.run_sample_id ='"+sampleid+"' and \n" +
                "gb.virus_call = 'PASS' and vc.call =1\n" +
                "and vc.ruo_reportable =1";

//            String SampleMethylQuery = "select (smc.* )from sample_methyl_call smc join gh_board gb on gb.run_sample_id =smc.run_sample_id  where \n" +
//                    "smc.runid = '"+runid+"' and smc.run_sample_id ='"+sampleid+"' and \n" +
//                    "gb.sample_methyl_call  = 'PASS' and smc.\"call\" =1";

        String SampleMethylQuery = "Select (smc.*), tf.upper_limit ,tf.lower_limit  from sample_methyl_call smc \n" +
                "join gh_board gb on gb.run_sample_id = smc.run_sample_id \n" +
                "join tf_reportable_range tf on (tf.analysis_version = smc.analysis_version  and tf.tumor_type =smc.model_name ) \n" +
                " where gb.sample_methyl_call  = 'PASS' and smc.methyl_call =1 and \n"+
                "smc.runid = '"+runid+"' and smc.run_sample_id ='"+sampleid+"'";

        String TMBQuery_High = "select (tc.* )from tmb_call tc join gh_board gb on gb.run_sample_id =tc.run_sample_id  where \n" +
                "tc.runid = '"+runid+"' and tc.run_sample_id ='"+sampleid+"' and tc.tmb_category  ='High'";

        String TMBQuery_Low = "select (tc.* )from tmb_call tc join gh_board gb on gb.run_sample_id =tc.run_sample_id  where \n" +
                "tc.runid = '"+runid+"' and tc.run_sample_id ='"+sampleid+"' and tc.tmb_category  ='Low'";

        String MSIQuery = "select (mc.* )from msi_call mc join gh_board gb on gb.run_sample_id =mc.run_sample_id  where \n" +
                "mc.runid = '"+runid+"' and mc.run_sample_id ='"+sampleid+"' and mc.msi_status ='MSI-H'";

        String HRDQuery = "select (hc.* )from hrd_call hc join gh_board gb on gb.run_sample_id =hc.run_sample_id  where \n" +
                "hc.runid = '"+runid+"' and hc.run_sample_id ='"+sampleid+"' and hc.num_reversions > 0";



        try {
            con = DriverManager.getConnection(JDBCUrl, username, password);
            st = con.createStatement();
            System.out.println("INFO: GHDB connection established");
            System.out.println("---------------------GETTING GHDB DATA--------------------");

            int testNumber = testsExecute.counterTest;
                switch (testNumber) {
                    case 1: //SNV
                        System.out.println(SNVQuery);
                        rs = st.executeQuery(SNVQuery);

                        break;
                    case 2:
                        System.out.println(CNVQuery_call3);
                        rs = st.executeQuery(CNVQuery_call3);
                        break;
                    case 3:
                        rs = st.executeQuery(fusionQuery);

                        break;
                    case 4:
                        rs = st.executeQuery(denovoFusionQuery);
                        break;
                    case 5:
                        rs = st.executeQuery(AlleleTypeQuery);
                        break;

                    case 6:
                        rs = st.executeQuery(VirusQuery);
                        break;
                    case 7:
                        rs = st.executeQuery(indelQuery);
                        break;
                    case 8:
                        rs = st.executeQuery(MSIQuery);
                        break;
                    case 9:
                        rs = st.executeQuery(HRDQuery);
                        break;
                    case 10:
                        rs = st.executeQuery(SampleMethylQuery);
                        break;
                    case 11:
                        rs = st.executeQuery(SingleMethylRegionQuery);
                        break;
                    case 12:
                        rs = st.executeQuery(deletionQuery_loh);
                        break;
                    case 13:
                        rs = st.executeQuery(TMBQuery_High);
                        break;
                    default:
                        System.out.println("Default hit");
                        break;
                }

            rsmd = rs.getMetaData();

            jsonArr = new JSONArray();
            while (rs.next()) {
                int dbColumns = rsmd.getColumnCount();
                obj = new JSONObject();
                for (int i = 1; i <= dbColumns; i++) {
                    try {
                        String column_name = rsmd.getColumnName(i);
                        if (rs.getObject(column_name) == null) {
                            obj.put(column_name, JSONObject.NULL);
                        } else {
                            obj.put(column_name, rs.getObject(column_name));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    jsonArr.put(obj);
                }
                rs_size++;
            }

            System.out.println("Number of records collected:" + rs_size);
            System.out.println("ghDb Data collection completed");

            System.out.println("-------------------------------------------------------------------");
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        try {
            if (con == null) {

                throw new Exception("ERROR: Connection cannot be established.");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return jsonArr;
    }
}


