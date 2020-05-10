package com.exam2;

import android.view.MotionEvent;

import org.cocos2d.actions.interval.CCFadeIn;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

/**
 * Created by ytong on 11/20/17.
 */
public class GameLayer extends CCLayer {

    CCSprite player1,player2,bg;

    //constructor
    public GameLayer(){
        init();
    }

    private void init(){
        bg= CCSprite.sprite("bg.png");
        bg.setPosition(400,240);
        this.addChild(bg);

        player1= CCSprite.sprite("mario100.png");
        player1.setPosition(50,350);
        this.addChild(player1);


        this.setIsTouchEnabled(true);
    }


    @Override
    public boolean ccTouchesEnded(MotionEvent event) {
        return super.ccTouchesEnded(event);
    }

    @Override
    public boolean ccTouchesMoved(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();



        return super.ccTouchesMoved(event);
    }

    @Override
    public boolean ccTouchesBegan(MotionEvent event) {

        // get the touch points
        float x=event.getX();
        float y=event.getY();

//        for(int i=0;i<3;i++) {
            CCMoveTo moveTo = CCMoveTo.action(1, convertPointCoord(x , y ));
            player1.runAction(moveTo);

//        }
//        CCMoveTo moveTo1=CCMoveTo.action(1,convertPointCoord(x/3,y/3));
//        player1.runAction(moveTo1);
//        CCMoveTo moveTo2=CCMoveTo.action(1,convertPointCoord(x/3,y/3));
//        player1.runAction(moveTo2);
     //   addSprite(x,y);


//        CGPoint realDest = CGPoint.ccp(x, y);
//        player1.runAction(CCSequence.actions(
//                CCMoveTo.action(1, realDest),
//                CCCallFuncN.action(this, "spriteMoveFinished")));

        return super.ccTouchesBegan(event);
    }

    public void addSprite(float x,float y){
        // x, y for the location
        CCSprite player= CCSprite.sprite("mario100.png");
        // define a point for location

        CGPoint play_location=
                CCDirector.sharedDirector()
                        .convertToGL(CGPoint.ccp(x, y));
        player.setPosition(play_location);
        this.addChild(player);

//        this.addChild(player,0);

        this.schedule("run",6);

        CCFadeIn fadeIn= CCFadeIn.action(1);
        player.runAction(fadeIn);

    }

    private CGPoint convertPointCoord(float x, float y){

        CGPoint cgPoint= CCDirector.sharedDirector().convertToGL(CGPoint.ccp(x,y));
        return cgPoint;
    }
}
