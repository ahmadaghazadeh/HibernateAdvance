package com.sevensky.hibernate_advance;

import com.sevensky.hibernate_advance.joinedtable.ElectricGuitar;
import com.sevensky.hibernate_advance.repository.ElectricGuitarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {


    private final ElectricGuitarRepository electricGuitarRepository;

    public Bootstrap(ElectricGuitarRepository electricGuitarRepository) {
        this.electricGuitarRepository = electricGuitarRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ElectricGuitar electricGuitar = new ElectricGuitar();
        electricGuitar.setNumberOfStrings(7);
        electricGuitar.setNumberOfPickups(5);
        electricGuitarRepository.save(electricGuitar);

    }
}
