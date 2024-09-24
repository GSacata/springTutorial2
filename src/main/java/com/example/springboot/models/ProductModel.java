package com.example.springboot.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_PRODUCTS")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable {
    private static final long serialVersionUID = 1L; // Controle de versão da classe/modelo

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) // IDs serão gerados automaticamente
    private UUID idProduct;
    private String name;
    private BigDecimal value;
    private String description;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    public UUID getIdProduct() {
        return idProduct;
    }
    
    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public BigDecimal getValue() {
        return value;
    }
    
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
