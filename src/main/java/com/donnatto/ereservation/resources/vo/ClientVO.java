package com.donnatto.ereservation.resources.vo;

import lombok.Data;

@Data
public class ClientVO {

    private String cliName;
    private String cliLastName;
    private String cliIdentification;
    private String cliAddress;
    private String cliPhone;
    private String cliEmail;
}
