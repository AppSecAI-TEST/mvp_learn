package assignment.com.dagger2learning;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anudeep on 09/08/17.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @ApplicationContext
    public Context context() {
        return context;
    }
}
