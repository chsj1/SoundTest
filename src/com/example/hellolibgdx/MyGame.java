package com.example.hellolibgdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGame implements ApplicationListener {
	Stage stage;
	TextureAtlas atlas;
	Image zuojiantouImage;
	Sound sound;
	@Override
	public void create() {
		stage = new Stage(480, 800, false);
		atlas = new TextureAtlas(Gdx.files.internal("data/event.atlas"));
		sound = Gdx.audio.newSound(Gdx.files.internal("data/btn.wav"));//Sound对象的初始化
//		long soundId = sound.play();//播放音频文件
//		sound.setLooping(soundId, false);//根据soundId设置是否循环播放
//		sound.setVolume(soundId, 0.5f);//根据soundId设置音量
//		sound.stop();//停止播放音效
		zuojiantouImage = new Image(atlas.findRegion("zuo"));
		zuojiantouImage.setPosition(100, 100);
		zuojiantouImage.setColor(Color.RED);
		zuojiantouImage.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				sound.play();
				return true;
			}
		});
		stage.addActor(zuojiantouImage);
		Gdx.input.setInputProcessor(stage);
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);// 设置背景为白色
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// 清屏
		stage.act();
		stage.draw();
	}
	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
}
