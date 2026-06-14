package com.xue.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xue.order.mapper.OdsAppGsmTgMapper;
import com.xue.order.mapper.OdsOneMapper;
import com.xue.order.pojo.OdsAppGsmTgValuAssetLiabDQ;
import com.xue.order.pojo.OdsIasEvalOne;
import com.xue.order.service.FiccService;
import com.xue.order.vo.requests.OdsAppGsmRequest;
import com.xue.order.vo.requests.OdsIasEvalRequest;
import com.xue.order.vo.response.OdsAppGsmResponse;
import com.xue.order.vo.response.OdsIasEvalResponse;
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

    @Override
    public OdsIasEvalResponse queryOdsIasEvalList(OdsIasEvalRequest request) {
        // 构建分页对象
        Page<OdsIasEvalOne> page = new Page<>(request.getPageNum(), request.getPageSize());

        // 构建查询条件
        LambdaQueryWrapper<OdsIasEvalOne> wrapper = new LambdaQueryWrapper<>();

        // secu_accname 模糊查询
        if (StringUtils.hasText(request.getSecuAccname())) {
            wrapper.like(OdsIasEvalOne::getSecuAccname, request.getSecuAccname());
        }

        // beg_date 精确匹配
        if (request.getBegDate() != null) {
            wrapper.eq(OdsIasEvalOne::getBegDate, request.getBegDate());
        }

        // 按 beg_date 降序排序
        wrapper.orderByDesc(OdsIasEvalOne::getBegDate);

        // 执行分页查询
        Page<OdsIasEvalOne> resultPage = odsOneMapper.selectPage(page, wrapper);

        // 构建响应
        OdsIasEvalResponse response = new OdsIasEvalResponse();
        response.setRecords(resultPage.getRecords());
        response.setTotal(resultPage.getTotal());
        response.setPageNum(resultPage.getCurrent());
        response.setPageSize(resultPage.getSize());
        response.setPages(resultPage.getPages());

        return response;
    }

    @Override
    public OdsAppGsmResponse queryOdsIasEvalOfInList(OdsAppGsmRequest request) {
        // 使用传统 MyBatis 查询总记录数
        Long total = odsAppGsmTgMapper.count(request.getAcctName(), request.getEtlTxDate());

        // 计算偏移量
        long offset = (request.getPageNum() - 1) * request.getPageSize();

        // 使用传统 MyBatis 分页查询数据
        List<OdsAppGsmTgValuAssetLiabDQ> records = odsAppGsmTgMapper.queryList(
                request.getAcctName(),
                request.getEtlTxDate(),
                offset,
                request.getPageSize());

        // 计算总页数
        long pages = (total + request.getPageSize() - 1) / request.getPageSize();

        // 构建响应
        OdsAppGsmResponse response = new OdsAppGsmResponse();
        response.setRecords(records);
        response.setTotal(total);
        response.setPageNum(request.getPageNum());
        response.setPageSize(request.getPageSize());
        response.setPages(pages);

        return response;
    }
}
