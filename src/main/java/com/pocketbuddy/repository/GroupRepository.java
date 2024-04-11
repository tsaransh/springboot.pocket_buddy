package com.pocketbuddy.repository;

import com.pocketbuddy.entity.GroupDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupDetails, String> {

}
