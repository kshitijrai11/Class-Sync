package com.studentportal.dashboard;

public class CenterAllocationResponse {

    private String district;
    private String block;
    private String centerName;
    private String centerNumber;
    private int allocatedStudents;
    private int unallocatedStudents;
    private int remainingCapacity;
    private String statusMessage;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterNumber() {
        return centerNumber;
    }

    public void setCenterNumber(String centerNumber) {
        this.centerNumber = centerNumber;
    }

    public int getAllocatedStudents() {
        return allocatedStudents;
    }

    public void setAllocatedStudents(int allocatedStudents) {
        this.allocatedStudents = allocatedStudents;
    }

    public int getUnallocatedStudents() {
        return unallocatedStudents;
    }

    public void setUnallocatedStudents(int unallocatedStudents) {
        this.unallocatedStudents = unallocatedStudents;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
