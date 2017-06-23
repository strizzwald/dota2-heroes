package ksigauke.com.dotaheroes.di;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class SchedulerModule {

    @Singleton
    @Provides
    @Named("main")
    Scheduler mainScheduler(){
        return AndroidSchedulers.mainThread();
    }

    @Singleton
    @Provides
    @Named("io")
    Scheduler ioScheduler(){
        return Schedulers.io();
    }

}
