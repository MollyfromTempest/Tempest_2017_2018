package org.firstinspires.ftc.Tempest_2017_2018.teamcode.Programs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.Tempest_2017_2018.teamcode.DriveTrains.HolonomicDrive;

/**
 * Created by Molly on 9/30/2017.
 */
@TeleOp
public class Teleop_6699 extends LinearOpMode{


    HolonomicDrive Holodrive;

    public void Sleep(long ticks) throws InterruptedException {
        long timer = System.currentTimeMillis();
        while (System.currentTimeMillis() - timer < ticks) {
            idle();
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        Holodrive = new HolonomicDrive();
        Holodrive.init(hardwareMap);

        double theta;
        double power;
        double pivotpower;

        double driveScale = 1;
        double turnScale =1;

        /*
        boolean JUp = false
        JewelArm.setposition(some position);
         */

        waitForStart();
        while(opModeIsActive()){
            theta = -Math.PI / 4 + Math.atan2(-gamepad1.left_stick_y, -gamepad1.left_stick_x);
            power = Math.sqrt((gamepad1.left_stick_x) * (gamepad1.left_stick_x) + (gamepad1.left_stick_y) * (gamepad1.left_stick_y));
            pivotpower = -gamepad1.right_stick_x;
            if (power > 0.2) {
                Holodrive.pan(theta, power * driveScale);
            } else if (Math.abs(pivotpower) > 0.1){
                Holodrive.NE.setPower(pivotpower * turnScale);
                Holodrive.SE.setPower(pivotpower * turnScale);
                Holodrive.NW.setPower(-pivotpower * turnScale);
                Holodrive.SW.setPower(-pivotpower * turnScale);
            } else{
                Holodrive.stopmotors();
            }
            /*
            Code reserved for jewel arm, although specific button involved could change
            Will tweak to add some stuff involving arm class, but code for that isn't created yet
            if (gamepad1.dpad_left) {
                if (!JewelArmUp) {
                    JewelArm.setPosition(JUp);
                    JewelArmUp = true;
                } else {
                    JewelArm.setPosition(JDown);
                    JewelArmUp = false;
                }

                while (gamepad1.dpad_left) idle();
            }*/
        }
    }

}
