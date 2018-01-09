package com.pavoindus.modeltraining.model;

import org.apache.commons.logging.LogFactory;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

@Entity
public class ModelConfig implements Serializable {

    @Id
    private Long id;
    @OneToOne
    @JoinColumn(nullable = false, name = "id")
    private Model model;
    private Double wt01Coeff;
    private Double wt02Coeff;
    private Double wt03Coeff;
    private Double wt04Coeff;
    private Double wt05Coeff;
    private Double wt06Coeff;
    private Double wt07Coeff;
    private Double wt08Coeff;
    private Double wt09Coeff;
    private Double wt10Coeff;
    private Double wt11Coeff;
    private Double wt12Coeff;
    private Double wt13Coeff;
    private Double wt14Coeff;
    private Double wt15Coeff;
    private Double wt16Coeff;
    private Double wt17Coeff;
    private Double wt18Coeff;
    private Double wt19Coeff;
    private Double wt20Coeff;
    private Double wt21Coeff;
    private Double wt22Coeff;
    private Double wt23Coeff;
    private Double wt24Coeff;
    private Double wt25Coeff;
    private Double wt26Coeff;
    private Double wt27Coeff;
    private Double wt28Coeff;
    private Double wt29Coeff;
    private Date whenCreated;
    protected ModelConfig() {
    }
    public ModelConfig(Model model) {
        this.model = model;
        this.id = model.getId();
        this.whenCreated = new Date();
    }
    public ModelConfig(Model model, Double wt01Coeff, Double wt02Coeff, Double wt03Coeff, Double wt04Coeff, Double wt05Coeff, Double wt06Coeff, Double wt07Coeff, Double wt08Coeff, Double wt09Coeff, Double wt10Coeff, Double wt11Coeff, Double wt12Coeff, Double wt13Coeff, Double wt14Coeff, Double wt15Coeff, Double wt16Coeff, Double wt17Coeff, Double wt18Coeff, Double wt19Coeff, Double wt20Coeff, Double wt21Coeff, Double wt22Coeff, Double wt23Coeff, Double wt24Coeff, Double wt25Coeff, Double wt26Coeff, Double wt27Coeff, Double wt28Coeff, Double wt29Coeff) {
        this.model = model;
        this.id = model.getId();
        this.wt01Coeff = wt01Coeff;
        this.wt02Coeff = wt02Coeff;
        this.wt03Coeff = wt03Coeff;
        this.wt04Coeff = wt04Coeff;
        this.wt05Coeff = wt05Coeff;
        this.wt06Coeff = wt06Coeff;
        this.wt07Coeff = wt07Coeff;
        this.wt08Coeff = wt08Coeff;
        this.wt09Coeff = wt09Coeff;
        this.wt10Coeff = wt10Coeff;
        this.wt11Coeff = wt11Coeff;
        this.wt12Coeff = wt12Coeff;
        this.wt13Coeff = wt13Coeff;
        this.wt14Coeff = wt14Coeff;
        this.wt15Coeff = wt15Coeff;
        this.wt16Coeff = wt16Coeff;
        this.wt17Coeff = wt17Coeff;
        this.wt18Coeff = wt18Coeff;
        this.wt19Coeff = wt19Coeff;
        this.wt20Coeff = wt20Coeff;
        this.wt21Coeff = wt21Coeff;
        this.wt22Coeff = wt22Coeff;
        this.wt23Coeff = wt23Coeff;
        this.wt24Coeff = wt24Coeff;
        this.wt25Coeff = wt25Coeff;
        this.wt26Coeff = wt26Coeff;
        this.wt27Coeff = wt27Coeff;
        this.wt28Coeff = wt28Coeff;
        this.wt29Coeff = wt29Coeff;
        this.whenCreated = new Date();
    }

    public ModelConfig(Model model, Double[] wt) {
        this.model = model;
        this.id = model.getId();
        for(int i = 0; i< wt.length; i++) {
            String fieldName = "wt"+String.format("%02d", i+1) +"Coeff";
            try {
                Field field = this.getClass().getDeclaredField(fieldName);
                field.set(this, wt[i]);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                LogFactory.getLog(this.getClass()).error("Unable to set value", e);
            }
        }
        this.whenCreated = new Date();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Double getWt01Coeff() {
        return wt01Coeff;
    }

    public void setWt01Coeff(Double wt01Coeff) {
        this.wt01Coeff = wt01Coeff;
    }

    public Double getWt02Coeff() {
        return wt02Coeff;
    }

    public void setWt02Coeff(Double wt02Coeff) {
        this.wt02Coeff = wt02Coeff;
    }

    public Double getWt03Coeff() {
        return wt03Coeff;
    }

    public void setWt03Coeff(Double wt03Coeff) {
        this.wt03Coeff = wt03Coeff;
    }

    public Double getWt04Coeff() {
        return wt04Coeff;
    }

    public void setWt04Coeff(Double wt04Coeff) {
        this.wt04Coeff = wt04Coeff;
    }

    public Double getWt05Coeff() {
        return wt05Coeff;
    }

    public void setWt05Coeff(Double wt05Coeff) {
        this.wt05Coeff = wt05Coeff;
    }

    public Double getWt06Coeff() {
        return wt06Coeff;
    }

    public void setWt06Coeff(Double wt06Coeff) {
        this.wt06Coeff = wt06Coeff;
    }

    public Double getWt07Coeff() {
        return wt07Coeff;
    }

    public void setWt07Coeff(Double wt07Coeff) {
        this.wt07Coeff = wt07Coeff;
    }

    public Double getWt08Coeff() {
        return wt08Coeff;
    }

    public void setWt08Coeff(Double wt08Coeff) {
        this.wt08Coeff = wt08Coeff;
    }

    public Double getWt09Coeff() {
        return wt09Coeff;
    }

    public void setWt09Coeff(Double wt09Coeff) {
        this.wt09Coeff = wt09Coeff;
    }

    public Double getWt10Coeff() {
        return wt10Coeff;
    }

    public void setWt10Coeff(Double wt10Coeff) {
        this.wt10Coeff = wt10Coeff;
    }

    public Double getWt11Coeff() {
        return wt11Coeff;
    }

    public void setWt11Coeff(Double wt11Coeff) {
        this.wt11Coeff = wt11Coeff;
    }

    public Double getWt12Coeff() {
        return wt12Coeff;
    }

    public void setWt12Coeff(Double wt12Coeff) {
        this.wt12Coeff = wt12Coeff;
    }

    public Double getWt13Coeff() {
        return wt13Coeff;
    }

    public void setWt13Coeff(Double wt13Coeff) {
        this.wt13Coeff = wt13Coeff;
    }

    public Double getWt14Coeff() {
        return wt14Coeff;
    }

    public void setWt14Coeff(Double wt14Coeff) {
        this.wt14Coeff = wt14Coeff;
    }

    public Double getWt15Coeff() {
        return wt15Coeff;
    }

    public void setWt15Coeff(Double wt15Coeff) {
        this.wt15Coeff = wt15Coeff;
    }

    public Double getWt16Coeff() {
        return wt16Coeff;
    }

    public void setWt16Coeff(Double wt16Coeff) {
        this.wt16Coeff = wt16Coeff;
    }

    public Double getWt17Coeff() {
        return wt17Coeff;
    }

    public void setWt17Coeff(Double wt17Coeff) {
        this.wt17Coeff = wt17Coeff;
    }

    public Double getWt18Coeff() {
        return wt18Coeff;
    }

    public void setWt18Coeff(Double wt18Coeff) {
        this.wt18Coeff = wt18Coeff;
    }

    public Double getWt19Coeff() {
        return wt19Coeff;
    }

    public void setWt19Coeff(Double wt19Coeff) {
        this.wt19Coeff = wt19Coeff;
    }

    public Double getWt20Coeff() {
        return wt20Coeff;
    }

    public void setWt20Coeff(Double wt20Coeff) {
        this.wt20Coeff = wt20Coeff;
    }

    public Double getWt21Coeff() {
        return wt21Coeff;
    }

    public void setWt21Coeff(Double wt21Coeff) {
        this.wt21Coeff = wt21Coeff;
    }

    public Double getWt22Coeff() {
        return wt22Coeff;
    }

    public void setWt22Coeff(Double wt22Coeff) {
        this.wt22Coeff = wt22Coeff;
    }

    public Double getWt23Coeff() {
        return wt23Coeff;
    }

    public void setWt23Coeff(Double wt23Coeff) {
        this.wt23Coeff = wt23Coeff;
    }

    public Double getWt24Coeff() {
        return wt24Coeff;
    }

    public void setWt24Coeff(Double wt24Coeff) {
        this.wt24Coeff = wt24Coeff;
    }

    public Double getWt25Coeff() {
        return wt25Coeff;
    }

    public void setWt25Coeff(Double wt25Coeff) {
        this.wt25Coeff = wt25Coeff;
    }

    public Double getWt26Coeff() {
        return wt26Coeff;
    }

    public void setWt26Coeff(Double wt26Coeff) {
        this.wt26Coeff = wt26Coeff;
    }

    public Double getWt27Coeff() {
        return wt27Coeff;
    }

    public void setWt27Coeff(Double wt27Coeff) {
        this.wt27Coeff = wt27Coeff;
    }

    public Double getWt28Coeff() {
        return wt28Coeff;
    }

    public void setWt28Coeff(Double wt28Coeff) {
        this.wt28Coeff = wt28Coeff;
    }

    public Double getWt29Coeff() {
        return wt29Coeff;
    }

    public void setWt29Coeff(Double wt29Coeff) {
        this.wt29Coeff = wt29Coeff;
    }

    public Date getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Date whenCreated) {
        this.whenCreated = whenCreated;
    }
}
