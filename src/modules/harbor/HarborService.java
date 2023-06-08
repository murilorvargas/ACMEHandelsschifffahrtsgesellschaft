package modules.harbor;

import java.util.List;

import modules.harbor.dtos.CreateHarborDTO;
import modules.harbor.dtos.FindHarborByIdDTO;
import modules.harbor.entities.interfaces.IHarborReadable;
import modules.harbor.repositories.InMemoryHarborRepository;
import modules.harbor.repositories.interfaces.IHarborRepository;
import shared.errors.CargoNotFound;
import shared.errors.HarborAlreadyExists;
import shared.errors.NoCargoRegistered;

public class HarborService {
    private IHarborRepository harborRepository;

    public HarborService() {
        this.harborRepository = InMemoryHarborRepository.instanceOf();
    }

    public IHarborReadable createHarbor(CreateHarborDTO createHarborDTO) {
        IHarborReadable harborAlreadyExists = this.harborRepository.findById(createHarborDTO.getId());
        if (harborAlreadyExists != null) {
            throw new HarborAlreadyExists(String.valueOf(createHarborDTO.getId()));
        }
        return this.harborRepository.create(createHarborDTO.getId(), createHarborDTO.getName(),
                createHarborDTO.getCountry());
    }

    public List<IHarborReadable> findAllHarbors() {
        List<IHarborReadable> harbors = this.harborRepository.findAll();
        if (harbors.isEmpty()) {
            throw new NoCargoRegistered();
        }

        return harbors;
    }

    public IHarborReadable findHarborById(FindHarborByIdDTO findHarborByIdDTO) {
        IHarborReadable harbor = this.harborRepository.findById(findHarborByIdDTO.getId());
        if (harbor == null) {
            throw new CargoNotFound(String.valueOf(findHarborByIdDTO.getId()));
        }

        return harbor;
    }
}
