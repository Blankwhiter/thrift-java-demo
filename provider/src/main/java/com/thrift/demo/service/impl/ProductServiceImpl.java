package com.thrift.demo.service.impl;

import com.thrift.demo.api.ProductService;
import org.apache.thrift.TException;

/**
 * 接口服务实现
 */
public class ProductServiceImpl implements ProductService.Iface {
    public void printProductName() throws TException {
        System.out.println("你成功调用了 打印产品名称");
    }

    public String getProductDesc(String name) throws TException {
        return "你成功调用了该"+name+"的描述！！";
    }

    public boolean isHaveStock() throws TException {
        System.out.println("我们永远不可能缺货！！！");
        return true;
    }
}
