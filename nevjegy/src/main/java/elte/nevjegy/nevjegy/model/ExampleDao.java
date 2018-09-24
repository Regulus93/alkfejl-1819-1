package elte.nevjegy.nevjegy.model;

import org.springframework.stereotype.Repository;

@Repository
public class ExampleDao {

    public String getHello(String language){
        switch (language){
            default:
                return "Hello";
            case "hu":
                return "Szia";
            case "en":
                return "Hi";
			case "it":
                return "Ciao";
            case "fr":
                return "Bonjour";

        }
    }
}
