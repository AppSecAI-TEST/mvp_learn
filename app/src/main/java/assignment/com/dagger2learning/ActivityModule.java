package assignment.com.dagger2learning;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anudeep on 09/08/17.
 */

@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    @Named("activityContext")
    public Context context() {
        return context;
    }
}
