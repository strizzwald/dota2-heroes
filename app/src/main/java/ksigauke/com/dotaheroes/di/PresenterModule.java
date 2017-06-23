package ksigauke.com.dotaheroes.di;


import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import ksigauke.com.dotaheroes.herolist.HeroesContract;
import ksigauke.com.dotaheroes.herolist.HeroesPresenter;
import ksigauke.com.dotaheroes.repository.HeroRepository;

@Module
class PresenterModule {

    @Provides
    @Singleton
    HeroesContract.Presenter provideHeroesPresenter(HeroRepository heroRepository, @Named("io") Scheduler io, @Named("main") Scheduler main) {
        return new HeroesPresenter(heroRepository, io, main);
    }

}
