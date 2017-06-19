package ksigauke.com.dotaheroes.network;

import java.util.List;

import io.reactivex.Observable;
import ksigauke.com.dotaheroes.domain.Hero;
import retrofit2.http.GET;

public interface OpenDotaApi {

    @GET("/api/heroStats")
    Observable<List<Hero>> getAllHeroes();
}
