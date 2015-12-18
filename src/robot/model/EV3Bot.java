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
	private int obstacleDistance;
	
	public EV3Bot()
	{
		this.botMessage = "Lejos!";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		this.obstacleDistance = 8;
		
		displayMessage();
	}
	
	public void driveRoom()
	{
		displayMessage("DriveRoom!");
		
		if(obstacleDistance < 6)
		{
			while(obstacleDistance < 6)
			{
				Motor.A.forward();
				Motor.B.backward();
			}
		}
		else
		{
			Motor.A.forward();
			Motor.B.forward();
		}
		
		dance();
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
	
	private void dance()
	{
		Motor.A.forward();
		Motor.B.backward();
		Delay.msDelay(1000);
		Motor.A.stop();
		Motor.B.stop();
		Motor.B.forward();
		Motor.A.forward();
		Delay.msDelay(1000);
		Motor.A.stop();
		Motor.B.stop();
		Motor.B.forward();
		Motor.A.backward();
		Delay.msDelay(2000);
		Motor.B.stop();
		Motor.A.stop();
		Motor.A.forward();
		Motor.B.forward();
		Delay.msDelay(1000);
		Motor.A.forward();
		Motor.A.backward();
		Delay.msDelay(1000);
		Motor.A.stop();
		Motor.B.stop();
	}
	
	private void drive()
	{
		displayMessage("Driving forward!");
		Motor.A.forward();
		Motor.B.forward();
		Delay.msDelay(waitTime + 6000);
	}
}
