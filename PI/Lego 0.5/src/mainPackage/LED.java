package mainPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;



import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class LED {

	static GpioController gpio;
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
	}
	
	public LED(){
		gpio = GpioFactory.getInstance();
	}
	
	public static void setOrangeOn() throws IOException, InterruptedException{
		Process p;
		String[] command = {"sh", "/home/pi/Desktop/LED/Controll/LED1/start_orange.sh"};
		p = Runtime.getRuntime().exec(command); 
		p.waitFor();
	}
	public static void setWhiteOn() throws IOException, InterruptedException{
		Process p;
		String[] command = {"sh", "/home/pi/Desktop/LED/Controll/LED1/start_white.sh"};
		p = Runtime.getRuntime().exec(command); 
		p.waitFor();
	}
	
	public static void setOff() throws IOException, InterruptedException{
		Process p;
		String[] command = {"sh", "/home/pi/Desktop/LED/Controll/LED1/stop.sh"};
		p = Runtime.getRuntime().exec(command); 
		p.waitFor();
	}
	
	public void shutdownGPIO(){
		gpio.shutdown();
	}
	
	
}
