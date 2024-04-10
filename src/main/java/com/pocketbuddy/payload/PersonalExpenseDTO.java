package com.pocketbuddy.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalExpenseDTO {
    public String id;
    public String expenseTitle;
    public Double expenseAmount;
    public String userUid;

}
