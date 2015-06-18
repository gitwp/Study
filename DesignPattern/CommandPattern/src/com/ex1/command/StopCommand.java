package com.ex1.command;

import com.ex1.reciever.AudioPlayer;

public class StopCommand implements Command {
	private AudioPlayer myAudio;
	
	public StopCommand(AudioPlayer audioPlayer) {
		this.myAudio = audioPlayer;
	}

	@Override
	public void execute() {
		 myAudio.stop();
	}

}
