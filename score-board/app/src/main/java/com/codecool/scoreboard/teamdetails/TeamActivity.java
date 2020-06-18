package com.codecool.scoreboard.teamdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.model.Team;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamActivity extends AppCompatActivity implements TeamContract.View {

    private TeamContract.Presenter presenter;

    @BindView(R.id.error_page)
    ConstraintLayout errorPage;
    @BindView(R.id.team_header)
    ConstraintLayout teamHeader;
    @BindView(R.id.team_details)
    ConstraintLayout teamDetails;
    @BindView(R.id.stadium_details)
    ConstraintLayout stadiumDetails;
    @BindView(R.id.error_message)
    TextView errorText;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.stadium_image)
    ImageView stadiumImage;
    @BindView(R.id.team_name)
    TextView teamName;
    @BindView(R.id.alt_name)
    TextView altName;
    @BindView(R.id.founded)
    TextView founded;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.leagues)
    TextView leagues;
    @BindView(R.id.team_desc)
    TextView teamDesc;
    @BindView(R.id.stadium_desc)
    TextView stadiumDesc;
    @BindView(R.id.stadium_name)
    TextView stadiumName;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.website)
    Button website;
    @BindView(R.id.video)
    Button youtube;

    ScrollView layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        presenter = new TeamPresenter(this);
        presenter.onAttach();

        ButterKnife.bind(this);

        String id = getIntent().getStringExtra("id");
        presenter.getTeamById(id);
        layout = findViewById(R.id.teamDetailsLayout);
    }

    @Override
    public void showTeam(Team team) {

        Picasso.get()
                .load(team.getTeamLogo())
                .error(R.drawable.default_img)
                .fit()
                .into(logo);

        teamName.setText(team.getTeamName());
        altName.setText(team.getAlternateNames());
        founded.setText(team.getFormedYear());
        category.setText(team.getSportCategory());
        leagues.setText(team.getLeague());
        teamDesc.setText(team.getDescription());

        Picasso.get()
                .load(team.getStadiumImage())
                .error(R.drawable.default_img)
                .fit()
                .into(stadiumImage);

        stadiumName.setText(team.getStadiumName());
        location.setText(team.getStadiumLocation());
        stadiumDesc.setText(team.getStadiumDesc());

        teamHeader.setVisibility(View.VISIBLE);
        teamDetails.setVisibility(View.VISIBLE);
        stadiumDetails.setVisibility(View.VISIBLE);
        setBackground(team.getTeamName());

    }

    private void setBackground(String teamName) {
        if (teamName.equals("Wolves")) {
            layout.setBackgroundResource(R.drawable.orange_gradient_background);
        } else if (teamName.equals("Liverpool")
                || teamName.equals("Norwich")) {
            layout.setBackgroundResource(R.drawable.green_gradient_background);
        } else if (teamName.equals("Arsenal")
                || teamName.equals("Sheffield United")
                || teamName.equals("West Ham")
                || teamName.equals("Watford")
                || teamName.equals("Southampton")
                || teamName.equals("Bournemouth")
                || teamName.equals("Man United")) {
            layout.setBackgroundResource(R.drawable.red_gradient_background);
        } else if (teamName.equals("Man City")
                || teamName.equals("Chelsea")
                || teamName.equals("Tottenham")
                || teamName.equals("Aston Villa")
                || teamName.equals("Brighton")
                || teamName.equals("Crystal Palace")
                || teamName.equals("Leicester")
                || teamName.equals("Newcastle")
                || teamName.equals("Everton")) {
            layout.setBackgroundResource(R.drawable.blue_gradient_background);
        } else if (teamName.equals("Burnley")) {
            layout.setBackgroundResource(R.drawable.yellow_gradient_background);
        }
    }

    @Override
    public void showEmptyTeamData() {
        errorText.setText(R.string.empty_data_user_msg);
        errorPage.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        errorText.setText(errorMessage);
        errorPage.setVisibility(View.VISIBLE);
    }

    @Override
    public void setPresenter(TeamContract.Presenter presenter) {
        this.presenter = presenter;
    }
}