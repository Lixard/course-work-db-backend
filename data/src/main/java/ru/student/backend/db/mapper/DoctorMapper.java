package ru.student.backend.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.student.backend.db.model.Doctor;

import java.util.List;

@Mapper
public interface DoctorMapper {

    @Select(
            //language=PostgreSQL
            "SELECT doctor_id, user_id, last_name, first_name, second_name FROM doctors"
    )
    List<Doctor> getDoctors();

    @Select(
            //language=PostgreSQL
            "SELECT doctor_id, user_id, last_name, first_name, second_name FROM doctors " +
                    "WHERE doctor_id = #{id}"
    )
    Doctor findById(@Param("id") int id);

    @Insert(
            //language=PostgreSQL
            "INSERT INTO doctors(user_id, last_name, first_name, second_name) " +
                    "VALUES (#{userId}, #{lastName}, #{firstName}, #{secondName})"
    )
    void insert(Doctor doctor);

    @Update(
            //language=PostgreSQL
            "UPDATE doctors SET " +
                    "last_name = #{lastName}, " +
                    "first_name = #{firstName}, " +
                    "second_name = #{secondName} " +
                    "WHERE doctor_id = #{doctorId}"
    )
    void update(Doctor doctor);

    @Delete(
            //language=PostgreSQL
            "DELETE FROM doctors WHERE doctor_id = #{id}"
    )
    void delete(@Param("id") int id);
}
