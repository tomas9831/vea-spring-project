//package cz.vsb.vea.cz.vsb.vea.lab02v2;
//
//import javax.xml.ws.Endpoint;
//
//import org.apache.cxf.Bus;
//import org.apache.cxf.jaxws.EndpointImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import cz.vsb.vea.cz.vsb.vea.lab02v2.controllers.PersonWs;
//import cz.vsb.vea.cz.vsb.vea.lab02v2.converters.LocalDateConverter;
//
//@Configuration
//public class ConvertersConfig implements WebMvcConfigurer{
//
//	@Autowired
//	private Bus bus;
//	@Autowired
//	private PersonWs personWs;
//
//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//		WebMvcConfigurer.super.addFormatters(registry);
//		registry.addConverter(new LocalDateConverter());
//	}
//
//
//	@Bean
//	public Endpoint personEndpoint() {
//		EndpointImpl endpointImpl = new EndpointImpl(bus, personWs);
//		endpointImpl.publish("/PersonWS");
//		return endpointImpl;
//	}
//
//}
