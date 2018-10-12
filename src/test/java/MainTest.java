import org.junit.Test;
import raylib.*;

public class MainTest {
	/*** runMain
	 * Open and close a window just to be sure that our library is sane.
	 */
	@Test
	public void runMain() {
		Raylib.InitWindow(640, 480, "Test");
		Raylib.CloseWindow();
	}

	@Test
	public void drawBox() {
		
	}
}
