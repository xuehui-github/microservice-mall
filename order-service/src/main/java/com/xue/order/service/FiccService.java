package com.xue.order.service;

import com.xue.order.pojo.DwdEvalOne;
import com.xue.order.pojo.OdsAppGsmTgValuAssetLiabDQ;
import com.xue.order.pojo.OdsIasEvalOne;
import com.xue.order.vo.requests.OdsAppGsmRequest;
import com.xue.order.vo.requests.OdsIasEvalRequest;
import com.xue.order.vo.response.PageResult;

public interface FiccService {

    PageResult<OdsIasEvalOne> queryOdsIasEvalList(OdsIasEvalRequest odsIasEvalRequest);

    PageResult<OdsAppGsmTgValuAssetLiabDQ> queryOdsIasEvalOfInList(OdsAppGsmRequest request);

    PageResult<DwdEvalOne> queryDwdEvalOneList(OdsIasEvalRequest request);
}
