-- =============================================
-- 变更说明: 创建省市区地理数据表 china_geo_divisions
-- 作者:     huixue
-- 日期:     2026-05-26
-- 用途:     存储中国省市区三级行政区域数据，包含高德地图GIS坐标和边界
--           数据来源于 ok_data_level*.csv 文件
-- =============================================
CREATE TABLE `china_geo_divisions` (
    `id` INT NOT NULL COMMENT '与ok_data_level*.csv表中的ID相同，通过这个ID关联到省市区具体数据',
    `pid` INT NOT NULL COMMENT '上级ID',
    `deep` TINYINT NOT NULL COMMENT '层级深度；0：省，1：市，2：区',
    `name` VARCHAR(100) NOT NULL COMMENT '如：罗湖区，城市完整名称',
    `ext_path` VARCHAR(500) NOT NULL COMMENT '如：广东省 深圳市 罗湖区，为省市区三级完整名称，中间用空格分隔',
    `geo` POINT SRID 0 NULL COMMENT '城市中心坐标，高德地图GCJ-02火星坐标系。NULL表示无坐标（原EMPTY）',
    `polygon` MULTIPOLYGON SRID 0 NULL COMMENT '行政区域边界，高德地图GCJ-02火星坐标系。NULL表示无边界（原EMPTY），多个地块用MULTIPOLYGON表示',
    PRIMARY KEY (`id`),
    INDEX `idx_pid` (`pid`),
    INDEX `idx_deep` (`deep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='省市区地理数据表（GIS空间字段）';