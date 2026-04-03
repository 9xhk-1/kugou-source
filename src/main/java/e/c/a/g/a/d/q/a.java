package e.c.a.g.a.d.q;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class a extends MediaSessionCompat.Callback {
    public static final String a = "a";

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        super.onAddQueueItem(mediaDescriptionCompat);
        if (g0.a) {
            g0.b(a, "onAddQueueItem: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        super.onCommand(str, bundle, resultReceiver);
        if (g0.a) {
            g0.b(a, "onCommand: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCustomAction(String str, Bundle bundle) {
        super.onCustomAction(str, bundle);
        if (g0.a) {
            g0.b(a, "onCustomAction: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onFastForward() {
        super.onFastForward();
        if (g0.a) {
            g0.b(a, "onFastForward: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public boolean onMediaButtonEvent(Intent intent) {
        if (g0.a) {
            g0.b(a, "onMediaButtonEvent: ");
        }
        return super.onMediaButtonEvent(intent);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPause() {
        super.onPause();
        if (g0.a) {
            g0.b(a, "onPause: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlay() {
        super.onPlay();
        if (g0.a) {
            g0.b(a, "onPlay: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromMediaId(String str, Bundle bundle) {
        super.onPlayFromMediaId(str, bundle);
        if (g0.a) {
            g0.b(a, "onPlayFromMediaId: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromSearch(String str, Bundle bundle) {
        super.onPlayFromSearch(str, bundle);
        if (g0.a) {
            g0.b(a, "onPlayFromSearch: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromUri(Uri uri, Bundle bundle) {
        super.onPlayFromUri(uri, bundle);
        if (g0.a) {
            g0.b(a, "onPlayFromUri: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepare() {
        super.onPrepare();
        if (g0.a) {
            g0.b(a, "onPrepare: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromMediaId(String str, Bundle bundle) {
        super.onPrepareFromMediaId(str, bundle);
        if (g0.a) {
            g0.b(a, "onPrepareFromMediaId: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromSearch(String str, Bundle bundle) {
        super.onPrepareFromSearch(str, bundle);
        if (g0.a) {
            g0.b(a, "onPrepareFromSearch: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        super.onPrepareFromUri(uri, bundle);
        if (g0.a) {
            g0.b(a, "onPrepareFromUri: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        super.onRemoveQueueItem(mediaDescriptionCompat);
        if (g0.a) {
            g0.b(a, "onRemoveQueueItem: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItemAt(int i2) {
        super.onRemoveQueueItemAt(i2);
        if (g0.a) {
            g0.b(a, "onRemoveQueueItemAt: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRewind() {
        super.onRewind();
        if (g0.a) {
            g0.b(a, "onRewind: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSeekTo(long j) {
        super.onSeekTo(j);
        if (g0.a) {
            g0.b(a, "onSeekTo: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetCaptioningEnabled(boolean z) {
        super.onSetCaptioningEnabled(z);
        if (g0.a) {
            g0.b(a, "onSetCaptioningEnabled: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetPlaybackSpeed(float f2) {
        super.onSetPlaybackSpeed(f2);
        if (g0.a) {
            g0.b(a, "onSetPlaybackSpeed: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat) {
        super.onSetRating(ratingCompat);
        if (g0.a) {
            g0.b(a, "onSetRating: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRepeatMode(int i2) {
        super.onSetRepeatMode(i2);
        if (g0.a) {
            g0.b(a, "onSetRepeatMode: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetShuffleMode(int i2) {
        super.onSetShuffleMode(i2);
        if (g0.a) {
            g0.b(a, "onSetShuffleMode: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToNext() {
        super.onSkipToNext();
        if (g0.a) {
            g0.b(a, "onSkipToNext: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToPrevious() {
        super.onSkipToPrevious();
        if (g0.a) {
            g0.b(a, "onSkipToPrevious: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToQueueItem(long j) {
        super.onSkipToQueueItem(j);
        if (g0.a) {
            g0.b(a, "onSkipToQueueItem: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onStop() {
        super.onStop();
        if (g0.a) {
            g0.b(a, "onStop: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        super.onAddQueueItem(mediaDescriptionCompat, i2);
        if (g0.a) {
            g0.b(a, "onAddQueueItem: ");
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        super.onSetRating(ratingCompat, bundle);
        if (g0.a) {
            g0.b(a, "onSetRating: ");
        }
    }
}
