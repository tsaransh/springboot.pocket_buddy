package com.pocketbuddy.payload;

import lombok.Data;

import java.util.Date;

@Data
public class PersonalExpenseStatement {

    public String userUid;
    public Date startDate;
    public Date endDate;

}
