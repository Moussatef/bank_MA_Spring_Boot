package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.RejetDTO;
import com.bank.bankAM.dto.service.IMapClassWithDto;
import com.bank.bankAM.entity.Rejet;
import com.bank.bankAM.repository.RejetRepository;
import com.bank.bankAM.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    public RejetDTO addNewRejet(RejetDTO rejet, MultipartFile file) {
        Rejet rejet_convert = rejetMapper.convertToEntity(rejet,Rejet.class);
        System.out.println(rejet_convert);

        try{
            String filePath = this.saveFile(rejet.getClientCode(), file);
            System.out.println("************************** File Path : " + filePath);
            rejet_convert.setFile(filePath);
        } catch (Exception e){
            e.printStackTrace();
        }

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
            rejet.setIsWrongField(rejetDto.getIsWrongField());
            rejet.setErrorCode(rejetDto.getErrorCode());
            rejet.setErrorLabel(rejetDto.getErrorLabel());
            rejet.setIsRequestTaken(rejetDto.getIsRequestTaken());
            rejet.setActionDetail(rejetDto.getActionDetail());
            rejet.setTakenBy(rejetDto.getTakenBy());
            Rejet rejetUpdated = rejetRepository.save(rejet);
            return rejetMapper.convertToDto(rejetUpdated,RejetDTO.class);
        }
        return null;

    }


    public String saveFile(String clientCode, MultipartFile file) throws IOException {

        byte[] fileBytes = file.getBytes();


        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");

        String date = LocalDateTime.now().format(format);

        String fileName = file.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));

        String fileNewName = clientCode + "_" + date + fileExtension;

        Path path = Paths.get("C:\\Users\\otman\\Documents\\BAMCo\\" + fileNewName);

        Files.write(path, fileBytes);

        //String filePath = "C:\\" + path;

        return path.toString();
    }
}
