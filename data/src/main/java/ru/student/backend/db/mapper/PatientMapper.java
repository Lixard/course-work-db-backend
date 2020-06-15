package ru.student.backend.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.student.backend.db.model.Patient;
import ru.student.backend.db.model.PatientWithAppointmentDate;

import java.time.LocalDateTime;
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
            "SELECT p.patient_id, " +
                    "p.last_name," +
                    "p.first_name, " +
                    "p.second_name, " +
                    "p.sex, " +
                    "p.birthday, " +
                    "p.policy, " +
                    "p.serial_passport, " +
                    "p.number_passport, " +
                    "a.appointment_date " +
                    "FROM appointments a " +
                    "JOIN patients p on a.patient_id = p.patient_id " +
                    "WHERE a.doctor_id = #{doctorId} " +
                    "GROUP BY a.doctor_id, " +
                    "p.patient_id, " +
                    "p.last_name, " +
                    "p.second_name, " +
                    "p.sex, " +
                    "p.birthday, " +
                    "p.policy, " +
                    "p.serial_passport, " +
                    "p.number_passport, " +
                    " a.appointment_date " +
                    "HAVING min(a.appointment_date) > #{dateStart} " +
                    "AND max(a.appointment_date) < #{dateEnd}"

    )
    List<PatientWithAppointmentDate> getPatientsForCurrentDoctorForPeriod(@Param("doctorId") int doctorId,
                                                                          @Param("dateStart") LocalDateTime dateStart,
                                                                          @Param("dateEnd") LocalDateTime dateEnd);

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
    @SelectKey(
            before = false,
            keyProperty = "patientId",
            keyColumn = "patient_id",
            statement = "select currval('patients_patient_id_seq')",
            resultType = Integer.class
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
