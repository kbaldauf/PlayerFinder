package com.kbaldauf.playerfinder.presenter;

import com.kbaldauf.playerfinder.data.DataManager;
import com.kbaldauf.playerfinder.model.Player;
import com.kbaldauf.playerfinder.view.RosterView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import rx.Single;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RosterPresenterTest {

    @Mock
    DataManager mockDataManager;
    @Mock
    RosterView mockRosterView;

    private List<Player> players = new ArrayList<>();
    private RosterPresenter presenter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() {
        presenter = new RosterPresenter(mockDataManager);
    }

    @Test
    public void testDetachView() {
        assertFalse(presenter.isViewAttached());
        assertNull(presenter.getView());

        presenter.attachView(mockRosterView);

        assertTrue(presenter.isViewAttached());
        assertNotNull(presenter.getView());

        presenter.detachView();

        assertFalse(presenter.isViewAttached());
        assertNull(presenter.getView());
    }

    @Test
    public void testLoadRosterSuccess() {
        when(mockDataManager.getPlayers(anyString())).thenReturn(Single.just(players));
        presenter.attachView(mockRosterView);
        presenter.loadRoster(anyString());

        verify(mockDataManager).getPlayers(anyString());
        verify(mockRosterView).hideLoadingSpinner();
    }

    @Test
    public void testLoadRosterFailure() {
        when(mockDataManager.getPlayers(anyString())).thenReturn(Single.<List<Player>>error(new Throwable()));
        presenter.attachView(mockRosterView);
        presenter.loadRoster(anyString());

        verify(mockDataManager).getPlayers(anyString());
        verify(mockRosterView).showErrorMessage();
    }
}
