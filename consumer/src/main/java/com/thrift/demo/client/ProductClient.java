package com.thrift.demo.client;


import com.thrift.demo.api.ProductService;
import org.apache.thrift.TException;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

/**
 * 建立连接 调用远程接口
 */
public class ProductClient {
    public static void main(String[] args) {

        try {
            TTransport transport;
            transport = new TSocket("127.0.0.1", 9090);

            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            ProductService.Client client = new ProductService.Client(protocol);

            perform(client);

            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    /**
     * 三个接口的调用
     * @param client
     * @throws TException
     */
    private static void perform(ProductService.Client client) throws TException {
        client.printProductName();
        System.out.println(client.getProductDesc("小米 nix"));
        System.out.println(client.isHaveStock());
    }
}
