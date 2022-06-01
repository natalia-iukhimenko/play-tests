package ru.iukhimenko.play.core;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({"classpath:configuration.properties"})
public interface ProjectConfiguration extends Config {
    ProjectConfiguration CONFIGURATION = ConfigFactory.create(ProjectConfiguration.class, System.getProperties());

    String baseUrl();
}
