package com.pavoindus.modeltraining.form;

import java.lang.reflect.Field;

import org.apache.commons.logging.LogFactory;

public class ModelForm {

    private String name;
    private Long trainingDataInfoId;
    private String type;
    private Double wt01;
    private Double wt02;
    private Double wt03;
    private Double wt04;
    private Double wt05;
    private Double wt06;
    private Double wt07;
    private Double wt08;
    private Double wt09;
    private Double wt10;
    private Double wt11;
    private Double wt12;
    private Double wt13;
    private Double wt14;
    private Double wt15;
    private Double wt16;
    private Double wt17;
    private Double wt18;
    private Double wt19;
    private Double wt20;
    private Double wt21;
    private Double wt22;
    private Double wt23;
    private Double wt24;
    private Double wt25;
    private Double wt26;
    private Double wt27;
    private Double wt28;
    private Double wt29;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTrainingDataInfoId() {
        return trainingDataInfoId;
    }

    public void setTrainingDataInfoId(Long trainingDataInfoId) {
        this.trainingDataInfoId = trainingDataInfoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWt01() {
        return wt01;
    }

    public void setWt01(Double wt01) {
        this.wt01 = wt01;
    }

    public Double getWt02() {
        return wt02;
    }

    public void setWt02(Double wt02) {
        this.wt02 = wt02;
    }

    public Double getWt03() {
        return wt03;
    }

    public void setWt03(Double wt03) {
        this.wt03 = wt03;
    }

    public Double getWt04() {
        return wt04;
    }

    public void setWt04(Double wt04) {
        this.wt04 = wt04;
    }

    public Double getWt05() {
        return wt05;
    }

    public void setWt05(Double wt05) {
        this.wt05 = wt05;
    }

    public Double getWt06() {
        return wt06;
    }

    public void setWt06(Double wt06) {
        this.wt06 = wt06;
    }

    public Double getWt07() {
        return wt07;
    }

    public void setWt07(Double wt07) {
        this.wt07 = wt07;
    }

    public Double getWt08() {
        return wt08;
    }

    public void setWt08(Double wt08) {
        this.wt08 = wt08;
    }

    public Double getWt09() {
        return wt09;
    }

    public void setWt09(Double wt09) {
        this.wt09 = wt09;
    }

    public Double getWt10() {
        return wt10;
    }

    public void setWt10(Double wt10) {
        this.wt10 = wt10;
    }

    public Double getWt11() {
        return wt11;
    }

    public void setWt11(Double wt11) {
        this.wt11 = wt11;
    }

    public Double getWt12() {
        return wt12;
    }

    public void setWt12(Double wt12) {
        this.wt12 = wt12;
    }

    public Double getWt13() {
        return wt13;
    }

    public void setWt13(Double wt13) {
        this.wt13 = wt13;
    }

    public Double getWt14() {
        return wt14;
    }

    public void setWt14(Double wt14) {
        this.wt14 = wt14;
    }

    public Double getWt15() {
        return wt15;
    }

    public void setWt15(Double wt15) {
        this.wt15 = wt15;
    }

    public Double getWt16() {
        return wt16;
    }

    public void setWt16(Double wt16) {
        this.wt16 = wt16;
    }

    public Double getWt17() {
        return wt17;
    }

    public void setWt17(Double wt17) {
        this.wt17 = wt17;
    }

    public Double getWt18() {
        return wt18;
    }

    public void setWt18(Double wt18) {
        this.wt18 = wt18;
    }

    public Double getWt19() {
        return wt19;
    }

    public void setWt19(Double wt19) {
        this.wt19 = wt19;
    }

    public Double getWt20() {
        return wt20;
    }

    public void setWt20(Double wt20) {
        this.wt20 = wt20;
    }

    public Double getWt21() {
        return wt21;
    }

    public void setWt21(Double wt21) {
        this.wt21 = wt21;
    }

    public Double getWt22() {
        return wt22;
    }

    public void setWt22(Double wt22) {
        this.wt22 = wt22;
    }

    public Double getWt23() {
        return wt23;
    }

    public void setWt23(Double wt23) {
        this.wt23 = wt23;
    }

    public Double getWt24() {
        return wt24;
    }

    public void setWt24(Double wt24) {
        this.wt24 = wt24;
    }

    public Double getWt25() {
        return wt25;
    }

    public void setWt25(Double wt25) {
        this.wt25 = wt25;
    }

    public Double getWt26() {
        return wt26;
    }

    public void setWt26(Double wt26) {
        this.wt26 = wt26;
    }

    public Double getWt27() {
        return wt27;
    }

    public void setWt27(Double wt27) {
        this.wt27 = wt27;
    }

    public Double getWt28() {
        return wt28;
    }

    public void setWt28(Double wt28) {
        this.wt28 = wt28;
    }

    public Double getWt29() {
        return wt29;
    }

    public void setWt29(Double wt29) {
        this.wt29 = wt29;
    }

    public Double[] getWtArray() {
        Double[] wtArr = new Double[29];
        try {
            for (int i = 0; i < 29; i++) {
                Field field =
                    this.getClass().getDeclaredField("wt" + String.format("%02d", i + 1));
                wtArr[i] = (Double)field.get(this);
            }
        }catch ( Exception e ){
            LogFactory.getLog(this.getClass()).error(e);
        }
        return wtArr;
    }
}
