package com.jokenpo.project.crud;
;
import com.jokenpo.project.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCrud extends JpaRepository<UserModel, Long> {

}