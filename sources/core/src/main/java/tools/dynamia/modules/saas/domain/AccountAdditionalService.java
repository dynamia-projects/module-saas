/*
 * Copyright (C) 2021 Dynamia Soluciones IT S.A.S - NIT 900302344-1
 * Colombia / South America
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tools.dynamia.modules.saas.domain;

import tools.dynamia.domain.jpa.SimpleEntity;
import tools.dynamia.domain.contraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "saas_add_services")
public class AccountAdditionalService extends SimpleEntity {

    @ManyToOne
    private Account account;
    private String reference;
    @NotEmpty
    private String name;
    @Column(length = 1000)
    private String description;
    private BigDecimal price = BigDecimal.ZERO;
    private int quantity = 1;
    private BigDecimal total = BigDecimal.ZERO;


    public void compute() {
        if (price != null) {
            BigDecimal old = total;
            total = price.multiply(BigDecimal.valueOf(quantity));
            notifyChange("total", old, total);
        }
    }

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        compute();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        compute();
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
