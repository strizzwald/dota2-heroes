package ksigauke.com.dotaheroes.di;

import javax.inject.Singleton;

import dagger.Component;
import ksigauke.com.dotaheroes.herolist.HeroesFragment;
import ksigauke.com.dotaheroes.herolist.HeroesPresenter;
import ksigauke.com.dotaheroes.repository.HeroRepositoryImpl;

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, RepositoryModule.class, SchedulerModule.class})
public interface AppComponent {

    void inject(HeroesPresenter target);

    void inject(HeroRepositoryImpl target);

    void inject(HeroesFragment target);

}
