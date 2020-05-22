package ru.student.backend.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.student.backend.db.model.Diagnosis;

import java.util.List;

@Mapper
public interface DiagnosesMapper {

    @Select(
            //language=PostgreSQL
            "SELECT diagnosis_id, diagnosis_name " +
                    "FROM diagnoses"
    )
    List<Diagnosis> getDiagnoses();

    @Select(
            //language=PostgreSQL
            "SELECT diagnosis_id, diagnosis_name " +
                    "FROM diagnoses " +
                    "WHERE diagnosis_id = #{id}"
    )
    Diagnosis findById(@Param("id") int id);

    @Insert(
            //language=PostgreSQL
            "INSERT INTO diagnoses(diagnosis_name) " +
                    "VALUES (#{diagnosisName})"
    )
    void insert(Diagnosis diagnosis);

    @Update(
            //language=PostgreSQL
            "UPDATE diagnoses " +
                    "SET diagnosis_name = #{diagnosisName} " +
                    "WHERE diagnosis_id = #{diagnosisId}"
    )
    void update(Diagnosis diagnosis);

    @Delete(
            //language=PostgreSQL
            "DELETE FROM diagnoses WHERE diagnosis_id = #{id}"
    )
    void delete(@Param("id") int id);
}
