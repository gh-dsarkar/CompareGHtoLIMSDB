import org.*;
import org.json.*;
import org.testng.annotations.*;

import java.sql.*;
import java.util.*;

public class UpdateBIPVersion {



    @Test
    public void getGhDBdata() {
         ResultSetMetaData rsmd;

       String sampleid = testsExecute.sampleid;
        String runid = testsExecute.runid;
        //    static Scanner userEntry = new Scanner(System.in);
        ArrayList<Integer> testList = new ArrayList<Integer>();

//    String runid= "230105_A01902_0066_AREVEALSX3";
//    String sampleid= "A061886909";
        int rs_size=0;

        int i = testsExecute.counterTest;

        ResultSet rs = null;
        String ghDBQuery;
        String username = "admin";
        String password = "N7Tks0xPS";
        String JDBCUrl = "jdbc:postgresql://10.4.170.107/ghdb";
        Connection con = null;
        Statement st;
        JSONObject obj;
        try {
            Class.forName("org.postgresql.Driver");

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(JDBCUrl, username, password);

        st = con.createStatement();
        System.out.println("INFO: GHDB connection established");
        System.out.println("---------------------GETTING GHDB DATA--------------------");

        String [] tableArray= {"sample_methyl_call","tmb_call", "single_region_methyl_call", "denovofusion_call", "virus_call", "deletion_call", "fusion_call", "gh_board", "snv_call", "sample_coverage", "ghcnv_qc", "gh_sample", "alleletype_call", "subpanel_qc", "genomeloh_call", "cnv_call", "sample_qc", "ghcnv_probe",  "hrd_call", "qc_on_target", "segment_call", "contamination_map", "gh_fusion", "control_scorecard", "indel_call"};
        String [] runIDs = {
            "863284_NB501074_0315_AUTO222573"};

        for (int k=0; k< runIDs.length;k++) {

            for (int j = 0; j < tableArray.length; j++) {
                try {
//                    String Checkanalysis_version = " select analysis_version from " +tableArray[j]+";";
//
//                    ResultSet resultSet = st.executeQuery(Checkanalysis_version);
//                    resultSet.last();
//                    int rowCount= resultSet.getRow();
//                    if (rowCount > 0) {
                        Thread.sleep(2000);
                        String StateExecute = "update " + tableArray[j] + " set analysis_version = 'Sirius-1.0.0-RLS' where runid like '" + runIDs[k] + "' and run_sample_id='B00249142';";
                        st.executeUpdate(StateExecute);
                        Thread.sleep(2000);
//                System.out.println(StateExecute);
                        System.out.println(tableArray[j] + " tbl updated for analysis version ");
//                    }
                }
                catch (Exception e ){
                    System.out.println(tableArray[j] +" doesn't have analysis_version" +runIDs[k]);
                }

            }
        }




        }

        catch (Exception e) {
            System.out.println(e.getMessage());
//            throw new Exception();


        }
    }
}
