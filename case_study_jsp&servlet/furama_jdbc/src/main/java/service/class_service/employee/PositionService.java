package service.class_service.employee;

import model.employee.PositionEmployee;
import repository.class_repository.employee.PositionRepository;
import repository.interface_repository.employee.IPositionRepository;
import service.interface_service.employee.IPositionService;

import java.util.List;

public class PositionService implements IPositionService {
    IPositionRepository iPositionRepository = new PositionRepository();
    @Override
    public List<PositionEmployee> listPosition() {
        return iPositionRepository.listPosition();
    }
}
