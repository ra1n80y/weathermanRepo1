package com.RAINBOY.SERVICE;

import com.RAINBOY.BO.InternationalClientPOJO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ServiceInterface
{
    String registerCustomer(InternationalClientPOJO pojo);

    Iterable<InternationalClientPOJO> registerMultipleCustomers(Iterable<InternationalClientPOJO> list);

    Optional<InternationalClientPOJO>getVaccineById(Long ID);

    String removeVaccineById(Long id);

    Iterable <InternationalClientPOJO>fetchMultipleDetails(boolean status,String...tableProperties);

    List<InternationalClientPOJO> getDetailsByObject(InternationalClientPOJO client);

}
