package elte.nevjegy.nevjegy.service;

import elte.nevjegy.nevjegy.model.ExampleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    ExampleDao exampleDao;

    public String getHello(String language) {
        return exampleDao.getHello(language);
    }
}
