package com.hashcode;

import com.hashcode.service.InputLoader;
import com.hashcode.strategies.StrategyOne;

public class App {

    public static void main(String[] args) {
        final InputLoader inputLoader = new InputLoader();
        final StrategyOne strategyOne = new StrategyOne();
        strategyOne.runStrategy(inputLoader.getPhotos());
    }
}
