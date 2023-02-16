package co.com.msprocessidentifier.objects;

import java.time.Instant;

import lombok.Data;

@Data
public class MonitorTime {

	private long timeStart;
	private long timeEnd;
	private String initialDate;
	private String completionDate;
	
	public MonitorTime() {
		timeStart = System.nanoTime();
		initialDate = Instant.now().toString();
	}
	
	public void timeElapsed(){
		timeEnd = System.nanoTime();
		completionDate = Instant.now().toString();
	}
}
