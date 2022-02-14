package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.RejetDTO;
import com.bank.bankAM.dto.model.RoleDTO;
import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.dto.service.IMapClassWithDto;
import com.bank.bankAM.entity.Rejet;
import com.bank.bankAM.entity.Role;
import com.bank.bankAM.entity.User;
import com.bank.bankAM.repository.RejetRepository;
import com.bank.bankAM.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class RejetService implements IRejetService {
    private final RejetRepository rejetRepository;
    private final UserRepository userRepository;
    @Autowired
    IMapClassWithDto<Rejet, RejetDTO> rejetMapper;

    @Override
    public List<RejetDTO> getAllRejet() {
        List<Rejet> rejetList =  rejetRepository.findAll();

        return rejetMapper.convertListToListDto(rejetList,RejetDTO.class);
    }

    @Override
    public RejetDTO getRejet(long id) {
        Rejet rejet = rejetRepository.findById(id).orElse(null);

        return rejetMapper.convertToDto(rejet,RejetDTO.class);
    }

    @Override
    public RejetDTO addNewRejet(RejetDTO rejet) {
        Rejet rejet_convert = rejetMapper.convertToEntity(rejet,Rejet.class);
        //UserDTO userDTO = rejetMapper.convertToDto() rejet_new.getTakenBy()
        return rejetMapper.convertToDto( rejetRepository.save(rejet_convert),RejetDTO.class);
    }

    @Override
    public void deleteRejet(Long rejetId) {
        boolean exists = rejetRepository.existsById(rejetId);
        if (!exists){
            throw new IllegalStateException("rejet ID : "+rejetId+" is not exists");
        }
        rejetRepository.deleteById(rejetId);

    }

    @Override
    public RejetDTO updateRejet(RejetDTO rejetDto) {
        Rejet rejet = rejetRepository.findById(rejetDto.getId()).orElse(null);
        if(rejet !=null) {
            rejet.setFlowType(rejetDto.getFlowType());
            rejet.setRejectNature(rejetDto.getRejectNature());
            rejet.setUserRegistrationNumber(rejetDto.getUserRegistrationNumber());
            rejet.setCliFileCode(rejetDto.getCliFileCode());
            rejet.setEntity(rejetDto.getEntity());
            rejet.setBu(rejetDto.getBu());
            rejet.setSu(rejetDto.getSu());
            rejet.setAgencyCode(rejetDto.getAgencyCode());
            rejet.setRegionalDelegation(rejetDto.getRegionalDelegation());
            rejet.setSubDelegationType(rejetDto.getSubDelegationType());
            rejet.setSubDelegationName(rejetDto.getSubDelegationName());
            rejet.setClientCode(rejetDto.getClientCode());
            rejet.setGravity(rejetDto.getGravity());
            rejet.setZoneCode(rejetDto.getZoneCode());
            rejet.setIsWrongField(rejetDto.isWrongField());
            rejet.setErrorCode(rejetDto.getErrorCode());
            rejet.setErrorLabel(rejetDto.getErrorLabel());
            rejet.setIsRequestTaken(rejetDto.isRequestTaken());
            rejet.setActionDetail(rejetDto.getActionDetail());
            rejet.setTakenBy(rejetDto.getTakenBy());
            Rejet rejetUpdated = rejetRepository.save(rejet);
            return rejetMapper.convertToDto(rejetUpdated,RejetDTO.class);
        }
        return null;

    }
}
