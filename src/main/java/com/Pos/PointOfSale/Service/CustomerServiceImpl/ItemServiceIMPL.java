package com.Pos.PointOfSale.Service.CustomerServiceImpl;

import com.Pos.PointOfSale.Entity.ItemEntity;
import com.Pos.PointOfSale.Service.ItemService;
import com.Pos.PointOfSale.dto.ItemDto;
import com.Pos.PointOfSale.dto.request.ItemSaveRequestDto;
import com.Pos.PointOfSale.exception.EntryDuplicateException;
import com.Pos.PointOfSale.repository.ItemRepo;
import com.Pos.PointOfSale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;


    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addItem(ItemSaveRequestDto itemSaveRequestDto) {
        ItemEntity item = itemMapper.RequesDtoToEntity(itemSaveRequestDto);

        item.setActiveState(true);
        if (!itemRepo.existsById(item.getItemId())) {

            return itemRepo.save(item).getItemName();
        } else {
            throw new EntryDuplicateException("Allredy duplicate entry");
        }


    }

    @Override
    public List<ItemDto> getAllItems() {
        List<ItemEntity> getItems = itemRepo.findAll();
        List<ItemDto> itemDtoList = new ArrayList<>();

        List<ItemDto> itemDtos = modelMapper.map(getItems, new TypeToken<List<ItemDto>>() {
        }.getType());


        return itemDtos;

    }

    @Override
    public List<ItemDto> getAllItemsByStateType(boolean status) {
        List<ItemEntity> getItems = itemRepo.findAllByActiveStateEquals(status);
        List<ItemDto> itemDtos = modelMapper.map(getItems, new TypeToken<List<ItemDto>>() {
        }.getType());


        return itemDtos;
    }
}
