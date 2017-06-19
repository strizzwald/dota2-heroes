package ksigauke.com.dotaheroes.herolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import ksigauke.com.dotaheroes.R;
import ksigauke.com.dotaheroes.domain.Hero;
import ksigauke.com.dotaheroes.repository.HeroRepositoryImpl;

public class HeroesFragment extends Fragment implements HeroesContract.View {

    private HeroesPresenter heroesPresenter = new HeroesPresenter(new HeroRepositoryImpl(), this);
    private HeroesAdapter heroesAdapter;
    private ProgressBar heroesProgressBar;

    public HeroesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        heroesAdapter = new HeroesAdapter(new ArrayList<Hero>(0));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_heroes, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.rv_heroes_list);
        heroesProgressBar = (ProgressBar) root.findViewById(R.id.heroesProgressBar);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setAdapter(heroesAdapter);
        recyclerView.setLayoutManager(layoutManager);
        heroesPresenter.getAllHeroes();
        return root;
    }

    @Override
    public void showLoadingBar() {
        heroesProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayHeroes(List<Hero> heroes) {
        heroesAdapter.setHeroes(heroes);
    }

    @Override
    public void hideLoadingBar() {
        heroesProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(getView(), errorMessage, Snackbar.LENGTH_LONG)
                .show();
    }
}
