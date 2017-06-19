package ksigauke.com.dotaheroes.di;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ksigauke.com.dotaheroes.herolist.HeroesContract;
import ksigauke.com.dotaheroes.herolist.HeroesPresenter;

@Module
class PresenterModule {

    @Provides
    @Singleton
    HeroesContract.Presenter provideHeroesPresenter(Context context) {
        return new HeroesPresenter(context);
    }

}
