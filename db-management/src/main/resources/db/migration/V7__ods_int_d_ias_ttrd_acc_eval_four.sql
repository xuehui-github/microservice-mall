-- =============================================
-- 变更说明: ficc fiadvisor ods_int_d_ias_ttrd_acc_eval_four definition
-- 作者:     huixue
-- 日期:     2026-05-26
-- 用途:
-- =============================================
--

CREATE TABLE `ods_int_d_ias_ttrd_acc_eval_four` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id，主键',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint DEFAULT NULL COMMENT '是否删除标志,0未删除，1删除',
  `beg_date` date DEFAULT NULL COMMENT '估值日期',
  `secu_accname` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账户名称',
  `secu_accid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账户代码',
  `a_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资产类型',
  `i_code` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资产代码',
  `b_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资产名称',
  `m_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '交易市场',
  `ps_l_amount` decimal(38,6) DEFAULT NULL COMMENT '数量',
  `unit_amount` decimal(38,6) DEFAULT NULL COMMENT '单位成本',
  `amount` decimal(38,6) DEFAULT NULL COMMENT '成本',
  `amount_per` decimal(38,6) DEFAULT NULL COMMENT '成本占净值%',
  `market_price` decimal(38,6) DEFAULT NULL COMMENT '市价',
  `market_value` decimal(38,6) DEFAULT NULL COMMENT '市值',
  `fv_per` decimal(38,6) DEFAULT NULL COMMENT '市值占净值%',
  `fv_inc` decimal(38,6) DEFAULT NULL COMMENT '估值增值',
  `hgir` decimal(38,6) DEFAULT NULL COMMENT '应计利息',
  `imp_date` date DEFAULT NULL COMMENT '恒泰时间',
  `imp_time` datetime DEFAULT NULL COMMENT '衡泰时间',
  `data_dt` date DEFAULT NULL COMMENT '插入数据中心时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2871449 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='投顾团队估值表四级科目数据';