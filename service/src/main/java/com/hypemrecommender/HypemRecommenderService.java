package com.hypemrecommender;

import com.hypemrecommender.dao.MongoRatingDao;
import com.hypemrecommender.resources.RatingResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: @karangb
 * Date: 04/09/2013
 * Time: 22:51
 */
public class HypemRecommenderService extends Service<HypemRecommenderConfiguration> {

    public static void main(String[] args) throws Exception {
        new HypemRecommenderService().run(args);
    }

    @Override
    public void initialize(Bootstrap<HypemRecommenderConfiguration> bootstrap) {
        bootstrap.setName("hypem-recommender");
    }

    @Override
    public void run(HypemRecommenderConfiguration hypemRecommenderConfiguration, Environment environment) throws Exception {
        environment.addResource(new RatingResource(new MongoRatingDao()));
    }
}
