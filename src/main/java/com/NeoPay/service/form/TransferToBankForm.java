package com.NeoPay.service.form;

import lombok.Data;

@Data
public class TransferToBankForm {


    private String iban;
    private Double amount;

}
