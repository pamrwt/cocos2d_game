package com.exam2;

import android.app.Activity;
import android.os.Bundle;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

public class MainActivity extends Activity {

    CCGLSurfaceView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView=new CCGLSurfaceView(this);

        setContentView(gameView);

        // declare a director
        CCDirector director= CCDirector.sharedDirector();
        // set properties for director
        director.setAnimationInterval(1/50.0);
        director.setDisplayFPS(true);
        director.attachInView(gameView);

        // declare scene
        CCScene scene= CCScene.node();
        GameLayer gameLayer=new GameLayer();
        scene.addChild(gameLayer);

        director.runWithScene(scene);

    }
}
