package com.skypointer.huaji.bean;

import java.io.Serializable;

public class ZtreeNode implements Serializable {

    private static final long serialVersionUID = -5875932093984290441L;

    public ZtreeNode() {
    }

    public ZtreeNode(Long id, Long pId, String name, boolean open) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.open = open;
    }

    private Long id;

    private Long pId;

    private String name;

    private boolean open;

    private boolean checked = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
