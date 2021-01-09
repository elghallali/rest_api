package com.elghallali.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "The name should not be empty!")
    private String name;
    private String description;
    @Positive(message = "The stock should be greater than zero!")
    private Double stock;
    private Double price;
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @NotEmpty(message = "The category should not be empty!")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitialize","handler"})
    private Category category;
    private String imageUrl;
}
