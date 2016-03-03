package robot.model;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
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
	/*
	 * Display
	 */
	private String botMessage;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	private long turnWaitTime;
	
	/*
	 * Driving
	 */
	private MovePilot botPilot;
	
	/*
	 * Sample section
	 */
	private EV3UltrasonicSensor distanceSensor;
	private float [] ultrasonicSamples;
	
	public EV3Bot()
	{
		this.botMessage = "Lejos!";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		this.turnWaitTime = 500;
		
		distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S1"));
		ultrasonicSamples = new float[distanceSensor.sampleSize()];
		distanceSensor.enable();
		setupPilot();
	}
	
	public void driveRoom()
	{
		displayMessage("DriveRoom!");
		distanceSensor.fetchSample(ultrasonicSamples, 0);
		if(ultrasonicSamples[0] < 5)
		{
			
		}
		else
		{
			botPilot.travel(4410.4);
			Delay.msDelay(turnWaitTime);
			botPilot.rotate(-90);
			Delay.msDelay(turnWaitTime);
			botPilot.travel(6000.2);
			Delay.msDelay(turnWaitTime);
			botPilot.rotate(90);
			Delay.msDelay(turnWaitTime);
			botPilot.travel(3550.1);
			Delay.msDelay(turnWaitTime);
			botPilot.rotate(-90);
			Delay.msDelay(turnWaitTime);
			botPilot.travel(950.4);
		}
	}
	
	private void setupPilot()
	{
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A, 55).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.B, 55).offset(72);
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
