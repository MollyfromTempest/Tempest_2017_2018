package org.firstinspires.ftc.Tempest_2017_2018.teamcode.Programs;



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.Tempest_2017_2018.teamcode.DriveTrains.HolonomicDrive;
import org.firstinspires.ftc.Tempest_2017_2018.teamcode.Manipulators.Jewel_Arm;
import org.firstinspires.ftc.Tempest_2017_2018.teamcode.Sensors.ColorSensorClass;

/**
 * Created by Molly on 9/30/2017.
 */
@Autonomous
public class Jewel_Autonomous extends LinearOpMode{
    HolonomicDrive Holodrive;
    ColorSensorClass Colorsens;
    Jewel_Arm Jewel;
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
        Jewel = new Jewel_Arm();
        Jewel.init(hardwareMap);
        //Can I do this? I don't know if I'm allowed to have 3.

        waitForStart();
        Colorsens.leftColor.enableLed(true);
        Colorsens.rightColor.enableLed(true);
        Jewel.jewelArmDown();
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
                Holodrive.turnrightunlim(0.5, this);
                Sleep(2000);
                Holodrive.stopmotors();
            }
            else if (Colorsens.isRed(Colorsens.leftColor) && Colorsens.isRed(Colorsens.rightColor)){
                // Left red and right blue. Since we are blue, we want to turn left.
                Holodrive.turnleftunlim(0.5, this);
                Sleep(2000);
                Holodrive.stopmotors();
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
                Holodrive.turnleftunlim(0.5, this);
                Sleep(2000);
                Holodrive.stopmotors();
            }
            else if (Colorsens.isRed(Colorsens.leftColor) && Colorsens.isRed(Colorsens.rightColor)){
                // Left red and right blue. Since we are red, we want to turn right.
                Holodrive.turnrightunlim(0.5, this);
                Sleep(2000);
                Holodrive.stopmotors();
            }
            else{
                //No reading? Ambigious reading? Either way, something is wrong and we don't want to risk turning.
                Sleep(30000);
            }

        }
    }
}
