package com.IBM.associates.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Estagiario {


    @Id
    @Column(nullable = false)
    private Long cnum;


    @NotEmpty(message = "Nome não pode ser vazio.")
    @Column(nullable = false)
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contract_date;

    public Long getCnum() {
        return cnum;
    }

    public void setCnum(Long cnum) {
        this.cnum = cnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getContract_date() {
        return contract_date;
    }

    public void setContract_date(LocalDate contract_date) {
        this.contract_date = contract_date;
    }

    public Estagiario(Long cnum, String name, LocalDate contract_date) {
        this.cnum = cnum;
        this.name = name;
        this.contract_date = contract_date;
    }

    public Estagiario() {
    }
}
