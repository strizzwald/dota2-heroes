package ksigauke.com.dotaheroes;

import android.app.Application;

import ksigauke.com.dotaheroes.di.AppComponent;
import ksigauke.com.dotaheroes.di.AppModule;
import ksigauke.com.dotaheroes.di.DaggerAppComponent;

public class DotaHeroesApplication extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);

    }

    protected AppComponent initDagger(DotaHeroesApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}
