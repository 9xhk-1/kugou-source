# Mock Card + Island Demo

This is a blank test app that recreates the core logic flow found in the reverse-engineered project:

- card-like provider + data provider split
- playback state broadcasts (`META_CHANGED`, `PLAY_STATE_CHANGED`)
- provider `call()` actions (`togglePlay`, `nextSong`, `prevSong`, `updateProgress`)
- foreground playback notification
- "island-like" hint notification (using `show_heytap_indicator` and `CATEGORY_NAVIGATION`)

## Location

Created under:

`result/mock_card_island_app`

## Main Components

- `MockPlayerController`: in-memory queue and state machine
- `MockCardDataProvider`: accepts card actions via `ContentResolver.call`
- `MockCardWidgetProvider`: exposes card snapshot data (JSON)
- `MockCardHostReceiver`: logs card refresh snapshots
- `MusicPlaybackService`: foreground service + periodic progress tick
- `NotificationHelper`: playback notification and island-like notification
- `MainActivity`: manual test panel
- `MusicCardAppWidgetProvider`: real Android home-screen music card widget
- `MediaSessionController`: media session metadata/state for system media surface

## Manual Test

1. Launch app.
2. Add widget to launcher desktop: `Mock Card Island` -> `Music Card`.
3. Use `Prev / Play-Pause / Next` in app or widget and observe widget sync.
4. Verify playback notification updates silently (no alert spam).
5. Click `Simulate Island Hint` to send one low-priority island-like hint notification.

## Notes

- This is a test scaffold, not a production card SDK integration.
- Card JSON (`app_mock_widget.json`) is included to mirror structure and actions.

## CI Build (GitHub Actions)

A workflow is added at:

`.github/workflows/build-mock-card-apk.yml`

It builds `result/mock_card_island_app` with:

- JDK 17
- Android SDK platform 34 + build-tools 34.0.0
- Gradle 8.9

Output artifact:

- `mock-card-debug-apk` (contains `app-debug.apk`)
