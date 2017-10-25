package com;

import com.thrift.QryResult;
import com.thrift.TestQry;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClientDemo {
    private final static int DEFAULT_QRY_CODE = 1;

    public static void main(String[] args) {
        try {
            TTransport tTransport = getTTransport();
            TProtocol protocol = new TBinaryProtocol(tTransport);
            TestQry.Client client = new TestQry.Client(protocol);
            QryResult result = client.qryTest(DEFAULT_QRY_CODE);
            System.out.println("code=" + result.code + " msg=" + result.msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static TTransport getTTransport() throws Exception {
        try {
            TTransport tTransport = getTTransport("127.0.0.1", 30001, 5000);
            if (!tTransport.isOpen()) {
                tTransport.open();
            }
            return tTransport;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static TTransport getTTransport(String host, int port, int timeout) {
        final TSocket tSocket = new TSocket(host, port, timeout);
        final TTransport transport = new TFramedTransport(tSocket);
        return transport;
    }
}
