-- =============================================
-- 变更说明: ficc fiadvisor.ods_int_d_ias_ttrd_acc_eval_one definition
-- 作者:     huixue
-- 日期:     2026-05-26
-- 用途:
-- =============================================
--

CREATE TABLE `ods_int_d_ias_ttrd_acc_eval_one` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id，主键',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint DEFAULT NULL COMMENT '是否删除标志,0未删除，1删除',
  `beg_date` date DEFAULT NULL COMMENT '估值日期',
  `secu_accname` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账户名称',
  `secu_accid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账户代码',
  `bankamount` decimal(38,6) DEFAULT NULL COMMENT '银行存款',
  `bondamount` decimal(38,6) DEFAULT NULL COMMENT '债券',
  `fundamount` decimal(38,6) DEFAULT NULL COMMENT '基金',
  `productsamount` decimal(38,6) DEFAULT NULL COMMENT '理财产品',
  `receamount` decimal(38,6) DEFAULT NULL COMMENT '应收股利',
  `repurchase` decimal(38,6) DEFAULT NULL COMMENT '正回购',
  `reverse` decimal(38,6) DEFAULT NULL COMMENT '逆回购',
  `derivative` decimal(38,6) DEFAULT NULL COMMENT '衍生品',
  `tbond_futures` decimal(38,6) DEFAULT NULL COMMENT '国债期货空头',
  `actulamount` decimal(38,6) DEFAULT NULL COMMENT '实收资本金额',
  `totalassets` decimal(38,6) DEFAULT NULL COMMENT '总资产',
  `liabilities` decimal(38,6) DEFAULT NULL COMMENT '负债',
  `net_sum` decimal(38,6) DEFAULT NULL COMMENT '净资产',
  `price` decimal(38,6) DEFAULT NULL COMMENT '单位净值',
  `sumprice` decimal(38,6) DEFAULT NULL COMMENT '累计单位净值',
  `net_grorate` decimal(38,6) DEFAULT NULL COMMENT '成立以来净值增长率',
  `net_grorate_year` decimal(38,6) DEFAULT NULL COMMENT '净值年增长率',
  `net_grorate_quarter` decimal(38,6) DEFAULT NULL COMMENT '净值季度增长率',
  `net_grorate_mouth` decimal(38,6) DEFAULT NULL COMMENT '净值月增长率',
  `net_grorate_week` decimal(38,6) DEFAULT NULL COMMENT '净值周增长率',
  `net_grorate_day` decimal(38,6) DEFAULT NULL COMMENT '净值日增长率',
  `totalgrand` decimal(38,6) DEFAULT NULL COMMENT '累计派现金额',
  `tstk` decimal(38,6) DEFAULT NULL COMMENT '股票',
  `bondlb` decimal(38,6) DEFAULT NULL COMMENT '债券借贷',
  `interest_pay` decimal(38,6) DEFAULT NULL COMMENT '应付利息',
  `imp_date` date DEFAULT NULL COMMENT '衡泰时间',
  `imp_time` datetime DEFAULT NULL COMMENT '衡泰时间',
  `data_dt` date DEFAULT NULL COMMENT '插入数据中心时间',
  `settle_balance` decimal(38,12) DEFAULT NULL COMMENT '结算备付金',
  `out_boond` decimal(38,12) DEFAULT NULL COMMENT '存出保证金',
  `trust_pay` decimal(38,12) DEFAULT NULL COMMENT '受托人报酬',
  `storage_fee` decimal(38,12) DEFAULT NULL COMMENT '保管费',
  `investment_fee` decimal(38,12) DEFAULT NULL COMMENT '投资顾问费',
  `sales_service_fee` decimal(38,12) DEFAULT NULL COMMENT '销售服务费',
  `tax_fee` decimal(38,12) DEFAULT NULL COMMENT '税费',
  `other_pay` decimal(38,12) DEFAULT NULL COMMENT '其他应付款',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22705 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='投顾团队估值表一级科目数据';