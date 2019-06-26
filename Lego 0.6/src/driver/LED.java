package driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.python.util.PythonInterpreter; 
import org.python.core.*; 

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class LED {

	static GpioController gpio;
	
	public static void main(String[] args) throws IOException, InterruptedException{
		while (true){
			setOn();
			setOff();
		}
	}
	
	public LED(){
		gpio = GpioFactory.getInstance();
	}
	
	public static void setOn() throws IOException, InterruptedException{
		Process p;
		String[] command = {"sh", "/home/pi/Desktop/LED/Controll/LED1/start_orange.sh"};
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
	
	public void pythonVersuch(){
		PythonInterpreter python = new PythonInterpreter();
		
		int LED_COUNT      = 60;      
		int LED_PIN        = 18;       
		int LED_FREQ_HZ    = 800000;  
		int LED_DMA        = 10;      
		int LED_BRIGHTNESS = 255;     
		int LED_CHANNEL    = 0;   
		 
		python.set("LED_COUNT", new PyInteger(LED_COUNT));
		python.set("LED_PIN", new PyInteger(LED_PIN));
		python.set("LED_FREQ_HZ", new PyInteger(LED_FREQ_HZ));
		python.set("LED_DMA", new PyInteger(LED_DMA));
		python.set("LED_BRIGHTNESS", new PyInteger(LED_BRIGHTNESS));
		python.set("LED_CHANNEL", new PyInteger(LED_CHANNEL));
	
	}
}
