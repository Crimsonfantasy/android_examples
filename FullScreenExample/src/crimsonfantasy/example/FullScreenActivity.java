package crimsonfantasy.example;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

@SuppressLint("InlinedApi")
public class FullScreenActivity extends Activity {

	private String TAG = "actionBar";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	// This snippet hides the system bars.
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@SuppressLint("InlinedApi")
	
	/** toggle on /off IMMERSIVE screen.(full screen)
	 * 
	 */
	private void toggleSystemUI() {

		int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
		int newUiOptions = uiOptions;
		newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

		// Navigation bar hiding: Backwards compatible to ICS.
		if (Build.VERSION.SDK_INT >= 14) {
			newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
		}

		// Status bar hiding: Backwards compatible to Jellybean
		if (Build.VERSION.SDK_INT >= 16) {
			newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
		}

		// Immersive mode: Backward compatible to KitKat.
		// Note that this flag doesn't do anything by itself, it only augments
		// the behavior
		// of HIDE_NAVIGATION and FLAG_FULLSCREEN. For the purposes of this
		// sample
		// all three flags are being toggled together.
		// Note that there are two immersive mode UI flags, one of which is
		// referred to as "sticky".
		// Sticky immersive mode differs in that it makes the navigation and
		// status bars
		// semi-transparent, and the UI flag does not get cleared when the user
		// interacts with
		// the screen.
		if (Build.VERSION.SDK_INT >= 18) {
			newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
		}

		getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
		// END_INCLUDE (set_ui_flags)

	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@SuppressLint("InlinedApi")
	
// This snippet shows the system bars. It does this by removing all the flags
// except for the ones that make the content appear under the system bars.

	private void showStuffUnderSystemBar() {

		View decroView = getWindow().getDecorView();
	

		decroView.setSystemUiVisibility(  View.SYSTEM_UI_FLAG_LAYOUT_STABLE
	            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
	            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			toggleSystemUI();
		}

	}
}
