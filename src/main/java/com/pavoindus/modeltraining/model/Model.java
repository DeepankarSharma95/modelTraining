package com.pavoindus.modeltraining.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Model implements Serializable {

    protected Model() {
    }

    public Model(TrainingDataInfo trainingDataInfo, String name, Type type) {
        this.trainingDataInfo = trainingDataInfo;
        this.name = name;
        this.type = type;
        this.status = Status.ACTIVE;
        this.whenCreated = new Date();
    }

    public Model(TrainingDataInfo trainingDataInfo, String name, Type type, Status status, String fileLocation) {
        this.trainingDataInfo = trainingDataInfo;
        this.name = name;
        this.type = type;
        this.status = status;
        this.fileLocation = fileLocation;
        this.whenCreated = new Date();
    }

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "training_data_info_id", nullable = false)
    private TrainingDataInfo trainingDataInfo;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Type type;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private String fileLocation;
    private Date whenCreated;


    public enum Type {
        DT("Decision Tree"), RF("Random Forest");

        private Type(String description) {
            this.description = description;
        }
        private String description;

        public String getDescription() {
            return description;
        }
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainingDataInfo getTrainingDataInfo() {
        return trainingDataInfo;
    }

    public void setTrainingDataInfo(TrainingDataInfo trainingDataInfo) {
        this.trainingDataInfo = trainingDataInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Date getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Date whenCreated) {
        this.whenCreated = whenCreated;
    }
}
