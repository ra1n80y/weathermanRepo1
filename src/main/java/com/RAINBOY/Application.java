package com.RAINBOY;

import com.RAINBOY.BO.InternationalClientPOJO;
import com.RAINBOY.SERVICE.ServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.RAINBOY")
public class Application
{
	//Summary: Repo ref is used in service layer method ALWAYS
	//Service layer method should pass pojo ref in param.

	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = SpringApplication.run (Application.class, args);

		ServiceImpl service = context.getBean (ServiceImpl.class);

		InternationalClientPOJO client=new InternationalClientPOJO ();
		service.getDetailsByObject (client).forEach (System.out::println);

		System.out.println ("gitUpdate");

//	    Iterable<InternationalClientPOJO> list = service.fetchMultipleDetails (true, "NAME", "COUNTRY");
//		list.forEach ((c)-> System.out.println (c.getNAME ()+"=> "+c.getCOUNTRY ()));
//
//		System.out.println (service.removeVaccineById (6L));
//
//		Long ID=6L;
//		Optional<InternationalClientPOJO> optional = service.getVaccineById (ID);
//
//		if(optional.isPresent ())
//			System.out.println(optional.get ());
//		else
//			optional.orElseThrow (()->new IllegalArgumentException ("NOT FOUND LMAOO"));
//
//
//
//	 	List<InternationalClientPOJO>list=new ArrayList<> ();
//		list.add (new InternationalClientPOJO(3,25,"Marcelo","Brazil"));
//		list.add (new InternationalClientPOJO(4,23,"Bianca","Spain"));
//		list.add (new InternationalClientPOJO(5,27,"Hakeem","Nigeria"));
//		list.add (new InternationalClientPOJO(6,34,"Janelle","USA"));
//
//		String ss=""+service.registerMultipleCustomers (list);
//		System.out.println (ss);
//
//		InternationalClientPOJO pojo = new InternationalClientPOJO ();
//		pojo.setID (2);
//		pojo.setAGE (30);
//		pojo.setNAME ("Natalia");
//		pojo.setCOUNTRY ("United Kingdom");
//
//		String message = service.registerCustomer (pojo);
//		System.out.println (message);
		context.close ();
	}
}
