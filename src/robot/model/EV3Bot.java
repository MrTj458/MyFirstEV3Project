package robot.model;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;

/**
 * @author thod0127
 * @vesion 0.2 Jan 5 2016
 */
public class EV3Bot
{
	private String botMessage;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	private int obstacleDistance;
	private MovePilot botPilot;
	
	public EV3Bot()
	{
		this.botMessage = "Lejos!";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		this.obstacleDistance = 8;
		
		setupPilot();
		displayMessage();
	}
	
	public void driveRoom()
	{
		displayMessage("DriveRoom!");
		
		botPilot.travel(100);
	}
	
	private void setupPilot()
	{
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A, 43.2).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.B, 43.2).offset(72);
		Chassis baseChassis = new WheeledChassis(new Wheel []{leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL);
		botPilot = new MovePilot(baseChassis);
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
		LCD.clear();
	}
	
	private void dance()
	{
		
	}
}
