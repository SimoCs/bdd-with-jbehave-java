package com.pluralsight.bddjbehave.selenium;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.List;

public class PluralsightWebsiteStoryRunner extends JUnitStories {

    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
                List.of("**/pluralsight_website.story"), null);
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new PluralsightWebsiteSteps());
    }

}