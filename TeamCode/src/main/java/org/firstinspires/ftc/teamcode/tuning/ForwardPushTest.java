package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "ForwardPushTest", group = "tuning")
public class ForwardPushTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        // CHANGE THESE NAMES to match your config
        DcMotorEx par = hardwareMap.get(DcMotorEx.class, "par");   // parallel dead wheel
        DcMotorEx perp = hardwareMap.get(DcMotorEx.class, "perp"); // perpendicular dead wheel

        waitForStart();

        if (isStopRequested()) return;

        // reset encoders
        par.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        perp.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        par.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        perp.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        // Tell driver to physically push the bot forward ~24 inches
        telemetry.addLine("Push the robot straight forward ~24 inches, then stop.");
        telemetry.update();

        while (opModeIsActive()) {
            int parTicks = par.getCurrentPosition();
            int perpTicks = perp.getCurrentPosition();

            telemetry.addData("Parallel Ticks", parTicks);
            telemetry.addData("Perpendicular Ticks", perpTicks);
            telemetry.update();
        }
    }
}