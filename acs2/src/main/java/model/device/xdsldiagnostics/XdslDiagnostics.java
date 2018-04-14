/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.xdsldiagnostics;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import parser.device.XdslDiagnosticsDeserializer;

/**
 *
 * @author G0041775
 */
@JsonDeserialize(using = XdslDiagnosticsDeserializer.class)
public class XdslDiagnostics {
    private String ModulationType,
            ShowtimeStart,
            UpstreamMaxRate,
            UpstreamCurrRate,
            UpstreamPower,
            UpstreamNoiseMargin,
            UpstreamAttenuation,
            DownstreamMaxRate,
            DownstreamCurrRate,
            DownstreamPower,
            DownstreamNoiseMargin,
            DownstreamAttenuation,
            LinkRetrain,
            LossOfFraming,
            SeverelyErroredSecs,
            ATUCFECErrors,
            ATUCHECErrors,
            ATUCCRCErrors,
            FECErrors,
            HECErrors,
            CRCErrors;

    public String getModulationType() {
        return ModulationType;
    }

    public void setModulationType(String ModulationType) {
        this.ModulationType = ModulationType;
    }

    public String getShowtimeStart() {
        return ShowtimeStart;
    }

    public void setShowtimeStart(String ShowtimeStart) {
        this.ShowtimeStart = ShowtimeStart;
    }

    public String getUpstreamMaxRate() {
        return UpstreamMaxRate;
    }

    public void setUpstreamMaxRate(String UpstreamMaxRate) {
        this.UpstreamMaxRate = UpstreamMaxRate;
    }

    public String getUpstreamCurrRate() {
        return UpstreamCurrRate;
    }

    public void setUpstreamCurrRate(String UpstreamCurrRate) {
        this.UpstreamCurrRate = UpstreamCurrRate;
    }

    public String getUpstreamPower() {
        return UpstreamPower;
    }

    public void setUpstreamPower(String UpstreamPower) {
        this.UpstreamPower = UpstreamPower;
    }

    public String getUpstreamNoiseMargin() {
        return UpstreamNoiseMargin;
    }

    public void setUpstreamNoiseMargin(String UpstreamNoiseMargin) {
        this.UpstreamNoiseMargin = UpstreamNoiseMargin;
    }

    public String getUpstreamAttenuation() {
        return UpstreamAttenuation;
    }

    public void setUpstreamAttenuation(String UpstreamAttenuation) {
        this.UpstreamAttenuation = UpstreamAttenuation;
    }

    public String getDownstreamMaxRate() {
        return DownstreamMaxRate;
    }

    public void setDownstreamMaxRate(String DownstreamMaxRate) {
        this.DownstreamMaxRate = DownstreamMaxRate;
    }

    public String getDownstreamCurrRate() {
        return DownstreamCurrRate;
    }

    public void setDownstreamCurrRate(String DownstreamCurrRate) {
        this.DownstreamCurrRate = DownstreamCurrRate;
    }

    public String getDownstreamPower() {
        return DownstreamPower;
    }

    public void setDownstreamPower(String DownstreamPower) {
        this.DownstreamPower = DownstreamPower;
    }

    public String getDownstreamNoiseMargin() {
        return DownstreamNoiseMargin;
    }

    public void setDownstreamNoiseMargin(String DownstreamNoiseMargin) {
        this.DownstreamNoiseMargin = DownstreamNoiseMargin;
    }

    public String getDownstreamAttenuation() {
        return DownstreamAttenuation;
    }

    public void setDownstreamAttenuation(String DownstreamAttenuation) {
        this.DownstreamAttenuation = DownstreamAttenuation;
    }

    public String getLinkRetrain() {
        return LinkRetrain;
    }

    public void setLinkRetrain(String LinkRetrain) {
        this.LinkRetrain = LinkRetrain;
    }

    public String getLossOfFraming() {
        return LossOfFraming;
    }

    public void setLossOfFraming(String LossOfFraming) {
        this.LossOfFraming = LossOfFraming;
    }

    public String getSeverelyErroredSecs() {
        return SeverelyErroredSecs;
    }

    public void setSeverelyErroredSecs(String SeverelyErroredSecs) {
        this.SeverelyErroredSecs = SeverelyErroredSecs;
    }

    public String getATUCFECErrors() {
        return ATUCFECErrors;
    }

    public void setATUCFECErrors(String ATUCFECErrors) {
        this.ATUCFECErrors = ATUCFECErrors;
    }

    public String getATUCHECErrors() {
        return ATUCHECErrors;
    }

    public void setATUCHECErrors(String ATUCHECErrors) {
        this.ATUCHECErrors = ATUCHECErrors;
    }

    public String getATUCCRCErrors() {
        return ATUCCRCErrors;
    }

    public void setATUCCRCErrors(String ATUCCRCErrors) {
        this.ATUCCRCErrors = ATUCCRCErrors;
    }

    public String getFECErrors() {
        return FECErrors;
    }

    public void setFECErrors(String FECErrors) {
        this.FECErrors = FECErrors;
    }

    public String getHECErrors() {
        return HECErrors;
    }

    public void setHECErrors(String HECErrors) {
        this.HECErrors = HECErrors;
    }

    public String getCRCErrors() {
        return CRCErrors;
    }

    public void setCRCErrors(String CRCErrors) {
        this.CRCErrors = CRCErrors;
    }
            
    
}
