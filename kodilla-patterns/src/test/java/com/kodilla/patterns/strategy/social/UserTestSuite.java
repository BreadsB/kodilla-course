package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    String MARKUS = "Markus Timoty";
    String SIMON = "Simon Greedy";
    String TOM = "Tom Jerry";

    @Test
    void testDefaultPublisher() {
        User mark = new Millenials(MARKUS);
        User simon = new YGeneration(SIMON);
        User tom = new ZGeneration(TOM);

        String markPost = mark.post();
        String simonPost = simon.post();
        String tomPost = tom.post();

        Assertions.assertEquals("Markus Timoty shared new post on Facebook!", markPost);
        Assertions.assertEquals("Simon Greedy shared a new post on Twitter!", simonPost);
        Assertions.assertEquals("Tom Jerry shared a new post on Snapchat!", tomPost);
    }

    @Test
    void testOverwritingPublisher() {
        User mark = new Millenials(MARKUS);
        String markPost = mark.post();
        mark.setFavouritePublisher(new TwitterPublisher());
        String markPostOnNewPublisher = mark.post();

        Assertions.assertEquals("Markus Timoty shared new post on Facebook!" ,markPost);
        Assertions.assertEquals("Markus Timoty shared a new post on Twitter!" ,markPostOnNewPublisher);
    }
}
