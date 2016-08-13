package com.kbaldauf.playerfinder.util;

import android.content.Intent;

import com.kbaldauf.playerfinder.activity.RosterActivity;

import pocketknife.IntentBuilder;

public interface ActivityIntentUtil {
    @IntentBuilder(cls = RosterActivity.class)
    Intent getRosterActivityIntent(String teamSlug);
}
