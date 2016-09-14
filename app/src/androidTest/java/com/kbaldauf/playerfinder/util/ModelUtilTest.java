package com.kbaldauf.playerfinder.util;

import android.graphics.Color;
import android.support.test.runner.AndroidJUnit4;

import com.kbaldauf.playerfinder.model.Team;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class ModelUtilTest {

    @Test
    public void testBuildTeamName() {
        Team mockTeam = mock(Team.class);
        when(mockTeam.getName()).thenReturn("Name");
        when(mockTeam.getNickname()).thenReturn("Nickname");

        Assert.assertEquals("Name Nickname", ModelUtil.getBuiltTeamName(mockTeam));
    }

    @Test
    public void testParseColor() {
        int parsedColor = ModelUtil.getParsedColor("000000");

        assertEquals(Color.BLACK, parsedColor);
    }

    @Test
    public void testParseColorList() {
        int[] parsedColors = ModelUtil.getParsedColorList(Arrays.asList("000000", "FFFFFF"));

        assertEquals(2, parsedColors.length);
        assertEquals(Color.BLACK, parsedColors[0]);
        assertEquals(Color.WHITE, parsedColors[1]);
    }
}
