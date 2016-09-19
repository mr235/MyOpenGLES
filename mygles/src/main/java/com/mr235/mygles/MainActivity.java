package com.mr235.mygles;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity {

	private MyGLSurfaceView mGLView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mGLView = new MyGLSurfaceView(this);

		setContentView(mGLView);
	}

	static class MyGLSurfaceView extends GLSurfaceView {

		private final MyGLRenderer mRenderer;

		public MyGLSurfaceView(Context context){
			super(context);

			// Create an OpenGL ES 2.0 context
			setEGLContextClientVersion(2);

			mRenderer = new MyGLRenderer();

			// Set the Renderer for drawing on the GLSurfaceView
			setRenderer(mRenderer);

			// Render the view only when there is a change in the drawing data
			setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
		}
	}
	static class MyGLRenderer implements GLSurfaceView.Renderer {

		@Override
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		}

		@Override
		public void onSurfaceChanged(GL10 gl, int width, int height) {
			GLES20.glViewport(0, 0, width, height);
		}

		@Override
		public void onDrawFrame(GL10 gl) {
			GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
		}
	}
}