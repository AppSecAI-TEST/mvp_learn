package assignment.com.dagger2learning;

import com.google.gson.Gson;

import net.GithubService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anudeep on 09/08/17.
 */

@Module(includes = NetworkModule.class)
public class GithubServiceModule {

    @Provides
    @GithubApplicationScope
    public GithubService githubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);

    }

    @Provides
    @GithubApplicationScope
    public Gson gson() {
        return new Gson();
    }


    @Provides
    @GithubApplicationScope
    public Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();
        return retrofit;
    }
}
