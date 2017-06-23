package ksigauke.com.dotaheroes.di;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ksigauke.com.dotaheroes.Constants;
import ksigauke.com.dotaheroes.network.OpenDotaApi;
import ksigauke.com.dotaheroes.repository.HeroRepository;
import ksigauke.com.dotaheroes.repository.HeroRepositoryImpl;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class RepositoryModule {

    private static final String NAME_BASE_URL = "NAME_BASE_URL";

    @Provides
    @Named(NAME_BASE_URL)
    String provideBaseUrl() {
        return Constants.API_BASE_URL;
    }

    @Provides
    @Singleton
    HeroRepository provideHeroRepository(OpenDotaApi openDotaApi) {
        return new HeroRepositoryImpl(openDotaApi);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter, CallAdapter.Factory rxAdapter, @Named(NAME_BASE_URL) String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .addCallAdapterFactory(rxAdapter)
                .build();
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    CallAdapter.Factory provideRxAdapter() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    OpenDotaApi provideDotaApi(Retrofit retrofit) {
        return retrofit.create(OpenDotaApi.class);
    }
}
