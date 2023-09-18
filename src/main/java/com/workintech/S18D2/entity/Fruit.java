package com.workintech.S18D2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "fruit", schema = "spring")
public class Fruit extends Plant {
    @Enumerated(EnumType.STRING)
    @Column(name = "fruit_type")
    private FruitType type;
}