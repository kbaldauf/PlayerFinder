package com.kbaldauf.playerfinder.util;

import com.kbaldauf.playerfinder.model.Team;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ModelUtilTest {

    @Mock
    Team mockTeam;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testBuildTeamName() {
        when(mockTeam.getName()).thenReturn("Name");
        when(mockTeam.getNickname()).thenReturn("Nickname");

        assertEquals("Name Nickname", ModelUtil.getBuiltTeamName(mockTeam));
    }

    @Test
    public void testConvertColorCodeToHex() {
        String hexColor = ModelUtil.convertColorCodeToHex("000000");

        assertEquals(7, hexColor.length());
        assertEquals("#000000", hexColor);
    }
}
