package com.ex1.command;

import com.ex1.reciever.AudioPlayer;

public class PlayCommand implements Command {
	private AudioPlayer myAudio;
	
	public PlayCommand(AudioPlayer audioPlayer) {
		this.myAudio = audioPlayer;
	}

	@Override
	public void execute() {
		 myAudio.play();
	}

}
