package com.md4_casestudy_furame.service.impl.employee;

import com.md4_casestudy_furame.model.employee.Division;
import com.md4_casestudy_furame.repository.Employee.IDivisionRepository;
import com.md4_casestudy_furame.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Optional<Division> findById(int id) {
        return divisionRepository.findById(id);
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void remove(int id) {
        divisionRepository.deleteById(id);
    }
}
