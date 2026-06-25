package com.xue.order.controller;

import com.xue.order.service.FiccService;
import com.xue.order.vo.requests.OdsAppGsmRequest;
import com.xue.order.vo.requests.OdsIasEvalRequest;
import com.xue.order.vo.response.DwdEvalOneResponse;
import com.xue.order.vo.response.OdsAppGsmResponse;
import com.xue.order.vo.response.OdsIasEvalResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ficc")
@Tag(name = "账单明细", description = "Ficc账单明细接口")
public class FiccController {

    @Autowired
    private FiccService ficcService;

    @Operation(summary = "估值表 专户", description = "账户明细估值表，专户数据（MyBatis-Plus -> ods_int_d_ias_ttrd_acc_eval_one）")
    @PostMapping("/prodAssetValu/queryList")
    public OdsIasEvalResponse queryOdsIasEvalList(
            @Parameter(description = "账户明细查询请求") @RequestBody OdsIasEvalRequest odsIasEvalRequest) {
        return ficcService.queryOdsIasEvalList(odsIasEvalRequest);
    }

    @Operation(summary = "估值表 账户(iBatis)", description = "账户明细估值表，专户数据（Apache iBatis -> ods_app_gsm_tg_valu_asset_liab_d_q）")
    @PostMapping("/prodAssetValuOfIn/queryList")
    public OdsAppGsmResponse queryOdsIasEvalOfInList(
            @Parameter(description = "账户明细查询请求") @RequestBody OdsAppGsmRequest request) {
        return ficcService.queryOdsIasEvalOfInList(request);
    }

    @Operation(summary = "第二估值表(DWD)", description = "账户明细估值表，专户数据（MyBatis-Plus -> dwd_eval_one）")
    @PostMapping("/dualProdAssetValuOfout/queryList")
    public DwdEvalOneResponse queryDwdEvalOneList(
            @Parameter(description = "账户明细查询请求") @RequestBody OdsIasEvalRequest request) {
        return ficcService.queryDwdEvalOneList(request);
    }
}
