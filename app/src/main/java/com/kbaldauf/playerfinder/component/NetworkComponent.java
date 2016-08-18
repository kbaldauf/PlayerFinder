package com.kbaldauf.playerfinder.component;

import com.kbaldauf.playerfinder.module.NetworkModule;
import com.kbaldauf.playerfinder.network.StattleshipClient;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class, modules = NetworkModule.class)
public interface NetworkComponent {
    StattleshipClient exposeClient();
}