package com.probaldas.nycSchools.di;

import com.probaldas.nycSchools.NYCApplication;
import com.probaldas.nycSchools.repositories.ApiDataSourceFactory;
import com.probaldas.nycSchools.ui.details.SchoolDetailsViewModel;
import com.probaldas.nycSchools.ui.school.SchoolListViewModel;
import com.probaldas.nycSchools.ui.school.adapter.SchoolViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(NYCApplication application);

    void inject(ApiDataSourceFactory apiDataSourceFactory);

    void inject(SchoolListViewModel schoolListViewModel);

    void inject(SchoolViewModel schoolViewModel);

    void inject(SchoolDetailsViewModel schoolDetailsViewModel);

}
