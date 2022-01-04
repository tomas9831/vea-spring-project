//package cz.vsb.vea.cz.vsb.vea.lab02v2.DAO.jdbc;
//
//import cz.vsb.vea.cz.vsb.vea.lab02v2.DAO.PersonDao;
//import cz.vsb.vea.cz.vsb.vea.lab02v2.DAO.jdbc.Mappers.PersonMapper;
//import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import javax.sql.DataSource;
//import java.sql.*;
//import java.util.List;
//
//@Repository
//public class PersonDaoJdbc implements PersonDao<Person> {
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @PostConstruct
//    public void init() {
//        try {
//            String dbProducerName;
//            try (Connection con = jdbcTemplate.getDataSource().getConnection()) {
//                DatabaseMetaData metaData = con.getMetaData();
//                dbProducerName = metaData.getDatabaseProductName();
//            }
//            String sqlCreateTable;
//            if ("H2".equals(dbProducerName)) {
//                sqlCreateTable = "CREATE TABLE IF NOT EXISTS persons(id BIGINT NOT NULL AUTO_INCREMENT," +
//                        " login varchar(10) not null, " +
//                        " firstName varchar(255) not null, " +
//                        " lastName varchar(255) not null, " +
//                        " dateOfBirth date, ";
//            } else {
//                throw new RuntimeException("Unsupported database type");
//            }
//            jdbcTemplate.update(sqlCreateTable);
//        } catch (DataAccessException e) {
//            System.out.println("Table already exists.");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<Person> getAll() {
//        List<Person> persons = jdbcTemplate.query("select * from persons", new PersonMapper());
////        List<Person> teachers = jdbcTemplate.query("select * from teachers", new PersonMapper());
////        List<Person> students = jdbcTemplate.query("select * from students", new PersonMapper());
////        persons.addAll(teachers);
////        persons.addAll(students);
//        return persons;
//    }
//
//    @Override
//    public Person findById(long id) {
//        try {
//            return jdbcTemplate.queryForObject("select * from persons where id=?", new Object[]{id}, new PersonMapper());
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//    @Override
//    public Person insert(Person person) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement("insert into persons (firstname, lastname, dateofbirth) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, person.getFirstName());
//            ps.setString(2, person.getLastName());
//            ps.setDate(3, new Date(person.getAge()));
//            return ps;
//        }, keyHolder);
//        person.setId((int) keyHolder.getKey());
//        return person;
//    }
//
//    @Override
//    public Person update(Person person) {
//        jdbcTemplate.update("UPDATE persons SET firstname = ?, lastname = ?, dateofbirth = ? WHERE id = ?",
//                person.getFirstName(), person.getLastName(), person.getAge(), person.getId());
//        return person;
//    }
//
//    @Override
//    public void delete(long id) {
//        jdbcTemplate.update("DELETE FROM persons WHERE id = ?", id);
//    }
//
//}
