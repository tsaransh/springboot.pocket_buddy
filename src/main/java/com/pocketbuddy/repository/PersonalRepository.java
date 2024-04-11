package com.pocketbuddy.repository;

import com.pocketbuddy.entity.PersonalExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PersonalRepository extends JpaRepository<PersonalExpense, String> {

    @Query(value = "select * from users_personal_expenses_table where user_uid = :userUid", nativeQuery = true)
    List<Optional<PersonalExpense>> getStatements(@Param("userUid") String userUid);

    @Query(value= "select SUM(expense_amount) from users_personal_expenses_table where user_uid = :userUid", nativeQuery = true)
    double getTotalExpense(@Param("userUid") String userUid);

    @Query(value = "select * from users_personal_expenses_table where user_uid = :userUid and expense_date >= :startDate and expense_date <= :endDate", nativeQuery = true)
    List<Optional<PersonalExpense>> getUserStatementBetweenData(@Param("userUid") String userUid, @Param("startDate") Date date, @Param("endDate") Date endDate);

    @Query(value = "select SUM(expense_amount) from users_personal_expenses_table where user_uid = :userUid and expense_date >= :startDate and expense_date <= :endDate", nativeQuery = true)
    double getTotalExpenseSumBetweenData(@Param("userUid") String userUid, @Param("startDate") Date date, @Param("endDate") Date endDate);

}
