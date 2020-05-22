package ru.student.backend.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.student.backend.db.model.PrescriptionOfDrugs;

import java.util.List;

@Mapper
public interface PrescriptionsOfDrugsMapper {

    @Select(
            //language=PostgreSQL
            "SELECT appointment_id, drug_id FROM prescriptions_of_drugs WHERE appointment_id = #{id}"
    )
    List<PrescriptionOfDrugs> getPrescriptionsOfDrugs(@Param("id") int appointmentId);

    @Select(
            //language=PostgreSQL
            "SELECT appointment_id, drug_id FROM prescriptions_of_drugs " +
                    "WHERE appointment_id = #{id} AND drug_id = #{drugId}"
    )
    PrescriptionOfDrugs findById(@Param("appointmentId") int appointmentId, @Param("drugId") int drugId);

    @Insert(
            //language=PostgreSQL
            "INSERT INTO prescriptions_of_drugs(appointment_id, drug_id) " +
                    "VALUES (#{appointmentId}, #{drugId})"
    )
    void insert(PrescriptionOfDrugs prescriptionOfDrugs);

    @Delete(
            //language=PostgreSQL
            "DELETE FROM prescriptions_of_drugs " +
                    "WHERE appointment_id = #{appointmentId} AND drug_id = #{drugId}"
    )
    void delete(@Param("appointmentId") int appointmentId, @Param("drugId") int drugId);
}
