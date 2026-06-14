package com.xue.order.service;

import com.xue.order.vo.requests.OdsAppGsmRequest;
import com.xue.order.vo.requests.OdsIasEvalRequest;
import com.xue.order.vo.response.OdsAppGsmResponse;
import com.xue.order.vo.response.OdsIasEvalResponse;

public interface FiccService {

    OdsIasEvalResponse queryOdsIasEvalList(OdsIasEvalRequest odsIasEvalRequest);

    OdsAppGsmResponse queryOdsIasEvalOfInList(OdsAppGsmRequest request);
}
