package org;

import org.json.*;
import org.testng.*;
import org.testng.asserts.*;

import java.math.*;
import java.util.concurrent.atomic.*;


public class compareghDb {

    static int i = testsExecute.counterTest;

    public static void compareSNVData(){

        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for SNV");

         ghDBSpecific ghdb = new ghDBSpecific();
         LIMSDbSpecific lims = new LIMSDbSpecific();
         JSONArray GHDBDataMap = ghdb.getGhDBdata();
         JSONArray LIMSDataMap = lims.getLIMSdata();
            LIMSDataMap.forEach(limsItem->{
                JSONObject LIMSObj= (JSONObject)limsItem;

                GHDBDataMap.forEach(item->{
                    JSONObject obj = (JSONObject)item;

                    try{
                        if (obj.get("gene").equals(LIMSObj.get("GENE")) && obj.get("cdna").equals(LIMSObj.get("CDNA"))){
                            SoftAssert Assert = new SoftAssert();

                            Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("gene")+ " run_sample_id");
                            Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("gene")+ " runid");
                            Assert.assertEquals(obj.get("gene"),LIMSObj.get("GENE"),"Error for record with gene "+obj.get("gene")+ " gene");
                            Assert.assertEquals(obj.get("mut_aa"),LIMSObj.get("MUTATION_AA"),"Error for record with gene "+obj.get("gene")+ " mut_aa");
                            Assert.assertEquals(obj.get("mut_nt"),LIMSObj.get("MUTATION_NT"),"Error for record with gene "+obj.get("gene")+ " mut_nt");
                            Assert.assertEquals(obj.get("chrom"),LIMSObj.get("CHROMOSOME"),"Error for record with gene "+obj.get("gene")+ " chrom");
                            Assert.assertEquals(obj.get("position"),LIMSObj.get("POSITION"),"Error for record with gene "+obj.get("gene")+ " position");
                            Assert.assertEquals(obj.get("dbsnp"),LIMSObj.get("DBSNP_ID"),"Error for record with gene "+obj.get("gene")+ " dbsnp");
                            Assert.assertEquals(obj.get("percentage"),LIMSObj.get("PERCENTAGE"),"Error for record with gene "+obj.get("gene")+ " percentage");
                            Assert.assertEquals(obj.get("zscore"),LIMSObj.get("ZSCORE"),"Error for record with gene "+obj.get("gene")+ " zscore");
                            Assert.assertEquals(obj.get("cosmic"),LIMSObj.get("COSMIC_ID"),"Error for record with gene "+obj.get("gene")+ " cosmic");
                            Assert.assertEquals(obj.get("transcript_id"),LIMSObj.get("TRANSCRIPT_ID"),"Error for record with gene "+obj.get("gene")+ " transcript_id");
                            Assert.assertEquals(obj.get("cdna"),LIMSObj.get("CDNA"),"Error for record with gene "+obj.get("gene")+ " cdna");
                            Assert.assertEquals(obj.get("splice_effect"),LIMSObj.get("SPLICEEFFECT"),"Error for record with gene "+obj.get("gene")+ " splice_effect");
                            Assert.assertEquals(obj.get("call"),LIMSObj.get("SNVCALL"),"Error for record with gene "+obj.get("gene")+ " call");
                            Assert.assertEquals(obj.get("analysis_version"),LIMSObj.get("ANALYSISVERSION"),"Error for record with gene "+obj.get("gene")+ " analysis_version");
                            Assert.assertEquals(obj.get("tb_code"),LIMSObj.get("TBCODE"),"Error for record with gene "+obj.get("gene")+ " tb_code");
                            String comment = obj.get("variant_comment")==null ? "":(obj.get("variant_comment").toString().replaceAll(";",","));
                            Assert.assertEquals(comment,LIMSObj.get("VARIANTCOMMENT"),"Error for record with gene "+obj.get("gene"));
                            Assert.assertEquals(obj.get("mol_cnt"),LIMSObj.get("MOL_CNT"),"Error for record with gene "+obj.get("gene")+ " mol_cnt");
                            Assert.assertEquals(obj.get("reporting_category"),LIMSObj.get("REPORTING_CATEGORY"),"Error for record with gene "+obj.get("gene")+ " reporting_category");
                            Assert.assertEquals(obj.get("exon"),LIMSObj.get("EXON"),"Error for record with gene "+obj.get("gene")+ " exon");
                            Assert.assertEquals(obj.get("somatic_call"),LIMSObj.get("SOMATIC_CALL"),"Error for record with gene "+obj.get("gene")+ " somatic_call");
                            Assert.assertEquals(obj.get("somatic_review"),LIMSObj.get("SOMATIC_REVIEW"),"Error for record with gene "+obj.get("gene")+ " somatic_review");
                            Assert.assertEquals(obj.get("somatic_score"),LIMSObj.get("SOMATIC_SCORE"),"Error for record with gene "+obj.get("gene")+ " somatic_score");
                            Assert.assertEquals(obj.get("tumor_call"),LIMSObj.get("TUMORCALL"),"Error for record with gene "+obj.get("gene")+ " tumor_call");
                            Assert.assertEquals(obj.get("ldt_reportable"),LIMSObj.get("LDTREPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ldt_reportable");
                            Assert.assertEquals(obj.get("clinvar_clinsig"),LIMSObj.get("CLINVAR_CLINSIG"),"Error for record with gene "+obj.get("gene")+ " clinvar_clinsig");
                            Assert.assertEquals(obj.get("molecular_consequence"),LIMSObj.get("MOLECULAR_CONSEQUENCE"),"Error for record with gene "+obj.get("gene")+ " molecular_consequence");
                            Assert.assertEquals(obj.get("functional_impact"),LIMSObj.get("FUNCTIONAL_IMPACT"),"Error for record with gene "+obj.get("gene")+ " functional_impact");
                            Assert.assertEquals(obj.get("mutant_allele_status"),LIMSObj.get("MUTANT_ALLELE_STATUS"),"Error for record with gene "+obj.get("gene")+ " mutant_allele_status");
                            Assert.assertEquals(obj.get("clinvar_id"),LIMSObj.get("CLINVAR_ID"),"Error for record with gene "+obj.get("gene")+ " clinvar_id");
                            Assert.assertEquals(obj.get("grs_var_ntd_score"),LIMSObj.get("GRS_SCORE"),"Error for record with gene "+obj.get("gene")+ " grs_var_ntd_score");
                            Assert.assertEquals(obj.get("grs_used"),LIMSObj.get("GRS_USED"),"Error for record with gene "+obj.get("gene")+ " grs_used");
                            Assert.assertEquals(obj.get("tvf_call_multitumor"),LIMSObj.get("TVF_CALLED"),"Error for record with gene "+obj.get("gene")+ " tvf_call_multitumor");
                            Assert.assertEquals(obj.get("ruo_reportable"),LIMSObj.get("RUOREPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ruo_reportable");



                        }



                    }
                    catch(Exception e){
                        flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                        e.printStackTrace();
                        e.getMessage();
                    }
                });
            });

        if (flag.get()==0){
            System.out.println( "SNV data verified successfully");

        }
        else{
            System.err.println( "SNV data verification not successful");
        }

    }

    public static void compareCNVData(){
        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for CNV");

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        int ghdataSize =  ghdb.rs_size;
        JSONArray LIMSDataMap = lims.getLIMSdata();
        int LIMSDataSize =  lims.rs_size;

        Assert.assertEquals(ghdataSize,LIMSDataSize,"Error in the number of records Collected ");

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;

                try{
                    if (obj.get("gene").equals(LIMSObj.get("GENE")) ){

                        String comment = obj.get("variant_comment")==null ? "":(obj.get("variant_comment").toString().replaceAll(";",","));
                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("gene")+ " run_sample_id");
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("gene")+ " runid");
                        Assert.assertEquals(obj.get("gene"),LIMSObj.get("GENE"),"Error for record with gene "+obj.get("gene")+ " gene");


                        Assert.assertEquals(obj.get("zscore"),LIMSObj.get("ZSCORE"),"Error for record with gene "+obj.get("gene")+ " zscore");
//                        Assert.assertEquals(obj.get("mean"),LIMSObj.get("MEAN"),"Error for record with gene "+obj.get("gene")+ " mean");

                        Assert.assertEquals(((BigDecimal)obj.get("copy_number")).stripTrailingZeros().doubleValue(),LIMSObj.get("COPYNUMBER"),"Error for record with gene "+obj.get("gene")+ " copy_number");
//                        Assert.assertEquals(obj.get("copy_number"),LIMSObj.get("COPYNUMBER"),"Error for record with gene "+obj.get("gene")+ " copy_number");
                        Assert.assertEquals(Math.round((Float) obj.get("p_value")),LIMSObj.get("PVALUE"),"Error for record with gene "+obj.get("gene")+ " p_value");
//                        Assert.assertEquals(obj.get("call"),LIMSObj.get("CNVCALL"),"Error for record with gene "+obj.get("gene")+ " call");
                        Assert.assertEquals(obj.get("call").toString(),LIMSObj.get("CNVCALL"),"Error for record with gene "+obj.get("gene")+ " call");
                        Assert.assertEquals(obj.get("tb_code"),LIMSObj.get("TBCODE"),"Error for record with gene "+obj.get("gene")+ " tb_code");
                        Assert.assertEquals(comment,LIMSObj.get("VARIANTCOMMENT"),"Error for record with gene "+obj.get("gene")+ " variant_comment");
                        Assert.assertEquals(obj.get("analysis_version"),LIMSObj.get("ANALYSISVERSION"),"Error for record with gene "+obj.get("gene")+ " analysis_version");
                        Assert.assertEquals(obj.get("chrom"),LIMSObj.get("CHROMOSOME"),"Error for record with gene "+obj.get("gene")+ " chrom");
//                        Assert.assertEquals(obj.get("ldt_reportable"),LIMSObj.get("LDTREPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ldt_reportable");
                        Assert.assertEquals(obj.get("ldt_reportable").toString(),LIMSObj.get("LDTREPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ldt_reportable");
                        Assert.assertEquals(obj.get("ruo_reportable"),LIMSObj.get("RUOREPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ruo_reportable");


                    }



                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "CNV data verified successfully");

        }
        else{
            System.err.println( "CNV data verification not successful");
        }

    }

    public static void compareFusionData(){
        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for Fusion");
        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;

                try{
                    if (obj.get("gene_a").equals(LIMSObj.get("GENE_A")) ){
//                        System.out.println("Start comparision for gene"+LIMSObj.get("GENE"));
                        String comment = obj.get("variant_comment")==null ? "":(obj.get("variant_comment").toString().replaceAll(";",","));
                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("gene_a")+ " run_sample_id");
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("gene_a")+ " runid");
                        Assert.assertEquals(obj.get("gene_a"),LIMSObj.get("GENE_A"),"Error for record with gene "+obj.get("gene_a")+ " gene_a");
                        Assert.assertEquals(obj.get("gene_b"),LIMSObj.get("GENE_B"),"Error for record with gene "+obj.get("gene_a")+ " gene_b");
                        Assert.assertEquals(obj.get("chrom_a"),LIMSObj.get("CHROMOSOME_A"),"Error for record with gene "+obj.get("gene_a")+ " chrom_a");
                        Assert.assertEquals(obj.get("chrom_b"),LIMSObj.get("CHROMOSOME_B"),"Error for record with gene "+obj.get("gene_a")+ " chrom_b");
                        Assert.assertEquals(obj.get("pos_a"),LIMSObj.get("POSITION_A").toString(),"Error for record with gene "+obj.get("gene_a")+ " pos_a");
                        Assert.assertEquals(obj.get("pos_b"),LIMSObj.get("POSITION_B").toString(),"Error for record with gene "+obj.get("gene_a")+ " pos_b");
                        Assert.assertEquals(obj.get("molecule_coverage_a"),LIMSObj.get("WILDTYPE_MOLECULE_COUNT_A"),"Error for record with gene "+obj.get("gene_a")+ " molecule_coverage_a");
                        Assert.assertEquals(obj.get("molecule_coverage_b"),LIMSObj.get("WILDTYPE_MOLECULE_COUNT_B"),"Error for record with gene "+obj.get("gene_a")+ " molecule_coverage_b");
//                        Assert.assertEquals(obj.get("direction_a"),LIMSObj.get("DIRECTION_A"),"Error for record with gene "+obj.get("gene_a")+ " direction_a");
//                        Assert.assertEquals(obj.get("direction_b"),LIMSObj.get("DIRECTION_B"),"Error for record with gene "+obj.get("gene_a")+ " direction_b");
                        Assert.assertEquals(obj.get("downstream_gene"),LIMSObj.get("DOWNSTREAM_GENE"),"Error for record with gene "+obj.get("gene_a")+ " downstream_gene");
//                        Assert.assertEquals(obj.get("orientation_gene_a"),LIMSObj.get("ORIENTATION_GENE_A"),"Error for record with gene "+obj.get("gene_a")+ " orientation_gene_a");
//                        Assert.assertEquals(obj.get("orientation_gene_b"),LIMSObj.get("ORIENTATION_GENE_B"),"Error for record with gene "+obj.get("gene_a")+ " orientation_gene_b");
                        Assert.assertEquals(obj.get("fusion_molecule_count_a"),LIMSObj.get("FUSION_MOLECULE_COUNT_A"),"Error for record with gene "+obj.get("gene_a")+ " fusion_molecule_count_a");
                        Assert.assertEquals(obj.get("fusion_molecule_count_b"),LIMSObj.get("FUSION_MOLECULE_COUNT_B"),"Error for record with gene "+obj.get("gene_a")+ " fusion_molecule_count_b");
                        Assert.assertEquals(obj.get("fusion_molecule_count_ab"),LIMSObj.get("FUSION_MOLECULE_COUNT_AB"),"Error for record with gene "+obj.get("gene_a")+ " fusion_molecule_count_ab");
                        Assert.assertEquals(obj.get("call"),LIMSObj.get("FUSION_CALL"),"Error for record with gene "+obj.get("gene_a")+ " call");
                        Assert.assertEquals(obj.get("tb_code"),LIMSObj.get("TBCODE"),"Error for record with gene "+obj.get("gene_a")+ " tb_code");
                        Assert.assertEquals(comment,LIMSObj.get("VARIANTCOMMENT"),"Error for record with gene "+obj.get("gene_a")+ " variant_comment");
                        Assert.assertEquals(obj.get("analysis_version"),LIMSObj.get("ANALYSISVERSION"),"Error for record with gene "+obj.get("gene_a")+ " analysis_version");
                        Assert.assertEquals(obj.get("nof1_comment"),LIMSObj.get("NOF1_COMMENT"),"Error for record with gene "+obj.get("gene_a")+ " nof1_comment");
                        Assert.assertEquals(((BigDecimal)obj.get("percentage")).stripTrailingZeros().doubleValue(),LIMSObj.get("PERCENT_FUSION_AB"),"Error for record with gene "+obj.get("gene_a")+ " percentage");
                        Assert.assertEquals(obj.get("fusion_read_count_ab"),LIMSObj.get("FUSION_READ_COUNT_AB"),"Error for record with gene "+obj.get("gene_a")+ " fusion_read_count_ab");
                        Assert.assertEquals(obj.get("fusion_read_count_a"),LIMSObj.get("FUSION_READ_COUNT_A"),"Error for record with gene "+obj.get("gene_a")+ " fusion_read_count_a");
                        Assert.assertEquals(obj.get("fusion_read_count_b"),LIMSObj.get("FUSION_READ_COUNT_B"),"Error for record with gene "+obj.get("gene_a")+ " fusion_read_count_b");
                        Assert.assertEquals(obj.get("ldt_reportable").toString(),LIMSObj.get("LDTREPORTABLE"),"Error for record with gene "+obj.get("gene_a")+ " ldt_reportable");
                        Assert.assertEquals(obj.get("ruo_reportable"),LIMSObj.get("RUOREPORTABLE"),"Error for record with gene "+obj.get("gene_a")+ " ruo_reportable");
                    }



                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "Fusion data verified successfully");

        }
        else{
            System.err.println( "Fusion data verification not successful");
        }


    }

    public static void compareDeletionData(){

        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for Deletion");


        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;


                try{
                    if (obj.get("gene").equals(LIMSObj.get("GENE")) ){

                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("gene")+ " runid");
                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("gene")+ " run_sample_id");
                        Assert.assertEquals(obj.get("chrom"),LIMSObj.get("CHROM"),"Error for record with gene "+obj.get("gene")+ " chrom");
                        Assert.assertEquals(obj.get("start_pos"),LIMSObj.get("START_POS"),"Error for record with gene "+obj.get("gene")+ " start_pos");
                        Assert.assertEquals(obj.get("end_pos"),LIMSObj.get("END_POS"),"Error for record with gene "+obj.get("gene")+ " end_pos");
                        Assert.assertEquals(obj.get("nprobes"),LIMSObj.get("NPROBES"),"Error for record with gene "+obj.get("gene")+ " nprobes");
                        Assert.assertEquals(obj.get("copy_number"),LIMSObj.get("COPY_NUMBER"),"Error for record with gene "+obj.get("gene")+ " copy_number");
                        Assert.assertEquals(obj.get("gene"),LIMSObj.get("GENE"),"Error for record with gene "+obj.get("gene")+ " gene");
                        Assert.assertEquals(obj.get("mean"),LIMSObj.get("MEAN"),"Error for record with gene "+obj.get("gene")+ " mean");
                        Assert.assertEquals(obj.get("sd"),LIMSObj.get("SD"),"Error for record with gene "+obj.get("gene")+ " sd");
                        Assert.assertEquals(obj.get("z_score"),LIMSObj.get("Z_SCORE"),"Error for record with gene "+obj.get("gene")+ " z_score");
                        Assert.assertEquals(obj.get("p_value"),LIMSObj.get("P_VALUE"),"Error for record with gene "+obj.get("gene")+ " p_value");
                        Assert.assertEquals(obj.get("timestamp"),LIMSObj.get("TIMESTAMP"),"Error for record with gene "+obj.get("gene")+ " timestamp");
                        Assert.assertEquals(obj.get("is_deletion"),LIMSObj.get("IS_DELETION").equals("1")?true:false,"Error for record with gene "+obj.get("gene")+ " is_deletion");
                        Assert.assertEquals(obj.get("ll1"),LIMSObj.get("LL1"),"Error for record with gene "+obj.get("gene")+ " ll1");
                        Assert.assertEquals(obj.get("ll2"),LIMSObj.get("LL2"),"Error for record with gene "+obj.get("gene")+ " ll2");
                        Assert.assertEquals(obj.get("aic_score"),LIMSObj.get("AIC_SCORE"),"Error for record with gene "+obj.get("gene")+ " aic_score");
                        Assert.assertEquals(obj.get("llr_score"),LIMSObj.get("LLR_SCORE"),"Error for record with gene "+obj.get("gene")+ " llr_score");
                        Assert.assertEquals(obj.get("call"),LIMSObj.get("CALL"),"Error for record with gene "+obj.get("gene")+ " call");
                        Assert.assertEquals(obj.get("cnv_type"),LIMSObj.get("CNV_TYPE"),"Error for record with gene "+obj.get("gene")+ " cnv_type");
                        Assert.assertEquals(obj.get("nsnp"),LIMSObj.get("NSNP"),"Error for record with gene "+obj.get("gene")+ " nsnp");
                        Assert.assertEquals(obj.get("mutant_allele_status"),LIMSObj.get("MUTANT_ALLELE_STATUS"),"Error for record with gene "+obj.get("gene")+ " mutant_allele_status");
                        Assert.assertEquals(obj.get("variant_comment"),LIMSObj.get("VARIANT_COMMENT"),"Error for record with gene "+obj.get("gene")+ " variant_comment");
                        Assert.assertEquals(obj.get("focal"),LIMSObj.get("FOCAL"),"Error for record with gene "+obj.get("gene")+ " focal");
                        Assert.assertEquals(obj.get("segment_size"),LIMSObj.get("SEGMENT_SIZE"),"Error for record with gene "+obj.get("gene")+ " segment_size");
                        Assert.assertEquals(obj.get("pct_gene_overlap"),new Integer((int)LIMSObj.get("PCT_GENE_OVERLAP")).doubleValue(),"Error for record with gene "+obj.get("gene")+ " pct_gene_overlap");
                        Assert.assertEquals(obj.get("ldt_reportable"),LIMSObj.get("LDT_REPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ldt_reportable");
                        Assert.assertEquals(obj.get("estimated_cn"),LIMSObj.get("ESTIMATED_CN"),"Error for record with gene "+obj.get("gene")+ " estimated_cn");
                        Assert.assertEquals(obj.get("npoints"),LIMSObj.get("NPOINTS"),"Error for record with gene "+obj.get("gene")+ " npoints");
                        Assert.assertEquals(obj.get("analysis_version"),LIMSObj.get("ANALYSISVERSION"),"Error for record with gene "+obj.get("gene")+ " analysis_version");
                        Assert.assertEquals(obj.get("ruo_reportable"),LIMSObj.get("RUOREPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ruo_reportable");



                    }



                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "Deletion data verified successfully");

        }
        else{
            System.err.println( "Deletion data verification not successful");
        }

    }

    public static void compareDenovoFusionData(){
        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for DenovoFusion");

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;


                try{
                    if (obj.get("run_sample_id").equals(LIMSObj.get("SAMPLEID")) ){

                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("gene_a")+ " run_sample_id");
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("gene_a")+ " runid");
                        Assert.assertEquals(obj.get("call"),LIMSObj.get("CALL"),"Error for record with gene "+obj.get("gene_a")+ " call");
                        Assert.assertEquals(obj.get("valid"),LIMSObj.get("VALID"),"Error for record with gene "+obj.get("gene_a")+ " valid");
                        Assert.assertEquals(obj.get("chrom_a"),LIMSObj.get("CHROM_A"),"Error for record with gene "+obj.get("gene_a")+ " chrom_a");
                        Assert.assertEquals(obj.get("pos_a"),LIMSObj.get("POS_A"),"Error for record with gene "+obj.get("gene_a")+ " pos_a");
                        Assert.assertEquals(obj.get("direction_a"),LIMSObj.get("DIRECTION_A"),"Error for record with gene "+obj.get("gene_a")+ " direction_a");
                        Assert.assertEquals(obj.get("chrom_b"),LIMSObj.get("CHROM_B"),"Error for record with gene "+obj.get("gene_a")+ " chrom_b");
                        Assert.assertEquals(obj.get("pos_b"),LIMSObj.get("POS_B"),"Error for record with gene "+obj.get("gene_a")+ " pos_b");
                        Assert.assertEquals(obj.get("direction_b"),LIMSObj.get("DIRECTION_B"),"Error for record with gene "+obj.get("gene_a")+ " direction_b");
                        Assert.assertEquals(obj.get("indel"),LIMSObj.get("INDEL"),"Error for record with gene "+obj.get("gene_a")+ " indel");
                        Assert.assertEquals(obj.get("mol_cnt"),LIMSObj.get("MOL_CNT"),"Error for record with gene "+obj.get("gene_a")+ " mol_cnt");
                        Assert.assertEquals(obj.get("mol_cnt_a"),LIMSObj.get("MOL_CNT_A"),"Error for record with gene "+obj.get("gene_a")+ " mol_cnt_a");
                        Assert.assertEquals(obj.get("mol_cnt_b"),LIMSObj.get("MOL_CNT_B"),"Error for record with gene "+obj.get("gene_a")+ " mol_cnt_b");
                        Assert.assertEquals(obj.get("fusion_ds_count_ab"),LIMSObj.get("FUSION_DS_COUNT_AB"),"Error for record with gene "+obj.get("gene_a")+ " fusion_ds_count_ab");
                        Assert.assertEquals(obj.get("fusion_robust_count_ab"),LIMSObj.get("FUSION_ROBUST_COUNT_AB"),"Error for record with gene "+obj.get("gene_a")+ " fusion_robust_count_ab");
                        Assert.assertEquals(obj.get("fusion_mol_count_ab"),LIMSObj.get("FUSION_MOL_COUNT_AB"),"Error for record with gene "+obj.get("gene_a")+ " fusion_mol_count_ab");
                        Assert.assertEquals(obj.get("fusion_read_count_ab"),LIMSObj.get("FUSION_READ_COUNT_AB"),"Error for record with gene "+obj.get("gene_a")+ " fusion_read_count_ab");
                        Assert.assertEquals(obj.get("percentage"),(LIMSObj.get("PERCENTAGE")),"Error for record with gene "+obj.get("gene_a")+ " percentage");
                        double vfs= (Double)obj.get("average_family_size");
                        Assert.assertEquals((int)Math.round(vfs),LIMSObj.get("AVERAGE_FAMILY_SIZE"),"Error for record with gene "+obj.get("gene_a")+ " average_family_size");
                        Assert.assertEquals(obj.get("failure_mode"),LIMSObj.get("FAILURE_MODE"),"Error for record with gene "+obj.get("gene_a")+ " failure_mode");
                        Assert.assertEquals(obj.get("gene_a"),LIMSObj.get("GENE_A"),"Error for record with gene "+obj.get("gene_a")+ " gene_a");
                        Assert.assertEquals(obj.get("gene_b"),LIMSObj.get("GENE_B"),"Error for record with gene "+obj.get("gene_a")+ " gene_b");
                        Assert.assertEquals(obj.get("exons"),LIMSObj.get("EXONS"),"Error for record with gene "+obj.get("gene_a")+ " exons");
                        Assert.assertEquals(obj.get("exon_a"),LIMSObj.get("EXON_A"),"Error for record with gene "+obj.get("gene_a")+ " exon_a");
                        Assert.assertEquals(obj.get("exon_b"),LIMSObj.get("EXON_B"),"Error for record with gene "+obj.get("gene_a")+ " exon_b");
                        Assert.assertEquals(obj.get("somatic_call"),LIMSObj.get("SOMATIC_CALL"),"Error for record with gene "+obj.get("gene_a")+ " somatic_call");
                        Assert.assertEquals(obj.get("tag"),LIMSObj.get("TAG"),"Error for record with gene "+obj.get("gene_a")+ " tag");
                        Assert.assertEquals(obj.get("reciprocal_to"),LIMSObj.get("RECIPROCAL_TO"),"Error for record with gene "+obj.get("gene_a")+ " reciprocal_to");
                        Assert.assertEquals(obj.get("cnv"),LIMSObj.get("CNV"),"Error for record with gene "+obj.get("gene_a")+ " cnv");
                        Assert.assertEquals(obj.get("gene_orientation_a"),LIMSObj.get("GENE_ORIENTATION_A"),"Error for record with gene "+obj.get("gene_a")+ " gene_orientation_a");
                        Assert.assertEquals(obj.get("gene_orientation_b"),LIMSObj.get("GENE_ORIENTATION_B"),"Error for record with gene "+obj.get("gene_a")+ " gene_orientation_b");
                        Assert.assertEquals(obj.get("downstream_gene"),LIMSObj.get("DOWNSTREAM_GENE"),"Error for record with gene "+obj.get("gene_a")+ " downstream_gene");
                        Assert.assertEquals(obj.get("nof1_comment"),LIMSObj.get("NOF1_COMMENT"),"Error for record with gene "+obj.get("gene_a")+ " nof1_comment");
                        Assert.assertEquals(obj.get("functional_impact"),LIMSObj.get("FUNCTIONAL_IMPACT"),"Error for record with gene "+obj.get("gene_a")+ " functional_impact");
                        Assert.assertEquals(obj.get("variant_comment"),LIMSObj.get("VARIANT_COMMENT"),"Error for record with gene "+obj.get("gene_a")+ " variant_comment");
                        Assert.assertEquals(obj.get("mutant_allele_status"),LIMSObj.get("MUTANT_ALLELE_STATUS"),"Error for record with gene "+obj.get("gene_a")+ " mutant_allele_status");
                        Assert.assertEquals(obj.get("ldt_reportable"),LIMSObj.get("LDT_REPORTABLE"),"Error for record with gene "+obj.get("gene_a")+ " ldt_reportable");
                        Assert.assertEquals(obj.get("analysis_version"),LIMSObj.get("ANALYSISVERSION"),"Error for record with gene "+obj.get("gene_a")+ " analysis_version");
                        Assert.assertEquals(obj.get("ruo_reportable"),LIMSObj.get("RUOREPORTABLE"),"Error for record with gene "+obj.get("gene_a")+ " ruo_reportable");
                        int ISPOSITIVEBYREVIEW = ((int)obj.get("call") == 1 || (int)obj.get("call") == 2 || (int)obj.get("call") == 3)?1:0;

                        int ISPOSITIVEBYTUMORBOARDREVIEW = ((int)obj.get("call") == 1 || (int)obj.get("call") == 2 || (int)obj.get("call") == 3)?1:0;

                        Assert.assertEquals(String.valueOf(ISPOSITIVEBYREVIEW),LIMSObj.get("ISPOSITIVEBYREVIEW"));
                        Assert.assertEquals(String.valueOf(ISPOSITIVEBYTUMORBOARDREVIEW),LIMSObj.get("ISPOSITIVEBYTUMORBOARDREVIEW"));
                    }
                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "DenovoFusion data verified successfully");

        }
        else{
            System.err.println( "DenovoFusion data verification not successful");
        }

    }

    public static void compareIndelData(){

        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for Indel");

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;


                try{
                    if ((obj.get("gene").equals(LIMSObj.get("GENE")) ) && (obj.get("mut_aa").equals(LIMSObj.get("AMINOACID_MUTATION")))){

                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("gene")+ " run_sample_id");
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("gene")+ " runid");
//                        Assert.assertEquals(obj.get("sequence"),LIMSObj.get("SEQUENCE"),"Error for record with gene "+obj.get("gene")+ " sequence");
                        Assert.assertEquals(obj.get("exon"),LIMSObj.get("EXON"),"Error for record with gene "+obj.get("gene")+ " exon");
                        Assert.assertEquals(obj.get("chrom"),LIMSObj.get("CHROMOSOME"),"Error for record with gene "+obj.get("gene")+ " chromosome");
                        Assert.assertEquals(obj.get("position"),LIMSObj.get("POSITION_START"),"Error for record with gene "+obj.get("gene")+ " position");
                        Assert.assertEquals(obj.get("gene"),LIMSObj.get("GENE"),"Error for record with gene "+obj.get("gene")+ " gene");
                        Assert.assertEquals(obj.get("mut_aa"),LIMSObj.get("AMINOACID_MUTATION"),"Error for record with gene "+obj.get("gene")+ " aminoacid_mutation");
                        Assert.assertEquals(obj.get("indel_fam_cnt"),LIMSObj.get("INDEL_FAM_CNT"),"Error for record with gene "+obj.get("gene")+ " indel_fam_cnt");
//                        Assert.assertEquals(obj.get("refbase"),LIMSObj.get("REFBASE"),"Error for record with gene "+obj.get("gene")+ " refbase");
                        Assert.assertEquals(obj.get("transcript_id"),LIMSObj.get("TRANSCRIPT_ID"),"Error for record with gene "+obj.get("gene")+ " transcript_id");
                        Assert.assertEquals(obj.get("total_read_cnt"),LIMSObj.get("TOTAL_READ_CNT"),"Error for record with gene "+obj.get("gene")+ " total_read_count");
                        Assert.assertEquals(obj.get("indel_ds_cnt"),LIMSObj.get("INDEL_DS_CNT"),"Error for record with gene "+obj.get("gene")+ " indel_ds_cnt");
                        Assert.assertEquals(obj.get("fam_cnt"),LIMSObj.get("FAM_CNT"),"Error for record with gene "+obj.get("gene")+ " fam_cnt");
//                        Assert.assertEquals(obj.get("pass_fail"),LIMSObj.get("PASS_FAIL"),"Error for record with gene "+obj.get("gene")+ " pass_fail");
                        Assert.assertEquals(obj.get("length"),LIMSObj.get("LENGTH"),"Error for record with gene "+obj.get("gene")+ " length");
                        Assert.assertEquals(obj.get("type"),LIMSObj.get("TYPE"),"Error for record with gene "+obj.get("gene")+ " type");
                        Assert.assertEquals(obj.get("cdna"),LIMSObj.get("CDNA"),"Error for record with gene "+obj.get("gene")+ " cdna");
                        Assert.assertEquals(obj.get("splice_effect"),LIMSObj.get("SPLICEEFFECT"),"Error for record with gene "+obj.get("gene")+ " splice_effect");

                        Assert.assertEquals(((BigDecimal)obj.get("percentage")).stripTrailingZeros().doubleValue(),
                                LIMSObj.get("INDELS_RATIO"),"Error for record with gene "+obj.get("gene")+ " percentage");


                        Assert.assertEquals(obj.get("reporting_category"),LIMSObj.get("REPORTING_CATEGORY"),"Error for record with gene "+obj.get("gene")+ " reporting_category");
                        Assert.assertEquals(obj.get("llscore"),LIMSObj.get("LLSCORE"),"Error for record with gene "+obj.get("gene")+ " llscore");


                    }
                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "Indel data verified successfully");

        }
        else{
            System.err.println( "Indel data verification not successful");
        }

    }

    public static void compareAlleleTypeData(){
        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for AlleleType");

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;


                try{
                    if (obj.get("gene").equals(LIMSObj.get("GENE")) ){
                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("gene")+ " run_sample_id");
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("gene")+ " runid");
                        Assert.assertEquals(obj.get("gene"),LIMSObj.get("GENE"),"Error for record with gene "+obj.get("gene")+ " gene");
                        Assert.assertEquals(obj.get("alleletypes"),LIMSObj.get("ALLELETYPE"),"Error for record with gene "+obj.get("gene")+ " alleletypes");
                        Assert.assertEquals(obj.get("genotype"),LIMSObj.get("GENOTYPE"),"Error for record with gene "+obj.get("gene")+ " genotype");
                        Assert.assertEquals(obj.get("analysis_version"),LIMSObj.get("ANALYSISVERSION"),"Error for record with gene "+obj.get("gene")+ " analysis_version");
                        Assert.assertEquals(obj.get("ldt_reportable"),LIMSObj.get("LDTREPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ldt_reportable");
                        Assert.assertEquals(obj.get("ruo_reportable"),LIMSObj.get("RUOREPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ruo_reportable");

                    }
                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "AlleleType data verified successfully");

        }
        else{
            System.err.println( "AlleleType data verification not successful");
        }

    }

    public static void compareSingleMethylData(){
        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for SingleMethyl");

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;


                try{
                    if (obj.get("gene").equals(LIMSObj.get("GENE")) ){
                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("gene")+ " run_sample_id");
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("gene")+ " runid");
                        Assert.assertEquals(obj.get("gene"),LIMSObj.get("GENE"),"Error for record with gene "+obj.get("gene")+ " gene");
                        Assert.assertEquals(obj.get("methyl_score"),LIMSObj.get("METHYLSCORE"),"Error for record with gene "+obj.get("gene")+ " methyl_score");
                        Assert.assertEquals(obj.get("threshold"),LIMSObj.get("THRESHOLD"),"Error for record with gene "+obj.get("gene")+ " threshold");
                        Assert.assertEquals(obj.get("min_molecule"),LIMSObj.get("MINMOLECULE"),"Error for record with gene "+obj.get("gene")+ " min_molecule");
                        Assert.assertEquals(obj.get("molecules"),LIMSObj.get("MOLECULES"),"Error for record with gene "+obj.get("gene")+ " molecules");
                        Assert.assertEquals(obj.get("call"),LIMSObj.get("CALL"),"Error for record with gene "+obj.get("gene")+ " call");
                        Assert.assertEquals(obj.get("analysis_version"),LIMSObj.get("ANALYSISVERSION"),"Error for record with gene "+obj.get("gene")+ " analysis_version");
                        Assert.assertEquals(obj.get("ldt_reportable"),LIMSObj.get("LDTREPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ldt_reportable");
                        Assert.assertEquals(obj.get("ruo_reportable"),LIMSObj.get("RUOREPORTABLE"),"Error for record with gene "+obj.get("gene")+ " ruo_reportable");
                    }
                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "SingleMethyl data verified successfully");

        }
        else{
            System.err.println( "SingleMethyl data verification not successful");
        }

    }

    public static void compareVirusData(){
        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for Virus");

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;


                try{
                    if (obj.get("virus").equals(LIMSObj.get("VIRUS")) ){
                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("virus")+ " run_sample_id");
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("virus")+ " runid");
                        Assert.assertEquals(obj.get("virus"),LIMSObj.get("VIRUS"),"Error for record with gene "+obj.get("virus")+ " virus");
                        Assert.assertEquals(obj.get("molecule_count"),LIMSObj.get("MOLECULECOUNT"),"Error for record with gene "+obj.get("virus")+ " molecule_count");
                        Assert.assertEquals(obj.get("estimated_copy_number"),LIMSObj.get("ESTIMATEDCOPYNUMBER"),"Error for record with gene "+obj.get("virus")+ " estimated_copy_number");


                        Assert.assertEquals((int)Math.round((Double)obj.get("cut_off")),LIMSObj.get("CUTOFF"),"Error for record with gene "+obj.get("virus")+ " cut_off");
                        Assert.assertEquals(obj.get("call"),LIMSObj.get("CALL"),"Error for record with gene "+obj.get("virus")+ " call");
                        Assert.assertEquals(obj.get("analysis_version"),LIMSObj.get("ANALYSISVERSION"),"Error for record with gene "+obj.get("virus")+ " analysis_version");
                        Assert.assertEquals(obj.get("ldt_reportable"),LIMSObj.get("LDTREPORTABLE"),"Error for record with gene "+obj.get("virus")+ " ldt_reportable");
                        Assert.assertEquals(obj.get("ruo_reportable"),LIMSObj.get("RUOREPORTABLE"),"Error for record with gene "+obj.get("virus")+ " ruo_reportable");

                    }
                }
                catch(Exception e){

//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                }
            });
        });
    }

    public void compareSampleCoveragelData(){

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;


                try{
                    if (obj.get("gene").equals(LIMSObj.get("GENE")) ){
                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("gene")+ " run_sample_id");
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("gene")+ " runid");
                        Assert.assertEquals(obj.get("chrom"),LIMSObj.get("CHROM"),"Error for record with gene "+obj.get("gene")+ " chrom");
                        Assert.assertEquals(obj.get("start_pos"),LIMSObj.get("START_POS"),"Error for record with gene "+obj.get("gene")+ " start_pos");
                        Assert.assertEquals(obj.get("end_pos"),LIMSObj.get("END_POS"),"Error for record with gene "+obj.get("gene")+ " end_pos");
                        Assert.assertEquals(obj.get("region_name"),LIMSObj.get("REGION_NAME"),"Error for record with gene "+obj.get("gene")+ " region_name");
                        Assert.assertEquals(obj.get("gene"),LIMSObj.get("GENE"),"Error for record with gene "+obj.get("gene")+ " gene");
                        Assert.assertEquals(obj.get("transcript"),LIMSObj.get("TRANSCRIPT"),"Error for record with gene "+obj.get("gene")+ " transcript");
                        Assert.assertEquals(obj.get("median_coverage"),LIMSObj.get("MEDIAN_COVERAGE"),"Error for record with gene "+obj.get("gene")+ " median_coverage");
                        Assert.assertEquals(obj.get("status"),LIMSObj.get("STATUS"),"Error for record with gene "+obj.get("gene")+ " status");

                    }
                }
                catch(Exception e){

//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                }
            });
        });
    }

    public static void compareMSIData(){
        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for MSI");
        //Fails in num_evaluable_sites

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;


                try{
                    if (obj.get("max_maf").equals(LIMSObj.get("MAX_MAF")) ){
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("run_sample_id")+ " runid");
                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("run_sample_id")+ " run_sample_id");
                        Assert.assertEquals(obj.get("msi_score"),LIMSObj.get("MSI_SCORE"),"Error for record with gene "+obj.get("run_sample_id")+ " msi_score");
                        Assert.assertEquals(obj.get("msi_status"),LIMSObj.get("MSI_STATUS"),"Error for record with gene "+obj.get("run_sample_id")+ " msi_status");
                        Assert.assertEquals(obj.get("max_maf"),LIMSObj.get("MAX_MAF"),"Error for record with gene "+obj.get("run_sample_id")+ " max_maf");
                        Assert.assertEquals(obj.get("mean_maf"),LIMSObj.get("MEAN_MAF"),"Error for record with gene "+obj.get("run_sample_id")+ " mean_maf");
//                        Assert.assertEquals(obj.get("num_evaluable_sites"),LIMSObj.get("NUMEVALUABLESITES"),"Error for record with gene "+obj.get("run_sample_id")+ " num_evaluable_sites int4");

                    }
                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "MSI data verified successfully");

        }
        else{
            System.err.println( "MSI data verification not successful");
        }

    }

    public static void compareTMBData(){
        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for TMB");

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;


                try{
                    if (obj.get("run_sample_id").equals(LIMSObj.get("SAMPLEID")) ){
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("run_sample_id")+ " runid");
                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("run_sample_id")+ " run_sample_id");
                        Assert.assertEquals(obj.get("num_muts"),LIMSObj.get("NUM_MUTS"),"Error for record with gene "+obj.get("run_sample_id")+ " num_muts");
                        Assert.assertEquals(obj.get("num_nonsyn"),LIMSObj.get("NUM_NONSYN"),"Error for record with gene "+obj.get("run_sample_id")+ " num_nonsyn");
                        Assert.assertEquals( obj.get("mut_rate"), new Integer((int)LIMSObj.get("MUT_RATE")).doubleValue(),"Error for record with gene "+obj.get("run_sample_id")+ " mut_rate");
                        Assert.assertEquals((obj.get("nonsyn_rate")),new Integer((int)LIMSObj.get("NONSYN_RATE")).doubleValue(),"Error for record with gene "+obj.get("run_sample_id")+ " nonsyn_rate");
                        Assert.assertEquals(obj.get("tmb_score"),LIMSObj.get("TMB_SCORE"),"Error for record with gene "+obj.get("run_sample_id")+ " tmb_score");
                        Assert.assertEquals(obj.get("tmb_category"),LIMSObj.get("TMB_CATEGORY"),"Error for record with gene "+obj.get("run_sample_id")+ " tmb_category");
                        Assert.assertEquals(obj.get("num_nonsyn_nondriver"),LIMSObj.get("NUM_NONSYN_NONDRIVER"),"Error for record with gene "+obj.get("run_sample_id")+ " num_nonsyn_nondriver");
                        Assert.assertEquals(obj.get("nonsyn_nondriver_rate"),new Integer((int)LIMSObj.get("NONSYN_NONDRIVER_RATE")).doubleValue(),"Error for record with gene "+obj.get("run_sample_id")+ " nonsyn_nondriver_rate");

                    }
                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "TMB data verified successfully");

        }
        else{
            System.err.println( "TMB data verification not successful");
        }

    }

    public static void compareHRDData(){

        AtomicInteger flag= new AtomicInteger();

        System.out.println("Comparing data for HRD");

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;

                try{
                    if (obj.get("run_sample_id").equals(LIMSObj.get("SAMPLEID")) ){
                        Assert.assertEquals(obj.get("run_sample_id"),LIMSObj.get("SAMPLEID"),"Error for record with gene "+obj.get("gene")+ " run_sample_id");
                        Assert.assertEquals(obj.get("runid"),LIMSObj.get("RUNID"),"Error for record with gene "+obj.get("gene")+ " runid");
                        Assert.assertEquals(obj.get("genome_loh"),LIMSObj.get("GENOME_LOH"),"Error for record with gene "+obj.get("gene")+ " genome_loh");
                        Assert.assertEquals(obj.get("num_path_var"),LIMSObj.get("NUM_PATH_VAR"),"Error for record with gene "+obj.get("gene")+ " num_path_var");
                        Assert.assertEquals(obj.get("path_var_genes"),LIMSObj.get("PATH_VAR_GENES"),"Error for record with gene "+obj.get("gene")+ " path_var_genes");
                        Assert.assertEquals(obj.get("num_reversions"),LIMSObj.get("NUM_REVERSIONS"),"Error for record with gene "+obj.get("gene")+ " num_reversions");
                        Assert.assertEquals(obj.get("reversion_genes"),LIMSObj.get("REVERSION_GENES"),"Error for record with gene "+obj.get("gene")+ " reversion_genes");
                        Assert.assertEquals(obj.get("num_fusion"),LIMSObj.get("NUM_FUSION"),"Error for record with gene "+obj.get("gene")+ " num_fusion");
                        Assert.assertEquals(obj.get("fusion_gene_pairs"),LIMSObj.get("FUSION_GENE_PAIRS"),"Error for record with gene "+obj.get("gene")+ " fusion_gene_pairs");
                        Assert.assertEquals(obj.get("num_loh"),LIMSObj.get("NUM_LOH"),"Error for record with gene "+obj.get("gene")+ " num_loh");
                        Assert.assertEquals(obj.get("loh_genes"),LIMSObj.get("LOH_GENES"),"Error for record with gene "+obj.get("gene")+ " loh_genes");
                        Assert.assertEquals(obj.get("num_homdel"),LIMSObj.get("NUM_HOMDEL"),"Error for record with gene "+obj.get("gene")+ " num_homdel");
                        Assert.assertEquals(obj.get("homdel_genes"),LIMSObj.get("HOMDEL_GENES"),"Error for record with gene "+obj.get("gene")+ " homdel_genes");
                        Assert.assertEquals(obj.get("num_put_del"),LIMSObj.get("NUM_PUT_DEL"),"Error for record with gene "+obj.get("gene")+ " num_put_del");
                        Assert.assertEquals(obj.get("put_del_genes"),LIMSObj.get("PUT_DEL_GENES"),"Error for record with gene "+obj.get("gene")+ " put_del_genes");
                        Assert.assertEquals(obj.get("num_loh_cn"),LIMSObj.get("NUM_LOH_CN"),"Error for record with gene "+obj.get("gene")+ " num_loh_cn");
                        Assert.assertEquals(obj.get("loh_cn_genes"),LIMSObj.get("LOH_CN_GENES"),"Error for record with gene "+obj.get("gene")+ " loh_cn_genes");
                        Assert.assertEquals(obj.get("num_biallelic_mut"),LIMSObj.get("NUM_BIALLELIC_MUT"),"Error for record with gene "+obj.get("gene")+ " num_biallelic_mut");
                        Assert.assertEquals(obj.get("biallelic_mut_genes"),LIMSObj.get("BIALLELIC_MUT_GENES"),"Error for record with gene "+obj.get("gene")+ " biallelic_mut_genes");
                        Assert.assertEquals(obj.get("msaf"),LIMSObj.get("MSAF"),"Error for record with gene "+obj.get("gene")+ " msaf");
                        Assert.assertEquals(obj.get("hrd_score"),LIMSObj.get("HRD_SCORE"),"Error for record with gene "+obj.get("gene")+ " hrd_score");
                        Assert.assertEquals(obj.get("variant_comment"),LIMSObj.get("VARIANT_COMMENT"),"Error for record with gene "+obj.get("gene")+ " variant_comment");
                        Assert.assertEquals(obj.get("reversion_str"),LIMSObj.get("REVERSION_STR"),"Error for record with gene "+obj.get("gene")+ " reversion_str");
                        Assert.assertEquals(obj.get("hrd_status"),LIMSObj.get("HRDCALL"),"Error for record with gene "+obj.get("gene")+ " hrd_status");

                    }

                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "HRD data verified successfully");

        }
        else{
            System.err.println( "HRD data verification not successful");
        }


    }

    public static void compareSampleMethylData(){
        AtomicInteger flag= new AtomicInteger();
        System.out.println("---------------------------------------------------------------");

        System.out.println("Comparing data for SampleMethyl");

        ghDBSpecific ghdb = new ghDBSpecific();

        LIMSDbSpecific lims = new LIMSDbSpecific();
        JSONArray GHDBDataMap = ghdb.getGhDBdata();
        JSONArray LIMSDataMap = lims.getLIMSdata();

        LIMSDataMap.forEach(limsItem->{
            JSONObject LIMSObj= (JSONObject)limsItem;

            GHDBDataMap.forEach(item->{
                JSONObject obj = (JSONObject)item;

//&&
                try{
                    if (LIMSObj.get("SAMPLEID").equals(obj.get("run_sample_id")) && (LIMSObj.get("PREDTYPE")).equals(obj.get("pred_type")) && (LIMSObj.get("METHYLSCORE")).equals(obj.get("methyl_score"))  ){
                        if ((LIMSObj.get("MODELNAME")).equals(obj.get("model_name"))) {
                            Assert.assertEquals(obj.get("run_sample_id"), LIMSObj.get("SAMPLEID"), "Error for record with Tumor Type " + obj.get("pred_type") + " run_sample_id");
                            Assert.assertEquals(obj.get("runid"), LIMSObj.get("RUNID"), "Error for record with Tumor Type " + obj.get("pred_type") + " runid");
                            Assert.assertEquals(obj.get("model_name"), LIMSObj.get("MODELNAME"), "Error for record with Tumor Type " + obj.get("pred_type") + " model_name");
                            Assert.assertEquals(obj.get("methyl_score"), LIMSObj.get("METHYLSCORE"), "Error for record with Tumor Type " + obj.get("pred_type") + " methyl_score");
                            Assert.assertEquals(obj.get("threshold"), (new Integer((int) LIMSObj.get("THRESHOLD")).doubleValue()), "Error for record with gene " + obj.get("pred_type") + " threshold");
                            Assert.assertEquals(obj.get("methyl_call"), LIMSObj.get("METHYLCALL"), "Error for record with Tumor Type " + obj.get("pred_type") + " call");
                            Assert.assertEquals(obj.get("pred_type"), LIMSObj.get("PREDTYPE"), "Error for record with Tumor Type " + obj.get("pred_type") + " pred_type");
                            Assert.assertEquals(obj.get("pred_frac"), LIMSObj.get("PREDTF"), "Error for record with Tumor Type " + obj.get("pred_type") + " pred_frac");
                            Assert.assertEquals(obj.get("analysis_version"), LIMSObj.get("ANALYSISVERSION"), "Error for record with Tumor Type " + obj.get("pred_type") + " analysis_version");
//                      Only for Reveal Products
//                            Assert.assertEquals(obj.get("lower_limit"), LIMSObj.get("LOWERLIMIT"), "Error for record with Tumor Type " + obj.get("pred_type") + " LOWERLIMIT");
//                            Assert.assertEquals(obj.get("upper_limit"), LIMSObj.get("UPPERLIMIT"), "Error for record with Tumor Type " + obj.get("pred_type") + " UPPERLIMIT");
                        }
                    }

                }
                catch(Exception e){
                    flag.addAndGet(1);
//                    System.out.println(obj.get("gene").toString());
                    e.printStackTrace();
                    e.getMessage();
                }
            });
        });

        if (flag.get()==0){
            System.out.println( "SampleMethyl data verified successfully");

        }
        else{
            System.err.println( "SampleMethyl data verification not successful");
        }


    }


public static void excuteTests(){
    int testNumber = testsExecute.counterTest;
//    for (int i : testsExecute.testList){
        switch (testNumber) {
            case 1: //SNV
                compareSNVData();
                break;
            case 2:
                compareCNVData();
                break;
            case 3:
                compareFusionData();
                break;
            case 4:
                compareDenovoFusionData();
                break;
            case 5:
                compareAlleleTypeData();
                break;

            case 6:
                compareVirusData();
                break;
            case 7:
                compareIndelData();
                break;
            case 8:
                compareMSIData();
                break;
            case 9:
                compareHRDData();
                break;
            case 10:
                compareSampleMethylData();
                break;
            case 11:
                compareSingleMethylData();
                break;
            case 12:
                compareDeletionData();
                break;
            case 13:
                compareTMBData();
                break;
            default:
                System.out.println("Default hit");
                break;
            }
//        }
    }

}









