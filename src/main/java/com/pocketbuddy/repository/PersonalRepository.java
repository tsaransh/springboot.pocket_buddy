package com.pocketbuddy.repository;

import com.pocketbuddy.entity.PersonalExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonalRepository extends JpaRepository<PersonalExpense, String> {

    @Query(value = "select * from users_personal_expenses_table where user_uid = :userUid", nativeQuery = true)
    List<Optional<PersonalExpense>> getStatements(@Param("userUid") String userUid);
}
