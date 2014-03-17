/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynamia.modules.saas.domain;

import com.dynamia.modules.saas.enums.AccountPeriodicity;
import com.dynamia.tools.domain.SimpleEntity;
import com.dynamia.tools.domain.contraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "saas_account_types")
public class AccountType extends SimpleEntity {

    @NotNull
    @NotEmpty(message = "ingrese nombre del tipo de cuenta")
    private String name;
    private String description;
    private String internalDescription;
    private boolean active;
    private boolean publicType;
    @OneToMany(mappedBy = "tipoCuenta")
    private List<AccountTypeRestriction> restrictions = new ArrayList<>();
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private AccountPeriodicity periodicity;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInternalDescription() {
        return internalDescription;
    }

    public void setInternalDescription(String internalDescription) {
        this.internalDescription = internalDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPublicType() {
        return publicType;
    }

    public void setPublicType(boolean publicType) {
        this.publicType = publicType;
    }

    public List<AccountTypeRestriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<AccountTypeRestriction> restrictions) {
        this.restrictions = restrictions;
    }

    public AccountPeriodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(AccountPeriodicity periodicity) {
        this.periodicity = periodicity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

}