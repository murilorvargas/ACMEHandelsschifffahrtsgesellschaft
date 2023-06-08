package modules.harborDistance;

import modules.harbor.entities.interfaces.IHarborReadable;
import modules.harbor.repositories.interfaces.IHarborRepository;
import modules.harbor.repositories.InMemoryHarborRepository;
import modules.harborDistance.dtos.CreateHarborDistanceDTO;
import modules.harborDistance.entities.interfaces.IHarborDistanceReadable;
import modules.harborDistance.repositories.interfaces.IHarborDistanceRepository;
import modules.harborDistance.repositories.InMemoryHarborDistanceRepository;
import shared.errors.HarborDistanceAlreadyExists;
import shared.errors.HarborNotFound;

public class HarborDistanceService {
    private IHarborRepository harborRepository;
    private IHarborDistanceRepository harborDistanceRepository;

    public HarborDistanceService() {
        this.harborRepository = InMemoryHarborRepository.instanceOf();
        this.harborDistanceRepository = InMemoryHarborDistanceRepository.instanceOf();
    }

    public IHarborDistanceReadable createHarborDistance(CreateHarborDistanceDTO createHarborDistanceDTO) {
        IHarborReadable firstHarbor = this.harborRepository.findById(createHarborDistanceDTO.getFirstHarborId());
        if (firstHarbor == null) {
            throw new HarborNotFound(String.valueOf(createHarborDistanceDTO.getFirstHarborId()));
        }

        IHarborReadable secondHarbor = this.harborRepository.findById(createHarborDistanceDTO.getSecondHarborId());
        if (secondHarbor == null) {
            throw new HarborNotFound(String.valueOf(createHarborDistanceDTO.getSecondHarborId()));
        }

        IHarborDistanceReadable harborDistanceAlreadyExists = this.harborDistanceRepository.findByHarbors(
                createHarborDistanceDTO.getFirstHarborId(),
                createHarborDistanceDTO.getSecondHarborId());
        if (harborDistanceAlreadyExists != null) {
            throw new HarborDistanceAlreadyExists(
                    String.valueOf(createHarborDistanceDTO.getFirstHarborId()),
                    String.valueOf(createHarborDistanceDTO.getSecondHarborId()));
        }

        return this.harborDistanceRepository.create(createHarborDistanceDTO.getValue(), firstHarbor, secondHarbor);
    }
}
