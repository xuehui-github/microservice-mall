package com.xue.divisionsservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 对应数据库表 `china_geo_divisions` 的实体类
 * 字段与 V1__china_geo_divisions.sql 保持一致：
 * id, pid, deep, name, ext_path, geo, polygon
 *
 * 注意：数据库中的 geo 和 polygon 为 GIS 类型（POINT / MULTIPOLYGON），
 * 这里使用 String 保存（例如存 WKT），在需要时可以改为使用 JTS 类型并配置相应的类型处理器。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoDivisions implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 与 ok_data_level*.csv 表中的 ID 相同 */
	private Integer id;

	/** 上级 ID */
	private Integer pid;

	/** 层级深度；0：省，1：市，2：区 */
	private Byte deep;

	/** 完整名称，如：罗湖区 */
	private String name;

	/** 省市区三级完整名称，中间用空格分隔 */
	private String extPath;

	/** 城市中心坐标（原为 POINT）。目前以文本（WKT）或经纬度字符串保存，视映射器而定 */
	private String geo;

	/** 行政区域边界（原为 MULTIPOLYGON）。目前以文本（WKT）保存 */
	private String polygon;

}
