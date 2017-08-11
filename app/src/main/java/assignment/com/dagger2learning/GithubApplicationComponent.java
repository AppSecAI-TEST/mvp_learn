package assignment.com.dagger2learning;

import com.squareup.picasso.Picasso;

import net.GithubService;

import dagger.Component;

/**
 * Created by anudeep on 09/08/17.
 */
@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class, ActivityModule.class})
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGitHubServicce();
}
