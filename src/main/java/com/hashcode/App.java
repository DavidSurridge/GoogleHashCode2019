package com.hashcode;

import com.hashcode.model.SlideShow;
import com.hashcode.service.ExportSolution;
import com.hashcode.service.InputLoader;
import com.hashcode.service.ScoreCalculator;
import com.hashcode.strategies.ExampleSolution;
import com.hashcode.strategies.StrategyOne;

public class App {

    public static void main(String[] args) {
        final InputLoader inputLoader = new InputLoader();
        final StrategyOne strategyOne = new StrategyOne();
        final ExampleSolution exampleSolution = new ExampleSolution();
        final SlideShow slideShow = strategyOne.runStrategy(inputLoader.getPhotos());
        final Long slideShowScore = ScoreCalculator.getSlideShowScore(slideShow);
        ExportSolution.export(slideShow , "D");
    //    System.out.println(slideShowScore);
    }
}
