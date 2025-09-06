package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public final class LimelightCam {

    public Limelight3A hardware;
    public Telemetry telemetry;

    // Initializes the variables necessary for the lime light camera.
    public LimelightCam(Limelight3A hardware, Telemetry telemetry){
        this.hardware = hardware;
        this.telemetry = telemetry;
    }
    public void telemetryStats(LLResult result) {
        if (result.isValid()) {
            telemetry.addData("tx", result.getTx());
            telemetry.addData("txnc", result.getTxNC());
            telemetry.addData("ty", result.getTy());
            telemetry.addData("tync", result.getTyNC());
        } else {
            telemetry.addData("Stats", "not found");
        }
    }
    public void telemetryBarcode(LLResult result) {

    }
    public void telemetryLatency(LLResult result){
        if (result.isValid()) {
            double captureLatency = result.getCaptureLatency();
            double targetingLatency = result.getTargetingLatency();
            double parseLatency = result.getParseLatency();
            telemetry.addData("LL Latency", captureLatency + targetingLatency);
            telemetry.addData("Parse Latency", parseLatency);
            telemetry.addData("PythonOutput", java.util.Arrays.toString(result.getPythonOutput()));
        } else {
            telemetry.addData("Latency", "not found");
        }
    }
    public void telemetryBarcodes(LLResult result) {

    }
    public void telemetryClassifier(LLResult result) {

    }
    public void telemetryFiducial(LLResult result) {

    }
    public void telemetryColor(LLResult result) {

    }

}
