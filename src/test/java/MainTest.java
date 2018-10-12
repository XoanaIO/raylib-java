import org.junit.Test;
import raylib.*;

import static raylib.Raylib.*;

public class MainTest {
	/*** runMain
	 * Open and close a window just to be sure that our library is sane.
	 */
	@Test
	public void runMain() {
		InitWindow(640, 480, "Test");
		CloseWindow();
	}

	@Test
	public void pickingExample() {
		// Initialization
		//--------------------------------------------------------------------------------------
		int screenWidth = 800;
		int screenHeight = 450;

		InitWindow(screenWidth, screenHeight, "raylib [core] example - 3d picking");

		// Define the camera to look into our 3d world
		Camera3D camera = new Camera3D();
		camera.setPosition(new Vector3(10.0f, 10.0f, 10.0f)); // Camera position
		camera.setTarget(new Vector3(0.0f, 0.0f, 0.0f));      // Camera looking at point
		camera.setUp(new Vector3(0f, 1f, 0f));          // Camera up vector (rotation towards target)
		camera.setFovy(45.0f);                                // Camera field-of-view Y
		//camera.setType(CameraType.CAMERA_PERSPECTIVE);                   // Camera mode type
		camera.setType(0); // Perspective

		Vector3 cubePosition = new Vector3(0.0f, 1.0f, 0.0f);
		Vector3 cubeSize = new Vector3(2.0f, 2.0f, 2.0f);

		Ray ray = new Ray();        // Picking line ray

		boolean collision = false;

		//SetCameraMode(camera, CAMERA_FREE); // Set a free camera mode
		SetCameraMode(camera, 1);

		SetTargetFPS(60);                   // Set our game to run at 60 frames-per-second
		//--------------------------------------------------------------------------------------

		// Main game loop
		while (!WindowShouldClose())        // Detect window close button or ESC key
		{
			// Update
			//----------------------------------------------------------------------------------
			UpdateCamera(camera);          // Update camera

			if (IsMouseButtonPressed(MOUSE_LEFT_BUTTON))
			{
				ray = GetMouseRay(GetMousePosition(), camera);

				// Check collision between ray and box
				collision = CheckCollisionRayBox(ray,
						new BoundingBox(
							cubePosition.getX() - cubeSize.getX()/2, cubePosition.getY() - cubeSize.getY()/2, cubePosition.getZ() - cubeSize.getZ()/2,
							cubePosition.getX() + cubeSize.getX()/2, cubePosition.getY() + cubeSize.getY()/2, cubePosition.getZ() + cubeSize.getZ()/2
						)
				);
			}
			//----------------------------------------------------------------------------------

			// Draw
			//----------------------------------------------------------------------------------
			BeginDrawing();

			ClearBackground(new Color(255, 255, 255));

			BeginMode3D(camera);

			if (collision)
			{
				DrawCube(cubePosition, cubeSize.getX(), cubeSize.getY(), cubeSize.getZ(), new Color(255, 0, 0));
				DrawCubeWires(cubePosition, cubeSize.getX(), cubeSize.getY(), cubeSize.getZ(), new Color(200, 0, 50));

				DrawCubeWires(cubePosition, cubeSize.getX() + 0.2f, cubeSize.getY() + 0.2f, cubeSize.getZ() + 0.2f, new Color(0, 255, 0));
			}
			else
			{
				DrawCube(cubePosition, cubeSize.getX(), cubeSize.getY(), cubeSize.getZ(), new Color(128, 128, 128));
				DrawCubeWires(cubePosition, cubeSize.getX(), cubeSize.getY(), cubeSize.getZ(), new Color(50, 50, 50));
			}

			DrawRay(ray, new Color(200, 0, 50));
			DrawGrid(10, 1.0f);

			EndMode3D();

			DrawText("Try selecting the box with mouse!", 240, 10, 20, new Color(50, 50, 50));

			if(collision) DrawText("BOX SELECTED", (screenWidth - MeasureText("BOX SELECTED", 30)) / 2, (int)(screenHeight * 0.1f), 30, new Color(0, 255, 0));

			DrawFPS(10, 10);

			EndDrawing();
			//----------------------------------------------------------------------------------
			Thread.yield();
		}

		// De-Initialization
		//--------------------------------------------------------------------------------------
		CloseWindow();        // Close window and OpenGL context
		//--------------------------------------------------------------------------------------

	}
}
