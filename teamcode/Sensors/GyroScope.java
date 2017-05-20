package org.firstinspires.ftc.Tempest_2017_2018.teamcode.Sensors;

import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Aaron on 5/20/2017.
 */
public class GyroScope {
    GyroSensor gyro;

    HardwareMap HWMap;

    public GyroScope(){}

    public void init(HardwareMap HWMap){
        this.HWMap = HWMap;
        gyro = this.HWMap.gyroSensor.get("gyro");
        gyro.calibrate();
    }
}
