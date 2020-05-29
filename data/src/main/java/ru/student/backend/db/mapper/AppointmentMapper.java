package ru.student.backend.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.student.backend.db.model.Appointment;

import java.util.List;

@Mapper
public interface AppointmentMapper {

    @Select(
            //language=PostgreSQL
            "SELECT appointment_id," +
                    " patient_id," +
                    " doctor_id," +
                    " place," +
                    " appointment_date," +
                    " symptoms " +
                    "FROM appointments"
    )
    List<Appointment> getAppointments();

    @Select(
            //language=PostgreSQL
            "SELECT appointment_id, patient_id, doctor_id, place, appointment_date, symptoms " +
                    "FROM appointments " +
                    "WHERE patient_id = #{id}"
    )
    List<Appointment> getPatientAppointments(@Param("id") int patientId);

    @Select(
            //language=PostgreSQL
            "SELECT appointment_id," +
                    " patient_id," +
                    " doctor_id," +
                    " place," +
                    " appointment_date," +
                    " symptoms " +
                    "FROM appointments " +
                    "WHERE appointment_id = #{id}"
    )
    Appointment findById(@Param("id") int id);

    @Insert(
            //language=PostgreSQL
            "INSERT INTO appointments(patient_id, doctor_id, place, appointment_date, symptoms) " +
                    "VALUES (#{patientId}, #{doctorId}, #{place}, #{appointmentDate}, #{symtoms})"
    )
    void insert(Appointment appointment);

    @Update(
            //language=PostgreSQL
            "UPDATE appointments SET " +
                    "patient_id = #{patientId}, " +
                    "doctor_id = #{doctorId}, " +
                    "place = #{place}, " +
                    "appointment_date = #{appointmentDate}, " +
                    "symptoms = #{symptoms} " +
                    "WHERE appointment_id = #{appointmentId}"
    )
    void update(Appointment appointment);

    @Delete(
            //language=PostgreSQL
            "DELETE FROM appointments WHERE appointment_id = #{id}"
    )
    void delete(@Param("id") int id);
}
