package com.melody.client;

import com.melody.proto.grpc.qryaccount.QryAccountProto;
import com.melody.proto.grpc.qryaccount.QryAccountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author melody
 */
public class AccountQueryGrpcClient {

    private final ManagedChannel channel;

    private final QryAccountServiceGrpc.QryAccountServiceBlockingStub blockingStub;

    private final AtomicInteger atomicInteger = new AtomicInteger(1000000);

    public AccountQueryGrpcClient(String host , int port){
        channel = ManagedChannelBuilder.forAddress(host , port).usePlaintext(true).build();
        blockingStub = QryAccountServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void query(){
        QryAccountProto.AccountQryRequest request =
                QryAccountProto.AccountQryRequest.newBuilder().setRequestId(Integer.toString(atomicInteger.getAndIncrement())).setUserId("10191192").build();

        QryAccountProto.AccountQryResponse response = blockingStub.qryAccount(request);

        System.out.println("client-----> " + request.getRequestId());
        System.out.println("server-----> " + response.getAmount());
    }




}
