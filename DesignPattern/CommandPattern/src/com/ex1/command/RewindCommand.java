package com.ex1.command;

import com.ex1.reciever.AudioPlayer;

public class RewindCommand implements Command {
	private AudioPlayer myAudio;
	
	public RewindCommand(AudioPlayer audioPlayer) {
		this.myAudio = audioPlayer;
	}

	@Override
	public void execute() {
		 myAudio.rewind();
	}

}
