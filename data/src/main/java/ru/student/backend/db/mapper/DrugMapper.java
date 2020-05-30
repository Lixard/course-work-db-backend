package ru.student.backend.db.mapper;

import org.apache.ibatis.annotations.*;
import ru.student.backend.db.model.Drug;

import java.util.List;

@Mapper
public interface DrugMapper {

    @Select(
            //language=PostgreSQL
            "SELECT drug_id, name, method_of_taking, dosage," +
                    " description_of_action, side_effects " +
                    "FROM drugs"
    )
    List<Drug> getDrugs();

    @Select(
            //language=PostgreSQL
            "SELECT drug_id, name, method_of_taking, dosage," +
                    " description_of_action, side_effects " +
                    "FROM drugs " +
                    "WHERE drug_id = #{id}"
    )
    Drug findById(@Param("id") int id);

    @Insert(
            //language=PostgreSQL
            "INSERT INTO drugs(name, method_of_taking, dosage," +
                    " description_of_action, side_effects) " +
                    "VALUES (#{name}, #{methodOfTaking}, #{dosage}," +
                    " #{descriptionOfAction}, #{sideEffects})"
    )
    @SelectKey(
            before = false,
            keyProperty = "drugId",
            keyColumn = "drug_id",
            statement = "select currval('drugs_drug_id_seq')",
            resultType = Integer.class
    )
    void insert(Drug drug);

    @Update(
            //language=PostgreSQL
            "UPDATE drugs SET " +
                    "name = #{name}, " +
                    "method_of_taking = #{methodOfTaking}, " +
                    "dosage = #{dosage}, " +
                    "description_of_action = #{descriptionOfAction}, " +
                    "side_effects = #{sideEffect} " +
                    "WHERE drug_id = #{drugId}"
    )
    void update(Drug drug);

    @Delete(
            //language=PostgreSQL
            "DELETE FROM drugs WHERE drug_id = #{id}"
    )
    void delete(@Param("id") int id);
}
