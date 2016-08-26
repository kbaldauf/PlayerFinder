package com.kbaldauf.playerfinder.adapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.kbaldauf.playerfinder.R;
import com.kbaldauf.playerfinder.model.Team;
import com.kbaldauf.playerfinder.util.ModelUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private Context context;
    private List<Team> teams;
    private RadioButton selectedButton;
    private int selectedPosition;

    public TeamAdapter(Context context) {
        this.context = context;
        teams = new ArrayList<>();
        selectedPosition = 0;
    }

    public void setData(List<Team> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    public Team getSelectedTeam() {
        Team team = null;
        if (teams != null && selectedPosition < teams.size()) {
            team = teams.get(selectedPosition);
        }
        return team;
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

        // set team name
        holder.name.setText(ModelUtil.getBuiltTeamName(team));

        // set team color square
        if (team.getColors().size() > 1) { // for teams that offer more than one color, combine them as a gradient
            Drawable gradient = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ModelUtil.getParsedColorList(team.getColors()));
            holder.logo.setBackground(gradient);
        } else { // for teams with only one color, display them as a solid colored square
            holder.logo.setBackgroundColor(ModelUtil.getParsedColor(team.getColor()));
        }

        // ensure that radio button is properly checked or unchecked
        if (selectedPosition != position) {
            holder.radioButton.setChecked(false);
        } else {
            holder.radioButton.setChecked(true);
            selectedButton = holder.radioButton;
        }
    }

    protected class TeamViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name) TextView name;
        @BindView(R.id.color_palette) ImageView logo;
        @BindView(R.id.radio_button) RadioButton radioButton;

        private TeamViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            // disable click events for the radio button in order to
            // force it to use the TeamViewHolder's onClick listener
            radioButton.setClickable(false);
        }

        @OnClick(R.id.team_view_container)
        void onClick(View v) {
            if (selectedPosition != getAdapterPosition() && selectedButton != null) {
                selectedButton.setChecked(false);
            }
            radioButton.setChecked(true);
            selectedPosition = getAdapterPosition();
            selectedButton = radioButton;
        }
    }
}
