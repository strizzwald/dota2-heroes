package ksigauke.com.dotaheroes;

        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import ksigauke.com.dotaheroes.herolist.HeroesFragment;

public class HeroListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_list);
        FragmentManager fm  = getSupportFragmentManager();

        if(fm.findFragmentById(R.id.content_main) == null){
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(R.id.content_main,new HeroesFragment());
            transaction.commit();
        }

    }
}
