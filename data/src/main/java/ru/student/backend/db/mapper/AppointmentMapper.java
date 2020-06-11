package ru.student.backend.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.student.backend.db.model.Appointment;
import ru.student.backend.db.model.ComplicatedAppointment;

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
            "SELECT a.appointment_id," +
                    " p.patient_id," +
                    " p.last_name as patient_last_name," +
                    " p.first_name as patient_first_name," +
                    " p.second_name as patient_second_name," +
                    " d.doctor_id," +
                    " d.last_name as doctor_last_name," +
                    " d.first_name as doctor_first_name," +
                    " d.second_name as doctor_second_name," +
                    " a.place," +
                    " a.appointment_date," +
                    " a.symptoms " +
                    "FROM appointments a " +
                    "JOIN doctors d on a.doctor_id = d.doctor_id " +
                    "JOIN patients p on a.patient_id = p.patient_id"
    )
    List<ComplicatedAppointment> getComplicatedAppointments();


    @Select(
            //language=PostgreSQL
            "SELECT a.appointment_id," +
                    " d.doctor_id," +
                    " d.last_name as doctor_last_name," +
                    " d.first_name as doctor_first_name," +
                    " d.second_name as doctor_second_name," +
                    " a.place," +
                    " a.appointment_date," +
                    " a.symptoms " +
                    "FROM appointments a " +
                    "JOIN doctors d on a.doctor_id = d.doctor_id " +
                    "JOIN patients p on a.patient_id = p.patient_id " +
                    "GROUP BY a.appointment_id," +
                    " a.patient_id," +
                    " d.doctor_id," +
                    " doctor_last_name," +
                    " doctor_first_name," +
                    " doctor_second_name, " +
                    " a.place," +
                    " a.appointment_date," +
                    " a.symptoms " +
                    "HAVING a.patient_id = #{id}"

    )
    List<ComplicatedAppointment> getComplicatedAppointmentsByPatient(@Param("id") int patientId);


    @Select(
            //language=PostgreSQL
            "SELECT a.appointment_id," +
                    " p.patient_id," +
                    " p.last_name as patient_last_name," +
                    " p.first_name as patient_first_name," +
                    " p.second_name as patient_second_name," +
                    " a.place," +
                    " a.appointment_date," +
                    " a.symptoms " +
                    "FROM appointments a " +
                    "JOIN doctors d on a.doctor_id = d.doctor_id " +
                    "JOIN patients p on a.patient_id = p.patient_id " +
                    "GROUP BY a.appointment_id," +
                    " p.patient_id," +
                    " a.doctor_id," +
                    " d.doctor_id," +
                    " patient_last_name," +
                    " patient_first_name," +
                    " patient_second_name, " +
                    " a.place," +
                    " a.appointment_date," +
                    " a.symptoms " +
                    "HAVING a.doctor_id = #{id}"
    )
    List<ComplicatedAppointment> getComplicatedAppointmentsByDoctor(@Param("id") int doctorId);

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
                    "VALUES (#{patientId}, #{doctorId}, #{place}, #{appointmentDate}, #{symptoms})"
    )
    @SelectKey(
            before = false,
            keyProperty = "appointmentId",
            keyColumn = "appointment_id",
            statement = "select currval('appointments_appointment_id_seq')",
            resultType = Integer.class
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
