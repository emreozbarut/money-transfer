package com.bsf.money.transfer.service.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public final class Account
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private BigDecimal balance;

    @CreationTimestamp
    @Column(name = "createdAt")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private Date updatedAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "to")
    private Set<MoneyTransfer> sentTransfers = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "from")
    private Set<MoneyTransfer> receivedTransfers = new HashSet<>();
}

