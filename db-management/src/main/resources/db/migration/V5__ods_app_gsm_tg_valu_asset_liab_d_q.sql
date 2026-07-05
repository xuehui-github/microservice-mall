-- =============================================
-- 变更说明: ficc fiadvisor.ods_app_gsm_tg_valu_asset_liab_d_q definition
-- 作者:     huixue
-- 日期:     2026-05-26
-- 用途:
-- =============================================
--

CREATE TABLE `ods_app_gsm_tg_valu_asset_liab_d_q` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除标志,0未删除,1删除',
  `out_key` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '源表唯一键',
  `biz_dt` varchar(8) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '业务日期',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '批次编号',
  `acct_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账户代码',
  `acct_name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账户名称',
  `ord_amt` decimal(38,8) DEFAULT NULL COMMENT '委托规模',
  `total_asset` decimal(38,8) DEFAULT NULL COMMENT '总资产',
  `net_asset` decimal(38,8) DEFAULT NULL COMMENT '净资产',
  `cash_bal` decimal(38,8) DEFAULT NULL COMMENT '现金余额',
  `weighted_principal` decimal(38,8) DEFAULT NULL COMMENT '加权本金',
  `unit_net_val` decimal(38,8) DEFAULT NULL COMMENT '单位净值',
  `abst_rate` decimal(38,8) DEFAULT NULL COMMENT '绝对收益率',
  `anua_rate` decimal(38,8) DEFAULT NULL COMMENT '年化收益率',
  `etl_tx_date` date DEFAULT NULL COMMENT '数据日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3120001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='帐内-估值单一级科目原数据';