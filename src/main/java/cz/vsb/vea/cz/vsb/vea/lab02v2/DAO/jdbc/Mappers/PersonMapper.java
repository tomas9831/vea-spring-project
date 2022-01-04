//package cz.vsb.vea.cz.vsb.vea.lab02v2.DAO.jdbc.Mappers;
//
//import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Person;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class PersonMapper implements RowMapper<Person> {
//    @Override
//    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return new Person(
//                rs.getString("firstname"),
//                rs.getString("lastname"),
//                rs.getDate("dayOfBirth").toLocalDate()
//        );
//    }
//}
