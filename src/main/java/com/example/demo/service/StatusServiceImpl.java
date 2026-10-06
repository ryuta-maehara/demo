package com.example.demo.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Status;
import com.example.demo.repository.StatusRepository;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    /** {@inheritDoc} */
    @Override
    @Transactional(readOnly = true)
    public List<Status> findAll() {
        List<Status> list = statusRepository.selectAll();
        return list;
    }

    /** {@inheritDoc} */
    @Override
    @Transactional(readOnly = true)
    public Status findByCode(String statusCode) {
        Status status = statusRepository.selectByCode(statusCode);
        return status;
    }

}
