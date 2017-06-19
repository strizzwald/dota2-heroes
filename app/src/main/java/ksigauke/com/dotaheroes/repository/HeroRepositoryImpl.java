package ksigauke.com.dotaheroes.repository;

import java.util.List;

import io.reactivex.Observable;
import ksigauke.com.dotaheroes.Constants;
import ksigauke.com.dotaheroes.domain.Hero;
import ksigauke.com.dotaheroes.network.OpenDotaApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroRepositoryImpl implements HeroRepository {
    private OpenDotaApi openDotaApi;
    private Retrofit retrofit;

    @Override
    public Observable<List<Hero>> getAllHeroes() {

        retrofit = new Retrofit.Builder().baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        openDotaApi = retrofit.create(OpenDotaApi.class);

        return openDotaApi.getAllHeroes();
    }
}
