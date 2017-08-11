package assignment.com.dagger2learning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import net.dto.GithubRepo;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by anudeep on 31/07/17.
 */

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.fullDate();


    private List<GithubRepo> githubRepoList = new ArrayList<>();
    private final Picasso picasso;

    @Inject
    public ReposAdapter(Picasso picasso) {

        this.picasso = picasso;
    }


    public void setData(List<GithubRepo> githubRepoList) {
        this.githubRepoList = githubRepoList;

    }

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_repo, parent, false);
        ReposViewHolder reposViewHolder = new ReposViewHolder(view);
        return reposViewHolder;
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {
        Locale locale = holder.itemView.getResources().getConfiguration().locale;

        GithubRepo githubRepo = githubRepoList.get(position);
        holder.repoName.setText(githubRepoList.get(position).fullName);
        holder.description.setVisibility(TextUtils.isEmpty(githubRepo.description) ? GONE : VISIBLE);
        holder.description.setText(githubRepo.description);

        holder.stars.setText(String.format(locale, "%d", githubRepo.stargazersCount));
        holder.repoIssues.setText(String.format(locale, "%d", githubRepo.openIssuesCount));
        holder.forks.setText(String.format(locale, "%d", githubRepo.forksCount));

        holder.updatedAt.setText(holder.itemView.getResources()
                .getString(R.string.last_pushed, DATE_TIME_FORMATTER.print(githubRepo.updatedAt)));
        Context context = holder.itemView.getContext();
        picasso.load(githubRepo.owner.avatarUrl).into(holder.avatarImage);
    }

    @Override
    public int getItemCount() {
        return githubRepoList.size();
    }

    public static class ReposViewHolder extends ViewHolder {

        TextView repoName;
        TextView description;
        TextView stars;
        TextView repoIssues;
        TextView updatedAt;
        TextView forks;
        ImageView avatarImage;

        public ReposViewHolder(View itemView) {
            super(itemView);
            repoName = itemView.findViewById(R.id.repo_name);
            description = itemView.findViewById(R.id.repo_description);
            stars = itemView.findViewById(R.id.repo_stars);
            repoIssues = itemView.findViewById(R.id.repo_issues);
            updatedAt = itemView.findViewById(R.id.repo_updated_at);
            forks = itemView.findViewById(R.id.repo_forks);
            avatarImage = itemView.findViewById(R.id.user_avatar);
        }
    }


}
