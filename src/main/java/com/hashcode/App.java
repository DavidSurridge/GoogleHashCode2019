package com.hashcode;

import com.hashcode.service.InputLoader;
import com.hashcode.service.LogicExecutor;
import com.hashcode.model.Payload;

public class App {

    public static void main(String[] args) {
        final InputLoader inputLoader = new InputLoader();
        final Payload payload = inputLoader.getPayload();
        final LogicExecutor logicExecutor = new LogicExecutor();
        logicExecutor.doTheLogic(payload);
    }
}
