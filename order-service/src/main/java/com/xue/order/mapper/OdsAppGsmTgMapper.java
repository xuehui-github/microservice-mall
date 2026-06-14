package com.xue.order.mapper;

import com.xue.order.pojo.OdsAppGsmTgValuAssetLiabDQ;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

public interface OdsAppGsmTgMapper {

    @Select("<script>" +
            "SELECT COUNT(*) FROM ods_app_gsm_tg_valu_asset_liab_d_q WHERE 1=1" +
            "<if test='acctName != null and acctName != \"\"'>" +
            " AND acct_name LIKE CONCAT('%', #{acctName}, '%')" +
            "</if>" +
            "<if test='etlTxDate != null'>" +
            " AND etl_tx_date = #{etlTxDate}" +
            "</if>" +
            "</script>")
    Long count(@Param("acctName") String acctName,
               @Param("etlTxDate") LocalDate etlTxDate);

    @Select("<script>" +
            "SELECT * FROM ods_app_gsm_tg_valu_asset_liab_d_q WHERE 1=1" +
            "<if test='acctName != null and acctName != \"\"'>" +
            " AND acct_name LIKE CONCAT('%', #{acctName}, '%')" +
            "</if>" +
            "<if test='etlTxDate != null'>" +
            " AND etl_tx_date = #{etlTxDate}" +
            "</if>" +
            " ORDER BY etl_tx_date DESC" +
            " LIMIT #{offset}, #{limit}" +
            "</script>")
    List<OdsAppGsmTgValuAssetLiabDQ> queryList(@Param("acctName") String acctName,
                                                @Param("etlTxDate") LocalDate etlTxDate,
                                                @Param("offset") Long offset,
                                                @Param("limit") Long limit);
}
