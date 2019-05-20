package com.zb.service.dto;

/**
 * Created by bzheng on 2018/12/17.
 */
public class JacVehicleDTO {

    private Long id;

    private String plateNo;
    /**
     * vin
     */
    private String vin;

    /**
     * '车型id'
     */
    private Long modelId;

    /**
     * 所属大区ID
     */
    private Long regionId;

    /**
     * 所属经销商ID
     */
    private Long dealerId;

    /**
     * 所属车队ID
     */
    private Long motorcadeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public Long getMotorcadeId() {
        return motorcadeId;
    }

    public void setMotorcadeId(Long motorcadeId) {
        this.motorcadeId = motorcadeId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }
}
