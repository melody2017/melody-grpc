package com.melody;

import com.melody.client.AccountQueryGrpcClient;

/**
 * @author melody
 */
public class ClientMain {

    public static void main(String[] args) {
        final AccountQueryGrpcClient client = new AccountQueryGrpcClient("127.0.0.1",50015);
        for (int i = 0 ; i < 10000 ; i ++){
            client.query();
        }
    }
}
