package com.melody.grpc;

import com.melody.grpc.server.AccountQueryGrpcServer;

/**
 * @author melody
 */
public class ServerMain {

    public static void main(String[] args) {
        final AccountQueryGrpcServer server = new AccountQueryGrpcServer();
        try {
            server.start();
            server.blockUntilShutdown();
            System.out.println("grpc server is running....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
