package org.firstinspires.ftc.Tempest_2017_2018.teamcode.Programs;

import android.provider.CalendarContract;

import org.firstinspires.ftc.Tempest_2017_2018.teamcode.DriveTrains.HolonomicDrive;
import org.firstinspires.ftc.Tempest_2017_2018.teamcode.Sensors.ColorSensorClass;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
/**
 * Created by Molly on 9/30/2017.
 */
@Autonomous
public class Jewel_Autonomous extends LinearOpMode{
    HolonomicDrive Holodrive;
    ColorSensorClass Colorsens;
    public void Sleep(long ticks) throws InterruptedException {
        long timer = System.currentTimeMillis();
        while (System.currentTimeMillis() - timer < ticks) {
            idle();
        }
    }
    @Override
    public void runOpMode()throws InterruptedException{
        Holodrive = new HolonomicDrive();
        Holodrive.init(hardwareMap);
        Colorsens = new ColorSensorClass();
        Colorsens.init(hardwareMap);
        //Can I do this? I don't know if I'm allowed to have 2.

        waitForStart();
        //Insert Arm Stuff here or maybe in the color loop
        if (Holodrive.BlueSwitch.getState()){
            //BLUE BLUE BLUE
            if (Colorsens.isBlue(Colorsens.leftColor) && Colorsens.isBlue(Colorsens.rightColor)){
                //Both blue -- something is wrong!
                Sleep(30000);
            }
            else if (Colorsens.isRed(Colorsens.leftColor) && Colorsens.isRed(Colorsens.rightColor)){
                //Both red -- something is wrong!
                Sleep(30000);
            }
            else if (Colorsens.isBlue(Colorsens.leftColor) && Colorsens.isRed(Colorsens.rightColor)){
                // Left blue and right red. Since we are blue, we want to turn right.
                //[[Add the right turning here]]
            }
            else if (Colorsens.isRed(Colorsens.leftColor) && Colorsens.isRed(Colorsens.rightColor)){
                // Left red and right blue. Since we are blue, we want to turn left.
                // [[Add the left turning here]]
            }
            else{
                //No reading? Ambigious reading? Either way, something is wrong and we don't want to risk turning.
                Sleep(30000);
            }
        }
        else{
            //RED RED RED
            if (Colorsens.isBlue(Colorsens.leftColor) && Colorsens.isBlue(Colorsens.rightColor)){
                //Both blue -- something is wrong!
                Sleep(30000);
            }
            else if (Colorsens.isRed(Colorsens.leftColor) && Colorsens.isRed(Colorsens.rightColor)){
                //Both red -- something is wrong!
                Sleep(30000);
            }
            else if (Colorsens.isBlue(Colorsens.leftColor) && Colorsens.isRed(Colorsens.rightColor)){
                // Left blue and right red. Since we are red, we want to turn left.
                //[[Add the right turning here]]
            }
            else if (Colorsens.isRed(Colorsens.leftColor) && Colorsens.isRed(Colorsens.rightColor)){
                // Left red and right blue. Since we are red, we want to turn right.
                // [[Add the right turning here]]
            }
            else{
                //No reading? Ambigious reading? Either way, something is wrong and we don't want to risk turning.
                Sleep(30000);
            }

        }
    }
}
