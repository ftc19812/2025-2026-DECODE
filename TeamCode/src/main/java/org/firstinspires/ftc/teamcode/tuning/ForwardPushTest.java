package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

@TeleOp(name = "ForwardPushTestForTicks")
public class ForwardPushTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        // CHANGE THESE NAMES to match your config

        GoBildaPinpointDriver driver = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        driver.resetPosAndIMU();
        driver.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        waitForStart();

        telemetry.addLine("Push the robot straight forward ~24 inches, then stop.");
        telemetry.update();

        if (isStopRequested()) return;

        // Tell driver to physically push the bot forward ~24 inches

        while (opModeIsActive()) {

            int YEncoders = driver.getEncoderY();
            int XEncoders = driver.getEncoderX();

            telemetry.addData("Parallel Ticks (X)", XEncoders);
            telemetry.addData("Perpendicular Ticks (Y)", YEncoders);
            telemetry.addData("test", "2");
            telemetry.update();

            driver.update();
        }
    }
}