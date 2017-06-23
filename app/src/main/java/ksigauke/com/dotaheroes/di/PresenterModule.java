package ksigauke.com.dotaheroes.di;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ksigauke.com.dotaheroes.herolist.HeroesContract;
import ksigauke.com.dotaheroes.herolist.HeroesPresenter;
import ksigauke.com.dotaheroes.repository.HeroRepository;

@Module
class PresenterModule {

    @Provides
    @Singleton
    HeroesContract.Presenter provideHeroesPresenter(HeroRepository heroRepository) {
        return new HeroesPresenter(heroRepository);
    }

}
