package com.xue.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xue.order.mapper.DwdEvalOneMapper;
import com.xue.order.mapper.OdsAppGsmTgMapper;
import com.xue.order.mapper.OdsOneMapper;
import com.xue.order.pojo.DwdEvalOne;
import com.xue.order.pojo.OdsAppGsmTgValuAssetLiabDQ;
import com.xue.order.pojo.OdsIasEvalOne;
import com.xue.order.service.FiccService;
import com.xue.order.vo.requests.OdsAppGsmRequest;
import com.xue.order.vo.requests.OdsIasEvalRequest;
import com.xue.order.vo.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class FiccServiceImpl implements FiccService {

    @Autowired
    private OdsOneMapper odsOneMapper;

    @Autowired
    private OdsAppGsmTgMapper odsAppGsmTgMapper;

    @Autowired
    private DwdEvalOneMapper dwdEvalOneMapper;

    @Override
    public PageResult<OdsIasEvalOne> queryOdsIasEvalList(OdsIasEvalRequest request) {
        Page<OdsIasEvalOne> page = new Page<>(request.getPageNum(), request.getPageSize());

        LambdaQueryWrapper<OdsIasEvalOne> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(request.getSecuAccname())) {
            wrapper.like(OdsIasEvalOne::getSecuAccname, request.getSecuAccname());
        }
        if (request.getStartDate() != null) {
            wrapper.ge(OdsIasEvalOne::getBegDate, request.getStartDate());
        }
        if (request.getEndDate() != null) {
            wrapper.le(OdsIasEvalOne::getBegDate, request.getEndDate());
        }
        wrapper.orderByDesc(OdsIasEvalOne::getBegDate);

        Page<OdsIasEvalOne> resultPage = odsOneMapper.selectPage(page, wrapper);

        return PageResult.of(resultPage.getRecords(), resultPage.getTotal(), resultPage.getCurrent(), resultPage.getSize());
    }

    @Override
    public PageResult<OdsAppGsmTgValuAssetLiabDQ> queryOdsIasEvalOfInList(OdsAppGsmRequest request) {
        Long total = odsAppGsmTgMapper.count(
                request.getAcctName(),
                request.getStartDate(), request.getEndDate());
        long offset = (request.getPageNum() - 1) * request.getPageSize();

        List<OdsAppGsmTgValuAssetLiabDQ> records = odsAppGsmTgMapper.queryList(
                request.getAcctName(),
                request.getStartDate(), request.getEndDate(),
                offset, request.getPageSize());

        return PageResult.of(records, total, request.getPageNum(), request.getPageSize());
    }

    @Override
    public PageResult<DwdEvalOne> queryDwdEvalOneList(OdsIasEvalRequest request) {
        Page<DwdEvalOne> page = new Page<>(request.getPageNum(), request.getPageSize());

        LambdaQueryWrapper<DwdEvalOne> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(request.getSecuAccname())) {
            wrapper.like(DwdEvalOne::getSecuAccname, request.getSecuAccname());
        }
        if (request.getStartDate() != null) {
            wrapper.ge(DwdEvalOne::getBegDate, request.getStartDate());
        }
        if (request.getEndDate() != null) {
            wrapper.le(DwdEvalOne::getBegDate, request.getEndDate());
        }
        wrapper.orderByDesc(DwdEvalOne::getBegDate);

        Page<DwdEvalOne> resultPage = dwdEvalOneMapper.selectPage(page, wrapper);

        return PageResult.of(resultPage.getRecords(), resultPage.getTotal(), resultPage.getCurrent(), resultPage.getSize());
    }
}
