package com.kbaldauf.playerfinder.presenter;

import com.kbaldauf.playerfinder.data.DataManager;
import com.kbaldauf.playerfinder.model.Team;
import com.kbaldauf.playerfinder.view.TeamView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import rx.Single;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TeamPresenterTest {

    @Mock
    DataManager mockDataManager;
    @Mock
    TeamView mockTeamView;

    private List<Team> teams = new ArrayList<>();
    private TeamPresenter presenter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() {
        presenter = new TeamPresenter(mockDataManager);
    }

    @Test
    public void testDetachView() {
        assertFalse(presenter.isViewAttached());
        assertNull(presenter.getView());

        when(mockDataManager.getTeams()).thenReturn(Single.just(teams));
        presenter.attachView(mockTeamView);

        assertTrue(presenter.isViewAttached());
        assertNotNull(presenter.getView());

        presenter.detachView();

        assertFalse(presenter.isViewAttached());
        assertNull(presenter.getView());
    }

    @Test
    public void testHideLoadingSpinner() {
        when(mockDataManager.getTeams()).thenReturn(Single.just(teams));
        presenter.attachView(mockTeamView);

        verify(mockDataManager).getTeams();
        verify(mockTeamView).hideLoadingSpinner(teams);
    }

    @Test
    public void testShowErrorMessage() {
        when(mockDataManager.getTeams()).thenReturn(Single.<List<Team>>error(new Throwable()));
        presenter.attachView(mockTeamView);

        verify(mockDataManager).getTeams();
        verify(mockTeamView).showErrorMessage();
    }
}
