package ru.itmo.wp.form;

import javax.validation.constraints.NotNull;

public class ChangeStatusRequest {

    @NotNull
    private Long id;

    @NotNull
    private Boolean disabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
