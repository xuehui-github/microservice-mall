package com.xue.order.mapper;

import com.xue.order.pojo.OdsIasEvalOne;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

public interface OdsOneOfInMapper {

    @Select("<script>" +
            "SELECT COUNT(*) FROM ods_int_d_ias_ttrd_acc_eval_one WHERE 1=1" +
            "<if test='secuAccname != null and secuAccname != \"\"'>" +
            " AND secu_accname LIKE CONCAT('%', #{secuAccname}, '%')" +
            "</if>" +
            "<if test='begDate != null'>" +
            " AND beg_date = #{begDate}" +
            "</if>" +
            "</script>")
    Long count(@Param("secuAccname") String secuAccname,
               @Param("begDate") LocalDate begDate);

    @Select("<script>" +
            "SELECT * FROM ods_int_d_ias_ttrd_acc_eval_one WHERE 1=1" +
            "<if test='secuAccname != null and secuAccname != \"\"'>" +
            " AND secu_accname LIKE CONCAT('%', #{secuAccname}, '%')" +
            "</if>" +
            "<if test='begDate != null'>" +
            " AND beg_date = #{begDate}" +
            "</if>" +
            " ORDER BY beg_date DESC" +
            " LIMIT #{offset}, #{limit}" +
            "</script>")
    List<OdsIasEvalOne> queryList(@Param("secuAccname") String secuAccname,
                                   @Param("begDate") LocalDate begDate,
                                   @Param("offset") Long offset,
                                   @Param("limit") Long limit);
}
