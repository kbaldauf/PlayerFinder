package com.kbaldauf.playerfinder.component;

import com.kbaldauf.playerfinder.data.DataManager;
import com.kbaldauf.playerfinder.module.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = NetworkComponent.class, modules = DataModule.class)
public interface DataComponent {
    DataManager exposeDataManager();
}
