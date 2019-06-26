package driver;

import java.io.*;
import java.util.Timer;
import main.*;


/**
 * author Fabian Daum
 */
public class BluetoothDriver implements Runnable{
	
    private final Process proc;
    private final PrintWriter writer;
    public final InputStream inputStream;
    
    private String mac;
    private Controller controller;
    private String remoteService;
    private int motor;
    private int motorID;
    
    
    public BluetoothDriver(String bluetoothControlCommand) throws IOException {
        this.proc = Runtime.getRuntime().exec(bluetoothControlCommand);
        this.writer = new PrintWriter(new OutputStreamWriter(proc.getOutputStream()));
        this.inputStream = proc.getInputStream();
        
    }

    public BluetoothDriver(int motor, int motorID, String mac, Controller controller, String remoteService) throws IOException, InterruptedException {
        this("bluetoothctl"); 
    	this.mac = mac;
    	this.remoteService = remoteService;
    	this.motor = motor;
    	this.motorID = motorID;

    }
    
    public void reconnect(){
    	cmd("power on");
    	cmd("connect " + mac);
    	cmd("pairable on");
    	cmd("pair " + mac);
        cmd("select-attribute " + remoteService);
    }
    
    
    
    public void run(){
    	sleep(20);
    	reconnect();
        
        while(true){
        	sleep(5);
        	for (int i = 0; i < 4; i++){
        		if ( controller.getMotorStatus(motorID + i) == 1){
    	        	cmd("write 0x01 " + (motor + i) + " 0x00 0xFF");
    	        }
    	        else if ( controller.getMotorStatus(motorID + i) == -1){
    	        	cmd("write 0x01 " + (motor + i) + " 0x01 0xFF");
    	        }
    	        else {
    	        	cmd("write 0x01 " + (motor + i) + " 0x01 0x00");
    	        }
        	}
        } 
    }
    
    public void sleep(int i) {
    	try {
			Thread.sleep(i);
		} catch (InterruptedException e){
			e.printStackTrace();
		}  
    }
    
    //############################################1##############################################
    //# Motor Break Functions
    //##########################################################################################
    //# Description:
    //# Instantly stops a motor. Will damage motor over time if frequently used. Instead use Motor Stop
    //#
    //##########################################################################################
    
    public void breakA(){
    	cmd("write 0x00 0x00");
    }
    
    public void breakB(){
    	cmd("write 0x00 0x01");
    }
    
    public void breakV(){
    	cmd("write 0x00 0x02");
    }
    
    public void breakD(){
    	cmd("write 0x00 0x03");
    }

    
    //##########################################################################################
    //# Motor Stop Functions
    //##########################################################################################
    //# Description:
    //# Standart function to stop a motor within a short time but not instant.
    //#
    //##########################################################################################
    
    public void stopA(){
    	cmd("write 0x01 0x00 0x00 0x00");
    }
    
    public void stopB(){
    	cmd("write 0x01 0x01 0x00 0x00");
    }
    
    public void stopC(){
    	cmd("write 0x01 0x02 0x00 0x00");
    }
    
    public void stopD(){
    	cmd("write 0x01 0x03 0x00 0x00");
    }
    
    public void stop(int i){
    	cmd("write 0x01 " + i + " 0x00 0x00");
    }
    
    //##########################################################################################
    //# Motor Drive Functions
    //##########################################################################################
    //# Description:
    //#
    //#
    //##########################################################################################
    
    public void driveA(int time, int direction, int speed){
    	int startTimerA = 0;
    	while (startTimerA < time) {
    		System.out.println("Started Motor A");
	    	cmd("power on");
	        cmd("connect 88:6B:0F:40:65:A4");
	        cmd("select-attribute " + controller.getRemoteControllService());
	        cmd("write 0x01 0x00 " + direction + " " + speed);
	        startTimerA++;
    	}	
    	System.out.println("Stopped Motor A");
    	stopA();
    }
    
    public void driveB(int time, int direction, int speed){
    	int startTimerB = 0;
    	System.out.println("Started Motor B");
    	while (startTimerB < time) {
	    	cmd("power on");
	        cmd("connect 88:6B:0F:40:65:A4");
	        cmd("select-attribute " + controller.getRemoteControllService());
	        cmd("write 0x01 0x01 " + direction + " " + speed);
	        startTimerB++;
    	}	
    	System.out.println("Stopped Motor B");
    	stopB();
    }
    
    public void driveC(int time, int direction, int speed){
    	int startTimerC = 0;
    	System.out.println("Started Motor C");
    	while (startTimerC < time) {
	    	cmd("power on");
	        cmd("connect 88:6B:0F:40:65:A4");
	        cmd("select-attribute " + controller.getRemoteControllService());
	        cmd("write 0x01 0x02 " + direction + " " + speed);
	        startTimerC++;
    	}	
    	System.out.println("Stopped Motor C");
    	stopC();
    }
    
    public void driveD(int time, int direction, int speed){
    	int startTimerD = 0;
    	System.out.println("Started Motor D");
    	while (startTimerD < time) {
	    	cmd("power on");
	        cmd("connect 88:6B:0F:40:65:A4");
	        cmd("select-attribute " + controller.getRemoteControllService());
	        cmd("write 0x01 0x03 " + direction + " " + speed);
	        startTimerD++;
    	}	
    	System.out.println("Stopped Motor D");
    	stopD();
    }
    
    
    private void cmd(String command){
        writer.println(command);
        writer.flush();
        sleep(300);
    }

    public void powerUpAndScan(){
        cmd("power on");
        cmd("agent on");
        cmd("discoverable on");
        cmd("scan on");

    }

    public void powerOff(){
        cmd("power off");
    }

    public void powerCycle(){
        powerOff();
        powerUpAndScan();
    }

    private void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }
    }
}



