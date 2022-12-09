package com.md4_casestudy_furame.service.impl.employee;

import com.md4_casestudy_furame.model.employee.Position;
import com.md4_casestudy_furame.repository.Employee.IPositionRepository;
import com.md4_casestudy_furame.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(int id) {
        return positionRepository.findById(id);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void remove(int id) {
        positionRepository.deleteById(id);
    }
}
