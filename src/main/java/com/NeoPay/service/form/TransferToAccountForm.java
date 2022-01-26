package com.NeoPay.service.form;

import lombok.Data;

@Data
public class TransferToAccountForm {


    private String iban;
    private Double amount;

}
