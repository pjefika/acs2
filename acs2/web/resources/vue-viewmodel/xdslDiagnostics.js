/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global moment */

// CLASSES
var XdslDiagnostics = function (p) {
    if (p) {
        this.ModulationType = p.ModulationType;
        this.ShowtimeStart = p.ShowtimeStart;
        this.UpstreamMaxRate = p.UpstreamMaxRate;
        this.UpstreamCurrRate = p.UpstreamCurrRate;
        this.UpstreamPower = p.UpstreamPower;
        this.UpstreamNoiseMargin = p.UpstreamNoiseMargin;
        this.UpstreamAttenuation = p.UpstreamAttenuation;
        this.DownstreamMaxRate = p.DownstreamMaxRate;
        this.DownstreamCurrRate = p.DownstreamCurrRate;
        this.DownstreamPower = p.DownstreamPower;
        this.DownstreamNoiseMargin = p.DownstreamNoiseMargin;
        this.DownstreamAttenuation = p.DownstreamAttenuation;
        this.LinkRetrain = p.LinkRetrain;
        this.LossOfFraming = p.LossOfFraming;
        this.SeverelyErroredSecs = p.SeverelyErroredSecs;
        this.ATUCFECErrors = p.ATUCFECErrors;
        this.ATUCHECErrors = p.ATUCHECErrors;
        this.ATUCCRCErrors = p.ATUCCRCErrors;
        this.FECErrors = p.FECErrors;
        this.HECErrors = p.HECErrors;
        this.CRCErrors = p.CRCErrors;
    }
    
};