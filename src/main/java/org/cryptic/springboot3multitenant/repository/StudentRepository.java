package org.cryptic.springboot3multitenant.repository;


import org.cryptic.springboot3multitenant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByName(String name);

    void deleteByName(String name);
}
