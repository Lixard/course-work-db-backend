package ru.student.backend.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.student.backend.db.model.Patient;

import java.util.List;

@Mapper
public interface PatientMapper {

    @Select(
            //language=PostgreSQL
            "SELECT " +
                    "patient_id, " +
                    "last_name, " +
                    "first_name, " +
                    "second_name, " +
                    "sex, " +
                    "birthday, " +
                    "policy, " +
                    "serial_passport, " +
                    "number_passport " +
                    "FROM patients"
    )
    List<Patient> getPatients();

    @Select(
            //language=PostgreSQL
            "SELECT " +
                    "patient_id, " +
                    "last_name, " +
                    "first_name, " +
                    "second_name, " +
                    "sex, " +
                    "birthday, " +
                    "policy, " +
                    "serial_passport, " +
                    "number_passport " +
                    "FROM patients " +
                    "WHERE patient_id = #{id}"
    )
    Patient findById(@Param("id") int id);

    @Insert(
            //language=PostgreSQL
            "INSERT INTO patients(last_name, first_name, second_name," +
                    " sex, birthday, policy, serial_passport, number_passport)" +
                    " VALUES (#{lastName}, #{firstName}, #{secondName}, #{sex}," +
                    " #{birthday}, #{policy}, #{serialPassport}, #{numberPassport})"
    )
    void insert(Patient patient);

    @Update(
            //language=PostgreSQL
            "UPDATE patients SET " +
                    "last_name = #{lastName}, " +
                    "first_name = #{firstName}, " +
                    "second_name = #{secondName}, " +
                    "sex = #{sex}, " +
                    "birthday = #{birthday}, " +
                    "policy = #{policy}, " +
                    "serial_passport = #{serialPassport}, " +
                    "number_passport = #{numberPassport} " +
                    "WHERE patient_id = #{patientId}"
    )
    void update(Patient patient);

    @Select(
            //language=PostgreSQL
            "DELETE FROM patients WHERE patient_id = #{id}"
    )
    void delete(@Param("id") int id);
}
