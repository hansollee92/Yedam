package day3.remotecontrol;

public class Audio implements RemoteControl {

	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("오디오 켠다");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오 끈다");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > MAX_VOLUME) {
			volume = MAX_VOLUME;
		}else if(volume < MIN_VOLUME) {
			volume = MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 볼륨은 " + volume);
	}

}
