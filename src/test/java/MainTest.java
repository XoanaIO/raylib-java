import org.junit.Test;
import raylib.*;

import static raylib.Color.*;
import static raylib.Raylib.*;
import static raylib.TextureFilterMode.*;

public class MainTest {
	/*** runMain
	 * Open and close a window just to be sure that our library is sane.
	 */
	@Test
	public void runMain() {
		InitWindow(640, 480, "Test");
		CloseWindow();
	}

	//@Test
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

	//@Test
	public void modelLoadTest() {
		// Initialization
		//--------------------------------------------------------------------------------------
		int screenWidth = 800;
		int screenHeight = 450;

		InitWindow(screenWidth, screenHeight, "raylib [models] example - obj model loading");

		// Define the camera to look into our 3d world
		Camera3D camera = new Camera3D();
		camera.setPosition(new Vector3(3.0f, 3.0f, 3.0f));
		camera.setTarget(new Vector3(0.0f, 1.5f, 0.0f));
		camera.setUp(new Vector3(0.0f, 1.0f, 0.0f));
		camera.setFovy(45f);

		// NOTE: LoadModel is relative to the running path, NOT the JAR.
		Model dwarf = LoadModel("src/test/resources/bridge.obj");                   // Load OBJ model
		Texture2D texture = LoadTexture("src/test/resources/bridge_diffuse.png");   // Load model texture
		dwarf.getMaterial().getMap(Material.MAP_DIFFUSE).setTexture(texture);
		//dwarf.material.maps[MAP_DIFFUSE].texture = texture;                     // Set map diffuse texture
		Vector3 position = new Vector3(0.0f, 0.0f, 0.0f);                                // Set model position

		SetTargetFPS(60);   // Set our game to run at 60 frames-per-second
		//--------------------------------------------------------------------------------------

		// Main game loop
		while (!WindowShouldClose())    // Detect window close button or ESC key
		{
			// Update
			//----------------------------------------------------------------------------------
			//...
			//----------------------------------------------------------------------------------

			// Draw
			//----------------------------------------------------------------------------------
			BeginDrawing();

			ClearBackground(RAYWHITE);

			BeginMode3D(camera);

			DrawModel(dwarf, position, 0.5f, Color.WHITE);   // Draw 3d model with texture

			DrawGrid(10, 1.0f);         // Draw a grid

			DrawGizmo(position);        // Draw gizmo

			EndMode3D();

			DrawText("(c) Dwarf 3D model by David Moreno", screenWidth - 200, screenHeight - 20, 10, Color.GRAY);

			DrawFPS(10, 10);

			EndDrawing();
			//----------------------------------------------------------------------------------
		}

		// De-Initialization
		//--------------------------------------------------------------------------------------
		UnloadTexture(texture);     // Unload texture
		UnloadModel(dwarf);         // Unload model

		CloseWindow();              // Close window and OpenGL context
		//--------------------------------------------------------------------------------------
	}

	//@Test
	public void testTTF() {
		// Initialization
		//--------------------------------------------------------------------------------------
		int screenWidth = 800;
		int screenHeight = 450;

		InitWindow(screenWidth, screenHeight, "raylib [text] example - ttf loading");

    	String msg = "TTF Font";

		// NOTE: Textures/Fonts MUST be loaded after Window initialization (OpenGL context is required)

		// TTF Font loading with custom generation parameters
		Font font = LoadFontEx("src/test/resources/KAISG.ttf", 96, 0, null);

		// Generate mipmap levels to use trilinear filtering
		// NOTE: On 2D drawing it won't be noticeable, it looks like FILTER_BILINEAR
		GenTextureMipmaps(font.getTexture());

		float fontSize = font.getBaseSize();
		Vector2 fontPosition = new Vector2( 40, screenHeight/2 - 80);
		Vector2 textSize;

		SetTextureFilter(font.getTexture(), Texture2D.FILTER_MODE_POINT);
		int currentFontFilter = 0;

		SetTargetFPS(60);
		//--------------------------------------------------------------------------------------

		// Main game loop
		while (!WindowShouldClose())    // Detect window close button or ESC key
		{
			// Update
			//----------------------------------------------------------------------------------
			fontSize += GetMouseWheelMove()*4.0f;

			// Choose font texture filter method
			if (IsKeyPressed(KEY_ONE))
			{
				SetTextureFilter(font.getTexture(), Texture2D.FILTER_MODE_POINT);
				currentFontFilter = 0;
			}
			else if (IsKeyPressed(KEY_TWO))
			{
				SetTextureFilter(font.getTexture(), Texture2D.FILTER_MODE_BILINEAR);
				currentFontFilter = 1;
			}
			else if (IsKeyPressed(KEY_THREE))
			{
				// NOTE: Trilinear filter won't be noticed on 2D drawing
				SetTextureFilter(font.getTexture(), Texture2D.FILTER_MODE_TRILINEAR);
				currentFontFilter = 2;
			}

			textSize = MeasureTextEx(font, msg, fontSize, 0);

			if (IsKeyDown(KEY_LEFT)) fontPosition.setX(fontPosition.getX() - 10);
			else if (IsKeyDown(KEY_RIGHT)) fontPosition.setX(fontPosition.getX() + 10);

			//----------------------------------------------------------------------------------

			// Draw
			//----------------------------------------------------------------------------------
			BeginDrawing();

			ClearBackground(RAYWHITE);

			DrawText("Use mouse wheel to change font size", 20, 20, 10, GRAY);
			DrawText("Use KEY_RIGHT and KEY_LEFT to move text", 20, 40, 10, GRAY);
			DrawText("Use 1, 2, 3 to change texture filter", 20, 60, 10, GRAY);
			DrawText("Drop a new TTF font for dynamic loading", 20, 80, 10, DARKGRAY);

			DrawTextEx(font, msg, fontPosition, fontSize, 0, BLACK);

			// TODO: It seems texSize measurement is not accurate due to chars offsets...
			//DrawRectangleLines(fontPosition.x, fontPosition.y, textSize.x, textSize.y, RED);

			DrawRectangle(0, screenHeight - 80, screenWidth, 80, LIGHTGRAY);
			DrawText("Font size: "+ fontSize, 20, screenHeight - 50, 10, DARKGRAY);
			DrawText("Text size: " + textSize.getX() + ", " + textSize.getY(), 20, screenHeight - 30, 10, DARKGRAY);
			DrawText("CURRENT TEXTURE FILTER:", 250, 400, 20, GRAY);

			if (currentFontFilter == 0) DrawText("POINT", 570, 400, 20, BLACK);
			else if (currentFontFilter == 1) DrawText("BILINEAR", 570, 400, 20, BLACK);
			else if (currentFontFilter == 2) DrawText("TRILINEAR", 570, 400, 20, BLACK);

			EndDrawing();
			//----------------------------------------------------------------------------------
		}

		// De-Initialization
		//--------------------------------------------------------------------------------------
		UnloadFont(font);     // Font unloading

		CloseWindow();              // Close window and OpenGL context
		//--------------------------------------------------------------------------------------
	}
}
