package ksigauke.com.dotaheroes.repository;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import ksigauke.com.dotaheroes.DotaHeroesApplication;
import ksigauke.com.dotaheroes.domain.Hero;
import ksigauke.com.dotaheroes.network.OpenDotaApi;

public class HeroRepositoryImpl implements HeroRepository {

    @Inject
    OpenDotaApi openDotaApi;

    public HeroRepositoryImpl(OpenDotaApi openDotaApi) {
        this.openDotaApi = openDotaApi;
    }

    @Override
    public Observable<List<Hero>> getAllHeroes() {
        return openDotaApi.getAllHeroes();
    }
}
