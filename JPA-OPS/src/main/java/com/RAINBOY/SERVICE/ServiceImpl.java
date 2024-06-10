package com.RAINBOY.SERVICE;

import com.RAINBOY.BO.InternationalClientPOJO;
import com.RAINBOY.DAO.InternationalClientREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Configuration
@Service
public class ServiceImpl implements ServiceInterface
{
    //CRUDRepository methods are the most commonly used ones as seen with the 1st 4 implementations
    @Autowired
    private InternationalClientREPO repo;

    @Override
    public String registerCustomer(InternationalClientPOJO pojo)
    {
        //This right here is where the binding happens, probably(I'm still learning Spring lol)
        InternationalClientPOJO msg = repo.save (pojo);
        return "Data Saved for user: "+msg.getID ();
    }

    @Override
    public Iterable registerMultipleCustomers(Iterable<InternationalClientPOJO> list)
    {
        return repo.saveAll (list);
    }

    @Override
    public Optional<InternationalClientPOJO> getVaccineById(Long ID)
    {
        return repo.findById (ID);
    }

    @Override
    public String removeVaccineById(Long id)
    {
        Optional<InternationalClientPOJO>optional=repo.findById (id);

        if(optional.isPresent ())
        {
            repo.deleteById (id);
            return "DELETION SUCCESSFUL";
        }
        else
        {
            return "NOT FOUND";
        }
    }

    @Override
    public Iterable<InternationalClientPOJO> fetchMultipleDetails(boolean status, String...tableProperties)
    {
        //PagingAndSortingRepository Method implementation
        Sort sort=Sort.by (status? Sort.Direction.ASC: Sort.Direction.DESC,tableProperties);
        return repo.findAll (sort);
    }

    @Override
    public List<InternationalClientPOJO> getDetailsByObject(InternationalClientPOJO client)
    {
        //JPARepository Method implementation
        return repo.findAll (Example.of (client));
    }
}
