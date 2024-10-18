package com.ging.engine;

public class GameContainer implements Runnable
{

    private Thread thread;
    private Window window;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int width = 320, height = 240;
    private float scale = 1f;
    private String title = "GingEngine 1.0";

    public GameContainer()
    {

    }

    //Method that starts the actual computing of the game
    public void start()
    {
        window = new Window(this);
        thread = new Thread(this);
        thread.run();
    }

    public void stop()
    {

    }

    //Method that contains the update and render loops
    public void run()
    {
        running = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;


        while(running)
        {
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= UPDATE_CAP)
            {
                unprocessedTime -= UPDATE_CAP;

                render = true;
                //TODO: Update Game
                if(frameTime >= 1.0)
                {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: "+fps);
                }
            }

            if(render)
            {
                //TODO: Render Game
                window.update();
                frames++;
            }
            else
            {
                try
                {
                    thread.sleep(1);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }

        dispose();
    }

    public void dispose()
    {

    }

    //Main method that runs on program start
    public static void main(String[] args)
    {
        new GameContainer().start();

    }

}
