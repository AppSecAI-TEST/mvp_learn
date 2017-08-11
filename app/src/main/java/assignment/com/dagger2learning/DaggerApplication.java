package assignment.com.dagger2learning;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by anudeep on 30/07/17.
 */

public class DaggerApplication extends Application {


    GithubApplicationComponent githubApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        githubApplicationComponent = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

//        GithubService githubService2 = githubApplicationComponent.getGitHubServicce();
//        Picasso picasso2 = githubApplicationComponent.getPicasso();
//
//        GithubService githubService3 = githubApplicationComponent.getGitHubServicce();
//        Picasso picasso3 = githubApplicationComponent.getPicasso();
//
//        GithubService githubService4 = githubApplicationComponent.getGitHubServicce();
//        Picasso picasso4 = githubApplicationComponent.getPicasso();
//
//        GithubService githubService5 = githubApplicationComponent.getGitHubServicce();
//        Picasso picasso5 = githubApplicationComponent.getPicasso();
//
//
//        Log.i("Dagger 2", "githubService" + githubService);
//        Log.i("Picasso 2", "picasso " + picasso);
//
//
//        Log.i("Dagger 2", "githubService2" + githubService2);
//        Log.i("Picasso 2", "picasso2 " + picasso2);
//
//
//        Log.i("Dagger 2", "githubService3" + githubService3);
//        Log.i("Picasso 2", "picasso3 " + picasso3);
//
//        Log.i("Dagger 2", "githubService4" + githubService4);
//        Log.i("Picasso 2", "picasso4 " + picasso4);
//
//        Log.i("Dagger 2", "githubService5" + githubService);
//        Log.i("Picasso 2", "picasso5 " + picasso5);


        /*
        08-09 17:59:08.765 11082-11082/assignment.com.dagger2learning I/Dagger 2: githubServiceretrofit2.Retrofit$1@cc8092b
08-09 17:59:08.766 11082-11082/assignment.com.dagger2learning I/Dagger 2: githubService2retrofit2.Retrofit$1@aa1b721
08-09 17:59:08.766 11082-11082/assignment.com.dagger2learning I/Dagger 2: githubService3retrofit2.Retrofit$1@d3c0d07
08-09 17:59:08.766 11082-11082/assignment.com.dagger2learning I/Dagger 2: githubService4retrofit2.Retrofit$1@dc1a45d
08-09 17:59:08.766 11082-11082/assignment.com.dagger2learning I/Dagger 2: githubService5retrofit2.Retrofit$1@cc8092b
         */

        /*
        08-09 17:59:08.765 11082-11082/assignment.com.dagger2learning I/Picasso 2: picasso com.squareup.picasso.Picasso@6393188
08-09 17:59:08.766 11082-11082/assignment.com.dagger2learning I/Picasso 2: picasso2 com.squareup.picasso.Picasso@12d3746
08-09 17:59:08.766 11082-11082/assignment.com.dagger2learning I/Picasso 2: picasso3 com.squareup.picasso.Picasso@8f3de34
08-09 17:59:08.766 11082-11082/assignment.com.dagger2learning I/Picasso 2: picasso4 com.squareup.picasso.Picasso@87581d2
08-09 17:59:08.766 11082-11082/assignment.com.dagger2learning I/Picasso 2: picasso5 com.squareup.picasso.Picasso@20272a3

         */

////Context group
//        Context context = this;
//
//        //Network
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                Timber.i(message);
//            }
//        });
//
//        File cache = new File(context.getCacheDir(), "cache_file");
//        cache.mkdirs();
//        Cache cache1 = new Cache(cache, 10 * 1000 * 1000);
//
//
//        //Picasso
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
//                .cache(cache1)
//                .build();
//
//        picasso = new Picasso.Builder(context)
//                .downloader(getOkHttp3Downloader())
//                .build();
//
//        //Client
//        Gson gson = new Gson();
//
//        retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(okHttpClient)
//                .baseUrl("https://api.github.com/")
//                .build();
    }


//    public OkHttp3Downloader getOkHttp3Downloader() {
//        return new OkHttp3Downloader(getApplicationContext());
//    }
//
//    public Retrofit getRetrofit() {
//        return retrofit;
//    }

    public GithubApplicationComponent githubApplicationComponent() {
        return githubApplicationComponent;
    }

}
