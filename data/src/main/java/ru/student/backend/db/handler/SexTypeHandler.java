package ru.student.backend.db.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import ru.student.common.model.Sex;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Sex.class)
@MappedJdbcTypes(JdbcType.CHAR)
public class SexTypeHandler implements TypeHandler<Sex> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
        if (parameter != null) {
            ps.setString(i, parameter.getLiteral());
        } else {
            ps.setNull(i, jdbcType.TYPE_CODE);
        }
    }

    @Override
    public Sex getResult(ResultSet rs, String columnName) throws SQLException {
        return Sex.of(rs.getString(columnName)).orElse(null);
    }

    @Override
    public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Sex.of(rs.getString(columnIndex)).orElse(null);
    }

    @Override
    public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Sex.of(cs.getString(columnIndex)).orElse(null);
    }
}
