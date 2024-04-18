package com.pocketbuddy.repository;

import com.pocketbuddy.entity.GroupExpenseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface GroupExpenseDetailsRepository extends JpaRepository<GroupExpenseDetails, String> {

    @Query(value = "DELETE from group_expense_details where expense_id = :expenseId", nativeQuery = true)
    void deleteByExpenseId(@Param("expenseId") String expenseId);

    @Query(value = "SELECT * from group_expense_details where expense_id = :expenseId", nativeQuery = true)
    GroupExpenseDetails findByExpenseId(@Param("expenseId") String expenseId);

    @Query(value = "SELECT * from group_expense_details where expense_id = :groupId", nativeQuery = true)
    Optional<List<GroupExpenseDetails>> getStatement(@Param("groupId") String groupId);

    @Query(value = "SELECT SUM(expense_amount) from group_expense_details where expense_id = :groupId", nativeQuery = true)
    double getTotal(@Param("groupId") String groupId);

    @Query(value = "SELECT * from group_expense_details where expense_id = :groupId and date_of_expense >= :startDate and date_of_expense <= :endDate", nativeQuery = true)
    Optional<List<GroupExpenseDetails>> getStatement(@Param("groupId") String id,@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    @Query(value = "SELECT SUM(expense_amount) from group_expense_details where expense_id = :groupId and date_of_expense >= :startDate and date_of_expense <= :endDate", nativeQuery = true)
    Double getTotal(@Param("groupId") String id,@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    @Query(value = "DELETE from group_expense_details where expense_id = :groupId", nativeQuery = true)
    void deleteGroup(@Param("groupId") String groupId);
}
