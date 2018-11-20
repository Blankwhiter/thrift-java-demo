package com.thrift.demo.server;

import com.thrift.demo.api.ProductService;
import com.thrift.demo.service.impl.ProductServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * 提供产品服务的服务器
 */
public class ProductServer {


    public static ProductServiceImpl handler;

    public static ProductService.Processor processor;

    public static void main(String [] args) {
        try {
            handler = new ProductServiceImpl();
            processor = new ProductService.Processor( handler);

            Runnable simple = new Runnable() {
                public void run() {
                    simple(processor);
                }
            };

            new Thread(simple).start();

        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void simple(ProductService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
            // Use this for a multithreaded server
            // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();
            System.out.println("The simple server  done...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
