package assignment.com.dagger2learning;

import net.GithubService;

import dagger.Component;

/**
 * Created by anudeep on 09/08/17.
 */
@HomeActivityScope
@Component(modules = HomeActivityModule.class,dependencies = GithubApplicationComponent.class)
public interface HomeActivityComponent {


//    ReposAdapter reposAdapter();
//
//    GithubService githubService();


    void injectHomeActivity (MainActivity mainActivity);
}
