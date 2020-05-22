package ru.student.backend.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.student.backend.db.model.PatientDiagnoses;

import java.util.List;

@Mapper
public interface PatientDiagnosesMapper {

    @Select(
            //language=PostgreSQL
            "SELECT appointment_id, diagnosis_id  " +
                    "FROM patient_diagnoses " +
                    "WHERE appointment_id = #{appointmentId}"
    )
    List<PatientDiagnoses> getAppointmentDiagnoses(@Param("appointmentId") int appointmentId);

    @Select(
            //language=PostgreSQL
            "SELECT appointment_id, diagnosis_id  " +
                    "FROM patient_diagnoses " +
                    "WHERE appointment_id = #{appointmentId} " +
                    "AND diagnosis_id = #{diagnosisId}"
    )
    PatientDiagnoses findById(int appointmentId, int diagnosisId);

    @Insert(
            //language=PostgreSQL
            "INSERT INTO patient_diagnoses(appointment_id, diagnosis_id) " +
                    "VALUES (#{appointmentId}, #{diagnosisId})"
    )
    void insert(PatientDiagnoses patientDiagnoses);

    @Delete(
            //language=PostgreSQL
            "DELETE FROM patient_diagnoses " +
                    "WHERE appointment_id = #{appointmentId} AND diagnosis_id = #{diagnosisId}"
    )
    void delete(@Param("appointmentId") int appointmentId, @Param("diagnosisId") int diagnosisId);
}
