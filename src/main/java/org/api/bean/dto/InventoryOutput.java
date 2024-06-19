package org.api.bean.dto;

public class InventoryOutput {
    Integer inventoryOutputId;

    public InventoryOutput(Integer inventoryOutputId) {
        this.inventoryOutputId = inventoryOutputId;
    }

    public InventoryOutput() {
    }

    public Integer getInventoryOutputId() {
        return inventoryOutputId;
    }

    public void setInventoryOutputId(Integer inventoryOutputId) {
        this.inventoryOutputId = inventoryOutputId;
    }
}
