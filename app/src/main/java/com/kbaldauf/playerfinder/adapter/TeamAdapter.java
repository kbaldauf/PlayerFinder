package com.kbaldauf.playerfinder.adapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kbaldauf.playerfinder.R;
import com.kbaldauf.playerfinder.model.Team;
import com.kbaldauf.playerfinder.util.ModelUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private Context context;
    private List<Team> teams;

    public TeamAdapter(Context context) {
        this.context = context;
        teams = new ArrayList<>();
    }

    public void setData(List<Team> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(context).inflate(R.layout.team_view, parent, false);
        return new TeamViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.name.setText(ModelUtil.getBuiltTeamName(team));
        if (team.getColors().size() > 1) {
            Drawable gradient = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ModelUtil.getParsedColorList(team.getColors()));
            holder.logo.setBackground(gradient);
        } else {
            holder.logo.setBackgroundColor(ModelUtil.getParsedColor(team.getColor()));
        }
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name) TextView name;
        @BindView(R.id.logo) ImageView logo;

        public TeamViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
