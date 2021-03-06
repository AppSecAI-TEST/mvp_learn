package assignment.com.dagger2learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.GithubService;
import net.dto.GithubRepo;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView recyclerView;
    Call<List<GithubRepo>> allRepos;

    @Inject
    ReposAdapter reposAdapter;
    @Inject
    GithubService githubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DaggerApplication application = (DaggerApplication) getApplication();
        final HomeActivityComponent homeActivityComponent = DaggerHomeActivityComponent.builder()
                .githubApplicationComponent(application.githubApplicationComponent())
                .build();
        homeActivityComponent.injectHomeActivity(this);

        allRepos = githubService.getAllRepos();

        allRepos.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                reposAdapter.setData(response.body());
                recyclerView.setAdapter(reposAdapter);

            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {

            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (allRepos != null) {
            allRepos.cancel();
        }
    }
}
