package com.pavoindus.modeltraining.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ModelAnalysis implements Serializable {

    protected ModelAnalysis() {
    }

    public ModelAnalysis(Model model) {
        this.model = model;
        this.whenCreated = new Date();
    }

    public ModelAnalysis(Model model, String truePositive, String falseNegative, String accuracy, String score, String location) {
        this.model = model;
        this.truePositive = truePositive;
        this.falseNegative = falseNegative;
        this.accuracy = accuracy;
        this.score = score;
        this.location = location;
        this.whenCreated = new Date();
    }

    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Model model;
    private String truePositive;
    private String falseNegative;
    private String accuracy;
    private String score;
    private String location;
    private Date whenCreated;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getTruePositive() {
        return truePositive;
    }

    public void setTruePositive(String truePositive) {
        this.truePositive = truePositive;
    }

    public String getFalseNegative() {
        return falseNegative;
    }

    public void setFalseNegative(String falseNegative) {
        this.falseNegative = falseNegative;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Date whenCreated) {
        this.whenCreated = whenCreated;
    }
}
