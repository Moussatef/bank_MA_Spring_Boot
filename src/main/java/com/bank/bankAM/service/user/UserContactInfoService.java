package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.UserContactInfoDTO;
import com.bank.bankAM.dto.service.IMapClassWithDto;
import com.bank.bankAM.entity.UserContactInfo;
import com.bank.bankAM.repository.UserContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserContactInfoService implements  IUserContactInfoService{

    private final UserContactInfoRepository userContactInfoRepository;

    @Autowired
    IMapClassWithDto<UserContactInfo, UserContactInfoDTO> contactMapper;

    @Autowired
    public UserContactInfoService(UserContactInfoRepository userContactInfoRepository) {
        this.userContactInfoRepository = userContactInfoRepository;
    }


    @Override
    public List<UserContactInfoDTO> getAllUserContactInfo() {
        List<UserContactInfo> userContactInfo = userContactInfoRepository.findAll();

        return contactMapper.convertListToListDto(userContactInfo,UserContactInfoDTO.class);
    }

    @Override
    public UserContactInfoDTO getUserContactInfo(long id) {
        UserContactInfo userContactInfo = userContactInfoRepository.findById(id).orElse(null);
        return contactMapper.convertToDto(userContactInfo,UserContactInfoDTO.class);
    }

    @Override
    public UserContactInfoDTO addNewUserContactInfo(UserContactInfoDTO user) {
        UserContactInfo userContactInfo = contactMapper.convertToEntity(user,UserContactInfo.class);

        UserContactInfo newUserContact = userContactInfoRepository.save(userContactInfo);
        return contactMapper.convertToDto(newUserContact,UserContactInfoDTO.class);
    }

    @Override
    public void deleteUserContactInfo(Long userId) {
        boolean exists = userContactInfoRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("User Contact ID : "+userId+" is not exists");
        }
        userContactInfoRepository.deleteById(userId);

    }

    @Override
    public UserContactInfoDTO updateUserContactInfo(long id, UserContactInfoDTO userContactInfoDTO) {
        return null;
    }
}
