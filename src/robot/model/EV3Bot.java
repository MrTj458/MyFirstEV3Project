package robot.model;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class EV3Bot
{
	private String botMessage;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	
	public EV3Bot()
	{
		this.botMessage = "Lejos!";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
	}
	
	public void driveRoom()
	{
		displayMessage();
		circles();
		drive();
	}
	
	private void displayMessage()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}
	
	private void displayMessage(String message)
	{
		LCD.drawString(message, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}
	
	private void circles()
	{
		displayMessage("Circles!");
		Motor.A.forward();
		Motor.B.backward();
		Delay.msDelay(waitTime + 6000);
	}
	
	private void drive()
	{
		displayMessage("Driving forward!");
		Motor.A.forward();
		Motor.B.forward();
		Delay.msDelay(waitTime + 6000);
	}
}
