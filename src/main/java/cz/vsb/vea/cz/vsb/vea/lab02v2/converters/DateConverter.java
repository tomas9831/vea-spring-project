//package cz.vsb.vea.cz.vsb.vea.lab02v2.converters;
//
//import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Person;
//import cz.vsb.vea.cz.vsb.vea.lab02v2.services.PersonServis;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//import java.time.DateTimeException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class DateConverter implements Converter<String, LocalDate> {
//
//    private static final List<String> SUPPORTED_FORMATS = Arrays.asList("dd-MM-yyyy", "yyyy-MM-dd");
//    private static final List<DateTimeFormatter> DATE_TIME_FORMATTERS = SUPPORTED_FORMATS
//            .stream()
//            .map(DateTimeFormatter::ofPattern)
//            .collect(Collectors.toList());
//
//    @Autowired
//    private PersonServis studentService;
//
//    @Override
//    public LocalDate convert(String s) {
//        for (DateTimeFormatter dateTimeFormatter : DATE_TIME_FORMATTERS) {
//            try {
//                return LocalDate.parse(s, dateTimeFormatter);
//            } catch (DateTimeParseException ex) {
//            }
//        }
//
//        throw new DateTimeException(String.format("unable to parse (%s) supported formats are %s",
//                s, String.join(", ", SUPPORTED_FORMATS)));
//    }
//
//}