package com.ging.engine.game;

import com.ging.engine.AbstractGame;
import com.ging.engine.GameContainer;
import com.ging.engine.Renderer;

import java.awt.event.KeyEvent;

public class GameManger extends AbstractGame
{
    public GameManger()
    {

    }

    @Override
    public void update(GameContainer gc, float dt)
    {
        if(gc.getInput().isKeyDown(KeyEvent.VK_A)){
            System.out.println("A");
        }
    }

    @Override
    public void render(GameContainer gc, Renderer r)
    {

    }

    public static void main(String[] args)
    {
        GameContainer gc = new GameContainer(new GameManger());
        gc.start();
    }
}
