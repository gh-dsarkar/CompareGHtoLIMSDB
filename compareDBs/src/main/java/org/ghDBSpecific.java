package org;

import org.json.*;

import java.sql.*;

public class ghDBSpecific {

    private static ResultSetMetaData rsmd;

    String runid= "221007_A01744_0043_OTRVARSCEN";
    String sampleid= "A060542201";

    public int rs_size=0;



    String ghDBQuery;



//    public String ghDBQuerytoExecute(int option) {
//
//
//        switch (option) {
//            case 1: //CNV
//                ghDBQuery = "select cnv.* from cnv_call cnv join gh_board gb on gb.run_sample_id =cnv.run_sample_id  where gb.cnv_call = 'PASS' and cnv.\"call\" > 0 \n" +
//                        "and cnv.runid = '"+runid+"' and cnv.run_sample_id ='"+sampleid+"' and cnv.ruo_reportable =1";
//                break;
//            case 2: //SNV
//                ghDBQuery = "select (snv.* )from snv_call snv join gh_board gb on gb.run_sample_id =snv.run_sample_id  where \n" +
//                        "snv.runid = '"+runid+"' and snv.run_sample_id ='"+sampleid+"' and \n" +
//                        "gb.snv_call = 'PASS' and snv.tumor_call = 1 and snv.\"call\" =1 \n" +
//                        " and snv.ruo_reportable =1";
//                break;
//            case 3: //DeletionQuery
//                ghDBQuery = " select (dc.* )from deletion_call dc join gh_board gb on gb.run_sample_id =dc.run_sample_id  where \n" +
//                        "dc.runid = '"+runid+"' and dc.run_sample_id ='"+sampleid+"' and \n" +
//                        "gb.indel_call = 'PASS' and dc.is_deletion =true\n" +
//                        "and dc.ruo_reportable =1 and dc.cnv_type ='loh'";
//                break;
//            case 4: //DenovoQuery
//                ghDBQuery = "select fc.* from denovofusion_call fc join gh_board gb on gb.run_sample_id =fc.run_sample_id  where \n" +
//                        "fc.runid = '"+runid+"' and fc.run_sample_id ='"+sampleid+"'  \n" +
//                        "and gb.fusion_call ='PASS' and fc.\"call\" =1 and fc.ruo_reportable =1";
//                break;
//            case 5: //FusionQuery
//                ghDBQuery = "select fc.* from fusion_call fc join gh_board gb on gb.run_sample_id =fc.run_sample_id  where \n" +
//                        "fc.runid = '"+runid+"' and fc.run_sample_id ='"+sampleid+"'  \n" +
//                        "and gb.fusion_call ='PASS' and fc.\"call\" =1 and fc.ruo_reportable =1";
//                break;
//            case 6: //IndelQuery
//                ghDBQuery = "select (ic.* )from indel_call ic join gh_board gb on gb.run_sample_id =ic.run_sample_id  where \n" +
//                        "ic.runid = '"+runid+"' and ic.run_sample_id ='"+sampleid+"' and \n" +
//                        "gb.indel_call = 'PASS' and ic.\"call\" =1 \n" +
//                        " and ic.ruo_reportable =1 and ic.tumor_call is null";
//                break;
//            case 7: //AlleleTypeQuery
//                ghDBQuery = "select * from alleletype_call ac where " +
//                        "ac.runid = '"+runid+"' and ac.run_sample_id ='"+sampleid+"'";
//
//            case 8: //SingleMethylQuery
//                ghDBQuery =  "select (srmc.* )from single_region_methyl_call srmc join gh_board gb on gb.run_sample_id =srmc.run_sample_id  where \n" +
//                        "srmc.runid = '"+runid+"' and srmc.run_sample_id ='"+sampleid+"' and \n" +
//                        "gb.single_region_methyl_call = 'PASS' and srmc.\"call\" =1\n" +
//                        "and srmc.ruo_reportable =1";
//                break;
//            case 9: //VirusQuery
//                ghDBQuery = "select (vc.* )from virus_call vc join gh_board gb on gb.run_sample_id =vc.run_sample_id  where \n" +
//                        "vc.runid = '"+runid+"' and vc.run_sample_id ='"+sampleid+"' and \n" +
//                        "gb.virus_call = 'PASS' and vc.\"call\" =1\n" +
//                        "and vc.ruo_reportable =1";
//                break;
//            case 10: //TMB
//                ghDBQuery = "select (tc.* )from tmb_call tc join gh_board gb on gb.run_sample_id =tc.run_sample_id  where \n" +
//                        "tc.runid = '"+runid+"' and tc.run_sample_id ='"+sampleid+"' and tc.tmb_category  ='High'";
//                break;
////            case 11: //SampleCoverage
////                ghDBQuery = "SELECT * FROM U_GHSAMPLECOVERAGE WHERE SAMPLEID ='" + Sampleid + "' and runid ='" + rundid + "'";
////                break;
//            case 12: //MSI
//                ghDBQuery = "select (mc.* )from msi_call mc join gh_board gb on gb.run_sample_id =mc.run_sample_id  where \n" +
//                        "mc.runid = '"+runid+"' and mc.run_sample_id ='"+sampleid+"' and mc.msi_status ='MSI-H'";
//                break;
//            case 13: //HRD
//                ghDBQuery = "select (hc.* )from hrd_call hc join gh_board gb on gb.run_sample_id =hc.run_sample_id  where \n"+
//                "hc.runid = '"+runid+"' and hc.run_sample_id ='"+sampleid+"' and hc.num_reversions > 0";
//                break;
//            case 14: //SampleMethyl
//                ghDBQuery = "select (smc.* )from sample_methyl_call smc join gh_board gb on gb.run_sample_id =smc.run_sample_id  where \n" +
//                        "smc.runid = '"+runid+"' and smc.run_sample_id ='"+sampleid+"' and \n" +
//                        "gb.sample_methyl_call  = 'PASS' and smc.\"call\" =1";
//                break;
//
//        }
//        return ghDBQuery;
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
        try {
            con = DriverManager.getConnection(JDBCUrl, username, password);
            st = con.createStatement();
            System.out.println("INFO: GHDB connection established");

            String SNVQuery = "select (snv.* ), gb.snv_call from snv_call snv join gh_board gb on gb.run_sample_id =snv.run_sample_id  where \n" +
                    "snv.runid = '"+runid+"' and snv.run_sample_id ='"+sampleid+"' and \n" +
                    "gb.snv_call = 'PASS'  and snv.\"call\" =1 \n" +
                    " and snv.ruo_reportable =1";

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
                    "ic.runid = '"+runid+"' and ic.run_sample_id ='"+sampleid+"' and \n" +
                    "gb.indel_call = 'PASS' and ic.\"call\" =1 \n" +
                    " and ic.ruo_reportable =1 and ic.tumor_call is null";

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

            String SampleMethylQuery = "select (smc.* )from sample_methyl_call smc join gh_board gb on gb.run_sample_id =smc.run_sample_id  where \n" +
                    "smc.runid = '"+runid+"' and smc.run_sample_id ='"+sampleid+"' and \n" +
                    "gb.sample_methyl_call  = 'PASS' and smc.\"call\" =1";

            String TMBQuery_High = "select (tc.* )from tmb_call tc join gh_board gb on gb.run_sample_id =tc.run_sample_id  where \n" +
                    "tc.runid = '"+runid+"' and tc.run_sample_id ='"+sampleid+"' and tc.tmb_category  ='High'";

            String TMBQuery_Low = "select (tc.* )from tmb_call tc join gh_board gb on gb.run_sample_id =tc.run_sample_id  where \n" +
                    "tc.runid = '"+runid+"' and tc.run_sample_id ='"+sampleid+"' and tc.tmb_category  ='Low'";

            String MSIQuery = "select (mc.* )from msi_call mc join gh_board gb on gb.run_sample_id =mc.run_sample_id  where \n" +
                    "mc.runid = '"+runid+"' and mc.run_sample_id ='"+sampleid+"' and mc.msi_status ='MSI-H'";

            String HRDQuery = "select (hc.* )from hrd_call hc join gh_board gb on gb.run_sample_id =hc.run_sample_id  where \n" +
                    "hc.runid = '"+runid+"' and hc.run_sample_id ='"+sampleid+"' and hc.num_reversions > 0";

//            String QuerytoExecute = ghDBQuerytoExecute();

            System.out.println("---------------------GETTING GHDB DATA--------------------");
            System.out.println(deletionQuery_loh);
            ResultSet rs = st.executeQuery(deletionQuery_loh);



            rsmd = rs.getMetaData();

            jsonArr = new JSONArray();
            while (rs.next()) {
                int dbColumns = rsmd.getColumnCount();
                obj = new JSONObject();
                for (int i = 1; i <= dbColumns; i++) {
                    try {
                        String column_name = rsmd.getColumnName(i);
                        if (rs.getObject(column_name)==null){
                            obj.put(column_name, JSONObject.NULL);
                        }
                        else {
                            obj.put(column_name, rs.getObject(column_name));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    jsonArr.put(obj);
                }
                rs_size++;
            }

            System.out.println("Number of records collected:"+rs_size);
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


